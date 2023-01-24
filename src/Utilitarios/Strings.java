package Utilitarios;

import java.util.ArrayList;

public class Strings {
    public static String tratamentoParam(Object string){
        String stringTratada = String.valueOf(string);
        stringTratada = stringTratada.replaceAll(" ", "-");
        stringTratada = stringTratada.toLowerCase();
        return stringTratada;
    }
}
