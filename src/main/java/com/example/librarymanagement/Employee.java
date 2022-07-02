package com.example.librarymanagement;


public class Employee extends Person {
    private int Salary;
    private int EmployeeID;

    public Employee(String name, String email, String phone, int salary, int employeeID) {
        super(name, email, phone);
        Salary = salary;
        EmployeeID = employeeID;
    }

    public int getSalary() {
        return Salary;
    }

    public int getEmployeeID() {
        return EmployeeID;
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
