package section1.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;

public class Application1 {

    public static void main(String[] args) {

        Connection con = getConnection();

        /* query문을 저장하고 실행하는 기능을 하는 용도의 인터페이스*/
        Statement stat = null;
        /* select 결과 집합을 받아올 용도의 인터페이스 */
        ResultSet rset = null;

        try {
            /* connection을 이용하여 statement 생성 */
            stat = con.createStatement();

            rset = stat.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");

            /* next() : ResultSet의 커서를 하나 내리면서 해당 컬럼을 가르키고, 값이 존재하면 true 더이상 존재하지 않으면 false를 반환한다. */
            while(rset.next()) {
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
