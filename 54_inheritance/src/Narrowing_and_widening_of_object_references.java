
public class Narrowing_and_widening_of_object_references {
    // Narrowing and Widening of object references / Mempersempit dan Memperluas
    // referensi objek

    /*
     * Mentransmisikan sebuah instance dari kelas dasar ke subkelas seperti pada : b
     * = (B) a; disebut penyempitan (saat Anda mencoba mempersempit
     * objek kelas dasar ke objek kelas yang lebih spesifik) dan memerlukan
     * tipe-cast yang eksplisit.
     * 
     * Mentransmisikan turunan subkelas ke kelas dasar seperti pada: A a = b;
     * disebut pelebaran dan tidak memerlukan type-cast.
     * 
     * Sebagai ilustrasi, pertimbangkan deklarasi kelas berikut, dan kode pengujian:
     */

    public static void main(String[] args) {
        Vechile vehicle = new Vechile();
        Car2 car = new Car2();
        Truck truck = new Truck();
        MotorCycle motorCycle = new MotorCycle();

        // Polymorphism
        vehicle.start(); // Output: Vehicle is starting...
        car.start(); // Output: Vehicle is starting...
        car.drive(); // Output: Car is driving...
        truck.start(); // Output: Vehicle is starting...
        truck.loadCargo(); // Output: Truck is loading cargo...
        motorCycle.start(); // Output: Vehicle is starting...
        motorCycle.ride(); // Output: Motorcycle is riding...

        /*
         * Pernyataan Kendaraan kendaraan = Mobil baru(); adalah pernyataan Java yang
         * valid. Setiap contoh Mobil juga merupakan Kendaraan.
         * Oleh karena itu, penugasannya sah tanpa memerlukan type-cast yang eksplisit.
         * 
         * Sebaliknya Mobil c = kendaraan; tidak valid. Tipe statis dari variabel
         * kendaraan adalah Kendaraan yang artinya
         * yang dapat merujuk pada turunan Mobil, Truk, Sepeda Motor, atau subkelas
         * lainnya saat ini atau di masa depan
         * dari Kendaraan. (Atau tentu saja, sebuah instance dari Vehicle itu sendiri,
         * karena kita tidak mendeklarasikannya sebagai kelas abstrak.)
         * Penetapan tersebut tidak dapat diizinkan, karena hal tersebut dapat
         * menyebabkan mobil merujuk ke instance aTruck`.
         * 
         * Untuk mencegah situasi ini, kita perlu menambahkan type-cast eksplisit:
         * Car c = (Car) vehicle;
         */

        /*
         * Type-cast memberi tahu kompiler bahwa kita mengharapkan nilai vehicle menjadi
         * Car atau subkelas Car. Jika diperlukan,
         * kompiler akan memasukkan kode untuk melakukan pemeriksaan tipe run-time. Jika
         * pemeriksaan gagal, maka ClassCastException akan dilempar saat kode
         * dijalankan.
         * 
         * Perhatikan bahwa tidak semua tipe cast valid. Misalnya:
         * String s = (String) vehicle; // not valid
         */

        /*
         * Kompiler Java mengetahui bahwa sebuah instance yang bertipe kompatibel dengan
         * Vehicle tidak akan pernah bertipe kompatibel dengan String. Type-cast tidak
         * akan pernah berhasil, dan JLS mengamanatkan hal ini menyebabkan kesalahan
         * kompilasi.
         */
    }
}
