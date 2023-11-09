
package FenetreModale;

//Starting
import Form.Form_6;
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

public final class UpdateDocument extends javax.swing.JFrame {

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

    public String Type;

    public UpdateDocument() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(dateDebut);
        setBackground(new Color(0,0,0,0));
       RecuperationDonne();
        instant = false;
        NumP.setVisible(false);
        setBackground(new Color(0, 0, 0, 0));
        NomD.setOpaque(false);
        NomD.setOpaque(false);
        NumeroC1.setOpaque(false);
        dateDebut.setOpaque(false);
    }

    public void RecuperationDonne() throws SQLException {
        Form_6 information = new Form_6();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM documents WHERE IDD ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("IDD");
                NumP.setText(A1);

                String A2 = resul.getString("NumC_ref");
                NumeroC1.setSelectedItem(A2);
                System.out.println(A2);
                //JOptionPane.showMessageDialog(null, A2);

                String A3 = resul.getString("NomD");
                NomD.setText(A3);
                System.out.println(A3);


                String A4 = resul.getString("Type");

                //pour le radio
                String others = A4;
                // JOptionPane.showMessageDialog(null, others);

                if (others.equals("contrat")) {
                    starting.setSelected(true);
                    System.out.println(others);

                } else if (others.equals("devis")) {
                    running.setSelected(true);
                    System.out.println(others);

                } else {
                    if (others.equals("rapport")) {
                        ending.setSelected(true);
                        System.out.println(others);
                    }
                }

                String A5 = resul.getString("DateD");
                dateDebut.setText(A5);


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

                    NumeroC1.setModel(model); // Définir le modèle dans le JComboBox
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        NumP = new swing_Dialog.TextField();
        NomD = new swing_Dialog.TextField();
        dateDebut = new swing_Dialog.TextField();
        NumeroC1 = new composant.combobox.Combobox();
        ending = new composant.radio_button.RadioButtonCustom();
        running = new composant.radio_button.RadioButtonCustom();
        starting = new composant.radio_button.RadioButtonCustom();
        buttonOutLine2 = new swing.ButtonOutLine();
        buttonOutLine1 = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumP.setLabelText("Numero ");
        panelShadow1.add(NumP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 26, 62, 15));

        NomD.setLabelText("Nom du document");
        NomD.setLineColor(new java.awt.Color(200, 39, 228));
        NomD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomDActionPerformed(evt);
            }
        });
        panelShadow1.add(NomD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 260, -1));

        dateDebut.setBackground(new java.awt.Color(255, 255, 255));
        dateDebut.setLabelText("Date d'ajout du document");
        dateDebut.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(dateDebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, -1));

        NumeroC1.setLabeText("Numero Client");
        NumeroC1.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 250, 55));

        ending.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ending);
        ending.setText("rapport");
        ending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endingActionPerformed(evt);
            }
        });
        panelShadow1.add(ending, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 85, -1));

        running.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(running);
        running.setText("devis");
        running.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runningActionPerformed(evt);
            }
        });
        panelShadow1.add(running, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 68, -1));

        starting.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(starting);
        starting.setText("contrat");
        starting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startingActionPerformed(evt);
            }
        });
        panelShadow1.add(starting, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 73, -1));

        buttonOutLine2.setBackground(new java.awt.Color(220, 27, 27));
        buttonOutLine2.setForeground(new java.awt.Color(220, 27, 27));
        buttonOutLine2.setText("Annuler");
        buttonOutLine2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine2ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 102, -1));

        buttonOutLine1.setBackground(new java.awt.Color(200, 39, 228));
        buttonOutLine1.setForeground(new java.awt.Color(200, 39, 228));
        buttonOutLine1.setText("Modifier");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 98, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }
    private void runningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runningActionPerformed
        Type = "devis";
    }//GEN-LAST:event_runningActionPerformed

    private void endingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endingActionPerformed
        Type = "rapport";
    }//GEN-LAST:event_endingActionPerformed

    private void startingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startingActionPerformed
        Type = "contrat";
    }//GEN-LAST:event_startingActionPerformed

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        MessageModification modification = new MessageModification();
        String A7 = null;
        if (starting.isSelected()) {
            A7 = starting.getText();
        } else if (running.isSelected()) {
            A7 = running.getText();
        } else if (ending.isSelected()) {
            A7 = ending.getText();
        } else {
            A7 = Type;
        }
        System.out.println("La valeur sélectionnée est : " + A7);

        try {
            String A1 = NumP.getText();
            String A2 = (String) NumeroC1.getSelectedItem();
            String A3 = NomD.getText();
            String A4 = dateDebut.getText();
            System.out.println(A1);
            System.out.println(A2);
            System.out.println(A3);
            System.out.println(A4);

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

            Form_6 information = new Form_6();
            information.Recuperation();
            try {
                String recuprer = information.GetTableResult();
                String request = "SELECT * FROM documents WHERE IDD ='" + recuprer + "' ";
                prepare = con.prepareStatement(request);
                resul = prepare.executeQuery();
                if (resul.next()) {
                    L1 = resul.getString("IDD");
                    NumP.setText(A1);

                    String requete = "UPDATE documents SET IDD='" + A1 + "', NomD='" + A3 + "', DateD='" + A4 + "',Type='" + A7 + "', NumC_ref='" + A2 + "' WHERE IDD='" + recuprer + "' ";
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

    }//GEN-LAST:event_buttonOutLine1ActionPerformed

    private void buttonOutLine2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine2ActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_buttonOutLine2ActionPerformed

    private void NomDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomDActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException{
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UpdateDocument().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateDocument.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_Dialog.TextField NomD;
    private swing_Dialog.TextField NumP;
    private composant.combobox.Combobox NumeroC1;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.ButtonOutLine buttonOutLine1;
    private swing.ButtonOutLine buttonOutLine2;
    private swing_Dialog.TextField dateDebut;
    private composant.radio_button.RadioButtonCustom ending;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    private composant.radio_button.RadioButtonCustom running;
    private composant.radio_button.RadioButtonCustom starting;
    // End of variables declaration//GEN-END:variables
}
