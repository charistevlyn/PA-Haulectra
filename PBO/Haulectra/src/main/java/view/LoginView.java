/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AuthController;
import controller.ValidasiException;
import model.Admin;
import model.Pelanggan;
import model.Pengguna;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class LoginView extends javax.swing.JFrame {

    private final AuthController auth = new AuthController();
    private final char karakterTitik;   

    public LoginView() {
        initComponents();
        karakterTitik = txtPassword.getEchoChar();
        tampilTab(true);
    }

    private void tampilTab(boolean login) {
        ((java.awt.CardLayout) pnlIsi.getLayout()).show(pnlIsi, login ? "login" : "daftar");
        warnaiTab(btnTabLogin, login);
        warnaiTab(btnTabDaftar, !login);
        getRootPane().setDefaultButton(login ? btnLogin : btnDaftar);
    }

    private void warnaiTab(javax.swing.JButton tab, boolean aktif) {
        tab.setBackground(aktif ? Gaya.BIRU : java.awt.Color.WHITE);
        tab.setForeground(aktif ? java.awt.Color.WHITE : Gaya.REDUP);
        tab.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }

    private void lihatPassword(javax.swing.JPasswordField kolom, javax.swing.JButton tombol) {
        boolean tersembunyi = kolom.getEchoChar() != 0;
        kolom.setEchoChar(tersembunyi ? (char) 0 : karakterTitik);   // (char) 0 = tampilkan teks asli
        tombol.setIcon(Gaya.ikon(tersembunyi ? "mata_tutup" : "mata"));
        tombol.setToolTipText(tersembunyi ? "Sembunyikan password" : "Tampilkan password");
        kolom.requestFocusInWindow();
    }

    private void login() {
        Gaya.error(lblErrUsername, null);
        Gaya.error(lblErrPassword, null);
        try {
            Pengguna p = auth.login(txtUsername.getText(), new String(txtPassword.getPassword()));
            dispose();
            if (p instanceof Admin) {
                new AdminView().setVisible(true);
            } else {
                new PelangganView().setVisible(true);
            }
        } catch (ValidasiException e) {
            Gaya.error(lblErrUsername, e.getPesan("username"));
            Gaya.error(lblErrPassword, e.getPesan("password"));
        } catch (RuntimeException e) {
            KonfirmasiDialog.gagal(this, "Tidak dapat terhubung ke database. Periksa pengaturan di Konfigurasi.");
        }
    }

    private void daftar() {
        javax.swing.JLabel[] semua = {lblErrNama, lblErrUsernameBaru, lblErrTelepon, lblErrAlamat,
            lblErrPasswordBaru, lblErrKonfirmasi};
        for (javax.swing.JLabel l : semua) Gaya.error(l, null);
        try {
            Pelanggan baru = auth.registrasi(txtNama.getText(), txtUsernameBaru.getText(), txtTelepon.getText(),
                    txtAlamat.getText(), new String(txtPasswordBaru.getPassword()), new String(txtKonfirmasi.getPassword()));
            KonfirmasiDialog.info(this, "Akun berhasil dibuat", "Silakan login dengan username " + baru.getUsername() + ".");
            txtUsername.setText(baru.getUsername());
            txtPassword.setText("");
            for (javax.swing.text.JTextComponent t : new javax.swing.text.JTextComponent[]{txtNama, txtUsernameBaru,
                txtTelepon, txtAlamat, txtPasswordBaru, txtKonfirmasi}) t.setText("");
            tampilTab(true);
            txtPassword.requestFocusInWindow();
        } catch (ValidasiException e) {
            Gaya.error(lblErrNama, e.getPesan("nama"));
            Gaya.error(lblErrUsernameBaru, e.getPesan("username"));
            Gaya.error(lblErrTelepon, e.getPesan("telepon"));
            Gaya.error(lblErrAlamat, e.getPesan("alamat"));
            Gaya.error(lblErrPasswordBaru, e.getPesan("password"));
            Gaya.error(lblErrKonfirmasi, e.getPesan("konfirmasi"));
        } catch (RuntimeException e) {
            KonfirmasiDialog.gagal(this, "Akun gagal disimpan. " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlLatar = new javax.swing.JPanel();
        pnlKiri = new javax.swing.JPanel();
        pnlSampul = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTagline = new javax.swing.JLabel();
        lblSlogan = new javax.swing.JLabel();
        lblSampul = new javax.swing.JLabel();
        pnlKanan = new javax.swing.JPanel();
        pnlKartu = new javax.swing.JPanel();
        pnlTab = new javax.swing.JPanel();
        btnTabLogin = new javax.swing.JButton();
        btnTabDaftar = new javax.swing.JButton();
        pnlIsi = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        lblMasuk = new javax.swing.JLabel();
        lblMasukSub = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblErrUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        pnlPassword = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        btnLihatPassword = new javax.swing.JButton();
        lblErrPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblBelumPunya = new javax.swing.JLabel();
        pnlIsiLogin = new javax.swing.JPanel();
        pnlDaftar = new javax.swing.JPanel();
        lblBuatAkun = new javax.swing.JLabel();
        lblBuatAkunSub = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblErrNama = new javax.swing.JLabel();
        lblUsernameBaru = new javax.swing.JLabel();
        txtUsernameBaru = new javax.swing.JTextField();
        lblErrUsernameBaru = new javax.swing.JLabel();
        lblTelepon = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        lblErrTelepon = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        lblErrAlamat = new javax.swing.JLabel();
        lblPasswordBaru = new javax.swing.JLabel();
        pnlPasswordBaru = new javax.swing.JPanel();
        txtPasswordBaru = new javax.swing.JPasswordField();
        btnLihatPasswordBaru = new javax.swing.JButton();
        lblErrPasswordBaru = new javax.swing.JLabel();
        lblKonfirmasi = new javax.swing.JLabel();
        pnlKonfirmasi = new javax.swing.JPanel();
        txtKonfirmasi = new javax.swing.JPasswordField();
        btnLihatKonfirmasi = new javax.swing.JButton();
        lblErrKonfirmasi = new javax.swing.JLabel();
        btnDaftar = new javax.swing.JButton();
        pnlIsiDaftar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HAULECTRA - Login");
        setMinimumSize(new java.awt.Dimension(1000, 660));

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlLatar.setPreferredSize(new java.awt.Dimension(1180, 720));
        pnlLatar.setLayout(new java.awt.GridLayout(1, 2));

        pnlKiri.setBackground(new java.awt.Color(255, 255, 255));
        pnlKiri.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 48, 32, 48));
        pnlKiri.setLayout(new java.awt.GridBagLayout());

        pnlSampul.setBackground(new java.awt.Color(255, 255, 255));
        pnlSampul.setOpaque(false);

        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(16, 24, 40));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/logo_besar.png"))); // NOI18N
        lblLogo.setIconTextGap(12);

        lblTagline.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTagline.setForeground(new java.awt.Color(31, 94, 219));
        lblTagline.setText("TOKO ELEKTRONIK TERPERCAYA");

        lblSlogan.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        lblSlogan.setForeground(new java.awt.Color(16, 24, 40));
        lblSlogan.setText("<html>Teknologi pilihan.<br>Belanja lebih nyaman.</html>");

        lblSampul.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSampul.setForeground(new java.awt.Color(16, 24, 40));
        lblSampul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/sampul_login.png"))); // NOI18N

        javax.swing.GroupLayout pnlSampulLayout = new javax.swing.GroupLayout(pnlSampul);
        pnlSampul.setLayout(pnlSampulLayout);
        pnlSampulLayout.setHorizontalGroup(
            pnlSampulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSampulLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlSampulLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnlSampulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTagline, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSlogan, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(lblSampul, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlSampulLayout.setVerticalGroup(
            pnlSampulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSampulLayout.createSequentialGroup()
                .addComponent(lblLogo)
                .addGap(60, 60, 60)
                .addGroup(pnlSampulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTagline)
                    .addGroup(pnlSampulLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblSlogan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(lblSampul))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlKiri.add(pnlSampul, gridBagConstraints);

        pnlLatar.add(pnlKiri);

        pnlKanan.setBackground(new java.awt.Color(245, 247, 251));
        pnlKanan.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 48, 32, 48));

        pnlKartu.setBackground(new java.awt.Color(255, 255, 255));
        pnlKartu.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(28, 32, 28, 32)));
        pnlKartu.setPreferredSize(new java.awt.Dimension(440, 560));

        pnlTab.setBackground(new java.awt.Color(255, 255, 255));
        pnlTab.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));
        pnlTab.setLayout(new java.awt.GridLayout(1, 2));

        btnTabLogin.setBackground(new java.awt.Color(31, 94, 219));
        btnTabLogin.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTabLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnTabLogin.setText("Login");
        btnTabLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnTabLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTabLogin.setFocusPainted(false);
        btnTabLogin.setPreferredSize(new java.awt.Dimension(120, 40));
        btnTabLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabLoginActionPerformed(evt);
            }
        });
        pnlTab.add(btnTabLogin);

        btnTabDaftar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnTabDaftar.setForeground(new java.awt.Color(16, 24, 40));
        btnTabDaftar.setText("Daftar");
        btnTabDaftar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        btnTabDaftar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTabDaftar.setFocusPainted(false);
        btnTabDaftar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnTabDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabDaftarActionPerformed(evt);
            }
        });
        pnlTab.add(btnTabDaftar);

        pnlIsi.setBackground(new java.awt.Color(255, 255, 255));
        pnlIsi.setOpaque(false);
        pnlIsi.setLayout(new java.awt.CardLayout());

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogin.setOpaque(false);

        lblMasuk.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblMasuk.setForeground(new java.awt.Color(16, 24, 40));
        lblMasuk.setText("Selamat datang kembali");

        lblMasukSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblMasukSub.setForeground(new java.awt.Color(102, 112, 133));
        lblMasukSub.setText("Masuk untuk melanjutkan belanja Anda.");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(52, 64, 84));
        lblUsername.setText("Username");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(16, 24, 40));
        txtUsername.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtUsername.setPreferredSize(new java.awt.Dimension(340, 38));

        lblErrUsername.setForeground(new java.awt.Color(217, 45, 32));
        lblErrUsername.setText(" ");
        lblErrUsername.setPreferredSize(new java.awt.Dimension(40, 17));

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(52, 64, 84));
        lblPassword.setText("Password");

        pnlPassword.setBackground(new java.awt.Color(255, 255, 255));
        pnlPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        pnlPassword.setPreferredSize(new java.awt.Dimension(340, 38));
        pnlPassword.setLayout(new java.awt.BorderLayout());

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(16, 24, 40));
        txtPassword.setBorder(null);
        txtPassword.setPreferredSize(new java.awt.Dimension(290, 38));
        pnlPassword.add(txtPassword, java.awt.BorderLayout.CENTER);

        btnLihatPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/mata.png"))); // NOI18N
        btnLihatPassword.setToolTipText("Tampilkan password");
        btnLihatPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 8));
        btnLihatPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLihatPassword.setFocusPainted(false);
        btnLihatPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatPasswordActionPerformed(evt);
            }
        });
        pnlPassword.add(btnLihatPassword, java.awt.BorderLayout.EAST);

        lblErrPassword.setForeground(new java.awt.Color(217, 45, 32));
        lblErrPassword.setText(" ");
        lblErrPassword.setPreferredSize(new java.awt.Dimension(40, 17));

        btnLogin.setBackground(new java.awt.Color(31, 94, 219));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new java.awt.Dimension(120, 42));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblBelumPunya.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblBelumPunya.setForeground(new java.awt.Color(102, 112, 133));
        lblBelumPunya.setText("Belum memiliki akun? Pilih tab Daftar.");

        pnlIsiLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlIsiLogin.setOpaque(false);

        javax.swing.GroupLayout pnlIsiLoginLayout = new javax.swing.GroupLayout(pnlIsiLogin);
        pnlIsiLogin.setLayout(pnlIsiLoginLayout);
        pnlIsiLoginLayout.setHorizontalGroup(
            pnlIsiLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );
        pnlIsiLoginLayout.setVerticalGroup(
            pnlIsiLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblMasukSub, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblBelumPunya, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlIsiLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addComponent(lblMasuk)
                .addGap(0, 0, 0)
                .addComponent(lblMasukSub)
                .addGap(20, 20, 20)
                .addComponent(lblUsername)
                .addGap(6, 6, 6)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblPassword)
                .addGap(6, 6, 6)
                .addComponent(pnlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lblBelumPunya)
                .addGap(0, 0, 0)
                .addComponent(pnlIsiLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlIsi.add(pnlLogin, "login");

        pnlDaftar.setBackground(new java.awt.Color(255, 255, 255));
        pnlDaftar.setOpaque(false);
        pnlDaftar.setLayout(new java.awt.GridBagLayout());

        lblBuatAkun.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblBuatAkun.setForeground(new java.awt.Color(16, 24, 40));
        lblBuatAkun.setText("Buat akun pelanggan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlDaftar.add(lblBuatAkun, gridBagConstraints);

        lblBuatAkunSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblBuatAkunSub.setForeground(new java.awt.Color(102, 112, 133));
        lblBuatAkunSub.setText("Isi data diri untuk mulai berbelanja.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 16, 0);
        pnlDaftar.add(lblBuatAkunSub, gridBagConstraints);

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNama.setForeground(new java.awt.Color(52, 64, 84));
        lblNama.setText("Nama lengkap");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlDaftar.add(lblNama, gridBagConstraints);

        txtNama.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNama.setForeground(new java.awt.Color(16, 24, 40));
        txtNama.setPreferredSize(new java.awt.Dimension(170, 38));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        pnlDaftar.add(txtNama, gridBagConstraints);

        lblErrNama.setForeground(new java.awt.Color(217, 45, 32));
        lblErrNama.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrNama.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 4, 0);
        pnlDaftar.add(lblErrNama, gridBagConstraints);

        lblUsernameBaru.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUsernameBaru.setForeground(new java.awt.Color(52, 64, 84));
        lblUsernameBaru.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        pnlDaftar.add(lblUsernameBaru, gridBagConstraints);

        txtUsernameBaru.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtUsernameBaru.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUsernameBaru.setForeground(new java.awt.Color(16, 24, 40));
        txtUsernameBaru.setPreferredSize(new java.awt.Dimension(170, 38));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 14, 0, 0);
        pnlDaftar.add(txtUsernameBaru, gridBagConstraints);

        lblErrUsernameBaru.setForeground(new java.awt.Color(217, 45, 32));
        lblErrUsernameBaru.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrUsernameBaru.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 14, 4, 0);
        pnlDaftar.add(lblErrUsernameBaru, gridBagConstraints);

        lblTelepon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTelepon.setForeground(new java.awt.Color(52, 64, 84));
        lblTelepon.setText("No. telepon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlDaftar.add(lblTelepon, gridBagConstraints);

        txtTelepon.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtTelepon.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTelepon.setForeground(new java.awt.Color(16, 24, 40));
        txtTelepon.setPreferredSize(new java.awt.Dimension(170, 38));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        pnlDaftar.add(txtTelepon, gridBagConstraints);

        lblErrTelepon.setForeground(new java.awt.Color(217, 45, 32));
        lblErrTelepon.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrTelepon.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 4, 0);
        pnlDaftar.add(lblErrTelepon, gridBagConstraints);

        lblAlamat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(52, 64, 84));
        lblAlamat.setText("Alamat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        pnlDaftar.add(lblAlamat, gridBagConstraints);

        txtAlamat.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtAlamat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAlamat.setForeground(new java.awt.Color(16, 24, 40));
        txtAlamat.setPreferredSize(new java.awt.Dimension(170, 38));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 14, 0, 0);
        pnlDaftar.add(txtAlamat, gridBagConstraints);

        lblErrAlamat.setForeground(new java.awt.Color(217, 45, 32));
        lblErrAlamat.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrAlamat.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 14, 4, 0);
        pnlDaftar.add(lblErrAlamat, gridBagConstraints);

        lblPasswordBaru.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPasswordBaru.setForeground(new java.awt.Color(52, 64, 84));
        lblPasswordBaru.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlDaftar.add(lblPasswordBaru, gridBagConstraints);

        pnlPasswordBaru.setBackground(new java.awt.Color(255, 255, 255));
        pnlPasswordBaru.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        pnlPasswordBaru.setPreferredSize(new java.awt.Dimension(170, 38));
        pnlPasswordBaru.setLayout(new java.awt.BorderLayout());

        txtPasswordBaru.setBorder(null);
        txtPasswordBaru.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtPasswordBaru.setForeground(new java.awt.Color(16, 24, 40));
        txtPasswordBaru.setPreferredSize(new java.awt.Dimension(120, 38));
        pnlPasswordBaru.add(txtPasswordBaru, java.awt.BorderLayout.CENTER);

        btnLihatPasswordBaru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/mata.png"))); // NOI18N
        btnLihatPasswordBaru.setToolTipText("Tampilkan password");
        btnLihatPasswordBaru.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 8));
        btnLihatPasswordBaru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLihatPasswordBaru.setFocusPainted(false);
        btnLihatPasswordBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatPasswordBaruActionPerformed(evt);
            }
        });
        pnlPasswordBaru.add(btnLihatPasswordBaru, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        pnlDaftar.add(pnlPasswordBaru, gridBagConstraints);

        lblErrPasswordBaru.setForeground(new java.awt.Color(217, 45, 32));
        lblErrPasswordBaru.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrPasswordBaru.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 4, 0);
        pnlDaftar.add(lblErrPasswordBaru, gridBagConstraints);

        lblKonfirmasi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKonfirmasi.setForeground(new java.awt.Color(52, 64, 84));
        lblKonfirmasi.setText("Ulangi password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        pnlDaftar.add(lblKonfirmasi, gridBagConstraints);

        pnlKonfirmasi.setBackground(new java.awt.Color(255, 255, 255));
        pnlKonfirmasi.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        pnlKonfirmasi.setPreferredSize(new java.awt.Dimension(170, 38));
        pnlKonfirmasi.setLayout(new java.awt.BorderLayout());

        txtKonfirmasi.setBorder(null);
        txtKonfirmasi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtKonfirmasi.setForeground(new java.awt.Color(16, 24, 40));
        txtKonfirmasi.setPreferredSize(new java.awt.Dimension(120, 38));
        pnlKonfirmasi.add(txtKonfirmasi, java.awt.BorderLayout.CENTER);

        btnLihatKonfirmasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/mata.png"))); // NOI18N
        btnLihatKonfirmasi.setToolTipText("Tampilkan password");
        btnLihatKonfirmasi.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 8));
        btnLihatKonfirmasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLihatKonfirmasi.setFocusPainted(false);
        btnLihatKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatKonfirmasiActionPerformed(evt);
            }
        });
        pnlKonfirmasi.add(btnLihatKonfirmasi, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 14, 0, 0);
        pnlDaftar.add(pnlKonfirmasi, gridBagConstraints);

        lblErrKonfirmasi.setForeground(new java.awt.Color(217, 45, 32));
        lblErrKonfirmasi.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrKonfirmasi.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 14, 4, 0);
        pnlDaftar.add(lblErrKonfirmasi, gridBagConstraints);

        btnDaftar.setBackground(new java.awt.Color(31, 94, 219));
        btnDaftar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDaftar.setForeground(new java.awt.Color(255, 255, 255));
        btnDaftar.setText("Daftar");
        btnDaftar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnDaftar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDaftar.setFocusPainted(false);
        btnDaftar.setPreferredSize(new java.awt.Dimension(120, 42));
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        pnlDaftar.add(btnDaftar, gridBagConstraints);

        pnlIsiDaftar.setBackground(new java.awt.Color(255, 255, 255));
        pnlIsiDaftar.setOpaque(false);
        pnlIsiDaftar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        pnlDaftar.add(pnlIsiDaftar, gridBagConstraints);

        pnlIsi.add(pnlDaftar, "daftar");

        javax.swing.GroupLayout pnlKartuLayout = new javax.swing.GroupLayout(pnlKartu);
        pnlKartu.setLayout(pnlKartuLayout);
        pnlKartuLayout.setHorizontalGroup(
            pnlKartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTab, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlKartuLayout.setVerticalGroup(
            pnlKartuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKartuLayout.createSequentialGroup()
                .addComponent(pnlTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pnlIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlKananLayout = new javax.swing.GroupLayout(pnlKanan);
        pnlKanan.setLayout(pnlKananLayout);
        pnlKananLayout.setHorizontalGroup(
            pnlKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKananLayout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(pnlKartu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        pnlKananLayout.setVerticalGroup(
            pnlKananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKananLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(pnlKartu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pnlLatar.add(pnlKanan);

        getContentPane().add(pnlLatar, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTabLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabLoginActionPerformed
        tampilTab(true);
    }//GEN-LAST:event_btnTabLoginActionPerformed

    private void btnTabDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabDaftarActionPerformed
        tampilTab(false);
    }//GEN-LAST:event_btnTabDaftarActionPerformed

    private void btnLihatPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatPasswordActionPerformed
        lihatPassword(txtPassword, btnLihatPassword);
    }//GEN-LAST:event_btnLihatPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLihatPasswordBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatPasswordBaruActionPerformed
        lihatPassword(txtPasswordBaru, btnLihatPasswordBaru);
    }//GEN-LAST:event_btnLihatPasswordBaruActionPerformed

    private void btnLihatKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatKonfirmasiActionPerformed
        lihatPassword(txtKonfirmasi, btnLihatKonfirmasi);
    }//GEN-LAST:event_btnLihatKonfirmasiActionPerformed

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        daftar();
    }//GEN-LAST:event_btnDaftarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnLihatKonfirmasi;
    private javax.swing.JButton btnLihatPassword;
    private javax.swing.JButton btnLihatPasswordBaru;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnTabDaftar;
    private javax.swing.JButton btnTabLogin;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblBelumPunya;
    private javax.swing.JLabel lblBuatAkun;
    private javax.swing.JLabel lblBuatAkunSub;
    private javax.swing.JLabel lblErrAlamat;
    private javax.swing.JLabel lblErrKonfirmasi;
    private javax.swing.JLabel lblErrNama;
    private javax.swing.JLabel lblErrPassword;
    private javax.swing.JLabel lblErrPasswordBaru;
    private javax.swing.JLabel lblErrTelepon;
    private javax.swing.JLabel lblErrUsername;
    private javax.swing.JLabel lblErrUsernameBaru;
    private javax.swing.JLabel lblKonfirmasi;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMasuk;
    private javax.swing.JLabel lblMasukSub;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordBaru;
    private javax.swing.JLabel lblSampul;
    private javax.swing.JLabel lblSlogan;
    private javax.swing.JLabel lblTagline;
    private javax.swing.JLabel lblTelepon;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsernameBaru;
    private javax.swing.JPanel pnlDaftar;
    private javax.swing.JPanel pnlIsi;
    private javax.swing.JPanel pnlIsiDaftar;
    private javax.swing.JPanel pnlIsiLogin;
    private javax.swing.JPanel pnlKanan;
    private javax.swing.JPanel pnlKartu;
    private javax.swing.JPanel pnlKiri;
    private javax.swing.JPanel pnlKonfirmasi;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlPassword;
    private javax.swing.JPanel pnlPasswordBaru;
    private javax.swing.JPanel pnlSampul;
    private javax.swing.JPanel pnlTab;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JPasswordField txtKonfirmasi;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordBaru;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameBaru;
    // End of variables declaration//GEN-END:variables
}
