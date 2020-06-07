import com.sun.jndi.toolkit.dir.SearchFilter;
import entities.AnnonceEntity;
import mockDBB.DDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class ProductDetails {
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

    public ProductDetails(int idAnnonce, searchFields searchFields) {
        this.searchFields = searchFields;
        panelMain.addComponentListener(new ComponentAdapter() {
        });
        this.frame =  new JFrame("app");
        DDB mockDDB = new DDB();
        AnnonceEntity annonce = mockDDB.getAnnonceById(idAnnonce);
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

        home home = new home(searchFields);
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
