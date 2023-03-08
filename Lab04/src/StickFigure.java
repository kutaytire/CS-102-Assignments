
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

public class StickFigure extends JPanel{

    private int x;
    private int y;
    private int height;
    private Color color;
    ActionListener listen;
    Timer t, t2;
    ActionListener leftShift, rightShift, colorPicker,noseListen, eyesListen, mouthListen, handsListen;
    ChangeListener slide;
    JSlider slider;
    Graphics gd;
    JCheckBox nose,eyes,mouth,hands;
    JPanel elements;

    public StickFigure(int xCoordinate, int yCoordinate, int height, Color color) {

        x = xCoordinate;
        y = yCoordinate;
        this.height = height;
        this.color = color;

        elements = new JPanel();
        this.setLayout(null);
     
        leftShift = new LeftListener();
        t = new Timer(500, leftShift);

        rightShift = new RightListener();
        t2 = new Timer(500, rightShift);

        slide = new sliderListener();
        colorPicker = new ColorListener();

        noseListen = new partListener();
        handsListen = new partListener();
        mouthListen = new partListener();
        eyesListen = new partListener();
        
        createButtons();
        createSlider();
        colorChooser();
        createCheckBox();

        add(elements);
        elements.setBounds(60,500, 800, 150);
        
      
    }

    public void setX(int value) {

        x = value;
    }

    public void setY(int value) {

        y = value;
    }
    public void paintComponent( Graphics g) {

        gd = g;

       super.paintComponent(gd);

        gd.setColor(color);
        gd.drawLine(x, y, x, y + height);
        int headLength = height / 4;

        int tmp = x;
        int tmpY = y + height;

        int xArm = x -  2 * headLength;
        int xArmEnd = x + 2 *  headLength;

        int leftLeg = x - headLength;
        int rightLeg = x + headLength;

        int endLeg = tmpY + headLength;

        int headStart = (x - headLength);
        int headY = (y -  2 * headLength);
        gd.drawOval(headStart, headY, 2 * headLength, 2 * headLength);

        int leftEyeX  = headStart + headLength/4;
        int leftEyeY = headY +  headLength - headLength /5;

        int rightEyeX = headStart +  2 * headLength - headLength/4 - headLength / 3;

        if(hands.isSelected()) {
            gd.drawLine(xArm , headY +  3 * headLength, xArmEnd, headY +  3 * headLength);
        }
        gd.drawLine(tmp,tmpY, leftLeg, endLeg);
        gd.drawLine(tmp,tmpY, rightLeg, endLeg);

        if(eyes.isSelected()) {
            gd.drawOval( leftEyeX, leftEyeY, headLength/3, headLength/3 );
            gd.drawOval( rightEyeX, leftEyeY, headLength/3, headLength/3 );
        }

        int noseBeginX = leftEyeX +  headLength/3;
        int noseBeginY = leftEyeY + headLength / 3;

        if (nose.isSelected()) {
            gd.drawLine(noseBeginX + headLength / 4, noseBeginY,  rightEyeX - headLength / 4,  noseBeginY);
            gd.drawLine(noseBeginX + headLength / 4, noseBeginY,  (noseBeginX + rightEyeX)/2 , noseBeginY + headLength / 3);
            gd.drawLine( (noseBeginX + rightEyeX)/2, noseBeginY + headLength / 3,   rightEyeX - headLength / 4,  noseBeginY);
        }

        if(mouth.isSelected()) {
            g.drawLine(leftEyeX + headLength/3, noseBeginY + headLength/2, rightEyeX, noseBeginY + headLength/2);
        }


    }

    public void moveRight() {

        setX(x + 10);

        if (x > 1000) {

            x = 0;
        }
        repaint();
    }

    public void moveLeft() {

        setX(x - 10);

        if (x < 0) {

            x = 1000;
        }
        repaint();
    }


    
    public void createButtons() {

        JPanel movePanel = new JPanel();
        movePanel.setLayout(new GridLayout(1,3));
        JButton button = new JButton("Slide Right");
        button.addActionListener(rightShift);
        button.setBackground(Color.BLUE);
            
        movePanel.add(button);


        JButton button2 = new JButton("Stop");
        button2.setBackground(Color.RED);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t.stop();
                t2.stop();
            }
        });

        movePanel.add(button2);
  

        JButton button3 = new JButton("SlideLeft");
        button3.setBackground(Color.BLUE);
        button3.addActionListener(leftShift);

        movePanel.add(button3);
        elements.add(movePanel);
    }

    class LeftListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            moveLeft();
            t.start();
            t2.stop();
        }
    }

    class RightListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            moveRight();
            t2.start();
            t.stop();
        }
    }

    public void createSlider() {

        JPanel panelSlider = new JPanel();
        JLabel label = new JLabel("Height");

        panelSlider.setLayout(new BorderLayout());
        panelSlider.add(label, BorderLayout.CENTER);

        slider = new JSlider(JSlider.HORIZONTAL, 50, 300, 200);
        slider.addChangeListener(slide);
        panelSlider.add(slider, BorderLayout.NORTH);
        elements.add(panelSlider);




    }

    class sliderListener implements ChangeListener{
        public void stateChanged(ChangeEvent e)
        {

            height = slider.getValue();
            repaint();
        
        }
    }

    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            color =  JColorChooser.showDialog(new JFrame(),"Select a color",color); 
            repaint();

        }
    }
    
    public void colorChooser() {

        
        JButton button = new JButton("Pick Color");
        button.addActionListener(colorPicker);

        elements.add(button);
    }

    public void createCheckBox() {

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(4,1));
        nose = new JCheckBox("Nose");
        eyes = new JCheckBox("Eyes");
        mouth = new JCheckBox("Mouth");
        hands = new JCheckBox("Hands");

        nose.addActionListener(noseListen);
        eyes.addActionListener(eyesListen);
        mouth.addActionListener(mouthListen);
        hands.addActionListener(handsListen);
        panelButton.add(nose);
        panelButton.add(eyes);
        panelButton.add(mouth);
        panelButton.add(hands);

        panelButton.setBorder(new TitledBorder(new EtchedBorder(), "Visibility"));
       
        elements.add(panelButton);

    }

    class partListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            repaint();

        }
    }

    


}