package Conversoes;

import java.math.BigDecimal;

public interface Conversao {
    public BigDecimal converter(String x, String y);

    public BigDecimal calculoConversao(BigDecimal x);

}
