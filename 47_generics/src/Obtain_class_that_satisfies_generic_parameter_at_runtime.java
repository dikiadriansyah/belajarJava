import java.util.ArrayList;
import java.util.List;

// subkelas secara definitif mengikat parameterisasi ke Pengguna untuk semua instance kelas ini, sehingga informasi dapat dipulihkan saat runtime
// UserService class
class UserService extends DataService<User> {
    public UserService() {
        super(User.class);
    }
}

public class Obtain_class_that_satisfies_generic_parameter_at_runtime {
    // Obtain class that satisfies generic parameter at runtime / Dapatkan kelas
    // yang memenuhi parameter generik saat runtime

    /*
     * Banyak parameter generik yang tidak terikat, seperti yang digunakan dalam
     * metode statis, tidak dapat dipulihkan saat runtime (lihat Thread Lain tentang
     * Penghapusan). Namun ada strategi umum yang digunakan untuk mengakses tipe
     * yang memuaskan generik parameter pada kelas saat runtime. Hal ini
     * memungkinkan kode generik yang
     * bergantung pada akses mengetik tanpa harus memasukkan informasi tipe melalui
     * setiap panggilan.
     */

    // Latar belakang
    /*
     * Parameterisasi umum pada suatu kelas dapat diperiksa dengan membuat kelas
     * dalam anonim. Kelas ini akan menangkap informasi tipe. Secara umum mekanisme
     * ini disebut sebagai token tipe super, yang dirinci dalam postingan blog Neal
     * Gafter
     */

    // Implementasi
    // Tiga implementasi umum di Java adalah:
    /*
     * Guava's TypeToken
     * Spring's ParameterizedTypeRefence
     * Jakson's TypeReference
     */
    public static void main(String[] args) {
        UserService service = new UserService();
        List<User> users = service.getAll();

        // Display retrieved users
        for (User user : users) {
            System.out.println(user);
        }
    }
}
