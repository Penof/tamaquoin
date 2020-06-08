package common;

import entities.CritereEntity;
import mockDBB.CritereDTO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Criteria {

    private JPanel panelMain;
    private JPanel body;

    public Criteria(List<CritereEntity> critereDTOList, boolean home){
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        critereDTOList.forEach(critereDTO -> {
            JLabel title = new JLabel(critereDTO.getLabel());
            title.setFont(new Font(Font.SANS_SERIF,1,24));
            body.add(title);
            if(critereDTO.getTypeFront().equals("CheckBox")){
                critereDTO.getValeursPossibles().forEach(v -> {
                    JCheckBox jCheckBox = new JCheckBox(v.getValeurString());
                    body.add(jCheckBox);
                });
            }
            else if(home){
                JPanel jPanel = new JPanel();
                JTextField jTextField1 = new JTextField("Min");
                JTextField jTextField2 = new JTextField("Max");
                jPanel.add(jTextField1);
                jPanel.add(jTextField2);
                body.add(jPanel);
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
