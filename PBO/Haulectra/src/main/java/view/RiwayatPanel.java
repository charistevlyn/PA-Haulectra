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
public class RiwayatPanel extends javax.swing.JPanel implements Halaman {

    private final PelangganView induk;
    private final PesananController pesanan = new PesananController();
    private List<Pesanan> data = List.of();

    public RiwayatPanel(PelangganView induk) {
        this.induk = induk;
        initComponents();
        Gaya.tabel(tblRiwayat);
        Gaya.lebarKolom(tblRiwayat, 150, 150, 240, 120, 150, 200);
        Gaya.kolomStatus(tblRiwayat, 4);
        tblRiwayat.getColumnModel().getColumn(5).setMinWidth(200);   
        KolomAksi.pasang(tblRiwayat, 5, b -> tombol(data.get(b)), (b, t) -> aksi(data.get(b), t));
    }

    @Override
    public void muat() {
        data = pesanan.riwayat(txtCari.getText(), tahap());
        DefaultTableModel model = (DefaultTableModel) tblRiwayat.getModel();
        model.setRowCount(0);
        for (Pesanan p : data) {
            model.addRow(new Object[]{p.getNomor(), Gaya.tanggal(p.getTanggal()), p.getNamaProduk(),
                Gaya.rupiah(p.getTotalHarga()), Gaya.statusPelanggan(p), ""});
        }
        lblJumlah.setText(data.size() + " pesanan");
    }

    private Pesanan.Tahap tahap() {
        for (Pesanan.Tahap t : Pesanan.Tahap.values()) {
            if (t.toString().equals(cmbStatus.getSelectedItem())) return t;
        }
        return null;   
    }

    private String[] tombol(Pesanan p) {
        return switch (p.getTahap()) {
            case MENUNGGU_PEMBAYARAN -> new String[]{"Bayar", "Batalkan"};
            case DIPROSES, DIKIRIM -> new String[]{"Detail Pesanan"};
            case SELESAI -> new String[]{"Lihat"};
            case DIBATALKAN -> new String[]{};
        };
    }

    private void aksi(Pesanan p, String tombol) {
        switch (tombol) {
            case "Bayar" -> {
                if (PembayaranDialog.bayar(this, p)) {
                    NotifikasiDialog.tampil(this, "Pembayaran berhasil", "Pesanan " + p.getNomor() + " sedang diproses");
                }
            }
            case "Batalkan" -> {
                if (KonfirmasiDialog.tanya(this, "Batalkan pesanan", "Yakin ingin membatalkan pesanan <b>"
                        + p.getNomor() + "</b>? Stok barang akan dikembalikan.", "Batalkan", "dialog_hapus", true)) {
                    try {
                        pesanan.batalkan(p);
                        NotifikasiDialog.tampil(this, "Pesanan dibatalkan", p.getNomor());
                    } catch (ValidasiException e) {
                        KonfirmasiDialog.gagal(this, e.getMessage());
                    }
                }
            }
            default -> DetailPesananDialog.tampil(this, p, true);  
        }
        muat();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        pnlFilter = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        scrRiwayat = new javax.swing.JScrollPane();
        tblRiwayat = new javax.swing.JTable();
        lblJumlah = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 32, 24, 32));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlKepala.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Riwayat Pesanan");

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));

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
                    .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
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
            .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlKepalaLayout.setVerticalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addGroup(pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul)
                    .addComponent(lblSub))
                .addGap(24, 24, 24)
                .addComponent(pnlFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scrRiwayat.setBackground(new java.awt.Color(255, 255, 255));
        scrRiwayat.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));

        tblRiwayat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Pesanan", "Tanggal", "Produk", "Total", "Status", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRiwayat.setGridColor(new java.awt.Color(228, 231, 236));
        tblRiwayat.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblRiwayat.setRowHeight(52);
        tblRiwayat.setSelectionBackground(new java.awt.Color(232, 240, 255));
        tblRiwayat.setSelectionForeground(new java.awt.Color(16, 24, 40));
        scrRiwayat.setViewportView(tblRiwayat);

        lblJumlah.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblJumlah.setForeground(new java.awt.Color(102, 112, 133));
        lblJumlah.setText("0 pesanan");
        lblJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKepala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrRiwayat)
            .addComponent(lblJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrRiwayat)
                .addGap(0, 0, 0)
                .addComponent(lblJumlah))
        );
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSub;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JScrollPane scrRiwayat;
    private javax.swing.JTable tblRiwayat;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
