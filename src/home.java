import javax.swing.*;

public class home {
    private JPanel panelMain;
    private JButton proposerUneAnnonceButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JTextField textField3;
    private JButton rechercherButton;
    private JButton filtrerButton;

    public JPanel home() {
        return this.panelMain;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public static void main(String args[]){

        JFrame frame = new JFrame("app");
        frame.setContentPane(new home().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
