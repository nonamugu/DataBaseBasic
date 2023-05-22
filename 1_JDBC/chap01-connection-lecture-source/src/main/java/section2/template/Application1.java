package section2.template;

import java.sql.Connection;
import java.sql.SQLException;

import static section2.template.JDBCTemplate.close;
import static section2.template.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {
        Connection con = getConnection();

        System.out.println(con);

//        if(con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        close(con);

    }
}
