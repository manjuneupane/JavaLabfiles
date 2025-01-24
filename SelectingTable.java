import java.sql.*;

public class SelectingTable {
    static final String URL = "jdbc:mysql://localhost:3306/manjudb";
    static final String USER = "root";
    static final String PASS = "manju123@manju";

    public static void main(String[] args) {
        Connection conn = null;
        Statement smt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection

            conn = DriverManager.getConnection(URL, USER, PASS);

            // Insert query
            smt = conn.createStatement();
            String query = "SELECT * From CUSTOMER";

            // Set parameters for the prepared statement

            // Execute the update
//            smt.executeUpdate(query);

            // Select query to fetch data
//            String selectQuery = "SELECT * FROM CUSTOMER";
            rs = smt.executeQuery(query);


            // Print the results
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("Name: " + rs.getString("NAME"));
                System.out.println("Age: " + rs.getInt("AGE"));
                System.out.println("Address: " + rs.getString("ADDRESS"));
                System.out.println("Salary: " + rs.getDouble("SALARY"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (smt != null) smt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

