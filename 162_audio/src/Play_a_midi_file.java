import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Play_a_midi_file {
    // Play a MIDI file/Putar file MIDI
    /*
     * File MIDI dapat diputar dengan menggunakan beberapa kelas dari paket
     * javax.sound.midi. Sequencer melakukan
     * pemutaran file MIDI, dan banyak metodenya dapat digunakan untuk mengatur
     * kontrol pemutaran seperti jumlah loop, tempo,
     * track muting, dan lain-lain.
     * Pemutaran data MIDI secara umum dapat dilakukan dengan cara ini:
     */

    /*
     * import java.io.File;
     * import java.io.IOException;
     * import javax.sound.midi.InvalidMidiDataException;
     * import javax.sound.midi.MidiSystem;
     * import javax.sound.midi.MidiUnavailableException;
     * import javax.sound.midi.Sequence;
     * import javax.sound.midi.Sequencer;
     * public class MidiPlayback {
     * public static void main(String[] args) {
     * try {
     * Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
     * if (sequencer==null) {
     * System.err.println("Sequencer device not supported");
     * return;
     * }
     * sequencer.open(); // Open device
     * // Create sequence, the File must contain MIDI file data.
     * Sequence sequence = MidiSystem.getSequence(new File(args[0]));
     * sequencer.setSequence(sequence); // load it into sequencer
     * sequencer.start(); // start the playback
     * } catch (MidiUnavailableException | InvalidMidiDataException | IOException
     * ex) {
     * ex.printStackTrace();
     * }
     * }
     * }
     * 
     */

    // Untuk menghentikan penggunaan pemutaran:
    /*
     * sequencer.stop(); // Stop the playback
     * 
     */

    /*
     * Sequencer dapat diatur untuk membisukan satu atau lebih trek rangkaian selama
     * pemutaran sehingga tidak ada instrumen dalam pemutaran tertentu. Contoh
     * berikut mengatur track pertama dalam urutan yang akan dibisukan:
     * 
     * import javax.sound.midi.Track;
     * // ...
     * Track[] track = sequence.getTracks();
     * sequencer.setTrackMute(track[0]);
     */

    /*
     * Sequencer dapat memainkan suatu sequence berulang kali jika jumlah loop
     * diberikan. Berikut ini mengatur sequencer untuk memainkan urutan empat kali
     * dan tanpa batas waktu:
     * 
     * sequencer.setLoopCount(3);
     * sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
     */

    /*
     * Sequencer tidak selalu harus memainkan sequence dari awal, juga tidak harus
     * memainkan sequence sampai akhir. Itu dapat dimulai dan diakhiri kapan saja
     * dengan menentukan tanda centang dalam urutan untuk memulai dan mengakhiri.
     * Dimungkinkan juga untuk menentukan secara manual centang mana dalam urutan
     * sequencer yang harus diputar:
     * 
     * sequencer.setLoopStartPoint(512);
     * sequencer.setLoopEndPoint(32768);
     * sequencer.setTickPosition(8192);
     */

    /*
     * Sequencer juga dapat memutar file MIDI pada tempo tertentu, yang dapat
     * dikontrol dengan menentukan tempo dalam ketukan per menit (BPM) atau
     * mikrodetik per not seperempat (MPQ). Faktor pemutaran urutan juga dapat
     * disesuaikan.
     */

    /*
     * Ketika Anda selesai menggunakan Sequencer, ingatlah untuk menutupnya
     * sequencer.close();
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // --------------
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
            if (sequencer == null) {
                System.err.println("Sequencer device not supported");
                return;
            }
            sequencer.open(); // Open device
            // Create sequence, the File must contain MIDI file data.
            Sequence sequence = MidiSystem.getSequence(new File("20240304230421.mkv"));
            sequencer.setSequence(sequence); // load it into sequencer
            sequencer.start(); // start the playback
        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
        }
        /*
         * output:
         * javax.sound.midi.InvalidMidiDataException: could not get sequence from file
         */
    }
}
