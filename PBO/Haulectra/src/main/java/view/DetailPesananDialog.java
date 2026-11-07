/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import config.Konfigurasi;
import controller.PesananController;
import controller.ValidasiException;
import javax.swing.table.DefaultTableModel;
import model.Pesanan;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class DetailPesananDialog extends javax.swing.JDialog {

    private final PesananController controller = new PesananController();
    private Pesanan pesanan;

    public DetailPesananDialog(java.awt.Window parent) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        Gaya.tabel(tblBarang);
        Gaya.lebarKolom(tblBarang, 300, 120, 70, 130);
    }

    public static void tampil(java.awt.Component asal, Pesanan p, boolean pelanggan) {
        DetailPesananDialog d = new DetailPesananDialog(Gaya.jendela(asal));
        Pesanan terbaru = d.controller.muatUlang(p.getId());  
        d.pesanan = terbaru == null ? p : terbaru;
        d.isi(pelanggan);
        d.pack();
        d.setLocationRelativeTo(asal);
        d.setVisible(true);
    }

    private void isi(boolean pelanggan) {
        Pesanan p = pesanan;
        lblNomor.setText(p.getNomor() + ", " + Gaya.tanggal(p.getTanggal()));
        Gaya.badge(lblStatus, pelanggan ? Gaya.statusPelanggan(p) : p.getTahap().toString());
        lblPenerima.setText(p.getPelanggan().getNama() + ", " + p.getPelanggan().getNoTelepon());
        lblAlamat.setText("<html><div width=180>" + p.getPelanggan().getAlamat() + "</div></html>");
        lblMetode.setText(Gaya.metode(p.getMetodeBayar()));
        lblBayar.setText(p.isLunas() ? "Lunas" : "Belum dibayar");
        lblResi.setText(p.getNomorResi() == null ? "Belum dikirim" : p.getNomorResi());
        lblEstimasi.setText(p.getTahap() == Pesanan.Tahap.SELESAI
                ? "Diterima " + Gaya.tanggal(p.getTanggalDiterima())
                : Gaya.tanggal(p.getEstimasiTiba()));

        DefaultTableModel model = (DefaultTableModel) tblBarang.getModel();
        model.setRowCount(0);
        for (Pesanan.Item i : p.getItems()) {
            model.addRow(new Object[]{i.getProduk().getNama(), Gaya.rupiah(i.getProduk().getHarga()),
                i.getJumlah(), Gaya.rupiah(i.getSubtotal())});
        }
        lblSubtotal.setText(Gaya.rupiah(p.getSubtotal()));
        lblOngkir.setText(Gaya.rupiah(Konfigurasi.ONGKOS_KIRIM));
        lblPotongan.setText("-" + Gaya.rupiah(p.getPotongan()));
        lblTotal.setText(Gaya.rupiah(p.getTotalHarga()));
        btnDiterima.setVisible(pelanggan && p.getTahap() == Pesanan.Tahap.DIKIRIM);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLatar = new javax.swing.JPanel();
        pnlKepala = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblNomor = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        pnlIsi = new javax.swing.JPanel();
        pnlInfo = new javax.swing.JPanel();
        lblPenerimaTeks = new javax.swing.JLabel();
        lblPenerima = new javax.swing.JLabel();
        lblMetodeTeks = new javax.swing.JLabel();
        lblMetode = new javax.swing.JLabel();
        lblResiTeks = new javax.swing.JLabel();
        lblResi = new javax.swing.JLabel();
        lblAlamatTeks = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        lblBayarTeks = new javax.swing.JLabel();
        lblBayar = new javax.swing.JLabel();
        lblEstimasiTeks = new javax.swing.JLabel();
        lblEstimasi = new javax.swing.JLabel();
        scrBarang = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        pnlTotal = new javax.swing.JPanel();
        lblSubtotalTeks = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblOngkirTeks = new javax.swing.JLabel();
        lblOngkir = new javax.swing.JLabel();
        lblPotonganTeks = new javax.swing.JLabel();
        lblPotongan = new javax.swing.JLabel();
        lblTotalTeks = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnTutup = new javax.swing.JButton();
        btnDiterima = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detail Pesanan");

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 28, 20, 28));
        pnlLatar.setPreferredSize(new java.awt.Dimension(760, 560));

        pnlKepala.setBackground(new java.awt.Color(255, 255, 255));
        pnlKepala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 18, 0));
        pnlKepala.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Detail Pesanan");

        lblNomor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNomor.setForeground(new java.awt.Color(102, 112, 133));
        lblNomor.setText("Nomor");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(16, 24, 40));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Status");
        lblStatus.setPreferredSize(new java.awt.Dimension(150, 28));

        javax.swing.GroupLayout pnlKepalaLayout = new javax.swing.GroupLayout(pnlKepala);
        pnlKepala.setLayout(pnlKepalaLayout);
        pnlKepalaLayout.setHorizontalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addGroup(pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul, 0, 348, Short.MAX_VALUE)
                    .addComponent(lblNomor, 0, 348, Short.MAX_VALUE))
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlKepalaLayout.setVerticalGroup(
            pnlKepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addComponent(lblJudul)
                .addGap(4, 4, 4)
                .addComponent(lblNomor))
            .addGroup(pnlKepalaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlIsi.setBackground(new java.awt.Color(255, 255, 255));
        pnlIsi.setOpaque(false);

        pnlInfo.setBackground(new java.awt.Color(245, 247, 251));
        pnlInfo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(16, 18, 16, 18)));

        lblPenerimaTeks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPenerimaTeks.setForeground(new java.awt.Color(52, 64, 84));
        lblPenerimaTeks.setText("Penerima");

        lblPenerima.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPenerima.setForeground(new java.awt.Color(16, 24, 40));
        lblPenerima.setText("-");

        lblMetodeTeks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMetodeTeks.setForeground(new java.awt.Color(52, 64, 84));
        lblMetodeTeks.setText("Metode pembayaran");

        lblMetode.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblMetode.setForeground(new java.awt.Color(16, 24, 40));
        lblMetode.setText("-");

        lblResiTeks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblResiTeks.setForeground(new java.awt.Color(52, 64, 84));
        lblResiTeks.setText("Nomor resi");

        lblResi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblResi.setForeground(new java.awt.Color(16, 24, 40));
        lblResi.setText("-");

        lblAlamatTeks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAlamatTeks.setForeground(new java.awt.Color(52, 64, 84));
        lblAlamatTeks.setText("Alamat");

        lblAlamat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(16, 24, 40));
        lblAlamat.setText("-");

        lblBayarTeks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBayarTeks.setForeground(new java.awt.Color(52, 64, 84));
        lblBayarTeks.setText("Pembayaran");

        lblBayar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblBayar.setForeground(new java.awt.Color(16, 24, 40));
        lblBayar.setText("-");

        lblEstimasiTeks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEstimasiTeks.setForeground(new java.awt.Color(52, 64, 84));
        lblEstimasiTeks.setText("Estimasi tiba");

        lblEstimasi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblEstimasi.setForeground(new java.awt.Color(16, 24, 40));
        lblEstimasi.setText("-");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 110, Short.MAX_VALUE)
                    .addComponent(lblPenerimaTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlamatTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 173, Short.MAX_VALUE)
                    .addComponent(lblMetodeTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMetode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBayarTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 128, Short.MAX_VALUE)
                    .addComponent(lblResiTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstimasiTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstimasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPenerimaTeks)
                    .addComponent(lblMetodeTeks)
                    .addComponent(lblResiTeks))
                .addGap(4, 4, 4)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPenerima)
                    .addComponent(lblMetode)
                    .addComponent(lblResi))
                .addGap(14, 14, 14)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAlamatTeks)
                    .addComponent(lblBayarTeks)
                    .addComponent(lblEstimasiTeks))
                .addGap(4, 4, 4)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAlamat)
                    .addComponent(lblBayar)
                    .addComponent(lblEstimasi)))
        );

        scrBarang.setBackground(new java.awt.Color(255, 255, 255));
        scrBarang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)));
        scrBarang.setPreferredSize(new java.awt.Dimension(600, 150));

        tblBarang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produk", "Harga", "Jumlah", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBarang.setGridColor(new java.awt.Color(228, 231, 236));
        tblBarang.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblBarang.setRowHeight(40);
        tblBarang.setSelectionBackground(new java.awt.Color(232, 240, 255));
        tblBarang.setSelectionForeground(new java.awt.Color(16, 24, 40));
        scrBarang.setViewportView(tblBarang);

        pnlTotal.setBackground(new java.awt.Color(255, 255, 255));
        pnlTotal.setOpaque(false);

        lblSubtotalTeks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtotalTeks.setForeground(new java.awt.Color(102, 112, 133));
        lblSubtotalTeks.setText("Subtotal");

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(16, 24, 40));
        lblSubtotal.setText("Rp0");

        lblOngkirTeks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblOngkirTeks.setForeground(new java.awt.Color(102, 112, 133));
        lblOngkirTeks.setText("Ongkos kirim");

        lblOngkir.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblOngkir.setForeground(new java.awt.Color(16, 24, 40));
        lblOngkir.setText("Rp0");

        lblPotonganTeks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPotonganTeks.setForeground(new java.awt.Color(102, 112, 133));
        lblPotonganTeks.setText("Potongan voucher");

        lblPotongan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblPotongan.setForeground(new java.awt.Color(18, 128, 92));
        lblPotongan.setText("Rp0");

        lblTotalTeks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTotalTeks.setForeground(new java.awt.Color(102, 112, 133));
        lblTotalTeks.setText("Total pembayaran");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(31, 94, 219));
        lblTotal.setText("Rp0");

        javax.swing.GroupLayout pnlTotalLayout = new javax.swing.GroupLayout(pnlTotal);
        pnlTotal.setLayout(pnlTotalLayout);
        pnlTotalLayout.setHorizontalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addComponent(lblSubtotalTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblSubtotal))
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addComponent(lblOngkirTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblOngkir))
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addComponent(lblPotonganTeks)
                .addGap(32, 32, 32)
                .addComponent(lblPotongan))
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addComponent(lblTotalTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblTotal))
        );
        pnlTotalLayout.setVerticalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtotalTeks)
                    .addComponent(lblSubtotal))
                .addGap(6, 6, 6)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOngkirTeks)
                    .addComponent(lblOngkir))
                .addGap(6, 6, 6)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPotonganTeks)
                    .addComponent(lblPotongan))
                .addGap(6, 6, 6)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTotalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblTotalTeks))
                    .addComponent(lblTotal)))
        );

        javax.swing.GroupLayout pnlIsiLayout = new javax.swing.GroupLayout(pnlIsi);
        pnlIsi.setLayout(pnlIsiLayout);
        pnlIsiLayout.setHorizontalGroup(
            pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrBarang, 0, 498, Short.MAX_VALUE)
            .addGroup(pnlIsiLayout.createSequentialGroup()
                .addGap(0, 341, Short.MAX_VALUE)
                .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlIsiLayout.setVerticalGroup(
            pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIsiLayout.createSequentialGroup()
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(scrBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTombol.setBackground(new java.awt.Color(255, 255, 255));
        pnlTombol.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0));
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

        btnDiterima.setBackground(new java.awt.Color(31, 94, 219));
        btnDiterima.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDiterima.setForeground(new java.awt.Color(255, 255, 255));
        btnDiterima.setText("Pesanan Sudah Diterima");
        btnDiterima.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnDiterima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDiterima.setFocusPainted(false);
        btnDiterima.setPreferredSize(new java.awt.Dimension(210, 36));
        btnDiterima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiterimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTombolLayout = new javax.swing.GroupLayout(pnlTombol);
        pnlTombol.setLayout(pnlTombolLayout);
        pnlTombolLayout.setHorizontalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTombolLayout.createSequentialGroup()
                .addGap(0, 172, Short.MAX_VALUE)
                .addComponent(btnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnDiterima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTombolLayout.setVerticalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDiterima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlLatarLayout = new javax.swing.GroupLayout(pnlLatar);
        pnlLatar.setLayout(pnlLatarLayout);
        pnlLatarLayout.setHorizontalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKepala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlIsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTombol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void btnDiterimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiterimaActionPerformed
        if (KonfirmasiDialog.yaTidak(this, "Konfirmasi penerimaan",
                "Pesanan <b>" + pesanan.getNomor() + "</b> sudah diterima?", "dialog_sukses")) {
            try {
                controller.konfirmasiDiterima(pesanan);
                isi(true);
                NotifikasiDialog.tampil(this, "Pesanan selesai", "Terima kasih telah berbelanja di HAULECTRA");
            } catch (ValidasiException e) {
                KonfirmasiDialog.gagal(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDiterimaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiterima;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblAlamatTeks;
    private javax.swing.JLabel lblBayar;
    private javax.swing.JLabel lblBayarTeks;
    private javax.swing.JLabel lblEstimasi;
    private javax.swing.JLabel lblEstimasiTeks;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblMetode;
    private javax.swing.JLabel lblMetodeTeks;
    private javax.swing.JLabel lblNomor;
    private javax.swing.JLabel lblOngkir;
    private javax.swing.JLabel lblOngkirTeks;
    private javax.swing.JLabel lblPenerima;
    private javax.swing.JLabel lblPenerimaTeks;
    private javax.swing.JLabel lblPotongan;
    private javax.swing.JLabel lblPotonganTeks;
    private javax.swing.JLabel lblResi;
    private javax.swing.JLabel lblResiTeks;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblSubtotalTeks;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalTeks;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlIsi;
    private javax.swing.JPanel pnlKepala;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JScrollPane scrBarang;
    private javax.swing.JTable tblBarang;
    // End of variables declaration//GEN-END:variables
}
