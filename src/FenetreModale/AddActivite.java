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

public final class AddActivite extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static boolean instant;
    String A1;
    int NumActiv;
    String teste = "Veuillez saisir un numéro valide (chiffres uniquement).";

    String teste1 = "Veuillez remplir le champ de la description.";

    String teste2 = "Ce champ ne doit pas commencer par les symboles '+', '-', ou ','.";

    String teste3 = "Le numéro d'activité existe déjà.";

    public AddActivite() {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
//        setBackground(new Color(0,0,0,0));
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(dateDebutA);
        chDate1.setTextField(DateFinA);
//        setBackground(new Color(0,0,0,0));
        CheckValueComboBox();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
        DateFinA.setOpaque(false);
        Description.setOpaque(false);
        NumActivite.setOpaque(false);
        dateDebutA.setOpaque(false);
        NumeroA.setOpaque(false);
    }

    public String getCoucou() {
        return teste;
    }

    public String getCoucou1() {
        return teste1;
    }

    public String getCoucou2() {
        return teste2;
    }

    public String getCoucou3() {
        return teste3;
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
        BtnAjouterClient = new swing.ButtonOutLine();
        BtnAnnileClient = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumActivite.setLabelText("Numéro d'activité");
        NumActivite.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumActivite, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 28, 307, -1));

        Description.setLabelText("Description");
        Description.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 105, 307, 75));

        dateDebutA.setBackground(new java.awt.Color(255, 255, 255));
        dateDebutA.setLabelText("Date de début");
        dateDebutA.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(dateDebutA, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 198, 307, -1));

        DateFinA.setBackground(new java.awt.Color(255, 255, 255));
        DateFinA.setLabelText("Date de fin");
        DateFinA.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DateFinA, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 275, 307, -1));

        NumeroA.setLabeText("Numéro de projet");
        NumeroA.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 352, 307, 57));

        BtnAjouterClient.setBackground(new java.awt.Color(200, 39, 228));
        BtnAjouterClient.setForeground(new java.awt.Color(200, 39, 228));
        BtnAjouterClient.setText("Ajouter");
        BtnAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouterClientActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAjouterClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 96, 34));

        BtnAnnileClient.setBackground(new java.awt.Color(220, 27, 27));
        BtnAnnileClient.setForeground(new java.awt.Color(220, 27, 27));
        BtnAnnileClient.setText("Annuler");
        BtnAnnileClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnileClientActionPerformed(evt);
            }
        });
        panelShadow1.add(BtnAnnileClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 101, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
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
        MessageSuccess message = new MessageSuccess();
        MessageValidationChamps validation = new MessageValidationChamps();
        String dateDeb = dateDebutA.getText();
        System.out.println(dateDeb);

        String dateFin = DateFinA.getText();
        System.out.println(dateFin);

//        Starting validation
        String numClientText = NumActivite.getText();
//        Ending
//        teste3 = "Le numero Activite '" + NumActivite.getText() + "' est deja existe ";

        try {
            int numPhone = Integer.parseInt(numClientText);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
            validation.valide1();
            return;
        }

        if (NumActivite.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir le champ numéro.");
        } else if (Description.getText().equals("")) {
            validation.valide2();
        } else if (dateDebutA.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs de la date debut");
        } else if (DateFinA.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs de la date fin");

        } else if (NumActivite.getText().startsWith(".") || NumActivite.getText().startsWith("+") || NumActivite.getText().startsWith("-") || NumActivite.getText().startsWith(",") || NumActivite.getText().startsWith("/") || NumActivite.getText().startsWith(";")) {
//            JOptionPane.showMessageDialog(null, "Le numero du affectation ne peut pas commencer par les symboles '+', '-', ou ','");
            validation.valide3();
        } else if (Description.getText().startsWith(".") || Description.getText().startsWith("+") || Description.getText().startsWith("-") || Description.getText().startsWith(",") || Description.getText().startsWith("/") || Description.getText().startsWith(";")) {
//            JOptionPane.showMessageDialog(null, "Le nouveau lieu du affectation ne peut pas commencer par les symboles '+', '-', ou ','");
            validation.valide3();
        } else if (dateDebutA.getText().startsWith(".") || dateDebutA.getText().startsWith("+") || dateDebutA.getText().startsWith("-") || dateDebutA.getText().startsWith(",") || dateDebutA.getText().startsWith("/") || dateDebutA.getText().startsWith(";")) {
            JOptionPane.showMessageDialog(null, "Le nouveau lieu du affectation ne peut pas commencer par les symboles '+', '-', ou ','");
        } else if (DateFinA.getText().startsWith(".") || DateFinA.getText().startsWith("+") || DateFinA.getText().startsWith("-") || DateFinA.getText().startsWith(",") || DateFinA.getText().startsWith("/") || DateFinA.getText().startsWith(";")) {
            JOptionPane.showMessageDialog(null, "Le nouveau lieu du affectation ne peut pas commencer par les symboles '+', '-', ou ','");
        } else {
            try {
                String verify = "SELECT COUNT(*) FROM activites WHERE IDA = ?";
                prepare = con.prepareStatement(verify);
                prepare.setString(1, NumActivite.getText());
                resul = prepare.executeQuery();
                int count = 0;
                if (resul.next()) {
                    count = resul.getInt(1);
                }
                resul.close();
                prepare.close();
                if (count > 0) {
//                    JOptionPane.showMessageDialog(null, "Le numero Activite '" + NumActivite.getText() + "' est deja existe ");
                    validation.valide4();
                    return;
                } else {

                    boolean employeTrouve = false;  // On ajoute une variable pour vérifier si on trouve un employé correspondant

                    try {
                        String lieuEmp = NumeroA.getSelectedItem().toString();
                        String query = "SELECT IDP, NomP FROM projets WHERE IDP = ?";
                        prepare = con.prepareStatement(query);
                        prepare.setString(1, lieuEmp);
                        resul = prepare.executeQuery();
                        NumActiv = -1;
                        String numeroClient = "";

                        if (resul.next()) {
                            NumActiv = resul.getInt("IDP");
                            numeroClient = resul.getString("NomP");
                            //JOptionPane.showMessageDialog(null, "Le numéro d'employé est : " + numEmp);
                            employeTrouve = true;  // On met employeTrouve à true si on trouve un employé correspondant
                        }

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

                    String query = "SELECT NomP FROM projets WHERE IDP = '" + NumActiv + "'";
                    prepare = con.prepareStatement(query);
                    resul = prepare.executeQuery();

                    if (resul.next()) {
                        A1 = resul.getString("NomP");
                        System.out.println(A1);
                        //JOptionPane.showMessageDialog(null, "lieu est" +A1);
                    }

                    String request = "INSERT INTO activites (IDA,DescrA,DateDA,DateFA,NumA_ref) VALUES (?,?,'" + dateDeb + "','" + dateFin + "','" + NumActiv + "')";

                    prepare = con.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
                    prepare.setString(1, NumActivite.getText());
                    prepare.setString(2, Description.getText());

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
    }//GEN-LAST:event_BtnAjouterClientActionPerformed

    public void CheckValueComboBox() {
        try {
            String request = "SELECT IDP FROM projets";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            while (resul.next()) {
                NumeroA.addItem(resul.getString("IDP"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Échec de la récupération.");
        }
    }

    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            new AddActivite().setVisible(true);
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
