import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Connection con = null;

    public boolean connect(String id, String password) {
        boolean result = false;
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("Connected.");
            result = true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Not connected.");
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean selectPerson(String id, String password) {
        boolean result = false;
        try {
            String query = "SELECT * from 동의인 where 동의인번호=? and 비밀번호=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Selected person.");
                result = true;
            } else {
                System.out.println("Selected no person.");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Not selected person.");
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ArrayList<Rental> selectRental() {
        ArrayList<Rental> rentals = new ArrayList<>();
        try {
            String query = "SELECT * from 대여내역";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Rental rental = new Rental();
                rental.setRentalNumber(rs.getInt(1));
                rental.setStartPeriod(rs.getTimestamp(2));
                rental.setEndPeriod(rs.getTimestamp(3));
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

    public ArrayList<Rental> selectRental(String facilityName) {//프리페어먼트
        ArrayList<Rental> rentals = new ArrayList<>();
        String query = "SELECT " +
                "대여내역.대여번호, " +
                "대여내역.시작기간, " +
                "대여내역.종료기간, " +
                "대여내역.인원, " +
                "대여내역.사유, " +
                "대여내역.동의인, " +
                "대여내역.건물, " +
                "대여내역.호실, " +
                "대여내역.허가자 " +
                "from 대여내역, 시설물 " +
                "where 대여내역.건물=시설물.건물번호 and 시설물.시설명=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, facilityName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Rental rental = new Rental();
                rental.setRentalNumber(rs.getInt(1));
                rental.setStartPeriod(rs.getTimestamp(2));
                rental.setEndPeriod(rs.getTimestamp(3));
                rental.setPersonnel(rs.getInt(4));
                rental.setReason(rs.getString(5));
                rental.setDEUPerson(rs.getInt(6));
                rental.setFacility(rs.getInt(7));
                rental.setRoom(rs.getInt(8));
                rental.setLicenser(rs.getInt(9));
                rentals.add(rental);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rentals;
    }

    public boolean addRental(Rental rental) {
        boolean result = false;
        try {
            String query = "insert into 대여내역 values(대여번호.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setTimestamp(1, rental.getStartPeriod());
            pstmt.setTimestamp(2, rental.getEndPeriod());
            pstmt.setInt(3, rental.getPersonnel());
            pstmt.setString(4, rental.getReason());
            pstmt.setInt(5, rental.getDEUPerson());
            pstmt.setInt(6, rental.getFacility());
            pstmt.setInt(7, rental.getRoom());
            pstmt.setInt(8, rental.getLicenser());
            pstmt.executeQuery();
            pstmt.close();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}