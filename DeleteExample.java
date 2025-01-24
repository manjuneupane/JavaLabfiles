import java.sql.*;

public class DeleteExample {
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
                String deleteQuery="DELETE FROM CUSTOMER WHERE name=?";
                psmt=conn.prepareStatement(deleteQuery);
                psmt.setString(1,"Manju");
                psmt.executeUpdate();

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


