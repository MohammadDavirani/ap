package Projects.Library;

import midtermexam.Shop;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String major;
    private Long studentId;
    private LocalDate memberShipDate;


    public Student(){

    }

    public Student(String dataLine) {
        String[] parts = dataLine.split(",");
        this.firstName = parts[0].split("=")[1];
        this.lastName = parts[1].split("=")[1];
        this.major = parts[2].split("=")[1];
        this.studentId = Long.parseLong(parts[3].split("=")[1].trim());
        this.memberShipDate = LocalDate.parse(parts[4].split("=")[1].trim());
    }

    public Student(String first, String last, String it, Long i, LocalDate now) {
        this.firstName = first;
        this.lastName = last;
        this.major = it;
        this.studentId = i;
        this.memberShipDate = now;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                ", studentId=" + studentId +
                ", memberShipDate=" + memberShipDate
                ;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMajor() {
        return major;
    }
    public Long getStudentId() {
        return studentId;
    }
    public LocalDate getMemberShipDate() {
        return memberShipDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public void setMemberShipDate(LocalDate memberShipDate) {
        this.memberShipDate = memberShipDate;
    }
}
