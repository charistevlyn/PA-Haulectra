package controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Pelanggan;
import model.PenggunaDAO;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class PelangganController {

    private final PenggunaDAO dao = new PenggunaDAO();

    public Pelanggan profilSaya() {
        return (Pelanggan) dao.cariId(AuthController.getPenggunaLogin().getId());
    }

    public void ubahProfil(String nama, String username, String telepon, String alamat) {
        Pelanggan p = profilSaya();
        Map<String, String> salah = AuthController.periksaData(nama, username, telepon, alamat, p.getId());
        ValidasiException.cek(salah);
        p.setNama(nama.trim());
        p.setUsername(username.trim());
        p.setNoTelepon(AuthController.normalisasiTelepon(telepon));
        p.setAlamat(alamat.trim());
        dao.ubah(p);
        AuthController.getPenggunaLogin().setNama(p.getNama());  
        AuthController.getPenggunaLogin().setUsername(p.getUsername());
    }

    public List<Pelanggan> daftar(String kataKunci) {
        String k = kataKunci.toLowerCase().trim();
        return dao.semuaPelanggan().stream()
                .filter(p -> p.getNama().toLowerCase().contains(k) || p.getUsername().toLowerCase().contains(k))
                .collect(Collectors.toList());
    }
}
