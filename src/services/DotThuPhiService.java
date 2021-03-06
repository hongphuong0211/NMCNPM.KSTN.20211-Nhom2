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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author t2s
 */
public class DotThuPhiService {
     //them moi dotthuphi
    public boolean addNew(DotThuPhiBean dotThuPhiBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO dot_thu_phi(ma_dot_thu_phi,`so_tien_/1_nguoi`, ten_dot_thu_phi, ngay_bat_dau, ngay_ket_thuc)" 
                    + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
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
        DotThuPhiBean dotThuPhiBean = null;
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_thu_phi WHERE ma_dot_thu_phi = " + id;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.executeQuery();
            DotThuPhiModel thuPhi = new DotThuPhiModel();
            int check = 0;
            while (rs.next()) {
                thuPhi.setID(id);
                thuPhi.setSoTienMoiNhanKhau(rs.getInt("so_tien_/1_nguoi"));
                thuPhi.setTenDotThuPhi(rs.getString("ten_dot_thu_phi"));
                thuPhi.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                thuPhi.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));
                check = 1;
            }
            if (check == 1){
                dotThuPhiBean = new DotThuPhiBean();
                dotThuPhiBean.setDotThuPhi(thuPhi);
            }
            preparedStatement.close();
        } catch(Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        
        return dotThuPhiBean;
    }
    
    public List<DotThuPhiBean> getListDotThuPhi() {
        List<DotThuPhiBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM dot_thu_phi ORDER BY ngay_bat_dau DESC";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                DotThuPhiBean dotThuPhiBean = new DotThuPhiBean();
                DotThuPhiModel thuPhi = new DotThuPhiModel();
                thuPhi.setID(rs.getInt("ma_dot_thu_phi"));
                thuPhi.setSoTienMoiNhanKhau(rs.getInt("so_tien_/1_nguoi"));
                thuPhi.setTenDotThuPhi(rs.getString("ten_dot_thu_phi"));
                thuPhi.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                thuPhi.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));
                dotThuPhiBean.setDotThuPhi(thuPhi);
                list.add(dotThuPhiBean);
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
    public List<DotThuPhiBean> search(String keyword) {
        List<DotThuPhiBean> list = new  ArrayList<>();
        String query;
        if (keyword.trim().isEmpty()) {
            return this.getListDotThuPhi();
        }
        // truy cap db
        // create query
        try {
            int a = Integer.parseInt(keyword);
            query = "SELECT * "
                    + "FROM dot_thu_phi "
                    + "WHERE dot_thu_phi.ma_dot_thu_phi = "
                    + keyword;
        } catch (Exception e) {
            query = "SELECT * "
                    + "FROM dot_thu_phi "
                    + "WHERE ten_dot_thu_phi like '"
                    + keyword
                    + "';";
        }
        
        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                DotThuPhiModel dotThuPhi = new DotThuPhiModel();
                dotThuPhi.setID(rs.getInt("ma_dot_thu_phi"));
                dotThuPhi.setTenDotThuPhi(rs.getString("ten_dot_thu_phi"));
                dotThuPhi.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                dotThuPhi.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));
                dotThuPhi.setSoTienMoiNhanKhau(rs.getInt("so_tien_/1_nguoi"));
                DotThuPhiBean dotThuPhiBean = new DotThuPhiBean(dotThuPhi);
                list.add(dotThuPhiBean);
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