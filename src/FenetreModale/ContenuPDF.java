package FenetreModale;

//Starting
import Form.Form_5;
import ShowMessage.MessageImprimente;
import connexionDB.DatabaseConnection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class ContenuPDF extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static boolean instant;
    MessageImprimente imprimente = new MessageImprimente();
    boolean impressionAutorisee = true; // Variable de contrôle
    String R1;
    String R2;
    String R3;
    String R4;
    String R5;
    String R6;
    String R7;
    String R8;
    String R9;
    String R10;
    String R11;
    String R12;
    String R13;
    String R14;
    String R15;
    String R16;
    String R17;
    String R18;
    String R19;
    String R20;
    String R21;
    String R22;
    String R23;

    public ContenuPDF() throws SQLException, IOException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        instant = false;
        DateFinActivite.setVisible(false);
//        RecuperationDonne();
    }

    public void RecuperationDonne() throws SQLException, IOException {
        Form_5 information = new Form_5();

        information.Recuperation();

        try {
            String recuprer = information.GetTableResult();
            String request = "SELECT\n"
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
                    + "     p.IDP,\n"
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
                    + "    PROJETS p ON p.NumC_ref = c.IDClient\n"
                    + "LEFT JOIN\n"
                    + "    ACTIVITES a ON a.NumA_ref = p.IDP WHERE ID ='" + recuprer + "' ";
            prepare = con.prepareStatement(request);
            resul = prepare.executeQuery();
            if (resul.next()) {

                R1 = resul.getString("DateF");
                System.out.println("  " + R1);
                DateFacture.setText(R1);

                R2 = resul.getString("NumeroF");
                System.out.println("  " + R2);
                NumeroFacture.setText(R2);

                R3 = resul.getString("MotantTo");
                MotantTotal.setText(R3 + " Ariary");
                System.out.println(R3);

                R4 = resul.getString("Etat");
                System.out.println("  " + R4);
//                EtatFacutre.setText(R4);

                R5 = resul.getString("NumC_ref");
                System.out.println(R5);

                R6 = resul.getString("MotantD");
                System.out.println(R6 + " Ariary");
                DepenseProjet.setText(R6 + " Ariary");

                R7 = resul.getString("DateD");
                System.out.println("  " + R7);
                DateClient.setText("  " + R7 + " ( Date Depense)");

                R8 = resul.getString("NomP");
                System.out.println(R8);
                ProjetName.setText("  " + R8);

                R9 = resul.getString("Status");
                System.out.println("  " + R9);
                statusProjet.setText(R9);

                R10 = resul.getString("DateDP");
                System.out.println("  " + R10);
                DateDebut.setText("  " + R10);

                String R11 = resul.getString("DateFP");
                System.out.println(R11);
                DateFin.setText(" " + R11);

                R12 = resul.getString("IDClient");
                System.out.println(R12);
                NumeroClient.setText("  " + R12);

                R13 = resul.getString("NomC");
                System.out.println(R13);
                NomClient.setText("  " + R13);

                R14 = resul.getString("PrenomC");
                System.out.println(R14);

                R15 = resul.getString("AdresseC");
                System.out.println(R15);
                adresseClient.setText("  " + R15);

                R16 = resul.getString("NumeroC");
                System.out.println(R16);
                contact.setText("  " + R16);

                R17 = resul.getString("ID");
                System.out.println(R17);

                R18 = resul.getString("EmailC");
                Email.setText("  " + R18);
                System.out.println("  " + R18);

                R20 = resul.getString("DateFA");
//                DateFinActivite.setText("  "+R20);
                System.out.println(R20);

                R19 = resul.getString("DateDA");
                dateDebut.setText("  " + R19 + " à " + R20);
                System.out.println("  " + R19);

                R21 = resul.getString("DescrA");
                description.setText("  " + R21);
                System.out.println(R21);

                R22 = resul.getString("Etat");
                EtatPaiement.setText("  " + R22);
                System.out.println(R22);

                R23 = resul.getString("IDP");
                numeroProjet.setText("  " + R23);
                System.out.println(R23);

                if (R1 == null || R2 == null || R3 == null || R6 == null || R7 == null || R8 == null || R9 == null || R10 == null || R11 == null || R12 == null || R13 == null || R5 == null || R16 == null || R18 == null || R19 == null || R21 == null || R22 == null || R23 == null) {
//                    impressionAutorisee = false;
                    JOptionPane.showMessageDialog(this, "Erreur : L'impression est annulée en raison de données manquantes.");
                    instant = true;
                    return;
                } else {
                    CodePDF();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void CodePDF() throws SQLException, IOException {

//        RecuperationDonne();
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Data");

        printerJob.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            pf.setOrientation(PageFormat.LANDSCAPE);
            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
//            g2.scale(0.47,0.47);
            g2.scale(0.7, 0.7); // Change the scaling factor here
            ContenuPanel.print(g2);

            return Printable.PAGE_EXISTS;
        });

        boolean ok = printerJob.printDialog();
        if (ok) {
            try {
                printerJob.print();
//                JOptionPane.showMessageDialog(this, "Impriment");
                imprimente.setVisible(true);

                Animator animator = new Animator(5000); // Durée de l'animation (500ms)
                animator.setInterpolator(new SplineInterpolator(1f, 0f, 1f, 1f)); // Courbe d'interpolation
                animator.addTarget(new TimingTargetAdapter() {
                    @Override
                    public void timingEvent(float fraction) {
                        // Ici, vous pouvez mettre à jour les propriétés de votre fenêtre
                        // en fonction de l'avancement de l'animation, par exemple :
                        imprimente.setOpacity(1 - fraction); // Diminuer l'opacité de la fenêtre
                    }

                    @Override
                    public void end() {
                        // Fermer la fenêtre après la fin de l'animation
                        imprimente.dispose();
                    }
                });

                animator.start();

            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
        instant = true;
    }

    public void sortie() throws SQLException, IOException {
        RecuperationDonne();
    }

    public boolean isInstant() {
        return instant;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContenuPanel = new swing.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NumeroFacture = new javax.swing.JLabel();
        DateFacture = new javax.swing.JLabel();
        NomClient = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        DateClient = new javax.swing.JLabel();
        NumeroClient = new javax.swing.JLabel();
        adresseClient = new javax.swing.JLabel();
        numeroProjet = new javax.swing.JLabel();
        ProjetName = new javax.swing.JLabel();
        statusProjet = new javax.swing.JLabel();
        DepenseProjet = new javax.swing.JLabel();
        DateDebut = new javax.swing.JLabel();
        DateFin = new javax.swing.JLabel();
        MotantTotal = new javax.swing.JLabel();
        DateFinActivite = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        dateDebut = new javax.swing.JLabel();
        EtatPaiement = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pdfProjet.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pdfProjet3.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoLoginRegister.png"))); // NOI18N

        NumeroFacture.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NumeroFacture.setText("Numero Facture");

        DateFacture.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateFacture.setText("DateF Projet");

        NomClient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NomClient.setText("Nom Client");

        contact.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contact.setText("Contact");
        contact.setToolTipText("");

        Email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Email.setText("Email");

        DateClient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateClient.setText("10/10/2023");

        NumeroClient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NumeroClient.setText("10/10/2023");

        adresseClient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        adresseClient.setText("Antaravay");

        numeroProjet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numeroProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroProjet.setText("0003");

        ProjetName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProjetName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProjetName.setText("Java");

        statusProjet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        statusProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusProjet.setText("Etat");

        DepenseProjet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DepenseProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DepenseProjet.setText("2000000AR");

        DateDebut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateDebut.setText("DateD Projet");

        DateFin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateFin.setText("DateF Projet");

        MotantTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        DateFinActivite.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateFinActivite.setText("10/10/2023");

        description.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        description.setText("blabla");

        dateDebut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateDebut.setText("10/10/2023");

        EtatPaiement.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EtatPaiement.setText("Payer");

        javax.swing.GroupLayout ContenuPanelLayout = new javax.swing.GroupLayout(ContenuPanel);
        ContenuPanel.setLayout(ContenuPanelLayout);
        ContenuPanelLayout.setHorizontalGroup(
            ContenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenuPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(ContenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(numeroProjet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(330, 330, 330)
                        .addComponent(statusProjet, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(DateFinActivite, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(DateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(dateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(660, 660, 660)
                        .addComponent(DateFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(790, 790, 790)
                        .addComponent(NumeroFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(DateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(adresseClient, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(DateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(626, 626, 626)
                        .addComponent(MotantTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(NumeroClient, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(EtatPaiement, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(NomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(DepenseProjet, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(ProjetName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(660, 660, 660)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(ContenuPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ContenuPanelLayout.setVerticalGroup(
            ContenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenuPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(ContenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(numeroProjet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(statusProjet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(DateFinActivite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(610, 610, 610)
                        .addComponent(DateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(810, 810, 810)
                        .addComponent(dateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(DateFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(NumeroFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(DateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(adresseClient, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(640, 640, 640)
                        .addComponent(DateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(730, 730, 730)
                        .addComponent(MotantTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(NumeroClient))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(836, 836, 836)
                        .addComponent(EtatPaiement, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(780, 780, 780)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(NomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(DepenseProjet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(556, 556, 556)
                        .addComponent(ProjetName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenuPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(ContenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(ContenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ContenuPDF().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ContenuPDF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ContenuPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.PanelRound ContenuPanel;
    private javax.swing.JLabel DateClient;
    private javax.swing.JLabel DateDebut;
    private javax.swing.JLabel DateFacture;
    private javax.swing.JLabel DateFin;
    private javax.swing.JLabel DateFinActivite;
    private javax.swing.JLabel DepenseProjet;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel EtatPaiement;
    private javax.swing.JLabel MotantTotal;
    private javax.swing.JLabel NomClient;
    private javax.swing.JLabel NumeroClient;
    private javax.swing.JLabel NumeroFacture;
    private javax.swing.JLabel ProjetName;
    private javax.swing.JLabel adresseClient;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel dateDebut;
    private javax.swing.JLabel description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel numeroProjet;
    private javax.swing.JLabel statusProjet;
    // End of variables declaration//GEN-END:variables
}
