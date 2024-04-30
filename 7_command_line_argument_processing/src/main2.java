public class main2 {
    // A command with two arguments / Perintah dengan dua argumen

    // Dalam studi kasus ini, perintah membutuhkan tepat dua argumen.

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("usage: myapp <arg1> <arg2>");
            System.exit(1);
        }
        // Run the application
        System.out.println("It worked: " + args[0] + ", " + args[1]);
    }

    // perhatikan bahwa jika kita lali memeriksa args.length, perintah akan macet
    // jika pengguna menjalankannya terlalu sedikit argumen baris perintah.

}
