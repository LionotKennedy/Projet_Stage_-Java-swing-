package FenetreModale;

//Starting
import Form.Form_Dashboard;
import ShowMessage.MessageModification;
import ShowMessage.MessageValidationChamps;
import connexionDB.DatabaseConnection;
import static connexionDB.DatabaseConnection.connex;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public final class UpdateUser extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    String R4;
    String R7;

    String user1 = "Mot de passe incorrect.";
    String user2 = "Veuillez saisir une adresse e-mail valide.";
    String user3 = "Veuillez remplir le champs nouvelle mot de passe.";
    String user4 = "L'adresse e-mail est déjà existe.Veuillez saisir une autre.";

    public UpdateUser() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        setBackground(new Color(0, 0, 0, 0));
        RecuperationDonne();
        instant = false;

        userName.setOpaque(false);
        EmailAdr.setOpaque(false);
        EnciennePass.setOpaque(false);
        NouvellePass.setOpaque(false);

        IDUser.setVisible(false);
        codeVerification.setVisible(false);
        status.setVisible(false);
        PassWordCache.setVisible(false);
        Email2.setVisible(false);
    }

    public void RecuperationDonne() throws SQLException {
        Form_Dashboard information = new Form_Dashboard();
//        MainSystem information = new MainSystem();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM users WHERE UserID ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String R1 = resul.getString("UserID");
                IDUser.setText(R1);
                System.out.println(R1);

                String R2 = resul.getString("UserName");
                userName.setText(R2);
                System.out.println(R2);

                String R3 = resul.getString("Email");
                EmailAdr.setText(R3);
                System.out.println(R3);

                R4 = resul.getString("Password");
                PassWordCache.setText(R4);
                System.out.println(R4);

                String R5 = resul.getString("VerifyCode");
                codeVerification.setText(R5);
                System.out.println(R5);

                String R6 = resul.getString("Status");
                status.setText(R6);
                System.out.println(R6);

                R7 = resul.getString("Email");
                Email2.setText(R7);
                System.out.println("Faha roa " + R7);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }

    public String getUser3() {
        return user3;
    }

    public String getUser4() {
        return user4;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        userName = new swing_Dialog.TextField();
        EnciennePass = new swing_Dialog.PasswordField();
        NouvellePass = new swing_Dialog.PasswordField();
        EmailAdr = new swing_Dialog.TextField();
        BtnUpdateClient = new swing.ButtonOutLine();
        BtnUpAnnileClient = new swing.ButtonOutLine();
        IDUser = new javax.swing.JTextField();
        PassWordCache = new javax.swing.JTextField();
        codeVerification = new javax.swing.JTextField();
        Email2 = new javax.swing.JTextField();
        status = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        userName.setLabelText("Nom d'utilisateur");
        userName.setLineColor(new java.awt.Color(200, 39, 228));

        EnciennePass.setLabelText("Votre mot de passe");
        EnciennePass.setLineColor(new java.awt.Color(200, 39, 228));

        NouvellePass.setLabelText("Votre nouvelle mot de passe");
        NouvellePass.setLineColor(new java.awt.Color(200, 39, 228));

        EmailAdr.setLabelText("L'adresse Email");
        EmailAdr.setLineColor(new java.awt.Color(200, 39, 228));

        BtnUpdateClient.setBackground(new java.awt.Color(200, 39, 228));
        BtnUpdateClient.setForeground(new java.awt.Color(200, 39, 228));
        BtnUpdateClient.setText("Modifier");
        BtnUpdateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateClientActionPerformed(evt);
            }
        });

        BtnUpAnnileClient.setBackground(new java.awt.Color(220, 27, 27));
        BtnUpAnnileClient.setForeground(new java.awt.Color(220, 27, 27));
        BtnUpAnnileClient.setText("Annuler");
        BtnUpAnnileClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpAnnileClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(IDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PassWordCache, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeVerification, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Email2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnUpdateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnUpAnnileClient, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(EnciennePass, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NouvellePass, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailAdr, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EmailAdr, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EnciennePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NouvellePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PassWordCache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeVerification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUpdateClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUpAnnileClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        getContentPane().add(panelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }

    private void BtnUpdateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateClientActionPerformed

        MessageModification modification = new MessageModification();
        MessageValidationChamps validation = new MessageValidationChamps();
        String A1 = IDUser.getText();
        String A2 = userName.getText();
        String A3 = EmailAdr.getText();
        String A4 = EnciennePass.getText();
        String A5 = NouvellePass.getText();
        String A6 = codeVerification.getText();
        String A7 = status.getText();

        System.out.println(A1);
        System.out.println(A2);
        System.out.println(A3);
        System.out.println(A4);
        System.out.println(A5);
        System.out.println(A6);
        System.out.println(A7);

        if (!A4.equals(R4)) {
            try {
                validation.val1();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            //        Starting validation
            A2 = userName.getText();
            A5 = NouvellePass.getText();

            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";

            if (A3.matches(emailRegex)) {
                A3 = EmailAdr.getText();
                System.out.println("L'adresse email est valide !");
            } else {
                // La valeur de A6 ne correspond pas à une adresse email valide
                // Tu peux effectuer les actions appropriées ici
                System.out.println("L'adresse email n'est pas valide !");
            }

            Form_Dashboard information = null;
            try {
                information = new Form_Dashboard();
            } catch (SQLException ex) {
                Logger.getLogger(UpdateClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            information.Recuperation();

            String recuprer = information.GetTableResult();
            if (!EmailAdr.getText().matches(A3)) {
                try {
                    validation.val2();
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (NouvellePass.getText().equals("")) {
                try {
                    validation.val3();
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (R7 == null ? A3 != null : !R7.equals(A3)) {
                    System.out.println("coucou Lionot");
                    try {
                        String requete = "SELECT * FROM users WHERE Email = ?";
                        prepare = connex.prepareStatement(requete);
                        prepare.setString(1, A3);
                        resul = prepare.executeQuery();

                        if (resul.next()) {
                            validation.val4();
                            return;
                        } else {
                            String request = "UPDATE users SET UserID= '" + A1 + "', UserName='" + A2 + "', Email='" + A3 + "', Password='" + A5 + "', VerifyCode='" + A6 + "', Status='" + A7 + "' WHERE UserID='" + recuprer + "'";
                            prepare = con.prepareStatement(request);
                            prepare.execute();
                            modification.setVisible(true);

                            Animator animator = new Animator(4000); // Durée de l'animation (500ms)
                            animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
                            animator.addTarget(new TimingTargetAdapter() {
                                @Override
                                public void timingEvent(float fraction) {
                                    // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                                    // en fonction de l'avancement de l'animation, par exemple :
                                    modification.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
                                }

                                @Override
                                public void end() {
                                    // Fermer la fenêtre après la fin de l'animation
                                    modification.dispose();
                                }
                            });

                            animator.start();
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (R7 == null ? A3 == null : R7.equals(A3)) {
                    System.out.println("Bonjour toi Lionot Bogosy hana spin cv sad hanohana anao andafy any");

                    try {
                        String request = "UPDATE users SET UserID= '" + A1 + "', UserName='" + A2 + "', Email='" + A3 + "', Password='" + A5 + "', VerifyCode='" + A6 + "', Status='" + A7 + "' WHERE UserID='" + recuprer + "'";
                        prepare = con.prepareStatement(request);
                        prepare.execute();
                        modification.setVisible(true);

                        Animator animator = new Animator(4000); // Durée de l'animation (500ms)
                        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
                        animator.addTarget(new TimingTargetAdapter() {
                            @Override
                            public void timingEvent(float fraction) {
                                // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                                // en fonction de l'avancement de l'animation, par exemple :
                                modification.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
                            }

                            @Override
                            public void end() {
                                // Fermer la fenêtre après la fin de l'animation
                                modification.dispose();
                            }
                        });

                        animator.start();
                    } catch (SQLException ex) {
                        Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
        instant = true;
        this.dispose();
    }//GEN-LAST:event_BtnUpdateClientActionPerformed

    private void BtnUpAnnileClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpAnnileClientActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_BtnUpAnnileClientActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UpdateUser().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonOutLine BtnUpAnnileClient;
    private swing.ButtonOutLine BtnUpdateClient;
    private javax.swing.JTextField Email2;
    private swing_Dialog.TextField EmailAdr;
    private swing_Dialog.PasswordField EnciennePass;
    private javax.swing.JTextField IDUser;
    private swing_Dialog.PasswordField NouvellePass;
    private javax.swing.JTextField PassWordCache;
    private javax.swing.JTextField codeVerification;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    private javax.swing.JTextField status;
    private swing_Dialog.TextField userName;
    // End of variables declaration//GEN-END:variables
}
