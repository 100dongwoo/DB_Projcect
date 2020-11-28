import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView {

    private JFrame frame;
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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView window = new MainView();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 922, 618);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(748, 33, 147, 33);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(748, 73, 147, 33);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(748, 116, 147, 33);
        frame.getContentPane().add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(748, 159, 147, 33);
        frame.getContentPane().add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(748, 202, 147, 33);
        frame.getContentPane().add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(748, 245, 147, 33);
        frame.getContentPane().add(textField_5);

        textField_6 = new JTextField();
        textField_6.setBounds(748, 299, 147, 252);
        frame.getContentPane().add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel = new JLabel("\uC2DC\uC124");
        lblNewLabel.setBounds(681, 42, 57, 15);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\uD638\uC2E4");
        lblNewLabel_1.setBounds(681, 82, 57, 15);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("\uD5C8\uAC00\uC790");
        lblNewLabel_1_1.setBounds(679, 125, 57, 15);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("\uC2DC\uC791\uAE30\uAC04");
        lblNewLabel_1_2.setBounds(679, 168, 57, 15);
        frame.getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_2_1 = new JLabel("\uC885\uB8CC\uAE30\uAC04");
        lblNewLabel_1_2_1.setBounds(681, 211, 57, 15);
        frame.getContentPane().add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_1_2_2 = new JLabel("\uC778\uC6D0");
        lblNewLabel_1_2_2.setBounds(679, 254, 57, 15);
        frame.getContentPane().add(lblNewLabel_1_2_2);

        JLabel lblNewLabel_1_2_3 = new JLabel("\uC0AC\uC720");
        lblNewLabel_1_2_3.setBounds(681, 306, 57, 15);
        frame.getContentPane().add(lblNewLabel_1_2_3);

        JButton btnNewButton = new JButton("\uC804\uCCB4\uC870\uD68C");
        btnNewButton.setBounds(30, 21, 639, 56);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("\uC2DC\uC791\uAE30\uAC04");
        lblNewLabel_2.setBounds(37, 109, 48, 15);
        frame.getContentPane().add(lblNewLabel_2);

        textField_7 = new JTextField();
        textField_7.setBounds(96, 106, 177, 21);
        frame.getContentPane().add(textField_7);
        textField_7.setColumns(10);

        lblNewLabel_3 = new JLabel("\uC885\uB8CC\uAE30\uAC04");
        lblNewLabel_3.setBounds(299, 112, 48, 15);
        frame.getContentPane().add(lblNewLabel_3);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(358, 109, 177, 21);
        frame.getContentPane().add(textField_8);

        btnNewButton_1 = new JButton("\uAE30\uAC04 \uC870\uD68C");
        btnNewButton_1.setBounds(560, 105, 97, 23);
        frame.getContentPane().add(btnNewButton_1);

        btnNewButton_2 = new JButton("\uC2DC\uC124 \uC870\uD68C");
        btnNewButton_2.setBounds(560, 147, 97, 23);
        frame.getContentPane().add(btnNewButton_2);

        btnNewButton_3 = new JButton("\uC0AC\uC720 \uC870");
        btnNewButton_3.setBounds(560, 190, 97, 23);
        frame.getContentPane().add(btnNewButton_3);

        lblNewLabel_4 = new JLabel("\uC2DC\uC124\uBA85");
        lblNewLabel_4.setBounds(37, 149, 48, 15);
        frame.getContentPane().add(lblNewLabel_4);

        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(96, 149, 439, 21);
        frame.getContentPane().add(textField_10);

        lblNewLabel_6 = new JLabel("\uC0AC\uC720");
        lblNewLabel_6.setBounds(37, 192, 48, 15);
        frame.getContentPane().add(lblNewLabel_6);

        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(96, 192, 439, 43);
        frame.getContentPane().add(textField_12);

        table = new JTable();
        table.setBounds(52, 254, 615, 231);
        frame.getContentPane().add(table);

        btnNewButton_4 = new JButton("\uC608\uC57D \uCDE8\uC18C");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_4.setBounds(41, 495, 639, 56);
        frame.getContentPane().add(btnNewButton_4);
    }
}
