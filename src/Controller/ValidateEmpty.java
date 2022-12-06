package Controller;

import Model.Roles;

import javax.swing.*;

public class ValidateEmpty {

    public static boolean validate(Object role, String name, String last_name, String email, int pass, String address, String phone){
        if(role.equals(Roles.ADMINISTRATOR)){
            if(name.equals("") || email.equals("") || pass<8)
                return false;
            else
                return true;
        }else if(role.equals(Roles.USER)){
            if(name.equals("") || email.equals("") || pass<8 && last_name.equals("") || address.equals("") || phone.equals(""))
                return false;
            else
                return true;
        }else
            return true;
    }

}
