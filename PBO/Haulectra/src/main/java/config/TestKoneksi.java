package config;

import model.ProdukDAOJdbc;
import model.ProdukDAOJpa;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class TestKoneksi {

    public static void main(String[] args) {
        System.out.println("Singleton sama? " + (Koneksi.getInstance() == Koneksi.getInstance()));
        System.out.println("JDBC - jumlah produk: " + new ProdukDAOJdbc().semua().size());
        System.out.println("JPA  - jumlah produk: " + new ProdukDAOJpa().semua().size());
        System.exit(0);
    }
}
