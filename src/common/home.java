package common;

import ads.*;
import create.createStep1;
import dao.AnnonceDao;
import dao.CritereDao;
import dao.jpa.JpaAnnonceDao;
import dao.jpa.JpaCritereDao;
import dao.jpa.JpaUtilisateurDao;
import entities.AnnonceEntity;
import entities.CritereEntity;
import entities.UtilisateurEntity;
import entities.ValeurPossibleEntity;
import mockDBB.CritereDTO;
import mockDBB.DDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class home {
    private JPanel panelMain;
    private JButton searchAdBtn;

    private JPanel header;
    private JLabel tamacoin;
    private JPanel body;
    private JButton filtrerButton;

    private JPanel list;
    private JButton addAdBtn;
    private JPanel filters;
    private JLabel number_ads;
    private JButton myAccountBtn;

    private searchFields searchFields;
    private UtilisateurEntity user;

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

    public home(searchFields searchFields, UtilisateurEntity user) {
        this.user = user;
        if(this.user != null) {
            this.myAccountBtn.setText("Déconnexion");
        }

        this.frame =  new JFrame("app");
        this.searchFields = searchFields;

        AnnonceDao adManager = new JpaAnnonceDao();
        System.out.println(searchFields.toString());
        List<AnnonceEntity> annonces = (List<AnnonceEntity>)((JpaAnnonceDao) adManager).getAnnoncesByCriteres(searchFields.getCategoryId(), searchFields.getCityId(), searchFields.getKeyword(), searchFields.getPriceMin(), searchFields.getPriceMax());


        DDB mockDDB = new DDB();
        List<CritereDTO> criteres = mockDDB.getFilterByCategory();
        //CritereDao critereManager  = new JpaCritereDao();
        //List<CritereEntity> criteres = (List<CritereEntity>) ((JpaCritereDao) critereManager).getByCategoryId(searchFields.getCategoryId());
        //List<ValeurPossibleEntity> valeursPossibles = criteres.get(0).getValeursPossibles();

        filters.setLayout(new BoxLayout(filters, BoxLayout.Y_AXIS));
        criteres.forEach(critereDTO -> {
            filters.add(displayFilterByCheckPoint(critereDTO.critereEntity.getLabel(), critereDTO.valeur));
        });

        this.number_ads.setText(annonces.size() + (annonces.size() > 1 ? " résultats" : " résultat"));

        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        annonces.forEach(annonceEntity -> {
            AdsList prl = new AdsList(annonceEntity.getNom(),annonceEntity.getPrix(),annonceEntity.getDateCreation());
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
            this.list.add(prl.getPanelMain());
        });

        this.actionsListeners();
    }

    public void goToProductsList(int idAnnonce){
        this.getFrame().dispose();

        AdDetails productDetails = new AdDetails(idAnnonce, searchFields, user);
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

    public void actionsListeners() {
        //addAdBtn ----- START
        addAdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                createStep1 create = new createStep1(null, user);
                create.getFrame().setContentPane(create.getPanelMain());
                create.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                create.getFrame().pack();

                create.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                create.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                create.getFrame().setLocationRelativeTo(null);
                create.getFrame().setVisible(true);
            }
        });
        //addAdBtn ----- START

        //searchAdBtn ----- START
        searchAdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Search search = new Search(user);
                search.getFrame().setContentPane(search.getPanelMain());
                search.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                search.getFrame().pack();

                search.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                search.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                search.getFrame().setLocationRelativeTo(null);
                search.getFrame().setVisible(true);
            }
        });
        //searchAdBtn ----- START

        //myAccountBtn ----- START
        myAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                if(user != null){
                    Search search = new Search();
                    search.getFrame().setContentPane(search.getPanelMain());
                    search.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    search.getFrame().pack();

                    search.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    search.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    search.getFrame().setLocationRelativeTo(null);
                    search.getFrame().setVisible(true);
                } else {
                    signin login = new signin();
                    login.getFrame().setContentPane(login.getPanelMain());
                    login.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    login.getFrame().pack();

                    login.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    login.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    login.getFrame().setLocationRelativeTo(null);
                    login.getFrame().setVisible(true);
                }
            }
        });
        //myAccountBtn ----- END

    }
}
