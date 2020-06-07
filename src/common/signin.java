package common;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signin {
    private JPanel panelMain;
    private JTextField password;
    private JTextField login;
    private JButton backBtn;
    private JButton createAccountBtn;
    private JButton loginBtn;

    private JFrame frame;

    private Integer userId;

    public signin() {
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

        if(this.login.getText().length() == 0)  flag = false;
        if(this.password.getText().length() == 0)  flag = false;

        //Requete bdd
        //this.userId = 2;

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

                //Test
                userFields user = new userFields();
                user.setFirstname("Ayman");
                user.setLastname("Oussama");
                user.setUsername("ouayman");
                user.setEmail("ou.ayman@gmail.com");

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
        //loginBtn ----- END

        //createAccountBtn ----- START
        createAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                signup signup = new signup();
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
