import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class How_to_scale_a_bufferedimage {
    // How to scale a BufferedImage/Cara menskalakan BufferedImage

    /*
     * //Resizes an image using a Graphics2D object backed by a BufferedImage.
     * //@param srcImg - source image to scale
     * //@param w - desired width
     * //@param h - desired height
     * //@return - the new resized image
     * 
     */

    /*
     * private BufferedImage getScaledImage(Image srcImg, int w, int h){
     * //Create a new image with good size that contains or might contain arbitrary
     * alpha values between
     * and including 0.0 and 1.0.
     * BufferedImage resizedImg = new BufferedImage(w, h,
     * BufferedImage.TRANSLUCENT);
     * //Create a device-independant object to draw the resized image
     * Graphics2D g2 = resizedImg.createGraphics();
     * //This could be changed, Cf.
     * http://stackoverflow.com/documentation/java/5482/creating-images-
     * programmatically/19498/specifying-im
     * age-rendering-quality
     * g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
     * RenderingHints.VALUE_INTERPOLATION_BILINEAR);
     * //Finally draw the source image in the Graphics2D with the desired size.
     * g2.drawImage(srcImg, 0, 0, w, h, null);
     * //Disposes of this graphics context and releases any system resources that it
     * is using
     * g2.dispose();
     * //Return the image used to create the Graphics2D
     * return resizedImg;
     * }
     */

    public static void main(String[] args) {
        try {
            // URL gambar sumber
            URL imageUrl = new URL(
                    "https://i.pinimg.com/474x/69/60/f5/6960f526a36b097cdd6cbda4b8057775.jpg");

            // Baca gambar sumber dari URL
            BufferedImage srcImg = ImageIO.read(imageUrl);

            // Tentukan ukuran yang diinginkan
            int width = 200; // lebar baru
            int height = 150; // tinggi baru

            // Panggil fungsi getScaledImage untuk mengubah ukuran gambar
            BufferedImage scaledImg = getScaledImage(srcImg, width, height);

            // Simpan gambar yang telah diubah ukurannya
            File outputFile = new File("coba1.png");
            ImageIO.write(scaledImg, "png", outputFile);

            System.out.println("Image scaled successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getScaledImage(Image srcImg, int w, int h) {
        // Create a new image with good size that contains or might contain arbitrary
        // alpha values between
        // and including 0.0 and 1.0.
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        // Create a device-independant object to draw the resized image
        Graphics2D g2 = resizedImg.createGraphics();
        // This could be changed, Cf.
        // http://stackoverflow.com/documentation/java/5482/creating-images-programmatically/19498/specifying-im
        // age-rendering-quality
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        // Finally draw the source image in the Graphics2D with the desired size.
        g2.drawImage(srcImg, 0, 0, w, h, null);
        // Disposes of this graphics context and releases any system resources that it
        // is using
        g2.dispose();
        // Return the image used to create the Graphics2D
        return resizedImg;
    }

}
