package Conversoes;

import Excecoes.ConversaoException;
import Modal.Modal;
import Utilitarios.Strings;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Gabriel Ribeiro
 * @since 2023
 * @version 1.0
 */
public class ConversorMedidas {

    private String[] array = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
    private ArrayList<String> medidas = new ArrayList<>();
    private BigDecimal valorInicial;

    public ConversorMedidas() {
        Collections.addAll(this.medidas, array);
    }

    public String[] opcaoParaConverter(String opcao) {
        String[] medidas = new String[2];

        switch (opcao) {
            case "Quilômetros para Metros":
                medidas[0] = ("km");
                medidas[1] = ("m");
                break;

            case "Quilômetros para Centímetros":
                medidas[0] = ("km");
                medidas[1] = ("cm");
                break;

            case "Metros para Quilômetros":
                medidas[0] = ("m");
                medidas[1] = ("km");
                break;

            case "Metros para Centímetros":
                medidas[0] = ("m");
                medidas[1] = ("cm");
                break;

            case "Centímetros para Quilômetros":
                medidas[0] = ("cm");
                medidas[1] = ("km");
                break;

            case "Centímetros para Metros":
                medidas[0] = ("cm");
                medidas[1] = ("m");
                break;

            default:
                Modal.messageError("Nenhuma opção foi selecionada");
                break;
        }

        return medidas;
    }

    public String converter(BigDecimal valor, String opcao) {

        this.valorInicial = valor;

        String[] medidasConversao = this.opcaoParaConverter(opcao);

        String medidaEntrada = Strings.tratamentoParam(medidasConversao[0]);
        String medidaSaida = Strings.tratamentoParam(medidasConversao[1]);

        if (!this.medidas.contains(medidaSaida) && !this.medidas.contains(medidaSaida)) {
            throw new ConversaoException("Medida informada não existe");
        }

        return this.calculoConversao(this.medidas.indexOf(medidaEntrada), this.medidas.indexOf(medidaSaida)) + " " + medidaSaida;
    }


    public BigDecimal calculoConversao(int posicaoMedidaEntrada, int posicaoMedidaSaida) {

        BigDecimal resultado;
        int diferenca;

        if (posicaoMedidaEntrada > posicaoMedidaSaida) {
            diferenca = posicaoMedidaEntrada - posicaoMedidaSaida;
            double fator = Math.pow(10, diferenca);
            resultado = this.valorInicial.divide(new BigDecimal(fator));
        } else {
            diferenca = posicaoMedidaSaida - posicaoMedidaEntrada;
            double fator = Math.pow(10, diferenca);
            resultado = this.valorInicial.multiply(new BigDecimal(fator));
        }

        return resultado;
    }
}
