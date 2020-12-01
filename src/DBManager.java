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
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("DB 연결 성공");
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean selectPerson(String id, String password) {//프리페어먼트
		String query = "SELECT * from 동의인 where 동의인번호=? and 비밀번호=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("로그인 성공");
				return true;
			}
			System.out.println("회원이아닙니다.");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public ArrayList<Rental> selectRental() {
		String query = "SELECT * from 대여내역";
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

	public boolean addRental(Date 시작기간, Date 종료기간, int 인원, String 사유, int 동의인, int 건물, int 호실) {
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
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}