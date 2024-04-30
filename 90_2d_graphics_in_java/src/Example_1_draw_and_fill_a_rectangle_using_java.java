import javax.swing.*;
import java.awt.*;

public class Example_1_draw_and_fill_a_rectangle_using_java {
    // Example 1: Draw and Fill a Rectangle Using Java/ Contoh 1: Menggambar dan
    // Mengisi Persegi Panjang Menggunakan Java

    /*
     * Ini adalah Contoh yang mencetak persegi panjang dan mengisi warna pada
     * persegi panjang. https://i.stack.imgur.com/dlC5v.jpg
     */

    /*
     * Sebagian besar metode kelas Grafik dapat dibagi menjadi dua kelompok dasar:
     * 1. Metode menggambar dan mengisi, memungkinkan Anda merender shapes, text,
     * dan images dasar
     * 2. Metode pengaturan atribut, yang mempengaruhi tampilan gambar dan isian
     * tersebut
     * Contoh Kode: Mari kita mulai dengan sedikit contoh menggambar persegi panjang
     * dan mengisi warna di dalamnya. Di sana kami menyatakan
     * dua kelas, satu kelas adalah MyPanel dan Kelas lainnya adalah Test. Di kelas
     * MyPanel kami menggunakan matematika drawRect() & fillRect()
     * untuk menggambar persegi panjang dan mengisi Warna di dalamnya. Kami mengatur
     * warna dengan metode setColor(Color.blue). Di Kelas Dua kami Menguji
     * grafis yang merupakan Kelas Tes kita membuat Bingkai dan meletakkan MyPanel
     * dengan objek p=new MyPanel() di dalamnya. Dengan menjalankan Test
     * Di kelas kita melihat Persegi Panjang dan Persegi Panjang Berisi Warna Biru.
     */

    // First Class: MyPanel

    /*
     * import javax.swing.*;
     * import java.awt.*;
     * // MyPanel extends JPanel, which will eventually be placed in a JFrame
     * public class MyPanel extends JPanel {
     * // custom painting is performed by the paintComponent method
     * 
     * @Override
     * public void paintComponent(Graphics g){
     * // clear the previous painting
     * super.paintComponent(g);
     * // cast Graphics to Graphics2D
     * Graphics2D g2 = (Graphics2D) g;
     * g2.setColor(Color.red); // sets Graphics2D color
     * // draw the rectangle
     * g2.drawRect(0,0,100,100); // drawRect(x-position, y-position, width, height)
     * g2.setColor(Color.blue);
     * g2.fillRect(200,0,100,100); // fill new rectangle with color blue
     * }
     * }
     * 
     */

    // Second Class: Test
    /*
     * import javax.swing.;
     * import java.awt.;
     * public class Test { //the Class by which we display our rectangle
     * JFrame f;
     * MyPanel p;
     * public Test(){
     * f = new JFrame();
     * // get the content area of Panel.
     * Container c = f.getContentPane();
     * // set the LayoutManager
     * c.setLayout(new BorderLayout());
     * p = new MyPanel();
     * // add MyPanel object into container
     * c.add(p);
     * // set the size of the JFrame
     * f.setSize(400,400);
     * // make the JFrame visible
     * f.setVisible(true);
     * // sets close behavior; EXIT_ON_CLOSE invokes System.exit(0) on closing the
     * JFrame
     * f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * }
     * 
     * public static void main(String args[ ]){
     * Test t = new Test();
     * }
     * }
     */

    // Untuk Penjelasan Lebih Lanjut tentang Tata Letak Perbatasan:
    // https://docs.Oracle.com/javase/tutorial/uiswing/layout/border.html

    /*
     * paintComponent( )
     * 1. Ini adalah metode utama melukis
     * 2. Secara default, ini akan mengecat latar belakang terlebih dahulu
     * 3. Setelah itu melakukan pengecatan custom (menggambar lingkaran, persegi
     * panjang dll)
     */

    // Graphic2D refers Graphic2D Class

    // Catatan: Java 2D API memungkinkan Anda melakukan tugas-tugas berikut dengan
    // mudah:
    /*
     * 1. Gambarlah garis, persegi panjang, dan bentuk geometris lainnya.
     * 2. Isi bentuk tersebut dengan warna solid atau gradien dan tekstur.
     * 3. Gambar teks dengan opsi untuk kontrol yang baik atas font dan proses
     * rendering.
     * 4. Menggambar gambar, secara opsional menerapkan operasi pemfilteran.
     * 5. Terapkan operasi seperti pengomposisian dan transformasi selama salah satu
     * operasi rendering di atas.
     */

    // -------------
    JFrame f;
    MyPanel p;

    public Example_1_draw_and_fill_a_rectangle_using_java() {
        f = new JFrame();
        // get the content area of Panel.
        Container c = f.getContentPane();
        // set the LayoutManager
        c.setLayout(new BorderLayout());
        p = new MyPanel();
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
        // System.out.println("Hello, World!");

        // -----------
        Example_1_draw_and_fill_a_rectangle_using_java t = new Example_1_draw_and_fill_a_rectangle_using_java();
    }
}
