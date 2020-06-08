package create;

import ads.AdDetails;
import common.Search;
import dao.*;
import dao.jpa.*;
import entities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class createStep3 extends utils{
    //Choisir une categorie

    private JPanel panelMain;
    private JPanel stepContent;
    private JButton previousStepBtn;
    private JButton saveAdBtn;

    private JTextField ad_title;
    private JTextArea ad_description;
    private JTextField ad_price;

    private JPanel testt;
    private JFrame frame;

    private JComboBox cities_list;
    private JButton cancelBtn;
    private Map<Integer, String> cities;

    private newad ad;

    private UtilisateurEntity user;

    public createStep3(newad ad, UtilisateurEntity user) {
        this.user = user;

        this.ad = ad;
        this.frame =  new JFrame("app");

        this.cities = new HashMap<>();
        init();

        this.actionsListeners();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void init(){
        if(ad.getTitle() != null) this.ad_title.setText(ad.getTitle());
        if(ad.getDescription() != null) this.ad_description.setText(ad.getDescription());
        if(ad.getPrice() != null) this.ad_price.setText(ad.getPrice().toString());
        //this.cities_list.setSelectedItem();

        CoordonneeDao manager = new JpaCoordonneeDao();
        List<CoordonneeEntity> list = new ArrayList<CoordonneeEntity>();

        list = (List<CoordonneeEntity>) manager.findAll();


        this.cities_list.addItem("Choisir une ville");
        this.cities.put(-1, "Choisir une ville");

        for (CoordonneeEntity elt : list) {
            this.cities_list.addItem(elt.getVille());
            this.cities.put(elt.getIdCoordonnee(), elt.getVille());
        }

    }

    boolean saveData() {
        boolean flag = true;

        if(ad_title.getText().length() > 0) this.ad.setTitle(ad_title.getText()); else flag = false;
        if(ad_description.getText().length() > 0) this.ad.setDescription(ad_description.getText()); else flag = false;
        if(ad_price.getText().length() > 0) this.ad.setPrice(Double.parseDouble(ad_price.getText())); else flag = false;

        Integer cityId = getMapKeyByValue(cities, cities_list.getSelectedItem().toString());
        if(cityId != -1) this.ad.setCityId(cityId); else flag = false;

        return flag;
    }

    public void actionsListeners() {
        //ad_price ----- START
        ad_price.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        //ad_price ----- END

        //nextStepBtn ----- START
        saveAdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!saveData()) return;

                AnnonceDao manager = new JpaAnnonceDao();
                AnnonceEntity annonce = new AnnonceEntity(ad.getTitle(), new Timestamp(System.currentTimeMillis()), ad.getDescription(), ad.getPrice(), 0);

                CritereDao critereDao = new JpaCritereDao();
                ad.getCritereEntityList().forEach(critere ->  {
                    critere.getValeursPossibles().forEach(valeur -> {
                       AssocAnnonceCritereEntity assocAnnonceCritereEntity =  new AssocAnnonceCritereEntity(valeur.getValeurString());
                        annonce.addCriteresAnnonce(assocAnnonceCritereEntity);
                        critere.addCriteresAnnonce(assocAnnonceCritereEntity);
                        critereDao.update(critere);
                        manager.update(annonce);
                    });
                });


                CoordonneeDao coordonnesManager = new JpaCoordonneeDao();
                CoordonneeEntity coordonnee = coordonnesManager.find(CoordonneeEntity.class, ad.getCityId());

                SousCategorieDao ssCategoryManager = new JpaSousCategorieDao();
                SousCategorieEntity sousCategory = ssCategoryManager.find(SousCategorieEntity.class, ad.getCategoryId());

                coordonnee.addAnnonce(annonce);
                coordonnesManager.update(coordonnee);

                sousCategory.addAnnonce(annonce);
                ssCategoryManager.update(sousCategory);

                UtilisateurDao userManager = new JpaUtilisateurDao();
                user.addAnnonce(annonce);
                userManager.update(user);

                frame.dispose();
                AdDetails adDetails = new AdDetails(annonce.getIdAnnonce(), null, null);
                adDetails.getFrame().setContentPane(adDetails.getPanelMain());
                adDetails.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adDetails.getFrame().pack();

                adDetails.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                adDetails.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                adDetails.getFrame().setLocationRelativeTo(null);
                adDetails.getFrame().setVisible(true);
            }
        });
        //nextStepBtn ----- END

        //previousStepBtn ----- START
        previousStepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
                goToStep(frame, 2, ad, user);
            }
        });
        //previousStepBtn ----- END

        //cancelBtn ----- START
        cancelBtn.addActionListener(new ActionListener() {
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
        //cancelBtn ----- END
    }
}
