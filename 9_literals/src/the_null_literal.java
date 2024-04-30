public class the_null_literal {
    // The Null literal / Null literal

    // Null literal (ditulis sebagai null) mewakili satu-satunya nilai dari tipe
    // null. Berikut beberapa contohnya
    public static void main(String[] args) {

        the_null_literal object = null;
        the_null_literal[] objects = new the_null_literal[] {
                new the_null_literal(), null, new the_null_literal()
        };
        // myMethod(null);
        // if (objects != null) {
        // Do something
        // }

        System.out.println(objects);
        // hasil:
        // null

        // Tipe null agak tidak biasa. itu tidak memiliki name, jadi anda tidak dapat
        // mengungkapkannya dalam kode sumber java. (Dan tidak memiliki runtime
        // representasi juga.)

        // Satu-satunya tujuan dari tipe null adalah menjadi tipe null. ini adalah
        // penugasan yang kompatibel dengan semua jenis referensi, dan dapat berupa tipe
        // cast ke tipe referensi apapun. (dalam kasus terakhir, pemeran tidak
        // memerlukan pemeriksaan runtime)

        // akhirnya, null memiliki properti yang null instanceof <SomeReferenceType>
        // akan mengevaluasi ke false, apapun yang terjadi jenisnya

    }

}
