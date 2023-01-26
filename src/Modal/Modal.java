package Modal;

import javax.swing.JOptionPane;

/**
 * @author Gabriel Ribeiro
 * @version 1.0
 * @since 2023
 */
public class Modal {

    public static void messageError(String mensagem) {
        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Conversor",
                JOptionPane.ERROR_MESSAGE,
                null
        );
    }

    public static String caixaDeEntrada(String mensagem) {
        return
                (String) JOptionPane.showInputDialog(null,
                        mensagem,
                        "Conversor",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null
                );
    }

    public static String opcoesSelecao(String[] opcoes, int posicaoSelecionada) {
        return
                (String) JOptionPane.showInputDialog(null,
                        "Selecione a conversão:",
                        "Conversor",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes, // Array de opções
                        opcoes[posicaoSelecionada] // Opção marcada (selected)
                );
    }


    public static int confirmacao(String mensagem) {
        return JOptionPane.showConfirmDialog(null,
                mensagem,
                "Conversor",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
    }

    public static void mensagem(String mensagem) {
        JOptionPane.showMessageDialog(null,
                mensagem,
                "Conversor",
                JOptionPane.INFORMATION_MESSAGE,
                null
        );
    }

}
