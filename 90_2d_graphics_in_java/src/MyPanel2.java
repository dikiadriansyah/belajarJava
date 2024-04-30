import javax.swing.*;
import java.awt.*;

public class MyPanel2 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        // clear the previous painting
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.drawOval(0, 0, 20, 20);
        g2.fillOval(50, 50, 20, 20);
    }
}
