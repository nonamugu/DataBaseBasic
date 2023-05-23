package section2.preparedstatement;

import model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application4 {

    public static void main(String[] args) {

        /* 1. Connection 생성 */
        Connection con = getConnection();

        /* 2. PreparedStatement, ResultSet 생성 */
        PreparedStatement pstat =  null;
        ResultSet rset = null;
        EmployeeDTO row = null;

        /* 3. Scanner를 활용하여 조회할 사번 입력받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번의 번호를 입력해주세요 : ");
        String empId = sc.nextLine();

        /* 4. 조회를 위한 쿼리 작성 (placeholder 사용) */
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";

        /* 5. prepareStatement 생성 및 쿼리 준비 */
        try {
            pstat = con.prepareStatement(query);

            /* 6. 조건에 해당하는 사번 세팅 */
            pstat.setString(1, empId);
            rset = pstat.executeQuery();

            /* 7. 한 행의 정보를 담을 DTO 객체 생성하여 ResultSet에 존재하는 결과값을 객체에 세팅 */
            if(rset.next()) {
                row = new EmployeeDTO();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setEmail(rset.getString("EMAIL"));
                row.setPhone(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setManagerId(rset.getString("MANAGER_ID"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEntDate(rset.getDate("ENT_DATE"));
                row.setEntYn(rset.getString("ENT_YN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /* 8. 자원 반납 */
            close(con);
            close(pstat);
            close(rset);
        }
        /* 10. 조회한 직원 정보 오버라이딩된 toString으로 출력  */
        System.out.println(row.toString());


    }

}