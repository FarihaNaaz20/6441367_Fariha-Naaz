import java.sql.*;
public class StudentDAO {
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
    }
    public void insertStudent(int id, String name, int age) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO students (id, name, age) VALUES (?, ?, ?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateStudentAge(int id, int newAge) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE students SET age = ? WHERE id = ?")) {
            ps.setInt(1, newAge);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.insertStudent(1, "Alice", 20);
        dao.updateStudentAge(1, 21);
    }
}
