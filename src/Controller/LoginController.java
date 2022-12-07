package Controller;

import Model.Role;
import Model.Roles;
import Values.Datas;

public class LoginController {
    public static boolean validateRegister(String role, String name, char[] pass){
        return Datas.getRole(role, name, pass);
    }
}
