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
public class DotDongGopModel {
    private Date ngayBatDau;
    private String tenDotDongGop;
    private int ID;
    private Date ngayKetThuc;
 
//    public DotDongGopModel(int ID, String tenDotDongGop, Date ngayBatDau, Date ngayKetThuc) {
//        this.ID = ID;
//        this.tenDotDongGop = tenDotDongGop;
//        this.ngayBatDau = ngayBatDau;
//        this.ngayKetThuc = ngayKetThuc;
//    }
    public Date getNgayBatDau() {
        return this.ngayBatDau;
    }
    public void setNgayBatDau(Date ngay) {
        this.ngayBatDau = ngay;
    }
    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
               
    }
    public void setNgayKetThuc(Date ngay) {
        this.ngayKetThuc = ngay;
    }
    public String getTenDotDongGop() {
        return this.tenDotDongGop;
    }
    public void setTenDotDongGop(String ten) {
        this.tenDotDongGop = ten;
    }
    public int getID() {
        return this.ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}