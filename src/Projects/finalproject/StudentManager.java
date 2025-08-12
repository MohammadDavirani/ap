package Projects.finalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentManager implements Serializable {
    private List<Student> students;
    private List<BooksRequested> booksRequested;


    public StudentManager() {
        this.students = new ArrayList<>();
        this.booksRequested = new ArrayList<>();
    }
    public List<Student> getStudents(){
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //methods
    public void registerStudent(String name, String studentId, String username, String password, boolean borrowRequest) {
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        }

        Student newStudent = new Student(name, studentId, username, password, borrowRequest);
        students.add(newStudent);
        System.out.println("Student registration completed successfully.");
    }

    public List<BooksRequested> getAllRequests() {
        return new ArrayList<>(booksRequested);
    }
    public void addToRequestList(BooksRequested booksRequested){
        this.booksRequested.add(booksRequested);
    }
    public void removeRequest(BooksRequested request) {
        this.booksRequested.remove(request);
    }

    public Student authenticateStudent(String username, String password) {
        return students.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
    public void displayStudents() {
        System.out.println("\n--- List of Registered Students ---");

        if (students.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
    private boolean isUsernameTaken(String username) {
        return students.stream().anyMatch(s -> s.getUsername().equals(username));
    }
    public int getStudentCount() {
        return students.size();
    }

}

