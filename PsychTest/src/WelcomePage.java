import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("PsychTest/src/Photos/CS210 GUI Mockup test page.jpg");
    JLabel testPageImage = new JLabel(icon);
    // all buttons declaration.
    JButton personalityButton = new JButton("Personality");
    JButton achievementButton = new JButton("Achievement");
    JButton attitudeButton = new JButton("Attitude");
    JButton emotionalIntelligenceButton = new JButton("Emotional Intelligence");
    JButton intelligenceButton = new JButton("Intelligence");
    JButton neuropsychologyButton = new JButton("Neuropsychology");
    JButton projectiveButton = new JButton("Projective");
    JButton aptitudeButton = new JButton("Aptitude");

    JLabel welcomeLabel = new JLabel("Hello!");

    WelcomePage(String userID){

        welcomeLabel.setBounds(0,-8,200,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        welcomeLabel.setText("Hello " + userID);
        welcomeLabel.setForeground(Color.lightGray);

        //Personality button

        /*
        personalityButton.setBounds(103,102,523,38);
        personalityButton.setFont(new Font("Helvetica",Font.PLAIN,16));
        personalityButton.setFocusPainted(false);
        personalityButton.addActionListener(this);

        personalityButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                personalityButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                personalityButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });
        personalityButton.setToolTipText("measure behaviors, emotions, attitudes, behavioral and environmental characteristics");

        // Achievement Button
        achievementButton.setBounds(103,149,523,38);
        achievementButton.setFont(new Font("Helvetica",Font.PLAIN,16));
        achievementButton.addActionListener(this);

        achievementButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                achievementButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                achievementButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });

        //attitude Button
        attitudeButton.setBounds(103,196,523,38);
        attitudeButton.setFont(new Font("Helvetica",Font.PLAIN,16));
        attitudeButton.addActionListener(this);

        attitudeButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                attitudeButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                attitudeButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });

        //EMOTIONAL INTELLIGENCE button
        emotionalIntelligenceButton.setBounds(103,243,523,38);
        emotionalIntelligenceButton.setFont(new Font("Helvetica",Font.PLAIN,16));
        emotionalIntelligenceButton.addActionListener(this);

        emotionalIntelligenceButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                emotionalIntelligenceButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                emotionalIntelligenceButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });

        //intelligence button
        intelligenceButton.setBounds(103,290,523,38);
        intelligenceButton.setFont(new Font("Helvetica",Font.PLAIN,16));
        intelligenceButton.addActionListener(this);

        intelligenceButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){ intelligenceButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                intelligenceButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });

        //neuropsychology button
        neuropsychologyButton.setBounds(103,337,523,38);
        neuropsychologyButton.setFont(new Font("Helvetica",Font.PLAIN,16));
        neuropsychologyButton.addActionListener(this);

        neuropsychologyButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){ neuropsychologyButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                neuropsychologyButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });

        //Projective button
        projectiveButton.setBounds(103,384,523,38);
        projectiveButton.setFont(new Font("Helvetica",Font.PLAIN,16));
        projectiveButton.addActionListener(this);

        projectiveButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){ projectiveButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                projectiveButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });

        //Aptitude button
        aptitudeButton.setBounds(103,431,523,38);
        aptitudeButton.setFont(new Font("Helvetica",Font.PLAIN,16));
        aptitudeButton.addActionListener(this);

        aptitudeButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){ aptitudeButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                aptitudeButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });
         */

        // New button implementation
        buttonCrafter(personalityButton); // no bounds needs shifting for the first button
        buttonCrafter(achievementButton);
        achievementButton.setBounds(103,149,523,38); // shifting the button down to the correct location.
        buttonCrafter(attitudeButton);
        attitudeButton.setBounds(103,196,523,38); // shifting the button down to the correct location.
        buttonCrafter(emotionalIntelligenceButton);
        emotionalIntelligenceButton.setBounds(103,243,523,38);
        buttonCrafter(intelligenceButton);
        intelligenceButton.setBounds(103,290,523,38);
        buttonCrafter(neuropsychologyButton);
        neuropsychologyButton.setBounds(103,337,523,38);
        buttonCrafter(projectiveButton);
        projectiveButton.setBounds(103,384,523,38);
        buttonCrafter(aptitudeButton);
        aptitudeButton.setBounds(103,431,523,38);

        testPageImage.setSize(700,520);

        frame.add(welcomeLabel);
        frame.add(personalityButton);
        frame.add(achievementButton);
        frame.add(attitudeButton);
        frame.add(emotionalIntelligenceButton);
        frame.add(intelligenceButton);
        frame.add(neuropsychologyButton);
        frame.add(projectiveButton);
        frame.add(aptitudeButton);
        frame.add(testPageImage);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,520);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    /** To minimize code and craft new buttons
     *
     * @param button the button that will be edited with new values
     */
    public void buttonCrafter(JButton button){
        button.setBounds(103,102,523,38);
        button.setFont(new Font("Helvetica",Font.PLAIN,16));
        button.setFocusPainted(false);
        button.addActionListener(this);

        button.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                button.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                button.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == personalityButton){
            new SelectSurveyPage(personalityButton.getText());
        }
        if(e.getSource() == achievementButton){

        }
        if(e.getSource() == attitudeButton){

        }
        if(e.getSource() == emotionalIntelligenceButton){

        }
        if(e.getSource() == intelligenceButton){

        }
        if(e.getSource() == neuropsychologyButton){
            Survey newSurveyInstance = new Survey("PERSONALITY", "16 Personality Factors");
            newSurveyInstance.takeSurvey();
        }
        if(e.getSource() == projectiveButton){
            Survey newSurveyInstance = new Survey("PERSONALITY", "16 Personality Factors");
            newSurveyInstance.takeSurvey();
        }
        if(e.getSource() == aptitudeButton){
            Survey newSurveyInstance = new Survey("PERSONALITY", "16 Personality Factors");
            newSurveyInstance.takeSurvey();
        }

    }
}
