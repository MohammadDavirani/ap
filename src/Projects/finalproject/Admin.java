package Projects.finalproject;

import java.io.Serializable;

public class Admin extends Person implements Serializable {
    private int numberOfBooksRegistered;
    private int numberOfBooksLoaned;
    private int numberOfBooksReceived;

    public Admin(String username, String password){
        super(username,password);
        this.numberOfBooksRegistered = 0;
        this.numberOfBooksLoaned = 0;
        this.numberOfBooksReceived =0;
    }

    public String getUsername() {
        return super.getUsername();
    }
    public String getPassword() {
        return super.getPassword();
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
        super.setUsername(username);
    }
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", numberOfBooksRegistered=" + numberOfBooksRegistered +
                ", numberOfBooksLoaned=" + numberOfBooksLoaned +
                ", numberOfBooksReceived=" + numberOfBooksReceived +
                '}';
    }
}
