package Conversoes;

import Excecoes.ConversaoException;
import Utilitarios.Strings;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ConversorMedidas{

    private String[] array = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
    public ArrayList<String> medidas = new ArrayList<String>();
    private BigDecimal valorInicial;

    public ConversorMedidas(){
        for(String item : array){
            medidas.add(item);
        }
    }


    public BigDecimal converter(String valor, String medidaEntrada, String medidaSaida){

        this.valorInicial = new BigDecimal(valor);

        medidaEntrada = Strings.tratamentoParam(medidaEntrada);
        medidaSaida = Strings.tratamentoParam(medidaSaida);

        if(!this.medidas.contains(medidaEntrada) && !this.medidas.contains(medidaSaida)){
            throw new ConversaoException("Medida informada não existe");
        }

        return this.calculoConversao(medidas.indexOf(medidaEntrada), medidas.indexOf(medidaSaida));
    }


    public BigDecimal calculoConversao(int posicaoMedidaEntrada, int posicaoMedidaSaida){

        BigDecimal resultado;
        int diferenca;

        if(posicaoMedidaEntrada > posicaoMedidaSaida){
            diferenca = posicaoMedidaEntrada - posicaoMedidaSaida;
            double fator = Math.pow(10, diferenca);
            resultado = this.valorInicial.divide(new BigDecimal(fator));
        }else{
            diferenca = posicaoMedidaSaida - posicaoMedidaEntrada;
            double fator = Math.pow(10, diferenca);
            resultado = this.valorInicial.multiply(new BigDecimal(fator));
        }

        return resultado;
    }
}
