package Utilitarios;

/**
 * @author Gabriel Ribeiro
 * @version 1.0
 * @since 2023
 */
public class Strings {
    public static String tratamentoParam(Object string) {
        String stringTratada = String.valueOf(string);
        stringTratada = stringTratada.replaceAll(" ", "-");
        stringTratada = stringTratada.toLowerCase();
        return stringTratada;
    }
}
