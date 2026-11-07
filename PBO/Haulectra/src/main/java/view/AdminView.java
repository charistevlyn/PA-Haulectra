/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AuthController;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class AdminView extends javax.swing.JFrame {

    private final java.util.Map<String, Halaman> halaman = new java.util.LinkedHashMap<>();
    private final java.util.Map<String, javax.swing.JButton> tombolMenu = new java.util.LinkedHashMap<>();

    public AdminView() {
        initComponents();
        lblNamaAdmin.setText(AuthController.getPenggunaLogin().getNama());  
        daftarkan("produk", new ProdukPanel(), btnProduk);
        daftarkan("promo", new PromoPanel(), btnPromo);
        daftarkan("pesanan", new PesananAdminPanel(), btnPesanan);
        daftarkan("pelanggan", new DataPelangganPanel(), btnPelanggan);
        buka("produk");
    }

    private void daftarkan(String nama, javax.swing.JPanel panel, javax.swing.JButton tombol) {
        halaman.put(nama, (Halaman) panel);
        tombolMenu.put(nama, tombol);
        pnlHalaman.add(panel, nama);
    }

    private void buka(String nama) {
        ((java.awt.CardLayout) pnlHalaman.getLayout()).show(pnlHalaman, nama);
        tombolMenu.forEach((n, b) -> {
            boolean aktif = n.equals(nama);
            b.setBackground(aktif ? Gaya.BIRU_MUDA : java.awt.Color.WHITE);
            b.setForeground(aktif ? Gaya.BIRU : new java.awt.Color(52, 64, 84));
            b.setIcon(Gaya.ikon(aktif ? n + "_aktif" : n));
        });
        halaman.get(nama).muat();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSamping = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        btnProduk = new javax.swing.JButton();
        btnPromo = new javax.swing.JButton();
        btnPesanan = new javax.swing.JButton();
        btnPelanggan = new javax.swing.JButton();
        pnlSisa = new javax.swing.JPanel();
        sepLogout = new javax.swing.JSeparator();
        btnLogout = new javax.swing.JButton();
        pnlUtama = new javax.swing.JPanel();
        pnlAtas = new javax.swing.JPanel();
        lblLokasi = new javax.swing.JLabel();
        lblNamaAdmin = new javax.swing.JLabel();
        pnlHalaman = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HAULECTRA - Admin");
        setMinimumSize(new java.awt.Dimension(1240, 740));

        pnlSamping.setBackground(new java.awt.Color(255, 255, 255));
        pnlSamping.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(20, 16, 20, 16)));
        pnlSamping.setPreferredSize(new java.awt.Dimension(248, 600));

        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(16, 24, 40));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/logo.png"))); // NOI18N
        lblLogo.setIconTextGap(10);

        lblMenu.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(102, 112, 133));
        lblMenu.setText("MENU ADMIN");

        btnProduk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProduk.setForeground(new java.awt.Color(52, 64, 84));
        btnProduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/produk.png"))); // NOI18N
        btnProduk.setText("Kelola Produk");
        btnProduk.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        btnProduk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduk.setFocusPainted(false);
        btnProduk.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProduk.setIconTextGap(10);
        btnProduk.setPreferredSize(new java.awt.Dimension(200, 42));
        btnProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdukActionPerformed(evt);
            }
        });

        btnPromo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPromo.setForeground(new java.awt.Color(52, 64, 84));
        btnPromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/promo.png"))); // NOI18N
        btnPromo.setText("Kelola Promo");
        btnPromo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        btnPromo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPromo.setFocusPainted(false);
        btnPromo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPromo.setIconTextGap(10);
        btnPromo.setPreferredSize(new java.awt.Dimension(200, 42));
        btnPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromoActionPerformed(evt);
            }
        });

        btnPesanan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPesanan.setForeground(new java.awt.Color(52, 64, 84));
        btnPesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/pesanan.png"))); // NOI18N
        btnPesanan.setText("Kelola Pesanan");
        btnPesanan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        btnPesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesanan.setFocusPainted(false);
        btnPesanan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPesanan.setIconTextGap(10);
        btnPesanan.setPreferredSize(new java.awt.Dimension(200, 42));
        btnPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesananActionPerformed(evt);
            }
        });

        btnPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPelanggan.setForeground(new java.awt.Color(52, 64, 84));
        btnPelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/pelanggan.png"))); // NOI18N
        btnPelanggan.setText("Data Pelanggan");
        btnPelanggan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        btnPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPelanggan.setFocusPainted(false);
        btnPelanggan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPelanggan.setIconTextGap(10);
        btnPelanggan.setPreferredSize(new java.awt.Dimension(200, 42));
        btnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelangganActionPerformed(evt);
            }
        });

        pnlSisa.setBackground(new java.awt.Color(255, 255, 255));
        pnlSisa.setOpaque(false);

        javax.swing.GroupLayout pnlSisaLayout = new javax.swing.GroupLayout(pnlSisa);
        pnlSisa.setLayout(pnlSisaLayout);
        pnlSisaLayout.setHorizontalGroup(
            pnlSisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        pnlSisaLayout.setVerticalGroup(
            pnlSisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        sepLogout.setForeground(new java.awt.Color(228, 231, 236));

        btnLogout.setBackground(new java.awt.Color(217, 45, 32));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/logout_putih.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusPainted(false);
        btnLogout.setIconTextGap(8);
        btnLogout.setPreferredSize(new java.awt.Dimension(120, 42));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSampingLayout = new javax.swing.GroupLayout(pnlSamping);
        pnlSamping.setLayout(pnlSampingLayout);
        pnlSampingLayout.setHorizontalGroup(
            pnlSampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSampingLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPromo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sepLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSampingLayout.setVerticalGroup(
            pnlSampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSampingLayout.createSequentialGroup()
                .addComponent(lblLogo)
                .addGap(28, 28, 28)
                .addComponent(lblMenu)
                .addGap(8, 8, 8)
                .addComponent(btnProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(pnlSisa, 0, 0, Short.MAX_VALUE)
                .addComponent(sepLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlSamping, java.awt.BorderLayout.WEST);

        pnlUtama.setBackground(new java.awt.Color(245, 247, 251));
        pnlUtama.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlUtama.setLayout(new java.awt.BorderLayout());

        pnlAtas.setBackground(new java.awt.Color(255, 255, 255));
        pnlAtas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 32, 0, 32)));
        pnlAtas.setPreferredSize(new java.awt.Dimension(900, 56));

        lblLokasi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblLokasi.setForeground(new java.awt.Color(102, 112, 133));

        lblNamaAdmin.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblNamaAdmin.setForeground(new java.awt.Color(52, 64, 84));
        lblNamaAdmin.setText("Nama Admin");

        javax.swing.GroupLayout pnlAtasLayout = new javax.swing.GroupLayout(pnlAtas);
        pnlAtas.setLayout(pnlAtasLayout);
        pnlAtasLayout.setHorizontalGroup(
            pnlAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAtasLayout.createSequentialGroup()
                .addComponent(lblLokasi)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblNamaAdmin))
        );
        pnlAtasLayout.setVerticalGroup(
            pnlAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLokasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNamaAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlUtama.add(pnlAtas, java.awt.BorderLayout.NORTH);

        pnlHalaman.setBackground(new java.awt.Color(245, 247, 251));
        pnlHalaman.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlHalaman.setLayout(new java.awt.CardLayout());
        pnlUtama.add(pnlHalaman, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlUtama, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdukActionPerformed
        buka("produk");
    }//GEN-LAST:event_btnProdukActionPerformed

    private void btnPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromoActionPerformed
        buka("promo");
    }//GEN-LAST:event_btnPromoActionPerformed

    private void btnPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesananActionPerformed
        buka("pesanan");
    }//GEN-LAST:event_btnPesananActionPerformed

    private void btnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelangganActionPerformed
        buka("pelanggan");
    }//GEN-LAST:event_btnPelangganActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        if (KonfirmasiDialog.tanya(this, "Logout", "Yakin ingin keluar dari akun admin?", "Logout",
                "dialog_logout", true)) {
            new AuthController().logout();
            dispose();
            new LoginView().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPelanggan;
    private javax.swing.JButton btnPesanan;
    private javax.swing.JButton btnProduk;
    private javax.swing.JButton btnPromo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLokasi;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblNamaAdmin;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlHalaman;
    private javax.swing.JPanel pnlSamping;
    private javax.swing.JPanel pnlSisa;
    private javax.swing.JPanel pnlUtama;
    private javax.swing.JSeparator sepLogout;
    // End of variables declaration//GEN-END:variables
}
