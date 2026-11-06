package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class Koneksi {

    public interface KerjaSql<T> {
        T kerjakan(Connection conn) throws SQLException;
    }

    private static Koneksi instance;
    private final BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(Konfigurasi.UKURAN_POOL);

    private Koneksi() { }   

    public static synchronized Koneksi getInstance() {
        if (instance == null) {
            instance = new Koneksi();
        }
        return instance;
    }

    private Connection pinjam() throws SQLException {
        Connection c = pool.poll();
        if (c == null || !c.isValid(2)) {
            try {
                c = DriverManager.getConnection(Konfigurasi.URL, Konfigurasi.USER, Konfigurasi.PASSWORD);
            } catch (SQLException e) {
                throw new SQLException("Tidak dapat terhubung ke database 'haul'. "
                        + "Pastikan MySQL menyala dan database sudah diimpor.", e);
            }
        }
        return c;
    }

    private void kembalikan(Connection c) {
        try {
            c.setAutoCommit(true);
            if (!pool.offer(c)) c.close();
        } catch (SQLException e) {
        }
    }

    public <T> T jalankan(KerjaSql<T> kerja) {
        Connection c = null;
        try {
            c = pinjam();
            return kerja.kerjakan(c);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (c != null) kembalikan(c);
        }
    }

    public <T> T transaksi(KerjaSql<T> kerja) {
        return jalankan(c -> {
            c.setAutoCommit(false);
            try {
                T hasil = kerja.kerjakan(c);
                c.commit();
                return hasil;
            } catch (SQLException | RuntimeException e) {
                c.rollback();
                throw e;
            }
        });
    }
}
