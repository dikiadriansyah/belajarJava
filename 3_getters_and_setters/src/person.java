public class person {
    private String name; // hanya bisa diakses kepada sesama kelas aja

    // dikelas person, ada 1 variabel: name, Variabel ini dapat diakses menggunakan
    // metode getName() dan diubah menggunakan metode setName(String), namun,
    // menyetel name memerlukan panjang nama baru lebih besar dari 2 karakter dan
    // tidak menjadi null.
    // menggunakan metode penyetel (setter method) daripada membuat name variabel
    // menjadi publik memungkinkan orang lain untuk mengatur nilai nama dengan
    // batasan tertentu.
    // hal yang sama dapat diterapkan pada metode pengambil (getter method):
    public String getName() { // metode getName
        if (name.length() > 16) {
            return "Nama terlalu besar";
        } else {
            return name;

        }

    }

    // dalam metode getName() yang dimodifikasi diatas, nama dikembalikan hanya jika
    // panjangnya kurang dari atau sama dengan 16. jika tidak, "Nama terlalu besar"
    // dikembalikan. hal ini memungkinkan pemrogram untuk membuat variabel yang
    // dapat dijangkau dan dimodifikasi sesuka mereka, mencegah kelas klien mengedit
    // variabel yang tidak diinginkan.

    public void setName(String name) { // metode setName()
        if (name != null && name.length() > 2)
            this.name = name;
    }
}
