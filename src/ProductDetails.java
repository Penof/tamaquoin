import entities.AnnonceEntity;
import mockDBB.DDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class ProductDetails {
    private JPanel panelMain;
    private JPanel image;
    private JButton retourButton;
    private JLabel productName;
    private JLabel price;
    private JLabel description;
    private JLabel username;
    private JLabel date;

    public ProductDetails() {
        panelMain.addComponentListener(new ComponentAdapter() {
        });
    }

    public JPanel ProductDetails() {
        return this.panelMain;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public static void main(String args[]){
        ProductDetails prd = new ProductDetails();
        JFrame frame = new JFrame("app");
        DDB mockDDB = new DDB();
        AnnonceEntity annonce = mockDDB.getAnnonceById(1);
        prd.productName.setText(annonce.getNom());
        prd.description.setText(annonce.getDescription());
        prd.price.setText(String.valueOf(annonce.getPrix()));
        prd.date.setText(annonce.getDateCreation().toString());

        prd.retourButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
            }
        });

        JPanel jpanel =  prd.panelMain;
        frame.setContentPane(jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
