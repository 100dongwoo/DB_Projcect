import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainView extends JFrame implements ActionListener {
    String userId;
    DBManager dbm;
    private String colName[];
    public DefaultTableModel model;
    private JPanel mainFrame;
    //button
    private JButton reasonInquiryButton;//사유조회
    private JButton allSearch; //전체조회
    private JButton inquiryPeriodButton; //기간조회
    private JButton inquiryFacilityButton; //시설조회
    private JButton cancleReservationButton;//취소버튼
    private JButton applyButton;//신청버튼

    //InquiryText
    private JTextField startDateInquirytext; //시작기간
    private JTextField endDateInquirytext; //종료기간
    private JTextField facilityInquirytext;//시설명
    private JTextField reasonInquirytext;//사유

    //delele번호
    private JTextField deleteNumberText;


    //applyText
    private JTextField applyFacilityText;       //시설
    private JTextField applyRoomText;     //호실
    private JTextField applyLicenserText;     //허가자
    private JTextField applyStartDate;     //시작기간
    private JTextField applyFinishDate;     //종료기간
    private JTextField applyPersonnelText;     //인원
    private JTextArea applyReasonText;     //사유
    private JTable table;       //출력 테이블


    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_6;

    public MainView(DBManager dbm, String userId) {
        // setting
        this.dbm = dbm;
        this.userId = userId;

        setTitle("MainPage");
        setSize(1082, 681);
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


    private void initialize(JPanel frame) {
        mainFrame = frame;

        frame.setLayout(null);
        applyFacilityText = new JTextField();
        applyFacilityText.setBounds(889, 64, 147, 33);
        frame.add(applyFacilityText);
        applyFacilityText.setColumns(10);

        applyRoomText = new JTextField();
        applyRoomText.setColumns(10);
        applyRoomText.setBounds(889, 104, 147, 33);
        frame.add(applyRoomText);

        applyLicenserText = new JTextField();
        applyLicenserText.setColumns(10);
        applyLicenserText.setBounds(889, 147, 147, 33);
        frame.add(applyLicenserText);

        applyStartDate = new JTextField();
        applyStartDate.setColumns(10);
        applyStartDate.setBounds(889, 190, 147, 33);
        frame.add(applyStartDate);

        applyFinishDate = new JTextField();
        applyFinishDate.setColumns(10);
        applyFinishDate.setBounds(889, 233, 147, 33);
        frame.add(applyFinishDate);

        applyPersonnelText = new JTextField();
        applyPersonnelText.setColumns(10);
        applyPersonnelText.setBounds(889, 276, 147, 33);
        frame.add(applyPersonnelText);

        applyReasonText = new JTextArea();       //사유
        applyReasonText.setBounds(889, 330, 147, 252);
        frame.add(applyReasonText);


        JLabel lblNewLabel = new JLabel("\uC2DC\uC124");
        lblNewLabel.setBounds(822, 73, 57, 15);
        frame.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\uD638\uC2E4");
        lblNewLabel_1.setBounds(822, 113, 57, 15);
        frame.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("\uD5C8\uAC00\uC790");
        lblNewLabel_1_1.setBounds(820, 156, 57, 15);
        frame.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("\uC2DC\uC791\uAE30\uAC04");
        lblNewLabel_1_2.setBounds(820, 199, 57, 15);
        frame.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_2_1 = new JLabel("\uC885\uB8CC\uAE30\uAC04");
        lblNewLabel_1_2_1.setBounds(822, 242, 57, 15);
        frame.add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_1_2_2 = new JLabel("\uC778\uC6D0");
        lblNewLabel_1_2_2.setBounds(820, 285, 57, 15);
        frame.add(lblNewLabel_1_2_2);

        JLabel lblNewLabel_1_2_3 = new JLabel("\uC0AC\uC720");
        lblNewLabel_1_2_3.setBounds(822, 337, 57, 15);
        frame.add(lblNewLabel_1_2_3);

        allSearch = new JButton("\uC804\uCCB4\uC870\uD68C"); //전체조회버튼
        allSearch.setBounds(29, 20, 781, 67);

        frame.add(allSearch);
        allSearch.addActionListener(this);

        JLabel lblNewLabel_2 = new JLabel("\uC2DC\uC791\uAE30\uAC04");
        lblNewLabel_2.setBounds(36, 119, 48, 15);
        frame.add(lblNewLabel_2);

        startDateInquirytext = new JTextField();
        startDateInquirytext.setBounds(95, 116, 177, 21);
        frame.add(startDateInquirytext);
        startDateInquirytext.setColumns(10);

        lblNewLabel_3 = new JLabel("\uC885\uB8CC\uAE30\uAC04");
        lblNewLabel_3.setBounds(297, 119, 48, 15);
        frame.add(lblNewLabel_3);

        endDateInquirytext = new JTextField();
        endDateInquirytext.setColumns(10);
        endDateInquirytext.setBounds(357, 119, 177, 21);
        frame.add(endDateInquirytext);

        inquiryPeriodButton = new JButton("\uAE30\uAC04 \uC870\uD68C"); //기간조회버튼
        inquiryPeriodButton.setBounds(559, 115, 251, 23);
        frame.add(inquiryPeriodButton);


        inquiryFacilityButton = new JButton("\uC2DC\uC124 \uC870\uD68C");  //시설조회버튼
        inquiryFacilityButton.setBounds(559, 157, 251, 23);
        frame.add(inquiryFacilityButton);
        inquiryFacilityButton.addActionListener(this);

        reasonInquiryButton = new JButton("\uC0AC\uC720 \uC870\uD68C");//사유조회버튼
        reasonInquiryButton.setBounds(559, 200, 251, 23);
        frame.add(reasonInquiryButton);
        reasonInquiryButton.addActionListener((this));

        lblNewLabel_4 = new JLabel("\uC2DC\uC124\uBA85");
        lblNewLabel_4.setBounds(36, 159, 48, 15);
        frame.add(lblNewLabel_4);

        facilityInquirytext = new JTextField();
        facilityInquirytext.setColumns(10);
        facilityInquirytext.setBounds(95, 153, 439, 21);
        frame.add(facilityInquirytext);

        lblNewLabel_6 = new JLabel("\uC0AC\uC720");
        lblNewLabel_6.setBounds(36, 202, 48, 15);
        frame.add(lblNewLabel_6);

        reasonInquirytext = new JTextField();
        reasonInquirytext.setColumns(10);
        reasonInquirytext.setBounds(95, 185, 439, 43);
        frame.add(reasonInquirytext);

        table = new JTable();
        table.setBounds(51, 255, 759, 261);
        frame.add(table);


        cancleReservationButton = new JButton("\uC608\uC57D \uCDE8\uC18C");//예약취소버튼
        cancleReservationButton.setBounds(243, 526, 567, 56);
        frame.add(cancleReservationButton);

        JLabel userName = new JLabel(userId);
        userName.setFont(new Font("굴림", Font.BOLD, 25));
        userName.setBounds(891, 20, 132, 34);
        frame.add(userName);

        applyButton= new JButton("\uC2E0\uCCAD\uD558\uAE30"); //신청하기
        applyButton.setBounds(889, 592, 147, 33);
        frame.add(applyButton);

        deleteNumberText = new JTextField();
        deleteNumberText.setBounds(95, 530, 109, 52);
        frame.add(deleteNumberText);
        deleteNumberText.setColumns(10);

        JLabel lblNewLabel_6_1 = new JLabel("\uB300\uC5EC\uBC88\uD638");
        lblNewLabel_6_1.setBounds(29, 537, 59, 35);
        frame.add(lblNewLabel_6_1);
    }

    public void actionPerformed(ActionEvent e) {
        String[] colName = {"대여번호", "시작기간", "종료기간", "인원", "사유", "동의인", "건물", "호실", "허가자"};
        model = new DefaultTableModel(colName, 0);
        String[] row = new String[9];
        model.addRow(colName);

        if (e.getSource() == allSearch) {
            ArrayList<Rental> rentals = dbm.selectRental();
            for (Rental rental : rentals) {
                row[0] = String.valueOf(rental.getRentalNumber());
                row[1] = String.valueOf(rental.getStartPeriod());
                row[2] = String.valueOf(rental.getEndPeriod());
                row[3] = String.valueOf(rental.getPersonnel());
                row[4] = String.valueOf(rental.getReason());
                row[5] = String.valueOf(rental.getDEUPerson());
                row[6] = String.valueOf(rental.getFacility());
                row[7] = String.valueOf(rental.getRoom());
                row[8] = String.valueOf(rental.getLicenser());
                model.addRow(row);
            }
        } else if (e.getSource() == inquiryFacilityButton) {
            ArrayList<Rental> rentals = dbm.selectRental(facilityInquirytext.getText());
            for (Rental rental : rentals) {
                row[0] = String.valueOf(rental.getRentalNumber());
                row[1] = String.valueOf(rental.getStartPeriod());
                row[2] = String.valueOf(rental.getEndPeriod());
                row[3] = String.valueOf(rental.getPersonnel());
                row[4] = String.valueOf(rental.getReason());
                row[5] = String.valueOf(rental.getDEUPerson());
                row[6] = String.valueOf(rental.getFacility());
                row[7] = String.valueOf(rental.getRoom());
                row[8] = String.valueOf(rental.getLicenser());
                model.addRow(row);
            }
        }
        else if (e.getSource() == reasonInquiryButton){
            ArrayList<Rental> rentals = dbm.selectRentalresaon(reasonInquirytext.getText());
            for(Rental rental : rentals){
                row[0] = String.valueOf(rental.getRentalNumber());
                row[1] = String.valueOf(rental.getStartPeriod());
                row[2] = String.valueOf(rental.getEndPeriod());
                row[3] = String.valueOf(rental.getPersonnel());
                row[4] = String.valueOf(rental.getReason());
                row[5] = String.valueOf(rental.getDEUPerson());
                row[6] = String.valueOf(rental.getFacility());
                row[7] = String.valueOf(rental.getRoom());
                row[8] = String.valueOf(rental.getLicenser());
                model.addRow(row);
            }
        }


        table = new JTable(model);
        table.setBounds(29, 255, 781, 261);
        table.getColumnModel().getColumn(1).setPreferredWidth(170);
        table.getColumnModel().getColumn(2).setPreferredWidth(170);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        mainFrame.add(table);
        setVisible(true);
    }
}