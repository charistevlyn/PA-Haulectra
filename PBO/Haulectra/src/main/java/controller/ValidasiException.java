package controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public class ValidasiException extends RuntimeException {

    private final Map<String, String> pesanField;

    public ValidasiException(String pesan) {
        this(pesan, new HashMap<>());
    }

    public ValidasiException(String pesan, Map<String, String> pesanField) {
        super(pesan);
        this.pesanField = pesanField;
    }

    public String getPesan(String field) {
        return pesanField.get(field);
    }

    public static void cek(Map<String, String> pesanField) {
        if (!pesanField.isEmpty()) {
            throw new ValidasiException("Periksa kembali data yang diisi.", pesanField);
        }
    }
}
