import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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

	public void select(String table) {
		String query = "SELECT * FROM " + table;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ResultSetMetaData schema = rs.getMetaData();
//				for (int i = 0; i <= )
				System.out.print(schema.getColumnCount());
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
		dbconquery.select("������");
	}
}