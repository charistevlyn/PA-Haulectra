package model;

import java.util.List;

/**
 * 
 * @author WINDOWS 11 PRO
 */
public interface DAO<T> {

    List<T> semua();          

    T cariId(int id);        

    void simpan(T data);     

    void ubah(T data);       

    void hapus(int id);      
}
