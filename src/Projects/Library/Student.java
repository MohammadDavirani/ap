package Projects.Library;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String major;
    private Long studentId;
    private LocalDate memberShipDate;


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                ", studentId=" + studentId +
                ", memberShipDate=" + memberShipDate +
                '}';
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
