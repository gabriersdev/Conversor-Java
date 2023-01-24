import Utilitarios.Empty;

import java.math.BigDecimal;

import javax.swing.text.StyledEditorKit.BoldAction;

import Conversoes.ConversaoMoedas;
import Conversoes.ConversorMedidas;
import Conversoes.ConversorTemperatura;
import Modal.Modal;

public class Main {
    public static void main(String[] a) {
        
        boolean execucao = true;
        
        while(execucao){
            //Criação do array com as opções iniciais de seleção
            String[] opcoes = { "Conversor de moedas", "Conversor de medidas", "Conversor de temperatura"};
            String input = Modal.opcoesSelecao(opcoes, 0);
            
            Boolean tudoCerto = !Empty.isEmpty(input);
            
            String opcaoSelecionada = "";
            String categoria = "";
            
            if(tudoCerto){
                switch(input){
                    case "Conversor de moedas":
                    categoria = "moedas";
                    String[] opcoesConversaoMoedas = {"De Real para Euro", "De Real para Libra", "De Real para Dólar Americano", "De Real para Yene", "De Real para Dólar Australiano"};
                    opcaoSelecionada = Modal.opcoesSelecao(opcoesConversaoMoedas, 0);
                    break;
                    
                    case "Conversor de medidas":
                    categoria = "medidas";
                    String[] opcoesConversaoMedidas = {"Quilômetros para Metros", "Quilômetros para Centímetros", "Metros para Quilômetros", "Metros para Centímetros", "Centímetros para Quilômetros", "Centímetros para Metros"};
                    opcaoSelecionada = Modal.opcoesSelecao(opcoesConversaoMedidas, 0);
                    break;
                    
                    case "Conversor de temperatura":
                    categoria = "temperatura";
                    String[] opcoesConversaoTemperatura = {"Celsius para Kelvin", "Celsius para Fahrenheit", "Kelvin para Celsius", "Kelvin para Fahrenheit", "Fahrenheit para Celsius", "Fahrenheit para Kelvin"};
                    opcaoSelecionada = Modal.opcoesSelecao(opcoesConversaoTemperatura, 0);
                    break;
                }                
            }
            
            if(!Empty.isEmpty(opcaoSelecionada) && !Empty.isEmpty(categoria)){
                
                Boolean valorInformado = false;

                while(!valorInformado){
                    String valor = Modal.caixaDeEntrada("Insira um valor");
                    valor = valor.replaceAll(",", "");
                    
                    System.out.println(opcaoSelecionada);
                    System.out.println(categoria);
                    
                    if(!Empty.isEmpty(valor)){
                        
                        //Verificar de onde veio a conversao e pra que deve ser convertido o valor inserido 
                        try{
                            BigDecimal novoValor = new BigDecimal(valor);
    
                            switch(categoria){
                                case "moedas":
                                ConversaoMoedas conversaoMoedas = new ConversaoMoedas();
                                Modal.mensagem("O valor da conversão é " + conversaoMoedas.converter(novoValor, opcaoSelecionada));
                                break;

                                case "medidas":
                                ConversorMedidas conversorMedidas = new ConversorMedidas();
                                Modal.mensagem("O valor da conversão é " + conversorMedidas.converter(novoValor, opcaoSelecionada));
                                break;
                                
                                case "temperatura":
                                ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
                                Modal.mensagem("O valor da conversão é " + conversorTemperatura.converter(novoValor, opcaoSelecionada));
                                break;
                            }

                            valorInformado = true;
    
                        }catch(NumberFormatException excecao) {
                            Modal.messageError("Conversor", "O valor informado é inválido");
                            valorInformado = false;
                        }
                        
                    }else{
                        Modal.messageError("Conversor", "Informe um valor!");
                        valorInformado = false;
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