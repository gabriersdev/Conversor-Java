package Conversoes;

import Excecoes.ConversaoException;
import Utilitarios.Strings;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Gabriel Ribeiro
 * @version 1.0
 * @since 2023
 */
public class ConversaoMoedas {

    private BigDecimal valorInicial;
    private BigDecimal cotacaoEuro = new BigDecimal(5.66);
    private BigDecimal cotacaoDolarAmericano = new BigDecimal(5.21);
    private BigDecimal cotacaoLibra = new BigDecimal(6.46);
    private BigDecimal cotacaoYene = new BigDecimal(0.04);
    private BigDecimal cotacaoDolarAustraliano = new BigDecimal(3.63);

    public String converter(BigDecimal valor, String moeda) {

        this.valorInicial = valor;

        moeda = Strings.tratamentoParam(moeda);

        String retorno;

        switch (moeda) {
            case "de-real-para-euro":
                retorno = "€ " + calculoConversao(this.cotacaoEuro);
                break;

            case "de-real-para-libra":
                retorno = "£ " + calculoConversao(this.cotacaoLibra);
                break;

            case "de-real-para-dólar-americano":
                retorno = "US$ " + calculoConversao(this.cotacaoDolarAmericano);
                break;

            case "de-real-para-yene":
                retorno = "¥ " + calculoConversao(this.cotacaoYene);
                break;

            case "de-real-para-dólar-australiano":
                retorno = "AUD " + calculoConversao(this.cotacaoDolarAustraliano);
                break;

            default:
                throw new ConversaoException("A moeda informada não está disponível para conversão");
        }

        return retorno;
    }


    public BigDecimal calculoConversao(BigDecimal cotacao) {
        return this.valorInicial.divide(cotacao, 2, RoundingMode.HALF_UP);
    }

}
