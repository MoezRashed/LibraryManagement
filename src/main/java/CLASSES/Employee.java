package CLASSES;

public class Employee extends Person{
    private int Salary;
    private int EmployeeID;

    public Employee(String name, String email, double phone, int salary, int employeeID) {
        super(name, email, phone);
        Salary = salary;
        EmployeeID = employeeID;
    }

    public int getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Salary=" + Salary +
                ", EmployeeID=" + EmployeeID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
