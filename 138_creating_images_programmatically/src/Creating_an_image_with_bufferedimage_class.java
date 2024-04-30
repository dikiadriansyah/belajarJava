import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Creating_an_image_with_bufferedimage_class {
    // Creating an image with BufferedImage class/Membuat gambar dengan kelas
    // BufferedImage

    /*
     * int width = 256; //in pixels
     * int height = 256; //in pixels
     * BufferedImage image = new BufferedImage(width, height,
     * BufferedImage.TYPE_4BYTE_ABGR);
     * //BufferedImage.TYPE_4BYTE_ABGR - store RGB color and visibility (alpha), see
     * javadoc for more info
     * Graphics g = image.createGraphics();
     * //draw whatever you like, like you would in a drawComponent(Graphics g)
     * method in an UI application
     * g.setColor(Color.RED);
     * g.fillRect(20, 30, 50, 50);
     * g.setColor(Color.BLUE);
     * g.drawOval(120, 120, 80, 40);
     * g.dispose(); //dispose graphics objects when they are no longer needed
     * //now image has programmatically generated content, you can use it in
     * graphics.drawImage() to draw it
     * somewhere else
     * //or just simply save it to a file
     * ImageIO.write(image, "png", new File("myimage.png"));
     * 
     */

    public static void main(String[] args) {
        int width = 256; // in pixels
        int height = 256; // in pixels
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        // BufferedImage.TYPE_4BYTE_ABGR - store RGB color and visibility (alpha), see
        // javadoc for more info
        Graphics g = image.createGraphics();
        // draw whatever you like, like you would in a drawComponent(Graphics g) method
        // in an UI application
        g.setColor(Color.RED);
        g.fillRect(20, 30, 50, 50);
        g.setColor(Color.BLUE);
        g.drawOval(120, 120, 80, 40);
        g.dispose(); // dispose graphics objects when they are no longer needed
        // now image has programmatically generated content, you can use it in
        // graphics.drawImage() to draw it somewhere else or just simply save it to a
        // file

        try {
            ImageIO.write(image, "png", new File("myimage.png"));
            System.out.println("Image created successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred while saving the image: " + e.getMessage());
        }

    }
}
