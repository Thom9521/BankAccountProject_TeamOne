import java.sql.*;

/**
 * DB_Statements er hvor vi har metoder til vores database.
 */
public class DB_Statements {

    //  Declare a Statment
    private static Statement stmt = null;

    //   Declare a connection
    private static Connection con = DB_Connector.connect();
    //Deckare a result set
    private static ResultSet rs = null;

    //Declare a preparedstatement
    private static PreparedStatement pst = null;

    /**
     * Metode til at bruge en database
     * @param DB_Name Navnet på databasen som skal bruges. Indtastes når man koerer constructoren.
     */
    public void useDB(String DB_Name) {
        //statement
        String query = "use " + DB_Name;
        try {
            //connection
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            System.out.println("\n--using--" + DB_Name + "--");

        } catch (SQLException ex) {
            //handle sql exceptions
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();

        }
    }

    /**
     * Metode til at tjekke login når vi koerer vores login GUI.
     * @param username Bruges til at indtaste sit username
     * @param password Bruges til at indaste password
     * @return Retunere check, som tjekker om de indtastede vaerdier findes i databasen.
     */
    public Boolean checkLogin(String username, String password){
        boolean check = false;

        String query = "select * from team1.login where username = '" + username + "' and password = '" + password
                + "'";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                check = true;
                System.out.println("\n--Du er nu logget ind--");

            }
        } catch (SQLException e) {
            System.out.println("\n--Afvist");
            e.printStackTrace();
        }
        return check;
    }

}


