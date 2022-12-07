package View;

import Controller.LoginController;
import Controller.RegisterController;
import Controller.ValidateEmpty;
import Model.Roles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auth extends JFrame{
    private JButton validateButton;
    private JTextField txtEmail;
    private JPasswordField vTxtPass;
    private JTextField rTxtName;
    private JTextField rTxtEmail;
    private JButton registerButton;
    private JPanel panelMain;
    private JPasswordField rTxtPassword;
    private JTextField rTxtAddress;
    private JTextField rTxtPhone;
    private JComboBox cmbRole;
    private JComboBox vCmbRole;

    public Auth() {
        cmbRole.addItem(Roles.ADMINISTRATOR);
        cmbRole.addItem(Roles.USER);

        vCmbRole.addItem(Roles.INVITED);
        vCmbRole.addItem(Roles.ADMINISTRATOR);
        vCmbRole.addItem(Roles.USER);

        char[] pass = {'g','i','o','v','a','n','n','y'};
        new RegisterController().addRegister("juan", "", "juan@gmail.com","adfdsf","242314234",Roles.USER,pass);
        char[] pass2 = {'g','i','o','v','a','n','n','t'};
        new RegisterController().addRegister("estevan", "", "estevan@gmail.com","adfdsf","3356345",Roles.ADMINISTRATOR,pass2);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String rName = rTxtName.getText();
                String rEmail = rTxtEmail.getText();
                String rPhone = rTxtPhone.getText();
                String rAddress = rTxtAddress.getText();
                Object role = cmbRole.getSelectedItem();

                int passCount = rTxtPassword.getText().getBytes().length;
                if(ValidateEmpty.validate(role.toString(), rName, "", rEmail, passCount, rAddress, rPhone)) {
                    JOptionPane.showMessageDialog(registerButton, "All right!");
                    new RegisterController().addRegister(rName, "", rEmail,rAddress,rPhone,role,rTxtPassword.getPassword());
                }
                else
                    JOptionPane.showMessageDialog(registerButton, "There's some Empty objects");
            }
        });
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(LoginController.validateRegister(vCmbRole.getSelectedItem().toString(), txtEmail.getText(), vTxtPass.getPassword())){
                    new Principal().initComponents();
                    Auth.super.dispose();
                }
            }
        });
    }

    public static void initComponents(){
        Auth auth = new Auth();
        auth.setContentPane(auth.panelMain);
        auth.setSize(600, 900);
        auth.setTitle("Login/Register");
        auth.setDefaultCloseOperation(EXIT_ON_CLOSE);
        auth.setVisible(true);
        auth.setLocationRelativeTo(null);
    }
}
