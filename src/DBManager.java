import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager extends DBConnecter {
	public DBManager(String id, String password) {
		super(id, password);
	}

	public boolean insertRental(Date 시작기간, Date 종료기간, int 인원, String 사유, int 동의인, int 건물, int 호실) {
		String query = "insert into 대여내역  values(대여번호.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDate(1, 시작기간);
			pstmt.setDate(2, 종료기간);
			pstmt.setInt(3, 인원);
			pstmt.setString(4, 사유);
			pstmt.setInt(5, 동의인);
			pstmt.setInt(6, 건물);
			pstmt.setInt(7, 호실);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean selectPerson() {
		String query = "SELECT * from 동의인";
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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean selectPerson(String id, String password) {
		String query = "SELECT * from 동의인 where 동의인번호=" + id + " and 비밀번호=" + password;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("회원이아닙니다.");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean selectFacility() {
		String query = "SELECT * from 시설물";
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
		String query = "SELECT * from 대여내역";
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

	public static void main(String[] args) {
		DBManager dbm = new DBManager("DEU_FACILITY", "1234");
		dbm.selectPerson();
		dbm.selectPerson("20163248", "1234");
		dbm.selectPerson("20163248", "1235");
		dbm.selectFacility();
		dbm.selectRental();
	}
}