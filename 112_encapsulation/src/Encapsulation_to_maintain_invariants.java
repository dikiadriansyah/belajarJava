public class Encapsulation_to_maintain_invariants {
    // Encapsulation to maintain invariants/Enkapsulasi untuk mempertahankan
    // invarian

    /*
     * Ada dua bagian kelas: antarmuka dan implementasi.
     * 
     * Antarmuka adalah fungsionalitas kelas yang diekspos. Metode dan variabel
     * publiknya adalah bagian dari antarmuka.
     * 
     * Implementasinya adalah cara kerja internal suatu kelas. Kelas lain tidak
     * perlu mengetahui implementasi suatu kelas.
     * 
     * Enkapsulasi mengacu pada praktik menyembunyikan implementasi suatu kelas dari
     * pengguna kelas tersebut. Hal ini memungkinkan
     * kelas untuk membuat asumsi tentang keadaan internalnya.
     * 
     * Misalnya, ambil kelas ini yang mewakili suatu Sudut:
     * 
     * public class Angle {
     * 
     * private double angleInDegrees;
     * private double angleInRadians;
     * 
     * public static Angle angleFromDegrees(double degrees){
     * Angle a = new Angle();
     * a.angleInDegrees = degrees;
     * a.angleInRadians = Math.PI*degrees/180;
     * return a;
     * }
     * 
     * public static Angle angleFromRadians(double radians){
     * Angle a = new Angle();
     * a.angleInRadians = radians;
     * a.angleInDegrees = radians*180/Math.PI;
     * return a;
     * }
     * 
     * public double getDegrees(){
     * return angleInDegrees;
     * }
     * 
     * public double getRadians(){
     * return angleInRadians;
     * }
     * 
     * public void setDegrees(double degrees){
     * this.angleInDegrees = degrees;
     * this.angleInRadians = Math.PI*degrees/180;
     * }
     * 
     * public void setRadians(double radians){
     * this.angleInRadians = radians;
     * this.angleInDegrees = radians*180/Math.PI;
     * }
     * private Angle(){}
     * }
     * 
     */

    /*
     * Kelas ini bergantung pada asumsi dasar (atau invarian): angleInDegrees dan
     * angleInRadians selalu sync. Jika anggota kelasnya adalah publik, tidak ada
     * jaminan bahwa kedua representasi sudut tersebut berkorelasi.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -------------------
        // Membuat objek Angle dari sudut dalam derajat
        Angle angleDegrees = Angle.angleFromDegrees(90);

        // Mendapatkan nilai sudut dalam derajat dan radian
        System.out.println("Sudut dalam derajat: " + angleDegrees.getDegrees());
        System.out.println("Sudut dalam radian: " + angleDegrees.getRadians());
        /*
         * output:
         * Sudut dalam derajat: 90.0
         * Sudut dalam radian: 1.5707963267948966
         */

        // Mengatur nilai sudut dalam radian
        angleDegrees.setRadians(Math.PI / 2);

        // Mendapatkan nilai sudut setelah diubah dalam radian dan derajat
        System.out.println("Sudut setelah diubah dalam radian: " + angleDegrees.getRadians());
        System.out.println("Sudut setelah diubah dalam derajat: " + angleDegrees.getDegrees());

        /*
         * output:
         * Sudut setelah diubah dalam radian: 1.5707963267948966
         * Sudut setelah diubah dalam derajat: 90.0
         */
    }
}
