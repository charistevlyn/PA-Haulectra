package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public abstract class Promo {

    private int id;
    private String kode;
    private BigDecimal diskon;
    private int minimalBarang;
    private LocalDate mulai;
    private LocalDate selesai;
    private int idAdmin;

    public abstract BigDecimal hitungPotongan(BigDecimal subtotal);

    public abstract char getJenis();

    public abstract String getTeksDiskon();

    public static Promo buat(char jenis) {
        return jenis == 'P' ? new Persen() : new Nominal();
    }

    public String getStatus() {
        LocalDate hariIni = LocalDate.now();
        if (hariIni.isBefore(mulai)) return "Terjadwal";
        if (hariIni.isAfter(selesai)) return "Berakhir";
        return "Aktif";
    }

    public String getLabelJenis() { return getJenis() == 'P' ? "Persen (%)" : "Nominal (Rp)"; }

    public static class Persen extends Promo {
        @Override
        public BigDecimal hitungPotongan(BigDecimal subtotal) {
            return subtotal.multiply(getDiskon()).divide(BigDecimal.valueOf(100), 0, RoundingMode.HALF_UP);
        }
        @Override public char getJenis() { return 'P'; }
        @Override public String getTeksDiskon() { return getDiskon().stripTrailingZeros().toPlainString() + "%"; }
    }

    public static class Nominal extends Promo {
        @Override
        public BigDecimal hitungPotongan(BigDecimal subtotal) {
            return getDiskon().min(subtotal);   
        }
        @Override public char getJenis() { return 'N'; }
        @Override public String getTeksDiskon() { return "Rp" + String.format("%,d", getDiskon().longValue()).replace(',', '.'); }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }
    public BigDecimal getDiskon() { return diskon; }
    public void setDiskon(BigDecimal diskon) { this.diskon = diskon; }
    public int getMinimalBarang() { return minimalBarang; }
    public void setMinimalBarang(int minimalBarang) { this.minimalBarang = minimalBarang; }
    public LocalDate getMulai() { return mulai; }
    public void setMulai(LocalDate mulai) { this.mulai = mulai; }
    public LocalDate getSelesai() { return selesai; }
    public void setSelesai(LocalDate selesai) { this.selesai = selesai; }
    public int getIdAdmin() { return idAdmin; }
    public void setIdAdmin(int idAdmin) { this.idAdmin = idAdmin; }
}
