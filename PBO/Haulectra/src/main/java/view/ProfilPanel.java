/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PelangganController;
import controller.ValidasiException;
import model.Pelanggan;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class ProfilPanel extends javax.swing.JPanel implements Halaman {

    private final PelangganView induk;
    private final PelangganController controller = new PelangganController();

    public ProfilPanel(PelangganView induk) {
        this.induk = induk;
        initComponents();
    }

    @Override
    public void muat() {
        Pelanggan p = controller.profilSaya();
        lblKode.setText(p.getKode() + ", " + p.getUsername());
        txtNama.setText(p.getNama());
        txtUsername.setText(p.getUsername());
        txtTelepon.setText(p.getNoTelepon());
        txtAlamat.setText(p.getAlamat());
        txtBergabung.setText(p.getTanggalBergabung() == null ? "-" : Gaya.tanggal(p.getTanggalBergabung().toLocalDate()));
        modeUbah(false);
    }

    private void modeUbah(boolean ubah) {
        for (javax.swing.JTextField t : new javax.swing.JTextField[]{txtNama, txtUsername, txtTelepon, txtAlamat}) {
            t.setEditable(ubah);
            t.setBackground(ubah ? java.awt.Color.WHITE : Gaya.LATAR);
        }
        btnUbah.setVisible(!ubah);
        btnSimpan.setVisible(ubah);
        btnBatal.setVisible(ubah);
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblErrNama, lblErrUsername, lblErrTelepon, lblErrAlamat}) {
            Gaya.error(l, null);
        }
        if (ubah) txtNama.requestFocusInWindow();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        pnlTengah = new javax.swing.JPanel();
        pnlData = new javax.swing.JPanel();
        lblDataJudul = new javax.swing.JLabel();
        lblKode = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblErrNama = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblErrUsername = new javax.swing.JLabel();
        lblTelepon = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        lblErrTelepon = new javax.swing.JLabel();
        lblBergabung = new javax.swing.JLabel();
        txtBergabung = new javax.swing.JTextField();
        lblErrBergabung = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        lblErrAlamat = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnBatal = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        pnlSisa = new javax.swing.JPanel();

        setBackground(new java.awt.Color(245, 247, 251));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 32, 24, 32));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 0));
        pnlKepala.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Profil");

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

        pnlData.setBackground(new java.awt.Color(255, 255, 255));
        pnlData.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(24, 24, 20, 24)));

        lblDataJudul.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDataJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblDataJudul.setText("Data diri");

        lblKode.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblKode.setForeground(new java.awt.Color(102, 112, 133));
        lblKode.setText("Kode pelanggan");

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNama.setForeground(new java.awt.Color(52, 64, 84));
        lblNama.setText("Nama lengkap");

        txtNama.setEditable(false);
        txtNama.setBackground(new java.awt.Color(245, 247, 251));
        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNama.setForeground(new java.awt.Color(16, 24, 40));
        txtNama.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtNama.setPreferredSize(new java.awt.Dimension(280, 38));

        lblErrNama.setForeground(new java.awt.Color(217, 45, 32));
        lblErrNama.setText(" ");
        lblErrNama.setPreferredSize(new java.awt.Dimension(40, 17));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(52, 64, 84));
        lblUsername.setText("Username");

        txtUsername.setBackground(new java.awt.Color(245, 247, 251));
        txtUsername.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtUsername.setEditable(false);
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(16, 24, 40));
        txtUsername.setPreferredSize(new java.awt.Dimension(280, 38));

        lblErrUsername.setForeground(new java.awt.Color(217, 45, 32));
        lblErrUsername.setText(" ");
        lblErrUsername.setPreferredSize(new java.awt.Dimension(40, 17));

        lblTelepon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTelepon.setForeground(new java.awt.Color(52, 64, 84));
        lblTelepon.setText("No. telepon");

        txtTelepon.setBackground(new java.awt.Color(245, 247, 251));
        txtTelepon.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtTelepon.setEditable(false);
        txtTelepon.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTelepon.setForeground(new java.awt.Color(16, 24, 40));
        txtTelepon.setPreferredSize(new java.awt.Dimension(280, 38));

        lblErrTelepon.setForeground(new java.awt.Color(217, 45, 32));
        lblErrTelepon.setText(" ");
        lblErrTelepon.setPreferredSize(new java.awt.Dimension(40, 17));

        lblBergabung.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBergabung.setForeground(new java.awt.Color(52, 64, 84));
        lblBergabung.setText("Bergabung sejak");

        txtBergabung.setEditable(false);
        txtBergabung.setBackground(new java.awt.Color(245, 247, 251));
        txtBergabung.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtBergabung.setForeground(new java.awt.Color(16, 24, 40));
        txtBergabung.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtBergabung.setPreferredSize(new java.awt.Dimension(280, 38));

        lblErrBergabung.setForeground(new java.awt.Color(217, 45, 32));
        lblErrBergabung.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrBergabung.setText(" ");

        lblAlamat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(52, 64, 84));
        lblAlamat.setText("Alamat pengiriman");

        txtAlamat.setEditable(false);
        txtAlamat.setBackground(new java.awt.Color(245, 247, 251));
        txtAlamat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAlamat.setForeground(new java.awt.Color(16, 24, 40));
        txtAlamat.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtAlamat.setPreferredSize(new java.awt.Dimension(280, 38));

        lblErrAlamat.setForeground(new java.awt.Color(217, 45, 32));
        lblErrAlamat.setText(" ");
        lblErrAlamat.setPreferredSize(new java.awt.Dimension(40, 17));

        pnlTombol.setBackground(new java.awt.Color(255, 255, 255));
        pnlTombol.setOpaque(false);

        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(16, 24, 40));
        btnBatal.setText("Batal");
        btnBatal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        btnBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBatal.setFocusPainted(false);
        btnBatal.setPreferredSize(new java.awt.Dimension(130, 36));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(31, 94, 219));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("Ubah Data");
        btnUbah.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.setFocusPainted(false);
        btnUbah.setPreferredSize(new java.awt.Dimension(130, 36));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(31, 94, 219));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.setFocusPainted(false);
        btnSimpan.setPreferredSize(new java.awt.Dimension(130, 36));
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
                .addComponent(btnBatal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUbah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTombolLayout.setVerticalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDataJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblKode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBergabung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBergabung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblErrBergabung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(lblAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblErrAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTombol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addComponent(lblDataJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBergabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBergabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrBergabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblErrAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlSisa.setBackground(new java.awt.Color(255, 255, 255));
        pnlSisa.setOpaque(false);
        pnlSisa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        javax.swing.GroupLayout pnlTengahLayout = new javax.swing.GroupLayout(pnlTengah);
        pnlTengah.setLayout(pnlTengahLayout);
        pnlTengahLayout.setHorizontalGroup(
            pnlTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlData, 0, 700, 700)
            .addComponent(pnlSisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlTengahLayout.setVerticalGroup(
            pnlTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTengahLayout.createSequentialGroup()
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlSisa, 0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKepala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTengah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlTengah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        muat();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        modeUbah(true);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (!KonfirmasiDialog.tanya(this, "Simpan data diri", "Pastikan data diri sudah benar. Simpan perubahan?",
                "Simpan", "dialog_tanya", false)) {
            return;
        }
        try {
            controller.ubahProfil(txtNama.getText(), txtUsername.getText(), txtTelepon.getText(), txtAlamat.getText());
            induk.perbaruiNama();
            muat();
            NotifikasiDialog.tampil(this, "Data diri berhasil disimpan", null);
        } catch (ValidasiException e) {
            Gaya.error(lblErrNama, e.getPesan("nama"));
            Gaya.error(lblErrUsername, e.getPesan("username"));
            Gaya.error(lblErrTelepon, e.getPesan("telepon"));
            Gaya.error(lblErrAlamat, e.getPesan("alamat"));
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblBergabung;
    private javax.swing.JLabel lblDataJudul;
    private javax.swing.JLabel lblErrAlamat;
    private javax.swing.JLabel lblErrBergabung;
    private javax.swing.JLabel lblErrNama;
    private javax.swing.JLabel lblErrTelepon;
    private javax.swing.JLabel lblErrUsername;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JPanel pnlSisa;
    private javax.swing.JPanel pnlTengah;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtBergabung;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
