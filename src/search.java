import create.createStep1;
import dao.CoordonneeDao;
import dao.SousCategorieDao;
import dao.jpa.JpaCoordonneeDao;
import dao.jpa.JpaSousCategorieDao;
import entities.CoordonneeEntity;
import entities.SousCategorieEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class search {

    private String pageTitle = "Accueil";
    private JPanel panelMain;

    private JComboBox search_categories;
    private Map<Integer, String> categories;

    private JComboBox search_cities;
    private Map<Integer, String> cities;

    private JTextField search_keywords;
    private JTextField search_priceMin;
    private JTextField search_priceMax;
    private JButton search_confirm;
    private JButton addAdBtn;

    private JFrame frame;

    public search() {
        this.frame =  new JFrame("app");

        this.categories = new HashMap<>();
        this.initCategoriesList();

        this.cities = new HashMap<>();
        this.initCitiesList();

        this.actionsListeners();

        //updateAdsList();
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public JPanel getPanelMain() {
        return this.panelMain;
    }

    private void initCategoriesList() {
        SousCategorieDao manager = new JpaSousCategorieDao();
        List<SousCategorieEntity> list = new ArrayList<SousCategorieEntity>();

        list = (List<SousCategorieEntity>) manager.findAll();

        this.search_categories.addItem("Toutes les catégories");
        this.categories.put(-1, "Toutes les catégories");

        for (SousCategorieEntity elt : list) {
            this.search_categories.addItem(elt.getLabel());
            this.categories.put(elt.getIdSousCategorie(), elt.getLabel());
        }
    }

    private void initCitiesList() {
        CoordonneeDao manager = new JpaCoordonneeDao();
        List<CoordonneeEntity> list = new ArrayList<CoordonneeEntity>();

        list = (List<CoordonneeEntity>) manager.findAll();

        this.search_cities.addItem("Toute la France");
        this.cities.put(-1, "Toute la France");

        for (CoordonneeEntity elt : list) {
            this.search_cities.addItem(elt.getVille());
            this.cities.put(elt.getIdCoordonnee(), elt.getVille());
        }
    }

    public void actionsListeners() {

        Map<String, String> placeholders = new HashMap<>();

        //search_keywords ----- START
        placeholders.put("search_keywords", "Que recherchez-vous ?");
        if (search_keywords.getText().isEmpty()) {
            search_keywords.setForeground(Color.GRAY);
            search_keywords.setText(placeholders.get("search_keywords"));
        }

        search_keywords.setForeground(Color.GRAY);
        search_keywords.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search_keywords.getText().equals(placeholders.get("search_keywords"))) {
                    search_keywords.setText("");
                    search_keywords.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (search_keywords.getText().isEmpty()) {
                    search_keywords.setForeground(Color.GRAY);
                    search_keywords.setText(placeholders.get("search_keywords"));
                }
            }
        });
        //search_keywords ----- END

        //search_priceMin ----- START
        placeholders.put("search_priceMin", "min");
        if (search_priceMin.getText().isEmpty()) {
            search_priceMin.setForeground(Color.GRAY);
            search_priceMin.setText(placeholders.get("search_priceMin"));
        }

        search_priceMin.setForeground(Color.GRAY);
        search_priceMin.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search_priceMin.getText().equals(placeholders.get("search_priceMin"))) {
                    search_priceMin.setText("");
                    search_priceMin.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (search_priceMin.getText().isEmpty()) {
                    search_priceMin.setForeground(Color.GRAY);
                    search_priceMin.setText(placeholders.get("search_priceMin"));
                }
            }
        });

        search_priceMin.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        //search_priceMin ----- END

        //search_priceMax ----- START
        placeholders.put("search_priceMax", "max");
        if (search_priceMax.getText().isEmpty()) {
            search_priceMax.setForeground(Color.GRAY);
            search_priceMax.setText(placeholders.get("search_priceMax"));
        }

        search_priceMax.setForeground(Color.GRAY);
        search_priceMax.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search_priceMax.getText().equals(placeholders.get("search_priceMax"))) {
                    search_priceMax.setText("");
                    search_priceMax.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (search_priceMax.getText().isEmpty()) {
                    search_priceMax.setForeground(Color.GRAY);
                    search_priceMax.setText(placeholders.get("search_priceMax"));
                }
            }
        });

        search_priceMax.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        //search_priceMax ----- END

        //search_confirm ----- START
        search_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToProductsList();
            }
        });
        //search_confirm ----- END

        //addAdBtn ----- START
        addAdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToCreateAdForm();
            }
        });
        //addAdBtn ----- END
    }

    int getMapKeyByValue(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(entry.getValue() == value) return entry.getKey();
        }
        return -1;
    }

    public void goToProductsList(){

        Integer categoryId = getMapKeyByValue(categories, this.search_categories.getSelectedItem().toString());
        Integer cityId = getMapKeyByValue(cities, this.search_cities.getSelectedItem().toString());

        categoryId = categoryId == -1 ? null : categoryId;
        cityId = cityId == -1 ? null : cityId;

        searchFields searchFields = new searchFields(categoryId,cityId,this.search_keywords.getText(),this.search_priceMin.getText(),this.search_priceMax.getText());
        this.getFrame().dispose();

        home home = new home(searchFields);
        home.getFrame().setContentPane(home.getPanelMain());
        home.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.getFrame().pack();

        home.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        home.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.getFrame().setLocationRelativeTo(null);
        home.getFrame().setVisible(true);
    }

    public void goToCreateAdForm(){
        this.getFrame().dispose();

        createStep1 create = new createStep1(null, 1);
        create.getFrame().setContentPane(create.getPanelMain());
        create.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        create.getFrame().pack();

        create.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        create.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        create.getFrame().setLocationRelativeTo(null);
        create.getFrame().setVisible(true);
    }

    public static void main(String args[]) throws ParseException {

        search search = new search();

        //end
        search.getFrame().setContentPane(search.panelMain);
        search.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        search.getFrame().pack();

        search.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        search.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        search.getFrame().setLocationRelativeTo(null);
        search.getFrame().setVisible(true);

    }
}
