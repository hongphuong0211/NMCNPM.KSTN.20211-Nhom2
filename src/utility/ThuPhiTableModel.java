/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import services.ThongTinThuPhiService;
import Bean.DotThuPhiBean;
import Bean.HoKhauBean;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author t2s
 */
public class ThuPhiTableModel {
    public DefaultTableModel setTableThongTinThuPhi(DotThuPhiBean dotThuPhi, List<HoKhauBean> listItem, String[] listColumn) {
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
        ThongTinThuPhiService service = new ThongTinThuPhiService();
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((HoKhauBean item) -> {  
            obj[0] = item.getHoKhauModel().getID();
            obj[1] = item.getHoKhauModel().getDiaChi();
            obj[2] = item.getHoKhauModel().getSoThanhVien();
            int so_tien_moi_nguoi = dotThuPhi.getDotThuPhi().getSoTienMoiNhanKhau();
//            obj[3] = obj[2];
            try {
//                service.tongTienMoiHoKhau(dotThuPhi, item);
                obj[3] = service.tongTienMoiHoKhau(dotThuPhi, item) + "/" + item.getHoKhauModel().getSoThanhVien()*so_tien_moi_nguoi;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThuPhiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThuPhiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            dtm.addRow(obj);
            
        });
        return dtm;
    }
   
    public DefaultTableModel setTableThongKeThuPhi(List<DotThuPhiBean> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        ThongTinThuPhiService service = new ThongTinThuPhiService();
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((DotThuPhiBean item) -> { 
            obj[0] = item.getDotThuPhi().getID();
            obj[1] = item.getDotThuPhi().getTenDotThuPhi();
            obj[2] = item.getDotThuPhi().getSoTienMoiNhanKhau();
            obj[3] = item.getDotThuPhi().getNgayBatDau();
            obj[4] = item.getDotThuPhi().getNgayKetThuc();
            try {
                obj[5] = service.tongTienMoiDot(item);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThuPhiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThuPhiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                obj[6] = service.SoHoKhauNopDuTien(item);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThuPhiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThuPhiTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            dtm.addRow(obj);
        });
        return dtm;
    }
    
}