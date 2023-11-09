package FenetreModale;

//Starting
import Form.Form_5;
import ShowMessage.MessageImprimente;
import connexionDB.DatabaseConnection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
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

public class FormatPDF extends javax.swing.JFrame {

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
    String R24;
    String R25;

    public FormatPDF() throws SQLException, IOException {
        initComponents();
        con = connexionDB.DatabaseConnection.connex;
        instant = false;
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
                    + "    g.MotantG,\n"
                    + "    g.DateG,\n"
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
                    + "    GAINS g ON g.NumD_ref = f.NumC_ref\n"
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
                DateDepense.setText("  " + R7);

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

                R14 = resul.getString("PrenomC");
                System.out.println(R14);

                R13 = resul.getString("NomC");
                System.out.println(R13);
                NomClient.setText("  " + R13 + "  " + R14);

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

                R24 = resul.getString("MotantG");
                GainsProjet1.setText("  " + R24+ " Ariary");
                System.out.println(R24);

                R25 = resul.getString("DateG");
                DateGains.setText("  " + R25);
                System.out.println(R25);

                if (R1 == null || R2 == null || R3 == null || R6 == null || R7 == null || R8 == null || R9 == null || R10 == null || R11 == null || R12 == null || R13 == null || R5 == null || R16 == null || R18 == null || R19 == null || R21 == null || R22 == null || R23 == null || R24 == null || R25 == null) {
//                    impressionAutorisee = false;
                    JOptionPane.showMessageDialog(this, "Erreur : L'impression est annulée en raison de données manquantes.");
                    instant = true;
                    return;
                } else {
                    CodePDF();
                }
            }
        } catch (SQLException e) {
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
//            g2.scale(0.7, 0.7); // Change the scaling factor here
            double scaleX = 600.0 / 993;
            double scaleY = 800.0 / 1404;
            g2.scale(scaleX, scaleY);

//g2.setTransform(new AffineTransform());
            BufferedImage image = new BufferedImage(contenu.getWidth(), contenu.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2Image = image.createGraphics();
            contenu.print(g2Image);
            g2Image.dispose();
            g2.drawImage(image, 0, 0, null);
//            contenu.print(g2);

            return Printable.PAGE_EXISTS;
        });

        boolean ok = printerJob.printDialog();
        if (ok) {
            try {
                printerJob.print();
//                JOptionPane.showMessageDialog(this, "Impriment");
                imprimente.setVisible(true);

                Animator animator = new Animator(4000); // Durée de l'animation (500ms)
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
//        System.out.println(contenu);
//        System.out.println(printerJob);
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

        contenu = new javax.swing.JPanel();
        DateFacture = new javax.swing.JLabel();
        NumeroFacture = new javax.swing.JLabel();
        NumeroClient = new javax.swing.JLabel();
        NomClient = new javax.swing.JLabel();
        adresseClient = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        numeroProjet = new javax.swing.JLabel();
        ProjetName = new javax.swing.JLabel();
        statusProjet = new javax.swing.JLabel();
        DepenseProjet = new javax.swing.JLabel();
        GainsProjet1 = new javax.swing.JLabel();
        DateDebut = new javax.swing.JLabel();
        DateFin = new javax.swing.JLabel();
        DateDepense = new javax.swing.JLabel();
        DateGains = new javax.swing.JLabel();
        MotantTotal = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        dateDebut = new javax.swing.JLabel();
        EtatPaiement = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenu.setLayout(null);

        DateFacture.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateFacture.setText("DateF Projet");
        contenu.add(DateFacture);
        DateFacture.setBounds(830, 125, 130, 20);

        NumeroFacture.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NumeroFacture.setText("Numero Facture");
        contenu.add(NumeroFacture);
        NumeroFacture.setBounds(840, 150, 127, 20);

        NumeroClient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NumeroClient.setText("numero.");
        contenu.add(NumeroClient);
        NumeroClient.setBounds(274, 345, 160, 20);

        NomClient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NomClient.setText("Nom Client");
        contenu.add(NomClient);
        NomClient.setBounds(330, 370, 530, 20);

        adresseClient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        adresseClient.setText("Antaravay");
        contenu.add(adresseClient);
        adresseClient.setBounds(260, 395, 480, 20);

        contact.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contact.setText("Contact");
        contact.setToolTipText("");
        contenu.add(contact);
        contact.setBounds(300, 420, 310, 20);

        Email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Email.setText("Email");
        contenu.add(Email);
        Email.setBounds(250, 445, 600, 20);

        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoLoginRegister.png"))); // NOI18N
        contenu.add(Logo);
        Logo.setBounds(740, 30, 130, 80);

        numeroProjet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numeroProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroProjet.setText("0003");
        contenu.add(numeroProjet);
        numeroProjet.setBounds(110, 520, 110, 30);

        ProjetName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProjetName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProjetName.setText("Java");
        contenu.add(ProjetName);
        ProjetName.setBounds(220, 520, 200, 30);

        statusProjet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        statusProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusProjet.setText("Etat");
        contenu.add(statusProjet);
        statusProjet.setBounds(420, 520, 100, 30);

        DepenseProjet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DepenseProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DepenseProjet.setText("2000000AR");
        contenu.add(DepenseProjet);
        DepenseProjet.setBounds(520, 520, 180, 30);

        GainsProjet1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        GainsProjet1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GainsProjet1.setText("2000000AR");
        contenu.add(GainsProjet1);
        GainsProjet1.setBounds(710, 520, 170, 30);

        DateDebut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateDebut.setText("DateD Projet");
        contenu.add(DateDebut);
        DateDebut.setBounds(290, 580, 250, 20);

        DateFin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateFin.setText("DateF Projet");
        contenu.add(DateFin);
        DateFin.setBounds(290, 605, 280, 20);

        DateDepense.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateDepense.setText("10/10/2023");
        contenu.add(DateDepense);
        DateDepense.setBounds(270, 630, 320, 20);

        DateGains.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DateGains.setText("10/10/2023");
        contenu.add(DateGains);
        DateGains.setBounds(240, 650, 320, 25);

        MotantTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MotantTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MotantTotal.setText("20000Ar");
        contenu.add(MotantTotal);
        MotantTotal.setBounds(670, 740, 210, 30);

        description.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        description.setText("blabla");
        contenu.add(description);
        description.setBounds(310, 795, 580, 30);

        dateDebut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateDebut.setText("10/10/2023");
        contenu.add(dateDebut);
        dateDebut.setBounds(260, 825, 560, 25);

        EtatPaiement.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EtatPaiement.setText("Payer");
        contenu.add(EtatPaiement);
        EtatPaiement.setBounds(270, 850, 240, 25);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/facture_template_5_1.png"))); // NOI18N
        contenu.add(jLabel1);
        jLabel1.setBounds(0, 0, 980, 1410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenu, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenu, javax.swing.GroupLayout.PREFERRED_SIZE, 1408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    /**
     *
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FormatPDF().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormatPDF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FormatPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateDebut;
    private javax.swing.JLabel DateDepense;
    private javax.swing.JLabel DateFacture;
    private javax.swing.JLabel DateFin;
    private javax.swing.JLabel DateGains;
    private javax.swing.JLabel DepenseProjet;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel EtatPaiement;
    private javax.swing.JLabel GainsProjet1;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MotantTotal;
    private javax.swing.JLabel NomClient;
    private javax.swing.JLabel NumeroClient;
    private javax.swing.JLabel NumeroFacture;
    private javax.swing.JLabel ProjetName;
    private javax.swing.JLabel adresseClient;
    private javax.swing.JLabel contact;
    private javax.swing.JPanel contenu;
    private javax.swing.JLabel dateDebut;
    private javax.swing.JLabel description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel numeroProjet;
    private javax.swing.JLabel statusProjet;
    // End of variables declaration//GEN-END:variables
}
