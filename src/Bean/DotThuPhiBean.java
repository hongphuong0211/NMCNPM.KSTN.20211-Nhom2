/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;
import models.DotThuPhiModel;
import models.HoKhauModel;

/**
 *
 * @author Admin
 */
public class DotThuPhiBean {
    private DotThuPhiModel dotThuPhi;
    private Dictionary<HoKhauModel, Integer> danhSachHoThuPhi = new Hashtable<HoKhauModel, Integer>();

    public DotThuPhiBean(DotThuPhiModel dotThuPhi) {
        this.dotThuPhi = dotThuPhi;
        danhSachHoThuPhi = new Hashtable<HoKhauModel, Integer>();
    }

    public DotThuPhiModel getDotThuPhi() {
        return dotThuPhi;
    }

    public void setDotThuPhi(DotThuPhiModel dotThuPhi) {
        this.dotThuPhi = dotThuPhi;
    }

    public Dictionary<HoKhauModel, Integer> getDanhSachHoThuPhi() {
        return danhSachHoThuPhi;
    }

    public void setDanhSachHoThuPhi(Dictionary<HoKhauModel, Integer> danhSachHoThuPhi) {
        this.danhSachHoThuPhi = danhSachHoThuPhi;
    }
    
    public void insertDanhSachHoThuPhi(HoKhauModel hokhau, int tien){
        
    }
    
    
}
