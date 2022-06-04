package uascrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class uasLogin extends uasAbstrakLogin{
    protected Connection koneksi;
    protected PreparedStatement psmt;
    protected ResultSet dataUser;
    protected String query,userID,password,pesan;
    
    protected uasLogin(){
        try { 
            uasKoneksi connection = new uasKoneksi();
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    protected String getQuery() {
        return query;
    }

    protected void setQuery(String query) {
        this.query = query;
    }

    protected String getUserID() {
        return userID;
    }

    protected void setUserID(String userID) {
        this.userID = userID;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected String getPesan() {
        return pesan;
    }

    protected void setPesan(String pesan) {
        this.pesan = pesan;
    }
    
    protected String cekLogin(String userID, String password){
         query = "SELECT nama FROM user WHERE id_user=? AND password=md5(?)";
         try{ 
             psmt = koneksi.prepareStatement(query);
             psmt.setString(1, userID);
             psmt.setString(2, password);
             dataUser = psmt.executeQuery();
             
             if (dataUser.next()){
                 uasSession.setUserID(userID) ;
                 uasSession.setNama (dataUser.getString("nama"));
                 uasSession.setStatusLogin("AKTIF");
                 query = "INSERT INTO log_login (id_user) VALUES (?)";
                 try{
                     psmt = koneksi.prepareStatement(query);
                     psmt.setString(1, userID);
                     psmt.executeUpdate();
                     psmt.close();
                 }catch(Exception e){
                     pesan = "Gagal Simpan Log Login";
                 }
             }else{
                 pesan = "Gagal Login";
             }
         }catch(Exception e){
             pesan = "Gagal Login, Query Error";
         }
         return pesan;
    }
    
    protected void Logout(String userID){
        query = "UPDATE log_login SET waktu_logout=CURRENT_TIMESTAMP() WHERE id_user=? ORDER BY id DESC LIMIT 1";
        try{
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.executeUpdate();
            psmt.close();
            
            koneksi.close();
            
            uasSession.setUserID(null);
            uasSession.setNama(null);
            uasSession.setStatusLogin(null);
        }catch(Exception e){
            
        }
    }
}
