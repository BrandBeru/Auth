package Model;

public class Administrator extends Role implements Privileges{
    @Override
    public String getRole() {
        role = Roles.ADMINISTRATOR.name();
        return role;
    }
    @Override
    public String toString() {
        return "I'm " + getName() + " My role is " + getRole() + " my email is: " + getEmail() + " finally my phone: " + getPhoneNumber() + " My privileges: " + listPrivileges();
    }

    public Administrator(String name, String lastName, String email, String address, String phoneNumber, String password) {
        super(name, lastName, email, address, phoneNumber, password);
    }

    public Administrator(Role role){
        this.setName(role.getName());
        this.setEmail(role.getEmail());
        this.setPassword(role.getPassword());
        this.setAddress(role.getAddress());
        this.setPhoneNumber(role.getPhoneNumber());
        this.setLastName(role.getLastName());
    }
    public Administrator(){

    }

    @Override
    public void grantPrivileges() {
        privilegesMap.put("write", true);
        privilegesMap.put("read", true);
        privilegesMap.put("delete", true);
    }

    @Override
    public void deletePrivilege(String privilege) {
        privilegesMap.replace(privilege, false);
    }
}
