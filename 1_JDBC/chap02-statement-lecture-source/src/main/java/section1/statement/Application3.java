package section1.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application3 {

    public static void main(String[] args) {

        Connection con = getConnection();

        Statement stat = null;

        ResultSet rset = null;

        try {
            stat = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.print("조회할 사번을 입력해 주세요 : ");
            String empId = sc.nextLine();
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = " + empId + ";";

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
