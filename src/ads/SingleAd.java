package ads;

import entities.AnnonceEntity;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.List;

public class SingleAd {

    private JLabel title;
    private JLabel price;
    private JLabel category;
    private JLabel date;
    private JPanel panelMain;
    private JLabel ville;
    private JLabel description;

    public SingleAd(AnnonceEntity annonce){
        this.title.setText(annonce.getNom());
        this.description.setText(annonce.getDescription());
        this.date.setText(annonce.getDateCreation().toString());
        this.price.setText(annonce.getPrix() + " €");
        this.ville.setText(annonce.getCoordonnee().getVille());
        this.category.setText(annonce.getSousCategorie().getLabel());
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
