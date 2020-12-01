import oracle.jdbc.OracleTypes;

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
            System.out.println("Facility reservation was successful.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Facility reservation failed.");
        }
        return result;
    }
}