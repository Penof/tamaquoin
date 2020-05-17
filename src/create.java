import java.awt.Font;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class create {

    private JPanel panelMain;
    private JButton rechercherUneAnnonceButton;
    private JPanel step1;
    private JPanel testt;

    public create() {
        rechercherUneAnnonceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void initStep1(){
        ArrayList<String> categories =new ArrayList<>();
        categories.add("Ravi");
        categories.add("Vijay");
        categories.add("Ravi");
        categories.add("Ajay");
        categories.add("kdqkhd");
        categories.add("jhhjdj");
        categories.add("ksjj");
        categories.add("aa");
        for(String category: categories) {
            JButton btn = new JButton(category);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            this.step1.add(btn);
            System.out.println(category);
        }
    }

    public static void main(String args[]){

        JFrame frame = new JFrame("app");
        create c = new create();
        frame.setContentPane(c.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        c.initStep1();
    }
}
