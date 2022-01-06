/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import models.DotThuPhiModel;
import models.HoKhauModel;
import models.ThongTinThuPhiModel;

/**
 *
 * @author t2s
 */
public class ThongTinThuPhiBean {
    private ThongTinThuPhiModel thongTinThuPhi;
    private HoKhauModel hoKhau;
    private DotThuPhiModel dotThuPhi;

    public ThongTinThuPhiModel getThongTinThuPhi() {
        return thongTinThuPhi;
    }

    public void setThongTinThuPhi(ThongTinThuPhiModel thongTinThuPhi) {
        this.thongTinThuPhi = thongTinThuPhi;
    }

    public HoKhauModel getHoKhau() {
        return hoKhau;
    }

    public void setHoKhau(HoKhauModel hoKhau) {
        this.hoKhau = hoKhau;
    }

    public DotThuPhiModel getDotThuPhi() {
        return dotThuPhi;
    }

    public void setDotThuPhi(DotThuPhiModel dotThuPhi) {
        this.dotThuPhi = dotThuPhi;
    }

   
}
