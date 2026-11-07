/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PesananController;
import controller.ValidasiException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Pesanan;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class PesananAdminPanel extends javax.swing.JPanel implements Halaman {

    private final PesananController controller = new PesananController();
    private List<Pesanan> data = List.of();

    public PesananAdminPanel() {
        initComponents();
        Gaya.tabel(tblPesanan);
        Gaya.lebarKolom(tblPesanan, 130, 110, 140, 110, 180, 220, 160);
        Gaya.kolomStatus(tblPesanan, 4);
        tblPesanan.getColumnModel().getColumn(6).setMinWidth(160);  
        KolomAksi.pasang(tblPesanan, 6, b -> tombol(data.get(b)), (b, t) -> aksi(data.get(b), t));
    }

    @Override
    public void muat() {
        data = controller.cari(txtCari.getText(), tahap());
        DefaultTableModel model = (DefaultTableModel) tblPesanan.getModel();
        model.setRowCount(0);
        for (Pesanan p : data) {
            model.addRow(new Object[]{p.getNomor(), Gaya.tanggal(p.getTanggal().toLocalDate()), p.getPelanggan().getNama(),
                Gaya.rupiah(p.getTotalHarga()), p.getTahap().toString(),
                p.getNomorResi() == null ? "-" : p.getNomorResi(), ""});
        }
        lblJumlah.setText(data.size() + " pesanan ditampilkan");
    }

    private Pesanan.Tahap tahap() {
        for (Pesanan.Tahap t : Pesanan.Tahap.values()) {
            if (t.toString().equals(cmbStatus.getSelectedItem())) return t;
        }
        return null;
    }

    private String[] tombol(Pesanan p) {
        return p.getTahap() == Pesanan.Tahap.DIPROSES ? new String[]{"Detail", "Kirim"} : new String[]{"Detail"};
    }

    private void aksi(Pesanan p, String tombol) {
        if (tombol.equals("Detail")) {
            DetailPesananDialog.tampil(this, p, false);
            return;
        }
        if (KonfirmasiDialog.yaTidak(this, "Kirim pesanan", "Kirim pesanan <b>" + p.getNomor() + "</b>?",
                "dialog_kirim")) {
            try {
                controller.kirim(p);
                NotifikasiDialog.tampil(this, "Pesanan dikirim", "Nomor resi " + p.getNomorResi());
            } catch (ValidasiException e) {
                KonfirmasiDialog.gagal(this, e.getMessage());
            }
            muat();
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();
        pnlFilter = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        scrPesanan = new javax.swing.JScrollPane();
        tblPesanan = new javax.swing.JTable();
        lblJumlah = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 32, 24, 32));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlKepala.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Kelola Pesanan");

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));

        btnCetak.setBackground(new java.awt.Color(31, 94, 219));
        btnCetak.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCetak.setForeground(new java.awt.Color(255, 255, 255));
        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/cetak_putih.png"))); // NOI18N
        btnCetak.setText("Cetak Laporan");
        btnCetak.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnCetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCetak.setFocusPainted(false);
        btnCetak.setIconTextGap(8);
        btnCetak.setPreferredSize(new java.awt.Dimension(170, 40));
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        pnlFilter.setBackground(new java.awt.Color(255, 255, 255));
        pnlFilter.setOpaque(false);

        lblCari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCari.setForeground(new java.awt.Color(52, 64, 84));
        lblCari.setText("Cari");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCari.setForeground(new java.awt.Color(16, 24, 40));
        txtCari.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtCari.setPreferredSize(new java.awt.Dimension(300, 38));
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCari.setForeground(new java.awt.Color(16, 24, 40));
        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/cari.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        btnCari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCari.setFocusPainted(false);
        btnCari.setIconTextGap(8);
        btnCari.setPreferredSize(new java.awt.Dimension(96, 38));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(52, 64, 84));
        lblStatus.setText("Status");

        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbStatus.setForeground(new java.awt.Color(16, 24, 40));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua status", "Menunggu Pembayaran", "Diproses", "Dikirim", "Selesai", "Pesanan Dibatalkan" }));
        cmbStatus.setPreferredSize(new java.awt.Dimension(220, 38));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFilterLayout = new javax.swing.GroupLayout(pnlFilter);
        pnlFilter.setLayout(pnlFilterLayout);
        pnlFilterLayout.setHorizontalGroup(
            pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlFilterLayout.setVerticalGroup(
            pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCari)
                    .addComponent(lblStatus))
                .addGap(6, 6, 6)
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pnlKepalaLayout = new javax.swing.GroupLayout(pnlKepala);
        pnlKepala.setLayout(pnlKepalaLayout);
        pnlKepalaLayout.setHorizontalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addGroup(pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlKepalaLayout.setVerticalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addGroup(pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSub)
                    .addComponent(lblJudul)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(pnlFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scrPesanan.setBackground(new java.awt.Color(255, 255, 255));
        scrPesanan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));

        tblPesanan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Pesanan", "Tanggal", "Pelanggan", "Total", "Status", "No. Resi", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPesanan.setGridColor(new java.awt.Color(228, 231, 236));
        tblPesanan.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblPesanan.setRowHeight(52);
        tblPesanan.setSelectionBackground(new java.awt.Color(232, 240, 255));
        tblPesanan.setSelectionForeground(new java.awt.Color(16, 24, 40));
        scrPesanan.setViewportView(tblPesanan);

        lblJumlah.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblJumlah.setForeground(new java.awt.Color(102, 112, 133));
        lblJumlah.setText("0 data");
        lblJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKepala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrPesanan)
            .addComponent(lblJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrPesanan)
                .addGap(0, 0, 0)
                .addComponent(lblJumlah))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        CetakLaporanDialog.tampil(this);
    }//GEN-LAST:event_btnCetakActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        muat();
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        muat();
    }//GEN-LAST:event_btnCariActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        muat();
    }//GEN-LAST:event_cmbStatusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSub;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JScrollPane scrPesanan;
    private javax.swing.JTable tblPesanan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
