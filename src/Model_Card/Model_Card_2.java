
package Model_Card;

import javax.swing.Icon;

public class Model_Card_2 {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

   public Model_Card_2(Icon icon, String title, String values, String _Utilisateurs, String effetif_utilisateurs) {
    this.icon = icon;
    this.title = title;
    this.values = values;
}
   
    public Model_Card_2() {
    }

    private Icon icon;
    private String title;
    private String values;
}

