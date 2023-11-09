package ForgetPassword;

//Starting
import ComposantGlassPanePopup.GlassPanePopup;
import ShowMessage.MessageErreur;
import ShowMessage.MessageModification;
import ShowMessage.MessageValidationChamps;
import ShowMessage.UpdatePassW;
import component.LoadLogin;
import component.Message;
import connexionDB.DatabaseConnection;
import static connexionDB.DatabaseConnection.connex;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public final class UpdatePassword extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    private String Email;
    public static String R1, R2, R3, R4, R5, R6;

    String mes1 = "Veuillez remplir le champ mot de passe.";
    String mes2 = "Veuillez remplir le champ comfirmation du mot de passe.";
    String mes3 = "Erruer de validation.";
LoadLogin loginPanel = new LoadLogin();
UpdatePassW modification = new UpdatePassW();
    public UpdatePassword(String Email) {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        setBackground(new Color(0, 0, 0, 0));
        this.Email = Email;
        requeteAute();
    }

    public void requeteAute() {
        try {
            String request = "SELECT UserID,UserName,Email,Password,VerifyCode,Status FROM users WHERE Email = '" + Email + "'";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                R1 = resul.getString("UserID");
                System.out.println(R1);
                R2 = resul.getString("UserName");
                System.out.println(R2);
                R3 = resul.getString("Email");
                System.out.println(R3);
                R4 = resul.getString("Password");
                System.out.println(R4);
                R5 = resul.getString("VerifyCode");
                System.out.println(R5);
                R6 = resul.getString("Status");
                System.out.println(R6);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getVal1() {
        return mes1;
    }

    public String getVal2() {
        return mes2;
    }

    public String getVal3() {
        return mes3;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound3 = new swing.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmdOK2 = new swing.ButtonOutLine();
        cmdCancel2 = new swing.ButtonOutLine();
        jLabel7 = new javax.swing.JLabel();
        ComfirmationPassWord = new swing.MyPasswordField();
        newPassWord = new swing.MyPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nouvelle Mot de passe");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mot de passe");

        cmdOK2.setBackground(new java.awt.Color(4, 131, 42));
        cmdOK2.setForeground(new java.awt.Color(4, 131, 42));
        cmdOK2.setText("OK");
        cmdOK2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOK2ActionPerformed(evt);
            }
        });

        cmdCancel2.setBackground(new java.awt.Color(255, 18, 23));
        cmdCancel2.setForeground(new java.awt.Color(255, 18, 23));
        cmdCancel2.setText("Annuler");
        cmdCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancel2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Comfirmation du mot de passe");

        ComfirmationPassWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newPassWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdOK2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassWord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComfirmationPassWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComfirmationPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdOK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void cmdOK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOK2ActionPerformed
//        JOptionPane.showMessageDialog(null,Email);
        MessageValidationChamps validation = new MessageValidationChamps();
        MessageErreur erreur = new MessageErreur();
        String nouveau = newPassWord.getText();
        String comfirmation = ComfirmationPassWord.getText();
        System.out.println(nouveau);
        System.out.println(comfirmation);

        if (newPassWord.getText().equals("")) {
            try {
                validation.valPass1();
            } catch (SQLException ex) {
                Logger.getLogger(UpdatePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ComfirmationPassWord.getText().equals("")) {
            try {
                validation.valPass2();
            } catch (SQLException ex) {
                Logger.getLogger(UpdatePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (nouveau == null ? comfirmation == null : nouveau.equals(comfirmation)) {
            System.out.println(Email + " voila ton Email");

            String request = "UPDATE users SET UserID='" + R1 + "', UserName='" + R2 + "',Email='" + R3 + "',Password ='" + nouveau + "',VerifyCode='" + R5 + "',Status ='" + R6 + "' WHERE UserID ='" + R1 + "' ";
            try {
                prepare = con.prepareStatement(request);
                prepare.execute();
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
                            fermer();
                            modification.setVisible(true);
                            GlassPanePopup.closePopupLast();
                            
                        }
                    }
                });
                animator.start();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            try {
                erreur.valPass3();
            } catch (SQLException ex) {
                Logger.getLogger(UpdatePassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdOK2ActionPerformed

    private void cmdCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancel2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCancel2ActionPerformed
    private void fermer() {
        this.dispose();
    }

    /**
     * @param Email
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String Email) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            new UpdatePassword(Email).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyPasswordField ComfirmationPassWord;
    private swing.ButtonOutLine cmdCancel2;
    private swing.ButtonOutLine cmdOK2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private swing.MyPasswordField newPassWord;
    private swing.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
