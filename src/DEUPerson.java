public class DEUPerson {
    private int deuPersonNumber;
    private String password;
    private String name;
    private String phone;
    private String position;
    private String belong;

    public DEUPerson(int deuPersonNumber, String password, String name, String phone, String position, String belong) {
        this.deuPersonNumber = deuPersonNumber;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.position = position;
        this.belong = belong;
    }

    public int getDeuPersonNumber() {
        return deuPersonNumber;
    }

    public void setDeuPersonNumber(int deuPersonNumber) {
        this.deuPersonNumber = deuPersonNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }
}