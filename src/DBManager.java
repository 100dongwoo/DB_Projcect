import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {
    private Connection con = null;

//    public void finalize() {
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public boolean connect(String id, String password) {
        boolean result = false;
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("����̹� ���� ����");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("DB ���� ����");
            result = true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean selectPerson(String id, String password) { //��������Ʈ
        boolean result = false;
        try {
            String query = "SELECT * from ������ where �����ι�ȣ=? and ��й�ȣ=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("�α��� ����");
                result = true;
            } else {
                System.out.println("ȸ���̾ƴմϴ�.");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ArrayList<Rental> selectRental() {
        ArrayList<Rental> rentals = new ArrayList<>();
        try {
            String query = "SELECT * from �뿩����";
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rentals;
    }

    public boolean addRental(Rental rental) {
        boolean result = false;
        try {
            String query = "insert into �뿩���� values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "�뿩��ȣ.NEXTVAL");
            pstmt.setDate(2, rental.getStartPeriod());
            pstmt.setDate(3, rental.getEndPeriod());
            pstmt.setInt(4, rental.getPersonnel());
            pstmt.setString(5, rental.getReason());
            pstmt.setInt(6, rental.getDEUPerson());
            pstmt.setInt(7, rental.getFacility());
            pstmt.setInt(8, rental.getRoom());
            pstmt.setInt(9, rental.getLicenser());
            pstmt.close();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}