package section1.insert;

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

public class Application3 {

    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstat = null;
        int result = 0;
        MenuDTO menuDTO = new MenuDTO();

        Properties prop = new Properties();

        Scanner sc = new Scanner(System.in);
        System.out.print("등록하고 싶은 메뉴의 이름을 작성해주세요 : ");
        String menuName = sc.nextLine();
        System.out.print("등록하고 싶은 메뉴의 가격을 작성해주세요 : ");
        int menuPrice = sc.nextInt();
        System.out.print("등록하고 싶은 카테고리의 코드를 작성해주세요 : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.print("메뉴의 판매여부를 작성해주세요(Y/N) : ");
        String orderableStatus = sc.nextLine().toUpperCase();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");

            menuDTO.setName(menuName);
            menuDTO.setPrice(menuPrice);
            menuDTO.setCategoryCode(categoryCode);
            menuDTO.setOrderableStatus(orderableStatus);

            pstat = con.prepareStatement(query);
            pstat.setString(1, menuDTO.getName());
            pstat.setInt(2,menuDTO.getPrice());
            pstat.setInt(3,menuDTO.getCategoryCode());
            pstat.setString(4, menuDTO.getOrderableStatus());

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
            System.out.println("메뉴 등록 실패ㅜㅜ");
        }

    }
}
