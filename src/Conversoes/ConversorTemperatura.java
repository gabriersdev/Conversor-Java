package Conversoes;

import java.text.DecimalFormat;

public class ConversorTemperatura {

  public double kelvinParaCelsius(double valor){
    return this.formatacao((valor - 273));
  }

  public double kelvinParaFahrenheit(double valor){
    return this.formatacao(((valor - 273) * 1.8 + 32));
  }

  public double celsiusParaKelvin(double valor){
    return this.formatacao((valor + 273));
  }

  public double celsiusParaFahrenheit(double valor){
    return this.formatacao((valor * 1.8 + 32));
  }

  public double fahrenheitParaCelsius(double valor){
    return this.formatacao(((valor - 32) / 1.8));
  }

  public double fahrenheitParaKelvin(double valor){
    return this.formatacao(((valor - 32) * 5/9 + 273));
  }

  private double formatacao(double valor){
    DecimalFormat formato = new DecimalFormat("#.##");
    return Double.valueOf(formato.format((valor)).replaceAll(",", "."));
  }
}
