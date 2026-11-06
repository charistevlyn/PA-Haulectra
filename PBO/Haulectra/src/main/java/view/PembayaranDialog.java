/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PesananController;
import controller.ValidasiException;
import model.Pesanan;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class PembayaranDialog extends javax.swing.JDialog {

    private final PesananController controller = new PesananController();
    private Pesanan pesanan;
    private boolean lunas;

    public PembayaranDialog(java.awt.Window parent) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
    }

    public static boolean bayar(java.awt.Component asal, Pesanan p) {
        PembayaranDialog d = new PembayaranDialog(Gaya.jendela(asal));
        d.pesanan = p;
        d.lblSub.setText("Pesanan " + p.getNomor() + ", " + Gaya.metode(p.getMetodeBayar()));
        d.lblTotal.setText(Gaya.rupiah(p.getTotalHarga()));
        d.getRootPane().setDefaultButton(d.btnBayar);
        d.pack();
        d.setLocationRelativeTo(asal);
        d.setVisible(true);
        return d.lunas;
    }

    private void prosesBayar() {
        try {
            controller.bayar(pesanan, txtNominal.getText());
            lunas = true;
            dispose();
        } catch (ValidasiException e) {
            Gaya.error(lblErrNominal, e.getPesan("nominal") != null ? e.getPesan("nominal") : e.getMessage());
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLatar = new javax.swing.JPanel();
        pnlIsi = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        pnlTagihan = new javax.swing.JPanel();
        lblTagihanTeks = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblNominal = new javax.swing.JLabel();
        txtNominal = new javax.swing.JTextField();
        lblErrNominal = new javax.swing.JLabel();
        lblPetunjuk = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnNanti = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pembayaran");
        setResizable(false);

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 28, 20, 28));

        pnlIsi.setBackground(new java.awt.Color(255, 255, 255));
        pnlIsi.setOpaque(false);

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Pembayaran");

        lblSub.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSub.setForeground(new java.awt.Color(102, 112, 133));
        lblSub.setText("Pesanan");

        pnlTagihan.setBackground(new java.awt.Color(245, 247, 251));
        pnlTagihan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(14, 16, 14, 16)));

        lblTagihanTeks.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTagihanTeks.setForeground(new java.awt.Color(102, 112, 133));
        lblTagihanTeks.setText("Total tagihan");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(31, 94, 219));
        lblTotal.setText("Rp0");

        javax.swing.GroupLayout pnlTagihanLayout = new javax.swing.GroupLayout(pnlTagihan);
        pnlTagihan.setLayout(pnlTagihanLayout);
        pnlTagihanLayout.setHorizontalGroup(
            pnlTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTagihanTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlTagihanLayout.setVerticalGroup(
            pnlTagihanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTagihanLayout.createSequentialGroup()
                .addComponent(lblTagihanTeks)
                .addGap(4, 4, 4)
                .addComponent(lblTotal))
        );

        lblNominal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNominal.setForeground(new java.awt.Color(52, 64, 84));
        lblNominal.setText("Nominal pembayaran (Rp)");

        txtNominal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtNominal.setForeground(new java.awt.Color(16, 24, 40));
        txtNominal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(208, 213, 221)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        txtNominal.setPreferredSize(new java.awt.Dimension(360, 38));
        txtNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNominalActionPerformed(evt);
            }
        });

        lblErrNominal.setForeground(new java.awt.Color(217, 45, 32));
        lblErrNominal.setText(" ");
        lblErrNominal.setPreferredSize(new java.awt.Dimension(40, 17));

        lblPetunjuk.setForeground(new java.awt.Color(102, 112, 133));
        lblPetunjuk.setText("Masukkan nominal sesuai total tagihan.");

        javax.swing.GroupLayout pnlIsiLayout = new javax.swing.GroupLayout(pnlIsi);
        pnlIsi.setLayout(pnlIsiLayout);
        pnlIsiLayout.setHorizontalGroup(
            pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblSub, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblErrNominal, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPetunjuk, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlIsiLayout.setVerticalGroup(
            pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIsiLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblJudul)
                .addGap(4, 4, 4)
                .addComponent(lblSub)
                .addGap(18, 18, 18)
                .addComponent(pnlTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNominal)
                .addGap(6, 6, 6)
                .addComponent(txtNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblErrNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblPetunjuk))
        );

        pnlTombol.setBackground(new java.awt.Color(255, 255, 255));
        pnlTombol.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 0, 0, 0));
        pnlTombol.setOpaque(false);

        btnNanti.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnNanti.setForeground(new java.awt.Color(16, 24, 40));
        btnNanti.setText("Bayar Nanti");
        btnNanti.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(228, 231, 236)), javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15)));
        btnNanti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNanti.setFocusPainted(false);
        btnNanti.setPreferredSize(new java.awt.Dimension(120, 36));
        btnNanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNantiActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(31, 94, 219));
        btnBayar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Bayar");
        btnBayar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnBayar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBayar.setFocusPainted(false);
        btnBayar.setPreferredSize(new java.awt.Dimension(120, 36));
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTombolLayout = new javax.swing.GroupLayout(pnlTombol);
        pnlTombol.setLayout(pnlTombolLayout);
        pnlTombolLayout.setHorizontalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTombolLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(btnNanti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTombolLayout.setVerticalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNanti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlLatarLayout = new javax.swing.GroupLayout(pnlLatar);
        pnlLatar.setLayout(pnlLatarLayout);
        pnlLatarLayout.setHorizontalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlLatarLayout.setVerticalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatarLayout.createSequentialGroup()
                .addComponent(pnlIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTombol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlLatar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNominalActionPerformed
        prosesBayar();
    }//GEN-LAST:event_txtNominalActionPerformed

    private void btnNantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNantiActionPerformed
        dispose();
    }//GEN-LAST:event_btnNantiActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        prosesBayar();
    }//GEN-LAST:event_btnBayarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnNanti;
    private javax.swing.JLabel lblErrNominal;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblNominal;
    private javax.swing.JLabel lblPetunjuk;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblTagihanTeks;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlIsi;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlTagihan;
    private javax.swing.JPanel pnlTombol;
    private javax.swing.JTextField txtNominal;
    // End of variables declaration//GEN-END:variables
}
