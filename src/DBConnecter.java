import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	protected Connection con = null;
	
	public DBConnecter() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "DEU_FACILITY";
		String password = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("DB ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver.");
		} catch (SQLException e) {
			System.out.println("Connection Fail");
		}
	}
	
	public Connection getConnection() {
		return con;
	}
}