/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.Pesanan;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class BarisKeranjang extends javax.swing.JPanel {

    private final Pesanan.Item item;
    private final KeranjangPanel induk;

    public BarisKeranjang(Pesanan.Item item, KeranjangPanel induk) {
        this.item = item;
        this.induk = induk;
        initComponents();
        lblFoto.setIcon(Gaya.foto(item.getProduk().getGambar(), 72, 72));
        lblNama.setText(item.getProduk().getNama());
        lblHarga.setText(Gaya.rupiah(item.getProduk().getHarga()) + " / barang, stok " + item.getProduk().getStok());
        lblJumlah.setText(String.valueOf(item.getJumlah()));
        lblSubtotal.setText(Gaya.rupiah(item.getSubtotal()));
        btnTambah.setEnabled(item.getJumlah() < item.getProduk().getStok()); 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFoto = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        pnlJumlah = new javax.swing.JPanel();
        btnKurang = new javax.swing.JButton();
        lblJumlah = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        lblSubtotal = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 16)));

        lblFoto.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(16, 24, 40));
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/foto_kosong.png"))); // NOI18N
        lblFoto.setPreferredSize(new java.awt.Dimension(72, 72));

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNama.setForeground(new java.awt.Color(16, 24, 40));
        lblNama.setText("Nama produk");

        lblHarga.setForeground(new java.awt.Color(102, 112, 133));
        lblHarga.setText("Rp0 / barang");

        pnlJumlah.setBackground(new java.awt.Color(255, 255, 255));
        pnlJumlah.setOpaque(false);
        pnlJumlah.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        btnKurang.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnKurang.setForeground(new java.awt.Color(16, 24, 40));
        btnKurang.setText("−");
        btnKurang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));
        btnKurang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKurang.setFocusPainted(false);
        btnKurang.setPreferredSize(new java.awt.Dimension(34, 34));
        btnKurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKurangActionPerformed(evt);
            }
        });
        pnlJumlah.add(btnKurang);

        lblJumlah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblJumlah.setForeground(new java.awt.Color(16, 24, 40));
        lblJumlah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlah.setPreferredSize(new java.awt.Dimension(44, 34));
        lblJumlah.setText("1");
        pnlJumlah.add(lblJumlah);

        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(16, 24, 40));
        btnTambah.setText("+");
        btnTambah.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.setFocusPainted(false);
        btnTambah.setPreferredSize(new java.awt.Dimension(34, 34));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        pnlJumlah.add(btnTambah);

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(16, 24, 40));
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setPreferredSize(new java.awt.Dimension(130, 24));
        lblSubtotal.setText("Rp0");

        btnHapus.setBackground(new java.awt.Color(253, 236, 236));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(217, 45, 32));
        btnHapus.setText("Hapus");
        btnHapus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.setFocusPainted(false);
        btnHapus.setPreferredSize(new java.awt.Dimension(80, 34));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblNama)
                        .addGap(4, 4, 4)
                        .addComponent(lblHarga))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnKurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKurangActionPerformed
        induk.ubahJumlah(item, item.getJumlah() - 1);
    }//GEN-LAST:event_btnKurangActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        induk.ubahJumlah(item, item.getJumlah() + 1);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        induk.hapus(item);
    }//GEN-LAST:event_btnHapusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKurang;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JPanel pnlJumlah;
    // End of variables declaration//GEN-END:variables
}
