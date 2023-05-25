package com.section1.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application1 {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menu";
    private static String USER = "sahmyook";
    private static String PASSWORD = "sahmyook";

    public static void main(String[] args) {

        /*
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 자동 커밋
        * */

        Environment environment = new Environment(
                                                "dev",                                               // 환경정보 이름
                                                    new JdbcTransactionFactory(),                       // 트랜잭션 매니저 종류 결정 (JDBC or MANAGED)
                                                    new PooledDataSource(DRIVER, URL, USER, PASSWORD)   // ConnectionPool 사용 유무 (Pooled or Unpooled)
                                                    );

        /* 생성한 환경 설정 정보를 가지고 마이바이트 설정 객체 생성 */
        Configuration configuration = new Configuration(environment);

        /* 설정 객체에 매퍼 등록 */
        configuration.addMapper(Mapper.class);

        /* SqlSessionFactory : SqlSession 객체를 생성하기 위한 factory 역할을 수행하는 인터페이스
        * SqlSessionFactoryBuilder() : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 수행
        * build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결된 스트림을 매개 변수로 전달하면
        *           SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드 */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /* openSession(0 : SqlSession 인터페이스 타입의 객체를 반환하는 메소드
        * - false : Connection 인터페이스 타입 객체로 DML 수정 후 auto commit에 대한 옵션을 false로 지정 (권장)
        * - true : Connection 인터페이스 타입 객체로 DML 수정 후 auto commit에 대한 옵션을 true로 지정 */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        Mapper mapper = sqlSession.getMapper(Mapper.class);

        java.util.Date data = mapper.selectSysdate();

        System.out.println(data);

        sqlSession.close();

    }
}
