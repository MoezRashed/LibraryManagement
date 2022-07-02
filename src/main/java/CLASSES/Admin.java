package CLASSES;

public class Admin {
    private static Admin Myadmin;
    private static String username;
    private static String password;

    private Admin(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public static Admin getInstance()
    {
        if (Myadmin == null)
        {
            Myadmin = new Admin("root", "admin");
        }
        return Myadmin;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
    //chr=eck
}
