import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PageResults extends JFrame implements ActionListener {
    static String LOCATION_PRESET="./PsychTest/data/photos/";
    ArrayList<JButton> answersArray= new ArrayList<>();
    JPanel panel = new JPanel(); // Set the panel to add buttons
    Survey survey;
    JButton accept = createJButtonFromImage("","check.png");
    JButton cancel = createJButtonFromImage("","ex.png");

    public PageResults(Survey survey){
        super("Results");
        this.survey=survey;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // for scrolling
        JPanel middlePanel = new JPanel ();
        JPanel buttomPanel = new JPanel();
        buttomPanel.setLayout(new GridLayout());
        middlePanel.setBorder(new TitledBorder( new EtchedBorder(),  "" ) );

        JTextArea display = new JTextArea ( 25, 58 );
        display.setEditable ( false );

        //ArrayList<String> text = Read.fileToArrayList("consentForm.txt");
        ArrayList<String> text=Survey.getUserAnswers();

        String listString = "";
        for (String s : text)
        {
            listString += s + "\n";
        }

        display.setText(listString);
        display.setFont(MainClass.bodyFontNormal);
        JScrollPane scroll = new JScrollPane ( display );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );


        middlePanel.add ( scroll );

        Container c = createJLabelFromImage("background - gui.png");
        c.setLayout(new FlowLayout());

        JLabel consent = new JLabel();
        consent.setText("Results");
        consent.setFont(new Font(MainClass.headerFontName,Font.BOLD,39));
        consent.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxLayout);
        panel.setOpaque(false);
        panel.add(Box.createRigidArea(new Dimension(0,70)));
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
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel || e.getSource() == accept) {
            new PageWelcome();

        }
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