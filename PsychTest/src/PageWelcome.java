import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PageWelcome extends JFrame implements ActionListener {
    static String LOCATION_PRESET="./PsychTest/data/photos/";
    ArrayList<JButton> csArray= new ArrayList<>();
    JPanel panel = new JPanel(); // Set the panel to add buttons
    String[] categoryNames=new String[]{"PERSONALITY", "ACHIEVEMENT", "ATTITUDE", "EMOTIONAL INTELLIGENCE",
    "INTELLIGENCE", "NEUROPSYCHOLOGY","PROJECTIVE","APTITUDE"};
    String[] categoryDescriptions= new String[] {
            "measure behaviors, emotions, attitude, and behavioral and environmental characteristics",
            "measure respondents’ intellectual interests, achievements, and cognitive abilities",
            "measure views of respondents based on how much they agree or disagree with a statement",
            "measure emotional responses such as anger, sadness, happiness, and impulsivity",
            "measure mental/developmental learning disabilities",
            "measure cognitive abilities like memory, language, and executive functioning",
            "measure feedback from external influences to identify unrealized emotions/conflicts",
            "measure capabilities, skill sets, and projection of future success",
    };





    public PageWelcome(){
        super("PageWelcome");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = createJLabelFromImage("background - gui.png");
        c.setLayout(new FlowLayout());

        JLabel testsName = new JLabel();
        testsName.setText("Tests");
        testsName.setFont(new Font(MainClass.headerFontName,Font.BOLD,39));
        testsName.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // Y_Axis from up to down
        panel.setLayout(boxLayout); // to set the box layout
        panel.setOpaque(false);
        panel.add(Box.createRigidArea(new Dimension(0,75))); //add empty space
        panel.add(testsName);
        //panel.add(createJLabelFromImage("results.png"));

        csArray.add(createJButtonFromImageML(categoryNames[0],"category1.png"));
        csArray.add(createJButtonFromImageML(categoryNames[1],"category2.png"));
        csArray.add(createJButtonFromImageML(categoryNames[2],"category3.png"));
        csArray.add(createJButtonFromImageML(categoryNames[3],"category4.png"));
        csArray.add(createJButtonFromImageML(categoryNames[4],"category5.png"));
        csArray.add(createJButtonFromImageML(categoryNames[5],"category6.png"));
        csArray.add(createJButtonFromImageML(categoryNames[6],"category7.png"));
        csArray.add(createJButtonFromImageML(categoryNames[7],"category8.png"));

        for (JButton j : csArray) { //control spacing of the box layout
            j.setMaximumSize(new Dimension(775,65));
        }

        for (int i = 0; i<8; i++){ //only render 8 at a time
            panel.add(csArray.get(i));
        }


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
                //button.setForeground(MainClass.customBlue);
                button.setFont(MainClass.bodyFontNormal);
                for (int i =0; i<categoryNames.length; i++)
                {
                    if (button.getText().equals(categoryNames[i]))
                        button.setText(categoryDescriptions[i]);
                }

            }
            public void mouseExited(MouseEvent e){
                button.setForeground(Color.BLACK);
                button.setFont(MainClass.bodyFontNormal);
                for (int i =0; i<categoryDescriptions.length; i++)
                {
                    if (button.getText().equals(categoryDescriptions[i]))
                        button.setText(categoryNames[i]);
                }

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