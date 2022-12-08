package Controller;

import Model.Querys;
import Model.Role;
import Model.Roles;
import Values.Cache;
import Values.Datas;

public class LoginController {
    public static boolean validateRegister(String role, String name, char[] pass){
        if(Datas.getRole(role, name, pass) == null){
            return Querys.getUser(role, name, pass);
        }else
            return true;
    }
}
