import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Konto {

    static Connection con = DB_Connector.connect();
    static Statement stmt = null;

    // Metode til at lave kontoer med konto_type, reg_nr, konto_nr, rentesats, saldo, overtraeksgebyr og id
    public static void lavKonto(String Konto_type, int reg_nr, int konto_nr, double rentesats,
                                int saldo, int overtraeksgebyr, String overtraek, int id) throws SQLException {
        // Initialiserer varibler der skal bruges
        String sql;
        int hentet_reg_nr = 0;
        int hentet_konto_nr = 0;

        // Henter et reg_nr og konto_nr fra konto tabelen hvor reg_nr er reg_nr variablen og konto_nr er konto_nr variablen
        stmt = con.createStatement();
        sql = "SELECT reg_nr, konto_nr FROM konto WHERE reg_nr = " + reg_nr + " AND konto_nr = " + konto_nr;
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) { // Indsaetter reg_nr i hentet_reg_nr og konto_nr i hentet_konto_nr hvis den har hentet det
            hentet_reg_nr = rs.getInt("reg_nr");
            hentet_konto_nr = rs.getInt("konto_nr");
        }

        if (hentet_reg_nr == reg_nr && hentet_konto_nr == konto_nr) {
            System.out.println("Konto med reg_nr: " + reg_nr + " og konto_nr: " + konto_nr + " findes allerede!");
        } else {
            System.out.println("Creating statement...");
            stmt = con.createStatement();
            sql = "INSERT INTO konto VALUES  ('" + Konto_type + "', " + reg_nr + ", " + konto_nr + ", " + rentesats
                    + ", " + saldo + ", " + overtraeksgebyr + ", '" + overtraek + "', " + id + " );";
            System.out.println(sql);
            stmt.execute(sql);
            System.out.println("Successful!");
        }
    }

    // Metode til at lave flere forskellige kontoer
    public static void insertKontoData() throws SQLException {

        lavKonto("Loenkonto", 4056, 568465125, 1, 100000, 1200, "Ja", 1);
        lavKonto("Opsparingskonto", 4052, 547891250, 1.2, 250000, 0, "Nej", 1);
        lavKonto("Loenkonto", 3652, 568465555, 1, 100000, 1500, "Ja", 1);
        lavKonto("Opsparingskonto", 1457, 568465558, 1.2, 250000, 0, "Nej", 1);

        lavKonto("Loenkonto", 8748, 698551789, 1.8, 10000, 2000, "Ja", 2);
        lavKonto("Opsparingskonto", 6985, 264874259, 1.1, 600000, 0, "Nej", 2);

        lavKonto("Loenkonto", 5874, 748547989, 1.3, 41000, 2500, "Ja", 3);
        lavKonto("Opsparingskonto", 3698, 478514789, 1.2, 600000, 0, "Nej", 3);

        lavKonto("Loenkonto", 1520, 697564654, 1, 20000, 1000, "Ja", 4);
        lavKonto("Opsparingskonto", 7845, 258748965, 1.4, 500000, 0, "Nej", 4);

        lavKonto("Loenkonto", 5325, 582102093, 1.1, 35000, 1500, "Ja", 5);
        lavKonto("Opsparingskonto", 8745, 754864896, 1.3, 700000, 0, "Nej", 5);

    }


    //Metode til at indsaette et nyt beloeb paa et bestemt reg_nr
    public void insertMoney() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n1: Indsaet penge.\n2: Traek penge.\nSkriv 1 eller 2, efter hvad du vil.");
        int userinput = input.nextInt();
        if (userinput == 1){
            System.out.println("\nIndtast beloeb som skal indsaettes:");
            int beloeb = input.nextInt();
            System.out.println("Indtast reg. nr og konto nr som skal have overfoert penge:");
            int reg_nr = input.nextInt();
            int konto_nr = input.nextInt();
            String query = "UPDATE konto set saldo = saldo + " + beloeb + " where konto_nr = " + konto_nr;
            String query3 = "Insert into transactioner (Til_kontoNr, Indfoertbeloeb) values " +
                    "("+ konto_nr+","+ beloeb+")";

            try {
                //Connect
                stmt = con.createStatement();
                //execute query
                stmt.executeUpdate(query);
                stmt.executeUpdate(query3);


                System.out.println("\n--Overfoert penge: " + beloeb + "kr til reg. nummer: " + reg_nr +
                        " og kontonummer: " + konto_nr + "--");
                System.out.println("\n--Lagt ind i transaktionslog--");
            } catch (SQLException ex) {
                //Handle exceptions
                System.out.println("\n--Query did not execute--");
                ex.printStackTrace();
            }
        } else {
            System.out.println("\nIndtast beloeb som skal traekkes:");
            int beloeb = input.nextInt();
            System.out.println("Indtast reg. nr og konto nr som skal have trukket penge:");
            int reg_nr2 = input.nextInt();
            int konto_nr2 = input.nextInt();
            String query2 = "UPDATE konto set saldo = saldo - " + beloeb + " where konto_nr = " + konto_nr2;
            String query3 = "Insert into transactioner (Fra_Konto, Trukketbeloeb) values " +
                    "("+konto_nr2+"," + -beloeb+")";

            try {
                //Connect
                stmt = con.createStatement();
                //execute query

                stmt.executeUpdate(query2);
                stmt.executeUpdate(query3);



                System.out.println("\n--Trukket penge: " + beloeb + "kr fra reg. nummer: " + reg_nr2 +
                        " og kontonummer: " + konto_nr2 + "--");
                System.out.println("\n--Lagt ind i transaktionslog--");

            } catch (SQLException ex) {
                //Handle exceptions
                System.out.println("\n--Query did not execute--");
                ex.printStackTrace();
            }
        }

    }

    //Overfoere penge fra konto til konto
    public void insertSaldoData() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nIndtast overfoerselsbeloeb:");
        int beloeb = input.nextInt();
        System.out.println("Indtast reg. nr og konto nr som skal have overfoert penge:");
        int reg_nr = input.nextInt();
        int konto_nr = input.nextInt();
        System.out.println("Indtast reg. nr og konto nr som skal have trukket penge:");
        int reg_nr2 = input.nextInt();
        int konto_nr2 = input.nextInt();


        //SQL query
        //String query ="Update konto set saldo = " + beloeb + " where reg_nr = " + reg_nr;
        String query = "UPDATE konto set saldo = saldo + " + beloeb + " where konto_nr = " + konto_nr;
        String query2 = "UPDATE konto set saldo = saldo - " + beloeb + " where konto_nr = " + konto_nr2;
        String query3 = "Insert into transactioner (Fra_Konto, Trukketbeloeb, Til_kontoNr, Indfoertbeloeb) values " +
                "("+konto_nr2+"," + -beloeb+","+ konto_nr+","+ beloeb+")";


        try {
            //Connect
            stmt = con.createStatement();
            //execute query
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);

            System.out.println("\n--Overfoert penge: " + beloeb + "kr til reg. nummer: " + reg_nr +
                    " og kontonummer: " + konto_nr + "--");
            System.out.println("\n--Trukket penge: " + beloeb + "kr fra reg. nummer: " + reg_nr2 +
                    " og kontonummer: " + konto_nr2 + "--");
            System.out.println("\n--Lagt ind i transaktionslog--");
        } catch (SQLException ex) {
            //Handle exceptions
            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();
        }
    }

}
