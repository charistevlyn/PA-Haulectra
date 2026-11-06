package model;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public abstract class Pengguna {

    private int id;
    private String nama;
    private String username;
    private String password;

    protected Pengguna(int id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public abstract String getPeran();

    public abstract String getKeterangan();

    public boolean cocokPassword(String input) {
        return password.equals(input);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    String getPassword() { return password; }
}
