package ModalShow;

//Staring
import Form.Form_6;
import com.raven.datechooser.DateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
//Ending

public final class ShowDocument extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static boolean instant;
    public String L1;
    public String etat;

    public ShowDocument() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//        chDate.setTextField(DateF);
        RecuperationDonne();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
    }

    public void RecuperationDonne() throws SQLException {
        Form_6 information = new Form_6();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
//            String request = "SELECT\n"
//                    + "    d.IDD ,\n"
//                    + "    c.IDClient,\n"
//                    + "    c.NomC,\n"
//                    + "    p.IDP,\n"
//                    + "    p.NomP,\n"
//                    + "    d.NomD,\n"
//                    + "    d.DateD,\n"
//                    + "    d.Type\n"
//                    + "FROM\n"
//                    + "    DOCUMENTS d\n"
//                    + "INNER JOIN\n"
//                    + "    CLIENTS c ON d.NumC_ref = c.IDClient\n"
//                    + "INNER JOIN\n"
//                    + "    PROJETS p ON p.NumC_ref = c.IDClient WHERE IDD ='" + recuprer + "' ";
            String request = "SELECT\n"
                    + "    d.IDD,\n"
                    + "    c.IDClient,\n"
                    + "    c.NomC,\n"
//                                    + "    p.IDP AS Numero_Projet,\n"
//                                    + "    p.NomP AS Nom_Projet,\n"
                    + "    d.NomD,\n"
                    + "    d.DateD,\n"
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
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("IDD");
                NumClientUp2.setText(A1);

                String A2 = resul.getString("IDClient");
                NomUp2.setText(A2);

                String A3 = resul.getString("NomC");
                PrenomUp2.setText(A3);
                System.out.println(A3);

//                String A4 = resul.getString("IDP");
//                AdresseUp2.setText(A4);

//                String A5 = resul.getString("NomP");
//                NumeroUp3.setText(A5);

                String A6 = resul.getString("NomD");
                EmailUp3.setText(A6);

                String A7 = resul.getString("DateD");
                EmailUp4.setText(A7);

                String A8 = resul.getString("Type");
                EmailUp2.setText(A8);

            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        jLabel13 = new javax.swing.JLabel();
        NumClientUp2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        NomUp2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        PrenomUp2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        EmailUp3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        EmailUp4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        EmailUp2 = new javax.swing.JLabel();
        buttonOutLine3 = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Numéro de Document :");
        panelShadow1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, 27));

        NumClientUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumClientUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 28, 360, 27));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Numéro de Client :");
        panelShadow1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 27));

        NomUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NomUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 400, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Nom du Client :");
        panelShadow1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 27));

        PrenomUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(PrenomUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 370, 28));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Nom du Document :");
        panelShadow1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 180, 27));

        EmailUp3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 370, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Date du Document :");
        panelShadow1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 180, 27));

        EmailUp4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 360, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Type du document :");
        panelShadow1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 170, 27));

        EmailUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 370, 30));

        buttonOutLine3.setBackground(new java.awt.Color(60, 130, 239));
        buttonOutLine3.setForeground(new java.awt.Color(60, 130, 239));
        buttonOutLine3.setText("Fermer");
        buttonOutLine3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine3ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }
    private void buttonOutLine3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine3ActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_buttonOutLine3ActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ShowDocument().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ShowDocument.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmailUp2;
    private javax.swing.JLabel EmailUp3;
    private javax.swing.JLabel EmailUp4;
    private javax.swing.JLabel NomUp2;
    private javax.swing.JLabel NumClientUp2;
    private javax.swing.JLabel PrenomUp2;
    private swing.ButtonOutLine buttonOutLine3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
