
package Form;

//Starting
import FenetreModale.AddProject;
import FenetreModale.UpdateProject;
import ModalShow.ShowProjets;
import ShowMessage.MessageSupression;
import com.raven.datechooser.DateChooser;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class Form_2 extends javax.swing.JPanel {
    
     private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();
    
    public static Connection connex = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static String dataProjet;
    
    public Form_2() throws SQLException {
        initComponents();
        connex = connexionDB.DatabaseConnection.connex;
        tableDefault1.fixTable(jScrollPane1);
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setTextField(date1);
        chDate1.setTextField(date2);
        DisplayClient();
    }

    public void Recuperation() {
        try {
            int row = tableDefault1.getSelectedRow();
            if (row != -1) { // Vérifier si une ligne est sélectionnée
                Form_2.dataProjet = (tableDefault1.getModel().getValueAt(row, 0).toString());
                // Reste du code de récupération des données
                String request = "SELECT * FROM projets WHERE IDP='" + dataProjet + "' ";
                prepare = connex.prepareStatement(request);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("IDP");
                    System.out.println(R1);
                    String R2 = resul.getString("NomP");
                    System.out.println(R2);
                    String R3 = resul.getString("DescrP");
                    System.out.println(R3);
                    String R4 = resul.getString("Status");
                    System.out.println(R4);
                    String R5 = resul.getString("DateDP");
                    System.out.println(R5);
                    String R6 = resul.getString("DateFP");
                    System.out.println(R6);
                    String R7 = resul.getString("NumC_ref");
                    System.out.println(R7);
                    //recupere.setText(R1);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public String GetTableResult() {
        return dataProjet;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing_Home.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDefault1 = new swing_Home.table.TableDefault();
        EditModal = new menu.MenuItem();
        ModalAjout = new menu.MenuItem();
        DeleteProjet = new menu.MenuItem();
        date1 = new swing_Dialog.TextField();
        date2 = new swing_Dialog.TextField();
        BtnSearch = new swing_Dialog.Button();
        Search = new menu.MenuItem();
        showProjet = new menu.MenuItem();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(20);

        tableDefault1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nom", "Description", "Status", "Date debut", "Date Fin", "Numero Client"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDefault1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDefault1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDefault1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDefault1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        EditModal.setBackground(new java.awt.Color(94, 241, 241));
        EditModal.setForeground(new java.awt.Color(102, 102, 102));
        EditModal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/edit-folder-64.png"))); // NOI18N
        EditModal.setText("menuItem1");
        EditModal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditModalActionPerformed(evt);
            }
        });

        ModalAjout.setBackground(new java.awt.Color(94, 241, 241));
        ModalAjout.setForeground(new java.awt.Color(102, 102, 102));
        ModalAjout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/add-folder-64.png"))); // NOI18N
        ModalAjout.setText("menuItem1");
        ModalAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModalAjoutActionPerformed(evt);
            }
        });

        DeleteProjet.setBackground(new java.awt.Color(94, 241, 241));
        DeleteProjet.setForeground(new java.awt.Color(102, 102, 102));
        DeleteProjet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/delete-folder-64.png"))); // NOI18N
        DeleteProjet.setText("menuItem1");
        DeleteProjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProjetActionPerformed(evt);
            }
        });

        date1.setLabelText("Date Debut");
        date1.setLineColor(new java.awt.Color(200, 39, 228));

        date2.setLabelText("Date Fin");
        date2.setLineColor(new java.awt.Color(200, 39, 228));

        BtnSearch.setText("Recherche");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        Search.setBackground(new java.awt.Color(94, 241, 241));
        Search.setForeground(new java.awt.Color(102, 102, 102));
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/synchronize.png"))); // NOI18N
        Search.setText("menuItem1");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        showProjet.setBackground(new java.awt.Color(94, 241, 241));
        showProjet.setForeground(new java.awt.Color(102, 102, 102));
        showProjet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/folder-100.png"))); // NOI18N
        showProjet.setText("menuItem1");
        showProjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showProjetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ModalAjout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EditModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(367, 367, 367)
                                .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addGap(28, 28, 28)
                                .addComponent(date2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModalAjout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableDefault1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseClicked
        Recuperation();
    }//GEN-LAST:event_tableDefault1MouseClicked

    private void tableDefault1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseReleased
        DeleteProjet.setEnabled(true);
        EditModal.setEnabled(true);
        showProjet.setEnabled(true);
    }//GEN-LAST:event_tableDefault1MouseReleased

    private void EditModalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditModalActionPerformed
        try {
            UpdateProject edit = new UpdateProject();
            edit.setVisible(true);
            edit.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (edit.isInstant()) {
                        try {
                            DisplayClient();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EditModalActionPerformed

    private void ModalAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModalAjoutActionPerformed
        AddProject ajoutClient;
        try {
            ajoutClient = new AddProject();
            ajoutClient.setVisible(true);
        ajoutClient.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (ajoutClient.isInstant()) {
                    try {
                        DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        } catch (ParseException ex) {
            Logger.getLogger(Form_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ModalAjoutActionPerformed

    private void DeleteProjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProjetActionPerformed
       try {
           MessageSupression message = new MessageSupression();
            String R1 = resul.getString("IDP");
            if (JOptionPane.showConfirmDialog(null, "Attention vous voulez vraiment supprimer projet ?",
                    "Supprimer client", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (R1.length() != 0) {
                    String request = "DELETE FROM projets WHERE IDP = ?";
                    //String request = "DELETE FROM affectations WHERE AncienLieu IN (SELECT lieu FROM employes WHERE numEmp = ?)";
                    //String R1 = resul.getString("numEmp");
                    prepare = connex.prepareStatement(request);
                    prepare.setString(1, R1);
                    prepare.execute();
                    System.out.println("Suppression avec succes");
                    
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
                }
            } else {
                JOptionPane.showMessageDialog(null, "Veullez selectionner projet");
            }
            DisplayClient();

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        //bouton non clickable
    }//GEN-LAST:event_DeleteProjetActionPerformed

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        if (date1.getText() == null) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs date debut");
        } else if (date2.getText() == null) {
            JOptionPane.showMessageDialog(null, "Veuiller remplir le champs date fin");
        } else {
            String dateDebut = date1.getText();
            System.out.println(dateDebut);
            System.out.println(dateDebut);

            String dateFin = date2.getText();
            System.out.println(dateFin);
            System.out.println(dateFin);
            try {
                String request = "SELECT IDP AS \"N°Projet\",NomP AS \"Nom Projet\",DescrP AS \"Description\",Status AS \"Status\",\n"
                    + "DateDP AS \"Date Debut\",DateFP AS \"Date Fin\",NumC_ref AS \"N° Client\" FROM projets WHERE DateDP BETWEEN ?::date AND ?::date OR DateFP BETWEEN ?::date AND ?::date";
//                String request = "SELECT numAffect AS \"N° AFFECTATION\",AncienLieu AS \"ANCIEN LIEU\",NouveauLieu AS \"NOUVEAU LIEU\",dateServices AS \"DATE SERVICE\",dateAffect AS \"DATE AFFECTATION\" FROM affectations WHERE dateServices BETWEEN ?::date AND ?::date OR dateAffect BETWEEN ?::date AND ?::date";
                prepare = connex.prepareStatement(request);
                prepare.setString(1, dateDebut);
                prepare.setString(2, dateFin);
                prepare.setString(3, dateDebut);
                prepare.setString(4, dateFin);
                resul = prepare.executeQuery();
                tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));

//                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//                centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
//
//                for (int i = 0; i < tableDefault1.getColumnCount(); i++) {
//                    tableDefault1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
//                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_BtnSearchActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
         try {
             DisplayClient();
         } catch (SQLException ex) {
             Logger.getLogger(Form_2.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_SearchActionPerformed

    private void showProjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showProjetActionPerformed
       ShowProjets ajoutClient;
        try {
            ajoutClient = new ShowProjets();
            ajoutClient.setVisible(true);
        ajoutClient.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (ajoutClient.isInstant()) {
                    try {
                        DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        } catch (SQLException ex) {
             Logger.getLogger(Form_2.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_showProjetActionPerformed

     public final void DisplayClient() throws SQLException {
        try {
            String request = "SELECT IDP AS \"N°Projet\",NomP AS \"Nom Projet\",DescrP AS \"Description\",Status AS \"Status\",\n"
                    + "DateDP AS \"Date Debut\",DateFP AS \"Date Fin\",NumC_ref AS \"N° Client\" FROM projets ORDER BY IDP ASC";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));
            EditModal.setEnabled(false);
            DeleteProjet.setEnabled(false);
            showProjet.setEnabled(false);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_Dialog.Button BtnSearch;
    private menu.MenuItem DeleteProjet;
    private menu.MenuItem EditModal;
    private menu.MenuItem ModalAjout;
    private menu.MenuItem Search;
    private swing_Dialog.TextField date1;
    private swing_Dialog.TextField date2;
    private javax.swing.JScrollPane jScrollPane1;
    private swing_Home.RoundPanel roundPanel1;
    private menu.MenuItem showProjet;
    private swing_Home.table.TableDefault tableDefault1;
    // End of variables declaration//GEN-END:variables
}
