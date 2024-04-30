public class checking_arithmetic_with_assert {
    // Checking arithmetic with assert/Memeriksa aritmatika dengan menegaskan

    /*
     * a = 1 - Math.abs(1 - a % 2);
     * // This will throw an error if my arithmetic above is wrong.
     * assert a >= 0 && a <= 1 : "Calculated value of " + a +
     * " is outside of expected bounds";
     * return a;
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        int a = 3; // Contoh nilai a yang digunakan
        a = calculateA(a);
        System.out.println("Nilai a setelah dihitung: " + a);
        // output: Nilai a setelah dihitung: 1
    }

    public static int calculateA(int a) {
        a = 1 - Math.abs(1 - a % 2);
        // Akan melempar pesan kesalahan jika nilai a di luar batas yang diharapkan
        assert a >= 0 && a <= 1 : "Nilai yang dihitung " + a + " berada di luar batas yang diharapkan";
        return a;
    }

}
