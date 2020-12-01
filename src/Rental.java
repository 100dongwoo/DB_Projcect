import java.sql.Timestamp;

public class Rental {
    private Integer rentalNumber;
    private Timestamp startPeriod;
    private Timestamp endPeriod;
    private Integer personnel;
    private String reason;
    private Integer deuPerson;
    private Integer facility;
    private Integer room;
    private Integer licenser;

    public Integer getRentalNumber() {
        return rentalNumber;
    }

    public void setRentalNumber(Integer rentalNumber) {
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

    public Integer getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Integer personnel) {
        this.personnel = personnel;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getDEUPerson() {
        return deuPerson;
    }

    public void setDEUPerson(Integer deuPerson) {
        this.deuPerson = deuPerson;
    }

    public Integer getFacility() {
        return facility;
    }

    public void setFacility(Integer facility) {
        this.facility = facility;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getLicenser() {
        return licenser;
    }

    public void setLicenser(Integer licenser) {
        this.licenser = licenser;
    }
}