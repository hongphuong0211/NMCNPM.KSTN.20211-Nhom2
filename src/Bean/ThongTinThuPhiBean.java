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
    
    public ThongTinThuPhiBean() {
        this.dotThuPhi = new DotThuPhiModel();
        this.hoKhau = new HoKhauModel();
        this.thongTinThuPhi = new ThongTinThuPhiModel();
    }

    public ThongTinThuPhiBean(ThongTinThuPhiModel thongTinThuPhi, HoKhauModel hoKhau, DotThuPhiModel dotThuPhi) {
        this.thongTinThuPhi = thongTinThuPhi;
        this.hoKhau = hoKhau;
        this.dotThuPhi = dotThuPhi;
    }

    
    
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

    @Override
    public String toString() {
        String res =  "<html><style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                    + "";
        return res;
    }
    
}