package co.sophy.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "sophy";
	private String password= "1234";
	
	//private�� ����� �ȵǴϱ� connection�ϱ�
	public Connection conn;
	
	//������ DAO�� �����Ҷ� dao class �� ��ӹ޾Ƽ� ���
	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("DB����!!!");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("DB ���� ����!!!");
		}
	}
}
