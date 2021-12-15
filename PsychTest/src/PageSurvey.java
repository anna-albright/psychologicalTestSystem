import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PageSurvey extends JFrame implements ActionListener {
    static String LOCATION_PRESET="./PsychTest/data/photos/";
    ArrayList<JButton> answersArray= new ArrayList<>();
    JPanel panel = new JPanel(); // Set the panel to add buttons
    Survey survey;

    public PageSurvey(Survey survey)
    {
        super("PageSurvey");
        this.survey=survey;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = createJLabelFromImage("background - gui.png");
        c.setLayout(new FlowLayout());

        JLabel testName = new JLabel();
        testName.setText(survey.getSurveyName());
        testName.setFont(new Font("EB Garamond",Font.BOLD,39));
        testName.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // Y_Axis from up to down
        panel.setLayout(boxLayout); // to set the box layout
        panel.setOpaque(false);
        panel.add(Box.createRigidArea(new Dimension(0,75))); //add empty space
        panel.add(testName);

        renderQuestionsAndAnswers(survey);

        c.add(panel); //add panel to container,
        add(c); //add container to jframe
        pack();
        setLocationRelativeTo(null); //If the component is null, the window is placed in the center of the screen.
        setResizable(false); //make frame unresizeable
        setVisible(true); //do new PageSurvey().setVisible(true) in main instead later, allows for easier control

    }
    public void renderQuestionsAndAnswers(Survey survey){
        for (JButton x : answersArray){
            panel.remove(x);
        }
        answersArray.clear();

        for (int i=0; i<survey.getSurveyQuestion(Survey.getCurrentNum()).size(); i++)
        {
            JButton question=createJButtonFromImage(survey.getSurveyQuestion(Survey.getCurrentNum()).get(i),"question.png");
            JButton answer=createJButtonFromImageML(survey.getSurveyQuestion(Survey.getCurrentNum()).get(i),"answer.png");
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
                if (i==0)
                    break;
                //System.out.println("check");
                Survey.getUserAnswers().add(answersArray.get(i).getText().substring(0,1)); //adds only the first letter

                //answersArray.get(i).setIcon(new ImageIcon(LOCATION_PRESET+"answerSelected.png"));

                if (survey.getSurveyQuestion(Survey.getCurrentNum()+1)!=null) //checks if next question exists
                    Survey.setCurrentNum(Survey.getCurrentNum()+1);
                else
                {
                    this.survey.writeSurveyAnswersToFile(Survey.getUserAnswers()); //write to file
                    dispose();
                    //System.exit(0); //temporary, REMOVE LATER
                    //PageResults results = new PageResults(this.survey); //IMPLEMENT THIS - make it go to results page
                }

                renderQuestionsAndAnswers(this.survey);
                break; //idk
            }
        }

    }

    public JButton createJButtonFromImage(String fileName){
        JButton button=new JButton(new ImageIcon(LOCATION_PRESET+fileName));

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return button;
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

/*                if (button.getIcon().equals(new ImageIcon(LOCATION_PRESET + "answerSelected.png")))
                {
                    button.setForeground(Color.BLACK);
                    button.setFont(new Font("Inter Light", Font.PLAIN, 16));
                    button.setIcon(new ImageIcon(LOCATION_PRESET+"answer.png"));
                }*/
                button.setForeground(Color.BLACK);
                button.setFont(MainClass.bodyFontNormal);

            }
            public void mousePressed(MouseEvent e) {
                //button.setIcon(new ImageIcon(LOCATION_PRESET+"answerSelected.png"));
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
    /*    public static JLabel createJLabelFromImage(String fileName, String text){
            JLabel l=new JLabel(new ImageIcon(LOCATION_PRESET+fileName));
            l.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            return l;
        }*/

}
