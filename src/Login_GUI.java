import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI {
    //declare the frame/window
    private JFrame frame;

    //declare user text field
    private JTextField userNameField;

    //declare password field
    private JPasswordField passwordField;

    //declare user label
    private JLabel userNameLbl;

    //declare password label
    private  JLabel passwordLbl;

    //declare connect button
    private  JButton btnConnect;

    //constructor

    public Login_GUI() {
        initialize();
    }
    //the initialize method that builds the windows
    private void initialize() {

        //creates the frame/windows
        frame = new JFrame("Login Window");
        frame.setBounds(500,500, 450, 300);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //create user field
        userNameField = new JTextField();
        userNameField.setBounds(156,56,203,26);
        frame.getContentPane().add(userNameField);
        userNameField.setColumns(10);

        //create the password field
        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(156,107,203,26);
        frame.getContentPane().add(passwordField);

        //create user label
        userNameLbl = new JLabel("User Name:");
        userNameLbl.setBounds(57,61,87,16);
        frame.getContentPane().add(userNameLbl);

        //create password label
        passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(63,112,70,16);
        frame.getContentPane().add(passwordLbl);

        //create connect button

        btnConnect = new JButton("Connect");
        btnConnect.setBounds(148,172,117,29);
        frame.getContentPane().add(btnConnect);

        //create button action
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DB_Statements stmts = new DB_Statements();
                try{
                    String username = userNameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (stmts.checklogin(username, password)){
                        JOptionPane.showMessageDialog(null,"User Found\nAcess Granted");
                    }else {
                        JOptionPane.showMessageDialog(null, "User Not Found or wrong password\nAccess Denied");
                    }
                }
                catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1);
                }
            }
        });
        frame.setVisible(true);



    }

}

