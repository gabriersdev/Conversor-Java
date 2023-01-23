import Utilitarios.Empty;

import javax.swing.JOptionPane;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] a) {

        Empty empty = new Empty();

        //Criação do array com as opções iniciais de seleção
        String[] opcoes = { "Conversor de moedas", "Conversor de medidas", "Conversor de temperatura"};
        String input = (String) JOptionPane.showInputDialog(null,
                "Selecione a conversão:",
                "Conversor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes, // Array de opções
                opcoes[0] // Opção marcada (selected)
        );

        if(!empty.isEmpty(input)){
            String valor = (String) JOptionPane.showInputDialog(null,
                    "Valor para a conversão",
                    "Conversor",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null);
            System.out.println(valor);
        }

    }
}