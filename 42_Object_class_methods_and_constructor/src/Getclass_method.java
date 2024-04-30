// public class Getclass_method extends User {
// getClass() method

// Metode getClass() dapat digunakan untuk menemukan tipe kelas runtime suatu
// objek. Lihat contoh di bawah ini:

// private String specificUserID;

// public Getclass_method(String specificUserID, long userID, String name) {
// super(userID, name);
// this.specificUserID = specificUserID;
// }

// public static void main(String[] args) {
// User user = new User(879745, "John");
// Getclass_method specificUser = new Getclass_method("1AAAA", 877777, "Jim");
// User anotherSpecificUser = new Getclass_method("1BBBB", 812345, "Jenny");

// System.out.println(user.getClass());
/*
 * output:
 * class User
 */

// System.out.println(specificUser.getClass());
/*
 * output:
 * class SpecificUser
 */

// System.out.println(anotherSpecificUser.getClass());
/*
 * output:
 * class SpecificUser
 */

/*
 * Metode getClass() akan mengembalikan tipe kelas paling spesifik, itulah
 * sebabnya getClass() dipanggil
 * anotherSpecificUser, nilai yang dikembalikan adalah kelas SpesifikUser karena
 * nilai tersebut lebih rendah pada pohon warisan daripada User.
 */

// Perlu dicatat bahwa, meskipun metode getClass dideklarasikan sebagai:
/*
 * public final native Class<?> getClass();
 * 
 * Tipe statis sebenarnya yang dikembalikan oleh panggilan ke getClass adalah
 * Class<? extends T> di mana T adalah tipe statis objek tempat getClass
 * dipanggil.
 * 
 * yaitu yang berikut ini akan dikompilasi:
 * Class<? extends String> cls = "".getClass();
 */

// }
// }
