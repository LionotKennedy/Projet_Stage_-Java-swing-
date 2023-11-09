
package swing;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class VerticalTextLabel extends JLabel {

    public VerticalTextLabel(String text) {
        super(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(-Math.PI / 2); // Rotation de 90 degrés dans le sens antihoraire
        g2.drawString(getText(), -getHeight(), getWidth());
    }
}
