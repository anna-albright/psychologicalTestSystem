import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class NewAccountPage implements ActionListener {
    JFrame frame = new JFrame("Create New Account");
    ImageIcon icon = new ImageIcon("PsychTest/src/Photos/CS210 GUI Mockup Create Account.png");

    JLabel CreateAccountLabel = new JLabel(icon);
    JButton button = new JButton("Create Account");
    JLabel createIDLabel = new JLabel("Create New ID");
    JLabel createPasswordLabel = new JLabel("Create Password");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    //Constructor
    NewAccountPage(){

        CreateAccountLabel.setSize(700,500); // the photo

        createIDLabel.setBounds(300,240,100,25);
        createIDLabel.setForeground(new Color(255,160,100));

        createPasswordLabel.setBounds(300,300,150,25);
        createPasswordLabel.setForeground(new Color(255,160,100));

        button.setBounds(250,425,200,40);
        button.addActionListener(this);

        // text entry fields
        userIDField.setBounds(280,260,140,35);
        userPasswordField.setBounds(280,320,140,35);



        frame.add(createIDLabel);
        frame.add(createPasswordLabel);
        frame.add(button);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(CreateAccountLabel);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700,520);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){

            // getting information in the text boxes
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            MainClass.user = new User();
            String[] loginInfo = new String[2];
            loginInfo[0] = userID;
            loginInfo[1] = password;

            //IDandPasswords.putEntry(userID,password); // adding a new user to the system
            try {
                MainClass.user.createAccount(loginInfo);
                WelcomePage welcomePage = new WelcomePage(userID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                frame.dispose(); // getting rid of create account frame

        }

    }
}
