import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class localtime {
    public static void main(String[] args) {
        // Untuk menggunakan hanya bagian time dari date, gunakan LocalTime. Anda
        // dapat membuat instance objek LocalTime dengan beberapa cara
        // LocalTime lt = LocalTime.now();
        // System.out.println(lt); // 22:24:50.535
        // lt = LocalTime.MIDNIGHT;
        // System.out.println(lt); // 00:00

        // lt = LocalTime.NOON;
        // System.out.println(lt); // 12:00

        // lt = LocalTime.of(12, 12, 45);

        // LocalTime juga memiliki metode toString bawaan yang menampilkan format dengan
        // sangat baik.

        // System.out.println(lt); // 12:12:45

        // Anda juga bisa mendapatkan, menambah dan mengurangi hours, minutes, seconds,
        // dan nanoseconds dari objek LocalTime yaitu
        // lt.plusMinutes(1);
        // System.out.println(lt); // 22:25:50.535
        // lt.getMinutes();
        // lt.minusMinutes(1);
        // System.out.println(lt); // 22:24:50.535

        // Anda dapat mengubahnya menjadi objek Tanggal dengan kode berikut:
        LocalTime LT = LocalTime.now();
        int A_YEAR = 2023;
        int A_MONTH = 7;
        int A_DAY = 1;

        Instant ins = LT.atDate(LocalDate.of(A_YEAR, A_MONTH, A_DAY)).atZone(ZoneId.systemDefault()).toInstant();
        Date t = Date.from(ins);
        System.out.println(t); // Sat Jul 01 22:40:39 ICT 2023

        // kelas ini bekerja dengan sangat baik dalam kelas pengatur waktu untuk
        // mensimulasikan jam alarm

    }
}
