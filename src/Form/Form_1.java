package Form;

import FenetreModale.AddClient;
import FenetreModale.UpdateClient;
import ModalShow.ShowClients;
import ShowMessage.MessageSupression;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;

public class Form_1 extends javax.swing.JPanel {

    public static Connection connex = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static String dataClient;

    public Form_1() throws SQLException {
        initComponents();
        connex = connexionDB.DatabaseConnection.connex;
//        tableDefault1.fixTable(jScrollPane1);
        DisplayClient();
        init();
        rechercheClient.setOpaque(false);
        rechercheClient.setBackground(new Color(242, 242, 242));
    }

    private void init() {
        tableDefault1.fixTable(jScrollPane1);
    }

    public void Recuperation() {
        try {
            int row = tableDefault1.getSelectedRow();
            if (row != -1) { // Vérifier si une ligne est sélectionnée
                Form_1.dataClient = (tableDefault1.getModel().getValueAt(row, 0).toString());
                // Reste du code de récupération des données
                String request = "SELECT * FROM clients WHERE IDClient='" + dataClient + "' ";
                prepare = connex.prepareStatement(request);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("IDClient");
                    System.out.println(R1);
                    String R2 = resul.getString("NomC");
                    System.out.println(R2);
                    String R3 = resul.getString("PrenomC");
                    System.out.println(R3);
                    String R4 = resul.getString("AdresseC");
                    System.out.println(R4);
                    String R5 = resul.getString("AdresseC");
                    System.out.println(R5);
                    String R6 = resul.getString("NumeroC");
                    System.out.println(R6);
                    String R7 = resul.getString("EmailC");
                    System.out.println(R7);
                    //recupere.setText(R1);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //recuperer le donnee de la table

    public String GetTableResult() {
        return dataClient;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing_Home.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDefault1 = new swing_Home.table.TableDefault();
        rechercheClient = new swing_Dialog.TextField();
        BtnDeleteC = new menu.MenuItem();
        BtnUpdateModal = new menu.MenuItem();
        ModalAdd = new menu.MenuItem();
        Actualiser = new menu.MenuItem();
        ShowClient = new menu.MenuItem();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        tableDefault1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N CLIENT", "NOM CLIENT", "PRENOM CLIENT", "ADRESSE", "CONTACT", "COURRIEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );

        rechercheClient.setLabelText("Recherche (nom ou prenom)");
        rechercheClient.setLineColor(new java.awt.Color(200, 39, 228));
        rechercheClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechercheClientKeyReleased(evt);
            }
        });

        BtnDeleteC.setBackground(new java.awt.Color(81, 81, 249));
        BtnDeleteC.setForeground(new java.awt.Color(17, 200, 131));
        BtnDeleteC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/delete-folder-64.png"))); // NOI18N
        BtnDeleteC.setText("menuItem1");
        BtnDeleteC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteCActionPerformed(evt);
            }
        });

        BtnUpdateModal.setBackground(new java.awt.Color(81, 81, 249));
        BtnUpdateModal.setForeground(new java.awt.Color(17, 200, 131));
        BtnUpdateModal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/edit-folder-64.png"))); // NOI18N
        BtnUpdateModal.setText("menuItem2");
        BtnUpdateModal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateModalActionPerformed(evt);
            }
        });

        ModalAdd.setBackground(new java.awt.Color(81, 81, 249));
        ModalAdd.setForeground(new java.awt.Color(17, 200, 131));
        ModalAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/add-folder-64.png"))); // NOI18N
        ModalAdd.setText("menuItem3");
        ModalAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModalAddActionPerformed(evt);
            }
        });

        Actualiser.setBackground(new java.awt.Color(81, 81, 249));
        Actualiser.setForeground(new java.awt.Color(17, 200, 131));
        Actualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/synchronize.png"))); // NOI18N
        Actualiser.setText("menuItem1");
        Actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualiserActionPerformed(evt);
            }
        });

        ShowClient.setBackground(new java.awt.Color(81, 81, 249));
        ShowClient.setForeground(new java.awt.Color(17, 200, 131));
        ShowClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/folder-100.png"))); // NOI18N
        ShowClient.setText("menuItem1");
        ShowClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(350, 350, 350)
                                .addComponent(rechercheClient, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ModalAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShowClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnDeleteC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnUpdateModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rechercheClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShowClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModalAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDeleteC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnUpdateModal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rechercheClientKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheClientKeyReleased
        String search = rechercheClient.getText().trim().toLowerCase();
        String request = "SELECT IDClient AS \"N° CLIENT\",NomC AS \"NOM\",PrenomC AS \"PRENOM\",AdresseC AS \"ADRESSE\",NumeroC AS \"N° TELEPHONE\",EmailC AS \"EMAIL\" FROM clients WHERE LOWER(NomC) LIKE ? OR LOWER(PrenomC) LIKE ?";
        try {
            prepare = connex.prepareStatement(request);
            prepare.setString(1, "%" + search + "%");
            prepare.setString(2, "%" + search + "%");
            resul = prepare.executeQuery();
            tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));
            
            BtnUpdateModal.setEnabled(false);
            BtnDeleteC.setEnabled(false);
            ShowClient.setEnabled(false);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_rechercheClientKeyReleased

    private void ModalAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModalAddActionPerformed
        AddClient ajoutClient = new AddClient();
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
    }//GEN-LAST:event_ModalAddActionPerformed

    private void BtnUpdateModalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateModalActionPerformed
        try {
            UpdateClient updateclient = new UpdateClient();
            updateclient.setVisible(true);
            updateclient.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (updateclient.isInstant()) {
                        try {
                            DisplayClient();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnUpdateModalActionPerformed

    private void BtnDeleteCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteCActionPerformed
        try {
            MessageSupression message = new MessageSupression();
            String R1 = resul.getString("IDClient");
            if (JOptionPane.showConfirmDialog(null, "Attention vous voulez vraiment supprimer client?",
                    "Supprimer client", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (R1.length() != 0) {
                    String request = "DELETE FROM clients WHERE IDClient = ?";
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
                JOptionPane.showMessageDialog(null, "Veullez selectionner client ");
            }
            DisplayClient();

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_BtnDeleteCActionPerformed

    private void tableDefault1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseClicked
        Recuperation();
    }//GEN-LAST:event_tableDefault1MouseClicked

    private void tableDefault1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseReleased
        BtnUpdateModal.setEnabled(true);
        BtnDeleteC.setEnabled(true);
        ShowClient.setEnabled(true);
    }//GEN-LAST:event_tableDefault1MouseReleased

    private void ActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualiserActionPerformed
        try {
            DisplayClient();
        } catch (SQLException ex) {
            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualiserActionPerformed

    private void ShowClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowClientActionPerformed
        try {
            ShowClients Showclient = new ShowClients();
            Showclient.setVisible(true);
            Showclient.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (Showclient.isInstant()) {
                        try {
                            DisplayClient();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ShowClientActionPerformed

    public final void DisplayClient() throws SQLException {
        try {
            String request = "SELECT IDClient AS \"N° CLIENT\",NomC AS \"NOM\",PrenomC AS \"PRENOM\",AdresseC AS \"ADRESSE\",NumeroC AS \"N° TELEPHONE\",EmailC AS \"EMAIL\" FROM clients ORDER BY IDClient ASC";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));
            BtnUpdateModal.setEnabled(false);
            BtnDeleteC.setEnabled(false);
            ShowClient.setEnabled(false);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menu.MenuItem Actualiser;
    private menu.MenuItem BtnDeleteC;
    private menu.MenuItem BtnUpdateModal;
    private menu.MenuItem ModalAdd;
    private menu.MenuItem ShowClient;
    private javax.swing.JScrollPane jScrollPane1;
    private swing_Dialog.TextField rechercheClient;
    private swing_Home.RoundPanel roundPanel1;
    private swing_Home.table.TableDefault tableDefault1;
    // End of variables declaration//GEN-END:variables
}
