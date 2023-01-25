package Conversoes;

import Modal.Modal;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ConversorTemperatura {
  
  public String converter(BigDecimal valor, String opcao){
    
    Double valorConversao = valor.doubleValue();
    
    String[] medidas = opcao.split(" ");
    String medidaSaida = medidas[medidas.length - 1].toLowerCase();
    Double resultado = 0d;
    
    switch(opcao){
      case "Celsius para Kelvin":
      resultado = this.celsiusParaKelvin(valorConversao);
      break;
      
      case "Celsius para Fahrenheit":
      resultado = this.celsiusParaFahrenheit(valorConversao);
      break;
      
      case "Kelvin para Celsius":
      resultado = this.kelvinParaCelsius(valorConversao);
      break;
      
      case "Kelvin para Fahrenheit":
      resultado = this.kelvinParaFahrenheit(valorConversao);
      break;
      
      case "Fahrenheit para Celsius":
      resultado = this.fahrenheitParaCelsius(valorConversao);
      break;
      
      case "Fahrenheit para Kelvin":
      resultado = this.fahrenheitParaKelvin(valorConversao);
      break;
      
      default:
      Modal.messageError("Nenhuma opção foi selecionada");
      break;
    }
    
    return resultado + "º " + medidaSaida;
  }
  
  private Double kelvinParaCelsius(Double valor){
    return this.formatacao((valor - 273));
  }
  
  private Double kelvinParaFahrenheit(Double valor){
    return this.formatacao(((valor - 273) * 1.8 + 32));
  }
  
  private Double celsiusParaKelvin(Double valor){
    return this.formatacao((valor + 273));
  }
  
  private Double celsiusParaFahrenheit(Double valor){
    return this.formatacao((valor * 1.8 + 32));
  }
  
  private Double fahrenheitParaCelsius(Double valor){
    return this.formatacao(((valor - 32) / 1.8));
  }
  
  private Double fahrenheitParaKelvin(Double valor){
    return this.formatacao(((valor - 32) * 5/9 + 273));
  }
  
  private Double formatacao(Double valor){
    DecimalFormat formato = new DecimalFormat("#.##");
    return Double.valueOf(formato.format((valor)).replaceAll(",", "."));
  }
}
