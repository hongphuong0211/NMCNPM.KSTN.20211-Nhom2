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


/**
 *
 * @author Hai
 */
public class DongGopPanelController {
    private List<HoKhauBean> list;
    private JTextField searchJtf;
    private JPanel tableJpn;
    private final HoKhauService hoKhauService = new HoKhauService();
    private final DongGopTableModel thuPhiTableModel = new DongGopTableModel();
    private final String COLUNMS[] = {"Mã hộ khẩu", "Địa chỉ", "Số thành viên", "Số tiền"}; 
    private JFrame parentJFrame;
    private DotDongGopBean DotDongGop = new DotDongGopBean();
    private DotDongGopService dotDongGopService = new DotDongGopService();
    
    public DongGopPanelController(JTextField searchJtf, JPanel tableJpn) {
        this.searchJtf = searchJtf;
        this.tableJpn = tableJpn;
        this.list = hoKhauService.getListHoKhau();
//        DotDongGopModel dotDongGopModel = new DotDongGopModel();
//        dotDongGopModel.setID(1);
//        dotDongGopModel.setSoTienMoiNhanKhau(10);
//        dotDongGopModel.setTenDotDongGop("test1");
//        this.DotDongGop.setDotDongGop(dotDongGopModel);
        
        this.DotDongGop = this.dotDongGopService.getDotDongGop(1);
        setData();
        initAction();
        // them dot thu phi model
//        try{
//        String sDate1="0/09/1990";  
//            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//        }
//        catch(Exception e){
//        }
//        dotDongGopModel.setNgayBatDau("date1");
//        dotDongGopModel.setNgayKetThuc("1990-09-2");
        
        
    }
    
    public int search(int id){
        DotDongGopBean tmp = this.dotDongGopService.getDotDongGop(id);
        if (tmp != null) {
            this.DotDongGop = tmp;
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public void initAction() {
        this.searchJtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    list = hoKhauService.getListHoKhau();
                } else {
                    list = hoKhauService.search(key);
                }
                setData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    list = hoKhauService.getListHoKhau();
                } else {
                    list = hoKhauService.search(key);
                }
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = searchJtf.getText().trim();
                if (key.isEmpty()) {
                    list = hoKhauService.getListHoKhau();
                } else {
                    list = hoKhauService.search(key);
                }
                setData();
            }
        });
    }

    public void setData() {
        DefaultTableModel model = thuPhiTableModel.setTableThongTinDongGop(DotDongGop, list, COLUNMS);
        
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
                    HoKhauBean temp = list.get(table.getSelectedRow());
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
    
    public void refreshData(){ 
        this.list = hoKhauService.getListHoKhau();
        setData();
        initAction();
    }
    
    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public List<HoKhauBean> getList() {
        return list;
    }

    public void setList(List<HoKhauBean> list) {
        this.list = list;
    }

    public JTextField getSearchJtf() {
        return searchJtf;
    }

    public void setSearchJtf(JTextField searchJtf) {
        this.searchJtf = searchJtf;
    }

    public JPanel getTableJpn() {
        return tableJpn;
    }

    public void setTableJpn(JPanel tableJpn) {
        this.tableJpn = tableJpn;
    }
    
}
