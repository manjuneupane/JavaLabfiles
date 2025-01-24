import java.sql.*;

public class InsertExample {
    static final String URL = "jdbc:mysql://localhost:3306/manjudb";
    static final String USER = "root";
    static final String PASS = "manju123@manju";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Insert query
            String query = "INSERT INTO CUSTOMER (ID, NAME, AGE, ADDRESS, SALARY) VALUES (?, ?, ?, ?, ?)";
            psmt = conn.prepareStatement(query);

            // Set parameters for the prepared statement
            psmt.setInt(1, 1); // ID
            psmt.setString(2, "Manju"); // Name
            psmt.setInt(3, 20); // Age
            psmt.setString(4, "Butwal"); // Address
            psmt.setDouble(5, 20000.0); // Salary

            // Execute the insert
            int rowsInserted = psmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) psmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
