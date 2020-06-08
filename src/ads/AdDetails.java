package ads;

import common.*;
import create.createStep1;
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
    private JLabel title;
    private JLabel price;
    private JLabel description;
    private JLabel date;
    private JButton searchAdBtn;
    private JButton addAdBtn;
    private JButton myAccountBtn;
    private JLabel tamacoin;
    private JLabel author;
    private SearchFields searchFields;
    private JFrame frame;

    private UtilisateurEntity user;

    public AdDetails(int idAnnonce, SearchFields searchFields, UtilisateurEntity user) {

        this.user = user;

        this.searchFields = searchFields;
        panelMain.addComponentListener(new ComponentAdapter() {
        });
        this.frame =  new JFrame("app");

        AnnonceDao annonceManager = new JpaAnnonceDao();
        AnnonceEntity annonce = annonceManager.find(AnnonceEntity.class,idAnnonce);
        this.title.setText(annonce.getNom());
        this.description.setText(annonce.getDescription());
        this.price.setText(String.valueOf(annonce.getPrix()) + " €");
        this.date.setText("Publiée le : " + annonce.getDateCreation().toString());
        this.author.setText("Publiée par : " + annonce.getUtilisateur().getNom());

        this.actionsListeners();
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
