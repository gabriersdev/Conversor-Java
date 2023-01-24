import Utilitarios.Empty;

import Modal.Modal;

public class Main {
    public static void main(String[] a) {
        
        //Criação do array com as opções iniciais de seleção
        String[] opcoes = { "Conversor de moedas", "Conversor de medidas", "Conversor de temperatura"};
        String input = Modal.opcoesSelecao(opcoes, 0);
        
        if(!Empty.isEmpty(input)){
            // String valor = Modal.caixaDeEntrada("Insira um valor");
            // System.out.println(valor);
        }
        
        String[] opcoesConversaoMoeda = {"De Real para Euro", "De Real para Libra", "De Real para Dólar Americano", "De Real para Yene", "De Real para Dólar Australiano"};
        // Modal.opcoesSelecao(opcoesConversaoMoeda, 2);
        
        // Modal.mensagem("O valor da conversão é 23.05");
        
        boolean execucao = true;

        while(execucao){
            int confirmacao = Modal.confirmacao("Deseja continuar? ");
            if(confirmacao == 0){
                Modal.mensagem("Continuando...");
            }else{
                Modal.mensagem("Programa finalizado");
                execucao = false;
            }
        }

        
    }
}