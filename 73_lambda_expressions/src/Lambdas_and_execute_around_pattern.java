import java.sql.Connection;
import java.sql.SQLException;

interface DataProcessor {
    void process(Connection connection) throws SQLException;
}

public class Lambdas_and_execute_around_pattern {
    // Lambdas and Execute-around Pattern/Lambdas dan Pola Eksekusi-sekitar

    /*
     * Ada beberapa contoh bagus penggunaan lambda sebagai FunctionalInterface dalam
     * skenario sederhana. Kasus penggunaan yang cukup umum yang dapat ditingkatkan
     * dengan lambda adalah apa yang disebut pola Execute-Around. Dalam pola ini,
     * Anda memiliki sekumpulan kode penyiapan/pembongkaran standar yang diperlukan
     * untuk beberapa skenario seputar kode khusus kasus penggunaan. Beberapa contoh
     * umum dari hal ini adalah file io, database io, blok coba/tangkap.
     */

    /*
     * interface DataProcessor {
     * void process( Connection connection ) throws SQLException;;
     * }
     * public void doProcessing( DataProcessor processor ) throws SQLException{
     * try (Connection connection = DBUtil.getDatabaseConnection();) {
     * processor.process(connection);
     * connection.commit();
     * }
     * }
     */

    // Kemudian untuk memanggil metode ini dengan lambda mungkin terlihat seperti:
    /*
     * public static void updateMyDAO(MyVO vo) throws DatabaseException {
     * doProcessing((Connection conn) -> MyDAO.update(conn, ObjectMapper.map(vo)));
     * }
     */

    /*
     * Ini tidak terbatas pada operasi I/O. Hal ini dapat diterapkan pada skenario
     * apa pun di mana tugas pengaturan/penghancuran serupa dapat diterapkan dengan
     * sedikit variasi. Manfaat utama dari Pola ini adalah penggunaan kembali kode
     * dan penerapan KERING (Jangan Ulangi Sendiri).
     */

    public static void doProcessing(DataProcessor processor) throws SQLException {
        try (Connection connection = DBUtil.getDatabaseConnection()) {
            processor.process(connection);
            connection.commit();
        }
    }

    public static void updateMyDAO(MyVO vo) throws DatabaseException {
        try {
            doProcessing((Connection conn) -> MyDAO.update(conn, ObjectMapper.map(vo)));
        } catch (SQLException e) {
            throw new DatabaseException("Error updating MyDAO", e);
        }
    }

    public static void main(String[] args) {
        // Example usage
        MyVO myVO = new MyVO("1", "John Doe");

        try {
            updateMyDAO(myVO);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
