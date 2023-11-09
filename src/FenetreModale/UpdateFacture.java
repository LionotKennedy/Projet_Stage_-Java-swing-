package FenetreModale;

//Staring
import Form.Form_5;
import ShowMessage.MessageModification;
import com.raven.datechooser.DateChooser;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public final class UpdateFacture extends javax.swing.JFrame {

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
    public String etat;
    String motantD;
    String motantG;
    double somme = 0;
    double DoubleMotantD = 0;
    double DoubleMotantG = 0;
    double difference = 0;
    String formatteddifference;
    String formattedsomme;

    public UpdateFacture() throws SQLException, IOException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(DateF);
        RecuperationDonne();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
        MotantT.setVisible(false);
        DateF.setOpaque(false);
        MotantT.setOpaque(false);
        NumF.setOpaque(false);
        NumeroC.setOpaque(false);
    }

    public void RecuperationDonne() throws SQLException, IOException {
        Form_5 information = new Form_5();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM factures WHERE ID ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("NumeroF");
                NumF.setText(A1);

                String A2 = resul.getString("NumC_ref");
                NumeroC.setSelectedItem(A2);
                System.out.println(A2);
                //JOptionPane.showMessageDialog(null, A2);

                String A3 = resul.getString("MotantTo");
                MotantT.setText(A3);
                System.out.println(A3);

                String A4 = resul.getString("DateF");
                DateF.setText(A4);

                String A5 = resul.getString("Etat");

                //pour le radio
                String others = A5;
                // JOptionPane.showMessageDialog(null, others);

                if (others.equals("payée")) {
                    finish.setSelected(true);
                    System.out.println(others);

                } else {
                    if (others.equals("en attente")) {
                        Wait.setSelected(true);
                        System.out.println(others);
                    }
                }
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
        NumF = new swing_Dialog.TextField();
        MotantT = new swing_Dialog.TextField();
        DateF = new swing_Dialog.TextField();
        NumeroC = new composant.combobox.Combobox();
        Wait = new composant.radio_button.RadioButtonCustom();
        finish = new composant.radio_button.RadioButtonCustom();
        btnAnnuler = new swing.ButtonOutLine();
        btnAjouter = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumF.setLabelText("Numéro de facture");
        NumF.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumF, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 51, 277, -1));

        MotantT.setLabelText("Montant total de la facture  ");
        MotantT.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(MotantT, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 40, 20));

        DateF.setBackground(new java.awt.Color(255, 255, 255));
        DateF.setLabelText("Date de la facture");
        DateF.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DateF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 277, -1));

        NumeroC.setLabeText("Numero Client");
        NumeroC.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 277, 52));

        Wait.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Wait);
        Wait.setText("en attente");
        Wait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WaitActionPerformed(evt);
            }
        });
        panelShadow1.add(Wait, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 107, -1));

        finish.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(finish);
        finish.setText("payée");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });
        panelShadow1.add(finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 98, -1));

        btnAnnuler.setBackground(new java.awt.Color(220, 27, 27));
        btnAnnuler.setForeground(new java.awt.Color(220, 27, 27));
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        panelShadow1.add(btnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 102, -1));

        btnAjouter.setBackground(new java.awt.Color(200, 39, 228));
        btnAjouter.setForeground(new java.awt.Color(200, 39, 228));
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        panelShadow1.add(btnAjouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }
    private void WaitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WaitActionPerformed
        etat = "en attente";
    }//GEN-LAST:event_WaitActionPerformed

    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
        etat = "payée";
    }//GEN-LAST:event_finishActionPerformed

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        MessageModification modification = new MessageModification();
        String A7 = null;
        if (finish.isSelected()) {
            A7 = finish.getText();
        } else if (Wait.isSelected()) {
            A7 = Wait.getText();
        } else {
            A7 = etat;
        }
        System.out.println("La valeur sélectionnée est : " + A7);

        try {
            String A1 = NumF.getText();
            String A2 = (String) NumeroC.getSelectedItem();
            String A3 = DateF.getText();
            String A4 = MotantT.getText();
            System.out.println(A1);
            System.out.println(A2);
            System.out.println(A3);
            System.out.println(A4);

            //        Starting validation
            String numDepenseText = NumF.getText();
            try {
                int numClient = Integer.parseInt(numDepenseText);
                // Si la conversion en int réussit, c'est un nombre valide.
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez saisir un numéro de valide (chiffres uniquement).");
                return;
            }

            //JOptionPane.showMessageDialog(null, "echec de recuperation" +A2);
            String query = "SELECT C.IDClient, C.NomC, D.MotantD, G.MotantG "
                    + "FROM CLIENTS C "
                    + "JOIN PROJETS P ON C.IDClient = P.NumC_ref "
                    + "JOIN DEPENSES D ON P.IDP = D.NumD_ref "
                    + "JOIN GAINS G ON P.IDP = G.NumD_ref "
                    + "WHERE C.IDClient = '" + A2 + "'";
            try {
                prepare = con.prepareStatement(query);
                resul = prepare.executeQuery();
                if (resul.next()) {
                    motantD = resul.getString("MotantD");
                    System.out.println(motantD);
                    motantG = resul.getString("MotantG");
                    System.out.println(motantG);
                }
                // Convertir les valeurs en types numériques (par exemple, double)
                DoubleMotantD = Double.parseDouble(motantD);
                DoubleMotantG = Double.parseDouble(motantG);

                difference = DoubleMotantG - DoubleMotantD;
                somme = DoubleMotantG + DoubleMotantD;

                // Créer un objet DecimalFormat pour formater les valeurs
                DecimalFormat decimalFormat = new DecimalFormat("0.00");

                // Formater les valeurs en décimal
                formatteddifference = decimalFormat.format(difference);
                formattedsomme = decimalFormat.format(somme);

                // Afficher les résultats formatés
                System.out.println("Différence : " + formatteddifference);
                System.out.println("Somme : " + formattedsomme);
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

            Form_5 information = new Form_5();
            information.Recuperation();
            try {
                String recuprer = information.GetTableResult();
                String request = "SELECT * FROM factures WHERE ID ='" + recuprer + "' ";
                prepare = con.prepareStatement(request);
                resul = prepare.executeQuery();
                if (resul.next()) {
//                    L1 = resul.getString("ID");
//                    NumF.setText(A1);

                    String requete = "UPDATE factures SET NumeroF='" + A1 + "', DateF='" + A3 + "', MotantTo ='" + formatteddifference + "',Etat='" + A7 + "', NumC_ref='" + A2 + "' WHERE ID='" + recuprer + "' ";
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
        } catch (IOException ex) {
            Logger.getLogger(UpdateFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        instant = true;
        this.dispose();
        System.out.println(motantD + "Lionot Bogosy1");
        System.out.println(motantG + "Lionot Bogosy2");
        System.out.println(somme + "Lionot Bogosy3");
        System.out.println(difference + "Lionot Bogosy4");
        System.out.println(formattedsomme + "Lionot Bogosy5");
        System.out.println(formatteddifference + "Lionot Bogosy6");

    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UpdateFacture().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateFacture.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UpdateFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_Dialog.TextField DateF;
    private swing_Dialog.TextField MotantT;
    private swing_Dialog.TextField NumF;
    private composant.combobox.Combobox NumeroC;
    private composant.radio_button.RadioButtonCustom Wait;
    private swing.ButtonOutLine btnAjouter;
    private swing.ButtonOutLine btnAnnuler;
    private javax.swing.ButtonGroup buttonGroup1;
    private composant.radio_button.RadioButtonCustom finish;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
