import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Reading_an_image_from_a_file {
    // Reading an image from a file/Membaca gambar dari file
    public static void main(String[] args) {
        try {
            // Ganti "~" dengan path lengkap ke direktori rumah Anda
            String filePath = System.getProperty("user.home") + "/Desktop/Tulips.jpg";
            File imageFile = new File(filePath);

            Image img = ImageIO.read(imageFile);

            // Proses pengolahan gambar dapat ditambahkan di sini

            System.out.println("Gambar berhasil dibaca.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
