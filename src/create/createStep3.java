package create;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
    private Map<Integer, String> cities;

    private newad ad;

    public createStep3(newad ad) {
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
        System.out.println(this.ad.toString());

        this.ad_title.setText(ad.getTitle());
        this.ad_description.setText(ad.getDescription());
        this.ad_price.setText(ad.getPrice());
        //this.cities_list.setSelectedItem();

        //MOCK TO BE CHANGED ----- START
        Map<Integer, String> obj2 = new HashMap<>();
        obj2.put(-1, "Choisir une ville");
        obj2.put(0, "Toute la france");
        obj2.put(1, "Paris");
        obj2.put(2, "Lille");
        obj2.put(3, "Lens");
        obj2.put(4, "Hénin-Beaumont");
        obj2.put(5, "Dourges");
        //MOCK TO BE CHANGED ----- END
        //Map<Integer, String> obj = getCitiesList();

        for (Map.Entry<Integer, String> elt : obj2.entrySet()) {
            this.cities_list.addItem(elt.getValue());
            this.cities.put(elt.getKey(), elt.getValue());
        }

    }

    boolean saveData() {
        Integer cityId = getMapKeyByValue(cities, cities_list.getSelectedItem().toString());
        if(ad_title.getText().length() == 0 || ad_description.getText().length() == 0 || ad_price.getText().length() == 0 || cityId == -1) return false;

        this.ad.setTitle(ad_title.getText());
        this.ad.setDescription(ad_description.getText());
        this.ad.setPrice(ad_price.getText());
        this.ad.setCityId(cityId);
        return true;
    }

    public void actionsListeners() {
        //nextStepBtn ----- START
        saveAdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(saveData()) goToStep(frame, 4, ad);
            }
        });
        //nextStepBtn ----- END

        //previousStepBtn ----- START
        previousStepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
                goToStep(frame, 2, ad);
            }
        });
        //previousStepBtn ----- END
    }
}
