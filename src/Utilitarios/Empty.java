package Utilitarios;

public class Empty {
    public static boolean isEmpty(String string){
        return (string == null || string.length() == 0);
    }

    public static boolean isClear(String string){
        return (string.length() == 0);
    }

    public static boolean isNull(String string){
        return (string == null);
    }
}
