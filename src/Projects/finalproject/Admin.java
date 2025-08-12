package Projects.finalproject;

public class Admin {
    private String username;
    private String password;
    private int numberOfBooksRegistered;
    private int numberOfBooksLoaned;

    public Admin(String username, String password){
        this.username = username;
        this.password = password;
        this.numberOfBooksRegistered = 0;
        this.numberOfBooksLoaned = 0;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getNumberOfBooksRegistered() {
        return numberOfBooksRegistered;
    }
    public int getNumberOfBooksLoaned() {
        return numberOfBooksLoaned;
    }


    public void setNumberOfBooksLoaned(int numberOfBooksLoaned) {
        this.numberOfBooksLoaned = numberOfBooksLoaned;
    }
    public void setNumberOfBooksRegistered(int numberOfBooksRegistered) {
        this.numberOfBooksRegistered = numberOfBooksRegistered;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
