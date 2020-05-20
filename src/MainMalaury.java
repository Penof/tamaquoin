import entities.AnnonceEntity;
import mockDBB.DDB;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;

public class MainMalaury extends JFrame {

    private static final long serialVersionUID = -64979793;

    private HashMap<String, JPanel> jPanels;

    private AnnonceEntity annonce;

    public MainMalaury(){
        super("Tamacoin");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jPanels = new HashMap<>();

        JPanel mainContainer = (JPanel) this.getContentPane();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        jPanels.put("main",mainContainer );

        JPanel secondMainContainer = new JPanel();
        secondMainContainer.setLayout(new BoxLayout(secondMainContainer, BoxLayout.X_AXIS));
        mainContainer.add(secondMainContainer);
        jPanels.put("second",(secondMainContainer));

        DDB mockDDB = new DDB();
        annonce = mockDDB.getAnnonceById(1);
    }


    public void productDetails(){

        JPanel jPanelProductDetails = new JPanel();
        jPanelProductDetails.setLayout(new BoxLayout(jPanelProductDetails, BoxLayout.Y_AXIS));
        jPanels.get("second").add(jPanelProductDetails);
        jPanels.put("JPanelProductDetails", jPanelProductDetails);

        JLabel productTitle = new JLabel(annonce.getNom());
        productTitle.setBounds(50,100,900,40);
        productTitle.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        jPanelProductDetails.add(productTitle);

        JLabel productPrice = new JLabel("" + annonce.getPrix());
        productPrice.setBounds(50,150,200,50);
        productPrice.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        jPanelProductDetails.add(productPrice);

        JLabel productImageContainer = new JLabel();
        ImageIcon productImage = new ImageIcon(this.getClass().getResource("./assets/images/imageNotFound.PNG"));
        productImageContainer.setIcon(productImage);
        productImageContainer.setBounds(50,200,1000,700);
        jPanelProductDetails.add(productImageContainer);

        JLabel descriptionTitle = new JLabel("Description");
        descriptionTitle.setBounds(50,890,200,30);
        descriptionTitle.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        jPanelProductDetails.add(descriptionTitle);

        String[] descriptionLines =  annonce.getDescription().split("(?<=\\G.{147})");
        for(int cpt= 0 ; cpt < descriptionLines.length ; cpt ++){
            JLabel productDescription1 = new JLabel(descriptionLines[cpt]);
            productDescription1.setBounds(50,800 + cpt*20,1000,300);
            jPanelProductDetails.add(productDescription1);
        }
    }

    public void adDetails(){
        JPanel JPanelAdDetails = new JPanel();
        JPanelAdDetails.setLayout(new BoxLayout(JPanelAdDetails, BoxLayout.Y_AXIS));
        jPanels.get("second").add(JPanelAdDetails);
        jPanels.put("JPanelAdDetails", JPanelAdDetails);
        JPanelAdDetails.setBackground(Color.white);

        JLabel textDetails = new JLabel("Détails");
        textDetails.setBounds(1500,100,200,30);
        textDetails.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        JPanelAdDetails.add(textDetails);

        JLabel owner = new JLabel("Par");
        owner.setBounds(1500,130,200,30);
        JPanelAdDetails.add(owner);

        JLabel ownerName = new JLabel("Malaury");
        ownerName.setBounds(1500,160,200,30);
        JPanelAdDetails.add(ownerName);

        JLabel publication = new JLabel("Publication");
        publication.setBounds(1500,190,200,30);
        JPanelAdDetails.add(publication);

        Timestamp creationDate = annonce.getDateCreation();
        JLabel productTimesStamp = new JLabel(creationDate.getTime() + "");
        productTimesStamp.setBounds(1500,220,200,30);
        JPanelAdDetails.add(productTimesStamp);
    }

    public void criteria(){



        JLabel criteria = new JLabel("Critères");
        criteria.setBounds(1500,300,200,30);
        criteria.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        jPanels.get("JPanelAdDetails").add(criteria);
    }

    public static void main(String args[]){
        MainMalaury main = new MainMalaury();
        main.productDetails();
        main.adDetails();
        main.criteria();

        main.setVisible(true);
    }
}
