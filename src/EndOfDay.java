import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
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
            String sql, hentetFnavn, hentetLnavn, hentetAdresse, hentetKonto_type, hentetOvertraeks, hentetUsername;
            int hentetPerson_id, hentetReg_nr, hentetKonto_nr, hentetRentesats, hentetSaldo, hentetOvertraeksgebyr, hentetId, hentetFra_Konto, hentetTil_Konto, hentetPassword;
            double hentetTrukketbelob, hentetIndfortbelob;
            Timestamp hentetTimestamp;


            output.println("Person_id \t\t fnavn \t\t lnavn \t\t adresse");
            output.println("------------------------------------------------");

            // Henter bruger tabelen
            stmt = con.createStatement();
            sql = "SELECT * FROM bruger";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())   { // Indsaetter raekkerne fra bruger tabelen ind i tekstfilen
                hentetPerson_id = rs.getInt(1);
                hentetFnavn = rs.getNString(2);
                hentetLnavn = rs.getNString(3);
                hentetAdresse = rs.getNString(4);
                output.print(hentetPerson_id + "\t\t" + hentetFnavn + "\t\t" + hentetLnavn + "\t\t" + hentetAdresse + "\n");
            }

            output.println();
            output.println("Konto_type \t\t reg_nr \t\t konto_nr \t\t rentesats \t\t saldo \t\t overtraeksgebyr \t\t overtraek \t\t id");
            output.println("------------------------------------------------------------------------------------------------------------------------------------");

            // Henter konto tabelen
            stmt = con.createStatement();
            sql = "SELECT * FROM konto";
            rs = stmt.executeQuery(sql);
            while (rs.next())   { // Indsaetter raekkerne fra konto tabelen ind i tekstfilen
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

            output.println();
            output.println("id \t\t Fra_Konto \t\t Trukketbeløb \t\t Til_kontoNr \t\t Indførtbeløb \t\t Timestamp");
            output.println("------------------------------------------------------------------------------------------------------------------------------------");

            // Henter transactioner tabelen
            stmt = con.createStatement();
            sql = "SELECT * FROM transactioner";
            rs = stmt.executeQuery(sql);
            while (rs.next())   { // Indsaetter raekkerne fra transactioner tabelen ind i tekstfilen
                hentetId = rs.getInt(1);
                hentetFra_Konto = rs.getInt(2);
                hentetTrukketbelob = rs.getDouble(3);
                hentetTil_Konto = rs.getInt(4);
                hentetIndfortbelob = rs.getDouble(5);
                hentetTimestamp = rs.getTimestamp(6);
                output.print(hentetId + "\t\t" + hentetFra_Konto + "\t\t" + hentetTrukketbelob + "\t\t" + hentetTil_Konto + "\t\t" + hentetIndfortbelob + "\t\t" + hentetTimestamp + "\n");
            }

            output.println();
            output.println("username \t\t password");
            output.println("------------------------------------------------------------------------------------------------------------------------------------");

            // Henter login tabelen
            stmt = con.createStatement();
            sql = "SELECT * FROM login";
            rs = stmt.executeQuery(sql);
            while (rs.next())   { // Indsaetter raekkerne fra login tabelen ind i tekstfilen
                hentetUsername = rs.getNString(1);
                hentetPassword = rs.getInt(2);
                output.print(hentetUsername + "\t\t" + hentetPassword + "\n");
            }

        }
        System.out.println("End Of Days backup successful!");
    }

}
