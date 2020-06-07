package create;

import common.Search;
import dao.CritereDao;
import dao.jpa.JpaCritereDao;
import entities.UtilisateurEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createStep2 extends utils{
    //Choisir une categorie

    private JPanel panelMain;
    private JPanel stepContent;
    private JButton nextStepBtn;
    private JButton previousStepBtn;
    private JButton cancelBtn;
    private JPanel testt;
    private JFrame frame;

    private newad ad;

    private UtilisateurEntity user;

    public createStep2(newad ad, UtilisateurEntity user) {
        this.user = user;

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
        //List<CritereEntity> criteres = (List<CritereEntity>) ((JpaCritereDao) manager).getByCategoryId(1);
    }

    public void actionsListeners() {
        //nextStepBtn ----- START
        nextStepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToStep(frame, 3, ad, user);
            }
        });
        //nextStepBtn ----- END

        //previousStepBtn ----- START
        previousStepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToStep(frame, 1, ad, user);
            }
        });
        //previousStepBtn ----- END

        //cancelBtn ----- START
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Search search = new Search(user);
                search.getFrame().setContentPane(search.getPanelMain());
                search.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                search.getFrame().pack();

                search.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                search.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                search.getFrame().setLocationRelativeTo(null);
                search.getFrame().setVisible(true);
            }
        });
        //cancelBtn ----- END
    }
}