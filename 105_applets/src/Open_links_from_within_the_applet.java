import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class Open_links_from_within_the_applet extends JApplet {
    // Open links from within the applet/Buka tautan dari dalam applet

    /*
     * Anda dapat menggunakan metode getAppletContext() untuk mendapatkan objek
     * AppletContext yang memungkinkan Anda meminta
     * browser untuk membuka tautan. Untuk ini, Anda menggunakan metode
     * showDocument(). Parameter kedua memberitahu browser untuk menggunakan
     * new window _blank atau jendela yang menampilkan applet _self.
     */

    @Override
    public void init() {
        JButton button = new JButton("ClickMe!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    URL url = new URL("http://stackoverflow.com/");
                    getAppletContext().showDocument(url, "_blank");
                } catch (Exception e) {
                    /* Exception handling code omitted for brevity */
                    e.printStackTrace();
                }
            }
        });
        add(button);
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("My Applet Example");
        JApplet applet = new Open_links_from_within_the_applet();
        frame.getContentPane().add(applet);
        frame.setSize(400, 200);
        applet.init();
        frame.setVisible(true);
    }
}
