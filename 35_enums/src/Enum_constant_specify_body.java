public class Enum_constant_specify_body {
    // Enum constant specific body / Enum benda spesifik yang konstan

    /*
     * Dalam enum dimungkinkan untuk mendefinisikan perilaku spesifik untuk
     * konstanta tertentu dari enum yang mengesampingkan perilaku default enum,
     * teknik ini dikenal sebagai konstanta badan spesifik.
     * 
     * Misalkan tiga siswa piano - John, Ben dan Luke - didefinisikan dalam enum
     * bernama PianoClass, sebagai berikut:
     */

    enum PianoClass {
        JOHN, BEN, LUKE;

        public String getSex() {
            return "Male";
        }

        public String getLevel() {
            return "Beginner";
        }
    }

    /*
     * Dan suatu hari datanglah dua siswa lainnya - Rita dan Tom - dengan jenis
     * kelamin (Wanita) dan level (Menengah) yang tidak sesuai dengan yang
     * sebelumnya:
     */

    enum PianoClass2 {
        JOHN, BEN, LUKE, RITA, TOM;

        public String getSex() {
            return "Male"; // issue, Rita is a female
        }

        public String getLevel() {
            return "Beginner"; // issue, Tom is an intermediate student
        }
    }

    /*
     * sehingga sekadar menambahkan siswa baru ke dalam deklarasi konstanta, sebagai
     * berikut, tidaklah benar:
     */

    public static void main(String[] args) {
        // PianoClass2 tom = PianoClass2.TOM;
        // PianoClass2 rita = PianoClass2.RITA;
        // System.out.println(tom.getLevel());
        // prints Beginner -> wrong Tom's not a beginner

        // System.out.println(rita.getSex());
        // prints Male -> wrong Rita's not a male

        // --------------
        // dan sekarang level Tom dan jenis kelamin Rita sudah sebagaimana mestinya:
        // PianoClass3 tom2 = PianoClass3.TOM;
        // PianoClass3 rita2 = PianoClass3.RITA;
        // System.out.println(tom2.getLevel()); // prints Intermediate
        // System.out.println(rita2.getSex()); // prints Female
        // ------------
        // dan penggunaan:
        Friend mat = Friend.MAT;
        Friend john = Friend.JOHN;
        Friend jane = Friend.JANE;
        System.out.println(mat.getGender()); // Male
        System.out.println(john.getGender()); // Male
        System.out.println(jane.getGender()); // Female
    }

    /*
     * Dimungkinkan untuk menentukan perilaku spesifik untuk masing-masing
     * konstanta, Rita dan Tom, yang mengesampingkan perilaku default PianoClass2
     * sebagai berikut:
     */
    enum PianoClass3 {
        JOHN, BEN, LUKE, RITA {
            @Override
            public String getSex() {
                return "Female";
            }
        },
        TOM {
            @Override
            public String getLevel() {
                return "Intermediate";
            }
        };

        public String getSex() {
            return "Male";
        }

        public String getLevel() {
            return "Beginner";
        }
    }

    /*
     * Cara lain untuk mendefinisikan isi konten tertentu adalah dengan menggunakan
     * konstruktor, misalnya:
     */

    enum Friend {
        MAT("Male"), JOHN("Male"), JANE("Female");

        private String gender;

        Friend(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return this.gender;
        }
    }

}
