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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class AddFacture extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    String A1;
    int NumClient;

    String motantD;
    String motantG;
    double somme = 0;
    double DoubleMotantD = 0;
    double DoubleMotantG = 0;
    double difference = 0;
    String formatteddifference;
    String formattedsomme;

    public String etat;
    static boolean instant;

    String facture1 = "Veuillez saisir un numéro de valide (chiffres uniquement).";

    String facture2 = "Veuillez saisir un numéro de pour Motant valide (chiffres uniquement).t";

    String facture3 = "Veuillez remplir le champs total de la montant";

    String facture4 = "Veillez sélectionner un etat de facture.";

    String facture5 = "Le numero de Facture est déjà existe.Veuillez saisir une autre numero.";

    String facture6 = "Ce champ ne dois pas commencer par les symboles '+', '-', ou ','";

    public AddFacture() {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(DateF);
        CheckValueComboBox();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
//         CustomRadioButtonUI();
        MotantT.setVisible(false);

        DateF.setOpaque(false);
        MotantT.setOpaque(false);
        NumF.setOpaque(false);
        NumeroC.setOpaque(false);
    }

    public String getFacture1() {
        return facture1;
    }

    public String getFacture2() {
        return facture2;
    }

    public String getFacture3() {
        return facture3;
    }

    public String getFacture4() {
        return facture4;
    }

    public String getFacture5() {
        return facture5;
    }

    public String getFacture6() {
        return facture6;
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
        panelShadow1.add(NumF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 280, -1));

        MotantT.setLabelText("Montant total de la facture  ");
        MotantT.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(MotantT, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 30, 20));

        DateF.setBackground(new java.awt.Color(255, 255, 255));
        DateF.setLabelText("Date de la facture");
        DateF.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DateF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 280, -1));

        NumeroC.setLabeText("Numero Client");
        NumeroC.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 280, 56));

        Wait.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Wait);
        Wait.setText("en attente");
        Wait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WaitActionPerformed(evt);
            }
        });
        panelShadow1.add(Wait, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 107, -1));

        finish.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(finish);
        finish.setText("payée");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });
        panelShadow1.add(finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 98, -1));

        btnAnnuler.setBackground(new java.awt.Color(220, 27, 27));
        btnAnnuler.setForeground(new java.awt.Color(220, 27, 27));
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        panelShadow1.add(btnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 102, -1));

        btnAjouter.setBackground(new java.awt.Color(200, 39, 228));
        btnAjouter.setForeground(new java.awt.Color(200, 39, 228));
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        panelShadow1.add(btnAjouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 98, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
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
        // Vérifier si aucun radiobutton n'est sélectionné
        MessageValidationChamps validation = new MessageValidationChamps();
        if (!Wait.isSelected() && !finish.isSelected()) {
            validation.validate4();
            return;
        }

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MessageSuccess message = new MessageSuccess();
        String dateDeb = DateF.getText();
        System.out.println(dateDeb);

        String ancienLieu = NumeroC.getSelectedItem().toString();
        String numDepenseText = NumF.getText();
        try {
            int numClient = Integer.parseInt(numDepenseText);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {

            validation.validate1();
            return;
        }

        if (NumF.getText().equals("")) {
            validation.validate1();
        } else if (NumF.getText().startsWith(".") || NumF.getText().startsWith("+") || NumF.getText().startsWith("-") || NumF.getText().startsWith(",") || NumF.getText().startsWith("/") || NumF.getText().startsWith(";")) {
            validation.validate6();
        } else if (DateF.getText().startsWith(".") || DateF.getText().startsWith("+") || DateF.getText().startsWith("-") || DateF.getText().startsWith(",") || DateF.getText().startsWith("/") || DateF.getText().startsWith(";")) {
            validation.validate6();
        } else {
            try {
                String verify = "SELECT COUNT(*) FROM factures WHERE NumeroF = ?";
                prepare = con.prepareStatement(verify);
                prepare.setString(1, NumF.getText());
                resul = prepare.executeQuery();
                int count = 0;
                if (resul.next()) {
                    count = resul.getInt(1);
                }
                resul.close();
                prepare.close();
                if (count > 0) {
//                    JOptionPane.showMessageDialog(null, "Le numero Affectations '" + NumF.getText() + "' est deja existe ");
                    validation.validate5();
                    return;
                } else {

                    boolean employeTrouve = false;  // On ajoute une variable pour vérifier si on trouve un employé correspondant

                    try {
                        String lieuEmp = NumeroC.getSelectedItem().toString();

                        String query = "SELECT C.IDClient, C.NomC, D.MotantD, G.MotantG "
                                + "FROM CLIENTS C "
                                + "JOIN PROJETS P ON C.IDClient = P.NumC_ref "
                                + "JOIN DEPENSES D ON P.IDP = D.NumD_ref "
                                + "JOIN GAINS G ON P.IDP = G.NumD_ref "
                                + "WHERE C.IDClient = ?";

                        prepare = con.prepareStatement(query);
                        prepare.setString(1, lieuEmp);
                        resul = prepare.executeQuery();

                        NumClient = -1;
                        String numeroClient = "";
                        motantD = "";
                        motantG = "";

                        if (resul.next()) {
                            NumClient = resul.getInt("IDClient");
                            numeroClient = resul.getString("NomC");
                            motantD = resul.getString("MotantD");
                            motantG = resul.getString("MotantG");
                            // Le reste du code pour traiter les données si nécessaire
                            employeTrouve = true;
                        }

                        // Convertir les valeurs en types numériques (par exemple, double)
                        DoubleMotantD = Double.parseDouble(motantD);
                        DoubleMotantG = Double.parseDouble(motantG);

                        difference = DoubleMotantG - DoubleMotantD;
                        somme = DoubleMotantG + DoubleMotantD;

                        // créer un objet DecimalFormat pour formater les valeurs
                        DecimalFormat decimalFormat = new DecimalFormat("0.00");

                        // formater les valeurs en décimal
                        formatteddifference = decimalFormat.format(difference);
                        formattedsomme = decimalFormat.format(somme);

                        // afficher les résultats formatés
                        System.out.println("différence : " + formatteddifference);
                        System.out.println("somme : " + formattedsomme);

                        resul.close();
                        prepare.close();

                    } catch (Exception e) {
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

                    String request = "INSERT INTO factures (DateF,NumeroF,MotantTo,Etat,NumC_ref) VALUES ('" + dateDeb + "',?,'" + formatteddifference + "',?,'" + NumClient + "')";

                    prepare = con.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
                    prepare.setString(1, NumF.getText());
//                    prepare.setString(2, MotantT.getText());
                    prepare.setString(2, etat);

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
            //JOptionPane.showMessageDialog(null, "Le numéro d'employé correspondant est : " + variableLieu);
//            JOptionPane.showMessageDialog(null, "Ajout avac succes !!");
            message.setVisible(true);

// Afficher la fenêtre après un délai de 2 secondes (2000 millisecondes)
//            Timer timer = new Timer(2000, e -> {
//                message.setVisible(true);
//            });
//            timer.setRepeats(false); // Ne pas répéter le timer
//            timer.start();
//
//            // Fermer automatiquement la fenêtre après un délai de 5 secondes (5000 millisecondes)
//            Timer closeTimer = new Timer(3000, e -> {
//                message.dispose(); // Fermer la fenêtre
//            });
//            closeTimer.setRepeats(false); // Ne pas répéter le timer
//            closeTimer.start();
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
            System.out.println(motantD + "Lionot Bogosy1");
            System.out.println(motantG + "Lionot Bogosy2");
            System.out.println(somme + "Lionot Bogosy3");
            System.out.println(difference + "Lionot Bogosy4");
            System.out.println(formattedsomme + "Lionot Bogosy5");
            System.out.println(formatteddifference + "Lionot Bogosy6");

        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        this.dispose();
        instant = true;
    }//GEN-LAST:event_btnAnnulerActionPerformed

    public final void CheckValueComboBox() {
        try {
            String request = "SELECT IDClient FROM clients";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            while (resul.next()) {
                NumeroC.addItem(resul.getString("IDClient"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "echec de recuperation");
        }
    }

    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            new AddFacture().setVisible(true);
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
