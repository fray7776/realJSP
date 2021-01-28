package co.sophy.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "sophy";
	private String password= "1234";
	
	//private는 상속이 안되니까 connection하기
	public Connection conn;
	
	//앞으로 DAO를 생성할때 dao class 것 상속받아서 사용
	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("DB연결!!!");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 실패!!!");
		}
	}
}
