/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class KonfirmasiDialog extends javax.swing.JDialog {

    private boolean setuju;

    public KonfirmasiDialog(java.awt.Window parent) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
    }

    public static boolean tanya(java.awt.Component asal, String judul, String pesan, String teksYa,
                                String ikon, boolean bahaya) {
        KonfirmasiDialog d = new KonfirmasiDialog(Gaya.jendela(asal));
        d.isi(judul, pesan, ikon);
        d.btnYa.setText(teksYa);
        d.btnYa.setBackground(bahaya ? Gaya.MERAH : Gaya.BIRU);
        d.tampil(asal);
        return d.setuju;
    }

    public static boolean yaTidak(java.awt.Component asal, String judul, String pesan, String ikon) {
        KonfirmasiDialog d = new KonfirmasiDialog(Gaya.jendela(asal));
        d.isi(judul, pesan, ikon);
        d.btnYa.setText("Ya");
        d.btnBatal.setText("Tidak");
        d.btnYa.setBackground(Gaya.BIRU);
        d.tampil(asal);
        return d.setuju;
    }

    public static void info(java.awt.Component asal, String judul, String pesan) {
        pesan(asal, judul, pesan, "dialog_sukses");
    }

    public static void gagal(java.awt.Component asal, String pesan) {
        pesan(asal, "Tidak dapat diproses", pesan, "dialog_gagal");
    }

    private static void pesan(java.awt.Component asal, String judul, String pesan, String ikon) {
        KonfirmasiDialog d = new KonfirmasiDialog(Gaya.jendela(asal));
        d.isi(judul, pesan, ikon);
        d.btnBatal.setVisible(false);
        d.btnYa.setText("Tutup");
        d.tampil(asal);
    }

    private void isi(String judul, String pesan, String ikon) {
        setTitle(judul);
        lblJudul.setText(judul);
        lblPesan.setText("<html><div width=320>" + pesan + "</div></html>");
        lblIkon.setIcon(Gaya.ikon(ikon));
    }

    private void tampil(java.awt.Component asal) {
        getRootPane().setDefaultButton(btnYa);
        pack();
        setLocationRelativeTo(asal);
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLatar = new javax.swing.JPanel();
        pnlIsi = new javax.swing.JPanel();
        lblIkon = new javax.swing.JLabel();
        lblJudul = new javax.swing.JLabel();
        lblPesan = new javax.swing.JLabel();
        pnlTombol = new javax.swing.JPanel();
        btnBatal = new javax.swing.JButton();
        btnYa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Konfirmasi");
        setResizable(false);

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 20, 24));

        pnlIsi.setBackground(new java.awt.Color(255, 255, 255));
        pnlIsi.setOpaque(false);

        lblIkon.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblIkon.setForeground(new java.awt.Color(16, 24, 40));
        lblIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/dialog_tanya.png"))); // NOI18N

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(16, 24, 40));
        lblJudul.setText("Judul");

        lblPesan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPesan.setForeground(new java.awt.Color(102, 112, 133));
        lblPesan.setText("Pesan");

        javax.swing.GroupLayout pnlIsiLayout = new javax.swing.GroupLayout(pnlIsi);
        pnlIsi.setLayout(pnlIsiLayout);
        pnlIsiLayout.setHorizontalGroup(
            pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIsiLayout.createSequentialGroup()
                .addComponent(lblIkon)
                .addGap(16, 16, 16)
                .addGroup(pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlIsiLayout.setVerticalGroup(
            pnlIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIkon)
            .addGroup(pnlIsiLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblJudul)
                .addGap(6, 6, 6)
                .addComponent(lblPesan))
        );

        pnlTombol.setBackground(new java.awt.Color(255, 255, 255));
        pnlTombol.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 0, 0, 0));
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

        btnYa.setBackground(new java.awt.Color(31, 94, 219));
        btnYa.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnYa.setForeground(new java.awt.Color(255, 255, 255));
        btnYa.setText("Ya");
        btnYa.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
        btnYa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnYa.setFocusPainted(false);
        btnYa.setPreferredSize(new java.awt.Dimension(120, 36));
        btnYa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTombolLayout = new javax.swing.GroupLayout(pnlTombol);
        pnlTombol.setLayout(pnlTombolLayout);
        pnlTombolLayout.setHorizontalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTombolLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnYa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTombolLayout.setVerticalGroup(
            pnlTombolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnYa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        setuju = false;
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnYaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYaActionPerformed
        setuju = true;
        dispose();
    }//GEN-LAST:event_btnYaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnYa;
    private javax.swing.JLabel lblIkon;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlIsi;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlTombol;
    // End of variables declaration//GEN-END:variables
}
