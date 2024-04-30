public class Key_and_key_management {
    // Keys and Key Management/Kunci dan Manajemen Kunci

    /*
     * Meskipun JCE mengamankan operasi kriptografi dan pembuatan kunci,
     * pengelolaannya sepenuhnya bergantung pada pengembang
     * kunci mereka. Informasi lebih lanjut perlu diberikan di sini.
     * 
     * Salah satu praktik terbaik yang diterima secara umum untuk menangani kunci
     * saat runtime adalah menyimpannya hanya sebagai array byte, dan tidak pernah
     * sebagai string. Hal ini karena string Java tidak dapat diubah, dan tidak
     * dapat "dihapus" atau "dihilangkan" secara manual di memori;
     * meskipun referensi ke sebuah string dapat dihapus, string yang sama akan
     * tetap berada di memori sampai segmen memorinya dikumpulkan dari sampah dan
     * digunakan kembali. Penyerang akan memiliki jendela besar di mana mereka dapat
     * membuang memori program dan dengan mudah menemukan kuncinya. Sebaliknya,
     * array byte dapat diubah, dan isinya dapat ditimpa
     * tempat; ada baiknya untuk 'menghilangkan' kunci Anda segera setelah Anda
     * tidak lagi membutuhkannya.
     */

}
