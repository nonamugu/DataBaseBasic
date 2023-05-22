package section1.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application2 {

    public static void main(String[] args) {

        Connection con = getConnection();

        Statement stat = null;

        ResultSet rset = null;

        try {
            stat = con.createStatement();

            String empId = "200";
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = " + empId + ";";

            System.out.println(query);

            rset = stat.executeQuery(query);

            if(rset.next()) {
                System.out.println(rset.getString("EMP_ID") + ": " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(stat);
            close(rset);
        }
    }
}
