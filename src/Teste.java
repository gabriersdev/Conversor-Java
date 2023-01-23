import Conversoes.ConversaoMoedas;
import Modal.Modal;

import java.math.BigDecimal;

public class Teste {
    public static void main(String[] args) {
        ConversaoMoedas conversaoMoedas = new ConversaoMoedas();
        BigDecimal valor = new BigDecimal(100);

        System.out.println(conversaoMoedas.converter("100", "dolar-americano"));

        try{
            conversaoMoedas.converter("100", "libra");
        }catch (Exception excecao){
            Modal.messageError("Conversor", excecao.getMessage());
        }

        //System.out.println(Math.pow(10, 6));
        System.out.println(0.001 * 10);

    }
}
