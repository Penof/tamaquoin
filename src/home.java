import entities.AnnonceEntity;
import mockDBB.DDB;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.List;

public class home {
    private JPanel panelMain;
    private JButton proposerUneAnnonceButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JTextField textField3;
    private JButton rechercherButton;
    private JButton filtrerButton;
    private JPanel list;

    public JPanel home() {
        return this.panelMain;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public static void main(String args[]) throws ParseException {

        JFrame frame = new JFrame("app");
        home home = new home();

        DDB mockDDB = new DDB();
        List<AnnonceEntity> annonces = mockDDB.getAnnonces(null,null,null,null,null);
        home.list=new JPanel();

        annonces.forEach(annonceEntity -> {
            ProductList prl = new ProductList(annonceEntity.getNom(),annonceEntity.getPrix(),annonceEntity.getDateCreation());
            home.list.add(prl.getPanelMain());
        });


        //end
        frame.setContentPane(home.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
