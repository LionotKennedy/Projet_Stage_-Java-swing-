package FenetreModale;

//Starting
import Form.Form_4;
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

public final class UpdateDepense extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;
    String A1;
    String T1;
    public String L1;

    public UpdateDepense() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(dateDepense);
        RecuperationDonne();
        instant = false;
        NumDepense.setVisible(false);
        setBackground(new Color(0, 0, 0, 0));
        DescriptionDepens.setOpaque(false);
        MotantD.setOpaque(false);
        NumDepense.setOpaque(false);
        NumeroD.setOpaque(false);
        dateDepense.setOpaque(false);
    }

    public void RecuperationDonne() throws SQLException {
        Form_4 information = new Form_4();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM depenses WHERE IDD ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("IDD");
                NumDepense.setText(A1);

                String A2 = resul.getString("NumD_ref");
                NumeroD.setSelectedItem(A2);
                System.out.println(A2);

                String A4 = resul.getString("DescrD");
                DescriptionDepens.setText(A4);

                String A6 = resul.getString("DateD");
                dateDepense.setText(A6);

                String A7 = resul.getString("MotantD");
                MotantD.setText(A7);

                //debut
                try {

                    String A8 = resul.getString("NumD_ref");

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

                    NumeroD.setModel(model); // Définir le modèle dans le JComboBox
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
        NumDepense = new swing_Dialog.TextField();
        DescriptionDepens = new swing_Dialog.TextField();
        MotantD = new swing_Dialog.TextField();
        dateDepense = new swing_Dialog.TextField();
        NumeroD = new composant.combobox.Combobox();
        BtnAnnileDepense = new swing.ButtonOutLine();
        BtnAjouterDepense = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumDepense.setLabelText("Numero Depense");
        NumDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumDepenseActionPerformed(evt);
            }
        });
        panelShadow1.add(NumDepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 24, 39, 21));

        DescriptionDepens.setLabelText("Description");
        DescriptionDepens.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DescriptionDepens, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 63, 294, 75));

        MotantD.setLabelText("Montant de la dépense  en Ariary");
        MotantD.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(MotantD, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 150, 294, 66));

        dateDepense.setBackground(new java.awt.Color(255, 255, 255));
        dateDepense.setLabelText("Date Depense");
        dateDepense.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(dateDepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 228, 294, -1));

        NumeroD.setLabeText("Numero Projet");
        NumeroD.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroD, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 299, 294, 60));

        BtnAnnileDepense.setBackground(new java.awt.Color(220, 27, 27));
        BtnAnnileDepense.setForeground(new java.awt.Color(220, 27, 27));
        BtnAnnileDepense.setText("Annuler");
        BtnAnnileDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnileDepenseActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAnnileDepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 95, 32));

        BtnAjouterDepense.setBackground(new java.awt.Color(200, 39, 228));
        BtnAjouterDepense.setForeground(new java.awt.Color(200, 39, 228));
        BtnAjouterDepense.setText("Modifier");
        BtnAjouterDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouterDepenseActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAjouterDepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 96, 34));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }
    private void BtnAnnileDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnnileDepenseActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_BtnAnnileDepenseActionPerformed

    private void BtnAjouterDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouterDepenseActionPerformed
        MessageModification modification = new MessageModification();
        try {
            String A1 = NumDepense.getText();
            String A2 = (String) NumeroD.getSelectedItem();
            String A4 = DescriptionDepens.getText();
            String A5 = MotantD.getText();
            String A6 = dateDepense.getText();
            System.out.println(A1);
            System.out.println(A2);
            System.out.println(A4);
            System.out.println(A5);
            System.out.println(A6);
            //JOptionPane.showMessageDialog(null, "echec de recuperation" +A2);

            //        Starting validation
//        String numDepenseText = NumDepense.getText();
            String numMotantText = MotantD.getText();
//        Ending

            try {
                int numPhone = Integer.parseInt(numMotantText);
                // Si la conversion en int réussit, c'est un nombre valide.
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez saisir un numéro de pour Motant valide (chiffres uniquement).");
                return;
            }

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

            Form_4 information = new Form_4();
            information.Recuperation();
            try {
                String recuprer = information.GetTableResult();
                String request = "SELECT * FROM depenses WHERE IDD ='" + recuprer + "' ";
                prepare = con.prepareStatement(request);
                resul = prepare.executeQuery();
                if (resul.next()) {
                    L1 = resul.getString("IDD");
                    NumDepense.setText(A1);

                    String requete = "UPDATE depenses SET IDD='" + A1 + "', DescrD='" + A4 + "',MotantD ='" + A5 + "',DateD='" + A6 + "', NumD_ref='" + A2 + "' WHERE IDD='" + A1 + "' ";
                    try {
                        prepare = con.prepareStatement(requete);
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
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        instant = true;
        this.dispose();

    }//GEN-LAST:event_BtnAjouterDepenseActionPerformed

    private void NumDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumDepenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumDepenseActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UpdateDepense().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDepense.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonOutLine BtnAjouterDepense;
    private swing.ButtonOutLine BtnAnnileDepense;
    private swing_Dialog.TextField DescriptionDepens;
    private swing_Dialog.TextField MotantD;
    private swing_Dialog.TextField NumDepense;
    private composant.combobox.Combobox NumeroD;
    private swing_Dialog.TextField dateDepense;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
