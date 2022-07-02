package DataBase;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dbconnect {
    private static Connection connection = null;

    public static Connection getConnect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library" , "root" , "admin");
        }
        catch (SQLException ex) {
            Logger.getLogger(Dbconnect.class.getName()).log(Level.SEVERE,null , ex);
        }
        return connection;
    }
}
