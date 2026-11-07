/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ProdukController;
import controller.ValidasiException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Produk;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class ProdukPanel extends javax.swing.JPanel implements Halaman {

    private final ProdukController controller = new ProdukController();
    private List<Produk> data = List.of();
    private boolean siap;

    public ProdukPanel() {
        initComponents();
        Gaya.tabel(tblProduk);
        Gaya.lebarKolom(tblProduk, 70, 90, 280, 160, 130, 70, 170);
        Gaya.kolomFoto(tblProduk, 0);
        KolomAksi.pasang(tblProduk, 6, b -> new String[]{"Ubah", "Hapus"}, (b, t) -> aksi(data.get(b), t));
        for (String k : controller.daftarKategori()) cmbKategori.addItem(k);
        siap = true;
    }

    @Override
    public void muat() {
        data = controller.cari(txtCari.getText(), (String) cmbKategori.getSelectedItem());
        DefaultTableModel model = (DefaultTableModel) tblProduk.getModel();
        model.setRowCount(0);
        for (Produk p : data) {
            model.addRow(new Object[]{Gaya.foto(p.getGambar(), 46, 46), p.getKode(), p.getNama(), p.getKategori(),
                Gaya.rupiah(p.getHarga()), p.getStok(), ""});
        }
        lblJumlah.setText(data.size() + " produk ditampilkan");
    }

    private void aksi(Produk p, String tombol) {
        if (tombol.equals("Ubah")) {
            if (ProdukDialog.tampil(this, controller.cariId(p.getId()))) {
                NotifikasiDialog.tampil(this, "Produk berhasil diubah", p.getNama());
            }
        } else if (KonfirmasiDialog.tanya(this, "Hapus produk", "Yakin ingin menghapus <b>" + p.getNama() + "</b>?",
                "Hapus", "dialog_hapus", true)) {
            try {
                controller.hapus(p.getId());
                NotifikasiDialog.tampil(this, "Produk dihapus", p.getNama());
            } catch (ValidasiException e) {
                KonfirmasiDialog.gagal(this, e.getMessage());
            }
        }
        muat();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        pnlFilter = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        lblKategori = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        scrProduk = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        lblJumlah = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 247, 251));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 32, 24, 32));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 16, 0));
        pnlKepala.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Kelola Produk");

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));

        btnTambah.setBackground(new java.awt.Color(31, 94, 219));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/tambah_putih.png"))); // NOI18N
        btnTambah.setText("Tambah Produk");
        btnTambah.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.setFocusPainted(false);
        btnTambah.setIconTextGap(8);
        btnTambah.setPreferredSize(new java.awt.Dimension(170, 40));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
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

        lblKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(52, 64, 84));
        lblKategori.setText("Kategori");

        cmbKategori.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbKategori.setForeground(new java.awt.Color(16, 24, 40));
        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua kategori" }));
        cmbKategori.setPreferredSize(new java.awt.Dimension(220, 38));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFilterLayout = new javax.swing.GroupLayout(pnlFilter);
        pnlFilter.setLayout(pnlFilterLayout);
        pnlFilterLayout.setHorizontalGroup(
            pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKategori)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlFilterLayout.setVerticalGroup(
            pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCari)
                    .addComponent(lblKategori))
                .addGap(6, 6, 6)
                .addGroup(pnlFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pnlKepalaLayout = new javax.swing.GroupLayout(pnlKepala);
        pnlKepala.setLayout(pnlKepalaLayout);
        pnlKepalaLayout.setHorizontalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addGroup(pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlKepalaLayout.setVerticalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addGroup(pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSub)
                    .addComponent(lblJudul)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(pnlFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scrProduk.setBackground(new java.awt.Color(255, 255, 255));
        scrProduk.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));

        tblProduk.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Foto", "Kode", "Nama Produk", "Kategori", "Harga", "Stok", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduk.setGridColor(new java.awt.Color(228, 231, 236));
        tblProduk.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblProduk.setRowHeight(60);
        tblProduk.setSelectionBackground(new java.awt.Color(232, 240, 255));
        tblProduk.setSelectionForeground(new java.awt.Color(16, 24, 40));
        scrProduk.setViewportView(tblProduk);

        lblJumlah.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblJumlah.setForeground(new java.awt.Color(102, 112, 133));
        lblJumlah.setText("0 data");
        lblJumlah.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKepala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrProduk)
            .addComponent(lblJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrProduk)
                .addGap(0, 0, 0)
                .addComponent(lblJumlah))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (ProdukDialog.tampil(this, null)) {
            NotifikasiDialog.tampil(this, "Produk berhasil ditambahkan", null);
            muat();
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        muat();
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        muat();
    }//GEN-LAST:event_btnCariActionPerformed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        if (siap) muat();
    }//GEN-LAST:event_cmbKategoriActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblSub;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JScrollPane scrProduk;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
