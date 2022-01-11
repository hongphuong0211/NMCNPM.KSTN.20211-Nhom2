/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class DotThuPhiModel {
    private int ID;
    private String tenDotThuPhi;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int soTienMoiNhanKhau;

//    public DotThuPhiModel(int ID, int SoTienMoiNhanKhau, String tenDotThuPhi, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
//        this.ngayBatDau = ngayBatDau;
//        this.tenDotThuPhi = tenDotThuPhi;
//        this.soTienMoiNhanKhau = soTienMoiNhanKhau;
//        this.ID = ID;
//        this.ngayKetThuc = ngayKetThuc;
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenDotThuPhi() {
        return tenDotThuPhi;
    }

    public void setTenDotThuPhi(String tenDotThuPhi) {
        this.tenDotThuPhi = tenDotThuPhi;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getSoTienMoiNhanKhau() {
        return soTienMoiNhanKhau;
    }

    public void setSoTienMoiNhanKhau(int soTienMoiNhanKhau) {
        this.soTienMoiNhanKhau = soTienMoiNhanKhau;
    }
    
}