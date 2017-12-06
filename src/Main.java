import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * Main klassen er hvor vi koerer vores program. Her samler vi alt op fra de andre klassen.
 */
public class Main {


    public static void main(String[] args) throws FileNotFoundException, SQLException {
        //launch(args);
        System.out.println("Nice job Team One!");

        Login_GUI run = new Login_GUI();

    }


  /*  @Override
   public void start(Stage primaryStage) {

        // Laver et objekt af klassen AAbenVindue
        //AAbenVindue aabenVindue = new AAbenVindue();


        //aabenVindue.kontonavnGUI(primaryStage);*/

    }


