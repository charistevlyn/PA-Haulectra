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
        scrBeranda.getViewport().addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                sesuaikanLebar();
            }
        });
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
        sesuaikanLebar();
    }

    private void sesuaikanLebar() {
        int w = scrBeranda.getViewport().getWidth();
        if (w <= 0) return;
        int kolom = Math.max(1, Math.min(3, (w - 64 + 16) / (380 + 16)));
        ((java.awt.GridLayout) pnlProduk.getLayout()).setColumns(kolom);
        pnlKonten.setPreferredSize(null);
        pnlKonten.setPreferredSize(new java.awt.Dimension(w, pnlKonten.getPreferredSize().height));
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
        java.awt.GridBagConstraints gridBagConstraints;

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
        pnlPromoBox.setLayout(new java.awt.GridBagLayout());

        lblPromoJudul.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPromoJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblPromoJudul.setText("Promo yang bisa dipakai");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        pnlPromoBox.add(lblPromoJudul, gridBagConstraints);

        lblPromoSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPromoSub.setForeground(new java.awt.Color(102, 112, 133));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 12, 0);
        pnlPromoBox.add(lblPromoSub, gridBagConstraints);

        pnlPromo.setBackground(new java.awt.Color(255, 255, 255));
        pnlPromo.setOpaque(false);
        pnlPromo.setLayout(new java.awt.GridLayout(1, 0, 12, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        pnlPromoBox.add(pnlPromo, gridBagConstraints);

        lblPromoKosong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPromoKosong.setForeground(new java.awt.Color(102, 112, 133));
        lblPromoKosong.setText("Belum ada promo yang berlaku saat ini.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlPromoBox.add(lblPromoKosong, gridBagConstraints);

        pnlFilter.setBackground(new java.awt.Color(255, 255, 255));
        pnlFilter.setOpaque(false);
        pnlFilter.setLayout(new java.awt.GridBagLayout());

        lblCari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCari.setForeground(new java.awt.Color(52, 64, 84));
        lblCari.setText("Cari produk");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlFilter.add(lblCari, gridBagConstraints);

        lblKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(52, 64, 84));
        lblKategori.setText("Kategori");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 0);
        pnlFilter.add(lblKategori, gridBagConstraints);

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCari.setForeground(new java.awt.Color(16, 24, 40));
        txtCari.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtCari.setPreferredSize(new java.awt.Dimension(300, 38));
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        pnlFilter.add(txtCari, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 0, 0);
        pnlFilter.add(btnCari, gridBagConstraints);

        cmbKategori.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbKategori.setForeground(new java.awt.Color(16, 24, 40));
        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua kategori" }));
        cmbKategori.setPreferredSize(new java.awt.Dimension(220, 38));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 16, 0, 0);
        pnlFilter.add(cmbKategori, gridBagConstraints);

        pnlProduk.setBackground(new java.awt.Color(255, 255, 255));
        pnlProduk.setOpaque(false);
        pnlProduk.setLayout(new java.awt.GridLayout(0, 3, 16, 16));

        lblKosong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblKosong.setForeground(new java.awt.Color(102, 112, 133));
        lblKosong.setText("Produk tidak ditemukan. Coba kata kunci atau kategori lain.");

        pnlSisa.setBackground(new java.awt.Color(255, 255, 255));
        pnlSisa.setOpaque(false);

        javax.swing.GroupLayout pnlSisaLayout = new javax.swing.GroupLayout(pnlSisa);
        pnlSisa.setLayout(pnlSisaLayout);
        pnlSisaLayout.setHorizontalGroup(
            pnlSisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSisaLayout.setVerticalGroup(
            pnlSisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlKontenLayout = new javax.swing.GroupLayout(pnlKonten);
        pnlKonten.setLayout(pnlKontenLayout);
        pnlKontenLayout.setHorizontalGroup(
            pnlKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPromoBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblKosong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlKontenLayout.setVerticalGroup(
            pnlKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKontenLayout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(4, 4, 4)
                .addComponent(lblSub)
                .addGap(20, 20, 20)
                .addComponent(pnlPromoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(pnlProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblKosong)
                .addComponent(pnlSisa, 0, 0, Short.MAX_VALUE))
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
