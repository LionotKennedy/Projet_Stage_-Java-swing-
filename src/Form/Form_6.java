package Form;

//Starting
import FenetreModale.AddDocument;
import FenetreModale.UpdateDocument;
import ModalShow.ShowDocument;
import Model_Card.Model_Card_2;
import ShowMessage.MessageSupression;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public final class Form_6 extends javax.swing.JPanel {

    public static Connection connex = null;
    public static java.sql.ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static String dataDocument;
    String C = null;
    String D = null;
    String R = null;

    public Form_6() throws SQLException {
        initComponents();
        connex = connexionDB.DatabaseConnection.connex;
        tableDefault1.fixTable(jScrollPane1);
        DisplayClients();
        GetContratData();
        GetDevisData();
        GetRapportData();
        GetValues();
    }

    public void Recuperation() {
        try {
            int row = tableDefault1.getSelectedRow();
            if (row != -1) { // Vérifier si une ligne est sélectionnée
                Form_6.dataDocument = (tableDefault1.getModel().getValueAt(row, 0).toString());
                // Reste du code de récupération des données
                String request = "SELECT * FROM documents WHERE IDD='" + dataDocument + "' ";
                prepare = connex.prepareStatement(request);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("IDD");
                    System.out.println(R1);
                    String R2 = resul.getString("NomD");
                    System.out.println(R2);
                    String R3 = resul.getString("Type");
                    System.out.println(R3);
                    String R4 = resul.getString("DateD");
                    System.out.println(R4);
                    String R5 = resul.getString("NumC_ref");
                    System.out.println(R5);
                    //recupere.setText(R1);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String GetTableResult() {
        return dataDocument;
    }

    public void GetContratData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = """
                                 SELECT COUNT(*) AS nombre_contrats
                                 FROM DOCUMENTS
                                 WHERE Type = 'contrat'""";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    C = resul.getString("nombre_contrats");
                    System.out.println(C);
//                    totalProjet.setxt(R1);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    public void GetDevisData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = """
                                 SELECT COUNT(*) AS nombre_devis
                                 FROM DOCUMENTS
                                 WHERE Type = 'devis'""";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    D = resul.getString("nombre_devis");
                    System.out.println(D);
//                    totalProjet.setxt(R1);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    public void GetRapportData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = """
                                 SELECT COUNT(*) AS nombre_rapport
                                 FROM DOCUMENTS
                                 WHERE Type = 'rapport'""";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    R = resul.getString("nombre_rapport");
                    System.out.println(R);
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
var icon = new ImageIcon(getClass().getResource("/icon/signing.png")); // Remplacez "create_account.png" par le nom de votre fichier d'icône
var icon2 = new ImageIcon(getClass().getResource("/icon/cash.png")); // Remplacez "create_account.png" par le nom de votre fichier d'icône
var icon3 = new ImageIcon(getClass().getResource("/icon/bill.png")); // Remplacez "create_account.png" par le nom de votre fichier d'icône
//        lbIcon.setIcon(icon);

        cards_21.setData(new Model_Card_2(icon, "Effectif du contrats", C + " Contrat(s)", " Utilisateur(s)", "Effetif utilisateur(s)"));
        cards_22.setData(new Model_Card_2(icon2, "Nombre réel de devis", D + " Devis", " Utilisateur(s)", "Effetif utilisateur(s)"));
        cards_23.setData(new Model_Card_2(icon3, "Effectif du rapports", R + " Rapport(s)", " Utilisateur(s)", "Effetif utilisateur(s)"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing_Home.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDefault1 = new swing_Home.table.TableDefault();
        BtnUpdateModale = new menu.MenuItem();
        BtnDelete = new menu.MenuItem();
        BtnAddModale = new menu.MenuItem();
        Actualiser = new menu.MenuItem();
        ShowDepense = new menu.MenuItem();
        cards_21 = new Card_3.Cards_2();
        cards_22 = new Card_3.Cards_2();
        cards_23 = new Card_3.Cards_2();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setPreferredSize(new java.awt.Dimension(948, 425));
        roundPanel1.setRound(20);

        tableDefault1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tableDefault1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N Document", "N Client", "Nom Client", "Nom Document", "Date Document", "Type"
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
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnUpdateModale.setBackground(new java.awt.Color(39, 166, 200));
        BtnUpdateModale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/edit-folder-64.png"))); // NOI18N
        BtnUpdateModale.setText("menuItem1");
        BtnUpdateModale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateModaleActionPerformed(evt);
            }
        });

        BtnDelete.setBackground(new java.awt.Color(39, 166, 200));
        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/delete-folder-64.png"))); // NOI18N
        BtnDelete.setText("menuItem1");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnAddModale.setBackground(new java.awt.Color(39, 166, 200));
        BtnAddModale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/add-folder-64.png"))); // NOI18N
        BtnAddModale.setText("menuItem1");
        BtnAddModale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddModaleActionPerformed(evt);
            }
        });

        Actualiser.setBackground(new java.awt.Color(39, 166, 200));
        Actualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/synchronize.png"))); // NOI18N
        Actualiser.setText("menuItem1");
        Actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualiserActionPerformed(evt);
            }
        });

        ShowDepense.setBackground(new java.awt.Color(39, 166, 200));
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
                        .addComponent(Actualiser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 590, Short.MAX_VALUE)
                        .addComponent(BtnAddModale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShowDepense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(BtnUpdateModale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cards_21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(cards_22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(cards_23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cards_21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cards_22, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cards_23, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShowDepense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAddModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUpdateModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
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
            UpdateDocument document = new UpdateDocument();
            document.setVisible(true);
            document.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (document.isInstant()) {
                        try {
                            DisplayClients();
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

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        try {
            MessageSupression message = new MessageSupression();
            String R1 = resul.getString("IDD");
            if (JOptionPane.showConfirmDialog(null, "Attention vous voulez vraiment supprimer depense ?",
                    "Supprimer depense", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (R1.length() != 0) {
                    String request = "DELETE FROM documents WHERE IDD = ?";
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
            DisplayClients();

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnAddModaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddModaleActionPerformed
        AddDocument document = new AddDocument();
        document.setVisible(true);
        document.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (document.isInstant()) {
                    try {
                        DisplayClients();
                    } catch (SQLException ex) {
                        Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                }
            }
        });
    }//GEN-LAST:event_BtnAddModaleActionPerformed

    private void ActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualiserActionPerformed
        try {
            DisplayClients();
        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualiserActionPerformed

    private void ShowDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowDepenseActionPerformed
        try {
            ShowDocument document = new ShowDocument();
            document.setVisible(true);
            document.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (document.isInstant()) {
                        try {
                            DisplayClients();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ShowDepenseActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        BtnDelete.setEnabled(false);
        BtnUpdateModale.setEnabled(false);
        ShowDepense.setEnabled(false);
    }//GEN-LAST:event_formKeyPressed

    public final void DisplayClients() throws SQLException {
        try {

            String request = "SELECT\n"
                    + "    d.IDD AS NUNERO_DOCUMENT,\n"
                    + "    c.IDClient AS NUMERO_CLIENT,\n"
                    + "    c.NomC AS NOM_CLIENT,\n"
                    //                + "    p.IDP AS Numero_Projet,\n"
                    //                + "    p.NomP AS Nom_Projet,\n"
                    + "    d.NomD AS NOM_DOCUMENT,\n"
                    + "    d.DateD AS DATE_DOCUMENT,\n"
                    + "    d.Type\n"
                    + "FROM\n"
                    + "    DOCUMENTS d\n"
                    + "INNER JOIN\n"
                    + "    CLIENTS c ON d.NumC_ref = c.IDClient;";
//                + "    CLIENTS c ON d.NumC_ref = c.IDClient\n"
//                + "INNER JOIN\n"
//                + "    PROJETS p ON p.NumC_ref = c.IDClient\n"
//                + "WHERE\n"
//                + "    d.NumC_ref IS NOT NULL\n"
//                + "    AND p.NumC_ref IS NOT NULL\n"
//                + "LIMIT 1;";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));
            BtnDelete.setEnabled(false);
            BtnUpdateModale.setEnabled(false);
            ShowDepense.setEnabled(false);
            GetContratData();
            GetDevisData();
            GetRapportData();
            GetValues();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menu.MenuItem Actualiser;
    private menu.MenuItem BtnAddModale;
    private menu.MenuItem BtnDelete;
    private menu.MenuItem BtnUpdateModale;
    private menu.MenuItem ShowDepense;
    private Card_3.Cards_2 cards_21;
    private Card_3.Cards_2 cards_22;
    private Card_3.Cards_2 cards_23;
    private javax.swing.JScrollPane jScrollPane1;
    private swing_Home.RoundPanel roundPanel1;
    private swing_Home.table.TableDefault tableDefault1;
    // End of variables declaration//GEN-END:variables
}
