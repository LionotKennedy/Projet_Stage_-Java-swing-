package main;

//Starting
import ComposantGlassPanePopup.GlassPanePopup;
import ShowMessage.ChargementLogin;
import ShowMessage.MessageLogin;
import component.LoadLogin;
import component.Message;
import component.PanelCover;
import component.PanelLoading;
import component.PanelLoginAndRegister;
import component.PanelVerifyCode;
import connexionDB.DatabaseConnection;
import model.ModelMessage;
import model.ModelUser;
import service.ServiceMail;
import service.ServiceUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.ModelLogin;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class Main extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoading loading;
    private PanelVerifyCode verifyCode;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private ServiceUser service;
//    private boolean verificationReussie = false;
    MessageLogin messageLog = new MessageLogin();
    ChargementLogin charger = new ChargementLogin();
    LoadLogin loginPanel = new LoadLogin();

    public Main() {
        initComponents();
        init();
        GlassPanePopup.install(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void init() {
        service = new ServiceUser();
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    register();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        };
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    login();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        loginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        bg.setLayout(layout);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(verifyCode, "pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%"); //  1al as 100%
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        verifyCode.addEventButtonOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    ModelUser user = loginAndRegister.getUser();
                    if (service.verifyCodeWithUser(verifyCode.getInputCode())) {
                        service.doneVerify(user.getUserID());
                        showMessage(Message.MessageType.SUCCESS, "Inscription réussie");
                        showMessage(Message.MessageType.SUCCESS, "Veuillez vous connecter pour continuer.");
                        verifyCode.setVisible(false);

                        loginAndRegister.clearTextFields();
//                        JOptionPane.showMessageDialog(null, "Veuillez vous connecter pour vous connecter");
                        messageLog.setVisible(true);

                        Animator animator = new Animator(4000); // Durée de l'animation (500ms)
                        animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
                        animator.addTarget(new TimingTargetAdapter() {
                            @Override
                            public void timingEvent(float fraction) {
                                // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                                // en fonction de l'avancement de l'animation, par exemple :
                                messageLog.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
                            }

                            @Override
                            public void end() {
                                // Fermer la fenêtre après la fin de l'animation
                                messageLog.dispose();
                            }
                        });

                        animator.start();

                    } else {
                        showMessage(Message.MessageType.ERROR, "Code de vérification incorrect.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void register() throws SQLException {
        ModelUser user = loginAndRegister.getUser();

        System.out.println(user.getUserName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        try {
            if (service.checkDuplicateUser(user.getUserName())) {
                showMessage(Message.MessageType.ERROR, "Le nom d'utilisateur existe déjà.");
            } else if (service.checkDuplicateEmail(user.getEmail())) {
                showMessage(Message.MessageType.ERROR, "L'adresse e-mail existe déjà.");
            } else if (!loginAndRegister.validation()) { // Notez le "!" ici
                showMessage(Message.MessageType.ERROR, "Veuillez remplir tous les champs");
            } else {
                AtomicInteger userID = new AtomicInteger();
                service.insertUser(user);
                int generatedUserID = userID.get();
                sendMain(user);

//                showMessage(Message.MessageType.SUCCESS, "User registered with UserID: " + generatedUserID);
//                JOptionPane.showMessageDialog(null, "Le UserID généré est : " + generatedUserID);
//                verificationReussie = true;
            }
        } catch (SQLException e) {
            showMessage(Message.MessageType.ERROR, "Erreur lors de l'inscription de l'utilisateur.");
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
//        this.dispose();
    }

    private void login() throws ClassNotFoundException {
        ModelLogin data = loginAndRegister.getDataLogin();
        try {
            ModelUser user = service.login(data);
//             ModelUser email = service.login(data);
            if (user != null) {
                String userName = user.getUserName();
                String email = user.getEmail();
//                new MainSystem(user).setVisible(true);
//                 GlassPanePopup.showPopup(new LoadLogin());
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
//                        this.dispose();
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginPanel);

                        // Si la fenêtre est une instance de JFrame, fermez-la
                        if (frame instanceof JFrame) {
                            fermer();
//                            System.exit(0);
//                            new MainSystem().setVisible(true);
                            new MainSystem(user).setVisible(true);

                        }
                    }
                });
                animator.start();

//                this.dispose();
            } else {
                showMessage(Message.MessageType.ERROR, "Adresse e-mail et mot de passe incorrects.");
            }

        } catch (SQLException e) {
            showMessage(Message.MessageType.ERROR, "Erreur de connexion.");
        }
    }

    private void fermer() {
        this.dispose();
    }

    private void sendMain(ModelUser user) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    loading.setVisible(true);
//            ModelMessage ms = new ServiceMail().sendMain(email, code);
                    String code = service.getVerifyCode(user.getUserName()); // Récupérer la valeur de VerifyCode depuis la base de données
                    System.out.println("code am Main ato iny io baba: " + code); // Afficher la valeur de code (à des fins de vérification)
                    ModelMessage ms = new ServiceMail().sendMain(user.getEmail(), code); // Passer à la fois l'adresse e-mail et la valeur de code
                    if (ms.isSuccess()) {
                        loading.setVisible(false);
                        verifyCode.setVisible(true);
                    } else {
                        loading.setVisible(false);
                        showMessage(Message.MessageType.ERROR, ms.getMessage());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    private void showMessage(Message.MessageType messageType, String message) {
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) throws ClassNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        DatabaseConnection.LoadConnexion();

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
