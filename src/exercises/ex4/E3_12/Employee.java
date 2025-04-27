package exercises.ex4.E3_12;

public class Employee {
    private double employeeSalary;
    private String employeeName;
    private double employeeSalaryPercent;

    public Employee(String employeeName, double currentSalary){
        this.employeeSalary = currentSalary;
        this.employeeName = employeeName;
        employeeSalaryPercent = 0;
    }

    public double getSalary() {
        return employeeSalary;
    }

    public String getName() {
        return employeeName;
    }

    public void raiseSalary(double byPercent) {
        employeeSalaryPercent = byPercent;

        double raise = employeeSalary * employeeSalaryPercent / 100;
        employeeSalary += raise;
    }
}
