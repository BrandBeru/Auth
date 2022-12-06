package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel lblImage;
    private JCheckBox checkBox1;
    private JButton button1;
    private JRadioButton radioButton1;

    public Principal() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Pressed");
            }
        });
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        p.setContentPane(p.mainPanel);
        p.setSize(1200, 1400);
        p.setTitle("Login/Register");
        p.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }
}
