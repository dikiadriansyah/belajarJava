import java.awt.*;
import javax.swing.*;

public class Specifying_image_rendering_quality extends JPanel {
    // Specifying image rendering quality/Menentukan kualitas rendering gambar

    /*
     * static void setupQualityHigh(Graphics2D g2d) {
     * g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
     * RenderingHints.VALUE_ANTIALIAS_ON);
     * g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
     * RenderingHints.VALUE_RENDER_QUALITY);
     * // many other RenderingHints KEY/VALUE pairs to specify
     * }
     * static void setupQualityLow(Graphics2D g2d) {
     * g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
     * RenderingHints.VALUE_ANTIALIAS_OFF);
     * g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
     * RenderingHints.VALUE_RENDER_SPEED);
     * }
     */

    // Perbandingan rendering QUALITY dan SPEED dari gambar sampel:
    // -----------------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw with high quality rendering
        setupQualityHigh(g2d);
        g2d.setColor(Color.RED);
        g2d.fillOval(50, 50, 100, 100);

        // Draw with low quality rendering
        setupQualityLow(g2d);
        g2d.setColor(Color.BLUE);
        g2d.fillOval(200, 50, 100, 100);
    }

    static void setupQualityHigh(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        // Set other RenderingHints KEY/VALUE pairs for high quality rendering
    }

    static void setupQualityLow(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        // Set other RenderingHints KEY/VALUE pairs for low quality rendering
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rendering Quality Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Specifying_image_rendering_quality());
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
