package Values;

import Controller.PasswordEncription;
import Model.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Datas {
    private static Map<String, Role> roleMap = new HashMap<String, Role>();

    private static Administrator adminSession;
    private static User userSession;
    private static Invited invitedSession;
    public static void addRole(Role addd_role){
        roleMap.put(addd_role.getRole(), addd_role);
    }
    public static boolean getRole(String role, String name, char[] pass){
        if(!role.equals(Roles.INVITED.name())){
            Iterator it = roleMap.keySet().iterator();
            while(it.hasNext()){
                String key = it.next().toString();
                Role actualRol = roleMap.get(key);
                if(actualRol.getRole().equals(role)) {
                    if(PasswordEncription.validatePassword(actualRol.getPassword(), pass) && actualRol.getName().equals(name)) {
                        setActiveSession(role, actualRol);
                        return true;
                    }
                }else
                    System.out.println("User is validating");
            }
        }else {
            invitedSession = new Invited(name);
            invitedSession.grantPrivileges();
            JOptionPane.showMessageDialog(null, invitedSession.toString());
            return true;
        }
        return false;
    }
    public static void setActiveSession(String roleType, Role role){
        if(roleType.equals(Roles.ADMINISTRATOR.name())) {
            adminSession = new Administrator(role);
            adminSession.grantPrivileges();
            JOptionPane.showMessageDialog(null, adminSession.toString());
        }
        else if(roleType.equals(Roles.USER.name())) {
            userSession = new User(role);
            userSession.grantPrivileges();
            JOptionPane.showMessageDialog(null, userSession.toString());
        }
    }
    public static Role getActiveRole(){
        if(adminSession!=null)
            return adminSession;
        else if(userSession!=null)
            return userSession;
        else
            return invitedSession;
    }
    public static void closeActiveRole(){
        if(adminSession!=null)
            adminSession = null;
        else if(userSession!=null)
            userSession = null;
        else
            invitedSession = null;
    }

}
