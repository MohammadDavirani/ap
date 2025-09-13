package Projects.finalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdminManager implements Serializable,CommonMethods {
    private List<Admin> admins;

    public AdminManager(){
        this.admins = new ArrayList<>();
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void registerAdmin(String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        }

        Admin newAdmin = new Admin(username,password);
        admins.add(newAdmin);
        System.out.println("Admin registration completed successfully.");
    }

    @Override
    public boolean isUsernameTaken(String username) {
        return admins.stream().anyMatch(s -> s.getUsername().equals(username));
    }

    public Admin authenticateAdmin(String username, String password) {
        return admins.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "AdminManager{" +
                "admins=" + admins +
                '}';
    }
}
