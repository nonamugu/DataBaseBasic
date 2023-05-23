package section1.statement;

import model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Application5 {

    public static void main(String[] args) {

        /* 1. Connection 생성 */
        Connection con = getConnection();

        /* 2. Statement, ResultSet 생성 */
        Statement stat = null;
        ResultSet rset = null;

        /* 3. 한 행의 정보를 담을 DTO 객체 생성 */
        EmployeeDTO selectedEmp = null;

        /* 4. 여러 DTO를 하나의 인스턴스로 묶기 위한 List 생성 */
        List<EmployeeDTO> list = null;

        /* 5. 전체 직원 정보 조회 쿼리를 담은 String 변수 생성 */
        String query = "SELECT * FROM EMPLOYEE;";

        /* 6. statment 생성 및 쿼리 실행 */
        try {
            stat = con.createStatement();
            rset = stat.executeQuery(query);

            /* 7. ResultSet에 존재하는 모든 결과값을 객체에 담아 배열에 추가 */
            list = new ArrayList<>();

            while(rset.next()) {
                selectedEmp = new EmployeeDTO();

                selectedEmp.setEmpId(rset.getString("EMP_ID"));
                selectedEmp.setEmpName(rset.getString("EMP_NAME"));
                selectedEmp.setEmpNo(rset.getString("EMP_NO"));
                selectedEmp.setEmail(rset.getString("EMAIL"));
                selectedEmp.setPhone(rset.getString("PHONE"));
                selectedEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectedEmp.setJobCode(rset.getString("JOB_CODE"));
                selectedEmp.setSalLevel(rset.getString("SAL_LEVEL"));
                selectedEmp.setSalary(rset.getInt("SALARY"));
                selectedEmp.setBonus(rset.getDouble("BONUS"));
                selectedEmp.setManagerId(rset.getString("MANAGER_ID"));
                selectedEmp.setHireDate(rset.getDate("HIRE_DATE"));
                selectedEmp.setEntDate(rset.getDate("ENT_DATE"));
                selectedEmp.setEntYn(rset.getString("ENT_YN"));

                list.add(selectedEmp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /* 8. 자원 반납 */
            close(con);
            close(stat);
            close(rset);
        }
        /* 9. 전체 직원 정보 오버라이딩된 toString으로 출력 */
        for(EmployeeDTO emp : list) {
            System.out.println(emp.toString());
        }



    }
}
