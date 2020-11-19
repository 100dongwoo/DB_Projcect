import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	public DBManager(Connection con) {
		this.con = con;
	}

	public void insert(Date ���۱Ⱓ, Date ����Ⱓ, int �ο�, String ����, int ������, int �ǹ�, int ȣ��) {
		String query = "insert into �뿩����  values(�뿩��ȣ.NEXTVAL,?,?,?,?,?,?,?) ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ���۱Ⱓ);
			pstmt.setDate(2, ����Ⱓ);
			pstmt.setInt(3, �ο�);
			pstmt.setString(4, ����);
			pstmt.setInt(5, ������);
			pstmt.setInt(6, �ǹ�);
			pstmt.setInt(7, ȣ��);
		}
		catch(SQLException e) {
			System.out.println("�뿩���� ������ ���� ����:"+e.getMessage());
		}
		
	}

	public void select(String table) {
		String query = "SELECT * form " + table;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.print("\t" + rs.getString(4));
				System.out.print("\t" + rs.getString(5));
				System.out.print("\t" + rs.getString(6));
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("������ �˻� ���� : " + e.getMessage());
		}
	}

	public static void main(String[] args) {

	}

}
