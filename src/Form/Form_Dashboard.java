package Form;

//Starting
import Card.ModelCard;
import Chart.ModelChart;
import FenetreModale.UpdateUser;
import ModelChart.ModelData;
import ShowMessage.MessageSupression;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public final class Form_Dashboard extends javax.swing.JPanel {

    public static Connection connex = null;
    public static java.sql.ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static String dataUser;
    String U;
    String Motant;
    String Client;
    String montant;

    public Form_Dashboard() throws SQLException {
        initComponents();
        connex = connexionDB.DatabaseConnection.connex;
        setOpaque(false);
        table.fixTable(jScrollPane1);
//        GlassPanePopup.install(this);
//        init();
//        initiale();
        LegendChart();
//        test();
        DisplayUser();
        GetUsersData();
        GetFactureData();
        GetClientData();
        setData();
        GetValues();
    }

    public void Recuperation() {
        try {
            int row = table.getSelectedRow();
            if (row != -1) { // Vérifier si une ligne est sélectionnée
                Form_Dashboard.dataUser = (table.getModel().getValueAt(row, 0).toString());
                // Reste du code de récupération des données
                String request = "SELECT * FROM users WHERE UserID='" + dataUser + "' ";
                prepare = connex.prepareStatement(request);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("UserID");
                    System.out.println(R1);
                    String R2 = resul.getString("UserName");
                    System.out.println(R2);
                    String R3 = resul.getString("Email");
                    System.out.println(R3);
                    String R4 = resul.getString("Password");
                    System.out.println(R4);
                    String R5 = resul.getString("VerifyCode");
                    System.out.println(R5);
                    String R6 = resul.getString("Status");
                    System.out.println(R6);
                    //recupere.setText(R1);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //recuperer le donnee de la table

    public String GetTableResult() {
        return dataUser;
    }

    public void GetUsersData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = "SELECT COUNT(*) as nombre_users FROM users";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    U = resul.getString("nombre_users");
                    System.out.println(U);
//                    totalProjet.setxt(R1);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    public void GetFactureData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = "SELECT SUM(CAST(REPLACE(MotantTo, ',', '.') AS DECIMAL(50, 2))) as somme_factures FROM factures";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    Motant = resul.getString("somme_factures");
                    if (Motant == null) {
                        Motant = "0";
                    }
                    System.out.println(Motant + " Ar");
//                    totalProjet.setxt(R1);
                }


            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }

    public void GetClientData() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = "SELECT COUNT(*) as nombre_clients FROM clients";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    Client = resul.getString("nombre_clients");
                    System.out.println(Client);
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
        cards1.setData(new ModelCard(null, null, null, U + " Utilisateur(s)", "Effectif d'utilisateur(s)"));
        cards2.setData(new ModelCard(null, null, null, Motant + " Ariary", "Total montant de la facture."));
        cards3.setData(new ModelCard(null, null, null, Client + " Client(s)", "Nombre effectif Clients"));
    }

    private void setData() {
        try {
            List<ModelData> lists = new ArrayList<>();

            String request = "SELECT \n"
                    + "    CASE \n"
                    + "        WHEN to_char(DateD, 'MM') = '01' THEN 'Janvier'\n"
                    + "        WHEN to_char(DateD, 'MM') = '02' THEN 'Février'\n"
                    + "        WHEN to_char(DateD, 'MM') = '03' THEN 'Mars'\n"
                    + "        WHEN to_char(DateD, 'MM') = '04' THEN 'Avril'\n"
                    + "        WHEN to_char(DateD, 'MM') = '05' THEN 'Mai'\n"
                    + "        WHEN to_char(DateD, 'MM') = '06' THEN 'Juin'\n"
                    + "        WHEN to_char(DateD, 'MM') = '07' THEN 'Juillet'\n"
                    + "        WHEN to_char(DateD, 'MM') = '08' THEN 'Août'\n"
                    + "        WHEN to_char(DateD, 'MM') = '09' THEN 'Septembre'\n"
                    + "        WHEN to_char(DateD, 'MM') = '10' THEN 'Octobre'\n"
                    + "        WHEN to_char(DateD, 'MM') = '11' THEN 'Novembre'\n"
                    + "        WHEN to_char(DateD, 'MM') = '12' THEN 'Décembre'\n"
                    + "    END AS month,\n"
                    + "	SUM(CAST(MotantD AS NUMERIC)) AS Expense,\n"
                    + "    SUM(CAST(MotantD AS NUMERIC)) AS amount,\n"
                    + "    SUM(CAST(MotantD AS NUMERIC)) AS cost,\n"
                    + "    SUM(CAST(MotantD AS NUMERIC)) AS profit\n"
                    + "FROM DEPENSES\n"
                    + "GROUP BY to_char(DateD, 'Month'), DateD\n"
                    + "ORDER BY DateD DESC\n"
                    + "LIMIT 12";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            while (resul.next()) {
                String month = resul.getString("Month");
                double Expense = resul.getDouble("Expense");
                double amount = resul.getDouble("Amount");
                double cost = resul.getDouble("Cost");
                double profit = resul.getDouble("Profit");
                lists.add(new ModelData(month, Expense, amount, cost, profit));
            }
            resul.close();
            prepare.close();
            //  Add Data to chart
            for (int i = lists.size() - 1; i >= 0; i--) {
                ModelData d = lists.get(i);
                charts1.addData(new ModelChart(d.getMonth(), new double[]{d.getExpense(), d.getAmount(), d.getCost(), d.getProfit()}));
            }
            //  Start to show data with animation
            charts1.start();
        } catch (SQLException e) {
        }
    }

    public void LegendChart() {
//        charts1.addLegend("Amount", Color.decode("#7b4397"), Color.decode("#dc2430"));
//        charts1.addLegend("Cost", Color.decode("#e65c00"), Color.decode("#F9D423"));
//        charts1.addLegend("Profit", Color.decode("#0099F7"), Color.decode("#F11712"));

        charts1.addLegend("Expense", new Color(12, 84, 175), new Color(0, 108, 247));
        charts1.addLegend("Amount", new Color(54, 4, 143), new Color(104, 49, 200));
        charts1.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        charts1.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
    }

    private void test() {
        charts1.clear();
        charts1.addData(new ModelChart("January", new double[]{500, 50, 100}));
        charts1.addData(new ModelChart("February", new double[]{600, 300, 150}));
        charts1.addData(new ModelChart("March", new double[]{200, 50, 900}));
        charts1.addData(new ModelChart("April", new double[]{480, 700, 100}));
        charts1.addData(new ModelChart("May", new double[]{350, 540, 500}));
        charts1.addData(new ModelChart("June", new double[]{450, 800, 100}));
        charts1.start();
    }

    private void init() {
        table.fixTable(jScrollPane1);
        table.addRow(new Object[]{"1", "Mike Bhand", "mikebhand@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"2", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        table.addRow(new Object[]{"3", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        table.addRow(new Object[]{"4", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"5", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"6", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        table.addRow(new Object[]{"7", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        table.addRow(new Object[]{"8", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"9", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"10", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"11", "Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018"});
        table.addRow(new Object[]{"12", "Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018"});
        table.addRow(new Object[]{"13", "Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018"});
        table.addRow(new Object[]{"14", "Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018"});
//  init card data
        cards1.setData(new ModelCard(null, null, null, "$ 500.00", "Report Income Monthly"));
        cards2.setData(new ModelCard(null, null, null, "$ 800.00", "Report Expense Monthly"));
        cards3.setData(new ModelCard(null, null, null, "$ 300.00", "Report Profit Monthly"));

        // Ajout des boutons à la table
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor((TableCellEditor) new ButtonEditor(createButton("Delete", null)));
        table.getColumnModel().getColumn(5).setCellEditor((TableCellEditor) new ButtonEditor(createButton("Edit", null)));
        table.getColumnModel().getColumn(5).setCellEditor((TableCellEditor) new ButtonEditor(createButton("View", null)));

    }

    public void initiale() {
        charts1.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        charts1.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        charts1.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        charts1.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        charts1.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        charts1.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        charts1.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        charts1.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        charts1.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        charts1.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        charts1.start();
//        progress1.start();
//        progress2.start();
//        progress3.start();
//        progress4.start();
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        private final ImageIcon icon1;
        private final ImageIcon icon2;
        private final ImageIcon icon3;

        public ButtonRenderer() {
            setOpaque(true);
            // Chargez les icônes à partir de fichiers ou utilisez les icônes appropriées
            icon1 = new ImageIcon("/icon/user.png");
            icon2 = new ImageIcon("/icon/error.png");
            icon3 = new ImageIcon("/icon/email.png");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            switch (row) {
                case 0 ->
                    setIcon(icon1);
                case 1 ->
                    setIcon(icon2);
                case 2 ->
                    setIcon(icon3);
                default -> {
                }
            }
            return this;
        }
    }

    // Classe interne pour l'édition des boutons dans la table
    class ButtonEditor extends DefaultCellEditor {

        private final JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JButton button) {
            super(new JCheckBox());
            this.button = button;
            this.button.setOpaque(true);
            this.button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Insérez ici le code d'action pour chaque bouton (Delete, Edit, View)
                switch (label) {
                    case "Delete" -> {
                    }
                    case "Edit" -> {
                    }
                    case "View" -> {
                    }
                    default -> {
                    }
                }
                // Action pour le bouton "Delete"
                // Action pour le bouton "Edit"
                // Action pour le bouton "View"
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cards1 = new Card.Cards();
        cards2 = new Card.Cards();
        cards3 = new Card.Cards();
        roundPanel1 = new swing_Home.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing_Home.table.Table();
        charts1 = new Chart.Charts();
        BtnDeleteU = new menu.MenuItem();
        BtnUpdateModale = new menu.MenuItem();

        cards1.setIcon(javaswingdev.GoogleMaterialDesignIcon.PERSON);

        cards2.setColor1(new java.awt.Color(72, 200, 122));
        cards2.setColor2(new java.awt.Color(189, 229, 201));
        cards2.setIcon(javaswingdev.GoogleMaterialDesignIcon.PAYMENT);

        cards3.setColor1(new java.awt.Color(242, 52, 52));
        cards3.setColor2(new java.awt.Color(239, 159, 159));
        cards3.setIcon(javaswingdev.GoogleMaterialDesignIcon.PEOPLE);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nom Utilisateur", "Couriel", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setShowGrid(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnDeleteU.setBackground(new java.awt.Color(77, 163, 34));
        BtnDeleteU.setForeground(new java.awt.Color(204, 204, 204));
        BtnDeleteU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/delete-folder-64.png"))); // NOI18N
        BtnDeleteU.setText("menuItem1");
        BtnDeleteU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteUActionPerformed(evt);
            }
        });

        BtnUpdateModale.setBackground(new java.awt.Color(77, 163, 34));
        BtnUpdateModale.setForeground(new java.awt.Color(204, 204, 204));
        BtnUpdateModale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/edit-folder-64.png"))); // NOI18N
        BtnUpdateModale.setText("menuItem1");
        BtnUpdateModale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateModaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnDeleteU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnUpdateModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cards1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                .addGap(30, 30, 30)
                                .addComponent(cards2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                .addGap(30, 30, 30)
                                .addComponent(cards3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                            .addComponent(charts1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cards1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cards2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cards3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(charts1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnUpdateModale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDeleteU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        Recuperation();
    }//GEN-LAST:event_tableMouseClicked

    private void BtnDeleteUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteUActionPerformed
        try {
            MessageSupression message = new MessageSupression();
            int R1 = Integer.parseInt(resul.getString("UserID"));
            if (JOptionPane.showConfirmDialog(null, "Attention vous voulez vraiment supprimer user? " + R1,
                    "Supprimer user", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
//                if (R1.length() != 0) {
                if (R1 != 0) {
                    String request = "DELETE FROM users WHERE UserID = ?";
                    prepare = connex.prepareStatement(request);
//                    prepare.setString(1, R1);
                    prepare.setInt(1, R1);
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
                JOptionPane.showMessageDialog(null, "Veullez selectionner users ");
            }
            DisplayUser();
            GetUsersData();
            GetFactureData();
            GetClientData();
            GetValues();

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_BtnDeleteUActionPerformed

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        BtnDeleteU.setEnabled(true);
        BtnUpdateModale.setEnabled(true);
    }//GEN-LAST:event_tableMouseReleased

    private void BtnUpdateModaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateModaleActionPerformed
        try {
            UpdateUser depense = new UpdateUser();
            depense.setVisible(true);
//GlassPanePopup.showPopup(new UpdateUser());
            depense.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (depense.isInstant()) {
                        try {
                            DisplayUser();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnUpdateModaleActionPerformed

    public final void DisplayUser() throws SQLException {
        try {
            String request = "SELECT UserID AS \"N° UTILISATEUR\",UserName AS \"NOM UTILISATEUR\",Email AS \"COURIEL UTILSATEUR\",Status AS \"STATUS\" FROM users ORDER BY UserID ASC";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resul));
            BtnDeleteU.setEnabled(false);
            BtnUpdateModale.setEnabled(false);
//            ShowClient.setEnabled(false);
            GetUsersData();
            GetFactureData();
            GetClientData();
            GetValues();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menu.MenuItem BtnDeleteU;
    private menu.MenuItem BtnUpdateModale;
    private Card.Cards cards1;
    private Card.Cards cards2;
    private Card.Cards cards3;
    private Chart.Charts charts1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing_Home.RoundPanel roundPanel1;
    private swing_Home.table.Table table;
    // End of variables declaration//GEN-END:variables
}
