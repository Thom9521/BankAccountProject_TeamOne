import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {
    //  Declare a connection
    private static Connection con = null;
    //  JDBC driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    //  The url = jdbc:dbms//host name:port#/db name
    private static String url = "jdbc:mysql://localhost:3306/team1";
    //  User name
    private static String user = "root";
    // Password
    private static String password = "8305";

    public static Connection connect() {
        System.out.println("\n--Connecting to MySQL JDBC--");
        //  Locate MySQL JDBC Driver
        try {
            Class.forName(DRIVER);
        }
        //  Catch exceptions if JDBC is not found
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("\n--JDBC driver is missing--");

        }
        System.out.println("\n--MySQL JDBC driver registered--");

        try {
            //  Connect to MySQL DB = URL, userName, password
            con = DriverManager.getConnection(url, user, password);
        }
        // Catch exceptions on connection error
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("\n--Did not connect, try again--");
        }
        //   if connecting successful
        if (con != null) {
            System.out.println("\n--Connection successful--");
        } else {
            System.out.println("\n--Failed to connect--");
        }
        return con;
    }
}

