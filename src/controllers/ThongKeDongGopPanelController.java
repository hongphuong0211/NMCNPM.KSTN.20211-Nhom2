package controllers;

import Bean.ThongTinDongGopBean;
import Bean.HoKhauBean;
import Bean.DotDongGopBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import services.HoKhauService;
import services.ThongTinDongGopService;
import services.DotDongGopService;
import utility.TableModelHoKhau;
import utility.DongGopTableModel;
import views.infoViews.InfoJframe;
import models.DotDongGopModel;
import java.util.Date;  
import java.text.SimpleDateFormat;  
import services.DotDongGopService;
import Bean.DotDongGopBean;


/**
 *
 * @author Hai
 */
public class ThongKeDongGopPanelController {
    private List<DotDongGopBean> list;
    private JTextField searchJtf;
    private JPanel tableJpn;
    private final HoKhauService hoKhauService = new HoKhauService();
    private final DongGopTableModel thuPhiTableModel = new DongGopTableModel();
    private final String COLUNMS[] = {"ID", "Tên đợt", "Ngày bắt đầu", "Ngày kết thúc", "Tổng tiền", "Số hộ khẩu nộp đủ"};
    private JFrame parentJFrame;
    private DotDongGopBean DotDongGop = new DotDongGopBean();
    private DotDongGopService dotDongGopService = new DotDongGopService();
    
    public ThongKeDongGopPanelController(JPanel tableJpn) {
        this.list = dotDongGopService.getListDotDongGop();
        this.tableJpn = tableJpn;

        this.DotDongGop = this.dotDongGopService.getDotDongGop(1);
        setData();
        initAction();
        
    }
    
    public void initAction() {
        list = this.dotDongGopService.getListDotDongGop();
        setData();
    }

    public void setData() {
        DefaultTableModel model = thuPhiTableModel.setTableThongKeDongGop(list, COLUNMS);
        
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    DotDongGopBean temp = list.get(table.getSelectedRow());
                    InfoJframe infoJframe = new InfoJframe(temp.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        tableJpn.removeAll();
        tableJpn.setLayout(new BorderLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();
    }
    
    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
}
