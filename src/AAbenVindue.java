import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AAbenVindue {

    public AAbenVindue() {
    }

    // Metode til at kalde på kontonavnGUI vinduet
    public void kontonavnGUI(Stage primaryStage) {
        try {
            // Indlæser KontonavnGUI.fxml fil
            Parent root = FXMLLoader.load(getClass().getResource("GUI/KontonavnGUI.fxml"));

            // Laver en scene med FXML filen
            Scene scene = new Scene(root);

            // Sætter vinduet titel til Kontoejer
            primaryStage.setTitle("Kontoejer");
            // Sætter scenen
            primaryStage.setScene(scene);
            // Viser den
            primaryStage.show();



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Metode til at kalde på LønKonto vinduet
    public void lønKonto(Stage primaryStage) {
        try {
            // Indlæser LønKonto.fxml fil
            Parent root = FXMLLoader.load(getClass().getResource("GUI/LoenKonto.fxml"));

            // Laver en scene med FXML filen
            Scene scene = new Scene(root);

            // Sætter vinduet titel til Kontoejer
            primaryStage.setTitle("Loen Konto");
            // Sætter scenen
            primaryStage.setScene(scene);
            // Viser den
            primaryStage.show();



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Metode til at kalde på bankrådgiver vinduet
    public void bankrådgiver(Stage primaryStage) {
        try {
            // Indlæser BankrådgiverScreen_System_2.fxml fil
            Parent root = FXMLLoader.load(getClass().getResource("GUI/BankraadgiverScreen_System_2.fxml"));

            // Laver en scene med FXML filen
            Scene scene = new Scene(root);

            // Sætter vinduet titel til Kontoejer
            primaryStage.setTitle("Bank raadgiver");
            // Sætter scenen
            primaryStage.setScene(scene);
            // Viser den
            primaryStage.show();



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
