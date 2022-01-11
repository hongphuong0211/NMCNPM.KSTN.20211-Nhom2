/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import controllers.HoKhauPanelController;
import javax.swing.JFrame;
import views.NhanKhauManagerFrame.AddNewPeopleJFrame;
import views.NhanKhauManagerFrame.DangKyTamVangJFrame;
import views.ThuPhiManagerFrame.ThemThongTinThuPhiJFrame;
import controllers.ThuPhiPanelController;

/**
 *
 * @author quant
 */
public class ThuPhiPanel extends javax.swing.JPanel {

    /**
     * Creates new form ThuPhiPanel
     */
    
    private ThuPhiPanelController controller = null;
    private JFrame parentJFrame;
    
    public ThuPhiPanel(JFrame parentFrame) {
        this.parentJFrame = parentFrame;
        initComponents();
        controller = new ThuPhiPanelController(NhapDotThuPhiText, tablePanel);
        controller.setParentJFrame(parentFrame);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePanel = new javax.swing.JPanel();
        TaoMoiBtn = new javax.swing.JButton();
        GhiNhanBtn = new javax.swing.JButton();
        NhapDotThuPhiText = new javax.swing.JTextField();
        SoTienMoiNhanKhauText = new javax.swing.JTextField();
        SoTienMoiNhanKhauLabel = new javax.swing.JLabel();
        NhapDotThuPhiLabel = new javax.swing.JLabel();
        Search = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        TaoMoiBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TaoMoiBtn.setText("Tạo mới");
        TaoMoiBtn.setPreferredSize(new java.awt.Dimension(101, 25));
        TaoMoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoMoiBtnActionPerformed(evt);
            }
        });

        GhiNhanBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GhiNhanBtn.setText("Ghi Nhận");
        GhiNhanBtn.setPreferredSize(new java.awt.Dimension(101, 25));
        GhiNhanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GhiNhanBtnActionPerformed(evt);
            }
        });

        NhapDotThuPhiText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        NhapDotThuPhiText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhapDotThuPhiTextActionPerformed(evt);
            }
        });

        SoTienMoiNhanKhauText.setBackground(new java.awt.Color(240, 240, 240));
        SoTienMoiNhanKhauText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoTienMoiNhanKhauTextActionPerformed(evt);
            }
        });

        SoTienMoiNhanKhauLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SoTienMoiNhanKhauLabel.setText("Số tiền cần nộp/nhân khẩu: ");

        NhapDotThuPhiLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        NhapDotThuPhiLabel.setText("Nhập đợt thu phí:");

        Search.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SoTienMoiNhanKhauLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(NhapDotThuPhiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SoTienMoiNhanKhauText, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(NhapDotThuPhiText))
                        .addGap(18, 18, 18)
                        .addComponent(Search)
                        .addGap(0, 260, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GhiNhanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TaoMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SoTienMoiNhanKhauLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SoTienMoiNhanKhauText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NhapDotThuPhiText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NhapDotThuPhiLabel)
                    .addComponent(Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(TaoMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GhiNhanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NhapDotThuPhiTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapDotThuPhiTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NhapDotThuPhiTextActionPerformed

    private void SoTienMoiNhanKhauTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoTienMoiNhanKhauTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoTienMoiNhanKhauTextActionPerformed

    private void TaoMoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoMoiBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TaoMoiBtnActionPerformed

    private void GhiNhanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GhiNhanBtnActionPerformed
        // TODO add your handling code here:
        ThemThongTinThuPhiJFrame themThongTinThuPhiJFrame = new ThemThongTinThuPhiJFrame(this.parentJFrame, this.controller);
        themThongTinThuPhiJFrame.setLocationRelativeTo(null);
        themThongTinThuPhiJFrame.setResizable(false);
        themThongTinThuPhiJFrame.setVisible(true);
    }//GEN-LAST:event_GhiNhanBtnActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        this.controller.search(Integer.parseInt(NhapDotThuPhiText.getText()));
        this.controller.refreshData();
    }//GEN-LAST:event_SearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GhiNhanBtn;
    private javax.swing.JLabel NhapDotThuPhiLabel;
    private javax.swing.JTextField NhapDotThuPhiText;
    private javax.swing.JButton Search;
    private javax.swing.JLabel SoTienMoiNhanKhauLabel;
    private javax.swing.JTextField SoTienMoiNhanKhauText;
    private javax.swing.JButton TaoMoiBtn;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables
}
