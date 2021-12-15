import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageConsent extends JFrame implements ActionListener {
    JFrame frame = new JFrame(); // creating a new frame
    JPanel panel = new JPanel(); // Set the panel to add buttons
    JLabel consentText;


    public PageConsent (){
        super("Informed Consent");
        //JButton yesSelect = PageSurvey.createJButtonFromImage("PsychTest/data/photos/yesSelected.png");
        Container c = PageSurvey.createJLabelFromImage("background - gui.png");
        c.setLayout(new FlowLayout());

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); // Y_Axis from up to down
        panel.setLayout(boxLayout); // to set the box layout
        panel.setOpaque(false);
        panel.add(Box.createRigidArea(new Dimension(0,75))); //add empty space

        //consentText.setFont(new Font("EB Garamond",Font.PLAIN,18)); // setting text style

        c.add(panel); // add panel to the container
        add(c); // add container to the frame
        pack();
        setResizable(false); //make frame unresizeable
        frame.setLocationRelativeTo(null);
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
