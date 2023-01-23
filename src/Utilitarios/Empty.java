package Utilitarios;

public class Empty {
    private String string;

    public boolean isEmpty(String string){
        if(string == null || string.length() == 0){
            return true;
        }else{
            return false;
        }
    }
}
