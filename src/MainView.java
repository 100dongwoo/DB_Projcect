import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
public class MainView  extends  JFrame{
    String User="";
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JLabel lblNewLabel_3;
    private JTextField textField_8;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JLabel lblNewLabel_4;
    private JTextField textField_10;
    private JLabel lblNewLabel_6;
    private JTextField textField_12;
    private JTable table;
    private JButton btnNewButton_4;
    private JButton allSearch;
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    MainView window = new MainView();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public MainView(String user) {
        // setting
        User=user;
        setTitle("MainPage");
        setSize(922, 684);
        setResizable(false);
        setLocation(100, 100);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //화면중간
        // panel
        JPanel panel = new JPanel();
        initialize(panel);
        add(panel);
        setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(JPanel frame) {
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(747, 64, 147, 33);
        frame.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(747, 104, 147, 33);
        frame.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(747, 147, 147, 33);
        frame.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(747, 190, 147, 33);
        frame.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(747, 233, 147, 33);
        frame.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(747, 276, 147, 33);
        frame.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setBounds(747, 330, 147, 252);
        frame.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel = new JLabel("\uC2DC\uC124");
        lblNewLabel.setBounds(680, 73, 57, 15);
        frame.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\uD638\uC2E4");
        lblNewLabel_1.setBounds(680, 113, 57, 15);
        frame.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("\uD5C8\uAC00\uC790");
        lblNewLabel_1_1.setBounds(678, 156, 57, 15);
        frame.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("\uC2DC\uC791\uAE30\uAC04");
        lblNewLabel_1_2.setBounds(678, 199, 57, 15);
        frame.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_2_1 = new JLabel("\uC885\uB8CC\uAE30\uAC04");
        lblNewLabel_1_2_1.setBounds(680, 242, 57, 15);
        frame.add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_1_2_2 = new JLabel("\uC778\uC6D0");
        lblNewLabel_1_2_2.setBounds(678, 285, 57, 15);
        frame.add(lblNewLabel_1_2_2);

        JLabel lblNewLabel_1_2_3 = new JLabel("\uC0AC\uC720");
        lblNewLabel_1_2_3.setBounds(680, 337, 57, 15);
        frame.add(lblNewLabel_1_2_3);

        allSearch = new JButton("\uC804\uCCB4\uC870\uD68C"); //전체조회버튼
        allSearch.setBounds(29, 20, 639, 67);
        frame.add(allSearch);

        JLabel lblNewLabel_2 = new JLabel("\uC2DC\uC791\uAE30\uAC04");
        lblNewLabel_2.setBounds(36, 119, 48, 15);
        frame.add(lblNewLabel_2);

        textField_7 = new JTextField();
        textField_7.setBounds(95, 116, 177, 21);
        frame.add(textField_7);
        textField_7.setColumns(10);

        lblNewLabel_3 = new JLabel("\uC885\uB8CC\uAE30\uAC04");
        lblNewLabel_3.setBounds(297, 119, 48, 15);
        frame.add(lblNewLabel_3);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(357, 119, 177, 21);
        frame.add(textField_8);

        btnNewButton_1 = new JButton("\uAE30\uAC04 \uC870\uD68C"); //기간조회버튼
        btnNewButton_1.setBounds(559, 115, 97, 23);
        frame.add(btnNewButton_1);

        btnNewButton_2 = new JButton("\uC2DC\uC124 \uC870\uD68C");  //시설조회버튼
        btnNewButton_2.setBounds(559, 157, 97, 23);
        frame.add(btnNewButton_2);

        btnNewButton_3 = new JButton("\uC0AC\uC720 \uC870\uD68C");//사유조회버튼
        btnNewButton_3.setBounds(559, 200, 97, 23);
        frame.add(btnNewButton_3);

        lblNewLabel_4 = new JLabel("\uC2DC\uC124\uBA85");//예약취소버튼
        lblNewLabel_4.setBounds(36, 159, 48, 15);
        frame.add(lblNewLabel_4);

        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(95, 153, 439, 21);
        frame.add(textField_10);

        lblNewLabel_6 = new JLabel("\uC0AC\uC720");
        lblNewLabel_6.setBounds(36, 202, 48, 15);
        frame.add(lblNewLabel_6);

        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(95, 185, 439, 43);
        frame.add(textField_12);

        table = new JTable();
        table.setBounds(51, 255, 615, 261);
        frame.add(table);

        btnNewButton_4 = new JButton("\uC608\uC57D \uCDE8\uC18C");//예약취소버튼
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_4.setBounds(40, 526, 639, 56);
        frame.add(btnNewButton_4);

        JLabel userName = new JLabel(User);
        userName.setFont(new Font("굴림", Font.BOLD, 25));
        userName.setBounds(749, 20, 132, 34);
        frame.add(userName);

        JButton btnNewButton_5 = new JButton("\uC2E0\uCCAD\uD558\uAE30"); //신청하기
        btnNewButton_5.setBounds(747, 592, 147, 33);
        frame.add(btnNewButton_5);
    }
}
