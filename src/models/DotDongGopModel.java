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
public class DotDongGopModel {
    private LocalDate ngayBatDau;
    private String tenDotDongGop;

    public DotDongGopModel(LocalDate ngayBatDau, String tenDotDongGop) {
        this.ngayBatDau = ngayBatDau;
        this.tenDotDongGop = tenDotDongGop;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public String getTenDotDongGop() {
        return tenDotDongGop;
    }
}
