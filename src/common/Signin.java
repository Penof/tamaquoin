package common;

import create.createStep1;
import dao.UtilisateurDao;
import dao.jpa.JpaUtilisateurDao;
import entities.UtilisateurEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signin {
    private JPanel panelMain;
    private JTextField password;
    private JTextField email;
    private JButton backBtn;
    private JButton createAccountBtn;
    private JButton loginBtn;

    private JFrame frame;

    private UtilisateurEntity user;

    private boolean redirectToCreateAd = false;

    public Signin(boolean redirectToCreateAd) {
        this.redirectToCreateAd = redirectToCreateAd;
        this.frame =  new JFrame("app");
        actionsListeners();
    }

    public Signin() {
        this.frame =  new JFrame("app");
        actionsListeners();
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JFrame getFrame() {
        return frame;
    }


    boolean signinUser(){
        boolean flag = true;

        if(this.email.getText().length() == 0)  flag = false;
        if(this.password.getText().length() == 0)  flag = false;

        if(!flag) return flag;

        //Requete bdd
        UtilisateurDao manager = new JpaUtilisateurDao();
        this.user = ((JpaUtilisateurDao) manager).signin(this.email.getText(), this.password.getText());

       if(this.user.getIdUtilisateur() == null) flag = false;
        return flag;
    }



    public void actionsListeners() {

        //backBtn ----- START
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Search search = new Search();
                search.getFrame().setContentPane(search.getPanelMain());
                search.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                search.getFrame().pack();

                search.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                search.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                search.getFrame().setLocationRelativeTo(null);
                search.getFrame().setVisible(true);
            }
        });
        //backBtn ----- END

        //loginBtn ----- START
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!signinUser()) return;
                frame.dispose();

                if(redirectToCreateAd) {
                    createStep1 create = new createStep1(null, user);
                    create.getFrame().setContentPane(create.getPanelMain());
                    create.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    create.getFrame().pack();

                    create.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    create.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    create.getFrame().setLocationRelativeTo(null);
                    create.getFrame().setVisible(true);
                }else {
                    Search search = new Search(user);
                    search.getFrame().setContentPane(search.getPanelMain());
                    search.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    search.getFrame().pack();

                    search.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    search.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    search.getFrame().setLocationRelativeTo(null);
                    search.getFrame().setVisible(true);
                }
            }
        });
        //loginBtn ----- END

        //createAccountBtn ----- START
        createAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Signup signup = new Signup();
                signup.getFrame().setContentPane(signup.getPanelMain());
                signup.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                signup.getFrame().pack();

                signup.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                signup.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                signup.getFrame().setLocationRelativeTo(null);
                signup.getFrame().setVisible(true);
            }
        });
        //createAccountBtn ----- END

    }
}
