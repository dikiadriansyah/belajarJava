import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Save_an_image_to_disk {
    // Save an Image to disk/Simpan Gambar ke disk

    /*
     * public static void saveImage(String destination) throws IOException {
     * // method implemented in
     * "Creating a simple image Programmatically and displaying it" example
     * BufferedImage img = createSampleImage();
     * // ImageIO provides several write methods with different outputs
     * ImageIO.write(img, "png", new File(destination));
     * }
     * 
     */

    public static void saveImage(String destination) throws IOException {
        // method implemented in "Creating a simple image Programmatically and
        // displaying it" example
        BufferedImage img = createSampleImage();
        // ImageIO provides several write methods with different outputs
        ImageIO.write(img, "png", new File(destination));
    }

    static BufferedImage createSampleImage() {
        // instantiate a new BufferedImage (subclass of Image) instance
        BufferedImage img = new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);

        // draw something on the image
        paintOnImage(img);

        return img;
    }

    static void paintOnImage(BufferedImage img) {
        // get a drawable Graphics2D (subclass of Graphics) object
        Graphics2D g2d = img.createGraphics();

        // some sample drawing
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 640, 480);
        g2d.setColor(Color.WHITE);
        g2d.drawLine(0, 0, 640, 480);
        g2d.drawLine(0, 480, 640, 0);
        g2d.setColor(Color.YELLOW);
        g2d.drawOval(200, 100, 240, 280);
        g2d.setColor(Color.RED);
        g2d.drawRect(150, 70, 340, 340);

        // drawing on images can be very memory-consuming
        // so it's better to free resources early
        // it's not necessary, though
        g2d.dispose();
    }

    public static void main(String[] args) {
        try {
            saveImage("sample_image.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
