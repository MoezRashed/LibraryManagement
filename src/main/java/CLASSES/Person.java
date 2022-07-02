package CLASSES;

public abstract class Person {
    protected  String name;
    protected String email;
    protected double phone;


    public Person(String name, String email, double phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public abstract String toString();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getPhone() {
        return phone;
    }
}
