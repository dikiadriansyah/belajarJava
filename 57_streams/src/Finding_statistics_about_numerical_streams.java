import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Finding_statistics_about_numerical_streams {
    // Finding Statistics about Numerical Streams / Menemukan Statistik tentang
    // Aliran Numerik

    /*
     * Java 8 menyediakan kelas yang disebut IntSummaryStatistics,
     * DoubleSummaryStatistics, dan LongSummaryStatistics
     * yang memberikan objek keadaan untuk mengumpulkan statistik seperti count,
     * min, max, sum, dan average.
     */
    public static void main(String[] args) {
        List<Integer> naturalNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = naturalNumbers.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println(stats);
        /*
         * output:
         * IntSummaryStatistics{count=10, sum=55, min=1, average=5.500000, max=10}
         */

    }
}
