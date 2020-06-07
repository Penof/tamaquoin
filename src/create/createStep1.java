package create;

import dao.SousCategorieDao;
import dao.jpa.JpaSousCategorieDao;
import entities.SousCategorieEntity;

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
    private Map<Integer, String> categories;

    private JPanel testt;
    private JFrame frame;

    private newad ad;

    public createStep1(newad ad, Integer userId) {
        this.ad = ad == null ? new newad() : ad;
        this.ad.setUserId(userId);
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
                if(saveData()) goToStep(frame, 2, ad);
            }
        });
        //nextStepBtn ----- END
    }
}
