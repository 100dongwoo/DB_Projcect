import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.sql.Connection;
import java.util.ArrayList;

public class facilityView extends JFrame {
    DBManager dbm;
    private JFrame frame;
    private final String[] colName = {"건물번호", "호실번호", "시설명", "관리자"};
    public DefaultTableModel model = new DefaultTableModel(colName, 0);

    public facilityView(DBManager dbm) {
        this.dbm = dbm;
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        //GUI
        frame = new JFrame();
        frame.setBounds(100, 100, 716, 517);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("시설물 전체 조회");
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(52, 10, 576, 59);
        frame.getContentPane().add(lblNewLabel);
        //
        ArrayList<Facility> facilitys;
        facilitys = dbm.selectFacility();
        model = new DefaultTableModel(colName, 0);
        model.addRow(colName);
        for (Facility rental : facilitys) {
            String[] row = new String[4];
            row[0] = String.valueOf(rental.getFacilityNumber());
            row[1] = String.valueOf(rental.getRoom());
            row[2] = String.valueOf(rental.getName());
            row[3] = String.valueOf(rental.getManager());
            model.addRow(row);
        }
        JTable table = new JTable(model);
        table.setBounds(12, 79, 677, 389);
        frame.getContentPane().add(table);
    }

}
