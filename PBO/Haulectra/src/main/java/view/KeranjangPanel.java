/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PesananController;
import model.Pesanan;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class KeranjangPanel extends javax.swing.JPanel implements Halaman {

    private final PelangganView induk;
    private final PesananController pesanan = new PesananController();

    public KeranjangPanel(PelangganView induk) {
        this.induk = induk;
        initComponents();
        scrDaftar.getVerticalScrollBar().setUnitIncrement(16);
        scrDaftar.getViewport().addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                sesuaikanLebar();
            }
        });
    }

    @Override
    public void muat() {
        Pesanan k = pesanan.getKeranjang();
        pnlDaftar.removeAll();
        for (Pesanan.Item item : k.getItems()) {
            BarisKeranjang baris = new BarisKeranjang(item, this);
            baris.setAlignmentX(LEFT_ALIGNMENT);
            baris.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, baris.getPreferredSize().height));
            pnlDaftar.add(baris);
            pnlDaftar.add(javax.swing.Box.createVerticalStrut(12));
        }
        boolean kosong = k.getItems().isEmpty();
        ((java.awt.CardLayout) pnlTengah.getLayout()).show(pnlTengah, kosong ? "kosong" : "isi");
        lblJumlahNilai.setText(k.getJumlahBarang() + " barang");
        lblSubtotalNilai.setText(Gaya.rupiah(k.getSubtotal()));
        btnCheckout.setEnabled(!kosong);
        btnCheckout.setBackground(kosong ? Gaya.GARIS : Gaya.BIRU);
        sesuaikanLebar();
        induk.perbaruiKeranjang();
    }

    private void sesuaikanLebar() {
        int w = scrDaftar.getViewport().getWidth();
        if (w <= 0) return;
        pnlDaftar.setPreferredSize(null);
        pnlDaftar.setPreferredSize(new java.awt.Dimension(w, pnlDaftar.getPreferredSize().height));
        pnlDaftar.revalidate();
        pnlDaftar.repaint();
    }

    void ubahJumlah(Pesanan.Item item, int jumlahBaru) {
        if (jumlahBaru < 1) {
            hapus(item);
            return;
        }
        pesanan.ubahJumlah(item.getProduk().getId(), jumlahBaru);
        muat();
    }

    void hapus(Pesanan.Item item) {
        if (KonfirmasiDialog.tanya(this, "Hapus barang", "Yakin ingin menghapus <b>" + item.getProduk().getNama()
                + "</b> dari keranjang?", "Hapus", "dialog_hapus", true)) {
            pesanan.hapusDariKeranjang(item.getProduk().getId());
            muat();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        pnlTengah = new javax.swing.JPanel();
        scrDaftar = new javax.swing.JScrollPane();
        pnlDaftar = new javax.swing.JPanel();
        pnlKosong = new javax.swing.JPanel();
        lblKosongIkon = new javax.swing.JLabel();
        lblKosongJudul = new javax.swing.JLabel();
        lblKosongSub = new javax.swing.JLabel();
        btnBelanja = new javax.swing.JButton();
        pnlKanan = new javax.swing.JPanel();
        pnlRingkasan = new javax.swing.JPanel();
        lblRingkasan = new javax.swing.JLabel();
        lblJumlahTeks = new javax.swing.JLabel();
        lblJumlahNilai = new javax.swing.JLabel();
        lblSubtotalTeks = new javax.swing.JLabel();
        lblSubtotalNilai = new javax.swing.JLabel();
        sepRingkasan = new javax.swing.JSeparator();
        lblCatatan = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 247, 251));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 32, 24, 32));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 0));
        pnlKepala.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Keranjang");

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));

        javax.swing.GroupLayout pnlKepalaLayout = new javax.swing.GroupLayout(pnlKepala);
        pnlKepala.setLayout(pnlKepalaLayout);
        pnlKepalaLayout.setHorizontalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlKepalaLayout.setVerticalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSub)
            .addComponent(lblJudul)
        );

        pnlTengah.setBackground(new java.awt.Color(255, 255, 255));
        pnlTengah.setOpaque(false);
        pnlTengah.setLayout(new java.awt.CardLayout());

        scrDaftar.setBorder(null);
        scrDaftar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlDaftar.setBackground(new java.awt.Color(245, 247, 251));
        pnlDaftar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlDaftar.setLayout(new javax.swing.BoxLayout(pnlDaftar, javax.swing.BoxLayout.Y_AXIS));
        scrDaftar.setViewportView(pnlDaftar);

        pnlTengah.add(scrDaftar, "isi");

        pnlKosong.setBackground(new java.awt.Color(255, 255, 255));
        pnlKosong.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 40, 40, 40));
        pnlKosong.setLayout(new java.awt.GridBagLayout());

        lblKosongIkon.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblKosongIkon.setForeground(new java.awt.Color(16, 24, 40));
        lblKosongIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/keranjang_aktif.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlKosong.add(lblKosongIkon, gridBagConstraints);

        lblKosongJudul.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblKosongJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblKosongJudul.setText("Keranjang masih kosong");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlKosong.add(lblKosongJudul, gridBagConstraints);

        lblKosongSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblKosongSub.setForeground(new java.awt.Color(102, 112, 133));
        lblKosongSub.setText("Pilih produk di Beranda lalu tekan tombol Keranjang.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        pnlKosong.add(lblKosongSub, gridBagConstraints);

        btnBelanja.setBackground(new java.awt.Color(31, 94, 219));
        btnBelanja.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnBelanja.setForeground(new java.awt.Color(255, 255, 255));
        btnBelanja.setText("Mulai Belanja");
        btnBelanja.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnBelanja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBelanja.setFocusPainted(false);
        btnBelanja.setPreferredSize(new java.awt.Dimension(150, 36));
        btnBelanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBelanjaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        pnlKosong.add(btnBelanja, gridBagConstraints);

        pnlTengah.add(pnlKosong, "kosong");

        pnlKanan.setBackground(new java.awt.Color(255, 255, 255));
        pnlKanan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        pnlKanan.setOpaque(false);

        pnlRingkasan.setBackground(new java.awt.Color(255, 255, 255));
        pnlRingkasan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        lblRingkasan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblRingkasan.setForeground(new java.awt.Color(16, 24, 40));
        lblRingkasan.setText("Ringkasan");

        lblJumlahTeks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblJumlahTeks.setForeground(new java.awt.Color(102, 112, 133));
        lblJumlahTeks.setText("Jumlah barang");

        lblJumlahNilai.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblJumlahNilai.setForeground(new java.awt.Color(16, 24, 40));
        lblJumlahNilai.setText("0 barang");

        lblSubtotalTeks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtotalTeks.setForeground(new java.awt.Color(102, 112, 133));
        lblSubtotalTeks.setText("Subtotal");

        lblSubtotalNilai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblSubtotalNilai.setForeground(new java.awt.Color(31, 94, 219));
        lblSubtotalNilai.setText("Rp0");

        sepRingkasan.setForeground(new java.awt.Color(228, 231, 236));

        lblCatatan.setForeground(new java.awt.Color(102, 112, 133));
        lblCatatan.setText("<html><div width=240></div></html>");

        btnCheckout.setBackground(new java.awt.Color(31, 94, 219));
        btnCheckout.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCheckout.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckout.setText("Checkout");
        btnCheckout.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnCheckout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckout.setFocusPainted(false);
        btnCheckout.setPreferredSize(new java.awt.Dimension(120, 42));
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRingkasanLayout = new javax.swing.GroupLayout(pnlRingkasan);
        pnlRingkasan.setLayout(pnlRingkasanLayout);
        pnlRingkasanLayout.setHorizontalGroup(
            pnlRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCatatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblRingkasan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRingkasanLayout.createSequentialGroup()
                .addComponent(lblJumlahTeks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblJumlahNilai))
            .addGroup(pnlRingkasanLayout.createSequentialGroup()
                .addComponent(lblSubtotalTeks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSubtotalNilai))
            .addComponent(sepRingkasan)
            .addComponent(btnCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlRingkasanLayout.setVerticalGroup(
            pnlRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCatatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlRingkasanLayout.createSequentialGroup()
                .addComponent(lblRingkasan)
                .addGap(14, 14, 14)
                .addGroup(pnlRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblJumlahTeks)
                    .addComponent(lblJumlahNilai))
                .addGap(10, 10, 10)
                .addGroup(pnlRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblSubtotalTeks)
                    .addComponent(lblSubtotalNilai))
                .addGap(14, 14, 14)
                .addComponent(sepRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlKananLayout = new javax.swing.GroupLayout(pnlKanan);
        pnlKanan.setLayout(pnlKananLayout);
        pnlKananLayout.setHorizontalGroup(
            pnlKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlKananLayout.setVerticalGroup(
            pnlKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKepala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTengah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlKanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTengah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlKanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBelanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBelanjaActionPerformed
        induk.buka("beranda");
    }//GEN-LAST:event_btnBelanjaActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        induk.buka("checkout");
    }//GEN-LAST:event_btnCheckoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBelanja;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlahNilai;
    private javax.swing.JLabel lblJumlahTeks;
    private javax.swing.JLabel lblKosongIkon;
    private javax.swing.JLabel lblKosongJudul;
    private javax.swing.JLabel lblKosongSub;
    private javax.swing.JLabel lblRingkasan;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblSubtotalNilai;
    private javax.swing.JLabel lblSubtotalTeks;
    private javax.swing.JPanel pnlDaftar;
    private javax.swing.JPanel pnlKanan;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JPanel pnlKosong;
    private javax.swing.JPanel pnlRingkasan;
    private javax.swing.JPanel pnlTengah;
    private javax.swing.JScrollPane scrDaftar;
    private javax.swing.JSeparator sepRingkasan;
    // End of variables declaration//GEN-END:variables
}
