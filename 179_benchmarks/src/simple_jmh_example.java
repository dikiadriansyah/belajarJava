public class simple_jmh_example {
    // Simple JMH example/Contoh JMH sederhana

    /*
     * Salah satu alat untuk menulis tes benchmark yang tepat adalah JMH. Katakanlah
     * kita ingin membandingkan kinerja pencarian elemen di HashSet vs TreeSet.
     * 
     * Cara termudah untuk memasukkan JHM ke dalam proyek Anda adalah dengan
     * menggunakan plugin maven dan shade. Anda juga dapat melihat pom.xml dari
     * contoh JHM.
     */

    /*
     * <build>
     * <plugins>
     * <plugin>
     * <groupId>org.apache.maven.plugins</groupId>
     * <artifactId>maven-shade-plugin</artifactId>
     * <version>3.0.0</version>
     * <executions>
     * <execution>
     * <phase>package</phase>
     * <goals>
     * <goal>shade</goal>
     * </goals>
     * <configuration>
     * <finalName>/benchmarks</finalName>
     * <transformers>
     * <transformer
     * 
     * implementation=
     * "org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
     * <mainClass>org.openjdk.jmh.Main</mainClass>
     * </transformer>
     * </transformers>
     * <filters>
     * <filter>
     * <artifact>*:*</artifact>
     * <excludes>
     * <exclude>META-INF/*.SF</exclude>
     * <exclude>META-INF/*.DSA</exclude>
     * <exclude>META-INF/*.RSA</exclude>
     * </excludes>
     * </filter>
     * </filters>
     * </configuration>
     * </execution>
     * </executions>
     * </plugin>
     * </plugins>
     * </build>
     * <dependencies>
     * <dependency>
     * <groupId>org.openjdk.jmh</groupId>
     * <artifactId>jmh-core</artifactId>
     * <version>1.18</version>
     * </dependency>
     * <dependency>
     * <groupId>org.openjdk.jmh</groupId>
     * <artifactId>jmh-generator-annprocess</artifactId>
     * <version>1.18</version>
     * </dependency>
     * </dependencies>
     */

    // Setelah ini, Anda perlu menulis kelas benchmark itu sendiri:

    /*
     * package benchmark;
     * import org.openjdk.jmh.annotations.*;
     * import org.openjdk.jmh.infra.Blackhole;
     * import java.util.HashSet;
     * import java.util.Random;
     * import java.util.Set;
     * import java.util.TreeSet;
     * import java.util.concurrent.TimeUnit;
     * 
     * @State(Scope.Thread)
     * public class CollectionFinderBenchmarkTest {
     * private static final int SET_SIZE = 10000;
     * private Set<String> hashSet;
     * private Set<String> treeSet;
     * private String stringToFind = "8888";
     * 
     * @Setup
     * public void setupCollections() {
     * hashSet = new HashSet<>(SET_SIZE);
     * treeSet = new TreeSet<>();
     * for (int i = 0; i < SET_SIZE; i++) {
     * final String value = String.valueOf(i);
     * hashSet.add(value);
     * treeSet.add(value);
     * }
     * stringToFind = String.valueOf(new Random().nextInt(SET_SIZE));
     * }
     * 
     * @Benchmark
     * 
     * @BenchmarkMode(Mode.AverageTime)
     * 
     * @OutputTimeUnit(TimeUnit.NANOSECONDS)
     * public void testHashSet(Blackhole blackhole) {
     * blackhole.consume(hashSet.contains(stringToFind));
     * }
     * 
     * @Benchmark
     * 
     * @BenchmarkMode(Mode.AverageTime)
     * 
     * @OutputTimeUnit(TimeUnit.NANOSECONDS)
     * public void testTreeSet(Blackhole blackhole) {
     * blackhole.consume(treeSet.contains(stringToFind));
     * }
     * }
     */

    /*
     * Harap diingat blackhole.consume() ini, kita akan membahasnya lagi nanti. Kita
     * juga membutuhkan kelas utama untuk menjalankan benchmark:
     * 
     * package benchmark;
     * import org.openjdk.jmh.runner.Runner;
     * import org.openjdk.jmh.runner.RunnerException;
     * import org.openjdk.jmh.runner.options.Options;
     * import org.openjdk.jmh.runner.options.OptionsBuilder;
     * public class BenchmarkMain {
     * public static void main(String[] args) throws RunnerException {
     * final Options options = new OptionsBuilder()
     * .include(CollectionFinderBenchmarkTest.class.getSimpleName())
     * .forks(1)
     * .build();
     * new Runner(options).run();
     * }
     * }
     */

    /*
     * Dan kita sudah siap. Kita hanya perlu menjalankan mvn package (itu akan
     * membuat benchmarks.jar di folder /target Anda) dan menjalankan tes benchmark
     * kami:
     * 
     * java -cp target/benchmarks.jar benchmark.BenchmarkMain
     */

    /*
     * Dan setelah beberapa pemanasan dan iterasi perhitungan, kita akan mendapatkan
     * hasil:
     * # Run complete. Total time: 00:01:21
     * Benchmark Mode Cnt Score Error Units
     * CollectionFinderBenchmarkTest.testHashSet avgt 20 9.940 ± 0.270 ns/op
     * CollectionFinderBenchmarkTest.testTreeSet avgt 20 98.858 ± 13.743 ns/op
     */

    /*
     * Tentang blackhole.consume(). Jika perhitungan Anda tidak mengubah
     * status aplikasi Anda, kemungkinan besar Java akan mengabaikannya. Jadi, untuk
     * menghindarinya, Anda bisa membuat metode benchmark Anda mengembalikan
     * sejumlah nilai, atau menggunakan objek Blackhole untuk menggunakannya.
     * 
     * Anda dapat menemukan informasi lebih lanjut tentang penulisan tolok ukur yang
     * tepat di blog Aleksey Shipilëv, di blog Jacob Jenkov
     * dan di blog kinerja Java: 1, 2.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
