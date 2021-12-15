import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
public class SelectSurveyPage extends JFrame implements ActionListener {
    static String LOCATION_PRESET="./PsychTest/data/photos/";

   //JButton firstTest = new JButton("First test");
   //JButton secondTest = new JButton("Second test");
    JPanel panel = new JPanel();
    JButton test;
    JButton firstTest = createJButtonFromImage("Test1","answer.png");
    JButton secondTest = createJButtonFromImage("Test2","answer.png");


    public static void registerCustomFonts() throws IOException, FontFormatException { //wip
        Font ebg = Font.createFont(Font.TRUETYPE_FONT, new File("./PsychTest/data/fonts/EB Garamond/static/EBGaramond-Bold.ttf"));
        Font hnl = Font.createFont(Font.TRUETYPE_FONT, new File("./PsychTest/data/fonts/Helvetica Neue/HelveticaNeue Light.ttf"));

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(ebg);
        ge.registerFont(hnl);

/*        Font EBGaramondBold = new Font("DejaVu Sans", Font.PLAIN, 20);
        Font helveticaNeueLight = new Font("DejaVu Sans", Font.BOLD, 20);*/
        JList fonts = new JList( ge.getAvailableFontFamilyNames() );
        JOptionPane.showMessageDialog(null, new JScrollPane(fonts));

    }
    public JButton createJButtonFromImage(String fileName){
        JButton button=new JButton(new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.addActionListener(this);

        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return button;
    }
    public JButton createJButtonFromImage(String text, String fileName){
        JButton button=new JButton(text, new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.addActionListener(this);

        
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setFont(new Font("Helvetica", Font.PLAIN, 16));
        return button;
    }
    public static JLabel createJLabelFromImage(String fileName){
        JLabel l=new JLabel(new ImageIcon(LOCATION_PRESET+fileName));
        l.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return l;
    }
    SelectSurveyPage(String testChoice){
        Container c = createJLabelFromImage("background - gui.png");
        c.setLayout(new FlowLayout());
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // Y_Axis from up to down
        test = createJButtonFromImage(testChoice,"answerSelected.png");

        panel.setLayout(boxlayout); // to set the box layout
        //panel.setBorder(new EmptyBorder(new Insets(100, 150, 100, 150))); // Set border for the panel
        panel.setOpaque(false);

        panel.add(Box.createRigidArea(new Dimension(0,75))); //add empty space
        JLabel testName = new JLabel();
        testName.setText("Tests");
        testName.setFont(new Font("EB Garamond",Font.PLAIN,25));
        testName.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(testName);
        panel.add(test);
        panel.add(firstTest);
        panel.add(secondTest);

        

        c.add(panel); //add panel to container,
        add(c); //add container to jframe
        pack();
        setResizable(false); //make frame unresizeable
        setVisible(true);


//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(700,520);
//        frame.setLayout(null);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == firstTest){
            System.out.println(firstTest.getText());
        }

    }

}
