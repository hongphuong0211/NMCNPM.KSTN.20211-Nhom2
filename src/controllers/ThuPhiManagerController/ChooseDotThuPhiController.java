/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.ThuPhiManagerController;

import Bean.DotThuPhiBean;
//import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
//import services.HoKhauService;
import services.DotThuPhiService;
import utility.ThuPhiTableModel;

/**
 *
 * @author Admin
 */
public class ChooseDotThuPhiController {
    private DotThuPhiBean dotthuphiBean;
    private JTextField searchJtf;
    private JTextField selectedJtf;
    private JPanel tableJPanel;
    private List<DotThuPhiBean> list;
    
    //private final HoKhauService hoKhauService = new HoKhauService();
    private final DotThuPhiService thuphiService = new DotThuPhiService();
    private final ThuPhiTableModel tableModelHoKhau  = new ThuPhiTableModel();
    private final String[] COLUMNS = {"Mã đợt thu phí", "Tên đợt thu phí", "Số tiền mỗi nhân khẩu", "Ngày bắt đầu", "Ngày kết thúc"};
    
    public ChooseDotThuPhiController(DotThuPhiBean thuphiBean, JTextField searchJtf, JTextField selectedJtf, JPanel tableJPanel) {
        this.dotthuphiBean = thuphiBean;
        this.searchJtf = searchJtf;
        this.selectedJtf = selectedJtf;
        this.tableJPanel = tableJPanel;
        this.list = this.thuphiService.getListDotThuPhi();
        setData();
        initAction();
    }
    
    public void initAction() {
        this.searchJtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = searchJtf.getText();
                list = thuphiService.search(key.trim());
                setData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = searchJtf.getText();
                list = thuphiService.search(key.trim());
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = searchJtf.getText();
                list = thuphiService.search(key.trim());
                setData();
            }
        });
    }
    
    public void setData() {
        DefaultTableModel model = this.tableModelHoKhau.setTableThuPhi(this.list, COLUMNS);
        JTable table = new JTable(model){
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;   //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table.setRowHeight(30);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {
                    JOptionPane.showMessageDialog(null, "aa");
                }
                DotThuPhiBean temp = list.get(table.getSelectedRow());
                dotthuphiBean.setDotThuPhi(temp.getDotThuPhi());
                selectedJtf.setText(temp.getDotThuPhi().getTenDotThuPhi());
            }
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        tableJPanel.removeAll();
        tableJPanel.setLayout(new BorderLayout());
        tableJPanel.add(scroll);
        tableJPanel.validate();
        tableJPanel.repaint();
    }

   

    public JTextField getSearchJtf() {
        return searchJtf;
    }

    public void setSearchJtf(JTextField searchJtf) {
        this.searchJtf = searchJtf;
    }

    public JPanel getTableJPanel() {
        return tableJPanel;
    }

    public void setTableJPanel(JPanel tableJPanel) {
        this.tableJPanel = tableJPanel;
    }

    public JTextField getSelectedJtf() {
        return selectedJtf;
    }

    public void setSelectedJtf(JTextField selectedJtf) {
        this.selectedJtf = selectedJtf;
    }

    public DotThuPhiBean getDotthuphiBean() {
        return dotthuphiBean;
    }

    public void setDotthuphiBean(DotThuPhiBean dotthuphiBean) {
        this.dotthuphiBean = dotthuphiBean;
    }
    

    public List<DotThuPhiBean> getList() {
        return list;
    }

    public void setList(List<DotThuPhiBean> list) {
        this.list = list;
    }   
    
}
