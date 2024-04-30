import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

import javax.swing.*;

import java.applet.AudioClip;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import javax.imageio.ImageIO;

public class Loading_images_audio_and_other_resources extends JApplet {
    // Loading images, audio and other resources/Memuat gambar, audio, dan sumber
    // daya lainnya

    /*
     * Applet Java dapat memuat sumber daya yang berbeda. Namun karena mereka
     * berjalan di browser web klien, Anda perlu memastikan bahwa sumber daya ini
     * dapat diakses. Applet tidak dapat mengakses sumber daya klien sebagai sistem
     * file lokal.
     * 
     * Jika Anda ingin memuat sumber daya dari URL yang sama dengan Applet yang
     * disimpan, Anda dapat menggunakan metode getCodeBase() untuk mengambil URL
     * dasar. Untuk memuat sumber daya, applet menawarkan metode getImage() dan
     * getAudioClip() untuk memuat file gambar atau audio.
     */

    // Load and show an image/Muat dan tampilkan gambar

    /*
     * public class MyImgApplet extends JApplet{
     * private Image img;
     * 
     * @Override
     * public void init(){
     * try {
     * img = getImage(new
     * URL("http://cdn.sstatic.net/stackexchange/img/logos/so/sologo.png"));
     * } catch (MalformedURLException e) { //omitted for brevity }
     * }
     * 
     * @Override
     * public void paint(Graphics g) {
     * g.drawImage(img, 0, 0, this);
     * }
     * }
     * 
     */

    // Load and play an audio file/Memuat dan memutar file audio

    /*
     * public class MyAudioApplet extends JApplet{
     * private AudioClip audioClip;
     * 
     * @Override
     * public void init(){
     * try {
     * audioClip = getAudioClip(new URL("URL/TO/AN/AUDIO/FILE.WAV"));
     * } catch (MalformedURLException e) { //omitted for brevity }
     * }
     * 
     * @Override
     * public void start() {
     * audioClip.play();
     * }
     * 
     * @Override
     * public void stop(){
     * audioClip.stop();
     * }
     * }
     */

    // Load and display a text file/ Memuat dan menampilkan file teks
    /*
     * public class MyTextApplet extends JApplet{
     * 
     * @Override
     * public void init(){
     * JTextArea textArea = new JTextArea();
     * JScrollPane sp = new JScrollPane(textArea);
     * add(sp);
     * // load text
     * try {
     * URL url = new URL("http://www.textfiles.com/fun/quotes.txt");
     * InputStream in = url.openStream();
     * BufferedReader bf = new BufferedReader(new InputStreamReader(in));
     * String line = "";
     * while((line = bf.readLine()) != null) {
     * textArea.append(line + "\n");
     * }
     * } catch(Exception e) { // omitted for brevity }
     * }
     * }
     */

    // ------------
    // private Image img;

    // @Override
    // public void init() {
    // try {
    // img = ImageIO.read(new URL(
    // "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEHWmLEw9GLCuC3UOAGgplBBO5Ul-6XNbRVQ&usqp=CAU"));
    // } catch (IOException e) {
    // /* omitted for brevity */
    // e.printStackTrace();
    // }
    // }

    // @Override
    // public void paint(Graphics g) {
    // super.paint(g);
    // if (img != null && img.getWidth(this) > 0 && img.getHeight(this) > 0) {
    // g.drawImage(img, 0, 0, this);
    // } else {
    // // Gambar belum tersedia atau tidak valid
    // g.drawString("Gambar tidak tersedia", 10, 10);
    // }
    // }
    // ---------------
    public Clip audioClip;

    @Override
    public void init() {
        try {
            URL url = new URL("https://www2.cs.uic.edu/~i101/SoundFiles/StarWars3.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        if (audioClip != null && !audioClip.isRunning())
            audioClip.start();
    }

    @Override
    public void stop() {
        if (audioClip != null && audioClip.isRunning())
            audioClip.stop();
    }
    // ---------------
    // @Override
    // public void init() {
    // JTextArea textArea = new JTextArea();
    // JScrollPane sp = new JScrollPane(textArea);
    // add(sp);
    // // load text
    // try {
    // URL url = new URL("http://www.textfiles.com/fun/quotes.txt");
    // InputStream in = url.openStream();
    // BufferedReader bf = new BufferedReader(new InputStreamReader(in));
    // String line = "";
    // while ((line = bf.readLine()) != null) {
    // textArea.append(line + "\n");
    // }
    // } catch (Exception e) {
    // /* omitted for brevity */ }
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Applet Example");
            JApplet applet = new Loading_images_audio_and_other_resources();
            frame.getContentPane().add(applet);
            frame.setSize(400, 200);
            applet.init();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

    }

}
