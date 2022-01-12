/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.DongGopManagerFrame;

import views.ThuPhiManagerFrame.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import services.MysqlConnection;
import controllers.DongGopPanelController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author conghoang
 */
public class TaoMoiDotDongGopJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ThemDotThuPhi
     */
    private JFrame parentFrame;
    private DongGopPanelController parentController;
    public TaoMoiDotDongGopJFrame(JFrame parentFrame, DongGopPanelController parentController) {
        this.parentController = parentController;
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
    }
    void close() {
        this.parentFrame.setEnabled(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        MaDotThuPhi = new javax.swing.JLabel();
        TenDotThuPhi = new javax.swing.JLabel();
        NgayBatDau = new javax.swing.JLabel();
        MaDotThuPhiText = new javax.swing.JTextField();
        TenDotThuPhiText = new javax.swing.JTextField();
        CancelButton = new javax.swing.JButton();
        CreateButton = new javax.swing.JButton();
        NgayKetThuc = new javax.swing.JLabel();
        ngayBatDauJdc = new com.toedter.calendar.JDateChooser();
        ngayKetThucJdc = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MaDotThuPhi.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        MaDotThuPhi.setText("Mã đợt ủng hộ");

        TenDotThuPhi.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        TenDotThuPhi.setText("Tên đợt ủng hộ");

        NgayBatDau.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        NgayBatDau.setText("Ngày bắt đầu");

        TenDotThuPhiText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenDotThuPhiTextActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");

        CreateButton.setText("Create");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        NgayKetThuc.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        NgayKetThuc.setText("Ngày kết thúc");

        ngayBatDauJdc.setEnabled(false);

        ngayKetThucJdc.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(CancelButton)
                        .addGap(67, 67, 67)
                        .addComponent(CreateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MaDotThuPhi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(TenDotThuPhi)
                            .addComponent(NgayBatDau)
                            .addComponent(NgayKetThuc))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MaDotThuPhiText, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(TenDotThuPhiText)
                            .addComponent(ngayBatDauJdc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ngayKetThucJdc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MaDotThuPhi)
                        .addComponent(MaDotThuPhiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenDotThuPhi)
                    .addComponent(TenDotThuPhiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NgayBatDau)
                    .addComponent(ngayBatDauJdc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NgayKetThuc)
                    .addComponent(ngayKetThucJdc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(CreateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TenDotThuPhiTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenDotThuPhiTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenDotThuPhiTextActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "INSERT INTO dot_ung_ho(ma_dot_ung_ho, ten_dot_ung_ho, ngay_bat_dau, ngau_ket_thuc)" 
                        + " values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, Integer.parseInt(MaDotThuPhiText.getText()));
            preparedStatement.setString(2, TenDotThuPhiText.getText());
            preparedStatement.setDate(3, new java.sql.Date(this.ngayBatDauJdc.getDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(this.ngayKetThucJdc.getDate().getTime()));
//            try{
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                Date parsed = format.parse(NgayKetThucText.getText());
//                java.sql.Date sql = new java.sql.Date(parsed.getTime());
//                preparedStatement.setDate(3, sql);
//            }
//            catch(Exception e){
//                
//            }
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            close();
            JOptionPane.showMessageDialog(null, "Thêm thành công!!");
            close();
            parentController.refreshData();
        }
        catch(Exception e){
            System.out.print(e);
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Are you sure to close this??","Confirm",JOptionPane.YES_NO_OPTION) == 0) {
            close();
        }
    }//GEN-LAST:event_CancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateButton;
    private javax.swing.JLabel MaDotThuPhi;
    private javax.swing.JTextField MaDotThuPhiText;
    private javax.swing.JLabel NgayBatDau;
    private javax.swing.JLabel NgayKetThuc;
    private javax.swing.JLabel TenDotThuPhi;
    private javax.swing.JTextField TenDotThuPhiText;
    private javax.swing.JLabel jLabel1;
    private com.toedter.calendar.JDateChooser ngayBatDauJdc;
    private com.toedter.calendar.JDateChooser ngayKetThucJdc;
    // End of variables declaration//GEN-END:variables
}
