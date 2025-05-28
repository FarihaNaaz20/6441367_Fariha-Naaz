import java.sql.*;
public class AccountDAO {
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
    }
    public void transfer(int fromAccountId, int toAccountId, double amount) {
        Connection con = null;
        PreparedStatement debitStmt = null;
        PreparedStatement creditStmt = null;

        try {
            con = getConnection();
            con.setAutoCommit(false);

            debitStmt = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccountId);
            int debit = debitStmt.executeUpdate();

            creditStmt = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccountId);
            int credit = creditStmt.executeUpdate();

            if(debit == 1 && credit == 1) {
                con.commit();
            } else {
                con.rollback();
            }
        } catch(Exception e) {
            try {
                if(con != null) con.rollback();
            } catch(SQLException se) {
                se.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if(debitStmt != null) debitStmt.close();
                if(creditStmt != null) creditStmt.close();
                if(con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        dao.transfer(1, 2, 500.0);
    }
}
