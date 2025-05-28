import java.sql.*;
public class SimpleJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while(rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
