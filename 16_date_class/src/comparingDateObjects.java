import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class comparingDateObjects {
    public static void main(String[] args) {
        // Calendar, Date, and LocalDate
        // Version < Java SE 8
        // before, after, compareTo and equals methods

        // Use of Calendar and Date Objects
        final Date t = new Date();
        final Calendar c = Calendar.getInstance();
        c.set(2023, Calendar.JULY, 1, 10, 0, 0);
        Date b = c.getTime();
        // System.out.println(b); // Sat Jul 01 10:00:00 ICT 2023

        final Calendar c2 = Calendar.getInstance();
        c2.set(2023, Calendar.JULY, 1, 10, 0, 0);
        Date sbd = c2.getTime();

        // Before example
        // System.out.printf("adalah %1$tF before %2$tF? %3$b%n", t, b,
        // Boolean.valueOf(t.before(b)));
        // adalah 2023-07-02 before 2023-07-01? false

        // System.out.printf("adalah %1$tF before %1$tF? %3$b%n", t, t,
        // Boolean.valueOf(t.before(t)));
        // adalah 2023-07-02 before 2023-07-02? false

        // System.out.printf("adalah %2$tF before %1$tF? %3$b%n", t, b,
        // Boolean.valueOf(b.before(t)));
        // adalah 2023-07-01 before 2023-07-02? true

        // after example
        // System.out.printf("adalah %1$tF after %2$tF? %3$b%n", t, b,
        // Boolean.valueOf(t.after(b)));
        // adalah 2023-07-02 after 2023-07-01? true

        // System.out.printf("adalah %1$tF after %1$tF? %3$b%n", t, b,
        // Boolean.valueOf(t.after(t)));
        // adalah 2023-07-02 after 2023-07-02? false

        // System.out.printf("adalah %2$tF after %1$tF? %3$b%n", t, b,
        // Boolean.valueOf(b.after(t)));
        // adalah 2023-07-01 after 2023-07-02? false

        // Compare example
        // System.out.printf("Perbandingan %1$tF menjadi %2$tF: %3$d%n", t, b,
        // Integer.valueOf(t.compareTo(b)));
        // Perbandingan 2023-07-02 menjadi 2023-07-01: 1

        // System.out.printf("Perbandingan %1$tF menjadi %1$tF: %3$d%n", t, b,
        // Integer.valueOf(t.compareTo(t)));
        // Perbandingan 2023-07-02 menjadi 2023-07-02: 0

        // System.out.printf("Perbandingan %2$tF menjadi %1$tF: %3$d%n", t, b,
        // Integer.valueOf(b.compareTo(t)));
        // Perbandingan 2023-07-01 menjadi 2023-07-02: -1

        // Equal example
        // System.out.printf("adalah %1$tF sama dengan %2$tF? %3$b%n", t, b,
        // Boolean.valueOf(t.equals(b)));
        // adalah 2023-07-02 sama dengan 2023-07-01? false

        // System.out.printf("adalah %1$tF sama dengan %2$tF %3$b%n", b, sbd,
        // Boolean.valueOf(b.equals(sbd)));
        // adalah 2023-07-01 sama dengan 2023-07-01 false

        // System.out.printf("Karena b.getTime() -> %1$d adalah berbeda dari
        // sbd.getTime() -> %2$d, ada milidetik!%n",
        // Long.valueOf(b.getTime()), Long.valueOf(sbd.getTime()));
        // Karena b.getTime() -> 1688180400242 adalah berbeda dari sbd.getTime() ->
        // 1688180400272, ada milidetik!

        // Clear ms dari calendars
        c.clear(Calendar.MILLISECOND);
        c2.clear(Calendar.MILLISECOND);
        b = c.getTime();
        sbd = c2.getTime();

        // System.out.printf("adalah %1$tF sama dengan %2$tF setelah membersihkan ms?
        // %3$b%n", b, sbd,
        // Boolean.valueOf(b.equals(sbd)));
        // adalah 2023-07-01 sama dengan 2023-07-01 setelah membersihkan ms? true

        // versi >= Java SE 8
        // isBefore, isAfter, CompareTo dan equals method

        // gunakan LocalDate
        final LocalDate n = LocalDate.now();
        final LocalDate b2 = LocalDate.of(2023, 7, 1);
        final LocalDate b3 = LocalDate.of(2023, 7, 1);

        // Hours, minutes, second and nanoOfsecond can also be configured with an other
        // class LocalDateTime
        // LocalDateTime.of(year, month, dayOfMonth, hour, minute, second,
        // nanoOfSecond);

        // isBefore example
        // System.out.printf("adalah %1$tF before %2$tF? %3$b%n", n, b2,
        // Boolean.valueOf(n.isBefore(b2)));
        // output:
        // adalah 2023-07-02 before 2023-07-01? false

        // System.out.printf("adalah %1$tF before %1$tF? %3$b%n", n, b2,
        // Boolean.valueOf(n.isBefore(n)));
        // adalah 2023-07-02 before 2023-07-02? false

        // System.out.printf("adalah %2$tF before %1$tF? %3$b%n", n, b2,
        // Boolean.valueOf(b2.isBefore(n)));
        // adalah 2023-07-01 before 2023-07-02? true

        // isAfter example
        // System.out.printf("adalah %1$tF after %2$tF? %3$b%n", n, b2,
        // Boolean.valueOf(n.isAfter(b2)));
        // output:
        // adalah 2023-07-02 after 2023-07-01? true

        // System.out.printf("adalah %1$tF after %1$tF? %3$b%n", n, b2,
        // Boolean.valueOf(n.isAfter(n)));
        // adalah 2023-07-02 after 2023-07-02? false

        // System.out.printf("adalah %2$tF after %1$tF? %3$b%n", n, b2,
        // Boolean.valueOf(b2.isAfter(n)));
        // adalah 2023-07-01 after 2023-07-02? false

        // compareTo example
        // System.out.printf("perbandingan %1$tF menjadi %2$tF %3$d%n", n, b2,
        // Integer.valueOf(n.compareTo(b2)));
        // perbandingan 2023-07-02 menjadi 2023-07-01 1

        // System.out.printf("perbandingan %1$tF menjadi %1$tF %3$d%n", n, b2,
        // Integer.valueOf(n.compareTo(n)));
        // perbandingan 2023-07-02 menjadi 2023-07-02 0

        // System.out.printf("perbandingan %2$tF menjadi %1$tF %3$d%n ", n, b2,
        // Integer.valueOf(b2.compareTo(n)));
        // perbandingan 2023-07-01 menjadi 2023-07-02 -1

        // equals example
        // System.out.printf("adalah %1$tF sama dengan %2$tF? %3$b%n", n, b2,
        // Boolean.valueOf(n.equals(b2)));
        // adalah 2023-07-02 sama dengan 2023-07-01? false

        // System.out.printf("adalah %1$tF menjadi %2$tF? %3$b%n", b2, b3,
        // Boolean.valueOf(b2.equals(b3)));
        // adalah 2023-07-01 menjadi 2023-07-01? true

        // isEqual example
        // System.out.printf("adalah %1$tF sama dengan %2$tF? %3$b%n", n, b2,
        // Boolean.valueOf(n.isEqual(b2)));
        // adalah 2023-07-02 sama dengan 2023-07-01? false

        // System.out.printf("adalah %1$tF sama dengan %2$tF? %3$b%n", b2, b3,
        // Boolean.valueOf(b2.isEqual(b3)));
        // adalah 2023-07-01 sama dengan 2023-07-01? true

        // Date comparison before java 8
        // Sebelum Java 8, tanggal dapat dibandingkan menggunakan kelas
        // java.util.Calendar dan java.util.Date. Kelas tanggal menawarkan 4 metode
        // untuk membandingkan tanggal :
        // after(Date when)
        // before(Date when)
        // compareTo(Date anotherDate)
        // equals(Object obj)

        // after, before, compareTo and equals membandingkan nilai yg dikembalikan oleh
        // metode getTime() untuk setiap tanggal.

        // compareTo method mengembalikan positive integer.
        // Nilai lebih besar dari 0 : saat Date setelah argumen Date.
        // Nilai lebih besar dari 0 : saat Date sebelum argumen Date.
        // Nilai sama dengan 0 : saat Date sama dengan argumen Date

        // equals result dapat mengejutkan seperti yang ditunjukkan pada contoh
        // karena nilai, seperti milliseconds, tidak diinisialisasi dengan
        // nilai yang sama jika tidak diberikan secara eksplisit.

        // sejak java 8
        // dengan java 8 , new object untuk bekerja dengan Date tersedia
        // java.time.LocalDate. LocalDate mengimplementasikan ChronoLocalDate,
        // representasi abstrak tanggal dimana Chronology, atau calendar system, dapat
        // dipasang.

        // Untuk mendapatkan ketepatan waktu tanggal, Object java.time.LocalDateTime
        // harus digunakan. LocalDate dan LocalDateTime menggunakan nama metode yang
        // sama untuk membandingkan.

        // membandingkan dates menggunakan LocalDate berbeda dengan menggunakan
        // ChronoLocalDate karena chronology, atau calendar system tidak diperhitungkan
        // yg pertama.

        // Karena sebagian besar aplikasi harus menggunakan LocalDate, ChronoLocalDate
        // tidak disertakan dalam contoh. Bacaan lebih lanjut di sini.

        // Sebagian besar aplikasi harus mendeklarasikan metode signature, fields,
        // dan variabel sebagai LocalDate, bukan [ChronoLocalDate] interface ini.

        // LocalDate memiliki 5 metode untuk membandingkan tanggal:
        // isAfter(ChronoLocalDate other)
        // isBefore(ChronoLocalDate other)
        // isEqual(ChronoLocalDate other)
        // compareTo(ChronoLocalDate other)
        // equals(Object obj)

        // Dalam kasus parameter LocalDate, isAfter, isBefore, isEqual, equals dan
        // compareTo sekarang gunakan metode ini:
        // int compareTo0(LocalDate otherDate){
        // int cmp = (year - otherDate.year);
        // if(cmp == 0){
        // cmp = (month - otherDate.month);
        // if(cmp == 0){
        // cmp = (day - otherDate.day);
        // }
        // }
        // return cmp;
        // }
        // equals method periksa apakah referensi parameter sama dengan tanggal terlebih
        // dahulu sedangkan isEqual langsung memanggil compareTo0

        // Dalam kasus instance kelas ChronoLocalDate lainnya, tanggal dibandingkan
        // menggunakan Hari Epoch. Hari Zaman
        // count adalah hitungan hari yang bertambah sederhana di mana hari 0 adalah
        // 1970-01-01 (ISO).
    }
}
