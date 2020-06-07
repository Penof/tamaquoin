import entities.AnnonceEntity;
import mockDBB.DDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.text.ParseException;
import java.util.List;

public class home {
    private JPanel panelMain;
    private JButton searchAdBtn;
    private JButton filtrerButton;

    private JPanel list;
    private JButton addAdBtn;
    private JPanel header;
    private JPanel body;
    private JLabel tamacoin;

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

        home.panelMain = new JPanel();
        home.panelMain.setBackground(Color.white);

        header header = new header();
        header.getHeader().setPreferredSize(new Dimension(1800,300));
        home.panelMain.add(header.getHeader());

        home.body = new JPanel();




        home.list= new JPanel();
        annonces.forEach(annonceEntity -> {
            ProductList prl = new ProductList(annonceEntity.getNom(),annonceEntity.getPrix(),annonceEntity.getDateCreation());
            home.list.add(prl.getPanelMain());
        });

        home.body.add(home.list);
        home.panelMain.add(home.body);



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
