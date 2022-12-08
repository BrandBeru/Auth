package Controller;

import Model.*;
import Values.Cache;
import Values.Datas;

public class RegisterController {

    private Role newRole;

    public Role addRegister(String name, String lastName, String email, String address, String phoneNumber, Object role, char[] password){
        if(role.equals(Roles.ADMINISTRATOR)) {
            System.out.println("AD");
            newRole = new Administrator(name, lastName, email, address, phoneNumber, "");
            newRole.setPassword(PasswordEncription.encrypt(password));
            Querys.addUser(newRole);
        }
        else if(role.equals(Roles.USER)) {
            System.out.println("US");
            newRole = new User(name, lastName, email, address, phoneNumber, "");
            newRole.setPassword(PasswordEncription.encrypt(password));
            Querys.addUser(newRole);
        }
        else
            newRole = null;

        System.out.println(newRole.toString());
        Datas.addRole(newRole);
        System.out.println("Registered");
        return newRole;
    }
}
