package Model;

public class User extends Role implements Privileges{
    @Override
    public String toString() {
        return "I'm " + getName() + " my role is: " + getRole() + " and my email is: " + getEmail() + " My privileges are: " + listPrivileges();
    }
    @Override
    public String getRole() {
        role = Roles.USER.name();
        return role;
    }

    public User(String name, String lastName, String email, String address, String phoneNumber, String password) {
        super(name, lastName, email, address, phoneNumber, password);
    }

    @Override
    public void grantPrivileges() {
        privilegesMap.put("write", true);
        privilegesMap.put("read", true);
        privilegesMap.put("delete", false);
    }

    @Override
    public void deletePrivilege(String privilege) {
        privilegesMap.replace(privilege, false);
    }

    public User(Role role){
        this.setName(role.getName());
        this.setEmail(role.getEmail());
        this.setPassword(role.getPassword());
        this.setAddress(role.getAddress());
        this.setPhoneNumber(role.getPhoneNumber());
        this.setLastName(role.getLastName());
    }
}
