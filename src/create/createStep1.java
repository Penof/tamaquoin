package create;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
        System.out.println(this.ad.toString());

        this.frame =  new JFrame("app");
        this.categories = new HashMap<>();

        //MOCK TO BE CHANGED ----- START
        Map<Integer, String> obj = new HashMap<>();
        obj.put(-1, "   Choisir une catégorie   ");
        obj.put(1, "Voiture");
        obj.put(2, "Moto");
        obj.put(13, "Vélo");
        obj.put(4, "Téléphonie");
        obj.put(5, "Electronique");
        //MOCK TO BE CHANGED ----- END
        //Map<Integer, String> obj = getCategoriesList();

        for (Map.Entry<Integer, String> elt : obj.entrySet()) {
            this.categories_list.addItem(elt.getValue());
            this.categories.put(elt.getKey(), elt.getValue());
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
