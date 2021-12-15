import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PageSurvey extends JFrame implements ActionListener {
    JFrame frame = new JFrame(); // creating a new frame
    static String LOCATION_PRESET="./PsychTest/data/photos/";
    ArrayList<JButton> answersArray= new ArrayList<>();
    JPanel panel = new JPanel(); // Set the panel to add buttons
    Survey survey;

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
    public static JButton createJButtonFromImage(String fileName){
        JButton button=new JButton(new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return button;
    }
    public static JButton createJButtonFromImage(String text,String fileName){
        JButton button=new JButton(text, new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        //button.setVerticalTextPosition(SwingConstants.TOP);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        //button.setHorizontalAlignment(SwingConstants.LEFT); //make text justify to left?
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.setFont(new Font("Helvetica", Font.PLAIN, 16));
        return button;
    }

    public static JLabel createJLabelFromImage(String fileName){
        JLabel l=new JLabel(new ImageIcon(LOCATION_PRESET+fileName));
        l.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return l;
    }
/*    public static JLabel createJLabelFromImage(String fileName, String text){
        JLabel l=new JLabel(new ImageIcon(LOCATION_PRESET+fileName));
        l.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return l;
    }*/
    public PageSurvey(Survey survey)
    {
        super("PageSurvey test");
        this.survey=survey;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);

        Container c = createJLabelFromImage("background - gui.png");
        c.setLayout(new FlowLayout());

        //JPanel panel = new JPanel(); // Set the panel to add buttons
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // Y_Axis from up to down

        panel.setLayout(boxlayout); // to set the box layout
        //panel.setBorder(new EmptyBorder(new Insets(100, 150, 100, 150))); // Set border for the panel
        panel.setOpaque(false);

        panel.add(Box.createRigidArea(new Dimension(0,75))); //add empty space
        JLabel testName = new JLabel();
        testName.setText(survey.getSurveyName());
        testName.setFont(new Font("EB Garamond",Font.PLAIN,25));
        testName.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(testName);

        createQuestionsAndAnswers(survey);

        c.add(panel); //add panel to container,
        add(c); //add container to jframe
        pack();
        setResizable(false); //make frame unresizeable
        setVisible(true); //do new PageSurvey().setVisible(true) in main instead later, allows for easier control

    }
    public void createQuestionsAndAnswers(Survey survey){
        for (JButton x : answersArray){
            panel.remove(x);
        }
        answersArray.clear();

        for (int i=0; i<survey.getSurveyQuestion(Survey.getCurrentNum()).size(); i++)
        {
            JButton question=createJButtonFromImage(survey.getSurveyQuestion(Survey.getCurrentNum()).get(i),"question.png");
            JButton answer=createJButtonFromImage(survey.getSurveyQuestion(Survey.getCurrentNum()).get(i),"answer.png");
            question.addActionListener(this);
            answer.addActionListener(this);
            if (i==0)
                answersArray.add(question);
            else
                answersArray.add(answer);
        }

        for (JButton x : answersArray){
            panel.add(x);
        }
        panel.revalidate();
        panel.repaint();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i =0; i < answersArray.size();i++)
        {
            if(e.getSource()==answersArray.get(i))
            {
                //System.out.println("check");
                Survey.getUserAnswers().add(answersArray.get(i).getText().substring(0,1)); //adds only the first letter

                //answersArray.get(i).setIcon(new ImageIcon(LOCATION_PRESET+"answerSelected.png"));

                if (survey.getSurveyQuestion(Survey.getCurrentNum()+1)!=null)
                    Survey.setCurrentNum(Survey.getCurrentNum()+1);
                else
                {
                    this.survey.writeSurveyAnswersToFile(Survey.getUserAnswers());
                    dispose();
                    System.exit(0); //temporary, REMOVE LATER
                    //PageResults results = new PageResults(); //IMPLEMENT THIS - make it go to results page
                }

                createQuestionsAndAnswers(this.survey);
                //break;
            }
        }

    }
}
