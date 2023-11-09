package Form;

//Starting
import FenetreModale.AddFacture;
import FenetreModale.FormatPDF;
import FenetreModale.UpdateFacture;
import ModalShow.ShowFacture;
import ShowMessage.MessageConnexion;
import ShowMessage.MessageEmailSucces;
import ShowMessage.MessageErreur;
import ShowMessage.MessageSupression;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
import java.io.IOException;
import java.net.InetAddress;
import model.ModelMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.TableColumnModel;
//Ending

//Anothers
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending Anothers

public class Form_5 extends javax.swing.JPanel {

    public static Connection connex = null;
    public static java.sql.ResultSet resul = null;
    public static PreparedStatement prepare = null;

    static String dataFacture;
    static String R18;

    String facture;
//    JTextArea facture;

    String test = "Adresse e-mail invalide.";

    public Form_5() throws SQLException, IOException {

        initComponents();
        connex = connexionDB.DatabaseConnection.connex;
        tableDefault1.fixTable(jScrollPane1);
        DisplayClient();
//        tableDefault1.setColumnVisible(0, false);
        SearchFacturation.setOpaque(false);
        roundPanel1.setOpaque(false);
        SearchFacturation.setBackground(new Color(242, 242, 242));
    }

    public void Recuperation() {
        try {
            int row = tableDefault1.getSelectedRow();
            int columnIndex = 0;
            if (row != -1) { // Vérifier si une ligne est sélectionnée
                Form_5.dataFacture = (tableDefault1.getModel().getValueAt(row, columnIndex).toString());
                // Reste du code de récupération des données
//                String request = "SELECT * FROM depenses WHERE IDD='" + dataFacture + "' ";
                String requete = "SELECT\n"
                        + "    f.DateF,\n"
                        + "    f.NumeroF,\n"
                        + "    f.MotantTo,\n"
                        + "    f.Etat,\n"
                        + "    f.ID,\n"
                        + "    f.NumC_ref,\n"
                        + "    d.MotantD,\n"
                        + "    d.DateD,\n"
                        + "    g.MotantG,\n"
                        + "    g.DateG,\n"
                        + "    p.NomP,\n"
                        + "    p.Status,\n"
                        + "    p.DateDP,\n"
                        + "    p.DateFP,\n"
                        + "    p.IDP,\n"
                        + "    c.IDClient,\n"
                        + "    c.NomC,\n"
                        + "    c.PrenomC,\n"
                        + "    c.AdresseC,\n"
                        + "    c.NumeroC,\n"
                        + "    c.EmailC,\n"
                        + "    a.DateDA,\n"
                        + "    a.DateFA,\n"
                        + "    a.DescrA\n"
                        + "FROM\n"
                        + "    FACTURES f\n"
                        + "INNER JOIN\n"
                        + "    CLIENTS c ON f.NumC_ref = c.IDClient\n"
                        + "LEFT JOIN\n"
                        + "    DEPENSES d ON d.NumD_ref = f.NumC_ref\n"
                        + "LEFT JOIN\n"
                        + "    GAINS g ON g.NumD_ref = f.NumC_ref\n"
                        + "LEFT JOIN\n"
                        + "    PROJETS p ON p.NumC_ref = c.IDClient\n"
                        + "LEFT JOIN\n"
                        + "    ACTIVITES a ON a.NumA_ref = p.IDP WHERE ID ='" + dataFacture + "' ";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("DateF");
                    System.out.println(R1);
                    String R2 = resul.getString("NumeroF");
                    System.out.println(R2);
                    String R3 = resul.getString("MotantTo");
                    System.out.println(R3);
                    String R4 = resul.getString("Etat");
                    System.out.println(R4);
                    String R5 = resul.getString("NumC_ref");
                    System.out.println(R5);
                    String R6 = resul.getString("MotantD");
                    System.out.println(R6);
                    String R7 = resul.getString("DateD");
                    System.out.println(R7);
                    String R8 = resul.getString("NomP");
                    System.out.println(R8);
                    String R9 = resul.getString("Status");
                    System.out.println(R9);
                    String R10 = resul.getString("DateDP");
                    System.out.println(R10);
                    String R11 = resul.getString("DateFP");
                    System.out.println(R11);
                    String R12 = resul.getString("IDClient");
                    System.out.println(R12);
                    String R13 = resul.getString("NomC");
                    System.out.println(R13);
                    String R14 = resul.getString("PrenomC");
                    System.out.println(R14);
                    String R15 = resul.getString("AdresseC");
                    System.out.println(R15);
                    String R16 = resul.getString("NumeroC");
                    System.out.println(R16);
                    String R17 = resul.getString("ID");
                    System.out.println(R17);
                    String R18 = resul.getString("EmailC");
                    System.out.println(R18);
                    String R19 = resul.getString("DateDA");
                    System.out.println(R19);
                    String R20 = resul.getString("DateFA");
                    System.out.println(R20);
                    String R21 = resul.getString("DateFA");
                    System.out.println(R21);
                    String R24 = resul.getString("MotantG");
                    System.out.println(R24);
                    String R25 = resul.getString("DateG");
                    System.out.println(R25);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("hahahahahahahahahahahahahahahaha" + dataFacture);
    }

    public String GetTableResult() {
        return dataFacture;
    }

    public String getSalut() {
        return test;
    }

    public void test() {
        teste t = new teste();

        try {

            MessageFormat header = new MessageFormat("Reçu");
            MessageFormat footer = new MessageFormat("pages{0,number,integer}");

            try {

                String R2 = resul.getString("NumeroF");
                System.out.println(R2);

                JOptionPane.showMessageDialog(this, "le facture numero : " + R2);
                String R1 = resul.getString("DateF");
                System.out.println(R1);

                String R3 = resul.getString("MotantTo");
                System.out.println(R3);

                String R4 = resul.getString("Etat");
                System.out.println(R4);

                String R5 = resul.getString("NumC_ref");
                System.out.println(R5);

                String R6 = resul.getString("MotantD");
                System.out.println(R6);

                String R7 = resul.getString("DateD");
                System.out.println(R7);

                String R8 = resul.getString("NomP");
                System.out.println(R8);

                String R9 = resul.getString("Status");
                System.out.println(R9);

                String R10 = resul.getString("DateDP");
                System.out.println(R10);

                String R11 = resul.getString("DateFP");
                System.out.println(R11);

                String R12 = resul.getString("IDClient");
                System.out.println(R12);

                String R13 = resul.getString("NomC");
                System.out.println(R13);

                String R14 = resul.getString("PrenomC");
                System.out.println(R14);

                String R15 = resul.getString("AdresseC");
                System.out.println(R15);

                String R16 = resul.getString("NumeroC");
                System.out.println(R16);

                String R17 = resul.getString("ID");
                System.out.println(R17);

                R18 = resul.getString("EmailC");
                System.out.println(R18);

                String R19 = resul.getString("DateDA");
                System.out.println(R19);

                String R20 = resul.getString("DateFA");
                System.out.println(R20);

                String R21 = resul.getString("DescrA");
                System.out.println(R21);

                String R22 = resul.getString("IDP");
                System.out.println(R22);

                String R24 = resul.getString("MotantG");
                System.out.println(R24);

                String R25 = resul.getString("DateG");
                System.out.println(R25);

                // Vérification si l'un des attributs est null
                if (R1 == null || R2 == null || R3 == null || R4 == null || R5 == null || R6 == null || R7 == null || R8 == null || R9 == null || R10 == null || R11 == null || R12 == null || R13 == null || R14 == null || R15 == null || R16 == null || R17 == null || R18 == null || R19 == null || R20 == null || R21 == null || R22 == null) {
//                    System.out.println("Erreur: Données manquantes");
                    JOptionPane.showMessageDialog(this, "Erreur: Données manquantes.Veuillez verifier l'information concernant cette Clients");
                    return;
                } else {
                    PrinterJob printerJob = PrinterJob.getPrinterJob();
                    facture = "\t" + "\t" + "\t" + "\t" + "                         N° Facture:" + " " + R2 + " " + "\n"
                            + "\t" + "\t" + "\t" + "\t" + "                          🔸🔸🔸🔸🔸🔸🔸" + "\n" + "\n" + "\n"
                            + "\t" + "OpenData-Madagascar" + "\n" + "\n"
                            + "\t" + "OpenData-Madagascar 0120 B 282 IVORY" + "\n" + "\n"
                            + "\t" + "Antsirabe, Madagascar" + "\n" + "\n"
                            + "\t" + "🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻🔻" + "\n" + "\n"
                            + "\t" + "FACTURE" + "\t" + "\t" + "\t" + "                                     ENVOYER" + "\n" + "\n"
                            + "\t" + "Date Facture:" + " " + R1 + "\t" + "\t" + "                       Nom Client:" + " " + R13 + "\n" + "\n"
                            + "\t" + "Etat Facture:" + " " + R4 + "\t" + "\t" + "                         Numero Client:" + " " + R12 + "\n" + "\n"
                            + "\t" + "Total:" + " " + R3 + "Ariary" + "\t" + "\t" + "                       Contact:" + " " + R16 + "\n" + "\n"
                            + "\t" + "\t" + "\t" + "\t" + "Adresse Client:" + " " + R15 + "\n" + "\n"
                            + "\t" + "Couriel Client:" + " " + R18 + "\n" + "\n"
                            + "\t" + "\t" + "----------------------------------------------------------------------" + "\n"
                            + "\t" + "\t" + "\t" + "\t" + "                         PROJET" + "\n"
                            + "\t" + "\t" + "-----------------------------------------------------------------------" + "\n" + "\n"
                            + "\t" + "Nom Projet:" + " " + R8 + "\t" + "\t" + "\t" + "                          Date Debut du projet:" + " " + R10 + "\n" + "\n"
                            + "\t" + "Status Projet:" + " " + R9 + "\t" + "\t" + "\t" + "                   Date Fin du projet:" + " " + R11 + "\n" + "\n"
                            + "\t" + "Depense:" + " " + R6 + "Ariary" + "\t" + "\t" + "\t" + "                    Date Depenses:" + " " + R7 + "\n" + "\n"
                            + "\t" + "Gains:" + " " + R24 + "Ariary" + "\t" + "\t" + "\t" + "                    Date Gains:" + " " + R25 + "\n" + "\n"
                            + "\t" + "\t" + "----------------------------------------------------------------------" + "\n"
                            + "\t" + "\t" + "\t" + "\t" + "                         ACTIVITE" + "\n"
                            + "\t" + "\t" + "------------------------------------------------------------------------" + "\n" + "\n"
                            + "\t" + "Date Debut Activite:" + " " + R19 + "\t" + "\t" + "\t" + "             Description:" + " " + R21 + "\n" + "\n"
                            + "\t" + "Date Fin Activite:" + " " + R20 + "\t" + "\t" + "\t" + "                 Etats de la Paiement:" + " " + R4 + "\n" + "\n"
                            + "\t" + "🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺🔺" + "\n" + "\n" //                            + "\t" + "Le présent communiqué sera enregistré et communiqué partout où besoin sera."
                            ;
                }

            } catch (HeadlessException | SQLException e) {
                System.out.println(e);
            }
            DisplayClient();

        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ModelMessage Email() throws IOException, SQLException {
        MessageConnexion NoConn = new MessageConnexion();
        MessageEmailSucces succes = new MessageEmailSucces();
        MessageErreur erreur = new MessageErreur();
        ModelMessage ms = new ModelMessage(false, "");
//        String from = "******@gmail.com";
        test();

        JOptionPane.showMessageDialog(this, "L'adresse Email du Client est: " + R18);
//        JOptionPane.showMessageDialog(this, "\t\t\t\t\t\t\t\t\t\t\t\tFACTURE\n" + facture);
        if (!isInternetConnected()) {
            ms.setMessage("Pas de connexion internet.");
            NoConn.setVisible(true);
            Animator animator = new Animator(4000); // Durée de l'animation (500ms)
            animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
            animator.addTarget(new TimingTargetAdapter() {
                @Override
                public void timingEvent(float fraction) {
                    // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                    // en fonction de l'avancement de l'animation, par exemple :
                    NoConn.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
                }

                @Override
                public void end() {
                    // Fermer la fenêtre après la fin de l'animation
                    NoConn.dispose();
                }
            });

            animator.start();
            return ms;
        } else {
            String from = "opendata.m@gmail.com";
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            String username = "jwicheer14344@gmail.com";
            String password = "rxkc vkvk nzzg qhya";    //  Your email password here
            Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(R18));
                message.setSubject("Code de vérification.");
                message.setText(facture);
//                message.setText(content);
                Transport.send(message);
                ms.setSuccess(true);
                succes.setVisible(true);
                Animator animator = new Animator(4000); // Durée de l'animation (500ms)
                animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
                animator.addTarget(new TimingTargetAdapter() {
                    @Override
                    public void timingEvent(float fraction) {
                        // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                        // en fonction de l'avancement de l'animation, par exemple :
                        succes.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
                    }

                    @Override
                    public void end() {
                        // Fermer la fenêtre après la fin de l'animation
                        succes.dispose();
                    }
                });
                animator.start();

            } catch (MessagingException e) {
                // Gérer les erreurs d'envoi d'e-mail
                if (e.getMessage().equals("Adresses invalides")) {
                    ms.setMessage("Adresse e-mail invalide.");
                    erreur.valide1();
                } else {
                    ms.setMessage("Erreur lors de l'envoi de l'e-mail");
                }
            }
        }

        return ms;
    }

    private boolean isInternetConnected() {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            return address.isReachable(5000); // Définissez le délai d'attente en millisecondes selon vos besoins
        } catch (IOException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing_Home.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDefault1 = new swing_Home.table.TableDefault();
        BtnModalUpdate = new menu.MenuItem();
        BtnDelete = new menu.MenuItem();
        BtnAddModale = new menu.MenuItem();
        PDF = new menu.MenuItem();
        Gmail = new swing.Button();
        SearchFacturation = new swing_Dialog.TextField();
        Actualisation = new menu.MenuItem();
        ShowFacture = new menu.MenuItem();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setPreferredSize(new java.awt.Dimension(948, 425));
        roundPanel1.setRound(20);

        tableDefault1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N Facture", "N Client", "Nom Client", "Etat", "Motant", "Date facture", "N Telephone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDefault1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDefault1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDefault1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDefault1);

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
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnModalUpdate.setForeground(new java.awt.Color(255, 255, 255));
        BtnModalUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/edit-folder-64.png"))); // NOI18N
        BtnModalUpdate.setText("menuItem1");
        BtnModalUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModalUpdateActionPerformed(evt);
            }
        });

        BtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/delete-folder-64.png"))); // NOI18N
        BtnDelete.setText("menuItem1");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnAddModale.setForeground(new java.awt.Color(255, 255, 255));
        BtnAddModale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/add-folder-64.png"))); // NOI18N
        BtnAddModale.setText("menuItem2");
        BtnAddModale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddModaleActionPerformed(evt);
            }
        });

        PDF.setForeground(new java.awt.Color(255, 255, 255));
        PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/printer-48.png"))); // NOI18N
        PDF.setText("menuItem1");
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        Gmail.setBackground(new java.awt.Color(200, 39, 228));
        Gmail.setForeground(new java.awt.Color(255, 255, 255));
        Gmail.setText("Envoyer Email");
        Gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GmailActionPerformed(evt);
            }
        });

        SearchFacturation.setLabelText("Recherche (n° facture ou nom client)");
        SearchFacturation.setLineColor(new java.awt.Color(200, 39, 228));
        SearchFacturation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFacturationKeyReleased(evt);
            }
        });

        Actualisation.setForeground(new java.awt.Color(255, 255, 255));
        Actualisation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/synchronize.png"))); // NOI18N
        Actualisation.setText("menuItem1");
        Actualisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualisationActionPerformed(evt);
            }
        });

        ShowFacture.setForeground(new java.awt.Color(255, 255, 255));
        ShowFacture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCrud/folder-100.png"))); // NOI18N
        ShowFacture.setText("menuItem1");
        ShowFacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowFactureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Actualisation, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(364, 364, 364)
                        .addComponent(SearchFacturation, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Gmail, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addGap(397, 397, 397)
                                .addComponent(BtnAddModale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(ShowFacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(PDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnModalUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(SearchFacturation, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Actualisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAddModale, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PDF, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModalUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableDefault1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseClicked
        Recuperation();
//        test();
    }//GEN-LAST:event_tableDefault1MouseClicked

    private void tableDefault1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDefault1MouseReleased
        BtnDelete.setEnabled(true);
        BtnModalUpdate.setEnabled(true);
        PDF.setEnabled(true);
        Gmail.setEnabled(true);
        Gmail.setBackground(new Color(200, 39, 228));
//        Gmail.setEnabled(true);
        ShowFacture.setEnabled(true);
    }//GEN-LAST:event_tableDefault1MouseReleased

    private void BtnModalUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModalUpdateActionPerformed
        try {
            UpdateFacture depense = new UpdateFacture();
            depense.setVisible(true);
            depense.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (depense.isInstant()) {
                        try {
                            DisplayClient();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnModalUpdateActionPerformed

    private void BtnAddModaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddModaleActionPerformed
        AddFacture facture = new AddFacture();
        facture.setVisible(true);
        facture.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (facture.isInstant()) {
                    try {
                        DisplayClient();
                    } catch (SQLException ex) {
                        Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_BtnAddModaleActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        try {
            MessageSupression message = new MessageSupression();
            int R2 = resul.getInt("ID");
            if (JOptionPane.showConfirmDialog(null, "Attention vous voulez vraiment supprimer Facture ?",
                    "Supprimer facture", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (R2 != 0) {
                    String request = "DELETE FROM factures WHERE ID = ?";
//                    String request = "DELETE FROM affectations WHERE AncienLieu IN (SELECT lieu FROM employes WHERE numEmp = ?)";
//                    String R1 = resul.getString("numEmp");
                    prepare = connex.prepareStatement(request);
                    prepare.setInt(1, R2);
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
                JOptionPane.showMessageDialog(null, "Veullez selectionner projet");
            }
            DisplayClient();

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFActionPerformed

        PDF.addActionListener((ActionEvent e) -> {
            try {
//                JOptionPane.showMessageDialog(null, "lasa tsik");
                FormatPDF frame2 = new FormatPDF();
                frame2.sortie(); // Appeler une méthode de JFrame2
                if (frame2.isInstant()) {
                    DisplayClient();
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }//GEN-LAST:event_PDFActionPerformed

    private void GmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GmailActionPerformed
        try {
            Email();
//            R18,facture
        } catch (IOException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DisplayClient();
        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GmailActionPerformed

    private void SearchFacturationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFacturationKeyReleased
        String search = SearchFacturation.getText().trim().toLowerCase();
//        String request = "SELECT IDClient AS \"N° CLIENT\",NomC AS \"NOM\",PrenomC AS \"PRENOM\",AdresseC AS \"ADRESSE\",NumeroC AS \"N° TELEPHONE\",EmailC AS \"EMAIL\" FROM clients WHERE LOWER(NomC) LIKE ? OR LOWER(PrenomC) LIKE ?";
        String request = "SELECT\n"
                + "    f.NumeroF AS NUMERO_FACTURE,\n"
                + "    f.NumC_ref AS NUMERO_CLIENT,\n"
                + "    c.NomC AS NOM_CLENT,\n"
                + "    f.Etat AS ETAT,\n"
                + "    f.MotantTo AS MONTANT_TOTAL,\n"
                + "    f.DateF AS DATE_FACTURE,\n"
                + "    c.NumeroC AS CONTACT,\n"
                + "    c.EmailC AS EMAIL\n"
                + "FROM\n"
                + "    FACTURES f\n"
                + "INNER JOIN\n"
                + "    CLIENTS c ON f.NumC_ref = c.IDClient\n" // Ajout d'un espace avant "WHERE"
                + "WHERE LOWER(c.NomC) LIKE ? OR LOWER(f.NumeroF) LIKE ?";
        try {
            prepare = connex.prepareStatement(request);
            prepare.setString(1, "%" + search + "%");
            prepare.setString(2, "%" + search + "%");
            resul = prepare.executeQuery();
            tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));

            BtnDelete.setEnabled(false);
            BtnModalUpdate.setEnabled(false);
            PDF.setEnabled(false);
            Gmail.setEnabled(false);
            Gmail.setBackground(Color.GRAY);
            ShowFacture.setEnabled(false);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_SearchFacturationKeyReleased

    private void ActualisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualisationActionPerformed
        try {
            DisplayClient();
        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualisationActionPerformed

    private void ShowFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowFactureActionPerformed
        try {
            ShowFacture facture = new ShowFacture();
            facture.setVisible(true);
            facture.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    if (facture.isInstant()) {
                        try {
                            DisplayClient();
                        } catch (SQLException ex) {
                            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ShowFactureActionPerformed

    public final void DisplayClient() throws SQLException {
        try {
            String request = "SELECT\n"
                    + "	f.ID AS ID,\n"
                    + "	f.NumeroF AS NUMERO_FACTURE,\n"
                    + "f.NumC_ref AS NUMERO_CLIENT,\n"
                    + "c.NomC AS NOM_CLENT,\n"
                    + " f.Etat AS ETAT,\n"
                    + " f.MotantTo AS MONTANT_TOTAL,\n"
                    + "    f.DateF AS DATE_FACTURE,\n"
                    + " c.NumeroC AS CONTACT,\n"
                    + "c.EmailC AS EMAIL\n"
                    + "       \n"
                    + "FROM\n"
                    + "    FACTURES f\n"
                    + "INNER JOIN\n"
                    + "    CLIENTS c ON f.NumC_ref = c.IDClient";
            prepare = connex.prepareStatement(request);
            resul = prepare.executeQuery();

            tableDefault1.setModel(DbUtils.resultSetToTableModel(resul));

            TableColumnModel columnModel = tableDefault1.getColumnModel();
            int columnIndex = 0;
            columnModel.removeColumn(columnModel.getColumn(columnIndex));

            BtnDelete.setEnabled(false);
            BtnModalUpdate.setEnabled(false);
            PDF.setEnabled(false);
            Gmail.setEnabled(false);
            Gmail.setBackground(Color.GRAY);
            ShowFacture.setEnabled(false);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menu.MenuItem Actualisation;
    private menu.MenuItem BtnAddModale;
    private menu.MenuItem BtnDelete;
    private menu.MenuItem BtnModalUpdate;
    private swing.Button Gmail;
    private menu.MenuItem PDF;
    private swing_Dialog.TextField SearchFacturation;
    private menu.MenuItem ShowFacture;
    private javax.swing.JScrollPane jScrollPane1;
    private swing_Home.RoundPanel roundPanel1;
    private swing_Home.table.TableDefault tableDefault1;
    // End of variables declaration//GEN-END:variables
}
