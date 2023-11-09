package service;

//Starting
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;
import model.ModelLogin;
import model.ModelUser;
//Ending

public class ServiceUser {

    public static Connection con = null;
//    public static ResultSet resul = null;
//    public static PreparedStatement prepare = null;
    public static String code;
    public static AtomicInteger userid = new AtomicInteger();
    int userIDs;

    public ServiceUser() {
        con = connexionDB.DatabaseConnection.connex;
    }

//    concernant login
    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        try (PreparedStatement p = con.prepareStatement("SELECT UserID, UserName, Email FROM users WHERE Email COLLATE \"C\" = ? AND Password COLLATE \"C\" = ? AND Status = 'Verified' LIMIT 1",
                PreparedStatement.RETURN_GENERATED_KEYS,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {
            p.setString(1, login.getEmail());
            p.setString(2, login.getPassword());
            try (ResultSet r = p.executeQuery()) {
                if (r.first()) {
                    int userID = r.getInt(1);
                    String userName = r.getString(2);
                    String email = r.getString(3);
                    data = new ModelUser(userID, userName, email, "");
                }
            }
        }
        return data;
    }

//    ending
    public void insertUser(ModelUser user) throws SQLException {
        code = generateVerifyCode();
        ServiceMail servicemail = new ServiceMail();

        // Vérifier si le code généré est null
        if (code != null) {
            servicemail.sendMain(user.getEmail(), code);

            // Afficher la valeur de code dans un JOptionPane
//            JOptionPane.showMessageDialog(null, "Le code généré est : " + code);

            try (PreparedStatement prepare = con.prepareStatement("insert into users (username, email, password, verifycode) values (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS)) {

                prepare.setString(1, user.getUserName());
                prepare.setString(2, user.getEmail());
                prepare.setString(3, user.getPassword());
                prepare.setString(4, code);

                if (prepare.executeUpdate() > 0) {
                    try (ResultSet resul = prepare.getGeneratedKeys()) {
                        if (resul.next()) {
                            int userId = resul.getInt(1);
                            System.out.println("userid=" + userId);
                            userid.set(userId); // mettre à jour l'AtomicInteger
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Le code est nul.");
        }
    }

    public int insertUserAndGetUserID(ModelUser user) throws SQLException {
        AtomicInteger userID = new AtomicInteger();
        insertUser(user);
        int generatedUserID = userID.get();

        // Afficher la valeur UserID dans une JOptionPane
//        JOptionPane.showMessageDialog(null, "Le UserID généré est : " + generatedUserID);

        return generatedUserID;
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        code = df.format(ran.nextInt(1000000)); // Affectez la valeur à "code"
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        System.out.println("Code généré : " + code); // Ajoutez cette ligne
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        try (PreparedStatement prepare = con.prepareStatement("select UserID from users where VerifyCode=? ",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {

            prepare.setString(1, code);

            try (ResultSet resul = prepare.executeQuery()) {
                if (resul.first()) {
                    duplicate = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return duplicate;
    }

    public boolean checkDuplicateUser(String user) throws SQLException {
        boolean duplicate = false;
        try (PreparedStatement prepare = con.prepareStatement("select UserID from users where UserName=? and Status = 'Verified'",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {

            prepare.setString(1, user);

            try (ResultSet resul = prepare.executeQuery()) {
                if (resul.first()) {
                    duplicate = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return duplicate;
    }

    public boolean checkDuplicateEmail(String user) throws SQLException {
        boolean duplicate = false;
        try (PreparedStatement prepare = con.prepareStatement("select UserID from users where Email=? and Status ='Verified' limit 1",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {

            prepare.setString(1, user);

            try (ResultSet resul = prepare.executeQuery()) {
                if (resul.first()) {
                    duplicate = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return duplicate;
    }

    private void showMessage(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public String getVerifyCode(String userName) throws SQLException {
        String verifyCode = null;
        try (PreparedStatement prepare = con.prepareStatement("SELECT VerifyCode FROM users WHERE UserName = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {
            prepare.setString(1, userName);
            try (ResultSet resul = prepare.executeQuery()) {
                if (resul.first()) {
                    verifyCode = resul.getString("VerifyCode");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return verifyCode;
    }

    public boolean verifyCodeWithUser(String code) throws SQLException {
    boolean verify = false;
    System.out.println("coco bro");

    // Afficher les valeurs de userid et code
//    JOptionPane.showMessageDialog(null, "userid: " + userid.get() + "\ncode: " + code);

    try (PreparedStatement prepare = con.prepareStatement("select VerifyCode from users where UserID=?",
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

        prepare.setInt(1, userid.get());

        try (ResultSet resul = prepare.executeQuery()) {
            System.out.println("query executed");
            if (resul.first()) {
                String verifyCodeFromDb = resul.getString("VerifyCode");
                System.out.println("verifycode dans la base de données : " + verifyCodeFromDb);
                // Comparer le code de la base de données avec le code fourni
                if (verifyCodeFromDb.equals(code)) {
                    verify = true;
                    // Appeler doneVerify après avoir vérifié le code
                    doneVerify(userid.get());
                } else {
                    System.out.println("les codes ne correspondent pas.");
                }
            } else {
                System.out.println("aucun utilisateur avec cet id trouvé.");
            }
        }
    } catch (SQLException e) {
        // Affichez l'erreur à l'utilisateur
        showMessage("Erreur lors de l'accès à la base de données : " + e.getMessage());
        // Affichez l'erreur complète dans la console
        System.out.println("coco tsy bro (exception)");
    }

    return verify;
}


    public void doneVerify(int userid) throws SQLException {
        try (PreparedStatement prepare = con.prepareStatement("update users set VerifyCode='', Status = 'Verified' where UserID=?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) { // Supprimez "limit 1" ici

            prepare.setInt(1, userid);
            prepare.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
