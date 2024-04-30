import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

public class Collect_elements_of_a_stream_into_a_collection {
    // Collect Elements of a Stream into a Collection / Kumpulkan Elemen Aliran ke
    // dalam Koleksi

    // Collect with toList() and toSet() / Kumpulkan dengan toList() dan toSet()
    /*
     * Elemen dari Stream dapat dengan mudah dikumpulkan ke dalam wadah dengan
     * menggunakan operasi Stream.collect:
     * System.out.println(Arrays
     * .asList("apple", "banana", "pear", "kiwi", "orange")
     * .stream()
     * .filter(s -> s.contains("a"))
     * .collect(Collectors.toList()));
     * // prints: [apple, banana, pear, orange]
     */

    /*
     * Contoh koleksi lainnya, seperti Set, dapat dibuat dengan menggunakan metode
     * bawaan Kolektor lainnya. Misalnya,
     * Collectors.toSet() mengumpulkan elemen Aliran ke dalam Set.
     */

    // Explicit control over the implementation of List or Set/Kontrol eksplisit
    // atas implementasi List atau Set

    /*
     * Menurut dokumentasi Collectors#toList() dan Collectors#toSet(), tidak ada
     * jaminan pada jenis, mutabilitas, serializabilitas, atau keamanan thread dari
     * List atau Set yang dikembalikan.
     * 
     * Agar kontrol eksplisit atas implementasi dikembalikan,
     * Collectors#toCollection(Supplier) dapat digunakan
     * sebaliknya, pemasok tertentu mengembalikan koleksi baru dan kosong.
     */

    /*
     * // syntax with method reference
     * System.out.println(strings
     * .stream()
     * .filter(s -> s != null && s.length() <= 3)
     * .collect(Collectors.toCollection(ArrayList::new))
     * );
     * // syntax with lambda
     * System.out.println(strings
     * .stream()
     * .filter(s -> s != null && s.length() <= 3)
     * .collect(Collectors.toCollection(() -> new LinkedHashSet<>()))
     * );
     */

    // Collecting Elements using toMap / Mengumpulkan Elemen menggunakan toMap
    /*
     * Kolektor mengumpulkan elemen ke dalam Map, Dimana kuncinya adalah Student Id
     * dan Nilai adalah Nilai Siswa.
     * 
     * List<Student> students = new ArrayList<Student>();
     * students.add(new Student(1,"test1"));
     * students.add(new Student(2,"test2"));
     * students.add(new Student(3,"test3"));
     * 
     * Map<Integer, String> IdToName = students.stream()
     * .collect(Collectors.toMap(Student::getId, Student::getName));
     * System.out.println(IdToName);
     */

    // output:
    // {1=test1, 2=test2, 3=test3}

    /*
     * Collectors.toMap memiliki implementasi lain Collector<T, ?, Map<K,U>>
     * toMap(Function<? super T, ? extends K> keyMapper, Fungsi<? super T, ?
     * extends U> valueMapper, BinaryOperator<U> mergeFunction).MergeFunction
     * sebagian besar digunakan untuk memilih nilai
     * baru atau mempertahankan nilai lama jika kunci diulangi saat menambahkan
     * anggota baru di Peta dari daftar.
     * 
     * mergeFunction sering terlihat seperti: (s1, s2) -> s1 untuk mempertahankan
     * nilai yang sesuai dengan kunci yang diulang, atau (s1, s2) -> s2 untuk
     * memberi nilai baru pada kunci yang diulang.
     */

    // Collecting Elements to Map of Collections / Mengumpulkan Elemen ke Peta
    // Koleksi

    // Contoh: dari ArrayList ke Map<String, List<>>

    /*
     * Seringkali diperlukan pembuatan peta daftar dari daftar utama. Contoh: Dari
     * siswa yang mendaftar, kita perlu membuat peta daftar mata pelajaran untuk
     * setiap siswa.
     * 
     * List<Student> list = new ArrayList<>();
     * list.add(new Student("Davis", SUBJECT.MATH, 35.0));
     * list.add(new Student("Davis", SUBJECT.SCIENCE, 12.9));
     * list.add(new Student("Davis", SUBJECT.GEOGRAPHY, 37.0));
     * list.add(new Student("Sascha", SUBJECT.ENGLISH, 85.0));
     * list.add(new Student("Sascha", SUBJECT.MATH, 80.0));
     * list.add(new Student("Sascha", SUBJECT.SCIENCE, 12.0));
     * list.add(new Student("Sascha", SUBJECT.LITERATURE, 50.0));
     * list.add(new Student("Robert", SUBJECT.LITERATURE, 12.0));
     * 
     * Map<String, List<SUBJECT>> map = new HashMap<>();
     * list.stream().forEach(s -> {
     * map.computeIfAbsent(s.getName(), x -> new ArrayList<>()).add(s.getSubject());
     * });
     * System.out.println(map);
     */

    // Keluaran:
    /*
     * { Robert=[LITERATURE],
     * Sascha=[ENGLISH, MATH, SCIENCE, LITERATURE],
     * Davis=[MATH, SCIENCE, GEOGRAPHY] }
     * 
     */

    // Contoh dari ArrayList to Map<String, Map<>>

    /*
     * List<Student> list = new ArrayList<>();
     * list.add(new Student("Davis", SUBJECT.MATH, 1, 35.0));
     * list.add(new Student("Davis", SUBJECT.SCIENCE, 2, 12.9));
     * list.add(new Student("Davis", SUBJECT.MATH, 3, 37.0));
     * list.add(new Student("Davis", SUBJECT.SCIENCE, 4, 37.0));
     * list.add(new Student("Sascha", SUBJECT.ENGLISH, 5, 85.0));
     * list.add(new Student("Sascha", SUBJECT.MATH, 1, 80.0));
     * list.add(new Student("Sascha", SUBJECT.ENGLISH, 6, 12.0));
     * list.add(new Student("Sascha", SUBJECT.MATH, 3, 50.0));
     * list.add(new Student("Robert", SUBJECT.ENGLISH, 5, 12.0));
     * Map<String, Map<SUBJECT, List<Double>>> map = new HashMap<>();
     * list.stream().forEach(student -> {
     * map.computeIfAbsent(student.getName(), s -> new HashMap<>())
     * .computeIfAbsent(student.getSubject(), s -> new ArrayList<>())
     * .add(student.getMarks());
     * });
     * System.out.println(map);
     */

    // Keluaran:

    /*
     * { Robert={ENGLISH=[12.0]},
     * Sascha={MATH=[80.0, 50.0], ENGLISH=[85.0, 12.0]},
     * Davis={MATH=[35.0, 37.0], SCIENCE=[12.9, 37.0]} }
     */

    // Contekan

    // Tujuan
    /*
     * Collect to a List
     * Collect to an ArrayList with preallocated size
     * Collect to a Set
     * Collect to a Set with better iteration
     * performance
     * Collect to a case-insensitive
     * Set<String>
     * Collect to an EnumSet<AnEnum> (best
     * performance for enums)
     * Collect to a Map<K,V> with unique keys
     * Map MyObject.getter() to unique
     * MyObject
     * Map MyObject.getter() to multiple
     * MyObjects
     * 
     * 
     */

    /*
     * kode
     * Collectors.toList()
     * Collectors.toCollection(() -> new ArrayList<>(size))
     * Collectors.toSet()
     * Collectors.toCollection(() -> new LinkedHashSet<>())
     * Collectors.toCollection(() -> new
     * TreeSet<>(String.CASE_INSENSITIVE_ORDER))
     * Collectors.toCollection(() -> EnumSet.noneOf(AnEnum.class))
     * Collectors.toMap(keyFunc,valFunc)
     * Collectors.toMap(MyObject::getter, Function.identity())
     * Collectors.groupingBy(MyObject::getter)
     */

    public static void main(String[] args) {
        // System.out.println(Arrays
        // .asList("apple", "banana", "pear", "kiwi", "orange")
        // .stream()
        // .filter(s -> s.contains("a"))
        // .collect(Collectors.toList()));
        // prints: [apple, banana, pear, orange]

        // -----------------------
        // List<String> strings = new ArrayList<>(Arrays.asList("one", "two", "three",
        // null, "four", "five", "six", null));

        // Collect to ArrayList with method reference
        // ArrayList<String> resultArrayList = strings
        // .stream()
        // .filter(s -> s != null && s.length() <= 3)
        // .collect(Collectors.toCollection(ArrayList::new));

        // System.out.println("Result with ArrayList: " + resultArrayList);
        /*
         * output:
         * Result with ArrayList: [one, two, six]
         */

        // Collect to LinkedHashSet with lambda expression
        // LinkedHashSet<String> resultSet = strings
        // .stream()
        // .filter(s -> s != null && s.length() <= 3)
        // .collect(Collectors.toCollection(() -> new LinkedHashSet<>()));

        // System.out.println("Result with LinkedHashSet: " + resultSet);
        /*
         * output:
         * Result with LinkedHashSet: [one, two, six]
         */

        // -----------------------
        // List<Student> students = new ArrayList<Student>();
        // students.add(new Student(1, "test1"));
        // students.add(new Student(2, "test2"));
        // students.add(new Student(3, "test3"));

        // Map<Integer, String> IdToName = students.stream()
        // .collect(Collectors.toMap(Student::getId, Student::getName));
        // System.out.println(IdToName);

        /*
         * output:
         * {1=test1, 2=test2, 3=test3}
         */
        // ---------------------------
        // List<Student> list = new ArrayList<>();
        // list.add(new Student("Davis", SUBJECT.MATH, 35.0));
        // list.add(new Student("Davis", SUBJECT.SCIENCE, 12.9));
        // list.add(new Student("Davis", SUBJECT.GEOGRAPHY, 37.0));
        // list.add(new Student("Sascha", SUBJECT.ENGLISH, 85.0));
        // list.add(new Student("Sascha", SUBJECT.MATH, 80.0));
        // list.add(new Student("Sascha", SUBJECT.SCIENCE, 12.0));
        // list.add(new Student("Sascha", SUBJECT.LITERATURE, 50.0));
        // list.add(new Student("Robert", SUBJECT.LITERATURE, 12.0));

        // Map<String, List<SUBJECT>> map = new HashMap<>();
        // list.stream().forEach(s -> {
        // map.computeIfAbsent(s.getName(), x -> new ArrayList<>()).add(s.getSubject());
        // });
        // System.out.println(map);
        /*
         * output:
         * {Robert=[LITERATURE], Sascha=[ENGLISH, MATH, SCIENCE, LITERATURE],
         * Davis=[MATH, SCIENCE, GEOGRAPHY]}
         */

        // ---------------------------
        List<Collect_elements_of_a_stream_into_a_collection> list = new ArrayList<>();
        list.add(new Collect_elements_of_a_stream_into_a_collection("Davis", SUBJECT.MATH, 1, 35.0));
        list.add(new Collect_elements_of_a_stream_into_a_collection("Davis", SUBJECT.SCIENCE, 2, 12.9));
        list.add(new Collect_elements_of_a_stream_into_a_collection("Davis", SUBJECT.MATH, 3, 37.0));
        list.add(new Collect_elements_of_a_stream_into_a_collection("Davis", SUBJECT.SCIENCE, 4, 37.0));
        list.add(new Collect_elements_of_a_stream_into_a_collection("Sascha", SUBJECT.ENGLISH, 5, 85.0));
        list.add(new Collect_elements_of_a_stream_into_a_collection("Sascha", SUBJECT.MATH, 1, 80.0));
        list.add(new Collect_elements_of_a_stream_into_a_collection("Sascha", SUBJECT.ENGLISH, 6, 12.0));
        list.add(new Collect_elements_of_a_stream_into_a_collection("Sascha", SUBJECT.MATH, 3, 50.0));
        list.add(new Collect_elements_of_a_stream_into_a_collection("Robert", SUBJECT.ENGLISH, 5, 12.0));
        Map<String, Map<SUBJECT, List<Double>>> map = new HashMap<>();
        list.stream().forEach(student -> {
            map.computeIfAbsent(student.getName(), s -> new HashMap<>())
                    .computeIfAbsent(student.getSubject(), s -> new ArrayList<>())
                    .add(student.getMarks());
        });
        System.out.println(map);
        /*
         * output:
         * {Robert={ENGLISH=[12.0]}, Sascha={MATH=[80.0, 50.0], ENGLISH=[85.0, 12.0]},
         * Davis={SCIENCE=[12.9, 37.0], MATH=[35.0, 37.0]}}
         */

    }

    enum SUBJECT {
        MATH, SCIENCE, ENGLISH
    }

    private String name;
    private SUBJECT subject;
    private int id;
    private double marks;

    public Collect_elements_of_a_stream_into_a_collection(String name, SUBJECT subject, int id, double marks) {
        this.name = name;
        this.subject = subject;
        this.id = id;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public SUBJECT getSubject() {
        return subject;
    }

    public double getMarks() {
        return marks;
    }
}
