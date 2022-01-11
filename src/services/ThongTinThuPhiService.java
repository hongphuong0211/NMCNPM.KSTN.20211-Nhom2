 /** Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import Bean.ThongTinThuPhiBean;
import Bean.DotThuPhiBean;
import Bean.HoKhauBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import models.ThongTinThuPhiModel;

/**
 *
 * @author t2s
 */
public class ThongTinThuPhiService {
    //ghi nhan thu phi
    public boolean addNew(ThongTinThuPhiBean thongTinThuPhiBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO thong_tin_thu_phi(ma_dot_thu_phi, idHoKhau, ngay_thu_phi, so_tien)" 
                    + " values (?, ?, NOW(), ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, thongTinThuPhiBean.getDotThuPhi().getID());
        preparedStatement.setInt(2, thongTinThuPhiBean.getHoKhau().getID());
        preparedStatement.setInt(4, thongTinThuPhiBean.getThongTinThuPhi().getSoTien());
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();
        return true;
    }
    
    
    public int tongTienMoiHoKhau(DotThuPhiBean dotThuPhi, HoKhauBean hoKhau) throws ClassNotFoundException, SQLException {
        int dotThuPhiId = dotThuPhi.getDotThuPhi().getID();
        int hoKhauId = hoKhau.getHoKhauModel().getID();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT ma_dot_thu_phi, idHoKhau, SUM(so_tien) as Tong FROM thong_tin_thu_phi WHERE ma_dot_thu_phi = " 
                    + dotThuPhiId
                    + " AND idHoKhau = "
                    + hoKhauId
                    + " GROUP BY ma_dot_thu_phi, idHoKhau;";
        
        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = preparedStatement.executeQuery();
        int result = 0;
        while (rs.next()){
            result = rs.getInt("Tong");
        }
        return result;
    }   
    
    
    public int tongTienMoiDot(DotThuPhiBean dotThuPhi) throws ClassNotFoundException, SQLException {
        int dotThuPhiId = dotThuPhi.getDotThuPhi().getID();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT ma_dot_thu_phi, SUM(so_tien) as Tong FROM thong_tin_thu_phi WHERE ma_dot_thu_phi = "
                    + dotThuPhiId + " GROUP BY ma_dot_thu_phi;";
        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = preparedStatement.executeQuery();
         int result = 0;
        while (rs.next()){
            result = rs.getInt("Tong");
        }
        return result;
        
    }
    
    public int SoHoKhauNopDuTien(DotThuPhiBean dotThuPhi) throws ClassNotFoundException, SQLException {
        int dotThuPhiId = dotThuPhi.getDotThuPhi().getID();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT COUNT(*) as Number\n" +
            "FROM (SELECT ma_dot_thu_phi, idHoKhau, SUM(so_tien) as Tong\n" +
            "    FROM thong_tin_thu_phi\n" +
            "    WHERE ma_dot_thu_phi = " + dotThuPhiId + "\n" +
            "    GROUP BY ma_dot_thu_phi, idHoKhau) as x, ho_khau as h, dot_thu_phi as d\n" +
            "   	WHERE d.ma_dot_thu_phi = x.ma_dot_thu_phi AND h.ID = x.idHoKhau \n" +
            "    	AND x.Tong >= h.soThanhVien * d.`so_tien_/1_nguoi`";
        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = preparedStatement.executeQuery();
         int result = 0;
        while (rs.next()){
            System.out.print(rs.getInt("Number") + '\n');
            result = rs.getInt("Number");
        }
        return result;
    }

    
}