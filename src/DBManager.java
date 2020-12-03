import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import java.awt.*;
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
            System.out.println("DB connection was successful.");
            result = true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DB connection failed.");
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
                result = true;
                System.out.println("Login was successful.");
            } else {
                System.out.println("No such information exists.");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Login failed.");
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
            System.out.println("Have successfully searched the entire rental history.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Full rental history inquiry failed.");
        }
        return rentals;
    }

    public ArrayList<Rental> selectRentalFacility(String facilityName) {
        ArrayList<Rental> rentals = new ArrayList<>();
        try {
            String sql = "{call inquiry_facility(?, ?)}";
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, facilityName);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(2);
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
            cs.close();
            System.out.println("Have successfully searched the rental history of the facility name.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to search rental history of the facility name.");
        }
        return rentals;
    }

    public ArrayList<Rental> selectRentalReason(String reason) {
        ArrayList<Rental> rentals = new ArrayList<>();
        String query = "SELECT * from 대여내역 where 사유 LIKE ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + reason + "%");
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
            System.out.println("Have successfully selected the reason for the rental history.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to select reason for rental history.");
        }
        return rentals;
    }

    public boolean insertRental(Timestamp startPeriod, Timestamp endPeriod, Integer personnel, String reason, Integer deuPerson, Integer facility, Integer room, Integer licenser) {
        boolean result = false;
        try {
            String query = "insert into 대여내역 values(대여번호.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setTimestamp(1, startPeriod);
            pstmt.setTimestamp(2, endPeriod);
            pstmt.setInt(3, personnel);
            pstmt.setString(4, reason);
            pstmt.setInt(5, deuPerson);
            pstmt.setInt(6, facility);
            pstmt.setInt(7, room);
            pstmt.setInt(8, licenser);
            pstmt.executeQuery();
            pstmt.close();
            result = true;
            System.out.println("Have successfully inserted the rental history.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to insert rental history.");
        }
        return result;
    }

    //2020-11-11 10:10:10
    public ArrayList<Rental> selectPeriodInquiry(String startDateInquiry, String endDateInquiry) {
        ArrayList<Rental> rentals = new ArrayList<>();
        String query = "select * from 대여내역 where 시작기간 between ? and ?";
        try {
            System.out.println(Timestamp.valueOf(startDateInquiry));
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setTimestamp(1, Timestamp.valueOf(startDateInquiry));
            pstmt.setTimestamp(2, Timestamp.valueOf(endDateInquiry));
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
            System.out.println("selected PeriodInquiry");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Not selected PeriodInquiry.");
        }
        return rentals;
    }

    public boolean deleteRental(Integer rentalNumber, Integer deuPerson) {
        boolean result = false;
        try {
            String query = "delete from where 대여번호=? and 동의인=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, rentalNumber);
            pstmt.setInt(2, deuPerson);
            pstmt.executeQuery();
            pstmt.close();
            result = true;
            System.out.println("Have successfully deleted the rental history.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to delete rental history.");
        }
        return result;
    }
    public ArrayList<Facility> selectFacility() {
        ArrayList<Facility> Facilitys = new ArrayList<>();
        try {
            String query = "SELECT * from 시설물";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Facility facility = new Facility();
                facility.setFacilityNumber(rs.getInt(1));
                facility.setRoom(rs.getInt(2));
                facility.setName(rs.getString(3));
                facility.setManager(rs.getInt(4));
                Facilitys.add(facility);
            }
            rs.close();
            stmt.close();
            System.out.println("Have successfully searched the entire facility list");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Full facility list inquiry failed.");
        }
        return Facilitys;
    }
}