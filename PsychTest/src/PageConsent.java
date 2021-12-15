import org.w3c.dom.Text;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PageConsent extends JFrame implements ActionListener {
    static String LOCATION_PRESET="./PsychTest/data/photos/";
    JFrame frame = new JFrame(); // creating a new frame
    JPanel panel = new JPanel(); // Set the panel to add buttons
    JLabel consentText = new JLabel();
    JButton accept = createJButtonFromImage("","check.png");
    JButton cancel = createJButtonFromImage("","ex.png");

    public PageConsent (){

        super("Consent Form");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // for scrolling
        JPanel middlePanel = new JPanel ();
        JPanel buttomPanel = new JPanel();
        buttomPanel.setLayout(new GridLayout());
        middlePanel.setBorder(new TitledBorder( new EtchedBorder(),  "" ) );

        JTextArea display = new JTextArea ( 25, 58 );
        display.setEditable ( false );

        ArrayList<String> text = Read.fileToArrayList("consentForm.txt");

        String listString = "";
        for (String s : text)
        {
            listString += s + "\n";
        }

        display.setText(listString);
        JScrollPane scroll = new JScrollPane ( display );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );


        middlePanel.add ( scroll );

        Container c = createJLabelFromImage("background - gui.png");
        c.setLayout(new FlowLayout());

        JLabel consent = new JLabel();
        consent.setText("Informed Consent");
        consent.setFont(new Font(MainClass.headerFontName,Font.BOLD,39));
        consent.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxLayout);
        panel.setOpaque(false);
        panel.add(Box.createRigidArea(new Dimension(0,75)));
        panel.add(consent);
        panel.add(middlePanel);
        panel.add(buttomPanel);

        buttomPanel.add(cancel);
        buttomPanel.add(accept);


        c.add(panel); //add panel to container,
        add(c); //add container to jframe
        pack();
        setLocationRelativeTo(null); //If the component is null, the window is placed in the center of the screen.
        setResizable(false); //make frame unresizeable
        setVisible(true); //do new PageSurvey().setVisible(true) in main instead later, allows for easier control

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel){
            new LoginPage();

        }
        if(e.getSource() == accept){
            //new PageSurvey(Survey survey);

        }

    }
    public JButton createJButtonFromImage(String text,String fileName){
        JButton button=new JButton(text, new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

//        button.setVerticalTextPosition(SwingConstants.CENTER);
//        button.setHorizontalTextPosition(SwingConstants.CENTER);
//
//        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setFont(MainClass.bodyFontNormal);

        button.setFocusPainted(false);
        button.addActionListener(this);

        return button;
    }
    public static JLabel createJLabelFromImage(String fileName){
        JLabel l=new JLabel(new ImageIcon(LOCATION_PRESET+fileName));
        //l.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return l;
    }

}