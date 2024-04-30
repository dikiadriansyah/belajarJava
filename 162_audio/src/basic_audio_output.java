import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class basic_audio_output {
    // Basic audio output/Keluaran audio dasar

    /*
     * Halo Audio! Java yang memutar file suara dari penyimpanan lokal atau internet
     * tampilannya sebagai berikut. Ini berfungsi untuk file .wav yang tidak
     * terkompresi dan tidak boleh digunakan untuk memutar file mp3 atau terkompresi
     */

    /*
     * import java.io.*;
     * import java.net.URL;
     * import javax.sound.sampled.*;
     * public class SoundClipTest {
     * // Constructor
     * public SoundClipTest() {
     * try {
     * // Open an audio input stream.
     * File soundFile = new File("/usr/share/sounds/alsa/Front_Center.wav"); //you
     * could also
     * get the sound file with an URL
     * AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
     * AudioFormat format = audioIn.getFormat();
     * // Get a sound clip resource.
     * DataLine.Info info = new DataLine.Info(Clip.class, format);
     * Clip clip = (Clip)AudioSystem.getLine(info);
     * // Open audio clip and load samples from the audio input stream.
     * clip.open(audioIn);
     * clip.start();
     * } catch (UnsupportedAudioFileException e) {
     * e.printStackTrace();
     * } catch (IOException e) {
     * e.printStackTrace();
     * } catch (LineUnavailableException e) {
     * e.printStackTrace();
     * }
     * }
     * public static void main(String[] args) {
     * new SoundClipTest();
     * }
     * }
     */

    // Constructor
    public basic_audio_output() {
        try {
            // Open an audio input stream.
            File soundFile = new File(" src/20240304230421.mkv"); // you could also
            // get the sound file with an URL
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = audioIn.getFormat();
            // Get a sound clip resource.
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new basic_audio_output();
    }

}
