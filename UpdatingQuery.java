import java.sql.*;

public class UpdatingQuery {

    static final String URL = "jdbc:mysql://localhost:3306/manjudb";
    static final String USER = "root";
    static final String PASS = "manju123@manju";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement psmt = null;
//        Statement smt = null;
        ResultSet rs = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Update query
            String updateQuery = "UPDATE CUSTOMER SET AGE = ? WHERE name = ?";
            psmt = conn.prepareStatement(updateQuery);

            // Set parameters for the prepared statement
            psmt.setInt(1, 21); // Age
            psmt.setString(2, "MANJU"); // name

            // Execute the update
            int rowsAffected = psmt.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);

//            String query = "SELECT * From CUSTOMER";
//            rs = psmt.executeQuery(query);

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
