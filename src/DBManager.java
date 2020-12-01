import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	Connection con = null;

	public void finalize() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public boolean connect(String id, String password) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("DB ���� ����");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean insertRental(Date ���۱Ⱓ, Date ����Ⱓ, int �ο�, String ����, int ������, int �ǹ�, int ȣ��) {
		String query = "insert into �뿩����  values(�뿩��ȣ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ���۱Ⱓ);
			pstmt.setDate(2, ����Ⱓ);
			pstmt.setInt(3, �ο�);
			pstmt.setString(4, ����);
			pstmt.setInt(5, ������);
			pstmt.setInt(6, �ǹ�);
			pstmt.setInt(7, ȣ��);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	//�ü����뿩��������  Statement
	

	public boolean selectPerson() {
		String query = "SELECT * from ������";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println();
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.println(rs.getString(6));
			}
			System.out.println();
			rs.close();
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean selectPerson(String id, String password) {//��������Ʈ
		String query = "SELECT * from ������ where �����ι�ȣ=? and ��й�ȣ=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("�α��� ����");
				return true;
			}
			System.out.println("ȸ���̾ƴմϴ�.");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean selectFacility() {
		String query = "SELECT * from �ü���";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println();
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.println(rs.getInt(5));
			}
			System.out.println();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean selectRental() {
		String query = "SELECT * from �뿩����";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println();
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getDate(2) + "\t");
				System.out.print(rs.getDate(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\t");
				System.out.println(rs.getInt(8));
			}
			System.out.println();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

//	public static void main(String[] args) {
//		DBManager dbm = new DBManager("DEU_FACILITY", "1234");
//		dbm.selectPerson();
//		dbm.selectPerson("20163248", "1234");
//		dbm.selectPerson("20163248", "1235");
//		dbm.selectFacility();
//		dbm.selectRental();
//	}
}