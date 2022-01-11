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
//     @Override
//    public String toString() {
//        String res =  "<html><style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
//                + "<h3>Thông tin cơ bản:"
//                + "<p>Họ tên: <b>" + nhanKhauModel.getHoTen() + "</p>"
//                + "<p>Năm sinh: <b>" + nhanKhauModel.getNamSinh() + "</p>"
//                + "<p>Giới tính: <b>" + nhanKhauModel.getGioiTinh() + "</p>"
//                + "<p>Nguyên Quán: <b>" + nhanKhauModel.getNguyenQuan()+ "</p>"
//                + "<p>Dân tộc: <b>" + nhanKhauModel.getDanToc()+ "</p>"
//                + "<p>Tôn giáo: <b>" + nhanKhauModel.getTonGiao()+ "</p>"
//                + "<p>Quốc tịch: <b>" + nhanKhauModel.getQuocTich()+ "</p>"
//                + "<p>Số CMT: <b>" + chungMinhThuModel.getSoCMT()+ "</p>"
//                + "<h4>Tiểu sử<table>"
//                + "<tr>"
//                + "<th>Từ ngày</th>"
//                + "<th>Đến ngày</th>"
//                + "<th>Địa chỉ</th>"
//                + "<th>Nơi làm việc</th>"
//                + "</tr>";
//        for (TieuSuModel tieuSuModel: listTieuSuModels) {
//            res += "<tr>"
//                    + "<td>"
//                    + tieuSuModel.getTuNgay().toString()
//                    + "</td>"
//                    + "<td>"
//                    + tieuSuModel.getDenNgay().toString()
//                    + "</td>"
//                    + "<td>"
//                    + tieuSuModel.getDiaChi()
//                    + "</td>"
//                    + "<td>"
//                    + tieuSuModel.getNoiLamViec()
//                    + "</td>"
//                    + "</tr>";
//        }
//        res += "</table><h4>Gia đình<table>"
//                + "<tr>"
//                + "<th>Họ tên</th>"
//                + "<th>Ngày sinh</th>"
//                + "<th>Giới tính</th>"
//                + "<th>Quan hệ với nhân khẩu</th>"
//                + "<th>Nghề nghiệp</th>"
//                + "<th>Địa chỉ hiện tại</th>"
//                +"</tr>";
//        for (GiaDinhModel giaDinhModel: listGiaDinhModels) {
//            res += "<tr>"
//                    + "<td>"
//                    + giaDinhModel.getHoTen()
//                    + "</td>"
//                    + "<td>"
//                    + giaDinhModel.getNamSinh().toString()
//                    + "</td>"
//                    + "<td>"
//                    + giaDinhModel.getGioiTinh()
//                    + "</td>"
//                    + "<td>"
//                    + giaDinhModel.getQuanHeVoiNhanKhau()
//                    + "</td>"
//                    + "<td>"
//                    + giaDinhModel.getNgheNghiep()
//                    + "</td>"
//                    + "<td>"
//                    + giaDinhModel.getDiaChiHienTai()
//                    + "</td>"
//                    +"</tr>";
//        }
//        res +=  "</table>"
//                + "</div></html>";
//        return res;
//    }
}