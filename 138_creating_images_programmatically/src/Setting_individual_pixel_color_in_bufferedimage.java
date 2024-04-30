import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Setting_individual_pixel_color_in_bufferedimage {
    // Setting individual pixel's color in BufferedImage/Mengatur warna piksel
    // individual di BufferedImage

    /*
     * BufferedImage image = new BufferedImage(256, 256,
     * BufferedImage.TYPE_INT_ARGB);
     * //you don't have to use the Graphics object, you can read and set pixel color
     * individually
     * for (int i = 0; i < 256; i++) {
     * for (int j = 0; j < 256; j++) {
     * int alpha = 255; //don't forget this, or use BufferedImage.TYPE_INT_RGB
     * instead
     * int red = i; //or any formula you like
     * int green = j; //or any formula you like
     * int blue = 50; //or any formula you like
     * int color = (alpha << 24) | (red << 16) | (green << 8) | blue;
     * image.setRGB(i, j, color);
     * }
     * }
     * ImageIO.write(image, "png", new File("computed.png"));
     */
    public static void main(String[] args) {
        BufferedImage image = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
        // you don't have to use the Graphics object, you can read and set pixel color
        // individually
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                int alpha = 255; // don't forget this, or use BufferedImage.TYPE_INT_RGB instead
                int red = i; // or any formula you like
                int green = j; // or any formula you like
                int blue = 50; // or any formula you like
                int color = (alpha << 24) | (red << 16) | (green << 8) | blue;
                image.setRGB(i, j, color);
            }
        }

        // Write the BufferedImage to a PNG file
        try {
            ImageIO.write(image, "png", new File("computed.png"));
            System.out.println("Image created successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }
}
