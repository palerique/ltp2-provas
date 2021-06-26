package br.com.ceub.ltpii.provas.acoes.dominio;

import java.util.Date;

public class Acao {

  private Date data;
  private double abertura;
  private double alta;
  private double baixa;
  private double fechamento;
  private double volume;
  private double adjClose;

  public Date getData() {
    return data;
  }

  public void setData(final Date data) {
    this.data = data;
  }

  public double getAbertura() {
    return abertura;
  }

  public void setAbertura(final double abertura) {
    this.abertura = abertura;
  }

  public double getAlta() {
    return alta;
  }

  public void setAlta(final double alta) {
    this.alta = alta;
  }

  public double getBaixa() {
    return baixa;
  }

  public void setBaixa(final double baixa) {
    this.baixa = baixa;
  }

  public double getFechamento() {
    return fechamento;
  }

  public void setFechamento(final double fechamento) {
    this.fechamento = fechamento;
  }

  public double getVolume() {
    return volume;
  }

  public void setVolume(final double volume) {
    this.volume = volume;
  }

  public double getAdjClose() {
    return adjClose;
  }

  public void setAdjClose(final double adjClose) {
    this.adjClose = adjClose;
  }

  @Override
  public String toString() {
    return "Acao{" +
        "data=" + data +
        ", abertura=" + abertura +
        ", alta=" + alta +
        ", baixa=" + baixa +
        ", fechamento=" + fechamento +
        ", volume=" + volume +
        ", adjClose=" + adjClose +
        '}';
  }
}
