package ModalShow;
//Starting

import Form.Form_3;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//Ending

public class ShowActivite extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    public ShowActivite() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        RecuperationDonne();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
    }

    public void RecuperationDonne() throws SQLException {
        Form_3 information = new Form_3();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM activites WHERE IDA ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("IDA");
                NumClientUp.setText(A1);

                String A2 = resul.getString("NumA_ref");
                NumeroUp.setText(A2);

                String A4 = resul.getString("DescrA");
                NomUp.setText(A4);

                String A6 = resul.getString("DateDA");
                PrenomUp.setText(A6);

                String A7 = resul.getString("DateFA");
                AdresseUp.setText(A7);

            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        NumClientUp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NomUp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PrenomUp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AdresseUp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NumeroUp = new javax.swing.JLabel();
        buttonOutLine1 = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Numéro d'Activité :");
        panelShadow1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 27));

        NumClientUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumClientUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 20, 440, 27));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Description :");
        panelShadow1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 27));

        NomUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NomUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 460, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Date de Début :");
        panelShadow1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, 27));

        PrenomUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(PrenomUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 380, 28));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Date de Fin :");
        panelShadow1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 27));

        AdresseUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(AdresseUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 420, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Numéro de Projet :");
        panelShadow1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 170, 30));

        NumeroUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumeroUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 380, 30));

        buttonOutLine1.setBackground(new java.awt.Color(60, 130, 239));
        buttonOutLine1.setForeground(new java.awt.Color(60, 130, 239));
        buttonOutLine1.setText("Fermer");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 147, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInstant() {
        return instant;
    }

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        instant = true;
        this.dispose();
    }//GEN-LAST:event_buttonOutLine1ActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
       DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
           try {
               new ShowActivite().setVisible(true);
           } catch (SQLException ex) {
               Logger.getLogger(ShowActivite.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdresseUp;
    private javax.swing.JLabel NomUp;
    private javax.swing.JLabel NumClientUp;
    private javax.swing.JLabel NumeroUp;
    private javax.swing.JLabel PrenomUp;
    private swing.ButtonOutLine buttonOutLine1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
