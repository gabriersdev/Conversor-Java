import Conversoes.ConversaoMoedas;
import Modal.Modal;

public class Teste {
    public static void main(String[] args) {
        ConversaoMoedas conversaoMoedas = new ConversaoMoedas();

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
