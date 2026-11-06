/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PromoController;
import controller.ValidasiException;
import model.Promo;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class PromoDialog extends javax.swing.JDialog {

    private final PromoController controller = new PromoController();
    private Promo promo;  
    private boolean tersimpan;
    private com.toedter.calendar.JDateChooser dcMulai, dcSelesai;  

    public PromoDialog(java.awt.Window parent) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        dcMulai = gantiDenganKalender(txtMulai);
        dcSelesai = gantiDenganKalender(txtSelesai);
    }

    private com.toedter.calendar.JDateChooser gantiDenganKalender(javax.swing.JTextField txt) {
        java.awt.Container induk = txt.getParent();
        java.awt.GridBagConstraints batas = ((java.awt.GridBagLayout) induk.getLayout()).getConstraints(txt);
        induk.remove(txt);
        com.toedter.calendar.JDateChooser dc = new com.toedter.calendar.JDateChooser();
        dc.setDateFormatString("dd/MM/yyyy");
        dc.setFont(txt.getFont());
        dc.setPreferredSize(txt.getPreferredSize());
        induk.add(dc, batas);
        return dc;
    }

    private static java.util.Date keDate(java.time.LocalDate tgl) {
        return java.util.Date.from(tgl.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
    }

    private static String teksTanggal(com.toedter.calendar.JDateChooser dc) {
        if (dc.getDate() == null) return "";
        return dc.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
                .format(PromoController.FORMAT_TANGGAL);
    }

    public static boolean tampil(java.awt.Component asal, Promo p) {
        PromoDialog d = new PromoDialog(Gaya.jendela(asal));
        d.promo = p;
        if (p != null) {
            d.setTitle("Ubah Promo");
            d.lblJudul.setText("Ubah Promo " + p.getKode());
            d.txtKode.setText(p.getKode());
            (p.getJenis() == 'P' ? d.rbPersen : d.rbNominal).setSelected(true);
            d.txtDiskon.setText(p.getDiskon().stripTrailingZeros().toPlainString());
            d.txtMinimal.setText(String.valueOf(p.getMinimalBarang()));
            d.dcMulai.setDate(keDate(p.getMulai()));
            d.dcSelesai.setDate(keDate(p.getSelesai()));
        } else {
            d.setTitle("Tambah Promo");
            d.txtMinimal.setText("1");
            d.dcMulai.setDate(new java.util.Date());
        }
        d.labelPotongan();
        d.getRootPane().setDefaultButton(d.btnSimpan);
        d.pack();
        d.setLocationRelativeTo(asal);
        d.setVisible(true);
        return d.tersimpan;
    }

    private void labelPotongan() {
        lblDiskon.setText(rbPersen.isSelected() ? "Besar potongan (%), maks. 90" : "Besar potongan (Rp)");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpJenis = new javax.swing.ButtonGroup();
        pnlLatar = new javax.swing.JPanel();
        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        pnlData = new javax.swing.JPanel();
        lblKode = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        lblErrKode = new javax.swing.JLabel();
        lblJenis = new javax.swing.JLabel();
        pnlJenis = new javax.swing.JPanel();
        rbPersen = new javax.swing.JRadioButton();
        lblJarak = new javax.swing.JLabel();
        rbNominal = new javax.swing.JRadioButton();
        lblErrJenis = new javax.swing.JLabel();
        lblDiskon = new javax.swing.JLabel();
        txtDiskon = new javax.swing.JTextField();
        lblErrDiskon = new javax.swing.JLabel();
        lblMinimal = new javax.swing.JLabel();
        txtMinimal = new javax.swing.JTextField();
        lblErrMinimal = new javax.swing.JLabel();
        pnlTanggal = new javax.swing.JPanel();
        pnlMulai = new javax.swing.JPanel();
        lblMulai = new javax.swing.JLabel();
        txtMulai = new javax.swing.JTextField();
        lblErrMulai = new javax.swing.JLabel();
        pnlSelesai = new javax.swing.JPanel();
        lblSelesai = new javax.swing.JLabel();
        txtSelesai = new javax.swing.JTextField();
        lblErrSelesai = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnBatal = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Promo");
        setResizable(false);

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 28, 20, 28));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 0));
        pnlKepala.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Tambah Promo");

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));

        javax.swing.GroupLayout pnlKepalaLayout = new javax.swing.GroupLayout(pnlKepala);
        pnlKepala.setLayout(pnlKepalaLayout);
        pnlKepalaLayout.setHorizontalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSub)
            .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlKepalaLayout.setVerticalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSub)
            .addComponent(lblJudul)
        );

        pnlData.setBackground(new java.awt.Color(255, 255, 255));
        pnlData.setOpaque(false);

        lblKode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKode.setForeground(new java.awt.Color(52, 64, 84));
        lblKode.setText("Kode voucher");

        txtKode.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtKode.setForeground(new java.awt.Color(16, 24, 40));
        txtKode.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtKode.setPreferredSize(new java.awt.Dimension(380, 38));

        lblErrKode.setForeground(new java.awt.Color(217, 45, 32));
        lblErrKode.setText(" ");
        lblErrKode.setPreferredSize(new java.awt.Dimension(40, 17));

        lblJenis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJenis.setForeground(new java.awt.Color(52, 64, 84));
        lblJenis.setText("Jenis potongan");

        pnlJenis.setBackground(new java.awt.Color(255, 255, 255));
        pnlJenis.setOpaque(false);
        pnlJenis.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        rbPersen.setBackground(new java.awt.Color(255, 255, 255));
        grpJenis.add(rbPersen);
        rbPersen.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        rbPersen.setForeground(new java.awt.Color(16, 24, 40));
        rbPersen.setSelected(true);
        rbPersen.setText("Persen (%)");
        rbPersen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbPersen.setFocusPainted(false);
        rbPersen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPersenActionPerformed(evt);
            }
        });
        pnlJenis.add(rbPersen);

        lblJarak.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblJarak.setForeground(new java.awt.Color(16, 24, 40));
        lblJarak.setPreferredSize(new java.awt.Dimension(24, 8));
        pnlJenis.add(lblJarak);

        rbNominal.setBackground(new java.awt.Color(255, 255, 255));
        grpJenis.add(rbNominal);
        rbNominal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        rbNominal.setForeground(new java.awt.Color(16, 24, 40));
        rbNominal.setText("Nominal (Rp)");
        rbNominal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbNominal.setFocusPainted(false);
        rbNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNominalActionPerformed(evt);
            }
        });
        pnlJenis.add(rbNominal);

        lblErrJenis.setForeground(new java.awt.Color(217, 45, 32));
        lblErrJenis.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrJenis.setText(" ");

        lblDiskon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDiskon.setForeground(new java.awt.Color(52, 64, 84));
        lblDiskon.setText("Besar potongan (%)");

        txtDiskon.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtDiskon.setForeground(new java.awt.Color(16, 24, 40));
        txtDiskon.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtDiskon.setPreferredSize(new java.awt.Dimension(380, 38));

        lblErrDiskon.setForeground(new java.awt.Color(217, 45, 32));
        lblErrDiskon.setText(" ");
        lblErrDiskon.setPreferredSize(new java.awt.Dimension(40, 17));

        lblMinimal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMinimal.setForeground(new java.awt.Color(52, 64, 84));
        lblMinimal.setText("Minimal jumlah barang");

        txtMinimal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtMinimal.setForeground(new java.awt.Color(16, 24, 40));
        txtMinimal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtMinimal.setPreferredSize(new java.awt.Dimension(380, 38));

        lblErrMinimal.setForeground(new java.awt.Color(217, 45, 32));
        lblErrMinimal.setText(" ");
        lblErrMinimal.setPreferredSize(new java.awt.Dimension(40, 17));

        pnlTanggal.setBackground(new java.awt.Color(255, 255, 255));
        pnlTanggal.setOpaque(false);

        pnlMulai.setBackground(new java.awt.Color(255, 255, 255));
        pnlMulai.setOpaque(false);

        lblMulai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMulai.setForeground(new java.awt.Color(52, 64, 84));
        lblMulai.setText("Tanggal mulai");

        txtMulai.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtMulai.setForeground(new java.awt.Color(16, 24, 40));
        txtMulai.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtMulai.setPreferredSize(new java.awt.Dimension(180, 38));

        lblErrMulai.setForeground(new java.awt.Color(217, 45, 32));
        lblErrMulai.setText(" ");
        lblErrMulai.setPreferredSize(new java.awt.Dimension(40, 17));

        javax.swing.GroupLayout pnlMulaiLayout = new javax.swing.GroupLayout(pnlMulai);
        pnlMulai.setLayout(pnlMulaiLayout);
        pnlMulaiLayout.setHorizontalGroup(
            pnlMulaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMulaiLayout.setVerticalGroup(
            pnlMulaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMulaiLayout.createSequentialGroup()
                .addComponent(lblMulai)
                .addGap(6, 6, 6)
                .addComponent(txtMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlSelesai.setBackground(new java.awt.Color(255, 255, 255));
        pnlSelesai.setOpaque(false);

        lblSelesai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSelesai.setForeground(new java.awt.Color(52, 64, 84));
        lblSelesai.setText("Tanggal berakhir");

        txtSelesai.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSelesai.setForeground(new java.awt.Color(16, 24, 40));
        txtSelesai.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtSelesai.setPreferredSize(new java.awt.Dimension(180, 38));
        txtSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSelesaiActionPerformed(evt);
            }
        });

        lblErrSelesai.setForeground(new java.awt.Color(217, 45, 32));
        lblErrSelesai.setPreferredSize(new java.awt.Dimension(40, 17));
        lblErrSelesai.setText(" ");

        javax.swing.GroupLayout pnlSelesaiLayout = new javax.swing.GroupLayout(pnlSelesai);
        pnlSelesai.setLayout(pnlSelesaiLayout);
        pnlSelesaiLayout.setHorizontalGroup(
            pnlSelesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlSelesaiLayout.setVerticalGroup(
            pnlSelesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelesaiLayout.createSequentialGroup()
                .addComponent(lblSelesai)
                .addGap(6, 6, 6)
                .addComponent(txtSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlTanggalLayout = new javax.swing.GroupLayout(pnlTanggal);
        pnlTanggal.setLayout(pnlTanggalLayout);
        pnlTanggalLayout.setHorizontalGroup(
            pnlTanggalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTanggalLayout.createSequentialGroup()
                .addComponent(pnlMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(pnlSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTanggalLayout.setVerticalGroup(
            pnlTanggalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKode, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrKode, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblMinimal, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtMinimal, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrMinimal, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblKode)
                .addGap(6, 6, 6)
                .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblJenis)
                .addGap(6, 6, 6)
                .addComponent(pnlJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblDiskon)
                .addGap(6, 6, 6)
                .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblMinimal)
                .addGap(6, 6, 6)
                .addComponent(txtMinimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrMinimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(pnlTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(158, 158, 158)
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
            .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlLatarLayout.setVerticalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatarLayout.createSequentialGroup()
                .addComponent(pnlKepala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlLatar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbPersenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPersenActionPerformed
        labelPotongan();
    }//GEN-LAST:event_rbPersenActionPerformed

    private void rbNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNominalActionPerformed
        labelPotongan();
    }//GEN-LAST:event_rbNominalActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        for (javax.swing.JLabel l : new javax.swing.JLabel[]{lblErrKode, lblErrJenis, lblErrDiskon, lblErrMinimal,
            lblErrMulai, lblErrSelesai}) {
            Gaya.error(l, null);
        }
        try {
            controller.simpan(promo == null ? 0 : promo.getId(), txtKode.getText(), rbPersen.isSelected() ? 'P' : 'N',
                    txtDiskon.getText(), txtMinimal.getText(), teksTanggal(dcMulai), teksTanggal(dcSelesai));
            tersimpan = true;
            dispose();
        } catch (ValidasiException e) {
            Gaya.error(lblErrKode, e.getPesan("kode"));
            Gaya.error(lblErrJenis, e.getPesan("jenis"));
            Gaya.error(lblErrDiskon, e.getPesan("diskon"));
            Gaya.error(lblErrMinimal, e.getPesan("minimal"));
            Gaya.error(lblErrMulai, e.getPesan("mulai"));
            Gaya.error(lblErrSelesai, e.getPesan("selesai"));
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSelesaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelesaiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.ButtonGroup grpJenis;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblErrDiskon;
    private javax.swing.JLabel lblErrJenis;
    private javax.swing.JLabel lblErrKode;
    private javax.swing.JLabel lblErrMinimal;
    private javax.swing.JLabel lblErrMulai;
    private javax.swing.JLabel lblErrSelesai;
    private javax.swing.JLabel lblJarak;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblMinimal;
    private javax.swing.JLabel lblMulai;
    private javax.swing.JLabel lblSelesai;
    private javax.swing.JLabel lblSub;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlJenis;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlMulai;
    private javax.swing.JPanel pnlSelesai;
    private javax.swing.JPanel pnlTanggal;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JRadioButton rbNominal;
    private javax.swing.JRadioButton rbPersen;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtMinimal;
    private javax.swing.JTextField txtMulai;
    private javax.swing.JTextField txtSelesai;
    // End of variables declaration//GEN-END:variables
}
