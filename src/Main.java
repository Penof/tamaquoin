import common.Search;

import javax.swing.*;
import java.text.ParseException;

public class Main {

    public static void main(String args[]) throws ParseException {

        Search search = new Search();
        search.getFrame().setContentPane(search.getPanelMain());
        search.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        search.getFrame().pack();

        search.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        search.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        search.getFrame().setLocationRelativeTo(null);
        search.getFrame().setVisible(true);
    }
}
