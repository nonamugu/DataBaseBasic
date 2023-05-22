package section1.statement;

import model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static common.JDBCTemplate.getConnection;

public class Application4 {

    public static void main(String[] args) {

        Connection con = getConnection();

        Statement stat = null;

        ResultSet rset = null;

        EmployeeDTO selectedEMP = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("조회할 사번을 입력해주세요 : ");
        


    }
}
