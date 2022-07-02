package DataBase;

import java.sql.Connection;

public class ourMain {
    public static void main(String[] args)
    {
        Connection conn = Dbconnect.getConnect();
        if (conn == null) System.out.println("Connection failed");
        else System.out.println("Success");
    }
}
