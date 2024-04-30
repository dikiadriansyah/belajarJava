import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Editing_and_reusing_image_with_bufferedimage {
    // Editing and re-using image with BufferedImage/Mengedit dan menggunakan
    // kembali gambar dengan BufferedImage

    /*
     * BufferedImage cat = ImageIO.read(new File("cat.jpg")); //read existing file
     * //modify it
     * Graphics g = cat.createGraphics();
     * g.setColor(Color.RED);
     * g.drawString("Cat", 10, 10);
     * g.dispose();
     * //now create a new image
     * BufferedImage cats = new BufferedImage(256, 256,
     * BufferedImage.TYPE_4BYTE_ABGR);
     * //and draw the old one on it, 16 times
     * g = cats.createGraphics();
     * for (int i = 0; i < 4; i++) {
     * for (int j = 0; j < 4; j++) {
     * g.drawImage(cat, i * 64, j * 64, null);
     * }
     * }
     * g.setColor(Color.BLUE);
     * g.drawRect(0, 0, 255, 255); //add some nice border
     * g.dispose(); //and done
     * ImageIO.write(cats, "png", new File("cats.png"));
     * 
     */

    public static void main(String[] args) {
        try {
            BufferedImage cat = ImageIO.read(new File("D:\\belajarJava\\tulips.jpg")); // read existing file
            // modify it
            Graphics g = cat.createGraphics();
            g.setColor(Color.RED);
            g.drawString("Tulips", 10, 10);
            g.dispose();
            // now create a new image
            BufferedImage cats = new BufferedImage(256, 256, BufferedImage.TYPE_4BYTE_ABGR);
            // and draw the old one on it, 16 times
            g = cats.createGraphics();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    g.drawImage(cat, i * 64, j * 64, null);
                }
            }
            g.setColor(Color.BLUE);
            g.drawRect(0, 0, 255, 255); // add some nice border
            g.dispose(); // and done
            ImageIO.write(cats, "png", new File("tulips.png"));
            System.out.println("Image created successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
