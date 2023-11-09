
package Form;

//Starting
import FenetreModale.AddGains;
import FenetreModale.UpdateGains;
import ModalShow.ShowGains;
import Model_Card.Model_Card_2;
import ShowMessage.MessageSupression;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending


public final class Form_7 extends javax.swing.JPanel {

    public static Connection connex = null;
    public static java.sql.ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static String dataDepense;
    String Total = null;
    String Depense = null;
    public Form_7() throws SQLException {
        initComponents();
        connex = connexionDB.DatabaseConnection.connex;
        tableDefault1.fixTable(jScrollPane1);
        DisplayClient();
        GetGainData();
        GetTotalData();
        GetValues();
    }

    public void Recuperation() {
        try {
            int row = tableDefault1.getSelectedRow();
            if (row != -1) { // Vérifier si une ligne est sélectionnée
                Form_7.dataDepense = (tableDefault1.getModel().getValueAt(row, 0).toString());
                // Reste du code de récupération des données
                String request = "SELECT * FROM gains WHERE IDG='" + dataDepense + "' ";
                prepare = connex.prepareStatement(request);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("IDG");
                    System.out.println(R1);
                    String R2 = resul.getString("DescrG");
                    System.out.println(R2);
                    String R3 = resul.getString("MotantG");
                    System.out.println(R3);
                    String R4 = resul.getString("DateG");
                    System.out.println(R4);
                    String R5 = resul.getString("NumD_ref");
                    System.out.println(R5);
                    //recupere.setText(R1);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public String GetTableResult() {
        return dataDepense;
    }
    
    
    
    public void GetGainData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = "SELECT COUNT(*) as nombre_gain FROM gains";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    Depense = resul.getString("nombre_gain");
                    System.out.println(Depense);
//                    totalProjet.setxt(R1);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    public void GetTotalData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = "SELECT SUM(CAST(MotantG AS DECIMAL(30, 2))) as somme_gain FROM GAINS";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    Total = resul.getString("somme_gain");
                    if (Total == null) {
                        Total = "0";
                    }
                    System.out.println(Total + " Ar");
//                    totalProjet.setxt(R1);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    private void GetValues() {
        var icon1 = new ImageIcon(getClass().getResource("/icon/chart.png")); // Remplacez "chemin_vers_votre_image.png" par le chemin de votre fichier d'icône
        var icon2 = new ImageIcon(getClass().getResource("/icon/invoice.png")); // Remplacez "chemin_vers_votre_image.png" par le chemin de votre fichier d'icône

        Card_1.setData(new Model_Card_2(icon1, "Montant total des gains", Total + " Ariary", " Utilisateur(s)", "Effetif utilisateur(s)"));
        Card_2.setData(new Model_Card_2(icon2, "Nombre de gains effectives", Depense + " Depense(s)", " Utilisateur(s)", "Effetif utilisateur(s)"));

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Card_1 = new Card_3.Cards_2();
        Card_2 = new Card_3.Cards_2();
        Actualise = new menu.MenuItem();
        BtnAjouteModale = new menu.MenuItem();
        ShowDepense = new menu.MenuItem();
        BtnDelete = new menu.MenuItem();
        BtnUpdateModale = new menu.MenuItem();
        roundPanel1 = new swing_Home.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDefault1 = new swing_Home.table.TableDefault();

        Actualise.setForeground(new java.awt.Color(0, 255, 255));
        Actualise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/synchronize.png"))); // NOI18N
        Actualise.setText("menuItem1");
        Actualise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualiseActionPerformed(evt);
            }
        });

        BtnAjouteModale.setForeground(new java.awt.Color(0, 255, 255));
        BtnAjouteModale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/add-folder-64.png"))); // NOI18N
        BtnAjouteModale.setText("menuItem1");
        BtnAjouteModale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouteModaleActionPerformed(evt);
            }
        });

        ShowDepense.setForeground(new java.awt.Color(0, 255, 255));
        ShowDepense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/folder-100.png"))); // NOI18N
        ShowDepense.setText("menuItem1");
        ShowDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowDepenseActionPerformed(evt);
            }
        });

        BtnDelete.setForeground(new java.awt.Color(0, 255, 255));
        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/delete-folder-64.png"))); // NOI18N
        BtnDelete.setText("menuItem1");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnUpdateModale.setForeground(new java.awt.Color(0, 255, 255));
        BtnUpdateModale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/edit-folder-64.png"))); // NOI18N
        BtnUpdateModale.setText("menuItem1");
        BtnUpdateModale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateModaleActionPerformed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(20);

        tableDefault1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Description de la dépense", "Motant de la depense", "Date de la dépense ", "Numero Projet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Actualise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnAjouteModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(ShowDepense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BtnUpdateModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Card_1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(Card_2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Card_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Card_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShowDepense, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BtnAjouteModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnUpdateModale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Actualise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ActualiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualiseActionPerformed
        try {
            DisplayClient();
        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualiseActionPerformed

    private void BtnAjouteModaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouteModaleActionPerformed
        AddGains depense = new AddGains();
        depense.setVisible(true);
        depense.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (depense.isInstant()) {
                    try {
                        DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_BtnAjouteModaleActionPerformed

    private void ShowDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowDepenseActionPerformed
        try {
            ShowGains depense = new ShowGains();
            depense.setVisible(true);
            depense.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (depense.isInstant()) {
                        try {
                            DisplayClient();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ShowDepenseActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        try {
            MessageSupression message = new MessageSupression();
            String R1 = resul.getString("IDG");
            if (JOptionPane.showConfirmDialog(null, "Attention vous voulez vraiment supprimer gain ?",
                "Supprimer gain", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            if (R1.length() != 0) {
                String request = "DELETE FROM gains WHERE IDG = ?";
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
            JOptionPane.showMessageDialog(null, "Veullez selectionner gains");
        }
        DisplayClient();

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnUpdateModaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateModaleActionPerformed
        try {
            UpdateGains depense = new UpdateGains();
            depense.setVisible(true);
            depense.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (depense.isInstant()) {
                        try {
                            DisplayClient();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnUpdateModaleActionPerformed

    private void tableDefault1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseClicked
        Recuperation();
    }//GEN-LAST:event_tableDefault1MouseClicked

    private void tableDefault1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseReleased
        BtnDelete.setEnabled(true);
        BtnUpdateModale.setEnabled(true);
        ShowDepense.setEnabled(true);
    }//GEN-LAST:event_tableDefault1MouseReleased


    public final void DisplayClient() throws SQLException {
        try {
            String request = "SELECT IDG AS \"N° GAIN\",DescrG AS \"Description de la gain\",\n"
                    + "MotantG AS \"Montant de la gain\",DateG AS \"Date de la Gain\",NumD_ref AS \"N° Projet\" FROM gains ORDER BY IDG ASC";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));
            BtnDelete.setEnabled(false);
            BtnUpdateModale.setEnabled(false);
            ShowDepense.setEnabled(false);
            GetGainData();
            GetTotalData();
            GetValues();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menu.MenuItem Actualise;
    private menu.MenuItem BtnAjouteModale;
    private menu.MenuItem BtnDelete;
    private menu.MenuItem BtnUpdateModale;
    private Card_3.Cards_2 Card_1;
    private Card_3.Cards_2 Card_2;
    private menu.MenuItem ShowDepense;
    private javax.swing.JScrollPane jScrollPane1;
    private swing_Home.RoundPanel roundPanel1;
    private swing_Home.table.TableDefault tableDefault1;
    // End of variables declaration//GEN-END:variables
}
