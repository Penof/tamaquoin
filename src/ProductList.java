import entities.AnnonceEntity;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.List;

public class ProductList {

    private JLabel title;
    private JLabel price;
    private JLabel category;
    private JLabel date;
    private JPanel panelMain;

    public ProductList(String nom, double price, Timestamp date){
        this.title.setText(nom);
        this.price.setText(String.valueOf(price));
        this.date.setText(date.toString());
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
