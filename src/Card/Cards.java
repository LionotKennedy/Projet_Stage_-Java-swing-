package Card;

// Starting
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import javaswingdev.GradientType;
// Ending

public class Cards extends javax.swing.JPanel {

    private GoogleMaterialDesignIcon icon;

    public Cards() {
        initComponents();
        init();
    }

    private void init() {
        setOpaque(false);
        setBackground(Color.WHITE);
        setIcon(GoogleMaterialDesignIcon.AUTORENEW);
    }

    public void setIcon(GoogleMaterialDesignIcon icon) {
        this.icon = icon;
        IconLabel.setIcon(new GoogleMaterialIcon(icon, GradientType.DIAGONAL_1, new Color(191, 191, 191), Color.WHITE, 32).toIcon());
    }

    public GoogleMaterialDesignIcon getIcon() {
        return icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Area area = new Area(new RoundRectangle2D.Double(0, 20, getWidth(), getHeight() - 20, 10, 10));
        g2.setColor(getBackground());
        g2.fill(area);
        area.subtract(new Area(new Rectangle2D.Double(0, 20, getWidth(), getHeight() - 23)));
        g2.setPaint(new GradientPaint(0, 0, IconLabel.getColor1(), getWidth(), 0, IconLabel.getColor2()));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }

    public Color getColor1() {
        return IconLabel.getColor1();
    }

    public void setColor1(Color color1) {
        IconLabel.setColor1(color1);
    }

    public Color getColor2() {
        return IconLabel.getColor2();
    }

    public void setColor2(Color color2) {
        IconLabel.setColor2(color2);
    }

    public void setDescription(String description) {
        DescriptionLabel.setText(description);
    }

    public String getDescription() {
        return DescriptionLabel.getText();
    }

    public void setValues(String values) {
        ValuesLabel.setText(values);
    }

    public String getValues() {
        return ValuesLabel.getText();
    }

    public void setData(ModelCard data) {
        ValuesLabel.setText(data.getValues());
        DescriptionLabel.setText(data.getDescription());
        if (data.getColor1() != null) {
            setColor1(data.getColor1());
        }
        if (data.getColor2() != null) {
            setColor2(data.getColor2());
        }
        if (data.getIcon() != null) {
            setIcon(data.getIcon());
        }
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ValuesLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        IconLabel = new Card.LabelIcon();

        jLabel1.setText("jLabel1");

        ValuesLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        ValuesLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ValuesLabel.setText("$ 0.00");

        DescriptionLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        DescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DescriptionLabel.setText("Report Income Monthly");

        IconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ValuesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ValuesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescriptionLabel;
    private Card.LabelIcon IconLabel;
    private javax.swing.JLabel ValuesLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
