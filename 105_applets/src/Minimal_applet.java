import javax.swing.*;
import java.awt.*;

public class Minimal_applet extends JApplet {
    // Minimal Applet/Applet Minimal

    // Applet yang sangat sederhana menggambar persegi panjang dan mencetak string
    // sesuatu di layar.

    /*
     * public class MyApplet extends JApplet{
     * private String str = "StackOverflow";
     * 
     * @Override
     * public void init() {
     * setBackground(Color.gray);
     * }
     * 
     * @Override
     * public void destroy() {}
     * 
     * @Override
     * public void start() {}
     * 
     * @Override
     * public void stop() {}
     * 
     * @Override
     * public void paint(Graphics g) {
     * g.setColor(Color.yellow);
     * g.fillRect(1,1,300,150);
     * g.setColor(Color.red);
     * g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
     * g.drawString(str, 10, 80);
     * }
     * }
     */

    // Kelas utama applet berasal dari javax.swing.JApplet

    // Version ≤ Java SE 1.2

    // Sebelum Java 1.2 dan pengenalan applet API ayunan telah diperluas dari
    // java.applet.Applet

    /*
     * Applet tidak memerlukan metode utama. Titik masuknya dikendalikan oleh siklus
     * hidup. Untuk menggunakannya, mereka harus disematkan dalam dokumen HTML. Ini
     * juga merupakan titik di mana ukurannya ditentukan.
     * 
     * <html>
     * <head></head>
     * <body>
     * <applet code="MyApplet.class" width="400" height="200"></applet>
     * </body>
     * </html
     */
    // ----------------------
    private String str = "StackOverflow";

    @Override
    public void init() {
        setBackground(Color.gray);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(1, 1, 300, 150);
        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        g.drawString(str, 10, 80);
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ---------------
        JFrame frame = new JFrame("My Applet Example");
        JApplet applet = new Minimal_applet();
        frame.getContentPane().add(applet);
        frame.setSize(400, 200);
        applet.init();
        frame.setVisible(true);
    }
}
