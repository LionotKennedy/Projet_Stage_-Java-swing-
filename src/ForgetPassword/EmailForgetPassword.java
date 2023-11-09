package ForgetPassword;

//Starting
import ComposantGlassPanePopup.GlassPanePopup;
import ShowMessage.ChargementLogin;
import ShowMessage.MessageConnexion;
import ShowMessage.MessageValidationChamps;
import component.LoadLogin;
import connexionDB.DatabaseConnection;
import static connexionDB.DatabaseConnection.connex;
import java.awt.Color;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class EmailForgetPassword extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    DecimalFormat randomCode = new DecimalFormat("000000");
//    public static String code = "123456";
    public static String code;
    MessageConnexion NoConn = new MessageConnexion();
    MessageValidationChamps validation = new MessageValidationChamps();
    String Email1 = "L'adresse e-mail incorrects.";
    ChargementLogin charger = new ChargementLogin();
    LoadLogin loginPanel = new LoadLogin();

    public EmailForgetPassword() {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        setBackground(new Color(0, 0, 0, 0));
    }

    public String getEmail1() {
        return Email1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow4 = new ComposantPanelShadow.PanelShadow();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EmailForget = new swing.MyTextField();
        btnOK = new swing.ButtonOutLine();
        btnAnnuler = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Véuillez saisir votre email que vous avez creer votre compte");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Votre Adresse Email");

        EmailForget.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnOK.setBackground(new java.awt.Color(0, 204, 0));
        btnOK.setForeground(new java.awt.Color(0, 204, 0));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnAnnuler.setBackground(new java.awt.Color(255, 0, 0));
        btnAnnuler.setForeground(new java.awt.Color(255, 0, 0));
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(EmailForget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(EmailForget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        this.dispose();
        EmailForget.setText("");
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try {
            String Email = EmailForget.getText();
            System.out.println(Email);

            String request = "SELECT * FROM users WHERE Email = '" + Email + "'";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                System.out.println("Oui, l'adresse e-mail existe dans la base de données.");
                // Afficher votre message ou effectuer d'autres actions si l'adresse e-mail existe
                try {
                    Random rand = new Random();
                    code = randomCode.format(rand.nextInt(999999));
                    // String host = "smtp.gmail.com";
                    String user = "jwicheer14344@gmail.com";
                    String pass = "rxkc vkvk nzzg qhya";
                    String subject = "Code de réinitialisation";
                    String message = "Votre code de réinitialisation est " + code;
                    boolean sessionDebug = false;

                    Properties prop = new Properties();
                    prop.put("mail.smtp.host", "smtp.gmail.com");
                    prop.put("mail.smtp.port", "465"); // Port SSL pour Gmail
                    prop.put("mail.smtp.auth", "true");
                    prop.put("mail.smtp.starttls.enable", "true"); // Activer STARTTLS
                    prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

                    Session mailSession = Session.getInstance(prop,
                            new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user, pass);
                        }
                    });

                    if (!isInternetAvailable()) {
                        NoConn.setVisible(true);
                        Animator animator = new Animator(4000); // Durée de l'animation (500ms)
                        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
                        animator.addTarget(new TimingTargetAdapter() {
                            @Override
                            public void timingEvent(float fraction) {
                                // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                                // en fonction de l'avancement de l'animation, par exemple :
                                NoConn.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
                            }

                            @Override
                            public void end() {
                                // Fermer la fenêtre après la fin de l'animation
                                NoConn.dispose();
                            }
                        });

                        animator.start();
                        return;
                    }
                    if (code != null) {
                        mailSession.setDebug(sessionDebug);
                        Message msg = new MimeMessage(mailSession);
                        msg.setFrom(new InternetAddress(user));
                        InternetAddress[] address = {new InternetAddress(Email)};
                        msg.setRecipients(Message.RecipientType.TO, address);
                        msg.setSubject(subject);
                        msg.setText(message);

                        Transport.send(msg); // Utilisez Transport.send() pour envoyer le message
                        System.out.println(code);
                        GlassPanePopup.showPopup(loginPanel);

                        Animator animator = new Animator(4000); // Durée de l'animation (500ms)
                        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f));
                        animator.addTarget(new TimingTargetAdapter() {
                            public void timingevent(float fraction) {
                                // Vous pouvez mettre à jour les propriétés de votre fenêtre ici
                                setOpacity(1 - fraction);
                                repaint(); // Assurez-vous de redessiner le JPanel pour refléter les changements
                            }

                            @Override
                            public void end() {
                                // Fermer le panneau après la fin de l'animation
                                loginPanel.setVisible(false);
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginPanel);

                                // Si la fenêtre est une instance de JFrame, fermez-la
                                if (frame instanceof JFrame) {
                                    fermer();
                                    EmailForget.setText("");
                                    new CodeVerify(code, Email).setVisible(true);
//                            GlassPanePopup.closePopupLast();
                                }
                            }
                        });
                        animator.start();

                    } else {
                        String mess = "Le code est nul.";
                        JOptionPane.showMessageDialog(rootPane, mess);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, e.getMessage());
                }
//                System.out.println(code);
//                GlassPanePopup.showPopup(loginPanel);
//
//                Animator animator = new Animator(4000); // Durée de l'animation (500ms)
//                animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f));
//                animator.addTarget(new TimingTargetAdapter() {
//                    public void timingevent(float fraction) {
//                        // Vous pouvez mettre à jour les propriétés de votre fenêtre ici
//                        setOpacity(1 - fraction);
//                        repaint(); // Assurez-vous de redessiner le JPanel pour refléter les changements
//                    }
//
//                    @Override
//                    public void end() {
//                        // Fermer le panneau après la fin de l'animation
//                        loginPanel.setVisible(false);
////                        this.dispose();
//                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginPanel);
//
//                        // Si la fenêtre est une instance de JFrame, fermez-la
//                        if (frame instanceof JFrame) {
//                            fermer();
//                            EmailForget.setText("");
//                            new CodeVerify(code, Email).setVisible(true);
////                            GlassPanePopup.closePopupLast();
//                        }
//                    }
//                });
//                animator.start();

//                EmailForget.setText("");
//                new CodeVerify(code, Email).setVisible(true);
            } else {
                validation.valEmail1();
                // Afficher votre message ou effectuer d'autres actions si l'adresse e-mail n'existe pas
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EmailForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOKActionPerformed
    private void fermer() {
        this.dispose();
    }

    private boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("www.google.com");
            return !ipAddr.equals("");
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            new EmailForgetPassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyTextField EmailForget;
    private swing.ButtonOutLine btnAnnuler;
    private swing.ButtonOutLine btnOK;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private ComposantPanelShadow.PanelShadow panelShadow4;
    // End of variables declaration//GEN-END:variables
}
