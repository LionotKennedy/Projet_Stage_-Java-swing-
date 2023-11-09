package ModalShow;

//Starting
import Form.Form_1;
import connexionDB.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//Ending

public final class ShowClients extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static boolean instant;

    public ShowClients() throws SQLException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        RecuperationDonne();
        instant = false;
        setBackground(new Color(0, 0, 0, 0));
    }

    public void RecuperationDonne() throws SQLException {
        Form_1 information = new Form_1();
//        MainSystem information = new MainSystem();
        information.Recuperation();
        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT * FROM clients WHERE IDClient ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {
                String R1 = resul.getString("IDClient");
                NumClientUp.setText(R1);
                System.out.println(R1);

                String R2 = resul.getString("NomC");
                NomUp.setText(R2);
                System.out.println(R2);

                String R3 = resul.getString("PrenomC");
                PrenomUp.setText(R3);
                System.out.println(R3);

                String R4 = resul.getString("AdresseC");
                AdresseUp.setText(R4);
                System.out.println(R4);

                String R5 = resul.getString("NumeroC");
                NumeroUp.setText(R5);
                System.out.println(R5);

                String R6 = resul.getString("EmailC");
                EmailUp.setText(R6);
                System.out.println(R6);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean isInstant() {
        return instant;
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
        jLabel5 = new javax.swing.JLabel();
        EmailUp = new javax.swing.JLabel();
        buttonOutLine1 = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Numéro du Client :");
        panelShadow1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, 27));

        NumClientUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumClientUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 28, 390, 27));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Nom du Client :");
        panelShadow1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 27));

        NomUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NomUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 410, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Prénom du Client :");
        panelShadow1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 160, 27));

        PrenomUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(PrenomUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 400, 28));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Adresse du Client :");
        panelShadow1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 170, 27));

        AdresseUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(AdresseUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 390, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Numéro de Téléphone :");
        panelShadow1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 210, 40));

        NumeroUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(NumeroUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 360, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Adresse E-mail :");
        panelShadow1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 140, 27));

        EmailUp.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        panelShadow1.add(EmailUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 235, 420, 30));

        buttonOutLine1.setBackground(new java.awt.Color(60, 130, 239));
        buttonOutLine1.setForeground(new java.awt.Color(60, 130, 239));
        buttonOutLine1.setText("Fermer");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });
        panelShadow1.add(buttonOutLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                new ShowClients().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ShowClients.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdresseUp;
    private javax.swing.JLabel EmailUp;
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
    private ComposantPanelShadow.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
