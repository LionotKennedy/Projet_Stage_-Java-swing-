package ShowMessage;

//Starting
import FenetreModale.AddActivite;
import FenetreModale.AddClient;
import FenetreModale.AddDepense;
import FenetreModale.AddDocument;
import FenetreModale.AddFacture;
import FenetreModale.AddProject;
import FenetreModale.UpdateUser;
import ForgetPassword.CodeVerify;
import ForgetPassword.EmailForgetPassword;
import ForgetPassword.UpdatePassword;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
//Ending

public final class MessageValidationChamps extends javax.swing.JFrame {

    public MessageValidationChamps() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }

    public void valide1() {
        AddActivite act = new AddActivite();
        String coucou = act.getCoucou();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valide2() {
        AddActivite act = new AddActivite();
        String coucou = act.getCoucou1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valide3() {
        AddActivite act = new AddActivite();
        String coucou = act.getCoucou2();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valide4() {
        AddActivite act = new AddActivite();
        String coucou = act.getCoucou3();
        testeTransfer.setText(coucou);
        setVisible(true);
    }
    ///////////////////////////////////////////////////////

    public void valid1() {
        AddClient act = new AddClient();
        String coucou = act.getClient1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valid2() {
        AddClient act = new AddClient();
        String coucou = act.getClient2();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valid3() {
        AddClient act = new AddClient();
        String coucou = act.getClient3();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valid4() {
        AddClient act = new AddClient();
        String coucou = act.getClient4();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valid5() {
        AddClient act = new AddClient();
        String coucou = act.getClient5();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valid6() {
        AddClient act = new AddClient();
        String coucou = act.getClient6();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valid7() {
        AddClient act = new AddClient();
        String coucou = act.getClient7();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valid8() {
        AddClient act = new AddClient();
        String coucou = act.getClient8();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    ////////////////////////////////////////////////////////////
    public void validation1() {
        AddDepense act = new AddDepense();
        String coucou = act.getDepense1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validation2() {
        AddDepense act = new AddDepense();
        String coucou = act.getDepense2();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validation3() {
        AddDepense act = new AddDepense();
        String coucou = act.getDepense3();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validation4() {
        AddDepense act = new AddDepense();
        String coucou = act.getDepense4();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validation5() {
        AddDepense act = new AddDepense();
        String coucou = act.getDepense5();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    ///////////////////////////////////////////////////////
    public void validat1() {
        AddDocument act = new AddDocument();
        String coucou = act.getDocument1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validat2() {
        AddDocument act = new AddDocument();
        String coucou = act.getDocument2();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validat3() {
        AddDocument act = new AddDocument();
        String coucou = act.getDocument3();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validat4() {
        AddDocument act = new AddDocument();
        String coucou = act.getDocument4();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validat5() {
        AddDocument act = new AddDocument();
        String coucou = act.getDocument5();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validat6() {
        AddDocument act = new AddDocument();
        String coucou = act.getDocument6();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validat7() {
        AddDocument act = new AddDocument();
        String coucou = act.getDocument7();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    ///////////////////////////////////////////////////////
    public void validate1() {
        AddFacture act = new AddFacture();
        String coucou = act.getFacture1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validate2() {
        AddFacture act = new AddFacture();
        String coucou = act.getFacture2();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validate3() {
        AddFacture act = new AddFacture();
        String coucou = act.getFacture3();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validate4() {
        AddFacture act = new AddFacture();
        String coucou = act.getFacture4();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validate5() {
        AddFacture act = new AddFacture();
        String coucou = act.getFacture5();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validate6() {
        AddFacture act = new AddFacture();
        String coucou = act.getFacture6();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    ///////////////////////////////////////////////////////
    public void validt1() throws ParseException {
        AddProject act = new AddProject();
        String coucou = act.getProjet1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validt2() throws ParseException {
        AddProject act = new AddProject();
        String coucou = act.getProjet2();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validt3() throws ParseException {
        AddProject act = new AddProject();
        String coucou = act.getProjet3();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validt4() throws ParseException {
        AddProject act = new AddProject();
        String coucou = act.getProjet4();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validt5() throws ParseException {
        AddProject act = new AddProject();
        String coucou = act.getProjet5();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validt6() throws ParseException {
        AddProject act = new AddProject();
        String coucou = act.getProjet6();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void validt7() throws ParseException {
        AddProject act = new AddProject();
        String coucou = act.getProjet7();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    /////////////////////////////////////////////////
    public void val1() throws SQLException {
        UpdateUser act = new UpdateUser();
        String coucou = act.getUser1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void val2() throws SQLException {
        UpdateUser act = new UpdateUser();
        String coucou = act.getUser2();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void val3() throws SQLException {
        UpdateUser act = new UpdateUser();
        String coucou = act.getUser3();
        testeTransfer.setText(coucou);
        setVisible(true);  
    }
    
    public void val4() throws SQLException {
        UpdateUser act = new UpdateUser();
        String coucou = act.getUser4();
        testeTransfer.setText(coucou);
        setVisible(true); 
    }
//    //////////////////////////////////

    public void valEmail1() throws SQLException {
        EmailForgetPassword act = new EmailForgetPassword();
        String coucou = act.getEmail1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    /////////////////
    public void valVerify() throws SQLException {
        String code = "valeur_du_code";
        String email = "adresse_email";
        var act = new CodeVerify(code, email);
        String coucou = act.getmessageVerify();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    ///////////////////////
    public void valPass1() throws SQLException {
        String code = "valeur_du_code";
        var act = new UpdatePassword(code);
        String coucou = act.getVal1();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    public void valPass2() throws SQLException {
        String code = "valeur_du_code";
        var act = new UpdatePassword(code);
        String coucou = act.getVal2();
        testeTransfer.setText(coucou);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow4 = new ComposantPanelShadow.PanelShadow();
        jLabel7 = new javax.swing.JLabel();
        testeTransfer = new javax.swing.JLabel();
        button4 = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageGIF/ValidationChamps.gif"))); // NOI18N

        testeTransfer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        testeTransfer.setForeground(new java.awt.Color(153, 153, 153));
        testeTransfer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        testeTransfer.setText("Aucune Connection Intenet");

        button4.setBackground(new java.awt.Color(244, 210, 76));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("OK");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow4Layout.createSequentialGroup()
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow4Layout.createSequentialGroup()
                        .addComponent(testeTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testeTransfer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_button4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new MessageValidationChamps().setVisible(true);
        });
    }
    // Variables declaration - do not modify

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private swing.Button button2;
    private swing.Button button3;
    private swing.Button button4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private ComposantPanelShadow.PanelShadow panelShadow1;
    private ComposantPanelShadow.PanelShadow panelShadow2;
    private ComposantPanelShadow.PanelShadow panelShadow3;
    private ComposantPanelShadow.PanelShadow panelShadow4;
    private javax.swing.JLabel testeTransfer;
    // End of variables declaration//GEN-END:variables

}
