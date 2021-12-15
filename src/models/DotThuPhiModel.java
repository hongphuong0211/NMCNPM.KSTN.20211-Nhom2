/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class DotThuPhiModel {
    private LocalDate ngayBatDau;
    private String tenDotThuPhi;
    private int soTienMoiNhanKhau;

    public DotThuPhiModel(LocalDate ngayBatDau, String tenDotThuPhi, int soTienMoiNhanKhau) {
        this.ngayBatDau = ngayBatDau;
        this.tenDotThuPhi = tenDotThuPhi;
        this.soTienMoiNhanKhau = soTienMoiNhanKhau;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public String getTenDotThuPhi() {
        return tenDotThuPhi;
    }

    public int getSoTienMoiNhanKhau() {
        return soTienMoiNhanKhau;
    }
}
