/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import Bean.DotDongGopBean;
import Bean.HoKhauBean;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import services.ThongTinDongGopService;

/**
 *
 * @author t2s
 */
public class DongGopTableModel {
    public DefaultTableModel setTableThongTinDongGop(DotDongGopBean dotDongGop, List<HoKhauBean> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        ThongTinDongGopService service = new ThongTinDongGopService();
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((HoKhauBean item) -> {  
            obj[0] = item.getHoKhauModel().getID();
            obj[1] = item.getHoKhauModel().getDiaChi();
            obj[2] = item.getHoKhauModel().getSoThanhVien();
                try {
                obj[3] = service.tongTienMoiHoKhau(dotDongGop, item);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DongGopTableModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DongGopTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            dtm.addRow(obj);
            
        });
        return dtm;
    }
    
     public DefaultTableModel setTableThongKeDongGop(List<DotDongGopBean> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        ThongTinDongGopService service = new ThongTinDongGopService();
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((DotDongGopBean item) -> { 
            obj[0] = item.getDotDongGop().getID();
            obj[1] = item.getDotDongGop().getTenDotDongGop();           
            obj[2] = item.getDotDongGop().getNgayBatDau();
            obj[3] = item.getDotDongGop().getNgayKetThuc();
            try {
                obj[4] = service.tongTienMoiDot(item);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DongGopTableModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DongGopTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                obj[5] = service.soHoKhauDongGop(item);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DongGopTableModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DongGopTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print("-" + obj[5]);
            dtm.addRow(obj);
        });
        return dtm;
    }
    
}