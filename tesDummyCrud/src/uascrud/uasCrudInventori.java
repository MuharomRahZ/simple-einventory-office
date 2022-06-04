package uascrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public abstract class uasCrudInventori {
    protected String idBarang, namaBarang, tglMasuk, tglKeluar;
    protected double hargaSatuan, hargaTotal, jumlahBarang;
    protected double barangHadir, barangAway;
    
    protected Connection CRUDkoneksi;
    protected PreparedStatement CRUDpsmt;
    protected Statement CRUDstat;
    protected ResultSet CRUDhasil;
    protected String CRUDquery;
    
    
    
    protected uasCrudInventori(){
        try{
            uasKoneksi connection = new uasKoneksi();
            CRUDkoneksi = connection.getKoneksi();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    protected abstract void setIdBarang(String idBarang);
    protected abstract String getIdBarang();

    protected abstract void setNamaBarang(String namaBarang);
    protected abstract String getNamaBarang();

    protected abstract void setTglMasuk(String tglMasuk);
    protected abstract String getTglMasuk();

    protected abstract void setTglKeluar(String tglKeluar);
    protected abstract String getTglKeluar();
    
    protected abstract void setJumlahBarang(double jumlahBarang);
    protected abstract double getJumlahBarang();

    protected abstract void setHargaSatuan(double hargaSatuan);
    protected abstract double getHargaSatuan();

    protected abstract void setHargaTotal(double jumlahBarang, double hargaSatuan);
    protected abstract double getHargaTotal();

//    protected abstract void setBarangHadir(String barangHadir);
//    protected abstract String getBarangHadir();
//
//    protected abstract void setBarangAway(String barangAway);
//    protected abstract String getBarangAway();
    
    protected abstract void setBarangHadir(double barangHadir);
    protected abstract double getBarangHadir();

    protected abstract void setBarangAway(double jumlahBarang, double barangHadir);
    protected abstract double getBarangAway();

    //String idBarang, String namaBarang, String tglMasuk, String tglKeluar, String hargaSatuan, String jumlahBarang, String hargaTotal, String barangHadir, String barangAway
    protected abstract ResultSet tampilData();
    protected abstract void simpanData(String idBarang, String namaBarang, String tglMasuk, double jumlahBarang, double hargaSatuan, double hargaTotal, double barangHadir, double barangAway, String tglKeluar);
    protected abstract void ubahData(String idBarang, String namaBarang, String tglMasuk, double jumlahBarang, double hargaSatuan, double hargaTotal, double barangHadir, double barangAway, String tglKeluar);
    protected abstract void hapusData(String idBarang);
    protected abstract ResultSet cariData(String key);
    protected abstract ResultSet hitungData();
}
