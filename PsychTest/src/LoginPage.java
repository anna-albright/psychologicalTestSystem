import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame(); // creating a new frame

    ImageIcon icon = new ImageIcon("PsychTest/src/Photos/CS210 GUI Mockup (Unit 2).png"); // calling the login screen image

    JLabel loginPhoto = new JLabel(icon);
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton createAccount = new JButton("Create New Account");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel userIDLabel = new JLabel("User ID:");
    JLabel messageLabel = new JLabel("");

    String[] loginInfo = new String[2];

    /**
     *
     */
    LoginPage(){


        userIDLabel.setBounds(325,200,75,25);
        userIDLabel.setForeground(new Color(255,160,100));

        userPasswordLabel.setBounds(325,280,75,25);
        userPasswordLabel.setForeground(new Color(255,160,100));

        messageLabel.setBounds(280,100,200,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        // text entry fields
        userIDField.setBounds(280,220,140,35);
        userPasswordField.setBounds(280,300,140,35);

        loginButton.setBounds(250, 375, 100, 35);
        loginButton.addActionListener(this);

        resetButton.setBounds(350, 375, 100, 35);
        resetButton.addActionListener(this);

        createAccount.setBounds(250,420,200,35);
        createAccount.setForeground(new Color(20,100,100));
        createAccount.setBackground(Color.RED);
        createAccount.addActionListener(this);

        loginPhoto.setSize(700,500);


        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(createAccount);
        frame.add(loginPhoto);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700,520);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** Controls the action events
     *
     * @param e controls the source of the button clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource() == loginButton){

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            MainClass.user = new User();
            loginInfo[0] = userID;
            loginInfo[1] = password;

            if(MainClass.user.verifyCredentials(loginInfo)){

                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Login successful");
                frame.dispose();
                WelcomePage welcomePage = new WelcomePage(userID);
            }
            else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Wrong Input");

            }

        }
        if(e.getSource() == createAccount){
            new NewAccountPage();
        }

    } // end of action event


} // end of class
