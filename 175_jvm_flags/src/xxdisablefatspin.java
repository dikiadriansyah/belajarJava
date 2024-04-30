public class xxdisablefatspin {
    // -XXdisableFatSpin

    /*
     * Opsi ini menonaktifkan kode putaran kunci lemak di Java, memungkinkan thread
     * yang memblokir upaya mendapatkan kunci lemak masuk ke mode tidur
     * secara langsung.
     * 
     * Objek di Java menjadi kunci segera setelah thread apa pun memasuki blok
     * tersinkronisasi pada objek tersebut. Semua kunci ditahan
     * (yaitu, tetap terkunci) sampai benang pengunci dilepaskan. Jika kunci tidak
     * mau dilepaskan dengan cepat, maka kunci tersebut dapat dipompa menjadi
     * “gembok tebal”. “Pemintalan” terjadi ketika benang yang menginginkan kunci
     * tertentu secara terus-menerus memeriksa kunci tersebut untuk melihat apakah
     * benang tersebut masih diambil, berputar dalam putaran yang ketat saat
     * melakukan pemeriksaan. Memutar melawan kunci yang gemuk umumnya bermanfaat
     * meskipun, dalam beberapa kasus, hal ini bisa mahal dan mungkin mempengaruhi
     * kinerja. -XXdisableFatSpin memungkinkan Anda mematikan putaran terhadap kunci
     * lemak dan menghilangkan potensi kinerja yang buruk.
     */

    // penggunaan
    // -XXdisableFatSpin

}
