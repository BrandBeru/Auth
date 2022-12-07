package View;

import Controller.SetDatas;
import Values.Datas;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
    private JPanel mainPanel;
    private JTextField txt1;
    private JTextField txt2;
    private JLabel lblImage;
    private JCheckBox cbxread;
    private JButton btnedit;
    private JProgressBar bar;
    private JSlider slider1;
    private JLabel lblUser;
    private JLabel lblRole;
    private JButton deleteImageButton;
    private JButton changeImageButton;
    private JButton exitButton;
    private JLabel lblAdd;
    private JLabel lblPhone;
    private JLabel lblEmail;
    private JCheckBox cbxwrite;
    private JCheckBox cbxdelete;

    public Principal() {
        write(Datas.getActiveRole().listPrivileges().get("write"));
        read(Datas.getActiveRole().listPrivileges().get("read"));
        delete(Datas.getActiveRole().listPrivileges().get("delete"));

        new SetDatas().SetLabels(lblUser, lblEmail, lblAdd, lblPhone, lblRole);
        btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Pressed");
            }
        });
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                bar.setValue(slider1.getValue());
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Datas.closeActiveRole();
                Principal.super.dispose();
                Auth.initComponents();
                Datas.getActiveRole().toString();
            }
        });
        btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        deleteImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lblImage.setIcon(null);
            }
        });
        changeImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser("~/");
                int r = fileChooser.showOpenDialog(null);
                if(r == JFileChooser.APPROVE_OPTION){
                    lblImage.setIcon(new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath()));
                }
            }
        });
    }
    public void initComponents(){
        Principal p = new Principal();
        p.setContentPane(p.mainPanel);
        p.setSize(1200, 1400);
        p.setTitle("Login/Register");
        p.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }
    private void write(boolean can){
        txt1.setEnabled(can);
        txt2.setEnabled(can);
        changeImageButton.setEnabled(can);
        btnedit.setEnabled(can);
        cbxwrite.setSelected(can);
    }
    private void read(boolean can){
        lblImage.setVisible(can);
        lblUser.setVisible(can);
        lblRole.setVisible(can);
        lblEmail.setVisible(can);
        lblPhone.setVisible(can);
        lblAdd.setVisible(can);
        cbxread.setSelected(can);
    }
    private void delete(boolean can){
        deleteImageButton.setEnabled(can);
        cbxdelete.setSelected(can);
    }

}
