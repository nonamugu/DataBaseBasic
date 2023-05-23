package section1.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstat = null;
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));

            String query = prop.getProperty("insertMenu");
            System.out.println(query);

            pstat = con.prepareStatement(query);
            pstat.setString(1, "뚝배기불고기");
            pstat.setInt(2, 50000);
            pstat.setInt(3, 4);
            pstat.setString(4, "y");

            result = pstat.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstat);
        }

        System.out.println(result);
    }
}
