package main;

//Starting
import ComposantGlassPanePopup.GlassPanePopup;
import Form.Form_1;
import Form.Form_2;
import Form.Form_3;
import Form.Form_4;
import Form.Form_5;
import Form.Form_6;
import Form.Form_7;
import Form.Form_Dashboard;
import Form.Form_Profile;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.Component;
import java.awt.EventQueue;
import menu.EventMenu;
import menu.MainForm;
import menu.MenuItem;
import connexionDB.DatabaseConnection;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.ModelUser;
//Ending

public class MainSystem extends javax.swing.JFrame {

    static {
        FlatLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
    }

    private String connectedUserName;
    private String connectedEmail;
//    public MainSystem() {

    public MainSystem(ModelUser user) {
        initComponents();
        this.connectedUserName = user.getUserName();
        this.connectedEmail = user.getEmail();
        printConnectedUserInfo();
//setSize(1195, 623);

// Définir la taille maximale
        this.setMaximumSize(new Dimension(1300, 800));
// Définir la taille minimale
        this.setMinimumSize(new Dimension(1195, 623));
         this.setResizable(false); // Désactive la redimension de la fenêtre
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(1200, 650);
        setSize(1195, 623);

        GlassPanePopup.install(this);

        menu1.addEventMenuSelected(new EventMenu() {
            @Override
            public void mainMenuSelected(MainForm mainForm, int index, MenuItem menuItem) {
                if (index == 0) {
                    try {
                        mainForm.displayForm(new Form_Dashboard());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

            @Override
            public void subMenuSelected(MainForm mainForm, int index, int subMenuIndex, Component menuItem) {
                if (index == 0 && subMenuIndex == 0) {
                    try {
                        mainForm.displayForm(new Form_Dashboard());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (index == 0 && subMenuIndex == 1) {
                    try {
                        mainForm.displayForm(new Form_6());
                        Form_6 form = new Form_6();
                        form.DisplayClients();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (index == 0 && subMenuIndex == 2) {
                    Form_Profile profile = new Form_Profile();
                    profile.updateUserInfoPanel(connectedUserName, connectedEmail); 
                    profile.eventDeconnect((ActionEvent e) -> {
                        System.out.println("You have been clicked a button");
                        SwingUtilities.getWindowAncestor(profile).dispose();
                        GlassPanePopup.closePopupLast();
                    });
                    GlassPanePopup.showPopup(profile);
                } else if (index == 1 && subMenuIndex == 0) {
                    try {
                        mainForm.displayForm(new Form_1());
                        Form_1 form = new Form_1();
                        form.DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (index == 2 && subMenuIndex == 0) {
                    try {
                        mainForm.displayForm(new Form_2());
                        Form_2 form = new Form_2();
                        form.DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (index == 3 && subMenuIndex == 0) {
                    try {
                        mainForm.displayForm(new Form_3());
                        Form_3 form = new Form_3();
                        form.DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (index == 4 && subMenuIndex == 0) {
                    try {
                        mainForm.displayForm(new Form_4());
                        Form_4 form = new Form_4();
                        form.DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if (index == 4 && subMenuIndex == 1) {
                    try {
                        mainForm.displayForm(new Form_7());
                        Form_7 form = new Form_7();
//                        form.DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (index == 5 && subMenuIndex == 0) {
                    try {
                        mainForm.displayForm(new Form_5());
                        Form_5 form = new Form_5();
                        form.DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        menu1.setSelectedIndex(0);
    }

    public void printConnectedUserInfo() {
        System.out.println("User Name: " + connectedUserName);
        System.out.println("Email: " + connectedEmail);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu1 = new menu.Menu();
        Logo = new javax.swing.JLabel();
        menuItem1 = new menu.MenuItem();
        menuItem2 = new menu.MenuItem();
        menuItem3 = new menu.MenuItem();
        menuItem4 = new menu.MenuItem();
        menuItem5 = new menu.MenuItem();
        menuItem6 = new menu.MenuItem();
        subMenuPanel1 = new menu.SubMenuPanel();
        mainForm = new menu.MainForm();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuDarkMode = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu1.setMainForm(mainForm);
        menu1.setSubMenuPanel(subMenuPanel1);

        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHome/Entreprise.png"))); // NOI18N
        menu1.add(Logo);

        menuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHome/menu1.png"))); // NOI18N
        menuItem1.setText("menuItem1");
        menuItem1.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "iconHome/s4_3.png", "iconHome/6.png", "iconHome/administrator.png" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem1.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Dashboard", "Documents", "Profile" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu1.add(menuItem1);

        menuItem2.setBackground(new java.awt.Color(39, 166, 200));
        menuItem2.setForeground(new java.awt.Color(94, 57, 203));
        menuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHome/menu2.png"))); // NOI18N
        menuItem2.setText("menuItem2");
        menuItem2.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "iconHome/s2_2.png", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem2.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Client" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu1.add(menuItem2);

        menuItem3.setBackground(new java.awt.Color(200, 117, 19));
        menuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHome/menu3.png"))); // NOI18N
        menuItem3.setText("menuItem3");
        menuItem3.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "iconHome/s3_3.png", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem3.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Projet" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu1.add(menuItem3);

        menuItem4.setForeground(new java.awt.Color(52, 15, 159));
        menuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHome/menu4.png"))); // NOI18N
        menuItem4.setText("menuItem4");
        menuItem4.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "iconHome/s1_3.png", " ", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem4.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Activité" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu1.add(menuItem4);

        menuItem5.setBackground(new java.awt.Color(79, 153, 22));
        menuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHome/depth.png"))); // NOI18N
        menuItem5.setText("menuItem5");
        menuItem5.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "iconHome/s3_1.png", "iconHome/s1_4.png", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem5.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Depense", "Gains" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu1.add(menuItem5);

        menuItem6.setBackground(new java.awt.Color(159, 152, 156));
        menuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHome/petition.png"))); // NOI18N
        menuItem6.setText("menuItem6");
        menuItem6.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "iconHome/s4_1.png", " ", " ", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem6.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Facture" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menu1.add(menuItem6);

        subMenuPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(100, 1, 1, 1));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Options");

        menuDarkMode.setText("Mode Sombre");
        menuDarkMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDarkModeActionPerformed(evt);
            }
        });
        jMenu3.add(menuDarkMode);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subMenuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainForm, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(subMenuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(mainForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuDarkModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDarkModeActionPerformed
        // TODO add your handling code here:
        if (menuDarkMode.isSelected()) {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatDarculaLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        } else {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatIntelliJLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        }
    }//GEN-LAST:event_menuDarkModeActionPerformed

    /**
     * @param user
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(ModelUser user) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        FlatLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            //                new MainSystem().setVisible(true);
            new MainSystem(user).setVisible(true);
        });
    }
//    public static void main(String args[]) throws ClassNotFoundException {
//        DatabaseConnection.LoadConnexion();
//        FlatLaf.registerCustomDefaultsSource("style");
//        FlatIntelliJLaf.setup();
//        java.awt.EventQueue.invokeLater(() -> {
//            new MainSystem().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private menu.MainForm mainForm;
    private menu.Menu menu1;
    private javax.swing.JCheckBoxMenuItem menuDarkMode;
    private menu.MenuItem menuItem1;
    private menu.MenuItem menuItem2;
    private menu.MenuItem menuItem3;
    private menu.MenuItem menuItem4;
    private menu.MenuItem menuItem5;
    private menu.MenuItem menuItem6;
    private menu.SubMenuPanel subMenuPanel1;
    // End of variables declaration//GEN-END:variables
}
