package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Map;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class JpaUtil {

    private static EntityManagerFactory emf;

    private JpaUtil() { }

    public static synchronized EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("haulPU", Map.of(
                    "jakarta.persistence.jdbc.url", Konfigurasi.URL,
                    "jakarta.persistence.jdbc.user", Konfigurasi.USER,
                    "jakarta.persistence.jdbc.password", Konfigurasi.PASSWORD));
        }
        return emf.createEntityManager();
    }
}
