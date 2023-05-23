package section1.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application2 {

    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstat = null;
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));

            String query = prop.getProperty("insertMenu");
            System.out.println(query);

            Scanner sc = new Scanner(System.in);
            System.out.print("메뉴의 이름을 입력하세요 : ");
            String menuName = sc.nextLine();
            System.out.print("메뉴의 가격을 입력하세요 : ");
            int price = sc.nextInt();
            System.out.print("카테고리 코드를 입력하세요 : ");
            int categoryCode = sc.nextInt();
            System.out.print("판매 여부를 결정하세요(Y/N) : ");
            sc.nextLine();
            String orderableStatus = sc.nextLine().toUpperCase();

            pstat = con.prepareStatement(query);
            pstat.setString(1, menuName);
            pstat.setInt(2, price);
            pstat.setInt(3, categoryCode);
            pstat.setString(4, orderableStatus);

            result = pstat.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstat);
        }

        if(result > 0) {
            System.out.println("메뉴 등록 성공!!");
        } else {
            System.out.println("메뉴 등록 실패 ㅠㅠ");
        }
    }
}
