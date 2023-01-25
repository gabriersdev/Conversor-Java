import Conversoes.ConversaoMoedas;
import Conversoes.ConversorMedidas;
import Conversoes.ConversorTemperatura;
import Modal.Modal;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Funcao {
    
    private String opcaoSelecionada = "";
    private String categoria = "";
    
    public List<String> exibirOpcoesConversao(String input){
        switch(input){
            case "Conversor de moedas":
            this.categoria = "moedas";
            String[] opcoesConversaoMoedas = {"De Real para Euro", "De Real para Libra", "De Real para Dólar Americano", "De Real para Yene", "De Real para Dólar Australiano"};
            this.opcaoSelecionada = Modal.opcoesSelecao(opcoesConversaoMoedas, 0);
            break;
            
            case "Conversor de medidas":
            this.categoria = "medidas";
            String[] opcoesConversaoMedidas = {"Quilômetros para Metros", "Quilômetros para Centímetros", "Metros para Quilômetros", "Metros para Centímetros", "Centímetros para Quilômetros", "Centímetros para Metros"};
            this.opcaoSelecionada = Modal.opcoesSelecao(opcoesConversaoMedidas, 0);
            break;
            
            case "Conversor de temperatura":
            this.categoria = "temperatura";
            String[] opcoesConversaoTemperatura = {"Celsius para Kelvin", "Celsius para Fahrenheit", "Kelvin para Celsius", "Kelvin para Fahrenheit", "Fahrenheit para Celsius", "Fahrenheit para Kelvin"};
            this.opcaoSelecionada = Modal.opcoesSelecao(opcoesConversaoTemperatura, 0);
            break;
            
            default:
            Modal.messageError("Nenhuma opção foi selecionada");
            break;
        }
        
        List<String> retorno = new ArrayList<>();
        Collections.addAll(retorno, this.opcaoSelecionada, this.categoria);
        
        return retorno;
    }
    
    public boolean fazerConversao(BigDecimal novoValor){
        
        boolean retorno = true;
        
        try{
            switch(this.categoria){
                case "moedas":
                ConversaoMoedas conversaoMoedas = new ConversaoMoedas();
                Modal.mensagem("O valor da conversão é " + conversaoMoedas.converter(novoValor, this.opcaoSelecionada));
                break;
                
                case "medidas":
                ConversorMedidas conversorMedidas = new ConversorMedidas();
                Modal.mensagem("O valor da conversão é " + conversorMedidas.converter(novoValor, this.opcaoSelecionada));
                break;
                
                case "temperatura":
                ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
                Modal.mensagem("O valor da conversão é " + conversorTemperatura.converter(novoValor, this.opcaoSelecionada));
                break;
                
                default:
                Modal.messageError("Nenhuma categoria foi selecionada");
                break;
            }
            
        }catch (Exception e){
            retorno = false;
        }
        
        return retorno;
    }
}
