/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author t2s
 */
public class ThongTinThuPhiModel {
    private int dongGopID;
    private int hoKhauID;
    private Date ngayDongGop;
    private int soTien;
    
    public void setThuPhiID(int id) {
        this.dongGopID = id;
    }
    public void setHoKhauID(int id) {
        this.hoKhauID = id;
    }
    public void setNgayThuPhi(Date ngay) {
        this.ngayDongGop = ngay;
    }
    public void setSoTien(int soTien) {
        this.soTien = soTien;
        
    }
    
    public int getThuPhiID() {
        return this.dongGopID;
    }
    public int getHoKhauID() {
        return this.hoKhauID;
    }
    public Date getNgayThuPhi() {
        return this.ngayDongGop;
    }
    public int getSoTien() {
        return this.soTien;
    }
}