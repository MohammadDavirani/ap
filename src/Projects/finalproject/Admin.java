package Projects.finalproject;

import java.io.Serializable;

public class Admin implements Serializable {
    private String username;
    private String password;
    private int numberOfBooksRegistered;
    private int numberOfBooksLoaned;
    private int numberOfBooksReceived;

    public Admin(String username, String password){
        this.username = username;
        this.password = password;
        this.numberOfBooksRegistered = 0;
        this.numberOfBooksLoaned = 0;
        this.numberOfBooksReceived =0;
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
    public int getNumberOfBooksReceived() {
        return numberOfBooksReceived;
    }



    public void setNumberOfBooksReceived(int numberOfBooksReceived) {
        this.numberOfBooksReceived = numberOfBooksReceived;
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

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", numberOfBooksRegistered=" + numberOfBooksRegistered +
                ", numberOfBooksLoaned=" + numberOfBooksLoaned +
                ", numberOfBooksReceived=" + numberOfBooksReceived +
                '}';
    }
}
