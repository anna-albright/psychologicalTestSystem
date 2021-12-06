import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("PsychTest/src/Photos/CS210 GUI Mockup test page.jpg");
    JLabel testPageImage = new JLabel(icon);
    JButton personalityButton = new JButton("Personality");
    JButton achievementButton = new JButton("Achievement");
    JButton attitudeButton = new JButton("Attitude");

    JLabel welcomeLabel = new JLabel("Hello!");

    WelcomePage(String userID){

        welcomeLabel.setBounds(0,-8,200,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        welcomeLabel.setText("Hello " + userID);
        welcomeLabel.setForeground(Color.lightGray);

        //Personality button
        personalityButton.setBounds(103,102,523,38);
        personalityButton.setFocusPainted(false); // remove preselected view
        personalityButton.addActionListener(this);

        /** Mouse Events on hover (personality) */
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
        achievementButton.addActionListener(this);

        /** Mouse Events on hover (achievement) */
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
        attitudeButton.addActionListener(this);

        /** Mouse Events on hover (attitude) */
        attitudeButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                attitudeButton.setForeground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                attitudeButton.setForeground(UIManager.getColor(new Color(100,200,255)));
            }
        });




        testPageImage.setSize(700,520);


        frame.add(welcomeLabel);
        frame.add(personalityButton);
        frame.add(achievementButton);
        frame.add(attitudeButton);
        frame.add(testPageImage);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,520);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** Contols the actions when buttons are clicked
     * Param e - The action event variable
     */
    public void actionPerformed(ActionEvent e) {

    }
}
