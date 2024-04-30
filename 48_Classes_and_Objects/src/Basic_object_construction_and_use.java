public class Basic_object_construction_and_use {
    // Basic Object Construction and Use / Konstruksi dan Penggunaan Objek Dasar

    // Object mempunyai kelasnya sendiri, jadi contoh sederhananya adalah mobil
    // (penjelasan detailnya di bawah):
    /*
     * public class Car {
     * // Variables describing the characteristics of an individual car, varies per
     * // object
     * private int milesPerGallon;
     * private String name;
     * private String color;
     * public int numGallonsInTank;
     * 
     * public Car() {
     * milesPerGallon = 0;
     * name = "";
     * color = "";
     * numGallonsInTank = 0;
     * }
     * 
     * // this is where an individual object is created
     * public Car(int mpg, int gallonsInTank, String carName, String carColor) {
     * milesPerGallon = mpg;
     * name = carName;
     * color = carColor;
     * numGallonsInTank = gallonsInTank;
     * }
     * 
     * // methods to make the object more usable
     * // Cars need to drive
     * public void drive(int distanceInMiles){
     * //get miles left in car
     * int miles = numGallonsInTank * milesPerGallon;
     * 
     * //check that car has enough gas to drive distanceInMiles
     * if (miles <= distanceInMiles){
     * numGallonsInTank = numGallonsInTank - (distanceInMiles / milesPerGallon)
     * System.out.println("Drove " + numGallonsInTank + " miles!");
     * } else {
     * System.out.println("Could not drive!");
     * }
     * }
     * 
     * public void paintCar(String newColor) {
     * color = newColor;
     * }
     * 
     * // set new Miles Per Gallon
     * public void setMPG(int newMPG) {
     * milesPerGallon = newMPG;
     * }
     * 
     * // set new number of Gallon In Tank
     * public void setGallonsInTank(int numGallons) {
     * numGallonsInTank = numGallons;
     * }
     * 
     * public void nameCar(String newName) {
     * name = newName;
     * }
     * 
     * // Get the Car color
     * public String getColor() {
     * return color;
     * }
     * 
     * // Get the Car name
     * public String getName() {
     * return name;
     * }
     * 
     * // Get the number of Gallons
     * public String getGallons() {
     * return numGallonsInTank;
     * }
     * 
     * }
     * 
     */

    /*
     * Objek adalah turunan dari kelasnya. Jadi, cara Anda membuat objek adalah
     * dengan memanggil kelas Mobil dengan salah satu dari dua cara di kelas utama
     * Anda (metode utama di Java atau onCreate di Android).
     */

    // Pilihan 1
    // `Car newCar = new Car(30, 10, "Ferrari", "Red");

    /*
     * Opsi 1 adalah tempat Anda memberi tahu program segala sesuatu tentang Mobil
     * saat objek dibuat. Mengubah properti apa pun pada mobil memerlukan
     * pemanggilan salah satu metode seperti metode repaintCar. Contoh:
     * newCar.repaintCar("Blue");
     * 
     */

    // Catatan: Pastikan Anda meneruskan tipe data yang benar ke metode ini. Pada
    // contoh di atas, Anda juga dapat meneruskan variabel ke metode repaintCar
    // selama tipe datanya benar`.

    /*
     * Itu adalah contoh perubahan properti suatu objek, untuk menerima properti
     * suatu objek diperlukan penggunaan metode dari kelas Mobil yang memiliki nilai
     * kembalian (artinya metode yang tidak batal). Contoh:
     * String myCarName = newCar.getName(); //returns string "Ferrari"
     */

    // Opsi 1 adalah opsi terbaik ketika Anda memiliki semua data objek pada saat
    // pembuatan.

    // pilihan 2
    // `Car newCar = new Car();

    /*
     * Opsi 2 mendapatkan efek yang sama tetapi memerlukan lebih banyak pekerjaan
     * untuk membuat objek dengan benar. Saya ingin mengingat kembali Konstruktor di
     * kelas Car ini:
     * public void Car(){
     * milesPerGallon = 0;
     * name = "";
     * color = "";
     * numGallonsInTank = 0;
     * }
     */

    /*
     * Perhatikan bahwa Anda tidak harus memasukkan parameter apa pun ke dalam objek
     * untuk membuatnya. Ini sangat berguna saat itu
     * Anda tidak memiliki semua aspek objek tetapi Anda perlu menggunakan
     * bagian-bagian yang Anda miliki. Ini menetapkan data generik ke dalam
     * masing-masing variabel instan objek sehingga, jika Anda memanggil bagian data
     * yang tidak ada, tidak ada kesalahan yang terjadi.
     */

    // Catatan: Jangan lupa bahwa nanti Anda harus mengatur bagian-bagian objek yang
    // tidak Anda inisialisasi. Misalnya,
    /*
     * Car myCar = new Car();
     * String color = Car.getColor(); //returns empty string
     */

    /*
     * Ini adalah kesalahan umum di antara objek yang tidak diinisialisasi dengan
     * semua datanya. Kesalahan dihindari karena
     * ada Konstruktor yang mengizinkan objek Mobil kosong dibuat dengan variabel
     * stand-in (public Car(){}), tetapi
     * tidak ada bagian dari myCar yang benar-benar dikustomisasi. Contoh pembuatan
     * Objek Car yang benar:
     * Car myCar = new Car();
     * myCar.nameCar("Ferrari");
     * myCar.paintCar("Purple");
     * myCar.setGallonsInTank(10);
     * myCar.setMPG(30);
     */

    // Dan, sebagai pengingat, dapatkan properti objek dengan memanggil metode di
    // kelas utama Anda. Contoh:
    // String myCarName = myCar.getName(); //returns string "Ferrari"

    public static void main(String[] args) {
        // Car newCar = new Car(30, 10, "Ferrari", "Red");
        // newCar.paintCar("Blue");
        // System.out.println("Car Color: " + newCar.getColor()); // Car Color: Blue

        // -------------
        Car3 myCar = new Car3();
        myCar.nameCar("Ferrari");
        myCar.paintCar("Purple");
        myCar.setGallonsInTank(10);
        myCar.setMPG(30);
        String myCarName = myCar.getName(); // returns string "Ferrari"
        System.out.println("jenis mobil : " + myCarName);
        // output:
        // jenis mobil : Ferrari

    }
}
