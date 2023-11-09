package Form;

//Starting
import FenetreModale.AddDepense;
import FenetreModale.UpdateDepense;
import ModalShow.ShowDepense;
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

public final class Form_4 extends javax.swing.JPanel {

    public static Connection connex = null;
    public static java.sql.ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static String dataDepense;
    String Total = null;
    String Depense = null;

    public Form_4() throws SQLException {
        initComponents();
        connex = connexionDB.DatabaseConnection.connex;
        tableDefault1.fixTable(jScrollPane1);
        DisplayClient();
        GetDepenseData();
        GetTotalData();
        GetValues();
    }

    public void Recuperation() {
        try {
            int row = tableDefault1.getSelectedRow();
            if (row != -1) { // Vérifier si une ligne est sélectionnée
                Form_4.dataDepense = (tableDefault1.getModel().getValueAt(row, 0).toString());
                // Reste du code de récupération des données
                String request = "SELECT * FROM depenses WHERE IDD='" + dataDepense + "' ";
                prepare = connex.prepareStatement(request);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("IDD");
                    System.out.println(R1);
                    String R2 = resul.getString("DescrD");
                    System.out.println(R2);
                    String R3 = resul.getString("MotantD");
                    System.out.println(R3);
                    String R4 = resul.getString("DateD");
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

    public void GetDepenseData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = "SELECT COUNT(*) as nombre_depenses FROM depenses";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    Depense = resul.getString("nombre_depenses");
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

                String requete = "SELECT SUM(CAST(MotantD AS DECIMAL(30, 2))) as somme_depenses FROM DEPENSES";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    Total = resul.getString("somme_depenses");
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
        var icon1 = new ImageIcon(getClass().getResource("/icon/total.png")); // Remplacez "chemin_vers_votre_image.png" par le chemin de votre fichier d'icône
        var icon2 = new ImageIcon(getClass().getResource("/icon/expense.png")); // Remplacez "chemin_vers_votre_image.png" par le chemin de votre fichier d'icône

        Card_1.setData(new Model_Card_2(icon1, "Montant total des dépenses", Total + " Ariary", " Utilisateur(s)", "Effetif utilisateur(s)"));
        Card_2.setData(new Model_Card_2(icon2, "Nombre de dépenses effectives", Depense + " Depense(s)", " Utilisateur(s)", "Effetif utilisateur(s)"));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing_Home.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDefault1 = new swing_Home.table.TableDefault();
        BtnUpdateModale = new menu.MenuItem();
        BtnDelete = new menu.MenuItem();
        BtnAjouteModale = new menu.MenuItem();
        Actualise = new menu.MenuItem();
        ShowDepense = new menu.MenuItem();
        Card_1 = new Card_3.Cards_2();
        Card_2 = new Card_3.Cards_2();

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnUpdateModale.setForeground(new java.awt.Color(153, 255, 51));
        BtnUpdateModale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/edit-folder-64.png"))); // NOI18N
        BtnUpdateModale.setText("menuItem1");
        BtnUpdateModale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateModaleActionPerformed(evt);
            }
        });

        BtnDelete.setForeground(new java.awt.Color(153, 255, 51));
        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/delete-folder-64.png"))); // NOI18N
        BtnDelete.setText("menuItem1");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnAjouteModale.setForeground(new java.awt.Color(153, 255, 51));
        BtnAjouteModale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/add-folder-64.png"))); // NOI18N
        BtnAjouteModale.setText("menuItem1");
        BtnAjouteModale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouteModaleActionPerformed(evt);
            }
        });

        Actualise.setForeground(new java.awt.Color(153, 255, 51));
        Actualise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/synchronize.png"))); // NOI18N
        Actualise.setText("menuItem1");
        Actualise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualiseActionPerformed(evt);
            }
        });

        ShowDepense.setForeground(new java.awt.Color(153, 255, 51));
        ShowDepense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/folder-100.png"))); // NOI18N
        ShowDepense.setText("menuItem1");
        ShowDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowDepenseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Card_1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(Card_2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Actualise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnAjouteModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShowDepense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnUpdateModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Card_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Card_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ShowDepense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAjouteModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUpdateModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableDefault1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseClicked
        Recuperation();
    }//GEN-LAST:event_tableDefault1MouseClicked

    private void tableDefault1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseReleased
        BtnDelete.setEnabled(true);
        BtnUpdateModale.setEnabled(true);
        ShowDepense.setEnabled(true);

    }//GEN-LAST:event_tableDefault1MouseReleased

    private void BtnUpdateModaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateModaleActionPerformed
        try {
            UpdateDepense depense = new UpdateDepense();
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

    private void BtnAjouteModaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouteModaleActionPerformed
        AddDepense depense = new AddDepense();
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

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        try {
            MessageSupression message = new MessageSupression();
            String R1 = resul.getString("IDD");
            if (JOptionPane.showConfirmDialog(null, "Attention vous voulez vraiment supprimer depense ?",
                    "Supprimer depense", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (R1.length() != 0) {
                    String request = "DELETE FROM depenses WHERE IDD = ?";
//                    String request = "DELETE FROM affectations WHERE AncienLieu IN (SELECT lieu FROM employes WHERE numEmp = ?)";
//                    String R1 = resul.getString("numEmp");
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

    private void ActualiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualiseActionPerformed
        try {
            DisplayClient();
        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualiseActionPerformed

    private void ShowDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowDepenseActionPerformed
        try {
            ShowDepense depense = new ShowDepense();
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

    public final void DisplayClient() throws SQLException {
        try {
            String request = "SELECT IDD AS \"N° Depense\",DescrD AS \"Description de la dépense\",\n"
                    + "MotantD AS \"Montant de la dépense\",DateD AS \"Date de la dépense\",NumD_ref AS \"N° Projet\" FROM depenses ORDER BY IDD ASC";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));
            BtnDelete.setEnabled(false);
            BtnUpdateModale.setEnabled(false);
            ShowDepense.setEnabled(false);
            GetDepenseData();
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
