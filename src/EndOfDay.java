import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class EndOfDay {

    static Connection con = DB_Connector.connect();
    static Statement stmt = null;

    // Metode til at lave en End Of Day backup
    public static void backup() throws FileNotFoundException, SQLException {

        // Laver en dato til vores End Of Days filer i filnavnet
        Date date = new Date();
        String dagensDato = date.toString();
        dagensDato = dagensDato.replaceAll(" ", "_");
        dagensDato = dagensDato.replaceAll(":", "_");

        File file = new File("End_Of_Days/End_Of_Day_" + dagensDato + ".txt");

        try (
            // Laver filen
            PrintWriter output = new PrintWriter(file);
        ) {
            // Initialiserer varibler der skal bruges
            String sql;
            int hentetPerson_id;
            String hentetFnavn;
            String hentetLnavn;
            String hentetAdresse;
            String hentetKonto_type;
            int hentetReg_nr;
            int hentetKonto_nr;
            int hentetRentesats;
            int hentetSaldo;
            int hentetOvertraeksgebyr;
            String hentetOvertraeks;
            int hentetId;

            output.println("Person_id \t\t fnavn \t\t lnavn \t\t adresse");
            output.println("------------------------------------------------");

            // Henter bruger tabelen
            stmt = con.createStatement();
            sql = "SELECT * FROM bruger";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())   { // Indsætter rækkerne fra bruger tabelen ind i tekstfilen
                hentetPerson_id = rs.getInt(1);
                hentetFnavn = rs.getNString(2);
                hentetLnavn = rs.getNString(3);
                hentetAdresse = rs.getNString(4);
                output.print(hentetPerson_id + "\t\t" + hentetFnavn + "\t\t" + hentetLnavn + "\t\t" + hentetAdresse + "\n");
            }

            output.println();
            output.println("Konto_type \t\t reg_nr \t\\t konto_nr \t\t rentesats \t\t saldo \t\t overtraeksgebyr \t\t overtraek \t\t id");
            output.println("------------------------------------------------------------------------------------------------------------------------------------");

            // Henter konto tabelen
            stmt = con.createStatement();
            sql = "SELECT * FROM konto";
            rs = stmt.executeQuery(sql);
            while (rs.next())   { // Indsætter rækkerne fra konto tabelen ind i tekstfilen
                hentetKonto_type = rs.getNString(1);
                hentetReg_nr = rs.getInt(2);
                hentetKonto_nr = rs.getInt(3);
                hentetRentesats = rs.getInt(4);
                hentetSaldo = rs.getInt(5);
                hentetOvertraeksgebyr = rs.getInt(6);
                hentetOvertraeks = rs.getNString(7);
                hentetId = rs.getInt(8);
                output.print(hentetKonto_type + "\t\t" + hentetReg_nr + "\t\t" + hentetKonto_nr + "\t\t" + hentetRentesats + "\t\t" + hentetSaldo + "\t\t" + hentetOvertraeksgebyr + "\t\t" + hentetOvertraeks + "\t\t" + hentetId + "\n");
            }

        }
    }

}
