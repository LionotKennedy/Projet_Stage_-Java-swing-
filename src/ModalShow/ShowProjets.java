
package ModalShow;

//Starting
import Form.Form_2;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//Ending

public final class ShowProjets extends javax.swing.JFrame {

      public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;
    public ShowProjets() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        RecuperationDonne();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
    }

    public void RecuperationDonne() throws SQLException {
        Form_2 information = new Form_2();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM projets WHERE IDP ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String A1 = resul.getString("IDP");
                NomUp.setText(A1);

                String A2 = resul.getString("NumC_ref");
                NumClientUp.setText(A2);
                System.out.println(A2);
                //JOptionPane.showMessageDialog(null, A2);

                String A3 = resul.getString("NomP");
                EmailUp.setText(A3);
                System.out.println(A3);

                String A4 = resul.getString("DescrP");
                PrenomUp.setText(A4);

                String A5 = resul.getString("Status");
                AdresseUp.setText(A5);
                

                String A6 = resul.getString("DateDP");
                NumeroUp.setText(A6);

                String A7 = resul.getString("DateFP");
                EmailUp1.setText(A7);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new ComposantPanelShadow.PanelShadow();
        NomUp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NumClientUp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PrenomUp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AdresseUp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NumeroUp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EmailUp1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        EmailUp = new javax.swing.JLabel();
        buttonOutLine1 = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NomUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NomUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 400, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Numéro de client :");
        panelShadow1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Numéro de Projet :");
        panelShadow1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 27));

        NumClientUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumClientUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 28, 400, 27));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Description Projet :");
        panelShadow1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, 27));

        PrenomUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(PrenomUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 380, 28));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Status Projet :");
        panelShadow1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 27));

        AdresseUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(AdresseUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 440, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Date debut :");
        panelShadow1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, 40));

        NumeroUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumeroUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 420, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Date Fin :");
        panelShadow1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 100, 27));

        EmailUp1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 410, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Nom de Projet :");
        panelShadow1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, 27));

        EmailUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 370, 30));

        buttonOutLine1.setBackground(new java.awt.Color(60, 130, 239));
        buttonOutLine1.setForeground(new java.awt.Color(60, 130, 239));
        buttonOutLine1.setText("Fermer");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
                new ShowProjets().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ShowProjets.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdresseUp;
    private javax.swing.JLabel EmailUp;
    private javax.swing.JLabel EmailUp1;
    private javax.swing.JLabel NomUp;
    private javax.swing.JLabel NumClientUp;
    private javax.swing.JLabel NumeroUp;
    private javax.swing.JLabel PrenomUp;
    private swing.ButtonOutLine buttonOutLine1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
