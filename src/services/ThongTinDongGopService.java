/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Bean.ThongTinDongGopBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
}