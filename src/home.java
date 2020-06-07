import entities.AnnonceEntity;
import mockDBB.CritereDTO;
import mockDBB.DDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

    public JPanel displayFilterByCheckPoint(String name, List<String> values){
        JPanel result = new JPanel();
        result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(name);
        title.setFont(new Font(Font.SANS_SERIF, 1,18));
        result.add(title);
        values.forEach(value -> {
            JLabel val = new JLabel(value);
            JCheckBox checkBox = new JCheckBox();
            val.setFont(new Font(Font.SANS_SERIF, 0, 15));
            JPanel checkPanel = new JPanel();
            checkPanel.add(checkBox);
            checkPanel.add(val);
            checkPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            result.add(checkPanel);
        });
        return result;
    }

    public home(searchFields searchFields) {
        this.frame =  new JFrame("app");
        this.searchFields = searchFields;
        DDB mockDDB = new DDB();
        List<AnnonceEntity> annonces = mockDDB.getAnnonces(null,null,null,null,null);
        List<CritereDTO> criteres = mockDDB.getFilterByCategory();

        panelMain = new JPanel();
        panelMain.setBackground(Color.white);

        header header = new header();
        header.getHeader().setPreferredSize(new Dimension(1800,300));
        panelMain.add(header.getHeader());
        body = new JPanel();

        JPanel filters = new JPanel();
        filters.setLayout(new BoxLayout(filters, BoxLayout.Y_AXIS));
        JLabel filTitle = new JLabel("Filtres");
        filTitle.setFont(new Font(Font.SANS_SERIF, 1,20));
        filters.add(filTitle);

        criteres.forEach(critereDTO -> {
            filters.add(displayFilterByCheckPoint(critereDTO.critereEntity.getLabel(), critereDTO.valeur));
        });
        body.add(filters);

        list= new JPanel();
        annonces.forEach(annonceEntity -> {
            ProductList prl = new ProductList(annonceEntity.getNom(),annonceEntity.getPrix(),annonceEntity.getDateCreation());
            prl.getPanelMain().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    goToProductsList(annonceEntity.getIdAnnonce());
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            list.add(prl.getPanelMain());
        });

        body.add(list);
        panelMain.add(body);
    }

    public void goToProductsList(int idAnnonce){
        this.getFrame().dispose();

        ProductDetails productDetails = new ProductDetails(idAnnonce, searchFields);
        productDetails.getFrame().setContentPane(productDetails.getPanelMain());
        productDetails.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productDetails.getFrame().pack();

        productDetails.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        productDetails.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        productDetails.getFrame().setLocationRelativeTo(null);
        productDetails.getFrame().setVisible(true);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String args[]) {

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
