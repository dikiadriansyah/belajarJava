import java.util.Arrays;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class bare_metal_sound {
    // Bare metal sound/Suara metalik

    /*
     * Anda juga bisa tampil hampir bare-metal saat memproduksi suara dengan java.
     * Kode ini akan menulis data biner mentah ke dalam buffer audio OS untuk
     * menghasilkan suara. Sangat penting untuk memahami batasan dan perhitungan
     * yang diperlukan untuk menghasilkan suara seperti ini. Karena pemutaran pada
     * dasarnya dilakukan secara instan, perhitungan harus dilakukan hampir secara
     * real-time.
     * 
     * Oleh karena itu, metode ini tidak dapat digunakan untuk pengambilan sampel
     * suara yang lebih rumit. Untuk tujuan tersebut menggunakan alat khusus adalah
     * pendekatan yang lebih baik.
     * 
     * Metode berikut menghasilkan dan secara langsung mengeluarkan gelombang
     * persegi panjang dengan frekuensi tertentu dalam volume tertentu untuk durasi
     * tertentu.
     */

    /*
     * public void rectangleWave(byte volume, int hertz, int msecs) {
     * final SourceDataLine dataLine;
     * // 24 kHz x 8bit, single-channel, signed little endian AudioFormat
     * AudioFormat af = new AudioFormat(24_000, 8, 1, true, false);
     * try {
     * dataLine = AudioSystem.getSourceDataLine(af);
     * dataLine.open(af, 10_000); // audio buffer size: 10k samples
     * } catch (LineUnavailableException e) {
     * throw new RuntimeException(e);
     * }
     * int waveHalf = 24_000 / hertz; // samples for half a period
     * byte[] buffer = new byte[waveHalf * 20];
     * int samples = msecs * (24_000 / 1000); // 24k (samples / sec) / 1000 (ms/sec)
     * * time(ms)
     * dataLine.start(); // starts playback
     * int sign = 1;
     * for (int i = 0; i < samples; i += buffer.length) {
     * for (int j = 0; j < 20; j++) { // generate 10 waves into buffer
     * sign *= -1;
     * // fill from the jth wave-half to the j+1th wave-half with volume
     * Arrays.fill(buffer, waveHalf * j, waveHalf * (j+1), (byte) (volume * sign));
     * }
     * dataLine.write(buffer, 0, buffer.length); //
     * }
     * dataLine.drain(); // forces buffer drain to hardware
     * dataLine.stop(); // ends playback
     * }
     * 
     */

    /*
     * Untuk cara yang lebih berbeda dalam menghasilkan perhitungan sinus gelombang
     * suara yang berbeda dan kemungkinan ukuran sampel yang lebih besar diperlukan.
     * Hal ini menghasilkan kode yang jauh lebih kompleks dan karenanya dihilangkan
     * di sini.
     */
    // ------------------

    public static void main(String[] args) {
        bare_metal_sound player = new bare_metal_sound();
        player.playRectangleWave((byte) 100, 440, 2000); // Parameters: volume, hertz, milliseconds
    }

    public void playRectangleWave(byte volume, int hertz, int msecs) {
        final SourceDataLine dataLine;
        // 24 kHz x 8bit, single-channel, signed little endian AudioFormat
        AudioFormat af = new AudioFormat(24_000, 8, 1, true, false);
        try {
            dataLine = AudioSystem.getSourceDataLine(af);
            dataLine.open(af, 10_000); // audio buffer size: 10k samples
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        int waveHalf = 24_000 / hertz; // samples for half a period
        byte[] buffer = new byte[waveHalf * 20];
        int samples = msecs * (24_000 / 1000); // 24k (samples / sec) / 1000 (ms/sec) * time(ms)
        dataLine.start(); // starts playback
        int sign = 1;
        for (int i = 0; i < samples; i += buffer.length) {
            for (int j = 0; j < 20; j++) { // generate 10 waves into buffer
                sign *= -1;
                // fill from the jth wave-half to the j+1th wave-half with volume
                Arrays.fill(buffer, waveHalf * j, waveHalf * (j + 1), (byte) (volume * sign));
            }
            dataLine.write(buffer, 0, buffer.length); //
        }
        dataLine.drain(); // forces buffer drain to hardware
        dataLine.stop(); // ends playback
    }
}
