package common;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup {
    private JPanel panelMain;
    private JTextField password;
    private JTextField username;
    private JButton backBtn;
    private JButton saveBtn;
    private JTextField lastname;
    private JTextField firstname;
    private JTextField email;

    private JFrame frame;

    private userFields user;

    public signup() {
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
        this.user = new userFields();

        if(this.firstname.getText().length() > 0) this.user.setFirstname(this.firstname.getText()); else flag = false;
        if(this.lastname.getText().length() > 0) this.user.setFirstname(this.lastname.getText()); else flag = false;
        if(this.username.getText().length() > 0) this.user.setFirstname(this.username.getText()); else flag = false;
        if(this.email.getText().length() > 0) this.user.setFirstname(this.email.getText()); else flag = false;
        if(this.password.getText().length() > 0) this.user.setFirstname(this.password.getText()); else flag = false;

        //Requete bdd

        return flag;
    }

    public void actionsListeners() {

        //backBtn ----- START
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                signin login = new signin();
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

                signin login = new signin();
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
