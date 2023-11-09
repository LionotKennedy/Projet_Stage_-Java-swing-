
package FenetreModale;

//Starting
import static FenetreModale.AddDepense.instant;
import ShowMessage.MessageSuccess;
import ShowMessage.MessageValidationChamps;
import com.raven.datechooser.DateChooser;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class AddGains extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static boolean instant;
    String A1;
    int NumDep;

    String depense1 = "Veuillez saisir un numéro de valide (chiffres uniquement).";

    String depense2 = "Veuillez remplir le champ de la description";

    String depense3 = "Ce champ ne doit pas commencer par les symboles '+', '-', ou ','.";

    String depense4 = "Le numéro d'activité existe déjà.";

    String depense5 = "Veuillez saisir un numéro de pour Motant valide (chiffres uniquement).";
    public AddGains() {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(dateDepense);
        CheckValueComboBox();
        setBackground(new Color(0, 0, 0, 0));
        
        DescriptionDepens.setOpaque(false);
        MotantD.setOpaque(false);
        NumDepense.setOpaque(false);
        NumeroD.setOpaque(false);
        dateDepense.setOpaque(false);
    }

    public String getDepense1() {
        return depense1;
    }

    public String getDepense2() {
        return depense2;
    }

    public String getDepense3() {
        return depense3;
    }

    public String getDepense4() {
        return depense4;
    }

    public String getDepense5() {
        return depense5;
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

        NumDepense.setLabelText("Numéro de gain");
        NumDepense.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumDepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 29, 300, -1));

        DescriptionDepens.setLabelText("Description");
        DescriptionDepens.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DescriptionDepens, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 106, 300, -1));

        MotantD.setLabelText("Motant de la gain  en Ariary");
        MotantD.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(MotantD, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 183, 300, -1));

        dateDepense.setBackground(new java.awt.Color(255, 255, 255));
        dateDepense.setLabelText("Date de la Gain");
        dateDepense.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(dateDepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 260, 300, -1));

        NumeroD.setLabeText("Numéro du Projet");
        NumeroD.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroD, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 337, 300, 60));

        BtnAnnileDepense.setBackground(new java.awt.Color(220, 27, 27));
        BtnAnnileDepense.setForeground(new java.awt.Color(220, 27, 27));
        BtnAnnileDepense.setText("Annuler");
        BtnAnnileDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnileDepenseActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAnnileDepense, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 440, 100, 32));

        BtnAjouterDepense.setBackground(new java.awt.Color(200, 39, 228));
        BtnAjouterDepense.setForeground(new java.awt.Color(200, 39, 228));
        BtnAjouterDepense.setText("Ajouter");
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
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        MessageSuccess message = new MessageSuccess();
        MessageValidationChamps validation = new MessageValidationChamps();
        String dateDeb = dateDepense.getText();
        System.out.println(dateDeb);

        //        Starting validation
        String numDepenseText = NumDepense.getText();
        String numMotantText = MotantD.getText();
        //        Ending

        try {
            int numPhone = Integer.parseInt(numMotantText);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
//            validation.validation1();
            return;
        }

        try {
            int numClient = Integer.parseInt(numDepenseText);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
//            validation.validation1();
            return;
        }

        if (NumDepense.getText().equals("")) {
//            validation.validation1();
        } else if (DescriptionDepens.getText().equals("")) {
//            validation.validation2();
        } else if (dateDepense.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs de la description");
        } else if (MotantD.getText().equals("")) {
            validation.validation5();
        } else if (NumDepense.getText().startsWith(".") || NumDepense.getText().startsWith("+") || NumDepense.getText().startsWith("-") || NumDepense.getText().startsWith(",") || NumDepense.getText().startsWith("/") || NumDepense.getText().startsWith(";")) {
            validation.validation3();
        } else if (DescriptionDepens.getText().startsWith(".") || DescriptionDepens.getText().startsWith("+") || DescriptionDepens.getText().startsWith("-") || DescriptionDepens.getText().startsWith(",") || DescriptionDepens.getText().startsWith("/") || DescriptionDepens.getText().startsWith(";")) {
            validation.validation3();
        } else if (dateDepense.getText().startsWith(".") || dateDepense.getText().startsWith("+") || dateDepense.getText().startsWith("-") || dateDepense.getText().startsWith(",") || dateDepense.getText().startsWith("/") || dateDepense.getText().startsWith(";")) {
            validation.validation3();
        } else if (MotantD.getText().startsWith(".") || MotantD.getText().startsWith("+") || MotantD.getText().startsWith("-") || MotantD.getText().startsWith(",") || MotantD.getText().startsWith("/") || MotantD.getText().startsWith(";")) {
            validation.validation3();
        } else {
            try {
                String verify = "SELECT COUNT(*) FROM gains WHERE IDG = ?";
                prepare = con.prepareStatement(verify);
                prepare.setString(1, NumDepense.getText());
                resul = prepare.executeQuery();
                int count = 0;
                if (resul.next()) {
                    count = resul.getInt(1);
                }
                resul.close();
                prepare.close();
                if (count > 0) {
                    //                    JOptionPane.showMessageDialog(null, "Le numero Affectations '" + NumDepense.getText() + "' est deja existe ");
                    validation.validation4();
                    return;
                } else {

                    boolean employeTrouve = false;  // On ajoute une variable pour vérifier si on trouve un employé correspondant

                    try {
                        String lieuEmp = NumeroD.getSelectedItem().toString();
                        String query = "SELECT IDP, NomP FROM projets WHERE IDP = ?";
                        prepare = con.prepareStatement(query);
                        prepare.setString(1, lieuEmp);
                        resul = prepare.executeQuery();
                        NumDep = -1;
                        String numeroClient = "";

                        if (resul.next()) {
                            NumDep = resul.getInt("IDP");
                            numeroClient = resul.getString("NomP");
                            //JOptionPane.showMessageDialog(null, "Le numéro d'employé est : " + numEmp);
                            employeTrouve = true;  // On met employeTrouve à true si on trouve un employé correspondant
                        }

                        resul.close();
                        prepare.close();

                    } catch (SQLException e) {
                        System.out.println(" -->SQLException : " + e);
                    }

                    if (employeTrouve) {  // On affiche le message si employeTrouve est true
                        //JOptionPane.showMessageDialog(null, "Le numéro d'employé correspondant est : " + numeroEmp);
                    } else {
                        //JOptionPane.showMessageDialog(null, "Aucun employé correspondant trouvé.");
                    }

                    String query = "SELECT NomP FROM projets WHERE IDP = '" + NumDep + "'";
                    prepare = con.prepareStatement(query);
                    resul = prepare.executeQuery();

                    if (resul.next()) {
                        A1 = resul.getString("NomP");
                        System.out.println(A1);
                        //JOptionPane.showMessageDialog(null, "lieu est" +A1);
                    }

                    String request = "INSERT INTO gains (IDG,DescrG,MotantG,DateG,NumD_ref) VALUES (?,?,?,'" + dateDeb + "','" + NumDep + "')";

                    prepare = con.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
                    prepare.setString(1, NumDepense.getText());
                    prepare.setString(2, DescriptionDepens.getText());
                    prepare.setString(3, MotantD.getText());

                    /**/ int idDepartement = -1;

                    if (prepare.executeUpdate() > 0) {
                        resul = prepare.getGeneratedKeys();
                        if (resul.next()) {
                            idDepartement = resul.getInt(1);
                            System.out.println("ID=" + resul.getInt(1));
                        }
                    }

                }

            } catch (HeadlessException | SQLException e) {
                System.out.println(" -->SQLException : " + e);
            } finally {
                try {
                    prepare.close();
                    resul.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

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
            instant = true;
            this.dispose();

        }
    }//GEN-LAST:event_BtnAjouterDepenseActionPerformed

    public void CheckValueComboBox() {
        try {
            String request = "SELECT IDP FROM projets";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            while (resul.next()) {
                NumeroD.addItem(resul.getString("IDP"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "echec de recuperation");
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
         DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            new AddGains().setVisible(true);
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
