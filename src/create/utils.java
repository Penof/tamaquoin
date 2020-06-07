package create;

import javax.swing.*;
import java.util.Map;

public class utils {

    void goToStep(JFrame fromFrame, int stepNumber, newad ad) {
        fromFrame.dispose();
        switch (stepNumber) {
            case 1:
                createStep1 step1 = new createStep1(ad);
                openNewWindow(step1.getFrame(), step1.getPanelMain());
                break;
            case 2:
                createStep2 step2 = new createStep2(ad);
                openNewWindow(step2.getFrame(), step2.getPanelMain());
                break;
            case 3:
                createStep3 step3 = new createStep3(ad);
                openNewWindow(step3.getFrame(), step3.getPanelMain());
                break;
            default:
        }
    }

    void openNewWindow(JFrame frame, JPanel panel) {
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    int getMapKeyByValue(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(entry.getValue() == value) return entry.getKey();
        }
        return -1;
    }
}
