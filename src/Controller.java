import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;

/** Controller-klassen bruges til at sætte funktioner og metoder paa vores GUI.
 * I det hele taget saa goer Controller-klassen at vores GUI'er faar nogle funktioner.
 */
public class Controller {

    @FXML
    private Button btnGennemfoerOverfoersel;
    @FXML
    private TextField txtBeloeb;
    @FXML
    private MenuItem miAction1; //Overfoer fra
    @FXML
    private MenuItem miAction2; //Overfoer fra
    @FXML
    private MenuItem miAction3; //Overfoer til
    @FXML
    private MenuItem miAction4; //Overfoer til
    @FXML
    private TableView tableView; 

    /** Naar vores knapper fra vores GUI gaar ind og laeser den her metoden, saa vil de faa en action.
     * @param e er et objekt som metoden bruger til at kalde paa andre metoden, som fx e.getSource()
     */
    @FXML
    private void handleButtonAction(javafx.event.ActionEvent e) {
        int beloeb; //det indtastede beloeb i textfield

        beloeb=Integer.parseInt(txtBeloeb.getText()); //Laeser det beloeb man har indtastet i beloebsfeltet

        if(e.getSource() == btnGennemfoerOverfoersel) { //Koeres hvis den valgte knap bliver valgt
            System.out.println("Knappen virker og der er sendt " + beloeb + " kr.");

            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Dit beloeb paa " + beloeb + "kr er " +
                    "overfoert til den valgte konto."); //Pop-up vindue som sender en tekst


        }

    }

}
