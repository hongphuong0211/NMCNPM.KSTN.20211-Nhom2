/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Bean.ThongTinThuPhiBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
}
