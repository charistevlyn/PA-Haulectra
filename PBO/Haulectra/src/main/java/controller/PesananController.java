package controller;

import config.Konfigurasi;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import model.Pelanggan;
import model.Pesanan;
import model.PesananDAO;
import model.Produk;
import model.Promo;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class PesananController {

    private static Pesanan keranjang;   
    private final PesananDAO dao = new PesananDAO();
    private final ProdukController produkController = new ProdukController();

    public Pesanan getKeranjang() {
        Pelanggan login = (Pelanggan) AuthController.getPenggunaLogin();
        if (keranjang == null || keranjang.getPelanggan().getId() != login.getId()) {
            keranjang = new Pesanan(login);
        }
        return keranjang;
    }

    public int tambahKeKeranjang(int idProduk, int jumlah) {
        Produk terbaru = produkController.cariId(idProduk);
        if (terbaru == null) return 0;
        return getKeranjang().tambahItem(terbaru, jumlah);
    }

    public int jumlahDiKeranjang(int idProduk) {
        return getKeranjang().getItems().stream()
                .filter(i -> i.getProduk().getId() == idProduk)
                .mapToInt(Pesanan.Item::getJumlah).sum();
    }

    public void ubahJumlah(int idProduk, int jumlah) {
        getKeranjang().ubahJumlah(idProduk, jumlah);
    }

    public void hapusDariKeranjang(int idProduk) {
        getKeranjang().hapusItem(idProduk);
    }

    public List<Promo> voucherTersedia() {
        return new PromoController().promoAktif();
    }

    public void pakaiVoucher(Promo promo) {
        getKeranjang().setPromo(null);
        if (promo != null) {
            getKeranjang().setPromo(new PromoController().cekVoucher(promo.getKode(),
                    getKeranjang().getJumlahBarang()));
        }
    }

    public Pesanan checkout(String metodeBayar) {
        Pesanan p = getKeranjang();
        if (p.getItems().isEmpty()) throw new ValidasiException("Keranjang masih kosong.");
        if (metodeBayar == null) throw new ValidasiException("Pilih metode pembayaran.");
        p.setMetodeBayar(metodeBayar);
        p.setTotalHarga(p.hitungTotal(Konfigurasi.ONGKOS_KIRIM));
        p.setTanggal(LocalDateTime.now());
        jalankan(() -> dao.simpan(p));
        keranjang = null;   
        return p;
    }

    public void bayar(Pesanan p, String nominal) {
        BigDecimal nilai = ProdukController.angka(nominal);
        if (nilai == null || nilai.signum() <= 0) {
            throw new ValidasiException("Nominal tidak valid", Map.of("nominal", "Masukkan nominal berupa angka."));
        }
        try {
            p.bayar(nilai);
        } catch (IllegalStateException e) {
            throw new ValidasiException(e.getMessage(), Map.of("nominal", e.getMessage()));
        }
        dao.ubah(p);
    }

    public List<Pesanan> riwayat(String kataKunci, Pesanan.Tahap filter) {
        int idSaya = AuthController.getPenggunaLogin().getId();
        return cari(kataKunci, filter).stream()
                .filter(p -> p.getPelanggan().getId() == idSaya)
                .collect(Collectors.toList());
    }

    public void batalkan(Pesanan p) {
        if (p.getTahap() == Pesanan.Tahap.DIBATALKAN) throw new ValidasiException("Pesanan ini sudah dibatalkan.");
        if (!p.bisaDibatalkan()) throw new ValidasiException("Pesanan yang sudah dibayar tidak dapat dibatalkan.");
        jalankan(() -> {
            dao.batalkan(p.getId());
            p.batalkan();
        });
    }

    public void konfirmasiDiterima(Pesanan p) {
        jalankan(p::konfirmasiDiterima);
        dao.ubah(p);
    }

    public Pesanan muatUlang(int id) {
        return dao.cariId(id);
    }

    public List<Pesanan> cari(String kataKunci, Pesanan.Tahap filter) {
        String k = kataKunci.toLowerCase().trim();
        return dao.semua().stream()
                .filter(p -> filter == null || p.getTahap() == filter)
                .filter(p -> p.getNomor().toLowerCase().contains(k)
                        || p.getPelanggan().getNama().toLowerCase().contains(k)
                        || (p.getNomorResi() != null && p.getNomorResi().toLowerCase().contains(k)))
                .collect(Collectors.toList());
    }

    public void kirim(Pesanan p) {
        String resi;
        do {
            resi = buatResi(p);
        } while (dao.resiDipakai(resi, p.getId()));
        String resiFinal = resi;
        jalankan(() -> p.kirim(resiFinal, LocalDate.now().plusDays(Konfigurasi.ESTIMASI_KIRIM_HARI)));
        dao.ubah(p);
    }

    private String buatResi(Pesanan p) {
        return "HAUL" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)
                + String.format("%05d", p.getId()) + "-"
                + String.format("%05d", ThreadLocalRandom.current().nextInt(100000));
    }

    private void jalankan(Runnable aksi) {
        try {
            aksi.run();
        } catch (IllegalStateException e) {
            throw new ValidasiException(e.getMessage());
        }
    }
}
