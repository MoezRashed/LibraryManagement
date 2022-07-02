package com.example.librarymanagement;

import CLASSES.Cart;

public class Member extends Person {
    private int ID;
    private Cart currentcart;

    public Member(String name, String email, String phone, int ID) {
        super(name, email, phone);
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public Cart getCurrentcart() {
        return currentcart;
    }

    @Override
    public String toString() {
        return "Member{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
