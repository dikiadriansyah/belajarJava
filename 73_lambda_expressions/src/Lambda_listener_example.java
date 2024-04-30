import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

public class Lambda_listener_example {
    // Lambda - Listener Example/Lambda - Contoh Pendengar

    // Anonymous class listener/Pendengar kelas anonim

    /*
     * Sebelum Java 8, sangat umum bahwa kelas anonim digunakan untuk menangani
     * peristiwa klik pada JButton, seperti yang ditunjukkan pada kode berikut.
     * Contoh ini menunjukkan cara mengimplementasikan pendengar anonim dalam
     * lingkup btn.addActionListener.
     */
    /*
     * JButton btn = new JButton("My Button");
     * btn.addActionListener(new ActionListener() {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * System.out.println("Button was pressed");
     * }
     * });
     */

    // Lambda listener
    /*
     * Karena antarmuka ActionListener hanya mendefinisikan satu metode
     * actionPerformed(), ini adalah antarmuka fungsional yang berarti ada tempat
     * untuk menggunakan ekspresi Lambda untuk menggantikan kode boilerplate. Contoh
     * di atas dapat ditulis ulang menggunakan ekspresi Lambda sebagai berikut:
     * JButton btn = new JButton("My Button");
     * btn.addActionListener(e -> {
     * System.out.println("Button was pressed");
     * });
     */

    public static void main(String[] args) {
        // JButton btn = new JButton("My Button");

        // btn.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // System.out.println("Button was pressed");
        // }
        // });

        // -------------------------
        JButton btn = new JButton("My Button");
        btn.addActionListener(e -> {
            System.out.println("Button was pressed");
        });

        // Anda bisa menambahkan JButton ke JFrame atau container lainnya sesuai
        // kebutuhan
        // Misalnya: JFrame frame = new JFrame();
        JFrame frame = new JFrame();
        frame.getContentPane().add(btn);

        // Untuk menjalankan program, Anda perlu menampilkan frame atau container yang
        // telah diinisialisasi
        // Misalnya: frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        /*
         * output:
         * Button was pressed
         * Button was pressed
         */

    }
}
