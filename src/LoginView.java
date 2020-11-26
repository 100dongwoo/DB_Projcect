
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	DBManager dbm;

	private MainProcess main;
	private TestFrm testFrm;

	private JButton btnLogin;
	private JButton btnInit;
	private JPasswordField passText;
	private JTextField userText;
	private boolean bLoginCheck;

	public LoginView(DBManager dbm) {
		this.dbm = dbm;

		// setting
		setTitle("login");
		setSize(280, 150);
		setResizable(false);
		setLocation(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// panel
		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		add(panel);
		setVisible(true);
	}

	public void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("동의인번호");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JLabel passLabel = new JLabel("비밀번호");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passText = new JPasswordField(20);
		passText.setBounds(100, 40, 160, 25);
		panel.add(passText);

		btnInit = new JButton("다시입력");
		btnInit.setBounds(10, 80, 100, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passText.setText("");
			}
		});

		btnLogin = new JButton("로그인");
		btnLogin.setBounds(160, 80, 100, 25);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});
	}

	public void isLoginCheck()////////////// 로그인 체크부분
	{
		String id = userText.getText();
		@SuppressWarnings("deprecation")
		String password = passText.getText();
		
		
		System.out.println(id);
		System.out.println(password);
		if (dbm.selectPerson(id, password)) {
			JOptionPane.showMessageDialog(null, "동의인 환영합니다.");
		} else {
			JOptionPane.showMessageDialog(null, "다시입력해주세요.");
		}
	}

	// mainProcess와 연동
	public void setMain(MainProcess main) {
		this.main = main;
	}

	public boolean isLogin() {
		return bLoginCheck;
	}

}