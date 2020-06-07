package ads;

import entities.AnnonceEntity;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.List;

public class AdsList {

    private JLabel title;
    private JLabel price;
    private JLabel category;
    private JLabel date;
    private JPanel panelMain;

    public AdsList(String nom, double price, Timestamp date){
        this.title.setText(nom);
        this.price.setText(String.valueOf(price));
        this.date.setText(date.toString());
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
