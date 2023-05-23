package section2.update;

import model.dto.MenuDTO;

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
        MenuDTO menuDTO = new MenuDTO();

        Properties prop = new Properties();


        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));
            String query = prop.getProperty("updateMenuName");

            Scanner sc = new Scanner(System.in);
            System.out.print("업데이트할 메뉴명을 입력해주세요 : ");
            String menuName = sc.nextLine();
            System.out.print("업데이트할 가격을 입력해주세요 : ");
            int price = sc.nextInt();
            sc.nextLine();
            System.out.print("업데이트할 메뉴의 판매여부를 확인해주세요(Y/N) : ");
            String orderableMenu = sc.nextLine().toUpperCase();

            menuDTO.setName(menuName);
            menuDTO.setPrice(price);
            menuDTO.setOrderableStatus(orderableMenu);

            pstat = con.prepareStatement(query);
            pstat.setInt(1, menuDTO.getPrice());
            pstat.setString(2, menuDTO.getName());
            pstat.setString(3, menuDTO.getOrderableStatus());

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
            System.out.println("메뉴 수정 완료!!");
        } else {
            System.out.println("메뉴 수정 실패 ㅠㅠ");
        }
    }
}
