import javafx.application.Application;
import javafx.application.Platform;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Login_GUI indeholder vores beskrivels af design af GUI'en.
 */
public class Login_GUI {
    //Declare the frame/window
    private JFrame frame;
    //Declare user text field
    private JTextField userNameField;
    //Declare password field
    private JPasswordField passwordField;
    //Declare user label
    private JLabel userNameLabel;
    //Declare password label
    private JLabel passwordLabel;
    //Declare connect button
    private JButton btnConnect;

    //Constructor

    public Login_GUI() {
        initialize();
    }

    //The initialize method that builds the window
    private void initialize() {
        //Creates the frame/window
        frame = new JFrame("Login Window");
        frame.setBounds(500, 300, 450, 300);
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //Gør at programmet stopper med at køre på X - knappen
        frame.getContentPane().setLayout(null);

        //Create user field
        userNameField = new JTextField();
        userNameField.setBounds(156, 56, 203, 26);
        frame.getContentPane().add(userNameField);
        userNameField.setColumns(10);

        //Create password field
        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(156, 107, 203, 26);
        frame.getContentPane().add(passwordField);

        //Create user label
        userNameLabel = new JLabel("Username:");
        userNameLabel.setBounds(57, 61, 87, 16);
        frame.getContentPane().add(userNameLabel);

        //Create password label
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(63, 112, 70, 16);
        frame.getContentPane().add(passwordLabel);

        //Create connect button
        btnConnect = new JButton("Connect");
        btnConnect.setBounds(148, 172, 117, 29);
        frame.getContentPane().add(btnConnect);




        //Create button action
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DB_Statements stmts = new DB_Statements();


                try {
                    String username = userNameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (stmts.checkLogin(username, password)) {
                        JOptionPane.showMessageDialog(null, "User found\nAccess granted");
                        frame.setVisible(false);

                        Bruger.insertBrugerData();

                        Konto.insertKontoData();

                        Konto saldo = new Konto();

                        saldo.insertSaldoData();

                        saldo.insertMoney();

                        EndOfDay.backup();
                        // Afslutter programmet efter testen er koert
                        System.exit(0);


                    } else {
                        JOptionPane.showMessageDialog(null, "User or password is incorrect" +
                                "\nAccess denied");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }


            }
        });

        frame.setVisible(true);
    }


}
