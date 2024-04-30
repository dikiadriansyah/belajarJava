import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyDAO {
    // Dummy implementation for updating data in the database
    public static void update(Connection connection, MyVO myVO) throws SQLException {
        String sql = "UPDATE my_table SET name = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, myVO.getName());
            statement.setString(2, myVO.getId());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update record. No matching ID found.");
            }

            System.out.println("Record updated successfully.");
        }
    }
}
