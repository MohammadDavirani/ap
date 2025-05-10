package Projects.Library;

public class Student {
    private String firstName;
    private String lastName;
    private String major;
    private int studentId;
    private int memberShipDate;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMajor() {
        return major;
    }
    public int getStudentId() {
        return studentId;
    }
    public int getMemberShipDate() {
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
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setMemberShipDate(int memberShipDate) {
        this.memberShipDate = memberShipDate;
    }
}
