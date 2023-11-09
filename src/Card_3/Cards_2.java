
package Card_3;

//Starting
import ComposantPanelShadow.PanelShadow_2;
import Model_Card.Model_Card_2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Ending

public final class Cards_2 extends PanelShadow_2 {

    public static Connection connex = null;
    public static ResultSet resul = null;
    public static PreparedStatement prepare = null;
    
    public Cards_2() {
        initComponents();
        connex = connexionDB.DatabaseConnection.connex;
        getCard_2();
        init();
    }

    public void setData(Model_Card_2 data) {
        lbIcon.setIcon(data.getIcon());
        lbName.setText(data.getTitle());
        totalProjet.setText(data.getValues());
    }
    private void init() {
        setRadius(25);
    }
    
    public void getCard_2() {
        if (connex != null) {
            // Votre code de préparation de requête et d'exécution ici
            try {

                String requete = "SELECT COUNT(*) as nombre_projets FROM projets";
                prepare = connex.prepareStatement(requete);
                resul = prepare.executeQuery();

                if (resul.next()) {
                    String R1 = resul.getString("nombre_projets");
                    System.out.println(R1);
                    totalProjet.setText(R1);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("La connexion n'est pas initialisée correctement.");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        totalProjet = new javax.swing.JLabel();

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconCard/expense.png"))); // NOI18N

        lbName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbName.setText("Effectif Projet(s)");

        totalProjet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalProjet.setText("$ 0.000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(totalProjet, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalProjet, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel totalProjet;
    // End of variables declaration//GEN-END:variables
}
