import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class Using_preferences {
    // Using preferences /Menggunakan preferensi

    /*
     * Preferences dapat digunakan untuk menyimpan pengaturan pengguna yang
     * mencerminkan pengaturan aplikasi pribadi pengguna, misalnya. font editor
     * mereka, apakah mereka lebih suka aplikasi dimulai dalam mode layar penuh,
     * apakah mereka mencentang kotak "jangan tampilkan ini lagi" dan hal-hal
     * seperti itu.
     */

    /*
     * public class ExitConfirmer {
     * private static boolean confirmExit() {
     * Preferences preferences =
     * Preferences.userNodeForPackage(ExitConfirmer.class);
     * boolean doShowDialog = preferences.getBoolean("showExitConfirmation", true);
     * // true is
     * default value
     * if (!doShowDialog) {
     * return true;
     * }
     * //
     * // Show a dialog here...
     * //
     * boolean exitWasConfirmed = ...; // whether the user clicked OK or Cancel
     * boolean doNotShowAgain = ...; // get value from "Do not show again" checkbox
     * if (exitWasConfirmed && doNotShowAgain) {
     * // Exit was confirmed and the user chose that the dialog should not be shown
     * again
     * // Save these settings to the Preferences object so the dialog will not show
     * again next
     * time
     * preferences.putBoolean("showExitConfirmation", false);
     * }
     * return exitWasConfirmed;
     * }
     * public static void exit() {
     * if (confirmExit()) {
     * System.exit(0);
     * }
     * }
     * }
     * 
     */

    private static boolean confirmExit() {
        Preferences preferences = Preferences.userNodeForPackage(Using_preferences.class);
        boolean doShowDialog = preferences.getBoolean("showExitConfirmation", true);

        if (!doShowDialog) {
            return true;
        }

        int result = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.OK_CANCEL_OPTION);

        boolean exitWasConfirmed = (result == JOptionPane.OK_OPTION);
        boolean doNotShowAgain = false;

        if (exitWasConfirmed) {
            JCheckBox checkBox = new JCheckBox("Do not show again");
            Object[] options = { "OK", "Cancel" };
            Object[] message = { "Exit was confirmed. Do you want to save this preference?", checkBox };

            int optionResult = JOptionPane.showOptionDialog(null, message, "Exit Confirmation",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (optionResult == JOptionPane.OK_OPTION) {
                doNotShowAgain = checkBox.isSelected();
            }

            // Save preference
            preferences.putBoolean("showExitConfirmation", !doNotShowAgain);
        }

        return exitWasConfirmed;
    }

    public static void exit() {
        if (confirmExit()) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Example usage
        JFrame frame = new JFrame("Exit Confirmer Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                exit();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(exitButton);
        frame.setVisible(true);

    }
}
