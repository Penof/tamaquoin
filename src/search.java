import entities.AnnonceEntity;
import mockDBB.DDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class search {

    private String pageTitle = "Accueil";
    private JPanel panelMain;

    private JComboBox search_categories;
    private Map<String, Integer> categories;

    private JComboBox search_cities;
    private Map<String, Integer> cities;

    private JTextField search_keywords;
    private JTextField search_priceMin;
    private JTextField search_priceMax;
    private JButton search_confirm;

    public search() {
        this.categories = new HashMap<>();
        this.initCategoriesList();

        this.cities = new HashMap<>();
        this.initCitiesList();

        this.actionsListeners();

        //updateAdsList();
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public JPanel getPanelMain() {
        return this.panelMain;
    }

    private void initCategoriesList() {
        //MOCK TO BE CHANGED ----- START
        Map<Integer, String> obj = new HashMap<>();
        obj.put(-1, "Toutes catégories");
        obj.put(1, "Voiture");
        obj.put(2, "Moto");
        obj.put(13, "Vélo");
        obj.put(4, "Téléphonie");
        obj.put(5, "Electronique");
        //MOCK TO BE CHANGED ----- END
        //Map<Integer, String> obj = getCategoriesList();

        for (Map.Entry<Integer, String> elt : obj.entrySet()) {
            this.search_categories.addItem(elt.getValue());
            this.categories.put(elt.getValue(), elt.getKey());
        }
    }

    private void initCitiesList() {
        //MOCK TO BE CHANGED ----- START
        Map<Integer, String> obj = new HashMap<>();
        obj.put(-1, "Toute la France");
        obj.put(1, "Paris");
        obj.put(2, "Lille");
        obj.put(3, "Lens");
        obj.put(4, "Hénin-Beaumont");
        obj.put(5, "Dourges");
        //MOCK TO BE CHANGED ----- END
        //Map<Integer, String> obj = getCitiesList();

        for (Map.Entry<Integer, String> elt : obj.entrySet()) {
            this.search_cities.addItem(elt.getValue());
            this.cities.put(elt.getValue(), elt.getKey());
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
        placeholders.put("search_priceMin", "Prix minimum");
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
        placeholders.put("search_priceMax", "Prix maximum");
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
                //updateAdsList();
            }
        });
        //search_confirm ----- END
    }

    public void goToProductsList(){
        //searchFields searchFields = new searchFields(this.search_categories.getText());
    }

    public static void main(String args[]) throws ParseException {

        JFrame frame = new JFrame("app");
        search search = new search();

        //end
        frame.setContentPane(search.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
