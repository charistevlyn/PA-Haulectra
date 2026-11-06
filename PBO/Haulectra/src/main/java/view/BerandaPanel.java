/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AuthController;
import controller.PesananController;
import controller.ProdukController;
import controller.PromoController;
import java.util.List;
import model.Produk;
import model.Promo;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class BerandaPanel extends javax.swing.JPanel implements Halaman {

    private final PelangganView induk;
    private final ProdukController produk = new ProdukController();
    private final PesananController pesanan = new PesananController();
    private final PromoController promo = new PromoController();
    private boolean siap;

    public BerandaPanel(PelangganView induk) {
        this.induk = induk;
        initComponents();
        scrBeranda.getVerticalScrollBar().setUnitIncrement(16);
        for (String k : produk.daftarKategori()) cmbKategori.addItem(k);
        siap = true;
    }

    @Override
    public void muat() {
        lblSub.setText("Selamat datang, " + AuthController.getPenggunaLogin().getNama());
        tampilPromo();
        tampilProduk();
    }

    private void tampilPromo() {
        pnlPromo.removeAll();
        List<Promo> aktif = promo.promoAktif();
        for (Promo p : aktif) pnlPromo.add(new KartuPromo(p));
        pnlPromo.setVisible(!aktif.isEmpty());
        lblPromoKosong.setVisible(aktif.isEmpty());
    }

    private void tampilProduk() {
        pnlProduk.removeAll();
        List<Produk> daftar = produk.cari(txtCari.getText(), (String) cmbKategori.getSelectedItem());
        for (Produk p : daftar) pnlProduk.add(new KartuProduk(p, this::lihat, this::tambah));
        lblKosong.setVisible(daftar.isEmpty());
        pnlKonten.revalidate();
        pnlKonten.repaint();
    }

    private void lihat(Produk p) {
        int jumlah = DetailProdukDialog.pilih(this, p, pesanan.jumlahDiKeranjang(p.getId()));
        if (jumlah > 0) tambah(p, jumlah);
    }

    private void tambah(Produk p, int jumlah) {
        int masuk = pesanan.tambahKeKeranjang(p.getId(), jumlah);
        if (masuk > 0) {
            NotifikasiDialog.tampil(this, "Barang dimasukkan ke keranjang", p.getNama() + ", " + masuk + " barang");
        } else {
            NotifikasiDialog.tampil(this, "Jumlah di keranjang sudah sesuai stok", p.getNama(), false);
        }
        induk.perbaruiKeranjang();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrBeranda = new javax.swing.JScrollPane();
        pnlKonten = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        pnlPromoBox = new javax.swing.JPanel();
        lblPromoJudul = new javax.swing.JLabel();
        lblPromoSub = new javax.swing.JLabel();
        pnlPromo = new javax.swing.JPanel();
        lblPromoKosong = new javax.swing.JLabel();
        pnlFilter = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        lblKategori = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        cmbKategori = new javax.swing.JComboBox<>();
        pnlProduk = new javax.swing.JPanel();
        lblKosong = new javax.swing.JLabel();
        pnlSisa = new javax.swing.JPanel();

        setBackground(new java.awt.Color(245, 247, 251));
        setLayout(new java.awt.BorderLayout());

        scrBeranda.setBorder(null);
        scrBeranda.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlKonten.setBackground(new java.awt.Color(245, 247, 251));
        pnlKonten.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 32, 32, 32));

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Temukan elektronik pilihan Anda");

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));
        lblSub.setText("Selamat datang.");

        pnlPromoBox.setBackground(new java.awt.Color(243, 247, 255));
        pnlPromoBox.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(199, 215, 254)), javax.swing.BorderFactory.createEmptyBorder(16, 20, 16, 20)));

        lblPromoJudul.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPromoJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblPromoJudul.setText("Promo yang bisa dipakai");

        lblPromoSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPromoSub.setForeground(new java.awt.Color(102, 112, 133));

        pnlPromo.setBackground(new java.awt.Color(255, 255, 255));
        pnlPromo.setOpaque(false);
        pnlPromo.setLayout(new java.awt.GridLayout(1, 0, 12, 0));

        lblPromoKosong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPromoKosong.setForeground(new java.awt.Color(102, 112, 133));
        lblPromoKosong.setText("Belum ada promo yang berlaku saat ini.");

        javax.swing.GroupLayout pnlPromoBoxLayout = new javax.swing.GroupLayout(pnlPromoBox);
        pnlPromoBox.setLayout(pnlPromoBoxLayout);
        pnlPromoBoxLayout.setHorizontalGroup(
            pnlPromoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPromoSub)
            .addGroup(pnlPromoBoxLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlPromoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPromoJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPromoKosong, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlPromoBoxLayout.setVerticalGroup(
            pnlPromoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPromoBoxLayout.createSequentialGroup()
                .addGroup(pnlPromoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPromoSub))
                .addGap(17, 17, 17)
                .addComponent(lblPromoJudul)
                .addGap(14, 14, 14)
                .addComponent(lblPromoKosong))
        );

        pnlFilter.setBackground(new java.awt.Color(255, 255, 255));
        pnlFilter.setOpaque(false);

        lblCari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCari.setForeground(new java.awt.Color(52, 64, 84));
        lblCari.setText("Cari produk");

        lblKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(52, 64, 84));
        lblKategori.setText("Kategori");

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
                .addComponent(lblCari, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(lblKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlFilterLayout.createSequentialGroup()
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        pnlProduk.setBackground(new java.awt.Color(255, 255, 255));
        pnlProduk.setOpaque(false);
        pnlProduk.setLayout(new java.awt.GridLayout(0, 3, 16, 16));

        lblKosong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblKosong.setForeground(new java.awt.Color(102, 112, 133));
        lblKosong.setText("Produk tidak ditemukan. Coba kata kunci atau kategori lain.");

        pnlSisa.setBackground(new java.awt.Color(255, 255, 255));
        pnlSisa.setOpaque(false);
        pnlSisa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout pnlKontenLayout = new javax.swing.GroupLayout(pnlKonten);
        pnlKonten.setLayout(pnlKontenLayout);
        pnlKontenLayout.setHorizontalGroup(
            pnlKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlKontenLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSub, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPromoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKosong, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlKontenLayout.setVerticalGroup(
            pnlKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKontenLayout.createSequentialGroup()
                .addComponent(pnlProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblJudul)
                .addGap(4, 4, 4)
                .addComponent(lblSub)
                .addGap(20, 20, 20)
                .addComponent(pnlPromoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblKosong)
                .addGap(0, 0, 0)
                .addComponent(pnlSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scrBeranda.setViewportView(pnlKonten);

        add(scrBeranda, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        tampilProduk();
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        tampilProduk();
    }//GEN-LAST:event_btnCariActionPerformed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        if (siap) tampilProduk();
    }//GEN-LAST:event_cmbKategoriActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblKosong;
    private javax.swing.JLabel lblPromoJudul;
    private javax.swing.JLabel lblPromoKosong;
    private javax.swing.JLabel lblPromoSub;
    private javax.swing.JLabel lblSub;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JPanel pnlKonten;
    private javax.swing.JPanel pnlProduk;
    private javax.swing.JPanel pnlPromo;
    private javax.swing.JPanel pnlPromoBox;
    private javax.swing.JPanel pnlSisa;
    private javax.swing.JScrollPane scrBeranda;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
