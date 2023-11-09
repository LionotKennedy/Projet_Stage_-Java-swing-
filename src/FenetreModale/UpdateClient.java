package FenetreModale;

import Form.Form_1;
import ShowMessage.MessageModification;
import ShowMessage.MessageValidationChamps;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;

public final class UpdateClient extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    String client6 = "Veuillez saisir une adresse e-mail valide.";

    public UpdateClient() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        RecuperationDonne();
        instant = false;
        NumClientUp.setVisible(false);
        setBackground(new Color(0, 0, 0, 0));
        AdresseUp.setOpaque(false);
        EmailUp.setOpaque(false);
        NomUp.setOpaque(false);
        NumClientUp.setOpaque(false);
        NumeroUp.setOpaque(false);
        PrenomUp.setOpaque(false);
    }

    public void RecuperationDonne() throws SQLException {
        Form_1 information = new Form_1();
//        MainSystem information = new MainSystem();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM clients WHERE IDClient ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String R1 = resul.getString("IDClient");
                NumClientUp.setText(R1);
                System.out.println(R1);

                String R2 = resul.getString("NomC");
                NomUp.setText(R2);
                System.out.println(R2);

                String R3 = resul.getString("PrenomC");
                PrenomUp.setText(R3);
                System.out.println(R3);

                String R4 = resul.getString("AdresseC");
                AdresseUp.setText(R4);
                System.out.println(R4);

                String R5 = resul.getString("NumeroC");
                NumeroUp.setText(R5);
                System.out.println(R5);

                String R6 = resul.getString("EmailC");
                EmailUp.setText(R6);
                System.out.println(R6);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getClient6() {
        return client6;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        NumClientUp = new swing_Dialog.TextField();
        NomUp = new swing_Dialog.TextField();
        PrenomUp = new swing_Dialog.TextField();
        AdresseUp = new swing_Dialog.TextField();
        NumeroUp = new swing_Dialog.TextField();
        EmailUp = new swing_Dialog.TextField();
        BtnUpAnnileClient = new swing.ButtonOutLine();
        BtnUpdateClient = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumClientUp.setLabelText("Numero Client");
        panelShadow1.add(NumClientUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 22, 84, 21));

        NomUp.setLabelText("Nom du Client");
        NomUp.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NomUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 49, 282, -1));

        PrenomUp.setLabelText("Prenom du Client");
        PrenomUp.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(PrenomUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 114, 279, -1));

        AdresseUp.setLabelText("Adresse du Client");
        AdresseUp.setLineColor(new java.awt.Color(200, 39, 228));
        AdresseUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdresseUpActionPerformed(evt);
            }
        });
        panelShadow1.add(AdresseUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 185, 279, -1));

        NumeroUp.setLabelText("Numéro de Téléphone");
        NumeroUp.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 256, 279, -1));

        EmailUp.setLabelText("Email Cleint");
        EmailUp.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(EmailUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 279, -1));

        BtnUpAnnileClient.setBackground(new java.awt.Color(220, 27, 27));
        BtnUpAnnileClient.setForeground(new java.awt.Color(220, 27, 27));
        BtnUpAnnileClient.setText("Annuler");
        BtnUpAnnileClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpAnnileClientActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnUpAnnileClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 101, 32));

        BtnUpdateClient.setBackground(new java.awt.Color(200, 39, 228));
        BtnUpdateClient.setForeground(new java.awt.Color(200, 39, 228));
        BtnUpdateClient.setText("Modifier");
        BtnUpdateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateClientActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnUpdateClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 96, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }

    private void BtnUpdateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateClientActionPerformed
        MessageModification modification = new MessageModification();
        MessageValidationChamps validation = new MessageValidationChamps();
        String A1 = NumClientUp.getText();
        String A2 = NomUp.getText();
        String A3 = PrenomUp.getText();
        String A4 = AdresseUp.getText();
        String A5 = NumeroUp.getText();
        String A6 = EmailUp.getText();

        System.out.println(A1);
        System.out.println(A2);
        System.out.println(A3);
        System.out.println(A4);
        System.out.println(A5);
        System.out.println(A6);

        //        Starting validation
        A1 = NumClientUp.getText();
        A5 = NumeroUp.getText();

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";

        if (A6.matches(emailRegex)) {
            A6 = EmailUp.getText();
            System.out.println("L'adresse email est valide !");
        } else {
            // La valeur de A6 ne correspond pas à une adresse email valide
            // Tu peux effectuer les actions appropriées ici
            System.out.println("L'adresse email n'est pas valide !");
        }
//        Ending

        try {
            int numPhone = Integer.parseInt(A5);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir un numéro de téléphone valide (chiffres uniquement).");
            return;
        }

        try {
            int numClient = Integer.parseInt(A1);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Veuillez saisir un numéro de valide (chiffres uniquement).");
            return;
        }

        Form_1 information = null;
        try {
            information = new Form_1();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        information.Recuperation();

        String recuprer = information.GetTableResult();
        if (!EmailUp.getText().matches(A6)) {
//            JOptionPane.showMessageDialog(null, "Veuillez saisir une adresse e-mail valide.");
            validation.valid6();
            return;

        } else {
            String request = "UPDATE clients SET IDClient='" + A1 + "', NomC='" + A2 + "',PrenomC='" + A3 + "',AdresseC ='" + A4 + "',NumeroC='" + A5 + "',EmailC ='" + A6 + "' WHERE IDClient='" + recuprer + "' ";
            try {
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
                System.out.println(ex);
            }

        }

        instant = true;
        this.dispose();
    }//GEN-LAST:event_BtnUpdateClientActionPerformed

    private void BtnUpAnnileClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpAnnileClientActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_BtnUpAnnileClientActionPerformed

    private void AdresseUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdresseUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdresseUpActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UpdateClient().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_Dialog.TextField AdresseUp;
    private swing.ButtonOutLine BtnUpAnnileClient;
    private swing.ButtonOutLine BtnUpdateClient;
    private swing_Dialog.TextField EmailUp;
    private swing_Dialog.TextField NomUp;
    private swing_Dialog.TextField NumClientUp;
    private swing_Dialog.TextField NumeroUp;
    private swing_Dialog.TextField PrenomUp;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
