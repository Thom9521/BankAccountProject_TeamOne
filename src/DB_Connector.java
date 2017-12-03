import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB_Connector soerger for at vi kan connect til databasen fra IntelliJ. Ved hjaelp af specifike Driver, url, user og
 * password er det muligt at connect til databasen.
 */
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
    private static String password = "xmeto123";

    /**
     * Connect metoden tager brug af vores variabler som ses ovenfaar. Disse kan aendres saa hele metoden kan bruges igen
     * men til en anden specifik database. Metoden tager brug af try and catch, saa naar vi koerer programmet, saa vil
     * det ikke afslutte hvis der dukker en fejl op, men derimod komme med en fejl besked, saa vi kan se hvor fejlen er.
     * @return retunerer vores connectionen.
     */
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

        /**
         * En if metode saa retunerer det ene eller det andet alt efter om con = null eller con != null.
         */
        if (con != null) {
            System.out.println("\n--Connection successful--");
        } else {
            System.out.println("\n--Failed to connect--");
        }
        return con;
    }
}

