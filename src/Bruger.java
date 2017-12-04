import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *Bruger klassen bliver brugt til og oprettet bruger ned i Databasen
 * */

public class Bruger {
/**
 * Soeger for vores connect til vores DB fra DB_Connector klassen*/
    static Connection con = DB_Connector.connect();
    static Statement stmt = null;

    /** Vi erklaer vores info om vores bruger vi vil oprettet
     * hvor vi vaelger hvilken datatyper det skal vaere.
     * @param Person_id soeger for vi skal lave et id
     * @param fnavn soeger for at vi skal skrive et fornavn
     * @param lnavn soeger for at vi skal skrive et efternavn
     * @param adresse soeger for vi skal skrive et efternavn
     * @throws SQLException fjenere fejl hvis der er nogen
     **/


    // Laver en bruger med person_id, fornavn, efternavn og adresse
    public static void lavBruger(int Person_id, String fnavn, String lnavn, String adresse) throws SQLException {
        /** // Initialiserer varibler der skal bruges
         */
        String sql;
        int hentetId = 0;

        /**Henter et Person_id fra bruger tabelen hvor Person_id er Person_id variablen
         * check om bruger allerede findes
         */
        stmt = con.createStatement();
        sql = "SELECT Person_id FROM bruger WHERE Person_id = " + Person_id;
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next())   { // Indsaetter Person_id i hentetId hvis den har hentet det
            hentetId = rs.getInt("Person_id");
        }

        if (hentetId == Person_id) {
            System.out.println("Bruger med Person_id: " + Person_id + " findes allerede!");
        }
        /**
         * ellers opretter den bruger som er lavet nede under
         */
        else {
            System.out.println("Creating statement...");
            stmt = con.createStatement();

            //AI (fnavn, lnavn, adresse)
            sql = "INSERT INTO bruger VALUES (" + Person_id + ", '" + fnavn + "', '" + lnavn + "', '" + adresse + "');";
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Successful!");
        }
    }

    /** Metode til at lave flere forskelige brugere med lavBruger metoden
     *
     * @throws SQLException soeger for hvis der fejl at den bare forsaetter
     */
    public static void insertBrugerData() throws SQLException {

        lavBruger( 1,"Erik", "Ruhmanis", "Troensevej");
        lavBruger(2,"Thomas", "Christensen", "Parkvej");
        lavBruger( 3,"Michael", "Trans", "Danavej");
        lavBruger( 4,"Daniel", "Nørd", "Femøvej");
        lavBruger( 5,"Burhan", "Öztürk", "Maglemølle");

    }
}
