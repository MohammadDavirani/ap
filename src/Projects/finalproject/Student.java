package Projects.finalproject;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String studentId;
    private String username;
    private String password;
    private boolean borrowRequest;

    public Student(String name, String studentId, String username, String password ,boolean borrowRequest) {
        this.name = name;
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.borrowRequest = borrowRequest;
    }

    public String getName() {
        return name;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public boolean isBorrowRequest() {
        return borrowRequest;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBorrowRequest(boolean borrowRequest) {
        this.borrowRequest = borrowRequest;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
