public class toString_method {
    // toString() method

    /*
     * Metode toString() digunakan untuk membuat representasi String dari suatu
     * objek dengan menggunakan konten objek. Metode ini harus diganti saat menulis
     * kelas Anda. toString() dipanggil secara implisit ketika sebuah objek
     * digabungkan menjadi string seperti pada "halo" + anObject.
     */

    // Pertimbangkan hal berikut:

    private String firstName;
    private String lastName;

    public toString_method(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        toString_method user = new toString_method("John", "Doe");
        // System.out.println(user.toString()); // "John Doe"

        /*
         * Di sini toString() dari kelas Objek ditimpa di kelas Pengguna untuk
         * memberikan data yang berarti mengenai objek saat mencetaknya.
         * 
         * Saat menggunakan println(), metode toString() objek dipanggil secara
         * implisit. Oleh karena itu, pernyataan berikut melakukan hal yang sama:
         */

        System.out.println(user); // toString() is implicitly called on `user`
        // output: John Doe

        System.out.println(user.toString()); // output: John Doe

        /*
         * Jika toString() tidak diganti di kelas Pengguna yang disebutkan di atas,
         * System.out.println(user) dapat kembali
         * User@659e0bfd atau String serupa dengan hampir tidak ada informasi berguna
         * kecuali nama kelas. Hal ini akan terjadi karena
         * panggilan akan menggunakan implementasi toString() dari kelas Objek Java
         * dasar yang tidak mengetahui apa pun tentangnya
         * Struktur kelas pengguna atau aturan bisnis. Jika Anda ingin mengubah fungsi
         * ini di kelas Anda, cukup ganti metodenya.
         */
    }
}
