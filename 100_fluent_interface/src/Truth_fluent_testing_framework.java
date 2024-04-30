import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Truth_fluent_testing_framework {
    // Truth - Fluent Testing Framework/Kebenaran - Kerangka Pengujian Lancar

    // Dari "Cara menggunakan Kebenaran" http://google.github.io/truth/

    /*
     * String string = "awesome";
     * assertThat(string).startsWith("awe");
     * assertWithMessage("Without me, it's just aweso").that(string).contains("me");
     * Iterable<Color> googleColors = googleLogo.getColors();
     * assertThat(googleColors)
     * .containsExactly(BLUE, RED, YELLOW, BLUE, GREEN, RED)
     * .inOrder();
     */

    public static void main(String[] args) throws Exception {
        String string = "awesome";

        assertThat(string).startsWith("awe");
        assertWithMessage("Without me, it's just aweso").that(string).contains("me");

        Iterable<Color> googleColors = googleLogo.getColors();

        assertThat(googleColors)
                .containsExactly(Color.BLUE, Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED)
                .inOrder();
    }

    enum Color {
        BLUE, RED, YELLOW, GREEN
    }

}
