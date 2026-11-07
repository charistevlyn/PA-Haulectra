/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import model.Produk;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class KartuProduk extends javax.swing.JPanel {

    private final Produk produk;
    private final Consumer<Produk> aksiLihat;
    private final BiConsumer<Produk, Integer> aksiTambah;

    public KartuProduk(Produk produk, Consumer<Produk> aksiLihat, BiConsumer<Produk, Integer> aksiTambah) {
        this.produk = produk;
        this.aksiLihat = aksiLihat;
        this.aksiTambah = aksiTambah;
        initComponents();
        lblFoto.setIcon(Gaya.foto(produk.getGambar(), 112, 112));
        lblNama.setText(produk.getNama());
        lblNama.setToolTipText(produk.getNama());
        lblHarga.setText(Gaya.rupiah(produk.getHarga()));
        boolean habis = produk.getStok() <= 0;
        lblKategori.setText(produk.getKategori());
        lblStok.setText(habis ? "Stok habis" : "Stok " + produk.getStok());
        btnKeranjang.setEnabled(!habis);
        if (habis) btnKeranjang.setBackground(Gaya.GARIS);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFoto = new javax.swing.JLabel();
        lblKategori = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnLihat = new javax.swing.JButton();
        lblJarak = new javax.swing.JLabel();
        btnKeranjang = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12)));

        lblFoto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(16, 24, 40));
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/foto_kosong.png"))); // NOI18N
        lblFoto.setPreferredSize(new java.awt.Dimension(112, 112));

        lblKategori.setForeground(new java.awt.Color(102, 112, 133));
        lblKategori.setText("Kategori");

        lblStok.setForeground(new java.awt.Color(102, 112, 133));
        lblStok.setText("Stok");

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNama.setForeground(new java.awt.Color(16, 24, 40));
        lblNama.setText("Nama produk");

        lblHarga.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(31, 94, 219));
        lblHarga.setText("Rp0");

        pnlTombol.setBackground(new java.awt.Color(255, 255, 255));
        pnlTombol.setOpaque(false);

        btnLihat.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLihat.setForeground(new java.awt.Color(16, 24, 40));
        btnLihat.setText("Lihat");
        btnLihat.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        btnLihat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLihat.setFocusPainted(false);
        btnLihat.setPreferredSize(new java.awt.Dimension(74, 34));
        btnLihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatActionPerformed(evt);
            }
        });

        lblJarak.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblJarak.setForeground(new java.awt.Color(16, 24, 40));
        lblJarak.setPreferredSize(new java.awt.Dimension(8, 8));

        btnKeranjang.setBackground(new java.awt.Color(31, 94, 219));
        btnKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        btnKeranjang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/keranjang_kartu.png"))); // NOI18N
        btnKeranjang.setText("Keranjang");
        btnKeranjang.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnKeranjang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeranjang.setFocusPainted(false);
        btnKeranjang.setIconTextGap(6);
        btnKeranjang.setPreferredSize(new java.awt.Dimension(128, 34));
        btnKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeranjangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTombolLayout = new javax.swing.GroupLayout(pnlTombol);
        pnlTombol.setLayout(pnlTombolLayout);
        pnlTombolLayout.setHorizontalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTombolLayout.createSequentialGroup()
                .addComponent(btnLihat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblJarak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTombolLayout.setVerticalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLihat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlTombolLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblJarak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHarga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatActionPerformed
        aksiLihat.accept(produk);
    }//GEN-LAST:event_btnLihatActionPerformed

    private void btnKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeranjangActionPerformed
        aksiTambah.accept(produk, 1);
    }//GEN-LAST:event_btnKeranjangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeranjang;
    private javax.swing.JButton btnLihat;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJarak;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStok;
    private javax.swing.JPanel pnlTombol;
    // End of variables declaration//GEN-END:variables
}
