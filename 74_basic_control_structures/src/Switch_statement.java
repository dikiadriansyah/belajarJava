import java.util.*;

public class Switch_statement {
    // Switch statement/ Ganti pernyataan

    /*
     * Pernyataan switch adalah pernyataan cabang multi-arah Java. Digunakan untuk
     * menggantikan if-else if-else yang panjang
     * rantai, dan membuatnya lebih mudah dibaca. Namun, tidak seperti pernyataan
     * if, seseorang tidak boleh menggunakan pertidaksamaan; setiap nilai harus
     * didefinisikan secara konkrit.
     */

    // Ada tiga komponen penting pada pernyataan switch:
    /*
     * 1. case: Ini adalah nilai yang dievaluasi kesetaraannya dengan argumen pada
     * pernyataan switch.
     * 2. default: Ini adalah ekspresi opsional yang mencakup semua, jika tidak ada
     * pernyataan case yang bernilai true.
     * 3. Penyelesaian pernyataan case secara tiba-tiba; biasanya break: Ini
     * diperlukan untuk mencegah evaluasi yang tidak diinginkan
     * pernyataan case lebih lanjut
     */

    /*
     * Dengan pengecualian untuk continue, dimungkinkan untuk menggunakan
     * pernyataan apa pun yang akan menyebabkan penyelesaian pernyataan secara
     * tiba-tiba. Ini termasuk:
     * break
     * return
     * throw
     */

    /*
     * Pada contoh di bawah, pernyataan switch tipikal ditulis dengan empat
     * kemungkinan kasus, termasuk default.
     */

    /*
     * Scanner scan = new Scanner(System.in);
     * int i = scan.nextInt();
     * switch (i) {
     * case 0:
     * System.out.println("i is zero");
     * break;
     * case 1:
     * System.out.println("i is one");
     * break;
     * case 2:
     * System.out.println("i is two");
     * break;
     * default:
     * System.out.println("i is less than zero or greater than two");
     * }
     */

    /*
     * Dengan menghilangkan break atau pernyataan apa pun yang merupakan
     * penyelesaian mendadak, kita dapat memanfaatkan apa yang dikenal sebagai kasus
     * "fallthrough", yang mengevaluasi beberapa nilai. Hal ini dapat digunakan
     * untuk menciptakan rentang nilai yang berhasil dilawan, namun tetap tidak
     * sefleksibel kesenjangan.
     */

    /*
     * Scanner scan = new Scanner(System.in);
     * int foo = scan.nextInt();
     * switch(foo) {
     * case 1:
     * System.out.println("I'm equal or greater than one");
     * case 2:
     * case 3:
     * System.out.println("I'm one, two, or three");
     * break;
     * default:
     * System.out.println("I'm not either one, two, or three");
     * }
     */

    // Dalam kasus foo == 1 hasilnya akan menjadi:
    /*
     * I'm equal or greater than one
     * I'm one, two, or three
     */

    // Dalam kasus foo == 3 hasilnya akan menjadi:
    // I'm one, two, or three

    // Version ≥ Java SE 5

    // Pernyataan switch juga dapat digunakan dengan enum
    /*
     * enum Option {
     * BLUE_PILL,
     * RED_PILL
     * }
     * public void takeOne(Option option) {
     * switch(option) {
     * case BLUE_PILL:
     * System.out.println("Story ends, wake up, believe whatever you want.");
     * break;
     * case RED_PILL:
     * System.out.println("I show you how deep the rabbit hole goes.");
     * break;
     * 
     * }
     * }
     */

    // Version ≥ Java SE 7
    // Pernyataan switch juga dapat digunakan dengan Strings
    /*
     * public void rhymingGame(String phrase) {
     * switch (phrase) {
     * case "apples and pears":
     * System.out.println("Stairs");
     * break;
     * case "lorry":
     * System.out.println("truck");
     * break;
     * default:
     * System.out.println("Don't know any more");
     * }
     * }
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Scanner scan = new Scanner(System.in);
        // int i = scan.nextInt();
        // switch (i) {
        // case 0:
        // System.out.println("i is zero");
        // break;
        // case 1:
        // System.out.println("i is one");
        // break;
        // case 2:
        // System.out.println("i is two");
        // break;
        // default:
        // System.out.println("i is less than zero or greater than two");
        // }
        /*
         * output:
         * 1
         * i is one
         */
        // ------------------------------
        // Scanner scan = new Scanner(System.in);
        // int foo = scan.nextInt();
        // switch (foo) {
        // case 1:
        // System.out.println("I'm equal or greater than one");
        // case 2:
        // case 3:
        // System.out.println("I'm one, two, or three");
        // break;
        // default:
        // System.out.println("I'm not either one, two, or three");
        // }
        /*
         * output:
         * 2
         * I'm one, two, or three
         */
        // ------------------------------
        Switch_statement box1 = new Switch_statement();
        // Contoh penggunaan dengan BLUE_PILL
        // box1.takeOne(Option.BLUE_PILL);
        /*
         * output:
         * Story ends, wake up, believe whatever you want.
         */

        // Contoh penggunaan dengan RED_PILL
        // box1.takeOne(Option.RED_PILL);
        /*
         * output:
         * I show you how deep the rabbit hole goes.
         */
        // ------------------------------------------
        box1.rhymingGame("lorry"); // output: truck
    }

    // enum Option {
    // BLUE_PILL, RED_PILL
    // }

    // public void takeOne(Option option) {
    // switch (option) {
    // case BLUE_PILL:
    // System.out.println("Story ends, wake up, believe whatever you want.");
    // break;
    // case RED_PILL:
    // System.out.println("I show you how deep the rabbit hole goes.");
    // break;

    // }
    // }

    public void rhymingGame(String phrase) {
        switch (phrase) {
            case "apples and pears":
                System.out.println("Stairs");
                break;
            case "lorry":
                System.out.println("truck");
                break;
            default:
                System.out.println("Don't know any more");
        }
    }

}
