package exercises.ex4.E3_12;

public class EmployeeTester {
    public static void main(String[] args) {
        Employee e1 = new Employee("mohammad",50000);
        System.out.println("Name: " + e1.getName());
        System.out.println("Salary: " + e1.getSalary());

        e1.raiseSalary(10);
        System.out.println("New Salary: " + e1.getSalary());
    }
}
