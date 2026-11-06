/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ProdukController;
import controller.ValidasiException;
import model.Produk;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class ProdukDialog extends javax.swing.JDialog {

    private final ProdukController controller = new ProdukController();
    private Produk produk;         
    private byte[] gambarBaru;      
    private String namaFile;
    private boolean tersimpan;

    public ProdukDialog(java.awt.Window parent) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        for (String k : controller.daftarKategori()) cmbKategori.addItem(k);  
    }

    public static boolean tampil(java.awt.Component asal, Produk p) {
        ProdukDialog d = new ProdukDialog(Gaya.jendela(asal));
        d.produk = p;
        if (p != null) {
            d.setTitle("Ubah Produk");
            d.lblJudul.setText("Ubah Produk (ID " + p.getKode() + ")");
            d.txtNama.setText(p.getNama());
            d.cmbKategori.setSelectedItem(p.getKategori());
            d.txtHarga.setText(p.getHarga().toBigInteger().toString());
            d.txtStok.setText(String.valueOf(p.getStok()));
            d.lblPratinjau.setIcon(Gaya.foto(p.getGambar(), 198, 198));
            if (p.getGambar() != null) d.btnPilihGambar.setText("Ganti Gambar");
        } else {
            d.setTitle("Tambah Produk");
        }
        d.getRootPane().setDefaultButton(d.btnSimpan);
        d.pack();
        d.setLocationRelativeTo(asal);
        d.setVisible(true);
        return d.tersimpan;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLatar = new javax.swing.JPanel();
        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        pnlFoto = new javax.swing.JPanel();
        lblPratinjau = new javax.swing.JLabel();
        btnPilihGambar = new javax.swing.JButton();
        lblNamaFile = new javax.swing.JLabel();
        lblErrGambar = new javax.swing.JLabel();
        pnlData = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblErrNama = new javax.swing.JLabel();
        lblKategori = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        lblErrKategori = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        lblErrHarga = new javax.swing.JLabel();
        lblStok = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        lblErrStok = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnBatal = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produk");
        setResizable(false);

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 28, 20, 28));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 0));
        pnlKepala.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Tambah Produk");

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));
        lblSub.setText("Lengkapi data produk lalu simpan.");

        javax.swing.GroupLayout pnlKepalaLayout = new javax.swing.GroupLayout(pnlKepala);
        pnlKepala.setLayout(pnlKepalaLayout);
        pnlKepalaLayout.setHorizontalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblSub, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlKepalaLayout.setVerticalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(4, 4, 4)
                .addComponent(lblSub))
        );

        pnlFoto.setBackground(new java.awt.Color(255, 255, 255));
        pnlFoto.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 24));
        pnlFoto.setOpaque(false);

        lblPratinjau.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPratinjau.setForeground(new java.awt.Color(16, 24, 40));
        lblPratinjau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPratinjau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/foto_kosong.png"))); // NOI18N
        lblPratinjau.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));
        lblPratinjau.setPreferredSize(new java.awt.Dimension(200, 200));

        btnPilihGambar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPilihGambar.setForeground(new java.awt.Color(16, 24, 40));
        btnPilihGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/unggah.png"))); // NOI18N
        btnPilihGambar.setText("Pilih Gambar");
        btnPilihGambar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        btnPilihGambar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilihGambar.setFocusPainted(false);
        btnPilihGambar.setIconTextGap(8);
        btnPilihGambar.setPreferredSize(new java.awt.Dimension(200, 38));
        btnPilihGambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihGambarActionPerformed(evt);
            }
        });

        lblNamaFile.setForeground(new java.awt.Color(102, 112, 133));
        lblNamaFile.setText("Format JPG / PNG, maks. 2 MB");

        lblErrGambar.setForeground(new java.awt.Color(217, 45, 32));
        lblErrGambar.setText(" ");
        lblErrGambar.setPreferredSize(new java.awt.Dimension(40, 17));

        javax.swing.GroupLayout pnlFotoLayout = new javax.swing.GroupLayout(pnlFoto);
        pnlFoto.setLayout(pnlFotoLayout);
        pnlFotoLayout.setHorizontalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPratinjau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnPilihGambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNamaFile, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlFotoLayout.setVerticalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFotoLayout.createSequentialGroup()
                .addComponent(lblPratinjau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnPilihGambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblNamaFile)
                .addGap(2, 2, 2)
                .addComponent(lblErrGambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pnlData.setBackground(new java.awt.Color(255, 255, 255));
        pnlData.setOpaque(false);

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNama.setForeground(new java.awt.Color(52, 64, 84));
        lblNama.setText("Nama produk");

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNama.setForeground(new java.awt.Color(16, 24, 40));
        txtNama.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtNama.setPreferredSize(new java.awt.Dimension(320, 38));

        lblErrNama.setForeground(new java.awt.Color(217, 45, 32));
        lblErrNama.setText(" ");
        lblErrNama.setPreferredSize(new java.awt.Dimension(40, 17));

        lblKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(52, 64, 84));
        lblKategori.setText("Kategori");

        cmbKategori.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbKategori.setForeground(new java.awt.Color(16, 24, 40));
        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih kategori" }));
        cmbKategori.setPreferredSize(new java.awt.Dimension(320, 38));

        lblErrKategori.setForeground(new java.awt.Color(217, 45, 32));
        lblErrKategori.setText(" ");
        lblErrKategori.setPreferredSize(new java.awt.Dimension(40, 17));

        lblHarga.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHarga.setForeground(new java.awt.Color(52, 64, 84));
        lblHarga.setText("Harga (Rp)");

        txtHarga.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtHarga.setForeground(new java.awt.Color(16, 24, 40));
        txtHarga.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtHarga.setPreferredSize(new java.awt.Dimension(320, 38));

        lblErrHarga.setForeground(new java.awt.Color(217, 45, 32));
        lblErrHarga.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrHarga.setText(" ");

        lblStok.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStok.setForeground(new java.awt.Color(52, 64, 84));
        lblStok.setText("Stok");

        txtStok.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtStok.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtStok.setForeground(new java.awt.Color(16, 24, 40));
        txtStok.setPreferredSize(new java.awt.Dimension(320, 38));

        lblErrStok.setForeground(new java.awt.Color(217, 45, 32));
        lblErrStok.setText(" ");
        lblErrStok.setPreferredSize(new java.awt.Dimension(40, 17));

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrNama, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblStok, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrStok, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addComponent(lblNama)
                .addGap(6, 6, 6)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblKategori)
                .addGap(6, 6, 6)
                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblHarga)
                .addGap(6, 6, 6)
                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblStok)
                .addGap(6, 6, 6)
                .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTombol.setBackground(new java.awt.Color(255, 255, 255));
        pnlTombol.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 0, 0, 0));
        pnlTombol.setOpaque(false);

        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(16, 24, 40));
        btnBatal.setText("Batal");
        btnBatal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        btnBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBatal.setFocusPainted(false);
        btnBatal.setPreferredSize(new java.awt.Dimension(100, 36));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(31, 94, 219));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.setFocusPainted(false);
        btnSimpan.setPreferredSize(new java.awt.Dimension(120, 36));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTombolLayout = new javax.swing.GroupLayout(pnlTombol);
        pnlTombol.setLayout(pnlTombolLayout);
        pnlTombolLayout.setHorizontalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTombolLayout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTombolLayout.setVerticalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlLatarLayout = new javax.swing.GroupLayout(pnlLatar);
        pnlLatar.setLayout(pnlLatarLayout);
        pnlLatarLayout.setHorizontalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlLatarLayout.createSequentialGroup()
                .addComponent(pnlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlLatarLayout.setVerticalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatarLayout.createSequentialGroup()
                .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlLatar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihGambarActionPerformed
        javax.swing.JFileChooser pilih = new javax.swing.JFileChooser();
        pilih.setDialogTitle("Pilih gambar produk");
        pilih.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar (JPG, PNG)", "jpg", "jpeg", "png"));
        if (pilih.showOpenDialog(this) != javax.swing.JFileChooser.APPROVE_OPTION) return;
        java.io.File file = pilih.getSelectedFile();
        try {
            gambarBaru = Gaya.siapkanGambar(file);
            namaFile = file.getName();
            lblPratinjau.setIcon(Gaya.foto(gambarBaru, 198, 198));
            lblNamaFile.setText(namaFile);
            Gaya.error(lblErrGambar, null);
        } catch (java.io.IOException e) {
            Gaya.error(lblErrGambar, "File tidak dapat dibaca sebagai gambar.");
        }
    }//GEN-LAST:event_btnPilihGambarActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblErrNama, lblErrKategori, lblErrHarga, lblErrStok, lblErrGambar}) {
            Gaya.error(l, null);
        }
        String kategori = cmbKategori.getSelectedIndex() <= 0 ? null : (String) cmbKategori.getSelectedItem();
        try {
            controller.simpan(produk == null ? 0 : produk.getId(), txtNama.getText(), kategori, txtHarga.getText(),
                    txtStok.getText(), gambarBaru, namaFile);
            tersimpan = true;
            dispose();
        } catch (ValidasiException e) {
            Gaya.error(lblErrNama, e.getPesan("nama"));
            Gaya.error(lblErrKategori, e.getPesan("kategori"));
            Gaya.error(lblErrHarga, e.getPesan("harga"));
            Gaya.error(lblErrStok, e.getPesan("stok"));
            Gaya.error(lblErrGambar, e.getPesan("gambar"));
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnPilihGambar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel lblErrGambar;
    private javax.swing.JLabel lblErrHarga;
    private javax.swing.JLabel lblErrKategori;
    private javax.swing.JLabel lblErrNama;
    private javax.swing.JLabel lblErrStok;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNamaFile;
    private javax.swing.JLabel lblPratinjau;
    private javax.swing.JLabel lblStok;
    private javax.swing.JLabel lblSub;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlFoto;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
