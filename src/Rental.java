import java.util.Date;

public class Rental {
    private int rentalNumber;
    private Date startPeriod;
    private Date endPeriod;
    private int personnel;
    private String reason;
    private int deuPerson;
    private int facility;
    private int room;
    private int licenser;

    public int getRentalNumber() {
        return rentalNumber;
    }

    public void setRentalNumber(int rentalNumber) {
        this.rentalNumber = rentalNumber;
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    public int getPersonnel() {
        return personnel;
    }

    public void setPersonnel(int personnel) {
        this.personnel = personnel;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDEUPerson() {
        return deuPerson;
    }

    public void setDEUPerson(int deuPerson) {
        this.deuPerson = deuPerson;
    }

    public int getFacility() {
        return facility;
    }

    public void setFacility(int facility) {
        this.facility = facility;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getLicenser() {
        return licenser;
    }

    public void setLicenser(int licenser) {
        this.licenser = licenser;
    }
}