
import java.nio.channels.ClosedByInterruptException;

import javax.swing.*;

public class Unilate{

    private JFrame window;

    private int height;
    private int width;

    public Unilate(){
        height = 600;
        width = 600;

        this.window = new JFrame("Unilate");
        this.window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void addToWindow(JPanel panel){
        this.window.add(panel);
    }
}