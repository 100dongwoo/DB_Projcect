import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConn {
	public Connection connect(String id, String password) {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		}
		return con;
	}
}

public class DBConnecter {
	Connection con = null;
	public db_conn_query() {
		
	}
	public static
}