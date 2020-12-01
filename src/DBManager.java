import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {
	private Connection con = null;

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
		} catch (ClassNotFoundException | SQLException e) {
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

	public ArrayList<Rental> selectRental() {
		String query = "SELECT * from �뿩����";
		try {
			ArrayList<Rental> rentals = new ArrayList<>();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Rental rental = new Rental();
				rental.setRentalNumber(rs.getInt(1));
				rental.setStartPeriod(rs.getDate(2));
				rental.setEndPeriod(rs.getDate(3));
				rental.setPersonnel(rs.getInt(4));
				rental.setReason(rs.getString(5));
				rental.setDEUPerson(rs.getInt(6));
				rental.setFacility(rs.getInt(7));
				rental.setRoom(rs.getInt(8));
				rental.setLicenser(rs.getInt(9));
				rentals.add(rental);
			}
			rs.close();
			stmt.close();
			return rentals;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean addRental(Date ���۱Ⱓ, Date ����Ⱓ, int �ο�, String ����, int ������, int �ǹ�, int ȣ��) {
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
}