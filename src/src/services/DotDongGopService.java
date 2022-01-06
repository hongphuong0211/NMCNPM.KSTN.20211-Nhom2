/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import Bean.DotDongGopBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import models.DotDongGopModel;

/**
 *
 * @author t2s
 */
public class DotDongGopService {
    // them moi dotdonggop
    public boolean addNew(DotDongGopBean dotDongGopBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO dot_ung_ho(ma_dot_ung_ho, ten_dot_ung_ho, ngay_bat_dau, ngay_ket_thuc)" 
                    + " values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, dotDongGopBean.getDotDongGop().getID());
        preparedStatement.setString(2, dotDongGopBean.getDotDongGop().getTenDotDongGop());
        preparedStatement.setDate(3, (Date) dotDongGopBean.getDotDongGop().getNgayBatDau());
        preparedStatement.setDate(4, (Date) dotDongGopBean.getDotDongGop().getNgayKetThuc());
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();
        return true;
    }
  
    // chon dot dong gop theo id
    public DotDongGopBean getDotDongGop(int id) {
        DotDongGopBean dotDongGopBean = new DotDongGopBean();
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_ung_ho WHERE ma_dot_ung_ho = " + id;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DotDongGopModel dongGop = new DotDongGopModel();
                dongGop.setID(id);
                dongGop.setTenDotDongGop(rs.getString("ten_dot_ung_ho"));
                dongGop.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                dongGop.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));
            }
            preparedStatement.close();
        } catch(Exception e) {
            this.exceptionHandle(e.getMessage());
        }
       
        return dotDongGopBean;
    }
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}