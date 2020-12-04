import java.sql.Timestamp;

public class Rental {
    private Number rentalNumber;
    private Timestamp startPeriod;
    private Timestamp endPeriod;
    private Number personnel;
    private String reason;
    private Number deuPerson;
    private Number facility;
    private Number room;
    private Number licenser;

    public Number getRentalNumber() {
        return rentalNumber;
    }

    public void setRentalNumber(Number rentalNumber) {
        this.rentalNumber = rentalNumber;
    }

    public Timestamp getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Timestamp startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Timestamp getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Timestamp endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Number getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Number personnel) {
        this.personnel = personnel;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Number getDEUPerson() {
        return deuPerson;
    }

    public void setDEUPerson(Number deuPerson) {
        this.deuPerson = deuPerson;
    }

    public Number getFacility() {
        return facility;
    }

    public void setFacility(Number facility) {
        this.facility = facility;
    }

    public Number getRoom() {
        return room;
    }

    public void setRoom(Number room) {
        this.room = room;
    }

    public Number getLicenser() {
        return licenser;
    }

    public void setLicenser(Number licenser) {
        this.licenser = licenser;
    }
}