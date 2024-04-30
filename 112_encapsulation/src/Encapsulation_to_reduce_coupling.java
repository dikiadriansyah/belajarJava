public class Encapsulation_to_reduce_coupling {
    // Encapsulation to reduce coupling/Enkapsulasi untuk mengurangi kopling

    /*
     * Enkapsulasi memungkinkan Anda membuat perubahan internal pada suatu kelas
     * tanpa memengaruhi kode apa pun yang memanggil kelas tersebut. Hal ini
     * mengurangi kopling, atau seberapa besar suatu kelas bergantung pada
     * implementasi kelas lain.
     * 
     * Sebagai contoh, mari kita ubah implementasi kelas Angle dari contoh
     * sebelumnya:
     * 
     * public class Angle {
     * 
     * private double angleInDegrees;
     * 
     * public static Angle angleFromDegrees(double degrees){
     * Angle a = new Angle();
     * a.angleInDegrees = degrees;
     * return a;
     * }
     * 
     * public static Angle angleFromRadians(double radians){
     * Angle a = new Angle();
     * a.angleInDegrees = radians*180/Math.PI;
     * return a;
     * }
     * 
     * public double getDegrees(){
     * return angleInDegrees;
     * }
     * 
     * public double getRadians(){
     * return angleInDegrees*Math.PI / 180;
     * }
     * 
     * public void setDegrees(double degrees){
     * this.angleInDegrees = degrees;
     * }
     * 
     * public void setRadians(double radians){
     * this.angleInDegrees = radians*180/Math.PI;
     * }
     * private Angle(){}
     * }
     */

    /*
     * Implementasi kelas ini telah diubah sehingga hanya menyimpan satu
     * representasi sudut dan menghitung sudut lainnya bila diperlukan.
     * 
     * Namun, implementasinya berubah, tetapi antarmukanya tidak. Jika kelas
     * pemanggil mengandalkan akses
     * metode angleInRadians, itu perlu diubah untuk menggunakan Angle versi baru.
     * Memanggil kelas tidak seharusnya mempedulikan representasi internal suatu
     * kelas.
     */

    public static void main(String[] args) throws Exception {
        // Membuat sudut dalam derajat
        Angle2 angleInDegrees = Angle2.angleFromDegrees(90);
        System.out.println("Sudut dalam derajat: " + angleInDegrees.getDegrees());
        System.out.println("Sudut dalam radian: " + angleInDegrees.getRadians());
        /*
         * output:
         * Sudut dalam derajat: 90.0
         * Sudut dalam radian: 1.5707963267948966
         */

        // Mengatur sudut dalam radian
        angleInDegrees.setRadians(Math.PI);
        System.out.println("Sudut dalam derajat setelah diatur dalam radian: " + angleInDegrees.getDegrees());
        System.out.println("Sudut dalam radian setelah diatur dalam radian: " + angleInDegrees.getRadians());
        /*
         * output:
         * Sudut dalam derajat setelah diatur dalam radian: 180.0
         * Sudut dalam radian setelah diatur dalam radian: 3.141592653589793
         */

        // Membuat sudut dalam radian
        Angle2 angleInRadians = Angle2.angleFromRadians(Math.PI / 2);
        System.out.println("Sudut dalam derajat: " + angleInRadians.getDegrees());
        System.out.println("Sudut dalam radian: " + angleInRadians.getRadians());
        /*
         * output:
         * Sudut dalam derajat: 90.0
         * Sudut dalam radian: 1.5707963267948966
         */

        // Mengatur sudut dalam derajat
        angleInRadians.setDegrees(180);
        System.out.println("Sudut dalam derajat setelah diatur dalam derajat: " + angleInRadians.getDegrees());
        System.out.println("Sudut dalam radian setelah diatur dalam derajat: " + angleInRadians.getRadians());
        /*
         * output:
         * Sudut dalam derajat setelah diatur dalam derajat: 180.0
         * Sudut dalam radian setelah diatur dalam derajat: 3.141592653589793
         */
    }
}
