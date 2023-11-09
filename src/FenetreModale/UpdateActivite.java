package FenetreModale;

//Starting
import Form.Form_3;
import ShowMessage.MessageModification;
import com.raven.datechooser.DateChooser;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public final class UpdateActivite extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;
    String A1;
    String T1;
    public String L1;

    public UpdateActivite() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(dateDebutA);
        chDate1.setTextField(DateFinA);
        RecuperationDonne();
        instant = false;
        NumActivite.setVisible(false);
        setBackground(new Color(0, 0, 0, 0));
        DateFinA.setOpaque(false);
        Description.setOpaque(false);
        NumActivite.setOpaque(false);
        NumeroA.setOpaque(false);
        dateDebutA.setOpaque(false);
    }

    public void RecuperationDonne() throws SQLException {
        Form_3 information = new Form_3();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM activites WHERE IDA ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("IDA");
                NumActivite.setText(A1);

                String A2 = resul.getString("NumA_ref");
                NumeroA.setSelectedItem(A2);
                System.out.println(A2);

                String A4 = resul.getString("DescrA");
                Description.setText(A4);

                String A6 = resul.getString("DateDA");
                dateDebutA.setText(A6);

                String A7 = resul.getString("DateFA");
                DateFinA.setText(A7);

                //debut
                try {

                    String A8 = resul.getString("NumA_ref");

                    /////// code recuperation de donnee (all list) ////////
                    String requeste = "SELECT IDP FROM projets";
                    prepare = con.prepareStatement(requeste);
                    resul = prepare.executeQuery();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    String selectedValue = A2;

                    model.addElement(selectedValue);

                    while (resul.next()) {
                        String lieu = resul.getString("IDP");
                        if (!lieu.equals(selectedValue)) {
                            model.addElement(lieu);
                        }
                    }

                    NumeroA.setModel(model); // Définir le modèle dans le JComboBox
                    /////// ending code /////////

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "echec de recuperation");
                }
                //ending
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        NumActivite = new swing_Dialog.TextField();
        Description = new swing_Dialog.TextField();
        dateDebutA = new swing_Dialog.TextField();
        DateFinA = new swing_Dialog.TextField();
        NumeroA = new composant.combobox.Combobox();
        BtnAnnileClient = new swing.ButtonOutLine();
        BtnAjouterClient = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumActivite.setLabelText("Numero Activite");
        panelShadow1.add(NumActivite, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 22, 78, 14));

        Description.setLabelText("Description");
        Description.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 54, 285, 75));

        dateDebutA.setBackground(new java.awt.Color(255, 255, 255));
        dateDebutA.setLabelText("Date de début");
        dateDebutA.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(dateDebutA, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 147, 285, 72));

        DateFinA.setBackground(new java.awt.Color(255, 255, 255));
        DateFinA.setLabelText("Date de fin");
        DateFinA.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DateFinA, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 231, 285, -1));

        NumeroA.setLabeText("Numéro de projet");
        NumeroA.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 302, 285, 62));

        BtnAnnileClient.setBackground(new java.awt.Color(220, 27, 27));
        BtnAnnileClient.setForeground(new java.awt.Color(220, 27, 27));
        BtnAnnileClient.setText("Annuler");
        BtnAnnileClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnileClientActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAnnileClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 101, 30));

        BtnAjouterClient.setBackground(new java.awt.Color(200, 39, 228));
        BtnAjouterClient.setForeground(new java.awt.Color(200, 39, 228));
        BtnAjouterClient.setText("Modifier");
        BtnAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouterClientActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAjouterClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 434, 102, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
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
        MessageModification modification = new MessageModification();
        try {
            String A1 = NumActivite.getText();
            String A2 = (String) NumeroA.getSelectedItem();
            String A4 = Description.getText();
            String A5 = dateDebutA.getText();
            String A6 = DateFinA.getText();
            System.out.println(A1);
            System.out.println(A2);
            System.out.println(A4);
            System.out.println(A5);
            System.out.println(A6);
            //JOptionPane.showMessageDialog(null, "echec de recuperation" +A2);

            String query = "SELECT IDP FROM projets WHERE IDP = '" + A2 + "'";
            try {
                prepare = con.prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProject.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                resul = prepare.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProject.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if (resul.next()) {
                    T1 = resul.getString("IDP");
                    System.out.println(T1);
                    // JOptionPane.showMessageDialog(null, "lieu est" +T1);
                }

                //JOptionPane.showMessageDialog(null, "echec de recuperation" +T1);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProject.class.getName()).log(Level.SEVERE, null, ex);
            }

            Form_3 information = new Form_3();
            information.Recuperation();
            try {
                String recuprer = information.GetTableResult();
                String request = "SELECT * FROM activites WHERE IDA ='" + recuprer + "' ";
                prepare = con.prepareStatement(request);
                resul = prepare.executeQuery();
                if (resul.next()) {
                    L1 = resul.getString("IDA");
                    NumActivite.setText(A1);

                    String requete = "UPDATE activites SET IDA='" + A1 + "', DescrA='" + A4 + "',DateDA ='" + A5 + "',DateFA='" + A6 + "', NumA_ref='" + A2 + "' WHERE IDA='" + A1 + "' ";
                    try {
                        prepare = con.prepareStatement(requete);
                        prepare.execute();
//                        JOptionPane.showMessageDialog(null, "Modification avec succes");
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
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        instant = true;
        this.dispose();
    }//GEN-LAST:event_BtnAjouterClientActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UpdateActivite().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateActivite.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonOutLine BtnAjouterClient;
    private swing.ButtonOutLine BtnAnnileClient;
    private swing_Dialog.TextField DateFinA;
    private swing_Dialog.TextField Description;
    private swing_Dialog.TextField NumActivite;
    private composant.combobox.Combobox NumeroA;
    private swing_Dialog.TextField dateDebutA;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
