/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Bean.DotThuPhiBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import models.DotThuPhiModel;

/**
 *
 * @author t2s
 */
public class DotThuPhiService {
     //them moi dotthuphi
    public boolean addNew(DotThuPhiBean dotThuPhiBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO dot_thu_phi(ma_dot_thu_phi,so_tien_/1_nguoi, ten_dot_ung_ho, ngay_bat_dau, ngay_ket_thuc)" 
                    + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, dotThuPhiBean.getDotThuPhi().getID());
        preparedStatement.setInt(2, dotThuPhiBean.getDotThuPhi().getSoTienMoiNhanKhau());
        preparedStatement.setString(3, dotThuPhiBean.getDotThuPhi().getTenDotThuPhi());
        preparedStatement.setDate(4, (Date) dotThuPhiBean.getDotThuPhi().getNgayBatDau());
        preparedStatement.setDate(5, (Date) dotThuPhiBean.getDotThuPhi().getNgayKetThuc());
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();
        return true;
    }
  
    // chon dot thu phi theo id
    public DotThuPhiBean getDotThuPhi(int id) {
        DotThuPhiBean dotThuPhiBean = new DotThuPhiBean();
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_thu_phi WHERE ma_dot_thu_phi = " + id;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DotThuPhiModel thuPhi = new DotThuPhiModel();
                thuPhi.setID(id);
                thuPhi.setSoTienMoiNhanKhau(rs.getInt("so_tien_/1_nguoi"));
                thuPhi.setTenDotThuPhi(rs.getString("ten_dot_thu_phi"));
                thuPhi.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                thuPhi.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));
            }
            preparedStatement.close();
        } catch(Exception e) {
            this.exceptionHandle(e.getMessage());
        }
       
        return dotThuPhiBean;
    }
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
     
}
