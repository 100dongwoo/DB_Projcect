package loginTest;
import javax.swing.JFrame;
public class MainProcess{
    LoginView loginView;
    TestFrm testFrm;
    public static void main(String[] args) {
        // ����Ŭ���� ����
        MainProcess main = new MainProcess();
        main.loginView = new LoginView(); // �α���â ���̱�
        main.loginView.setMain(main); // �α���â���� ���� Ŭ����������
    }

	public void showFrameTest() {
		
		
	}
}