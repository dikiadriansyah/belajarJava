import javax.swing.*;
import java.awt.*;

public class Example2_drawing_and_filling_oval {
    // Example 2: Drawing and Filling Oval/Contoh 2: Menggambar dan Mengisi Oval
    /*
     * import javax.swing.*;
     * import java.awt.*;
     * public class MyPanel extends JPanel {
     * 
     * @Override
     * public void paintComponent(Graphics g){
     * // clear the previous painting
     * super.paintComponent(g);
     * Graphics2D g2 = (Graphics2D)g;
     * g2.setColor(Color.blue);
     * g2.drawOval(0, 0, 20,20);
     * g2.fillOval(50,50,20,20);
     * }
     * }
     * 
     */

    /*
     * g2.drawOval(int x,int y,int height, int width);
     * This method will draw an oval at specified x and y position with given height
     * and width. / Cara ini akan menggambar sebuah oval pada posisi x dan y
     * tertentu dengan tinggi dan lebar tertentu.
     * 
     * g2.fillOval(int x,int y,int height, int width); This method will fill an oval
     * at specified x and y position with given height and width. / Cara ini akan
     * mengisi oval pada posisi x dan y yang ditentukan dengan yang diberikan
     * tinggi dan lebar.
     */

    // -----------------------
    JFrame f;
    MyPanel2 p;

    public Example2_drawing_and_filling_oval() {
        f = new JFrame();
        // get the content area of Panel.
        Container c = f.getContentPane();
        // set the LayoutManager
        c.setLayout(new BorderLayout());
        p = new MyPanel2();
        // add MyPanel object into container
        c.add(p);
        // set the size of the JFrame
        f.setSize(400, 400);
        // make the JFrame visible
        f.setVisible(true);
        // sets close behavior; EXIT_ON_CLOSE invokes System.exit(0) on closing the
        // JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Example2_drawing_and_filling_oval box = new Example2_drawing_and_filling_oval();
    }
}