package Modal;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Modal {
    
    public static void messageError(String titulo, String mensagem){
        JOptionPane.showMessageDialog(
        null,
        mensagem,
        titulo,
        JOptionPane.ERROR_MESSAGE,
        null
        );
    }
    
    public static String caixaDeEntrada(String mensagem){
        String valor = (String) JOptionPane.showInputDialog(null,
        mensagem,
        "Conversor",
        JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        null);

        return valor;
    }
    
    public static String opcoesSelecao(String[] opcoes, int posicaoSelecionada){
        String input = (String) JOptionPane.showInputDialog(null,
        "Selecione a conversão:",
        "Conversor",
        JOptionPane.QUESTION_MESSAGE,
        null,
        opcoes, // Array de opções
        opcoes[posicaoSelecionada] // Opção marcada (selected)
        );
        
        return input;
    }
    
    public static int confirmacao(String mensagem){

        int valor = JOptionPane.showConfirmDialog(null, 
        mensagem,
        "Conversor",
        JOptionPane.YES_NO_CANCEL_OPTION, 
        JOptionPane.QUESTION_MESSAGE);

        return valor;
    }

    public static void mensagem(String mensagem){
        JOptionPane.showMessageDialog(null, 
        mensagem, 
        "Conversor", 
        JOptionPane.INFORMATION_MESSAGE,
        null);
    }
    
}
