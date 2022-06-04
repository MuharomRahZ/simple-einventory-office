package uascrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class uasCrudPersonalia extends uasCrudInventori{
    protected uasCrudPersonalia(){
        try{
            uasKoneksi connection = new uasKoneksi();
            CRUDkoneksi = connection.getKoneksi();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    protected void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    protected String getIdBarang() {
        return idBarang;
    }

    
    protected void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    protected String getNamaBarang() {
        return namaBarang;
    }

    
    protected void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }
    protected String getTglMasuk() {
        return tglMasuk;
    }

    
    protected void setTglKeluar(String tglKeluar) {
        this.tglKeluar = tglKeluar;
    }
    protected String getTglKeluar() {
        return tglKeluar;
    }
    
    
    protected void setJumlahBarang(double jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    protected double getJumlahBarang() {
        return jumlahBarang;
    }

    
    protected void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
    protected double getHargaSatuan() {
        return hargaSatuan;
    }

    
    protected void setHargaTotal(double jumlahBarang, double hargaSatuan) {
//        this.hargaTotal = hargaTotal;
        this.hargaTotal = jumlahBarang * hargaSatuan;
//        this.hargaTotal = 0;
    }
    protected double getHargaTotal() {
        return hargaTotal;
    }

    
    protected void setBarangHadir(double barangHadir) {
        this.barangHadir = barangHadir;
    }
    protected double getBarangHadir() {
        return barangHadir;
    }

    
    protected void setBarangAway(double jumlahBarang, double barangHadir) {
        this.barangAway = jumlahBarang - barangHadir;
    }
    protected double getBarangAway() {
        return barangAway;
    }
    
    
//    protected String cetakTotal(){
//        return getHargaTotal();
//    }
    
    protected ResultSet tampilData() {
        CRUDquery = "select * from personalia";
        try{
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e){
        }
        return CRUDhasil;
    }
    
    protected void simpanData(String idBarang, String namaBarang, String tglMasuk, double jumlahBarang, double hargaSatuan, double hargaTotal, double barangHadir, double barangAway, String tglKeluar) {
        CRUDquery = "insert into personalia values(?,?,?,?,?,?,?,?,?)";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, idBarang);
            CRUDpsmt.setString(2, namaBarang);
            CRUDpsmt.setString(3, tglMasuk);
            CRUDpsmt.setDouble(4, jumlahBarang);
            CRUDpsmt.setDouble(5, hargaSatuan);
            CRUDpsmt.setDouble(6, hargaTotal);
//            CRUDpsmt.setDouble(5, hargaSatuan);
//            CRUDpsmt.setDouble(6, jumlahBarang);
//            CRUDpsmt.setDouble(7, hargaTotal);
            CRUDpsmt.setDouble(7, barangHadir);
            CRUDpsmt.setDouble(8, barangAway);
            CRUDpsmt.setString(9, tglKeluar);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    protected void ubahData(String idBarang, String namaBarang, String tglMasuk, double jumlahBarang, double hargaSatuan, double hargaTotal, double barangHadir, double barangAway, String tglKeluar) {
        CRUDquery = "update personalia set namaBarang=?, tglMasuk=?, jumlahBarang=?, hargaSatuan=?, hargaTotal=?, barangHadir=?, barangAway=?, tglKeluar=? where idBarang=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, namaBarang);
            CRUDpsmt.setString(2, tglMasuk);
            CRUDpsmt.setDouble(3, jumlahBarang);
            CRUDpsmt.setDouble(4, hargaSatuan);
            CRUDpsmt.setDouble(5, hargaTotal);
//            CRUDpsmt.setDouble(5, hargaSatuan);
//            CRUDpsmt.setDouble(6, jumlahBarang);
//            CRUDpsmt.setDouble(7, hargaTotal);
            CRUDpsmt.setDouble(6, barangHadir);
            CRUDpsmt.setDouble(7, barangAway);
            CRUDpsmt.setString(8, tglKeluar);
            CRUDpsmt.setString(9, idBarang);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    protected void hapusData(String idBarang) {
        CRUDquery = "delete from personalia where idBarang=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, idBarang);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    protected ResultSet cariData(String key) {
        CRUDquery = "select * from personalia where idBarang like '%" + key + "%' or namaBarang "+ "like '%" + key + "%'" ;
        try{
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e){
        }
        return CRUDhasil;
    }
    
    protected ResultSet hitungData() {
        CRUDquery = "select count(*) from personalia";
        try{
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e){
        }
        return CRUDhasil;
    }

    
}
