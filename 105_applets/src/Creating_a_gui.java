import javax.swing.*;
import java.awt.event.*;

public class Creating_a_gui extends JApplet {
    // Creating a GUI/Membuat GUI

    /*
     * Applet dapat dengan mudah digunakan untuk membuat GUI. Mereka bertindak
     * seperti Container dan memiliki metode add() yang dapat digunakan apa pun
     * komponen awt atau swing.
     * 
     * public class MyGUIApplet extends JApplet{
     * private JPanel panel;
     * private JButton button;
     * private JComboBox<String> cmbBox;
     * private JTextField textField;
     * 
     * @Override
     * public void init(){
     * panel = new JPanel();
     * button = new JButton("ClickMe!");
     * button.addActionListener(new ActionListener(){
     * 
     * @Override
     * public void actionPerformed(ActionEvent ae) {
     * if(((String)cmbBox.getSelectedItem()).equals("greet")) {
     * JOptionPane.showMessageDialog(null,"Hello " + textField.getText());
     * } else {
     * JOptionPane.showMessageDialog(null,textField.getText() + " stinks!");
     * }
     * }
     * });
     * cmbBox = new JComboBox<>(new String[]{"greet", "offend"});
     * textField = new JTextField("John Doe");
     * panel.add(cmbBox);
     * panel.add(textField);
     * panel.add(button);
     * add(panel);
     * }
     * }
     */

    private JPanel panel;
    private JButton button;
    private JComboBox<String> cmbBox;
    private JTextField textField;

    @Override
    public void init() {
        panel = new JPanel();
        button = new JButton("ClickMe!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (((String) cmbBox.getSelectedItem()).equals("greet")) {
                    JOptionPane.showMessageDialog(null, "Hello " + textField.getText());
                } else {
                    JOptionPane.showMessageDialog(null, textField.getText() + " stinks!");
                }
            }
        });
        cmbBox = new JComboBox<>(new String[] { "greet", "offend" });
        textField = new JTextField("John Doe");
        panel.add(cmbBox);
        panel.add(textField);
        panel.add(button);
        add(panel);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("My GUI Applet");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JApplet applet = new Creating_a_gui();
                applet.init();
                frame.getContentPane().add(applet);
                frame.pack();
                frame.setVisible(true);
                applet.start();
            }
        });
    }
}
