package component;

//Starting
import ComposantGlassPanePopup.GlassPanePopup;
import ForgetPassword.EmailForgetPassword;
import ForgetPassword.testeIt;
import model.ModelUser;
import swing.Button;
import swing.MyPasswordField;
import swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.ModelLogin;
import net.miginfocom.swing.MigLayout;
//Ending

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private MyTextField txtUser;
    private MyTextField txtEmail;
    private MyPasswordField txtPass;

    /**
     * @return the dataLogin
     */
    public ModelLogin getDataLogin() {
        return dataLogin;
    }

    public ModelUser getUser() {
        return user;
    }

    private ModelUser user;
    private ModelLogin dataLogin;
//LoadLogin loginPanel = new LoadLogin();
    EmailForgetPassword password = new EmailForgetPassword();
    testeIt t = new testeIt();

    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
//        GlassPanePopup.install(null);
    }

    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Créer un compte");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(166, 114, 166));

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        var icon = new ImageIcon(getClass().getResource("/icon/logoLoginRegister.png")); // Remplacez "create_account.png" par le nom de votre fichier d'icône
        label.setIcon(icon);
        register.add(label);
        register.add(label);

        txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Nom");
        register.add(txtUser, "w 60%");
        txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/email.png")));
        txtEmail.setHint("Adresse électronique");
        register.add(txtEmail, "w 60%");
        txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/password.png")));
        txtPass.setHint("Mot de passe");
        register.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(166, 114, 166));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("S'INSCRIRE");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                user = new ModelUser(0, userName, email, password);
            }
        });
    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Se connecter");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(166, 114, 166));

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        var icon = new ImageIcon(getClass().getResource("/icon/logoLoginRegister.png")); // Remplacez "create_account.png" par le nom de votre fichier d'icône
        label.setIcon(icon);
        login.add(label);
        login.add(label);

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/email.png")));
        txtEmail.setHint("Adresse électronique");
        login.add(txtEmail, "w 60%");
//        String A1 = txtEmail.getText();
//        System.out.println(A1);
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/password.png")));
        txtPass.setHint("Mot de passe");
        login.add(txtPass, "w 60%");
//        String A2 = txtPass.getHint();
//        System.out.println(A2);
        JButton cmdForget = new JButton("Vous avez oublié votre mot de passe ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        cmdForget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                JOptionPane.showMessageDialog(null, "you have been clicked in button forget password");
                System.out.println("you have been clicked in button forget password");
//                GlassPanePopup.showPopup(t);
                password.setVisible(true); // Afficher la fenêtre JFrame
//                JDialog dialog = new JDialog(password, "Popup", true); // créer un nouveau JDialog avec titre "Popup" et parent la JFrame emailforgetpassword
//        dialog.setSize(200, 100); // Personnaliser la taille du JDialog
//        dialog.setLocationRelativeTo(password); // Centrer le JDialog par rapport à la JFrame emailforgetpassword
//        dialog.setVisible(true); // afficher le JDialog
            }
        });

        Button cmd = new Button();
        cmd.setBackground(new Color(166, 114, 166));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("SE CONNECTER");
        login.add(cmd, "w 40%, h 40");

        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                dataLogin = new ModelLogin(email, password);
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    public void clearTextFields() {
        txtUser.setText("");
        txtEmail.setText("");
        txtPass.setText("");
    }

    public boolean validation() {

        boolean isValid = true; // Par défaut, supposons que tout est valide
//        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        if (txtUser.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Coucou 1");
            isValid = false; // Si la validation échoue, définissez isValid sur false
        } else if (txtEmail.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Coucou 2");
            isValid = false;
        } else if (txtPass.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Coucou 3");
            isValid = false;
//        }else if(!txtEmail.getText().matches(emailPattern)){
//            JOptionPane.showMessageDialog(this, "Coucou 4");
        }

        return isValid; // Renvoyer l'état de la validation
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
