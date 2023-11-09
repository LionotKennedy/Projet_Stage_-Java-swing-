package FenetreModale;

//Starting
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

public final class AddDocument extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    String A1;
    int NumClient;

    public String Type;
    static boolean instant;

    String document1 = "Veuillez saisir un numéro de valide (chiffres uniquement).";

    String document2 = "Veuillez remplir le champ nom document";

    String document3 = "Veuillez remplir le champ nom";

    String document4 = "Veillez sélectionner un type de document.";

    String document5 = "Le numéro de document existe déjà. Veuillez saisir un autre numéro";

    String document6 = "Ce champ ne doit pas commencer par les symboles '+', '-', ou ','.";

    String document7 = "Le numéro de document existe déjà. Veuillez saisir un autre numéro";

//    String client8 = "Cet champ ne dois pas commencer par les symboles '+', '-', ou ','";
    public AddDocument() {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(dateDebut);
        CheckValueComboBox();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
        
        NomD.setOpaque(false);
        NumP.setOpaque(false);
        NumeroC1.setOpaque(false);
        dateDebut.setOpaque(false);
    }

    public String getDocument1() {
        return document1;
    }

    public String getDocument2() {
        return document2;
    }

    public String getDocument3() {
        return document3;
    }

    public String getDocument4() {
        return document4;
    }

    public String getDocument5() {
        return document5;
    }

    public String getDocument6() {
        return document6;
    }

    public String getDocument7() {
        return document7;
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

        NumP.setLabelText("Numéro ");
        NumP.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumP, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 23, 278, -1));

        NomD.setLabelText("Description du document");
        NomD.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NomD, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 88, 278, -1));

        dateDebut.setBackground(new java.awt.Color(255, 255, 255));
        dateDebut.setLabelText("Date d'ajout du document");
        dateDebut.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(dateDebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 159, 278, -1));

        NumeroC1.setLabeText("Numéro Client");
        NumeroC1.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 230, 278, 55));

        ending.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ending);
        ending.setText("rapport");
        ending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endingActionPerformed(evt);
            }
        });
        panelShadow1.add(ending, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 85, -1));

        running.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(running);
        running.setText("devis");
        running.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runningActionPerformed(evt);
            }
        });
        panelShadow1.add(running, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 68, -1));

        starting.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(starting);
        starting.setText("contrat");
        starting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startingActionPerformed(evt);
            }
        });
        panelShadow1.add(starting, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 73, -1));

        buttonOutLine2.setBackground(new java.awt.Color(220, 27, 27));
        buttonOutLine2.setForeground(new java.awt.Color(220, 27, 27));
        buttonOutLine2.setText("Annuler");
        buttonOutLine2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine2ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 102, -1));

        buttonOutLine1.setBackground(new java.awt.Color(200, 39, 228));
        buttonOutLine1.setForeground(new java.awt.Color(200, 39, 228));
        buttonOutLine1.setText("Ajouter");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 98, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        MessageValidationChamps validation = new MessageValidationChamps();
        // Vérifier si aucun radiobutton n'est sélectionné
        if (!starting.isSelected() && !running.isSelected() && !ending.isSelected()) {
//        JOptionPane.showMessageDialog(null, "Veillez sélectionner un type de document.");
            validation.validat4();
            return;
        }

        MessageSuccess message = new MessageSuccess();
        String dateDeb = dateDebut.getText();
        System.out.println(dateDeb);

        String ancienLieu = NumeroC1.getSelectedItem().toString();

//        Starting validation
        String numProduitText = NumP.getText();
//        Ending

        try {
            int numPhone = Integer.parseInt(numProduitText);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Veuillez saisir un numéro de valide (chiffres uniquement).");
            validation.validat1();
            return;
        }

        if (NumP.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs numero");
            validation.validat1();
        } else if (NomD.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs de la nom");
            validation.validat2();
        } else if (dateDebut.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs de la date debut");
        } else if (NumP.getText().startsWith(".") || NumP.getText().startsWith("+") || NumP.getText().startsWith("-") || NumP.getText().startsWith(",") || NumP.getText().startsWith("/") || NumP.getText().startsWith(";")) {
            validation.validat6();
        } else if (NomD.getText().startsWith(".") || NomD.getText().startsWith("+") || NomD.getText().startsWith("-") || NomD.getText().startsWith(",") || NomD.getText().startsWith("/") || NomD.getText().startsWith(";")) {
            validation.validat6();
        } else if (dateDebut.getText().startsWith(".") || dateDebut.getText().startsWith("+") || dateDebut.getText().startsWith("-") || dateDebut.getText().startsWith(",") || dateDebut.getText().startsWith("/") || dateDebut.getText().startsWith(";")) {
            validation.validat6();
        } else {
            try {
                String verify = "SELECT COUNT(*) FROM documents WHERE IDD = ?";
                prepare = con.prepareStatement(verify);
                prepare.setString(1, NumP.getText());
                resul = prepare.executeQuery();
                int count = 0;
                if (resul.next()) {
                    count = resul.getInt(1);
                }
                resul.close();
                prepare.close();
                if (count > 0) {
//                    JOptionPane.showMessageDialog(null, "Le numero Document '" + NumP.getText() + "' est deja existe ");
                    validation.validat5();
                    return;
                } else {

                    boolean employeTrouve = false;  // On ajoute une variable pour vérifier si on trouve un employé correspondant

                    try {
                        String lieuEmp = NumeroC1.getSelectedItem().toString();
                        String query = "SELECT IDClient, NomC FROM clients WHERE IDClient = ?";
                        prepare = con.prepareStatement(query);
                        prepare.setString(1, lieuEmp);
                        resul = prepare.executeQuery();
                        NumClient = -1;
                        String numeroClient = "";

                        if (resul.next()) {
                            NumClient = resul.getInt("IDClient");
                            numeroClient = resul.getString("NomC");
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

                    String query = "SELECT NomC FROM clients WHERE IDClient = '" + NumClient + "'";
                    prepare = con.prepareStatement(query);
                    resul = prepare.executeQuery();

                    if (resul.next()) {
                        A1 = resul.getString("NomC");
                        System.out.println(A1);
                        //JOptionPane.showMessageDialog(null, "lieu est" +A1);
                    }

                    String request = "INSERT INTO documents (IDD,NomD,Type,DateD,NumC_ref) VALUES (?,?,'" + Type + "','" + dateDeb + "','" + NumClient + "')";

                    prepare = con.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
                    prepare.setString(1, NumP.getText());
                    prepare.setString(2, NomD.getText());
//                    prepare.setString(3, Type);

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

    }//GEN-LAST:event_buttonOutLine1ActionPerformed

    private void buttonOutLine2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine2ActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_buttonOutLine2ActionPerformed

    public void CheckValueComboBox() {
        try {
            String request = "SELECT IDClient FROM clients";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            while (resul.next()) {
                NumeroC1.addItem(resul.getString("IDClient"));
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
            new AddDocument().setVisible(true);
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
