/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.Produk;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class DetailProdukDialog extends javax.swing.JDialog {

    private int jumlah = 1;
    private int maksimal;
    private int hasil;

    public DetailProdukDialog(java.awt.Window parent) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
    }

    public static int pilih(java.awt.Component asal, Produk p, int sudahDiKeranjang) {
        DetailProdukDialog d = new DetailProdukDialog(Gaya.jendela(asal));
        d.lblFoto.setIcon(Gaya.foto(p.getGambar(), 280, 280));
        d.lblKategori.setText(p.getKategori().toUpperCase());
        d.lblNama.setText("<html><div width=340>" + p.getNama() + "</div></html>");
        d.lblHarga.setText(Gaya.rupiah(p.getHarga()));
        d.lblStok.setText(p.getStok() > 0 ? "Stok tersedia " + p.getStok() + " unit" : "Stok habis");
        d.lblDeskripsi.setText("Kode produk: " + p.getKode());
        d.maksimal = Math.max(0, p.getStok() - sudahDiKeranjang);
        d.lblDiKeranjang.setText(sudahDiKeranjang > 0 ? "Sudah ada " + sudahDiKeranjang + " di keranjang" : " ");
        d.jumlah = Math.min(1, d.maksimal);
        d.perbarui();
        d.pack();
        d.setLocationRelativeTo(asal);
        d.setVisible(true);
        return d.hasil;
    }

    private void perbarui() {
        lblJumlah.setText(String.valueOf(jumlah));
        btnKurang.setEnabled(jumlah > 1);
        btnTambah.setEnabled(jumlah < maksimal);
        btnMasukkan.setEnabled(maksimal > 0);
        btnMasukkan.setBackground(maksimal > 0 ? Gaya.BIRU : Gaya.GARIS);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLatar = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        pnlInfo = new javax.swing.JPanel();
        lblKategori = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        sepInfo = new javax.swing.JSeparator();
        lblDeskripsi = new javax.swing.JLabel();
        lblJumlahJudul = new javax.swing.JLabel();
        pnlJumlah = new javax.swing.JPanel();
        btnKurang = new javax.swing.JButton();
        lblJumlah = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        lblDiKeranjang = new javax.swing.JLabel();
        pnlSisa = new javax.swing.JPanel();
        pnlTombol = new javax.swing.JPanel();
        btnTutup = new javax.swing.JButton();
        btnMasukkan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detail Produk");
        setResizable(false);

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 20, 24));

        lblFoto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(16, 24, 40));
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/foto_kosong.png"))); // NOI18N
        lblFoto.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblFoto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));
        lblFoto.setPreferredSize(new java.awt.Dimension(280, 280));

        pnlInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 24, 0, 0));
        pnlInfo.setOpaque(false);

        lblKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(31, 94, 219));
        lblKategori.setText("Kategori");

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblNama.setForeground(new java.awt.Color(16, 24, 40));
        lblNama.setText("Nama produk");

        lblHarga.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(31, 94, 219));
        lblHarga.setText("Rp0");

        lblStok.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblStok.setForeground(new java.awt.Color(102, 112, 133));
        lblStok.setText("Stok");

        sepInfo.setForeground(new java.awt.Color(228, 231, 236));

        lblDeskripsi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblDeskripsi.setForeground(new java.awt.Color(102, 112, 133));
        lblDeskripsi.setText("Kode produk");

        lblJumlahJudul.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJumlahJudul.setForeground(new java.awt.Color(52, 64, 84));
        lblJumlahJudul.setText("Jumlah");

        pnlJumlah.setBackground(new java.awt.Color(255, 255, 255));
        pnlJumlah.setOpaque(false);
        pnlJumlah.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        btnKurang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnKurang.setForeground(new java.awt.Color(16, 24, 40));
        btnKurang.setText("−");
        btnKurang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));
        btnKurang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKurang.setFocusPainted(false);
        btnKurang.setPreferredSize(new java.awt.Dimension(40, 38));
        btnKurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKurangActionPerformed(evt);
            }
        });
        pnlJumlah.add(btnKurang);

        lblJumlah.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblJumlah.setForeground(new java.awt.Color(16, 24, 40));
        lblJumlah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlah.setPreferredSize(new java.awt.Dimension(56, 38));
        lblJumlah.setText("1");
        pnlJumlah.add(lblJumlah);

        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(16, 24, 40));
        btnTambah.setText("+");
        btnTambah.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.setFocusPainted(false);
        btnTambah.setPreferredSize(new java.awt.Dimension(40, 38));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        pnlJumlah.add(btnTambah);

        lblDiKeranjang.setForeground(new java.awt.Color(102, 112, 133));
        lblDiKeranjang.setText(" ");

        pnlSisa.setBackground(new java.awt.Color(255, 255, 255));
        pnlSisa.setOpaque(false);
        pnlSisa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblStok, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sepInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblJumlahJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblDiKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addComponent(lblKategori)
                .addGap(6, 6, 6)
                .addComponent(lblNama)
                .addGap(10, 10, 10)
                .addComponent(lblHarga)
                .addGap(6, 6, 6)
                .addComponent(lblStok)
                .addGap(18, 18, 18)
                .addComponent(sepInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDeskripsi)
                .addGap(18, 18, 18)
                .addComponent(lblJumlahJudul)
                .addGap(8, 8, 8)
                .addComponent(pnlJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblDiKeranjang)
                .addGap(0, 0, 0)
                .addComponent(pnlSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTombol.setBackground(new java.awt.Color(255, 255, 255));
        pnlTombol.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 0, 0, 0));
        pnlTombol.setOpaque(false);

        btnTutup.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTutup.setForeground(new java.awt.Color(16, 24, 40));
        btnTutup.setText("Tutup");
        btnTutup.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        btnTutup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTutup.setFocusPainted(false);
        btnTutup.setPreferredSize(new java.awt.Dimension(100, 36));
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        btnMasukkan.setBackground(new java.awt.Color(31, 94, 219));
        btnMasukkan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMasukkan.setForeground(new java.awt.Color(255, 255, 255));
        btnMasukkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/keranjang_kartu.png"))); // NOI18N
        btnMasukkan.setText("Masukkan ke Keranjang");
        btnMasukkan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnMasukkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMasukkan.setFocusPainted(false);
        btnMasukkan.setIconTextGap(8);
        btnMasukkan.setPreferredSize(new java.awt.Dimension(220, 36));
        btnMasukkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukkanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTombolLayout = new javax.swing.GroupLayout(pnlTombol);
        pnlTombol.setLayout(pnlTombolLayout);
        pnlTombolLayout.setHorizontalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTombolLayout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(btnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnMasukkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTombolLayout.setVerticalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnMasukkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlLatarLayout = new javax.swing.GroupLayout(pnlLatar);
        pnlLatar.setLayout(pnlLatarLayout);
        pnlLatarLayout.setHorizontalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatarLayout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlLatarLayout.setVerticalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatarLayout.createSequentialGroup()
                .addGroup(pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlLatar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKurangActionPerformed
        jumlah = Math.max(1, jumlah - 1);
        perbarui();
    }//GEN-LAST:event_btnKurangActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        jumlah = Math.min(maksimal, jumlah + 1);
        perbarui();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void btnMasukkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukkanActionPerformed
        hasil = jumlah;
        dispose();
    }//GEN-LAST:event_btnMasukkanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKurang;
    private javax.swing.JButton btnMasukkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblDiKeranjang;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblJumlahJudul;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStok;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlJumlah;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlSisa;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JSeparator sepInfo;
    // End of variables declaration//GEN-END:variables
}
