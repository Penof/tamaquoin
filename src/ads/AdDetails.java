package ads;

import common.*;
import dao.AnnonceDao;
import dao.jpa.JpaAnnonceDao;
import entities.AnnonceEntity;
import entities.UtilisateurEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class AdDetails {
    private JPanel panelMain;
    private JPanel image;
    private JButton retourButton;
    private JLabel productName;
    private JLabel price;
    private JLabel description;
    private JLabel username;
    private JLabel date;
    private searchFields searchFields;
    private JFrame frame;

    private UtilisateurEntity user;

    public AdDetails(int idAnnonce, searchFields searchFields, UtilisateurEntity user) {

        this.user = user;

        this.searchFields = searchFields;
        panelMain.addComponentListener(new ComponentAdapter() {
        });
        this.frame =  new JFrame("app");

        AnnonceDao annonceManager = new JpaAnnonceDao();
        AnnonceEntity annonce = annonceManager.find(AnnonceEntity.class,idAnnonce);
        productName.setText(annonce.getNom());
        description.setText(annonce.getDescription());
        price.setText(String.valueOf(annonce.getPrix()));
        date.setText(annonce.getDateCreation().toString());

        retourButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                goToProductsList();
            }
        });
    }

    public void goToProductsList(){
        this.getFrame().dispose();

        Home home = new Home(searchFields, user);
        home.getFrame().setContentPane(home.getPanelMain());
        home.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.getFrame().pack();

        home.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        home.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.getFrame().setLocationRelativeTo(null);
        home.getFrame().setVisible(true);
    }

    public JPanel ProductDetails() {
        return this.panelMain;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
