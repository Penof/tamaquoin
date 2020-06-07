package create;

import dao.AnnonceDao;
import dao.CritereDao;
import dao.jpa.JpaCritereDao;
import entities.CritereEntity;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class createStep2 extends utils{
    //Choisir une categorie

    private JPanel panelMain;
    private JPanel stepContent;
    private JButton nextStepBtn;
    private JButton previousStepBtn;
    private JPanel testt;
    private JFrame frame;

    private newad ad;

    public createStep2(newad ad) {
        this.ad = ad;
        this.frame =  new JFrame("app");
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
        CritereDao manager = new JpaCritereDao();
        List<CritereEntity> criteres = (List<CritereEntity>) ((JpaCritereDao) manager).getByCategoryId(1);
    }

    public void actionsListeners() {
        //nextStepBtn ----- START
        nextStepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToStep(frame, 3, ad);
            }
        });
        //nextStepBtn ----- END

        //previousStepBtn ----- START
        previousStepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToStep(frame, 1, ad);
            }
        });
        //previousStepBtn ----- END
    }
}
