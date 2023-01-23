package Modal;

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

}
