public class Zero_instance_enum {
    // Zero instance enum / Nol contoh enum

    enum Util {
        /* No instances */;
        public static int clamp(int min, int max, int i) {
            return Math.min(Math.max(i, min), max);
        }
        // other utility methods...
    }

    /*
     * Sama seperti enum yang dapat digunakan untuk lajang (1 kelas instans), enum
     * juga dapat digunakan untuk kelas utilitas (0 kelas instans). Pastikan untuk
     * mengakhiri daftar konstanta enum (kosong) dengan ;.
     * 
     * Lihat pertanyaan Nol contoh enum vs konstruktor pribadi untuk mencegah
     * instantiasi untuk diskusi tentang pro dan kontra dibandingkan dengan
     * konstruktor swasta.
     */

    public static void main(String[] args) {
        int minValue = 10;
        int maxValue = 50;
        int valueToClamp = 30;

        int result = Util.clamp(minValue, maxValue, valueToClamp);

        System.out.println("Nilai setelah diclamp: " + result); // Nilai setelah diclamp: 30
    }
}
