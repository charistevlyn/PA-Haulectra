package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.math.BigDecimal;

/**
 * 
 * @author WINDOWS 11 PRO
 */
@Entity
@Table(name = "produk")
public class Produk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produk")
    private Integer id;

    @Column(name = "nama_produk")
    private String nama;

    @Column(name = "kategori")
    private String kategori;

    @Column(name = "harga")
    private BigDecimal harga;

    @Column(name = "stok")
    private int stok;

    @Transient                
    private byte[] gambar;

    public Produk() { }  

    public Produk(Integer id, String nama, String kategori, BigDecimal harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return id == null ? "" : String.valueOf(id); }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }
    public BigDecimal getHarga() { return harga; }
    public void setHarga(BigDecimal harga) { this.harga = harga; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }
    public byte[] getGambar() { return gambar; }
    public void setGambar(byte[] gambar) { this.gambar = gambar; }
}
