public class sample {

    // Enkapsulasi adalah konsep dasar dalam OOP. ini tentang membungkus data dan
    // kode sebagai satu kesatuan. dalam hal ini, merupakan praktik yang baik untuk
    // mendeklarasikan variabel sebagai pribadi(private) dan kemudian mengaksesnya
    // melalui getter dan setter untuk meliihat dan/atau memodifikasinya.
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // variabel pribadi ini tidak dapat diakses langsung dari luar kelas. oleh
    // karena itu mereka dilindungi dari akses tidak sah. namun jika anda ingin
    // melihat atau memodifikasinya, anda dapat menggunakan Getter dan Setter.

    // metode getXxx() akan mengembalikan nilai variabel xxx saat ini, sementara
    // Anda dapat mengatur nilai variabel xxx
    // menggunakan setXxx().
    // Konvensi penamaan metode adalah (dalam contoh variabel disebut namavariabel):

    // All non boolean variables
    // getVariableName() //Getter, The variable name should start with uppercase
    // setVariableName(..) //Setter, The variable name should start with uppercase

    // boolean variables
    // isVariableName() //Getter, The variable name should start with uppercase
    // setVariableName(...) //Setter, The variable name should start with uppercase

    // public Getter dan Setter adalah bagian dari definisi properti dari Java Bean.
}
