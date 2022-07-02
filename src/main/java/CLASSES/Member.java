package CLASSES;

public class Member extends Person {
    private int ID;
    private Cart currentcart;

    public Member(String name, String email, double phone, int ID) {
        super(name, email, phone);
        this.ID = ID;
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
