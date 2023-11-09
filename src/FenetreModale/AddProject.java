package FenetreModale;

// Starting
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public final class AddProject extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    String A1;
    int NumClient;

    public String status;
    static boolean instant;

    String projet1 = "Veuillez sélectionner un status de projet.";

    String projet2 = "Veuillez saisir un numéro de valide (chiffres uniquement).";

    String projet3 = "Veuillez remplir le champ numero";

    String projet4 = "Veuillez remplir le champ nom";

    String projet5 = "Veuillez remplir le champ de la description";

    String projet6 = "Le numero de client est deja existe.Veuillez saisir une autre numero.";

    String projet7 = "Ce champ ne dois pas commencer par les symboles '+', '-', ou ','.";

    public AddProject() throws ParseException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(dateDebut);
        chDate1.setTextField(DateFin);
        CheckValueComboBox();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
        
        DateFin.setOpaque(false);
        DescP.setOpaque(false);
        NomP.setOpaque(false);
        NumP.setOpaque(false);
        NumeroC.setOpaque(false);
        dateDebut.setOpaque(false);
    }

    public String getProjet1() {
        return projet1;
    }

    public String getProjet2() {
        return projet2;
    }

    public String getProjet3() {
        return projet3;
    }

    public String getProjet4() {
        return projet4;
    }

    public String getProjet5() {
        return projet5;
    }

    public String getProjet6() {
        return projet6;
    }

    public String getProjet7() {
        return projet7;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupeMagaReo = new javax.swing.ButtonGroup();
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
        buttonOutLine2 = new swing.ButtonOutLine();
        buttonOutLine1 = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumP.setLabelText("Numero ");
        NumP.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumP, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 17, 278, -1));

        NomP.setLabelText("Nom");
        NomP.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NomP, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 278, -1));

        DescP.setLabelText("Description");
        DescP.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DescP, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 159, 278, -1));

        dateDebut.setBackground(new java.awt.Color(255, 255, 255));
        dateDebut.setLabelText("Date Debut");
        dateDebut.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(dateDebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 230, 278, -1));

        DateFin.setBackground(new java.awt.Color(255, 255, 255));
        DateFin.setLabelText("Date Fin");
        DateFin.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(DateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 301, 278, -1));

        NumeroC.setLabeText("Numero Client");
        NumeroC.setLineColor(new java.awt.Color(200, 39, 228));
        panelShadow1.add(NumeroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 366, 278, 54));

        ending.setBackground(new java.awt.Color(255, 255, 255));
        GroupeMagaReo.add(ending);
        ending.setText(" terminé");
        ending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endingActionPerformed(evt);
            }
        });
        panelShadow1.add(ending, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 426, 77, -1));

        running.setBackground(new java.awt.Color(255, 255, 255));
        GroupeMagaReo.add(running);
        running.setText("en cours");
        running.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runningActionPerformed(evt);
            }
        });
        panelShadow1.add(running, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 80, -1));

        starting.setBackground(new java.awt.Color(255, 255, 255));
        GroupeMagaReo.add(starting);
        starting.setText("Débute");
        starting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startingActionPerformed(evt);
            }
        });
        panelShadow1.add(starting, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 426, 70, -1));

        buttonOutLine2.setBackground(new java.awt.Color(220, 27, 27));
        buttonOutLine2.setForeground(new java.awt.Color(220, 27, 27));
        buttonOutLine2.setText("Annuler");
        buttonOutLine2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine2ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 102, -1));

        buttonOutLine1.setBackground(new java.awt.Color(200, 39, 228));
        buttonOutLine1.setForeground(new java.awt.Color(200, 39, 228));
        buttonOutLine1.setText("Ajouter");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 98, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }
    private void endingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endingActionPerformed
        status = "terminer";
    }//GEN-LAST:event_endingActionPerformed

    private void startingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startingActionPerformed
        status = "Débute";
    }//GEN-LAST:event_startingActionPerformed

    private void runningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runningActionPerformed
        status = "en cours";
    }//GEN-LAST:event_runningActionPerformed

    private void buttonOutLine2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine2ActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_buttonOutLine2ActionPerformed

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        // Vérifier si aucun radiobutton n'est sélectionné
        MessageValidationChamps validation = new MessageValidationChamps();
        if (!starting.isSelected() && !running.isSelected() && !ending.isSelected()) {
            try {
                validation.validt1();
                return;
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MessageSuccess message = new MessageSuccess();
        String dateDeb = dateDebut.getText();
        System.out.println(dateDeb);

        String dateFin = DateFin.getText();
        System.out.println(dateFin);

        String ancienLieu = NumeroC.getSelectedItem().toString();

//        Starting validation
        String numDepenseText = NumP.getText();
//        Ending

        try {
            int numClient = Integer.parseInt(numDepenseText);
            // Si la conversion en int réussit, c'est un nombre valide.
        } catch (NumberFormatException e) {
            try {
                validation.validt2();
                return;
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (NumP.getText().equals("")) {
            try {
                validation.validt3();
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (NomP.getText().equals("")) {
            try {
                validation.validt4();
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (DescP.getText().equals("")) {
            try {
                validation.validt5();
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (dateDebut.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs de la date debut");
        } else if (DateFin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs de la date fin");
        } else if (NumP.getText().startsWith(".") || NumP.getText().startsWith("+") || NumP.getText().startsWith("-") || NumP.getText().startsWith(",") || NumP.getText().startsWith("/") || NumP.getText().startsWith(";")) {
            try {
                validation.validt7();
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (NomP.getText().startsWith(".") || NomP.getText().startsWith("+") || NomP.getText().startsWith("-") || NomP.getText().startsWith(",") || NomP.getText().startsWith("/") || NomP.getText().startsWith(";")) {
            try {
                validation.validt7();
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (DescP.getText().startsWith(".") || DescP.getText().startsWith("+") || DescP.getText().startsWith("-") || DescP.getText().startsWith(",") || DescP.getText().startsWith("/") || DescP.getText().startsWith(";")) {
            try {
                validation.validt7();
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                String verify = "SELECT COUNT(*) FROM projets WHERE IDP = ?";
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
//                    JOptionPane.showMessageDialog(null, "Le numero Affectations '" + NumP.getText() + "' est deja existe ");
                    validation.validt6();
                    return;
                } else {

                    boolean employeTrouve = false;  // On ajoute une variable pour vérifier si on trouve un employé correspondant

                    try {
                        String lieuEmp = NumeroC.getSelectedItem().toString();
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

                    String request = "INSERT INTO projets (IDP,NomP,DescrP,Status,DateDP,DateFP,NumC_ref) VALUES (?,?,?,?,'" + dateDeb + "','" + dateFin + "','" + NumClient + "')";

                    prepare = con.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
                    prepare.setString(1, NumP.getText());
                    prepare.setString(2, NomP.getText());
                    prepare.setString(3, DescP.getText());
                    prepare.setString(4, status);

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
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
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

    public void CheckValueComboBox() {
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
            try {
                new AddProject().setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_Dialog.TextField DateFin;
    private swing_Dialog.TextField DescP;
    private javax.swing.ButtonGroup GroupeMagaReo;
    private swing_Dialog.TextField NomP;
    private swing_Dialog.TextField NumP;
    private composant.combobox.Combobox NumeroC;
    private swing.ButtonOutLine buttonOutLine1;
    private swing.ButtonOutLine buttonOutLine2;
    private swing_Dialog.TextField dateDebut;
    private composant.radio_button.RadioButtonCustom ending;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    private composant.radio_button.RadioButtonCustom running;
    private composant.radio_button.RadioButtonCustom starting;
    // End of variables declaration//GEN-END:variables
}
