package ModalShow;

//Staring
import Form.Form_5;
import com.raven.datechooser.DateChooser;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
//Ending

public final class ShowFacture extends javax.swing.JFrame {

    private final DateChooser chDate = new DateChooser();
    private final DateChooser chDate1 = new DateChooser();

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static boolean instant;
    public String L1;
    public String etat;

    public ShowFacture() throws SQLException, IOException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//        chDate.setTextField(DateF);
        RecuperationDonne();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
    }

    public void RecuperationDonne() throws SQLException, IOException {
        Form_5 information = new Form_5();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request =  "SELECT\n"
                        + "    f.DateF,\n"
                        + "    f.NumeroF,\n"
                        + "    f.MotantTo,\n"
                        + "    f.Etat,\n"
                        + "    f.ID,\n"
                        + "    f.NumC_ref,\n"
                        + "    d.MotantD,\n"
                        + "    d.DateD,\n"
                        + "    p.NomP,\n"
                        + "    p.Status,\n"
                        + "    p.DateDP,\n"
                        + "    p.DateFP,\n"
                        + "    c.IDClient,\n"
                        + "    c.NomC,\n"
                        + "    c.PrenomC,\n"
                        + "    c.AdresseC,\n"
                        + "    c.NumeroC,\n"
                        + "    c.EmailC\n"
                        + "FROM\n"
                        + "    FACTURES f\n"
                        + "INNER JOIN\n"
                        + "    CLIENTS c ON f.NumC_ref = c.IDClient\n"
                        + "LEFT JOIN\n"
                        + "    DEPENSES d ON d.NumD_ref = f.NumC_ref\n"
                        + "LEFT JOIN\n"
                        + "    PROJETS p ON p.NumC_ref = c.IDClient\n"
                        + "LEFT JOIN\n"
                        + "    ACTIVITES a ON a.NumA_ref = p.IDP WHERE ID ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("NumeroF");
                NumClientUp2.setText(A1);

                String A2 = resul.getString("NumC_ref");
                NomUp2.setText(A2);

                String A3 = resul.getString("MotantTo");
                AdresseUp2.setText(A3);
                System.out.println(A3);

                String A4 = resul.getString("DateF");
                NumeroUp3.setText(A4);

                String A5 = resul.getString("Etat");
                PrenomUp2.setText(A5);

                String A6 = resul.getString("NumeroC");
                EmailUp4.setText(A6);

                String A7 = resul.getString("EmailC");
                EmailUp2.setText(A7);

                String A8 = resul.getString("NomC");
                EmailUp3.setText(A8);

            }
        } catch (SQLException e) {
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
        jLabel15 = new javax.swing.JLabel();
        AdresseUp2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        NumeroUp3 = new javax.swing.JLabel();
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
        jLabel13.setText("Numéro de Facture :");
        panelShadow1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, 27));

        NumClientUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumClientUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 28, 380, 27));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Numéro de Client :");
        panelShadow1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 27));

        NomUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NomUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 400, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Etat de la Facture :");
        panelShadow1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, 27));

        PrenomUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(PrenomUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 390, 28));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Montant Total :");
        panelShadow1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 27));

        AdresseUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(AdresseUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 350, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Date Fin :");
        panelShadow1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 100, 40));

        NumeroUp3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumeroUp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 380, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Nom de Client :");
        panelShadow1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 150, 27));

        EmailUp3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 390, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Numéro de Telephone :");
        panelShadow1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, 27));

        EmailUp4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 350, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Adresse Email :");
        panelShadow1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 140, 27));

        EmailUp2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 410, 30));

        buttonOutLine3.setBackground(new java.awt.Color(60, 130, 239));
        buttonOutLine3.setForeground(new java.awt.Color(60, 130, 239));
        buttonOutLine3.setText("Fermer");
        buttonOutLine3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine3ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
                new ShowFacture().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ShowFacture.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ShowFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdresseUp2;
    private javax.swing.JLabel EmailUp2;
    private javax.swing.JLabel EmailUp3;
    private javax.swing.JLabel EmailUp4;
    private javax.swing.JLabel NomUp2;
    private javax.swing.JLabel NumClientUp2;
    private javax.swing.JLabel NumeroUp3;
    private javax.swing.JLabel PrenomUp2;
    private swing.ButtonOutLine buttonOutLine3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
