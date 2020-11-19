import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager extends DBConnecter {
	public DBManager(String id, String password) {
		super(id, password);
	}

	public boolean rentalInsert(Date ���۱Ⱓ, Date ����Ⱓ, int �ο�, String ����, int ������, int �ǹ�, int ȣ��) {
		String query = "insert into �뿩����  values(�뿩��ȣ.NEXTVAL,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ���۱Ⱓ);
			pstmt.setDate(2, ����Ⱓ);
			pstmt.setInt(3, �ο�);
			pstmt.setString(4, ����);
			pstmt.setInt(5, ������);
			pstmt.setInt(6, �ǹ�);
			pstmt.setInt(7, ȣ��);
		} catch (SQLException e) {
			System.out.println("�뿩���� ������ ���� ����:" + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean select(String table) {
		String query = "SELECT * form " + table;
		try {
			Statement stmt = con.createStatement();
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
			return false;
		}
		return true;
	}

	public boolean Login(String id, String password) {
		String query = "SELECT * from ������ where �����ι�ȣ=" + id + "and ��й�ȣ=" + password;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				System.out.println("�α��� ����");
			} else {
				System.out.println("ȸ���̾ƴմϴ�.");
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// DBManager dbm = new DBManager("DEU_FACILITY", "1234");
	}
}