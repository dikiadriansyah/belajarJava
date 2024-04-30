package tommy;

public class main3 {

    // A command with "flag" options and at least one argument / Perintah dengan
    // opsi "bendera" dan setidaknya satu argumen

    public static void main(String[] args) {
        boolean feelMe = false;
        boolean seeMe = false;
        int index;
        loop: for (index = 0; index < args.length; index++) {
            String opt = args[index];
            switch (opt) {
                case "-c":
                    seeMe = true;
                    break;
                case "-f":
                    feelMe = true;
                    break;
                default:

                    if (!opt.isEmpty() && opt.charAt(0) == '-') {
                        error("Unknown option: '" + opt + "'");
                    }
                    break loop;

            }
        }
        if (index >= args.length) {
            error("Missing argument(s)");
        }
    }

    private static void error(String message) {
        if (message != null) {
            System.err.println(message);
        }
        System.err.println("usage: myapp [-f] [-c] [ <arg> ...]");
        System.exit(1);
    }

    // seperti yang anda lihat, memperoses argumen dan opsi menjadi agak rumit jika
    // sintaks perintahnya rumit. Dianjurkan untuk menggunakan perpustakaan "parsing
    // baris perintah"; lihat contoh lainnya

}
