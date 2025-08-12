package Projects.finalproject;

import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private List<Admin> admins;

    public AdminManager(){
        this.admins = new ArrayList<>();
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

    private boolean isUsernameTaken(String username) {
        return admins.stream().anyMatch(s -> s.getUsername().equals(username));
    }
}
