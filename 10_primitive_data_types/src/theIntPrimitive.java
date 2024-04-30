public class theIntPrimitive {
    public static void main(String[] args) {
        // Primitive data type seperti int menyimpan nilai langsung ke variabel yang
        // menggunakannya, sedangkan variabel yang dideklarasikan menggunakan Integer
        // menyimpan referensi ke nilai tersebut.

        // Menurut java API: "Kelas Integer membungkus nilai tipe primitif int dalam
        // sebuah objek. Objek bertipe Integer berisi satu bidang yang tipenya int."

        // Secara default, int adalah bilangan bulat bertanda 32-bit. Itu dapat
        // menyimpan nilai minimum -231, dan nilai maksimum 231 - 1.

        int angkaNegatif = -44;
        int angkaKu = 284;
        int angkaLain = 74;

        int tambahAngka = angkaKu + angkaLain;
        int penguranganAngka = angkaKu - angkaLain;

        // Jika Anda perlu menyimpan nomor di luar rentang ini, long sebaiknya digunakan
        // sebagai gantinya. Melebihi rentang nilai int mengarah ke overflow bilangan
        // bulat, menyebabkan nilai yang melebihi rentang ditambahkan ke situs
        // berlawanan dari rentang tersebut (positif menjadi negatif dan sebaliknya).
        // The value is ((value - MIN_VALUE) % RANGE) + MIN_VALUE, or ((value +
        // 2147483648) % 4294967296) - 2147483648

        int angkaMaksimum = 224214234;
        // System.out.println(angkaMaksimum); // 224214234

        angkaMaksimum = angkaMaksimum + 1; // menyebabkan luapan bilangan bulat
        // System.out.println(angkaMaksimum); // 224214235

        // nilai maximum dan minimum int dapat ditemukan di:
        int tinggi = Integer.MAX_VALUE;
        // System.out.println(tinggi); // 2147483647
        int pendek = Integer.MIN_VALUE;
        // System.out.println(pendek); // -2147483648

        // Nilai default dari sebuah int adalah 0
        int defaultInt; // defaultInt == 0
        // System.out.println(defaultInt);

    }

}
