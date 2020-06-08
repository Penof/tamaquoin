package common;

import dao.UtilisateurDao;
import dao.jpa.JpaUtilisateurDao;
import entities.UtilisateurEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup {
    private JPanel panelMain;
    private JTextField password;
    private JButton backBtn;
    private JButton saveBtn;
    private JTextField lastname;
    private JTextField firstname;
    private JTextField email;

    private JFrame frame;

    private UtilisateurEntity user;

    public Signup() {
        this.frame =  new JFrame("app");
        actionsListeners();
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JFrame getFrame() {
        return frame;
    }

    boolean createUser(){
        boolean flag = true;

        if(this.firstname.getText().length() == 0) flag = false;
        if(this.lastname.getText().length() == 0) flag = false;
        if(this.email.getText().length() == 0) flag = false;
        if(this.password.getText().length() == 0) flag = false;

        if(flag == false) return flag;

        UtilisateurDao manager = new JpaUtilisateurDao();
        this.user = new UtilisateurEntity(this.firstname.getText()+" "+this.lastname.getText(), this.email.getText(), this.password.getText());
        manager.create(user);
        if(this.user.getIdUtilisateur() == null) flag = false;

        return flag;
    }

    public void actionsListeners() {

        //backBtn ----- START
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                Signin login = new Signin();
                login.getFrame().setContentPane(login.getPanelMain());
                login.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.getFrame().pack();

                login.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                login.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                login.getFrame().setLocationRelativeTo(null);
                login.getFrame().setVisible(true);
            }
        });
        //backBtn ----- END

        //saveBtn ----- START
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!createUser()) {
                    return;
                }

                frame.dispose();

                Signin login = new Signin();
                login.getFrame().setContentPane(login.getPanelMain());
                login.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.getFrame().pack();

                login.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                login.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
                login.getFrame().setLocationRelativeTo(null);
                login.getFrame().setVisible(true);
            }
        });
        //saveBtn ----- END

    }
}
