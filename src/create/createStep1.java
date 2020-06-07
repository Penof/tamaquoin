package create;

import common.Search;
import dao.SousCategorieDao;
import dao.jpa.JpaSousCategorieDao;
import entities.SousCategorieEntity;
import entities.UtilisateurEntity;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class createStep1 extends utils{
    //Choisir une categorie

    private JPanel panelMain;
    private JButton nextStepBtn;

    private JComboBox categories_list;
    private JButton cancelBtn;
    private Map<Integer, String> categories;

    private JPanel testt;
    private JFrame frame;

    private newad ad;

    private UtilisateurEntity user;

    public createStep1(newad ad, UtilisateurEntity user) {
        this.ad = ad == null ? new newad() : ad;
        this.user = user;
        if(this.user != null) this.ad.setUserId(this.user.getIdUtilisateur());
        this.init();
        this.actionsListeners();
    }

    public createStep1(newad ad) {
        this.ad = ad;
        this.init();
        this.actionsListeners();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void init(){

        this.frame =  new JFrame("app");
        this.categories = new HashMap<>();

        SousCategorieDao manager = new JpaSousCategorieDao();
        List<SousCategorieEntity> list = new ArrayList<SousCategorieEntity>();

        list = (List<SousCategorieEntity>) manager.findAll();

        this.categories_list.addItem("Choisir une catégorie");
        this.categories.put(-1, "Choisir une catégorie");

        for (SousCategorieEntity elt : list) {
            this.categories_list.addItem(elt.getLabel());
            this.categories.put(elt.getIdSousCategorie(), elt.getLabel());
        }
    }

    boolean saveData() {
        Integer categoryId = getMapKeyByValue(categories, categories_list.getSelectedItem().toString());
        if(categoryId == -1) return false;

        ad.setCategoryId(categoryId);
        return true;
    }

    public void actionsListeners() {
        //nextStepBtn ----- START
        nextStepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(saveData()) goToStep(frame, 2, ad, user);
            }
        });
        //nextStepBtn ----- END

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
