package Excecoes;

/**
 * @author Gabriel Ribeiro
 * @version 1.0
 * @since 2023
 */
public class ConversaoException extends RuntimeException {
    public ConversaoException(String mensagem) {
        super(mensagem);
    }
}