import java.util.Date;

public class Rental {
    private int rentalNumber;
    private Date startPeriod;
    private Date endPeriod;
    private int personnel;
    private String reason;
    private int person;
    private int facility;
    private int room;
    private String licenser;

    public Rental(int rentalNumber, Date startPeriod, Date endPeriod, int personnel, String reason, int person, int facility, int room, String licenser) {
        this.rentalNumber = rentalNumber;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.personnel = personnel;
        this.reason = reason;
        this.person = person;
        this.facility = facility;
        this.room = room;
        this.licenser = licenser;
    }


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

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
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

    public String getLicenser() {
        return licenser;
    }

    public void setLicenser(String licenser) {
        this.licenser = licenser;
    }
}