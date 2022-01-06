/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;
import models.DotDongGopModel;
import models.HoKhauModel;

/**
 *
 * @author Admin
 */
public class DotDongGopBean {
    private DotDongGopModel dotDongGop;
   // private Dictionary<HoKhauModel, Integer> list_DanhSachDongGop = new Hashtable<HoKhauModel, Integer>();

    public DotDongGopBean(DotDongGopModel dotDongGop) {
        this.dotDongGop = dotDongGop;
       // list_DanhSachDongGop = new Hashtable<HoKhauModel, Integer>();
    }

    public DotDongGopBean() {
        this.dotDongGop = new DotDongGopModel();
    }

 

    public DotDongGopModel getDotDongGop() {
        return dotDongGop;
    }

    public void setDotDongGop(DotDongGopModel dotDongGop) {
        this.dotDongGop = dotDongGop;
    }


//    public void setList_DanhSachDongGop(Dictionary<HoKhauModel, Integer> list_DanhSachDongGop) {
//        this.list_DanhSachDongGop = list_DanhSachDongGop;
//    }
    
//    public void insertList_DanhSachDongGop(HoKhauModel hokhau, int tien){
//        Enumeration<HoKhauModel> h = this.list_DanhSachDongGop.keys();
//        while(h.hasMoreElements()){
//            if(h.nextElement().compareTo(hokhau)){
//                this.list_DanhSachDongGop.put(hokhau, this.list_DanhSachDongGop.get(hokhau) + tien);
//                return;
//            }
//        }     
//        this.list_DanhSachDongGop.put(hokhau, tien);
//    }
//    
}
