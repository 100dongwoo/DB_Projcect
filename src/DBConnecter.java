import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	private void selectPerson() {
		String query = "select * from ������";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("\t" + rs.getInt("�����ι�ȣ"));
				System.out.print("\t" + rs.getString("��й�ȣ"));
				System.out.print("\t" + rs.getString("�̸�"));
				System.out.print("\t" + rs.getString("��ȭ��ȣ"));
				System.out.print("\t" + rs.getString("��å"));
				System.out.print("\t" + rs.getString("�Ҽ�") + "\n");
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) throws SQLException {
		DBConnecter dbconquery = new DBConnecter();
		dbconquery.selectPerson();
	}
}