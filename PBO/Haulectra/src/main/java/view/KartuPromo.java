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
        java.awt.GridBagConstraints gridBagConstraints;

        lblPotongan = new javax.swing.JLabel();
        lblJenis = new javax.swing.JLabel();
        lblSyarat = new javax.swing.JLabel();
        sepPromo = new javax.swing.JSeparator();
        lblKode = new javax.swing.JLabel();
        lblBerlaku = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(199, 215, 254)), javax.swing.BorderFactory.createEmptyBorder(12, 14, 12, 14)));
        setLayout(new java.awt.GridBagLayout());

        lblPotongan.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblPotongan.setForeground(new java.awt.Color(31, 94, 219));
        lblPotongan.setText("Potongan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        add(lblPotongan, gridBagConstraints);

        lblJenis.setBackground(new java.awt.Color(232, 240, 255));
        lblJenis.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 8, 3, 8));
        lblJenis.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblJenis.setForeground(new java.awt.Color(31, 94, 219));
        lblJenis.setOpaque(true);
        lblJenis.setText("Diskon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(lblJenis, gridBagConstraints);

        lblSyarat.setForeground(new java.awt.Color(102, 112, 133));
        lblSyarat.setText("Syarat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        add(lblSyarat, gridBagConstraints);

        sepPromo.setForeground(new java.awt.Color(228, 231, 236));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        add(sepPromo, gridBagConstraints);

        lblKode.setBackground(new java.awt.Color(232, 240, 255));
        lblKode.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(164, 188, 253)), javax.swing.BorderFactory.createEmptyBorder(3, 10, 3, 10)));
        lblKode.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblKode.setForeground(new java.awt.Color(31, 94, 219));
        lblKode.setOpaque(true);
        lblKode.setText("KODE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(lblKode, gridBagConstraints);

        lblBerlaku.setForeground(new java.awt.Color(102, 112, 133));
        lblBerlaku.setText("s.d. tanggal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(lblBerlaku, gridBagConstraints);
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
