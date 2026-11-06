/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.Promo;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class KartuPromo extends javax.swing.JPanel {

    public KartuPromo(Promo promo) {
        initComponents();
        lblPotongan.setText(promo.getTeksDiskon());
        lblJenis.setText(promo.getJenis() == 'P' ? "Diskon %" : "Potongan Rp");
        lblSyarat.setText("Minimal belanja " + promo.getMinimalBarang() + " barang");
        lblKode.setText(promo.getKode());
        lblBerlaku.setText("Berlaku s.d. " + Gaya.tanggal(promo.getSelesai()));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPotongan = new javax.swing.JLabel();
        lblJenis = new javax.swing.JLabel();
        lblSyarat = new javax.swing.JLabel();
        sepPromo = new javax.swing.JSeparator();
        lblKode = new javax.swing.JLabel();
        lblBerlaku = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(199, 215, 254)), javax.swing.BorderFactory.createEmptyBorder(12, 14, 12, 14)));

        lblPotongan.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblPotongan.setForeground(new java.awt.Color(31, 94, 219));
        lblPotongan.setText("Potongan");

        lblJenis.setBackground(new java.awt.Color(232, 240, 255));
        lblJenis.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblJenis.setForeground(new java.awt.Color(31, 94, 219));
        lblJenis.setText("Diskon");
        lblJenis.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 8, 3, 8));
        lblJenis.setOpaque(true);

        lblSyarat.setForeground(new java.awt.Color(102, 112, 133));
        lblSyarat.setText("Syarat");

        sepPromo.setForeground(new java.awt.Color(228, 231, 236));

        lblKode.setBackground(new java.awt.Color(232, 240, 255));
        lblKode.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(164, 188, 253)), javax.swing.BorderFactory.createEmptyBorder(3, 10, 3, 10)));
        lblKode.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblKode.setForeground(new java.awt.Color(31, 94, 219));
        lblKode.setOpaque(true);
        lblKode.setText("KODE");

        lblBerlaku.setForeground(new java.awt.Color(102, 112, 133));
        lblBerlaku.setText("s.d. tanggal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPotongan, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(lblJenis))
            .addComponent(lblSyarat, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sepPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblKode)
                .addGap(166, 166, 166)
                .addComponent(lblBerlaku))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPotongan)
                    .addComponent(lblJenis))
                .addGap(2, 2, 2)
                .addComponent(lblSyarat)
                .addGap(10, 10, 10)
                .addComponent(sepPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKode)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblBerlaku))))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBerlaku;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblPotongan;
    private javax.swing.JLabel lblSyarat;
    private javax.swing.JSeparator sepPromo;
    // End of variables declaration//GEN-END:variables
}
