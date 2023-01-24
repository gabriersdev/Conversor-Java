package Conversoes;

import Excecoes.ConversaoException;
import Utilitarios.Strings;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversaoMoedas{

    private BigDecimal valorInicial;
    private BigDecimal cotacaoEuro = new BigDecimal(5.66);
    private BigDecimal cotacaoDolarAmericano = new BigDecimal(5.21);
    private BigDecimal cotacaoLibra = new BigDecimal(6.46);
    private BigDecimal cotacaoYene = new BigDecimal(0.04);
    private BigDecimal cotacaoDolarAustraliano = new BigDecimal(3.63);
    
    public BigDecimal converter(String valor, String moeda){

        this.valorInicial = new BigDecimal(valor);

        moeda = Strings.tratamentoParam(moeda);

        BigDecimal retorno = new BigDecimal(0);

        switch (moeda){
            case "euro":
                retorno = calculoConversao(this.cotacaoEuro);
                break;

            case "libra":
                retorno = calculoConversao(this.cotacaoLibra);
                break;

            case "dolar-americano":
                retorno = calculoConversao(this.cotacaoDolarAmericano);
                break;

            case "yene":
                retorno = calculoConversao(this.cotacaoYene);
                break;

            case "dolar-australiano":
                retorno = calculoConversao(this.cotacaoDolarAustraliano);
                break;

            default:
                throw new ConversaoException("A moeda informada não está disponível para conversão");
        }

        return retorno;
    }


    public BigDecimal calculoConversao(BigDecimal cotacao){
        return this.valorInicial.divide(cotacao, 2, RoundingMode.HALF_UP);
    }

}
