package FenetreModale;

//Starting
import ShowMessage.MessageSuccess;
import ShowMessage.MessageValidationChamps;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class AddClient extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    String client1 = "Veuillez saisir un numéro de téléphone valide (chiffres uniquement).";

    String client2 = "Veuillez saisir un numéro de valide (chiffres uniquement).";

    String client3 = "Veuillez remplir le champ nom.";

    String client4 = "Veuillez remplir le champ prenom.";

    String client5 = "Veuillez remplir le champ adresse.";

    String client6 = "Veuillez saisir une adresse e-mail valide.";

    String client7 = "Le numéro de client existe déjà. Veuillez saisir un autre numéro.";

    String client8 = "Ce champ ne doit pas commencer par les symboles '+', '-', ou ','.";

    public AddClient() {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        setBackground(new Color(0, 0, 0, 0));
        instant = false;
        
        AdrClient.setOpaque(false);
        NomClient.setOpaque(false);
        EmailClient.setOpaque(false);
        NumClient.setOpaque(false);
        NumPhone.setOpaque(false);
        PremClient.setOpaque(false);
    }

    public String getClient1() {
        return client1;
    }

    public String getClient2() {
        return client2;
    }

    public String getClient3() {
        return client3;
    }

    public String getClient4() {
        return client4;
    }

    public String getClient5() {
        return client5;
    }

    public String getClient6() {
        return client6;
    }

    public String getClient7() {
        return client7;
    }

    public String getClient8() {
        return client8;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        NumClient = new swing_Dialog.TextField();
        NomClient = new swing_Dialog.TextField();
        PremClient = new swing_Dialog.TextField();
        AdrClient = new swing_Dialog.TextField();
        NumPhone = new swing_Dialog.TextField();
        EmailClient = new swing_Dialog.TextField();
        BtnAnnileClient = new swing.ButtonOutLine();
        BtnAjouterClient = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumClient.setLabelText("Numéro Client");
        NumClient.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, 318, -1));

        NomClient.setLabelText("Nom du Client");
        NomClient.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NomClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 94, 318, -1));

        PremClient.setLabelText("Prénom du Client");
        PremClient.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(PremClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 159, 318, -1));

        AdrClient.setLabelText("Adresse du Client");
        AdrClient.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(AdrClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 224, 318, -1));

        NumPhone.setFocusTraversalPolicyProvider(true);
        NumPhone.setLabelText("Numéro de Téléphone");
        NumPhone.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 289, 318, -1));

        EmailClient.setLabelText("Email Cleint");
        EmailClient.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(EmailClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 360, 318, -1));

        BtnAnnileClient.setBackground(new java.awt.Color(220, 27, 27));
        BtnAnnileClient.setForeground(new java.awt.Color(220, 27, 27));
        BtnAnnileClient.setText("Annuler");
        BtnAnnileClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnileClientActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAnnileClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 95, 32));

        BtnAjouterClient.setBackground(new java.awt.Color(200, 39, 228));
        BtnAjouterClient.setForeground(new java.awt.Color(200, 39, 228));
        BtnAjouterClient.setText("Ajouter");
        BtnAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouterClientActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAjouterClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 97, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }

    private void BtnAnnileClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnnileClientActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_BtnAnnileClientActionPerformed

    private void BtnAjouterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouterClientActionPerformed
        MessageSuccess message = new MessageSuccess();
        MessageValidationChamps validation = new MessageValidationChamps();
        System.out.println(NumClient.getText());
        System.out.println(NomClient.getText());
        System.out.println(PremClient.getText());
        System.out.println(AdrClient.getText());
        System.out.println(NumPhone.getText());
        System.out.println(EmailClient.getText());
//        Starting validation
        String numClientText = NumClient.getText();
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        String numPhoneText = NumPhone.getText();
//        Ending

        try {
            int numPhone = Integer.parseInt(numPhoneText);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
            validation.valid1();
            return;
        }

        try {
            int numClient = Integer.parseInt(numClientText);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
            validation.valid2();
            return;
        }

        if (NumClient.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir le champs numero");
        } else if (NomClient.getText().equals("")) {
            validation.valid3();
        } else if (PremClient.getText().equals("")) {
            validation.valid4();
        } else if (AdrClient.getText().equals("")) {
            validation.valid5();
        } else if (NumPhone.getText().equals("")) {
            validation.valid1();
        } else if (EmailClient.getText().equals("")) {
            validation.valid6();
        } else if (NumClient.getText().startsWith(".") || NumClient.getText().startsWith("+") || NumClient.getText().startsWith("-") || NumClient.getText().startsWith(",") || NumClient.getText().startsWith("/") || NumClient.getText().startsWith(";")) {
            validation.valid8();
        } else if (NomClient.getText().startsWith(".") || NomClient.getText().startsWith("+") || NomClient.getText().startsWith("-") || NomClient.getText().startsWith(",") || NomClient.getText().startsWith("/") || NomClient.getText().startsWith(";")) {
            validation.valid8();
        } else if (PremClient.getText().startsWith(".") || PremClient.getText().startsWith("+") || PremClient.getText().startsWith("-") || PremClient.getText().startsWith(",") || PremClient.getText().startsWith("/") || PremClient.getText().startsWith(";")) {
            validation.valid8();
        } else if (AdrClient.getText().startsWith(".") || AdrClient.getText().startsWith("+") || AdrClient.getText().startsWith("-") || AdrClient.getText().startsWith(",") || AdrClient.getText().startsWith("/") || AdrClient.getText().startsWith(";")) {
            validation.valid8();

        } else if (!EmailClient.getText().matches(emailPattern)) {
            validation.valid6();
            return;

        } else {
            try {

                String verify = "SELECT COUNT(*) FROM clients WHERE IDClient = ?";
                prepare = con.prepareStatement(verify);
                prepare.setString(1, NumClient.getText());
                resul = prepare.executeQuery();
                int count = 0;
                if (resul.next()) {
                    count = resul.getInt(1);
                }
                resul.close();
                prepare.close();
                if (count > 0) {
//                    JOptionPane.showMessageDialog(null, "Le numero Employes '" + NumClient.getText() + "' est deja existe ");
                    validation.valid7();
                    return;
                } else {
                    String request = "INSERT INTO clients (IDClient,NomC,PrenomC,AdresseC,NumeroC,EmailC) VALUES (?,?,?,?,?,?)";

                    prepare = con.prepareStatement(request/*,Statement.RETURN_GENERATED_KEYS*/);
                    prepare.setString(1, NumClient.getText());
                    prepare.setString(2, NomClient.getText());
                    prepare.setString(3, PremClient.getText());
                    prepare.setString(4, AdrClient.getText());
                    prepare.setString(5, NumPhone.getText());
                    prepare.setString(6, EmailClient.getText());

                    int numeroClient = Integer.parseInt(NumClient.getText());
                    prepare.setInt(1, numeroClient);

                    /* int idDepartement =  -1;
                
                if(prepare.executeUpdate()>0){
                    resul = prepare.getGeneratedKeys();
                    if(resul.next()){
                        idDepartement =  resul.getInt(1);
                        System.out.println("ID="+resul.getInt(1));
                    }
                }*/
                    prepare.execute();
                    message.setVisible(true);

                    Animator animator = new Animator(4000); // Durée de l'animation (500ms)
                    animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
                    animator.addTarget(new TimingTargetAdapter() {
                        @Override
                        public void timingEvent(float fraction) {
                            // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                            // en fonction de l'avancement de l'animation, par exemple :
                            message.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
                        }

                        @Override
                        public void end() {
                            // Fermer la fenêtre après la fin de l'animation
                            message.dispose();
                        }
                    });

                    animator.start();
                }

            } catch (HeadlessException | SQLException e) {
                System.out.println(" -->SQLException : " + e);
            } finally {
                try {
                    prepare.close();
                    resul.close();
                } catch (SQLException e) {

                }
            }
            instant = true;
            this.dispose();
        }
    }//GEN-LAST:event_BtnAjouterClientActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        DatabaseConnection.LoadConnexion();

        java.awt.EventQueue.invokeLater(() -> {
            new AddClient().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_Dialog.TextField AdrClient;
    private swing.ButtonOutLine BtnAjouterClient;
    private swing.ButtonOutLine BtnAnnileClient;
    private swing_Dialog.TextField EmailClient;
    private swing_Dialog.TextField NomClient;
    private swing_Dialog.TextField NumClient;
    private swing_Dialog.TextField NumPhone;
    private swing_Dialog.TextField PremClient;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
