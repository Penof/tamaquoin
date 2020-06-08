package common;

import entities.CritereEntity;
import entities.ValeurPossibleEntity;
import mockDBB.CritereDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Criteria {

    private JPanel panelMain;
    private JPanel body;
    private List<CritereEntity> criteres;

    public Criteria(List<CritereEntity> critereDTOList, boolean home){
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        critereDTOList.forEach(critereDTO -> {
            JLabel title = new JLabel(critereDTO.getLabel());
            title.setFont(new Font(Font.SANS_SERIF,1,24));
            body.add(title);
            if(critereDTO.getTypeFront().equals("CheckBox")){
                critereDTO.getValeursPossibles().forEach(v -> {
                    JCheckBox jCheckBox = new JCheckBox(v.getValeurString());
                    jCheckBox.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            boolean find = false;
                            for (CritereEntity c : criteres) {
                                if(c.getLabel().equals(critereDTO.getLabel())){
                                    c.getValeursPossibles().add(v);
                                    find =true;
                                }
                            }
                            if(!find){
                                CritereEntity bis = critereDTO;
                                bis.getValeursPossibles().clear();
                                bis.getValeursPossibles().add(v);
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
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

    public List<CritereEntity> getCriteres() {
        return criteres;
    }
}
