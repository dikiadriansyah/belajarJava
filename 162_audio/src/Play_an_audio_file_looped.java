import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Play_an_audio_file_looped {
    // Play an Audio file Looped/Memutar file Audio Dilingkarkan

    // Impor yang dibutuhkan:
    /*
     * import javax.sound.sampled.AudioSystem;
     * import javax.sound.sampled.Clip;
     * 
     */
    /*
     * Kode ini akan membuat klip dan memutarnya terus menerus setelah dimulai:
     * Clip clip = AudioSystem.getClip();
     * clip.open(AudioSystem.getAudioInputStream(new URL(filename)));
     * clip.start();
     * clip.loop(Clip.LOOP_CONTINUOUSLY);
     */

    // Dapatkan Array dengan semua jenis file yang didukung:
    // AudioFileFormat.Type [] audioFileTypes = AudioSystem.getAudioFileTypes();
    public static void main(String[] args) throws Exception {
        try {
            String filename = "20240304230421.mkv"; // Ganti dengan lokasi file audio Anda
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new URL(filename)));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Menunggu sampai audio selesai diputar sebelum keluar
            while (clip.isRunning()) {
                Thread.sleep(1000); // Tunggu 1 detik
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
