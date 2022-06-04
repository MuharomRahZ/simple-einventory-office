package uascrud;
public class uasMain {
    public static void main(String[] args){
        try{
//            uasFormMainMenu form = new uasFormMainMenu();
            uasFormLogin form = new uasFormLogin();
            form.setVisible(true);
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
