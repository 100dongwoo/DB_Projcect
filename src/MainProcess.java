public class MainProcess {
    LoginView loginView;

    public static void main(String[] args) {
        // 메인클래스 실행
    	DBManager dbm = new DBManager();
    	dbm.connect("DEU_FACILITY", "1234");
    	
    	MainProcess main = new MainProcess();
        main.loginView = new LoginView(dbm); // 로그인창 보이기
    }
}