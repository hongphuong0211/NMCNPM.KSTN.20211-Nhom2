/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Bean.DotDongGopBean;
import Bean.HoKhauBean;
import Bean.ThongTinDongGopBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author t2s
 */
public class ThongTinDongGopService {
    
    //ghi nhan dong gop
    public boolean addNew(ThongTinDongGopBean thongTinDongGopBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO thong_tin_ung_ho(ma_dot_ung_ho, idHoKhau, ngayUngHo, so_tien)" 
                    + " values (?, ?, NOW(), ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, thongTinDongGopBean.getDotDongGopModel().getID());
        preparedStatement.setInt(2, thongTinDongGopBean.getHoKhauModel().getID());
        preparedStatement.setInt(4, thongTinDongGopBean.getThongTinDongGopModel().getSoTien());
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();
        return true;
    }
    public int tongTienMoiHoKhau(DotDongGopBean dotDongGop, HoKhauBean hoKhau) throws ClassNotFoundException, SQLException {
        int dotDongGopId = dotDongGop.getDotDongGop().getID();
        int hoKhauId = hoKhau.getHoKhauModel().getID();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT ma_dot_ung_ho, idHoKhau, SUM(so_tien) as Tong FROM thong_tin_ung_ho WHERE ma_dot_ung_ho = " 
                    + dotDongGopId
                    + " AND idHoKhau = "
                    + hoKhauId
                    + " GROUP BY ma_dot_ung_ho, idHoKhau;";
        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = preparedStatement.executeQuery();
        int result = 0;
        while (rs.next()){
            result = rs.getInt("Tong");
        }
        return result;
    }  
     public int tongTienMoiDot(DotDongGopBean dotDongGop) throws ClassNotFoundException, SQLException {
        int dotDongGopId = dotDongGop.getDotDongGop().getID();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT ma_dot_ung_ho, SUM(so_tien) as Tong FROM thong_tin_ung_ho WHERE ma_dot_ung_ho = "
                    + dotDongGopId + " GROUP BY ma_dot_ung_ho";
        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = preparedStatement.executeQuery();
         int result = 0;
        while (rs.next()){
            result = rs.getInt("Tong");
        }
        return result;
        
    }
     
     public int soHoKhauDongGop(DotDongGopBean dotDongGop) throws ClassNotFoundException, SQLException {
        int dotDongGopId = dotDongGop.getDotDongGop().getID();
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT COUNT(DISTINCT idHoKhau) as Number\n" +
                        "FROM thong_tin_ung_ho\n" +
                        "WHERE ma_dot_ung_ho = " + dotDongGopId;
        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = preparedStatement.executeQuery();
         int result = 0;
        while (rs.next()){
            result = rs.getInt("Number");
        }
        return result;
        
    }
    
    
    
}