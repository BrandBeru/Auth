package Model;

public class Invited extends Role implements Privileges{
    @Override
    public String getRole() {
        role = "invited";
        return role;
    }
    @Override
    public String toString() {
        return "Invited{"+getName() + "}" + "Role{"+getRole()+"}";
    }

    public Invited(String name, String lastName, String email, String address, String phoneNumber, String password) {
        super(name, lastName, email, address, phoneNumber, password);
    }
    public Invited(String name){
        setName(name);
    }
    public Invited(Role role){
        this.setName(role.getName());
        this.setEmail(role.getEmail());
        this.setPassword(role.getPassword());
        this.setAddress(role.getAddress());
        this.setPhoneNumber(role.getPhoneNumber());
        this.setLastName(role.getLastName());
    }

    @Override
    public void grantPrivileges() {
        privilegesMap.put("write", false);
        privilegesMap.put("read", true);
        privilegesMap.put("delete", false);
    }

    @Override
    public void deletePrivilege(String privilege) {
        privilegesMap.replace(privilege, false);
    }
}
