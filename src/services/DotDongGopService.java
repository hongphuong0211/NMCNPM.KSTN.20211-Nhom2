/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import Bean.DotDongGopBean;
import Bean.DotDongGopBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.DotDongGopModel;
import models.DotDongGopModel;

/**
 *
 * @author t2s
 */
public class DotDongGopService {
    // them moi dotdonggop
    public boolean addNew(DotDongGopBean dotDongGopBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO dot_ung_ho(ma_dot_ung_ho, ten_dot_ung_ho, ngay_bat_dau, ngau_ket_thuc)" 
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
        DotDongGopBean dotDongGopBean = null;
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_ung_ho WHERE ma_dot_ung_ho = " + id;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();
            DotDongGopModel dongGop = new DotDongGopModel();
            int check = 0;
            while (rs.next()) {
                dongGop.setID(id);
               
                dongGop.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                dongGop.setNgayKetThuc(rs.getDate("ngau_ket_thuc"));
                check = 1;
            }
            if (check == 1){
                dotDongGopBean = new DotDongGopBean();
                dotDongGopBean.setDotDongGop(dongGop);
            }
            preparedStatement.close();
        } catch(Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        
        return dotDongGopBean;
    }
     public List<DotDongGopBean> getListDotDongGop() {
        List<DotDongGopBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_ung_ho";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                DotDongGopModel donggop = new DotDongGopModel();
                donggop.setID(rs.getInt("ma_dot_ung_ho"));
                donggop.setTenDotDongGop(rs.getString("ten_dot_ung_ho"));
                donggop.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                donggop.setNgayKetThuc(rs.getDate("ngau_ket_thuc"));
                DotDongGopBean dotDongGopBean = new DotDongGopBean(donggop);
                list.add(dotDongGopBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
     
     /*
     * ham tim kiem dot thu phi theo ten
     */
    public List<DotDongGopBean> search(String keyword) {
        List<DotDongGopBean> list = new  ArrayList<>();
        String query;
        if (keyword.trim().isEmpty()) {
            return this.getListDotDongGop();
        }
        // truy cap db
        // create query
        try {
            int a = Integer.parseInt(keyword);
            query = "SELECT * "
                    + "FROM dot_ung_ho "
                    + "WHERE dot_ung_ho.ma_dot_ung_ho = "
                    + keyword;
        } catch (Exception e) {
            query = "SELECT * "
                    + "FROM dot_ung_ho "
                    + "WHERE ten_dot_ung_ho like '"
                    + keyword
                    + "';";
        }
        
        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                DotDongGopModel donggop = new DotDongGopModel();
                donggop.setID(rs.getInt("ma_dot_ung_ho"));
                donggop.setTenDotDongGop(rs.getString("ten_dot_ung_ho"));
                donggop.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                donggop.setNgayKetThuc(rs.getDate("ngau_ket_thuc"));
                DotDongGopBean dotDongGopBean = new DotDongGopBean(donggop);
                list.add(dotDongGopBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
     private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}