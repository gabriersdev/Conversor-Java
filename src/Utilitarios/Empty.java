package Utilitarios;

public class Empty {
    public static boolean isEmpty(String string){
        if(string == null || string.length() == 0){
            return true;
        }else{
            return false;
        }
    }
}
