public class MainProcess {
    LoginView loginView;

    public static void main(String[] args) {
        DBManager dbm = new DBManager();
        if (dbm.connect("DEU_FACILITY", "1234")) {
            MainProcess main = new MainProcess();
            main.loginView = new LoginView(dbm);
        }
    }
}