package common;

import ads.*;
import create.createStep1;
import dao.AnnonceDao;
import dao.CritereDao;
import dao.jpa.JpaAnnonceDao;
import dao.jpa.JpaCritereDao;
import entities.AnnonceEntity;
import entities.CritereEntity;
import entities.UtilisateurEntity;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class Home {
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

    private SearchFields searchFields;
    private UtilisateurEntity user;

    private JFrame frame;


    public Home(SearchFields searchFields, UtilisateurEntity user) {
        this.user = user;
        if(this.user != null) {
            this.myAccountBtn.setText("Déconnexion");
        }

        this.frame =  new JFrame("app");
        this.searchFields = searchFields;

        AnnonceDao adManager = new JpaAnnonceDao();
        System.out.println(searchFields.toString());
        List<AnnonceEntity> annonces = (List<AnnonceEntity>)((JpaAnnonceDao) adManager).getAnnoncesByCriteres(searchFields.getCategoryId(), searchFields.getCityId(), searchFields.getKeyword(), searchFields.getPriceMin(), searchFields.getPriceMax());

        filters.setLayout(new BoxLayout(filters, BoxLayout.Y_AXIS));
        if(searchFields.getCategoryId() != null){
            CritereDao manager = new JpaCritereDao();
            Criteria criteria = new Criteria((List<CritereEntity>) ((JpaCritereDao) manager).getByCategoryId(searchFields.getCategoryId()),true);
            filters.add(criteria.getPanelMain());
        }

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

                if(user == null) {
                    Signin login = new Signin(true);
                    login.getFrame().setContentPane(login.getPanelMain());
                    login.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    login.getFrame().pack();

                    login.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    login.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    login.getFrame().setLocationRelativeTo(null);
                    login.getFrame().setVisible(true);
                } else {
                    createStep1 create = new createStep1(null, user);
                    create.getFrame().setContentPane(create.getPanelMain());
                    create.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    create.getFrame().pack();

                    create.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    create.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    create.getFrame().setLocationRelativeTo(null);
                    create.getFrame().setVisible(true);
                }
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
                    Signin login = new Signin();
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
