package ForgetPassword;
//Starting

import ComposantGlassPanePopup.GlassPanePopup;
import ShowMessage.MessageValidationChamps;
import component.LoadLogin;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class CodeVerify extends javax.swing.JFrame {

    private String code;
    private String Email;
    String messageVerify = "Code de verification incorrects.";
    LoadLogin loginPanel = new LoadLogin();

    public CodeVerify(String code, String Email) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        this.code = code; // Affecter la valeur du code à la variable d'instance
        this.Email = Email;
//        txtCode2.setText(code);
    }

    public String getmessageVerify() {
        return messageVerify;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound3 = new swing.PanelRound();
        txtCode2 = new swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmdOK2 = new swing.ButtonOutLine();
        cmdCancel2 = new swing.ButtonOutLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        txtCode2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Code de vérification");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Vérifiez votre e-mail pour obtenir le code de vérification.");

        cmdOK2.setBackground(new java.awt.Color(4, 131, 42));
        cmdOK2.setForeground(new java.awt.Color(4, 131, 42));
        cmdOK2.setText("OK");
        cmdOK2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOK2ActionPerformed(evt);
            }
        });

        cmdCancel2.setBackground(new java.awt.Color(255, 18, 23));
        cmdCancel2.setForeground(new java.awt.Color(255, 18, 23));
        cmdCancel2.setText("Annuler");
        cmdCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancel2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(cmdOK2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdOK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancel2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCancel2ActionPerformed

    private void cmdOK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOK2ActionPerformed
        MessageValidationChamps validation = new MessageValidationChamps();
        String code2 = txtCode2.getText();
        System.out.println(code);
        System.out.println(code2);

        if (code == null ? code2 == null : code.equals(code2)) {
            System.out.println("Code de verification correcte");
            System.out.println(Email);
            GlassPanePopup.showPopup(loginPanel);

            Animator animator = new Animator(4000); // Durée de l'animation (500ms)
            animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f));
            animator.addTarget(new TimingTargetAdapter() {
                public void timingevent(float fraction) {
                    // Vous pouvez mettre à jour les propriétés de votre fenêtre ici
                    setOpacity(1 - fraction);
                    repaint(); // Assurez-vous de redessiner le JPanel pour refléter les changements
                }

                @Override
                public void end() {
                    // Fermer le panneau après la fin de l'animation
                    loginPanel.setVisible(false);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginPanel);

                    // Si la fenêtre est une instance de JFrame, fermez-la
                    if (frame instanceof JFrame) {
                        fermer();
                        txtCode2.setText("");
                        new UpdatePassword(Email).setVisible(true);
                         GlassPanePopup.closePopupLast();


                    }
                }
            });
            animator.start();
        } else {
            try {
                //            JOptionPane.showMessageDialog(rootPane, "Code de verification incorrecte");
                validation.valVerify();
            } catch (SQLException ex) {
                Logger.getLogger(CodeVerify.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdOK2ActionPerformed
    private void fermer() {
        this.dispose();
    }

    /**
     * @param code
     * @param Email
     */
    public static void main(String code, String Email) {

        java.awt.EventQueue.invokeLater(() -> {
            new CodeVerify(code, Email).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonOutLine cmdCancel;
    private swing.ButtonOutLine cmdCancel1;
    private swing.ButtonOutLine cmdCancel2;
    private swing.ButtonOutLine cmdOK;
    private swing.ButtonOutLine cmdOK1;
    private swing.ButtonOutLine cmdOK2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private swing.PanelRound panelRound1;
    private swing.PanelRound panelRound2;
    private swing.PanelRound panelRound3;
    private swing.MyTextField txtCode;
    private swing.MyTextField txtCode1;
    private swing.MyTextField txtCode2;
    // End of variables declaration//GEN-END:variables
}
