import Utilitarios.Empty;
import java.math.BigDecimal;
import java.util.List;
import Modal.Modal;

public class Main {
    public static void main(String[] a) {
        
        boolean execucao = true;
        
        while(execucao){
            //Criação do array com as opções iniciais de seleção
            String[] opcoes = { "Conversor de moedas", "Conversor de medidas", "Conversor de temperatura"};
            String input = Modal.opcoesSelecao(opcoes, 0);
            
            boolean ConversaoSelecionada = !Empty.isEmpty(input);
            
            String opcaoSelecionada = "";
            String categoria = "";
            Funcao funcao = new Funcao();
            
            if(ConversaoSelecionada){
                List<String> retorno = funcao.exibirOpcoesConversao(input);
                opcaoSelecionada = retorno.get(0);
                categoria = retorno.get(1);
            }
            
            if(!Empty.isEmpty(opcaoSelecionada) && !Empty.isEmpty(categoria)){
                
                boolean valorInformado = false;
                
                while(!valorInformado){
                    String valor = Modal.caixaDeEntrada("Insira um valor");
                    
                    if(Empty.isNull(valor)){
                        valorInformado = true;
                    }
                    
                    else if (!Empty.isEmpty(valor)){
                        valor = valor.replaceAll(",", ".");
                        
                        //Verificar de onde veio a conversao e pra que deve ser convertido o valor inserido
                        try{
                            BigDecimal novoValor = new BigDecimal(valor);
                            valorInformado = funcao.fazerConversao(novoValor);
                            
                        }catch(NumberFormatException excecao) {
                            Modal.messageError("O valor informado é inválido");
                        }
                    }
                    
                    else{
                        Modal.messageError("Informe um valor!");
                    }
                }
                
            }
            
            int confirmacao = Modal.confirmacao("Deseja continuar? ");
            
            if(confirmacao != 0){
                Modal.mensagem("Programa finalizado");
                execucao = false;
            }
        }
        
    }
}