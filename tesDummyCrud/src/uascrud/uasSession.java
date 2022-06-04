package uascrud;
public class uasSession {
    protected static String UserID, Nama, StatusLogin;

    public static String getUserID() {
        return UserID;
    }

    public static void setUserID(String UserID) {
        uasSession.UserID = UserID;
    }

    public static String getNama() {
        return Nama;
    }

    public static void setNama(String Nama) {
        uasSession.Nama = Nama;
    }

    public static String getStatusLogin() {
        return StatusLogin;
    }

    public static void setStatusLogin(String StatusLogin) {
        uasSession.StatusLogin = StatusLogin;
    }
    
    
}
