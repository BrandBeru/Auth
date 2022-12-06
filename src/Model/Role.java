package Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Role {

    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;
    protected String role;

    protected Map<String, Boolean> privilegesMap = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public abstract String getRole();

    String listPrivileges(){
        String s = "";
        Iterator it = privilegesMap.keySet().iterator();
        while (it.hasNext()){
            Object key = it.next();
            s += "Privilege: " + key + " - " + privilegesMap.get(key) + "\n";
        }
        return s;
    }

    public Role(String name, String lastName, String email, String address, String phoneNumber, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    public Role() {
    }
}
