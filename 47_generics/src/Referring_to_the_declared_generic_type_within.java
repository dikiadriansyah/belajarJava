import java.util.*;

public class Referring_to_the_declared_generic_type_within {
    // Referring to the declared generic type within its own declaration / Mengacu
    // pada tipe generik yang dideklarasikan dalam deklarasinya sendiri

    /*
     * Bagaimana cara Anda menggunakan instance tipe generik yang diwarisi (mungkin
     * lebih jauh) dalam deklarasi metode dalam tipe generik itu sendiri yang
     * dideklarasikan? Ini adalah salah satu masalah yang akan Anda hadapi saat
     * menggali lebih dalam tentang obat generik, namun masih merupakan masalah yang
     * cukup umum.
     * 
     * Asumsikan kita memiliki tipe DataSeries<T> (antarmuka di sini), yang
     * mendefinisikan seri data generik yang berisi nilai
     * tipe T. Sulit untuk bekerja dengan tipe ini secara langsung ketika kita ingin
     * melakukan banyak operasi dengan mis.
     * nilai ganda, jadi kami mendefinisikan DoubleSeries memperluas
     * DataSeries<Double>. Sekarang asumsikan, DataSeries<T> asli
     * tipe memiliki metode add(values) yang menambahkan rangkaian lain dengan
     * panjang yang sama dan mengembalikan yang baru. Bagaimana kita menerapkan tipe
     * nilai dan tipe pengembalian menjadi DoubleSeries daripada DataSeries<Double>
     * di kelas turunan kita?
     * 
     * Masalahnya dapat diselesaikan dengan menambahkan parameter tipe generik yang
     * merujuk kembali dan memperluas tipe tersebut
     * dideklarasikan (diterapkan pada antarmuka di sini, tetapi hal yang sama
     * berlaku untuk kelas):
     * public interface DataSeries<T, DS extends DataSeries<T, DS>> {
     * DS add(DS values);
     * List<T> data();
     * }
     * 
     * Di sini T mewakili tipe data yang dimiliki seri tersebut, mis. Gandakan dan
     * DS seri itu sendiri. Tipe (atau tipe) yang diwarisi sekarang dapat dengan
     * mudah diimplementasikan dengan mengganti parameter yang disebutkan di atas
     * dengan tipe turunan yang sesuai, sehingga,
     * menghasilkan definisi bentuk berbasis ganda yang konkret:
     * public interface DoubleSeries extends DataSeries<Double, DoubleSeries> {
     * static DoubleSeries instance(Collection<Double> data) {
     * return new DoubleSeriesImpl(data);
     * }
     * }
     * 
     * Pada saat ini bahkan IDE akan mengimplementasikan antarmuka di atas dengan
     * tipe yang benar, yang, setelah sedikit pengisian konten, akan terlihat
     * seperti ini:
     * class DoubleSeriesImpl implements DoubleSeries {
     * private final List<Double> data;
     * DoubleSeriesImpl(Collection<Double> data) {
     * this.data = new ArrayList<>(data);
     * }
     * 
     * @Override
     * public DoubleSeries add(DoubleSeries values) {
     * List<Double> incoming = values != null ? values.data() : null;
     * if (incoming == null || incoming.size() != data.size()) {
     * throw new IllegalArgumentException("bad series");
     * }
     * List<Double> newdata = new ArrayList<>(data.size());
     * for (int i = 0; i < data.size(); i++) {
     * newdata.add(this.data.get(i) + incoming.get(i)); // beware autoboxing
     * }
     * return DoubleSeries.instance(newdata);
     * }
     * 
     * @Override
     * public List<Double> data() {
     * return Collections.unmodifiableList(data);
     * }
     * }
     * 
     * Seperti yang Anda lihat, metode penambahan dideklarasikan sebagai
     * DoubleSeries add(nilai DoubleSeries) dan kompilernya senang.
     * Polanya dapat disarangkan lebih lanjut jika diperlukan.
     */

    public static void main(String[] args) {
        // Example usage
        List<Double> data1 = List.of(1.0, 2.0, 3.0);
        List<Double> data2 = List.of(4.0, 5.0, 6.0);

        DoubleSeries series1 = DoubleSeries.instance(data1);
        DoubleSeries series2 = DoubleSeries.instance(data2);

        DoubleSeries result = series1.add(series2);

        System.out.println("Series 1: " + series1.data()); // Series 1: [1.0, 2.0, 3.0]
        System.out.println("Series 2: " + series2.data()); // Series 2: [4.0, 5.0, 6.0]
        System.out.println("Result: " + result.data()); // Result: [5.0, 7.0, 9.0]
    }
}
