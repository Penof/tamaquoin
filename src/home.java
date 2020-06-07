import entities.AnnonceEntity;
import mockDBB.DDB;

import javax.swing.*;
import java.text.ParseException;
import java.util.List;

public class home {
    private JPanel panelMain;
    private JButton searchAdBtn;
    private JButton filtrerButton;


    private JPanel list;
    private JButton addAdBtn;

    private searchFields searchFields;

    private JFrame frame;

    public home(searchFields searchFields) {
        this.frame =  new JFrame("app");
        this.searchFields = searchFields;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String args[]) throws ParseException {

        JFrame frame = new JFrame("app");
        home home = new home(null);

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
