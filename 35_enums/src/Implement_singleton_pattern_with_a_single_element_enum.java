public class Implement_singleton_pattern_with_a_single_element_enum {
    // Implement Singleton pattern with a singleelement enum / Menerapkan pola
    // Singleton dengan enum elemen tunggal

    /*
     * Konstanta enum dibuat ketika enum direferensikan untuk pertama kalinya. Oleh
     * karena itu, hal itu memungkinkan untuk diterapkan
     * Pola desain perangkat lunak singleton dengan enum elemen tunggal.
     */

    public enum Attendant {
        INSTANCE;

        private Attendant() {
            // perform some initialization routine
        }

        public void sayHello() {
            System.out.println("Hello!");
        }
    }

    public static void main(String[] args) {
        Attendant.INSTANCE.sayHello();// instantiated at this point

        /*
         * output:
         * Hello!
         */

        /*
         * Menurut buku "Effective Java" oleh Joshua Bloch, enum elemen tunggal adalah
         * cara terbaik untuk mengimplementasikan singleton.
         * Pendekatan ini memiliki keuntungan sebagai berikut:
         * 1. thread safety
         * 2. guarantee of single instantiation
         * 3. out-of-the-box serialization
         * 
         * Dan seperti yang ditunjukkan pada bagian mengimplementasikan antarmuka,
         * singleton ini mungkin juga mengimplementasikan satu atau lebih antarmuka.
         */
    }
}
