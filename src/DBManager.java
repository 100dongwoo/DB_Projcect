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

	public void insert(Date 시작기간, Date 종료기간, int 인원, String 사유, int 동의인, int 건물, int 호실) {
		String query = "insert into 대여내역  values(대여번호.NEXTVAL,?,?,?,?,?,?,?) ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, 시작기간);
			pstmt.setDate(2, 종료기간);
			pstmt.setInt(3, 인원);
			pstmt.setString(4, 사유);
			pstmt.setInt(5, 동의인);
			pstmt.setInt(6, 건물);
			pstmt.setInt(7, 호실);
		}
		catch(SQLException e) {
			System.out.println("대여내역 데이터 삽입 오류:"+e.getMessage());
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
			System.out.println("데이터 검색 오류 : " + e.getMessage());
		}
	}

	public static void main(String[] args) {

	}

}
