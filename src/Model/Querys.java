package Model;

import Controller.PasswordEncription;
import Values.Cache;
import Values.Datas;

import java.sql.*;

public class Querys {
    private static Connection connection(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auth ", "beru","Giobero140206");
            System.out.println("Connection----->"+con);
            return con;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean addUser(Role role){
        try{
            String query = "INSERT INTO datas (name,lastname,email,address,phonenumber,password,role) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection().prepareStatement(query);
            stmt.setString(1, role.getName());
            stmt.setString(2, role.getLastName());
            stmt.setString(3, role.getEmail());
            stmt.setString(4, role.getAddress());
            stmt.setString(5, role.getPhoneNumber());
            stmt.setString(6, role.getPassword());
            stmt.setString(7, role.getRole());

            stmt.execute();


            connection().close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean getUser(String role, String name, char[] pass){
        try{
            System.out.println("In this place");
            String query = "select * from datas where name=? and password=? and role=?";
            PreparedStatement stmt = connection().prepareStatement(query);
            String passwordEncrypted = PasswordEncription.MD5(pass);
            System.out.println("The pass: "+passwordEncrypted);
            stmt.setString(1, name);
            stmt.setString(2, passwordEncrypted);
            stmt.setString(3, role);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Datas.addRole(role);
                Role roleactive = Datas.getActiveRole();
                roleactive.setName(result.getString("name"));
                roleactive.setLastName(result.getString("lastname"));
                roleactive.setEmail(result.getString("email"));
                roleactive.setAddress(result.getString("address"));
                roleactive.setPhoneNumber(result.getString("phonenumber"));
                roleactive.setPassword(result.getString("password"));

                connection().close();

                Cache.addCache(Datas.getRoleMap());

                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
