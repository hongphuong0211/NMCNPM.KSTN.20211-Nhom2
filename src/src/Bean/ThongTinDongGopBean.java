/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;
import models.ThongTinDongGopModel;
import models.DotDongGopModel;
import models.HoKhauModel;
/**
 *
 * @author t2s
 */
public class ThongTinDongGopBean {
    private ThongTinDongGopModel thongTinDongGopModel;
    private HoKhauModel hoKhauModel;
    private DotDongGopModel dotDongGopModel;

    public ThongTinDongGopBean(ThongTinDongGopModel thongTinDongGopModel, HoKhauModel hoKhauModel, DotDongGopModel dotDongGopModel) {
        this.thongTinDongGopModel = thongTinDongGopModel;
        this.hoKhauModel = hoKhauModel;
        this.dotDongGopModel = dotDongGopModel;
    }

    public ThongTinDongGopBean() {
         this.thongTinDongGopModel = new ThongTinDongGopModel();
        this.hoKhauModel = new HoKhauModel();
        this.dotDongGopModel = new DotDongGopModel();
    }
    
    
    public ThongTinDongGopModel getThongTinDongGopModel() {
        return thongTinDongGopModel;
    }

    public void setThongTinDongGopModel(ThongTinDongGopModel thongTinDongGopModel) {
        this.thongTinDongGopModel = thongTinDongGopModel;
    }

    public HoKhauModel getHoKhauModel() {
        return hoKhauModel;
    }

    public void setHoKhauModel(HoKhauModel hoKhauModel) {
        this.hoKhauModel = hoKhauModel;
    }

    public DotDongGopModel getDotDongGopModel() {
        return dotDongGopModel;
    }

    public void setDotDongGopModel(DotDongGopModel dotDongGopModel) {
        this.dotDongGopModel = dotDongGopModel;
    }
    
}
