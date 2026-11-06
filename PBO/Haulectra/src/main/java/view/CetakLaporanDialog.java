/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PesananController;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Pesanan;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class CetakLaporanDialog extends javax.swing.JDialog {

    private final PesananController controller = new PesananController();

    public CetakLaporanDialog(java.awt.Window parent) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
    }

    public static void tampil(java.awt.Component asal) {
        CetakLaporanDialog d = new CetakLaporanDialog(Gaya.jendela(asal));
        d.pack();
        d.setLocationRelativeTo(asal);
        d.setVisible(true);
    }

    private Object nilai(Pesanan p, String kolom) {
        return switch (kolom) {
            case "No. Pesanan" -> p.getNomor();
            case "Tanggal" -> Gaya.tanggal(p.getTanggal());
            case "Pelanggan" -> p.getPelanggan().getNama();
            case "Produk" -> p.getNamaProduk();
            case "Total (Rp)" -> p.getTotalHarga().toBigInteger();  
            case "Metode Bayar" -> Gaya.metode(p.getMetodeBayar());
            case "Status" -> p.getTahap().toString();
            default -> p.getNomorResi() == null ? "-" : p.getNomorResi();
        };
    }

    private void simpan() {
        List<String> kolom = new ArrayList<>();
        for (javax.swing.JCheckBox c : new javax.swing.JCheckBox[]{chkNomor, chkTanggal, chkPelanggan, chkProduk,
            chkTotal, chkMetode, chkStatus, chkResi}) {
            if (c.isSelected()) kolom.add(c.getText());
        }
        if (kolom.isEmpty()) {
            Gaya.error(lblErr, "Pilih minimal satu kolom.");
            return;
        }
        Pesanan.Tahap tahap = null;
        for (Pesanan.Tahap t : Pesanan.Tahap.values()) {
            if (t.toString().equals(cmbStatus.getSelectedItem())) tahap = t;
        }
        List<Pesanan> data = new ArrayList<>(controller.cari("", tahap));
        if (tahap == null) data.removeIf(p -> p.getTahap() == Pesanan.Tahap.DIBATALKAN);  
        if (data.isEmpty()) {
            Gaya.error(lblErr, "Tidak ada pesanan dengan status ini.");
            return;
        }
        Gaya.error(lblErr, null);

        JFileChooser pilih = new JFileChooser();
        pilih.setDialogTitle("Simpan laporan");
        pilih.setFileFilter(new FileNameExtensionFilter("File Excel (*.csv)", "csv"));
        pilih.setSelectedFile(new File("laporan_pesanan_haulectra_" + LocalDate.now() + ".csv"));
        if (pilih.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File file = pilih.getSelectedFile();
        if (!file.getName().toLowerCase().endsWith(".csv")) file = new File(file.getPath() + ".csv");

        try {
            tulisCsv(file, kolom, data);
            java.awt.Window induk = getOwner();
            dispose();
            KonfirmasiDialog.info(induk, "Laporan berhasil disimpan",
                    "File <b>" + file.getName() + "</b> tersimpan di folder " + file.getParent()
                    + ". Buka file tersebut dengan Microsoft Excel.");
        } catch (IOException e) {
            KonfirmasiDialog.gagal(this, "Laporan gagal disimpan. " + e.getMessage());
        }
    }

    private void tulisCsv(File file, List<String> kolom, List<Pesanan> data) throws IOException {
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
            out.println("sep=;");                      // memberi tahu Excel pemisah kolomnya titik koma
            out.println("Laporan Pesanan HAULECTRA");
            out.println("Status;" + cmbStatus.getSelectedItem());
            out.println("Dibuat;" + Gaya.tanggal(LocalDateTime.now()));
            out.println();
            out.println(String.join(";", kolom));
            BigDecimal total = BigDecimal.ZERO;
            for (Pesanan p : data) {
                List<String> baris = new ArrayList<>();
                for (String k : kolom) baris.add(sel(nilai(p, k)));
                out.println(String.join(";", baris));
                total = total.add(p.getTotalHarga());
            }
            out.println();
            out.println("Jumlah pesanan;" + data.size());
            out.println("Total nilai pesanan (Rp);" + total.toBigInteger());
        }
    }

    private static String sel(Object nilai) {
        String s = String.valueOf(nilai);
        return s.contains(";") || s.contains("\"") ? "\"" + s.replace("\"", "\"\"") + "\"" : s;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlLatar = new javax.swing.JPanel();
        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        pnlIsi = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        lblKolom = new javax.swing.JLabel();
        pnlKolom = new javax.swing.JPanel();
        chkNomor = new javax.swing.JCheckBox();
        chkTanggal = new javax.swing.JCheckBox();
        chkPelanggan = new javax.swing.JCheckBox();
        chkProduk = new javax.swing.JCheckBox();
        chkTotal = new javax.swing.JCheckBox();
        chkMetode = new javax.swing.JCheckBox();
        chkStatus = new javax.swing.JCheckBox();
        chkResi = new javax.swing.JCheckBox();
        lblErr = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnBatal = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cetak Laporan");
        setResizable(false);

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 28, 20, 28));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 18, 0));
        pnlKepala.setOpaque(false);
        pnlKepala.setLayout(new java.awt.GridBagLayout());

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Cetak Laporan Pesanan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        pnlKepala.add(lblJudul, gridBagConstraints);

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        pnlKepala.add(lblSub, gridBagConstraints);

        pnlIsi.setBackground(new java.awt.Color(255, 255, 255));
        pnlIsi.setOpaque(false);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(52, 64, 84));
        lblStatus.setText("Status pesanan");

        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbStatus.setForeground(new java.awt.Color(16, 24, 40));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua status", "Menunggu Pembayaran", "Diproses", "Dikirim", "Selesai", "Pesanan Dibatalkan" }));
        cmbStatus.setPreferredSize(new java.awt.Dimension(360, 38));

        lblKolom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKolom.setForeground(new java.awt.Color(52, 64, 84));
        lblKolom.setText("Kolom yang dimasukkan ke laporan");

        pnlKolom.setBackground(new java.awt.Color(255, 255, 255));
        pnlKolom.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(12, 14, 12, 14)));

        chkNomor.setBackground(new java.awt.Color(255, 255, 255));
        chkNomor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkNomor.setForeground(new java.awt.Color(16, 24, 40));
        chkNomor.setSelected(true);
        chkNomor.setText("No. Pesanan");
        chkNomor.setFocusPainted(false);

        chkTanggal.setBackground(new java.awt.Color(255, 255, 255));
        chkTanggal.setFocusPainted(false);
        chkTanggal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkTanggal.setForeground(new java.awt.Color(16, 24, 40));
        chkTanggal.setSelected(true);
        chkTanggal.setText("Tanggal");

        chkPelanggan.setBackground(new java.awt.Color(255, 255, 255));
        chkPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkPelanggan.setForeground(new java.awt.Color(16, 24, 40));
        chkPelanggan.setSelected(true);
        chkPelanggan.setText("Pelanggan");
        chkPelanggan.setFocusPainted(false);

        chkProduk.setBackground(new java.awt.Color(255, 255, 255));
        chkProduk.setFocusPainted(false);
        chkProduk.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkProduk.setForeground(new java.awt.Color(16, 24, 40));
        chkProduk.setText("Produk");

        chkTotal.setBackground(new java.awt.Color(255, 255, 255));
        chkTotal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkTotal.setForeground(new java.awt.Color(16, 24, 40));
        chkTotal.setSelected(true);
        chkTotal.setText("Total (Rp)");
        chkTotal.setFocusPainted(false);

        chkMetode.setBackground(new java.awt.Color(255, 255, 255));
        chkMetode.setFocusPainted(false);
        chkMetode.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkMetode.setForeground(new java.awt.Color(16, 24, 40));
        chkMetode.setText("Metode Bayar");

        chkStatus.setBackground(new java.awt.Color(255, 255, 255));
        chkStatus.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkStatus.setForeground(new java.awt.Color(16, 24, 40));
        chkStatus.setSelected(true);
        chkStatus.setText("Status");
        chkStatus.setFocusPainted(false);

        chkResi.setBackground(new java.awt.Color(255, 255, 255));
        chkResi.setFocusPainted(false);
        chkResi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkResi.setForeground(new java.awt.Color(16, 24, 40));
        chkResi.setSelected(true);
        chkResi.setText("No. Resi");

        javax.swing.GroupLayout pnlKolomLayout = new javax.swing.GroupLayout(pnlKolom);
        pnlKolom.setLayout(pnlKolomLayout);
        pnlKolomLayout.setHorizontalGroup(
            pnlKolomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKolomLayout.createSequentialGroup()
                .addComponent(chkNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlKolomLayout.createSequentialGroup()
                .addComponent(chkPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlKolomLayout.createSequentialGroup()
                .addComponent(chkTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlKolomLayout.createSequentialGroup()
                .addComponent(chkStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkResi, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlKolomLayout.setVerticalGroup(
            pnlKolomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKolomLayout.createSequentialGroup()
                .addGroup(pnlKolomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkNomor)
                    .addComponent(chkTanggal))
                .addGap(8, 8, 8)
                .addGroup(pnlKolomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPelanggan)
                    .addComponent(chkProduk))
                .addGap(8, 8, 8)
                .addGroup(pnlKolomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkTotal)
                    .addComponent(chkMetode))
                .addGap(8, 8, 8)
                .addGroup(pnlKolomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkStatus)
                    .addComponent(chkResi)))
        );

        lblErr.setForeground(new java.awt.Color(217, 45, 32));
        lblErr.setText(" ");
        lblErr.setPreferredSize(new java.awt.Dimension(40, 17));

        javax.swing.GroupLayout pnlIsiLayout = new javax.swing.GroupLayout(pnlIsi);
        pnlIsi.setLayout(pnlIsiLayout);
        pnlIsiLayout.setHorizontalGroup(
            pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblKolom, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlKolom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErr, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlIsiLayout.setVerticalGroup(
            pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIsiLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblStatus)
                .addGap(6, 6, 6)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblKolom)
                .addGap(8, 8, 8)
                .addComponent(pnlKolom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblErr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTombol.setBackground(new java.awt.Color(255, 255, 255));
        pnlTombol.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0));
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
        btnSimpan.setText("Simpan ke Excel");
        btnSimpan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.setFocusPainted(false);
        btnSimpan.setPreferredSize(new java.awt.Dimension(150, 36));
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
                .addGap(172, 172, 172)
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
            .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlLatarLayout.setVerticalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatarLayout.createSequentialGroup()
                .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlLatar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JCheckBox chkMetode;
    private javax.swing.JCheckBox chkNomor;
    private javax.swing.JCheckBox chkPelanggan;
    private javax.swing.JCheckBox chkProduk;
    private javax.swing.JCheckBox chkResi;
    private javax.swing.JCheckBox chkStatus;
    private javax.swing.JCheckBox chkTanggal;
    private javax.swing.JCheckBox chkTotal;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel lblErr;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKolom;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSub;
    private javax.swing.JPanel pnlIsi;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JPanel pnlKolom;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlTombol;
    // End of variables declaration//GEN-END:variables
}
