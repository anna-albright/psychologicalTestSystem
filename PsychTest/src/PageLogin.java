import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class PageLogin extends JFrame implements ActionListener {
    static String LOCATION_PRESET="./PsychTest/data/photos/";
    ArrayList<JButton> answersArray= new ArrayList<>();

    JLabel bg=createJLabelFromImage("welcome2.png");
    Container c = bg;

    JPanel panel = new JPanel(); // Set the panel to add buttons
    
    int fontSize=15;

    JLabel optionTitle = new JLabel();
    JButton buttonSignIn=createJButtonFromImageML("sign in", "usernameOrPassword.png");
    JButton buttonCreate=createJButtonFromImageML("create account", "usernameOrPassword.png");
    JButton buttonGuest=createJButtonFromImageML("continue as guest", "usernameOrPassword.png");
    JTextField textField=createTextFieldML("username");
    JPasswordField passwordField=createPasswordFieldML("password");
    JButton yesLogin = createJButtonNoTextFromImageML("yesUnselected.png");
    JButton yesCreate = createJButtonNoTextFromImageML("yesUnselected.png");

    Color previousColorTextField;
    Color previousColorPasswordField;

    public PageLogin(){
        super("PageSurvey test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        welcomeOption(); //renders welcome screen

        c.add(panel);
        c.revalidate();
        c.repaint();
        add(c); //add container to jframe

        pack();
        setLocationRelativeTo(null); //If the component is null, the window is placed in the center of the screen.
        setResizable(false); //make frame unresizeable
        setVisible(true); //do new PageSurvey().setVisible(true) in main instead later, allows for easier control

    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonSignIn)
            signInOption();
        if (e.getSource()==buttonCreate)
            createOption();
        if (e.getSource()==buttonGuest)
            new WelcomePage("test");

        if (e.getSource()==yesLogin)
        {
            String userID = textField.getText();
            String password = String.valueOf(passwordField.getPassword());
            MainClass.user = new User();
            String[] loginInfo = new String[2];
            loginInfo[0] = userID;
            loginInfo[1] = password;

            if(MainClass.user.verifyCredentials(loginInfo)){
                dispose();
                WelcomePage welcomePage = new WelcomePage(userID);
            }

        }
        if (e.getSource()==yesCreate){
            String userID = textField.getText();
            String password = String.valueOf(passwordField.getPassword());
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
            dispose(); // getting rid of create account frame
        }


    }
    public void welcomeOption() {
        if (c!=null)
            c.remove(bg);
        bg.setIcon(new ImageIcon(LOCATION_PRESET+"welcome2.png"));
        c = bg;
        c.setLayout(new FlowLayout());
/*
        optionTitle.setForeground(Color.WHITE);
        optionTitle.setText("welcome");
        optionTitle.setFont(new Font("EB Garamond",Font.BOLD,52));
        optionTitle.setAlignmentX(JComponent.CENTER_ALIGNMENT);
*/
        panel.removeAll();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // Y_Axis from up to down
        panel.setLayout(boxLayout); // to set the box layout
        panel.setOpaque(false);
        panel.add(Box.createRigidArea(new Dimension(0,287))); //add empty space
        panel.add(optionTitle);
        panel.add(buttonSignIn);
        panel.add(buttonCreate);
        panel.add(buttonGuest);

        panel.revalidate();
        panel.repaint();

    }
    public void signInOption() {
        if (c!=null)
            c.remove(bg);
        bg.setIcon(new ImageIcon(LOCATION_PRESET+"signIn.png"));
        c = bg;
        c.setLayout(new FlowLayout());

        panel.removeAll();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // Y_Axis from up to down
        panel.setLayout(boxLayout); // to set the box layout
        panel.setOpaque(false);
        panel.add(Box.createRigidArea(new Dimension(0,300))); //add empty space
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0,19))); //add empty space
        panel.add(passwordField);
        panel.add(yesLogin);

        panel.revalidate();
        panel.repaint();


    }
    public void createOption() {
        if (c!=null)
            c.remove(bg);
        bg.setIcon(new ImageIcon(LOCATION_PRESET+"create.png"));
        c = bg;
        c.setLayout(new FlowLayout());

        panel.removeAll();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // Y_Axis from up to down
        panel.setLayout(boxLayout); // to set the box layout
        panel.setOpaque(false);
        panel.add(Box.createRigidArea(new Dimension(0,300))); //add empty space
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0,19))); //add empty space
        panel.add(passwordField);
        panel.add(yesCreate);

        panel.revalidate();
        panel.repaint();
    }

    public JTextField createTextFieldML(String text)
    {
        JTextField textField = new JTextField(text);
        textField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        textField.setPreferredSize(new Dimension(172, 45));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(MainClass.bodyFontNormal);
        textField.setForeground(Color.LIGHT_GRAY); //set font color
        textField.setOpaque(false); //make transparent
        textField.setBorder(null); //remove border
        textField.addActionListener(this);
        textField.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }
        });
        return textField;

    }
    public JPasswordField createPasswordFieldML(String text){
        JPasswordField passwordField = new JPasswordField(text);

        passwordField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        passwordField.setPreferredSize(new Dimension(172, 45));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER); //set text to center
        passwordField.setFont(MainClass.bodyFontNormal);
        passwordField.setOpaque(false); //make transparent
        passwordField.setBorder(null); //remove border
        passwordField.setForeground(Color.LIGHT_GRAY); //set font color
        passwordField.addActionListener(this);

        passwordField.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                passwordField.setText("");
                passwordField.setForeground(Color.BLACK);
            }
        });

        return passwordField;
    }
    public JButton createJButtonFromImageML(String text,String fileName){
        JButton button=new JButton(text, new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        //button.setHorizontalAlignment(SwingConstants.LEFT); //make text justify to left?
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setFont(MainClass.bodyFontNormal);

        button.setFocusPainted(false);
        button.addActionListener(this);

        button.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                button.setForeground(MainClass.customBlue);
                button.setFont(MainClass.bodyFontNormal);

            }
            public void mouseExited(MouseEvent e){
                button.setForeground(Color.BLACK);
                button.setFont(MainClass.bodyFontNormal);

            }
            public void mousePressed(MouseEvent e) {
                button.setForeground(MainClass.customBlue);
                button.setFont(MainClass.bodyFontSelected);
            }
        });
        return button;
    }
    public JButton createJButtonNoTextFromImageML(String fileName){
        JButton button=new JButton(new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setFocusPainted(false);
        button.addActionListener(this);

        button.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                button.setIcon(new ImageIcon(LOCATION_PRESET+"yesSelected.png"));
                previousColorTextField=textField.getForeground();
                previousColorPasswordField=passwordField.getForeground();
                textField.setForeground(MainClass.customBlue);
                passwordField.setForeground(MainClass.customBlue);
            }
            public void mouseExited(MouseEvent e){
                button.setIcon(new ImageIcon(LOCATION_PRESET+"yesUnselected.png"));
                if (previousColorTextField==Color.LIGHT_GRAY)
                    textField.setForeground(Color.LIGHT_GRAY);
                else
                    textField.setForeground(Color.BLACK);

                if (previousColorPasswordField==Color.LIGHT_GRAY)
                    passwordField.setForeground(Color.LIGHT_GRAY);
                else
                    passwordField.setForeground(Color.BLACK);

            }
            public void mousePressed(MouseEvent e) {

            }
        });
        return button;
    }
    public JButton createJButtonFromImage(String text,String fileName){
        JButton button=new JButton(text, new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        //button.setHorizontalAlignment(SwingConstants.LEFT); //make text justify to left?
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setFont(MainClass.bodyFontNormal);

        button.setFocusPainted(false);
        button.addActionListener(this);

        return button;
    }
    public static JLabel createJLabelFromImage(String fileName){
        JLabel l=new JLabel(new ImageIcon(LOCATION_PRESET+fileName));
        l.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return l;
    }
}