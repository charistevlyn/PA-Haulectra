package config;

import java.math.BigDecimal;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class Konfigurasi {

    public static final String URL = "jdbc:mysql://localhost:3306/haul?serverTimezone=Asia/Makassar&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static final int UKURAN_POOL = 5;

    public static final boolean PRODUK_PAKAI_JPA = false;

    public static final String[] KATEGORI = {"Elektronik", "Aksesoris", "Penyimpanan", "Komponen Komputer"};

    public static final BigDecimal ONGKOS_KIRIM = new BigDecimal("20000");
    public static final int BATAS_BAYAR_JAM = 24;
    public static final int ESTIMASI_KIRIM_HARI = 3;            // estimasi tiba setelah dikirim
    public static final int UKURAN_GAMBAR_MAKS = 2 * 1024 * 1024;  // 2 MB (kolom MEDIUMBLOB)
}
