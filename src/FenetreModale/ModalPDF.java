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
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;
//Ending

public class ModalPDF extends javax.swing.JFrame {

    public static Connection con = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    static boolean instant;
    MessageImprimente imprimente = new MessageImprimente();

    public ModalPDF() {
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
                String R1 = resul.getString("DateF");
                System.out.println(R1);
                DateFacture.setText(R1);

                String R2 = resul.getString("NumeroF");
                System.out.println(R2);
                NumeroFacture.setText(R2);

                String R3 = resul.getString("MotantTo");
                MotantTotal.setText(R3);
                System.out.println(R3);

                String R4 = resul.getString("Etat");
                System.out.println(R4);
                EtatFacutre.setText(R4);

                String R5 = resul.getString("NumC_ref");
                System.out.println(R5);

                String R6 = resul.getString("MotantD");
                System.out.println(R6);
                DepenseProjet.setText(R6);

                String R7 = resul.getString("DateD");
                System.out.println(R7);

                String R8 = resul.getString("NomP");
                System.out.println(R8);
                ProjetName.setText(R8);

                String R9 = resul.getString("Status");
                System.out.println(R9);
                statusProjet.setText(R9);

                String R10 = resul.getString("DateDP");
                System.out.println(R10);
                DateDebut.setText(R10);

                String R11 = resul.getString("DateFP");
                System.out.println(R11);
                DateFin.setText(R11);

                String R12 = resul.getString("IDClient");
                System.out.println(R12);
                NumeroClient.setText(R12);

                String R13 = resul.getString("NomC");
                System.out.println(R13);
                NomClient.setText(R13);

                String R14 = resul.getString("PrenomC");
                System.out.println(R14);

                String R15 = resul.getString("AdresseC");
                System.out.println(R15);
                adresseClient.setText(R15);

                String R16 = resul.getString("NumeroC");
                System.out.println(R16);
                contact.setText(R16);

                String R17 = resul.getString("ID");
                System.out.println(R17);

                String R18 = resul.getString("EmailC");
                Email.setText(R18);
                System.out.println(R18);

                String R19 = resul.getString("DateDA");
                dateDebut.setText(R19);
                System.out.println(R19);

                String R20 = resul.getString("DateFA");
                DateFinActivite.setText(R20);
                System.out.println(R20);

                String R21 = resul.getString("DescrA");
                description.setText(R21);
                System.out.println(R21);

                String R22 = resul.getString("Etat");
                EtatPaiement.setText(R22);
                System.out.println(R22);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void CodePDF() throws SQLException, IOException {
        RecuperationDonne();
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
            roundPanel1.print(g2);

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

    public boolean isInstant() {
        return instant;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        roundPanel1 = new swing_Home.RoundPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        DateFacture = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        NomClient = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        adresseClient = new javax.swing.JLabel();
        NumeroClient = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        EtatFacutre = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ProjetName = new javax.swing.JLabel();
        statusProjet = new javax.swing.JLabel();
        DepenseProjet = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        MotantTotal = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        DateFinActivite = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        EtatPaiement = new javax.swing.JLabel();
        dateDebut = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        DateDebut = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        DateFin = new javax.swing.JLabel();
        NumeroFacture = new javax.swing.JLabel();
        pdf = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconHome/facture.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        roundPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 70, 880));

        jLabel1.setBackground(new java.awt.Color(243, 12, 41));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Open-DataMadagascar");
        roundPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 29, 169, 29));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoLoginRegister.png"))); // NOI18N
        roundPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 29, 130, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("openData-Madagascar 0120 B 282 IVORY");
        roundPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 58, 284, 37));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Antsirabe, Madagascar");
        roundPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 95, 192, 26));

        jPanel3.setBackground(new java.awt.Color(224, 74, 219));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        roundPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 143, 715, 2));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(224, 74, 219));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Facture ");
        roundPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 88, 24));

        DateFacture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateFacture.setText("DateF Projet");
        roundPanel1.add(DateFacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 97, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(224, 74, 219));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Adresse Client");
        roundPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 88, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(224, 74, 219));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Evoyer");
        roundPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 88, 24));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(224, 74, 219));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Date");
        roundPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 88, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(224, 74, 219));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Numero Client");
        roundPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 90, 20));

        NomClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NomClient.setText("Nom Client");
        roundPanel1.add(NomClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 170, 24));

        Email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Email.setText("Email");
        roundPanel1.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 250, 26));

        contact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contact.setText("Contact");
        roundPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 160, 26));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("10/10/2023");
        roundPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 97, 24));

        adresseClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adresseClient.setText("Antaravay");
        roundPanel1.add(adresseClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 120, 26));

        NumeroClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumeroClient.setText("123456");
        roundPanel1.add(NumeroClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 97, 26));

        jPanel4.setBackground(new java.awt.Color(222, 154, 219));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 5));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Numero");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Nom projet");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Status");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Depense");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        roundPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 720, 30));

        EtatFacutre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EtatFacutre.setText("Etat");
        roundPanel1.add(EtatFacutre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 97, 26));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("0003");
        roundPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 97, 24));

        ProjetName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProjetName.setText("Java");
        roundPanel1.add(ProjetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 426, 97, 30));

        statusProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusProjet.setText("Etat");
        roundPanel1.add(statusProjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 190, 26));

        DepenseProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DepenseProjet.setText("2000000AR");
        roundPanel1.add(DepenseProjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 97, 24));

        jPanel6.setBackground(new java.awt.Color(224, 74, 219));
        jPanel6.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        roundPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 567, 715, 2));

        jLabel27.setBackground(new java.awt.Color(243, 12, 41));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Total :");
        roundPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 88, 24));

        MotantTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundPanel1.add(MotantTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 100, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(224, 74, 219));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Modalite de paiement");
        roundPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 600, 150, 24));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Date Activite");
        roundPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 97, 24));

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Description activite");
        roundPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 720, 120, 26));

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Etat du paiement");
        roundPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 790, 120, 26));

        DateFinActivite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateFinActivite.setText("10/10/2023");
        roundPanel1.add(DateFinActivite, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 650, 70, 24));

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("a");
        roundPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 20, 24));

        description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        description.setText("blabla");
        roundPanel1.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 720, 150, 26));

        EtatPaiement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EtatPaiement.setText("Payer");
        roundPanel1.add(EtatPaiement, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 790, 140, 26));

        dateDebut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateDebut.setText("10/10/2023");
        roundPanel1.add(dateDebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, 80, 24));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Ariary");
        roundPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 60, 20));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Ariary");
        roundPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 50, 30));

        DateDebut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateDebut.setText("DateD Projet");
        roundPanel1.add(DateDebut, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 97, 24));

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("a");
        roundPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 650, 20, 24));

        DateFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateFin.setText("DateF Projet");
        roundPanel1.add(DateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 97, 20));

        NumeroFacture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumeroFacture.setText("Numero Facture");
        roundPanel1.add(NumeroFacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 110, 20));

        pdf.setText("PDF");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pdf)
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        //               JPanel panelToPrint = roundPanel1.getPanelToPrint();

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
            roundPanel1.print(g2);

            return Printable.PAGE_EXISTS;
        });

        boolean ok = printerJob.printDialog();
        if (ok) {
            try {
                printerJob.print();
                JOptionPane.showMessageDialog(this, "Impriment");
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_pdfActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        DatabaseConnection.LoadConnexion();
        java.awt.EventQueue.invokeLater(() -> {
            new ModalPDF().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateDebut;
    private javax.swing.JLabel DateFacture;
    private javax.swing.JLabel DateFin;
    private javax.swing.JLabel DateFinActivite;
    private javax.swing.JLabel DepenseProjet;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel EtatFacutre;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton pdf;
    private swing_Home.RoundPanel roundPanel1;
    private javax.swing.JLabel statusProjet;
    // End of variables declaration//GEN-END:variables
}
