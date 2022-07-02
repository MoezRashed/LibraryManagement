package com.example.librarymanagement;

public abstract class Person {
    protected  String name;
    protected String email;
    protected String phone;


    public Person(String name, String email, String phone) {
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

    public String getPhone() {
        return phone;
    }
}
