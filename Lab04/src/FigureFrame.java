import java.awt.*;
import javax.swing.*;

public class FigureFrame{

    public static void main (String[] arg) {


        JFrame frame = new JFrame();

        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Figure");

        JPanel comp = new StickFigure(150,150,200,Color.BLACK);
        frame.add(comp);

        frame.setVisible(true);

    }
    
}
