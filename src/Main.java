import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Main klassen er hvor vi koerer vores program. Her samler vi alt op fra de andre klassen.
 */
public class Main extends Application {

    private static boolean er_login = false;

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        //launch(args);

        System.out.println("Nice job Team One!");

        Login_GUI run = new Login_GUI();
        DB_Statements test = new DB_Statements();



        // nyt x DB_Statements objrkt

        // er_login = x.checkLogin(String username, String password)

        String username = "Thomas";
        String password = "12345678";

        if ( test.checkLogin(username, password)){

            System.out.println("Dette kører kun hvis du er logget ind.");

            Bruger.insertBrugerData();

            Konto.insertKontoData();

            Konto saldo = new Konto();
            saldo.insertSaldoData();

            saldo.insertMoney();

            EndOfDay.backup();
            // Afslutter programmet efter testen er koert
            System.exit(0);
        }



    }


    @Override
   public void start(Stage primaryStage) {

        // Laver et objekt af klassen AAbenVindue
        //AAbenVindue aabenVindue = new AAbenVindue();


        //aabenVindue.kontonavnGUI(primaryStage);

    }



}