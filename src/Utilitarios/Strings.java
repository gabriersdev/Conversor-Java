package Utilitarios;

public class Strings {
    public static String tratamentoParam(String string){
        string = string.replaceAll(" ", "-");
        string = string.toLowerCase();
        return string;
    }
}
