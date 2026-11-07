/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class NotifikasiDialog extends javax.swing.JDialog {

    public NotifikasiDialog(java.awt.Window parent) {
        super(parent, java.awt.Dialog.ModalityType.MODELESS);
        initComponents();
    }

    public static void tampil(java.awt.Component asal, String pesan, String detail) {
        tampil(asal, pesan, detail, true);
    }

    public static void tampil(java.awt.Component asal, String pesan, String detail, boolean berhasil) {
        java.awt.Window w = Gaya.jendela(asal);
        NotifikasiDialog d = new NotifikasiDialog(w);
        d.lblPesan.setText(pesan);
        d.lblDetail.setText(detail);
        d.lblDetail.setVisible(detail != null && !detail.isBlank());
        if (!berhasil) {
            d.lblIkon.setIcon(Gaya.ikon("notif_info"));
            d.pnlLatar.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 215, 254)),
                    javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 22)));
        }
        d.pack();
        if (w != null) {
            d.setLocation(w.getX() + (w.getWidth() - d.getWidth()) / 2, w.getY() + 80);
        }
        d.setVisible(true);
        javax.swing.Timer t = new javax.swing.Timer(2200, e -> d.dispose());
        t.setRepeats(false);
        t.start();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLatar = new javax.swing.JPanel();
        lblIkon = new javax.swing.JLabel();
        pnlTeks = new javax.swing.JPanel();
        lblPesan = new javax.swing.JLabel();
        lblDetail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusableWindowState(false);
        setUndecorated(true);

        pnlLatar.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(183, 223, 201)), javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 22)));

        lblIkon.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblIkon.setForeground(new java.awt.Color(16, 24, 40));
        lblIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/ikon/notif_sukses.png"))); // NOI18N

        pnlTeks.setBackground(new java.awt.Color(255, 255, 255));
        pnlTeks.setOpaque(false);

        lblPesan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPesan.setForeground(new java.awt.Color(16, 24, 40));
        lblPesan.setText("Barang dimasukkan ke keranjang");

        lblDetail.setForeground(new java.awt.Color(102, 112, 133));
        lblDetail.setText("Detail");

        javax.swing.GroupLayout pnlTeksLayout = new javax.swing.GroupLayout(pnlTeks);
        pnlTeks.setLayout(pnlTeksLayout);
        pnlTeksLayout.setHorizontalGroup(
            pnlTeksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
            .addComponent(lblPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlTeksLayout.setVerticalGroup(
            pnlTeksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTeksLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblPesan)
                .addGap(2, 2, 2)
                .addComponent(lblDetail))
        );

        javax.swing.GroupLayout pnlLatarLayout = new javax.swing.GroupLayout(pnlLatar);
        pnlLatar.setLayout(pnlLatarLayout);
        pnlLatarLayout.setHorizontalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLatarLayout.createSequentialGroup()
                .addComponent(lblIkon)
                .addGap(12, 12, 12)
                .addComponent(pnlTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLatarLayout.setVerticalGroup(
            pnlLatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIkon, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(pnlLatar, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblIkon;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JPanel pnlLatar;
    private javax.swing.JPanel pnlTeks;
    // End of variables declaration//GEN-END:variables
}
