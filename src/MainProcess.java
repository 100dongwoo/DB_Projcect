public class MainProcess {
	DBManager dbm;
    LoginView loginView;
    TestFrm testFrm;
    
    public static void main(String[] args) {
        // ����Ŭ���� ����
    	DBManager dbm = new DBManager();
    	dbm.connect("DEU_FACILITY", "1234");
    	
    	MainProcess main = new MainProcess();
        main.loginView = new LoginView(dbm); // �α���â ���̱�
        main.loginView.setMain(main); // �α���â���� ���� Ŭ����������
        
        dbm.selectPerson();
    }

	public void showFrameTest() {
		
		
	}
}


