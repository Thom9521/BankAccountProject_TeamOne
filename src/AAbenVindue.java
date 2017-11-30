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
            // Indlaeser KontonavnGUI.fxml fil
            Parent root = FXMLLoader.load(getClass().getResource("GUI/KontonavnGUI.fxml"));

            // Laver en scene med FXML filen
            Scene scene = new Scene(root);

            // Saetter vinduet titel til Kontoejer
            primaryStage.setTitle("Kontoejer");
            // Saetter scenen
            primaryStage.setScene(scene);
            // Viser den
            primaryStage.show();



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Metode til at kalde på LoenKonto vinduet
    public void loenKonto(Stage primaryStage) {
        try {
            // Indlaeser LoenKonto.fxml fil
            Parent root = FXMLLoader.load(getClass().getResource("GUI/LoenKonto.fxml"));

            // Laver en scene med FXML filen
            Scene scene = new Scene(root);

            // Saetter vinduet titel til Kontoejer
            primaryStage.setTitle("Loen Konto");
            // Saetter scenen
            primaryStage.setScene(scene);
            // Viser den
            primaryStage.show();



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Metode til at kalde paa bankraadgiver vinduet
    public void bankraadgiver(Stage primaryStage) {
        try {
            // Indlaeser BankraadgiverScreen_System_2.fxml fil
            Parent root = FXMLLoader.load(getClass().getResource("GUI/BankraadgiverScreen_System_2.fxml"));

            // Laver en scene med FXML filen
            Scene scene = new Scene(root);

            // Saetter vinduet titel til Kontoejer
            primaryStage.setTitle("Bank raadgiver");
            // Saetter scenen
            primaryStage.setScene(scene);
            // Viser den
            primaryStage.show();



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
