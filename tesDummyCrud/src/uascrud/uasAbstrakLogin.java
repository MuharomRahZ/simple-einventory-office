package uascrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public abstract class uasAbstrakLogin {
    protected Connection koneksi;
    protected PreparedStatement psmt;
    protected ResultSet dataUser;
    protected String query,userID,password,pesan;
    
    protected uasAbstrakLogin(){
        try { 
            uasKoneksi connection = new uasKoneksi();
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    protected abstract String getQuery();
    protected abstract void setQuery(String query);

    protected abstract String getUserID();
    protected abstract void setUserID(String userID);

    protected abstract String getPassword();
    protected abstract void setPassword(String password);

    protected abstract String getPesan();
    protected abstract void setPesan(String pesan);
    
    protected abstract String cekLogin(String userID, String password);
    protected abstract void Logout(String userID);
}
