import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	Connection con = null;
	
	public DBConnecter() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "DEU_FACILITY";
		String password = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver.");
		} catch (SQLException e) {
			System.out.println("Connection Fail");
		}
	}
	
	public Connection getConnection() {
		return con;
	}

//	private void selectPerson() {
//		String query = "SELECT * FROM 동의인";
//		try {
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				System.out.print("\t" + rs.getInt("동의인번호"));
//				System.out.print("\t" + rs.getString("비밀번호"));
//				System.out.print("\t" + rs.getString("이름"));
//				System.out.print("\t" + rs.getString("전화번호"));
//				System.out.print("\t" + rs.getString("직책"));
//				System.out.print("\t" + rs.getString("소속") + "\n");
//			}
//			stmt.close();
//			rs.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String arg[]) throws SQLException {
//		DBConnecter dbconquery = new DBConnecter();
//		dbconquery.selectPerson();
//	}
}