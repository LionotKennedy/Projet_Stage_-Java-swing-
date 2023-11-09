package FenetreModale;
//Starting

import Form.Form_2;
import ShowMessage.MessageModification;
import com.raven.datechooser.DateChooser;
import connexionDB.DatabaseConnection;
import java.awt.Color;
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

public final class UpdateProject extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;
    String A1;
    String T1;
    public String L1;
    int NumClient;

    public String status;

    public UpdateProject() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(dateDebut);
        chDate1.setTextField(DateFin);
        RecuperationDonne();
        instant = false;
//        CheckValueComboBox();
        NumP.setVisible(false);
        setBackground(new Color(0, 0, 0, 0));
        DateFin.setOpaque(false);
        DescP.setOpaque(false);
        NomP.setOpaque(false);
        NumP.setOpaque(false);
        NumeroC.setOpaque(false);
        dateDebut.setOpaque(false);
    }

    public void RecuperationDonne() throws SQLException {
        Form_2 information = new Form_2();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM projets WHERE IDP ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("IDP");
                NumP.setText(A1);

                String A2 = resul.getString("NumC_ref");
                NumeroC.setSelectedItem(A2);
                System.out.println(A2);
                //JOptionPane.showMessageDialog(null, A2);

                String A3 = resul.getString("NomP");
                NomP.setText(A3);
                System.out.println(A3);

                String A4 = resul.getString("DescrP");
                DescP.setText(A4);

                String A5 = resul.getString("Status");

                //pour le radio
                String others = A5;
                // JOptionPane.showMessageDialog(null, others);

                if (others.equals("Débute")) {
                    starting.setSelected(true);
                    System.out.println(others);

                } else if (others.equals("en cours")) {
                    running.setSelected(true);
                    System.out.println(others);

                } else {
                    if (others.equals("terminer")) {
                        ending.setSelected(true);
                        System.out.println(others);
                    }
                }

                String A6 = resul.getString("DateDP");
                dateDebut.setText(A6);

                String A7 = resul.getString("DateFP");
                DateFin.setText(A7);

                //debut
                try {

                    String A8 = resul.getString("NumC_ref");

                    /////// code recuperation de donnee (all list) ////////
                    String requeste = "SELECT IDClient FROM clients";
                    prepare = con.prepareStatement(requeste);
                    resul = prepare.executeQuery();
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    String selectedValue = A2;

                    model.addElement(selectedValue);

                    while (resul.next()) {
                        String lieu = resul.getString("IDClient");
                        if (!lieu.equals(selectedValue)) {
                            model.addElement(lieu);
                        }
                    }

                    NumeroC.setModel(model); // Définir le modèle dans le JComboBox
                    /////// ending code /////////

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "echec de recuperation");
                }
                //ending
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        NumP = new swing_Dialog.TextField();
        NomP = new swing_Dialog.TextField();
        DescP = new swing_Dialog.TextField();
        dateDebut = new swing_Dialog.TextField();
        DateFin = new swing_Dialog.TextField();
        NumeroC = new composant.combobox.Combobox();
        ending = new composant.radio_button.RadioButtonCustom();
        running = new composant.radio_button.RadioButtonCustom();
        starting = new composant.radio_button.RadioButtonCustom();
        BtnAnnuler = new swing.ButtonOutLine();
        btnModifier = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumP.setLabelText("Numero ");
        panelShadow1.add(NumP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 18, 18));

        NomP.setLabelText("Nom");
        NomP.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NomP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 276, -1));

        DescP.setLabelText("Description");
        DescP.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DescP, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 112, 276, 70));

        dateDebut.setBackground(new java.awt.Color(255, 255, 255));
        dateDebut.setLabelText("Date Debut");
        dateDebut.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(dateDebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 184, 276, 70));

        DateFin.setBackground(new java.awt.Color(255, 255, 255));
        DateFin.setLabelText("Date Fin");
        DateFin.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 276, 70));

        NumeroC.setForeground(new java.awt.Color(0, 0, 0));
        NumeroC.setLabeText("Numero Client");
        NumeroC.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 276, 61));

        ending.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ending);
        ending.setText(" terminé");
        ending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endingActionPerformed(evt);
            }
        });
        panelShadow1.add(ending, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 77, -1));

        running.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(running);
        running.setText("en cours");
        running.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runningActionPerformed(evt);
            }
        });
        panelShadow1.add(running, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        starting.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(starting);
        starting.setText("Debute");
        starting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startingActionPerformed(evt);
            }
        });
        panelShadow1.add(starting, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        BtnAnnuler.setBackground(new java.awt.Color(220, 27, 27));
        BtnAnnuler.setForeground(new java.awt.Color(220, 27, 27));
        BtnAnnuler.setText("Annuler");
        BtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnulerActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 108, 30));

        btnModifier.setBackground(new java.awt.Color(200, 39, 228));
        btnModifier.setForeground(new java.awt.Color(200, 39, 228));
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        panelShadow1.add(btnModifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 110, 30));

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
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }
    private void runningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runningActionPerformed
        status = "en cours";
    }//GEN-LAST:event_runningActionPerformed

    private void endingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endingActionPerformed
        status = "terminer";
    }//GEN-LAST:event_endingActionPerformed

    private void startingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startingActionPerformed
        status = "Debute";
    }//GEN-LAST:event_startingActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        MessageModification modification = new MessageModification();
        String A7 = null;
        if (starting.isSelected()) {
            A7 = starting.getText();
        } else if (running.isSelected()) {
            A7 = running.getText();
        } else if (ending.isSelected()) {
            A7 = ending.getText();
        } else {
            A7 = status;
        }
        System.out.println("La valeur sélectionnée est : " + A7);

        try {
            String A1 = NumP.getText();
            String A2 = (String) NumeroC.getSelectedItem();
            String A3 = NomP.getText();
            String A4 = DescP.getText();
            String A5 = dateDebut.getText();
            String A6 = DateFin.getText();
            System.out.println(A1);
            System.out.println(A2);
            System.out.println(A3);
            System.out.println(A4);
            System.out.println(A5);
            System.out.println(A6);
            //JOptionPane.showMessageDialog(null, "echec de recuperation" +A2);

            String query = "SELECT IDClient FROM clients WHERE IDClient = '" + A2 + "'";
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
                    T1 = resul.getString("IDClient");
                    System.out.println(T1);
                    // JOptionPane.showMessageDialog(null, "lieu est" +T1);
                }

                //JOptionPane.showMessageDialog(null, "echec de recuperation" +T1);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProject.class.getName()).log(Level.SEVERE, null, ex);
            }

            Form_2 information = new Form_2();
            information.Recuperation();
            try {
                String recuprer = information.GetTableResult();
                String request = "SELECT * FROM projets WHERE IDP ='" + recuprer + "' ";
                prepare = con.prepareStatement(request);
                resul = prepare.executeQuery();
                if (resul.next()) {
                    L1 = resul.getString("IDP");
                    NumP.setText(A1);

                    String requete = "UPDATE projets SET IDP='" + A1 + "', NomP='" + A3 + "', DescrP='" + A4 + "',Status='" + A7 + "',DateDP ='" + A5 + "',DateFP='" + A6 + "', NumC_ref='" + A2 + "' WHERE IDP='" + A1 + "' ";
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

    }//GEN-LAST:event_btnModifierActionPerformed

    private void BtnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnnulerActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_BtnAnnulerActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UpdateProject().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonOutLine BtnAnnuler;
    private swing_Dialog.TextField DateFin;
    private swing_Dialog.TextField DescP;
    private swing_Dialog.TextField NomP;
    private swing_Dialog.TextField NumP;
    private composant.combobox.Combobox NumeroC;
    private swing.ButtonOutLine btnModifier;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing_Dialog.TextField dateDebut;
    private composant.radio_button.RadioButtonCustom ending;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    private composant.radio_button.RadioButtonCustom running;
    private composant.radio_button.RadioButtonCustom starting;
    // End of variables declaration//GEN-END:variables
}
