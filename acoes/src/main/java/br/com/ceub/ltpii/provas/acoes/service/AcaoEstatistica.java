package br.com.ceub.ltpii.provas.acoes.service;

import br.com.ceub.ltpii.provas.acoes.dominio.Acao;
import java.util.List;

/*
 * https://www.todamateria.com.br/desvio-padrao/
 */
public class AcaoEstatistica {

  private double somaAbertura;
  private double mediaAbertura;
  private double maxAbertura;
  private double minAbertura;
  private double stdAbertura; // desvio padrão

  private double somaAlta;
  private double mediaAlta;
  private double maxAlta;
  private double minAlta;
  private double stdAlta; // desvio padrão

  private double somaBaixa;
  private double mediaBaixa;
  private double maxBaixa;
  private double minBaixa;
  private double stdBaixa; // desvio padrão

  private double somaFechamento;
  private double mediaFechamento;
  private double maxFechamento;
  private double minFechamento;
  private double stdFechamento; // desvio padrão

  private double somaVolume;
  private double mediaVolume;
  private double maxVolume;
  private double minVolume;
  private double stdVolume; // desvio padrão

  private double somaAdjClose;
  private double mediaAdjClose;
  private double maxAdjClose;
  private double minAdjClose;
  private double stdAdjClose; // desvio padrão

  public AcaoEstatistica calcular(final List<Acao> dadosAcoes) {

    //Loop usando o metodo forEach:
    dadosAcoes.forEach(acao -> {
      setMaxAbertura(Math.max(acao.getAbertura(), getMaxAbertura()));
      setMinAbertura(Math.min(acao.getAbertura(), getMinAbertura()));
      setSomaAbertura(getSomaAbertura() + acao.getAbertura());
      setMaxAdjClose(Math.max(acao.getAdjClose(), getMaxAdjClose()));
      setMinAdjClose(Math.min(acao.getAdjClose(), getMinAdjClose()));
      setSomaAdjClose(getSomaAdjClose() + acao.getAdjClose());
      setMaxAlta(Math.max(acao.getAlta(), getMaxAlta()));
      setMinAlta(Math.min(acao.getAlta(), getMinAlta()));
      setSomaAlta(getSomaAlta() + acao.getAlta());
      setMaxBaixa(Math.max(acao.getBaixa(), getMaxBaixa()));
      setMinBaixa(Math.min(acao.getBaixa(), getMinBaixa()));
      setSomaBaixa(getSomaBaixa() + acao.getBaixa());
      setMaxFechamento(Math.max(acao.getFechamento(), getMaxFechamento()));
      setMinFechamento(Math.min(acao.getFechamento(), getMinFechamento()));
      setSomaFechamento(getSomaFechamento() + acao.getFechamento());
      setMaxVolume(Math.max(acao.getVolume(), getMaxVolume()));
      setMinVolume(Math.min(acao.getVolume(), getMinVolume()));
      setSomaVolume(getSomaVolume() + acao.getVolume());
    });

    //Agora que sabemos o total podemos calcular a media
    setMediaAbertura(getSomaAbertura() / dadosAcoes.size());
    setMediaAdjClose(getSomaAdjClose() / dadosAcoes.size());
    setMediaAlta(getSomaAlta() / dadosAcoes.size());
    setMediaBaixa(getSomaBaixa() / dadosAcoes.size());
    setMediaFechamento(getSomaFechamento() / dadosAcoes.size());
    setMediaVolume(getSomaVolume() / dadosAcoes.size());

    //E com as médias os desvios padrões:
    dadosAcoes.forEach(acao -> {
      setStdAbertura(getStdAbertura() + Math.pow(acao.getAbertura(), 2));
      setStdAdjClose(getStdAdjClose() + Math.pow(acao.getAdjClose(), 2));
      setStdAlta(getStdAlta() + Math.pow(acao.getAlta(), 2));
      setStdBaixa(getStdBaixa() + Math.pow(acao.getBaixa(), 2));
      setStdFechamento(getStdFechamento() + Math.pow(acao.getFechamento(), 2));
      setStdVolume(getStdVolume() + Math.pow(acao.getVolume(), 2));
    });

    setStdAbertura(Math.sqrt(getStdAbertura() / dadosAcoes.size()));
    setStdAdjClose(Math.sqrt(getStdAdjClose() / dadosAcoes.size()));
    setStdAlta(Math.sqrt(getStdAlta() / dadosAcoes.size()));
    setStdBaixa(Math.sqrt(getStdBaixa() / dadosAcoes.size()));
    setStdFechamento(Math.sqrt(getStdFechamento() / dadosAcoes.size()));
    setStdVolume(Math.sqrt(getStdVolume() / dadosAcoes.size()));

    return this;
  }

  public double getSomaAbertura() {
    return somaAbertura;
  }

  public void setSomaAbertura(final double somaAbertura) {
    this.somaAbertura = somaAbertura;
  }

  public double getMediaAbertura() {
    return mediaAbertura;
  }

  public void setMediaAbertura(final double mediaAbertura) {
    this.mediaAbertura = mediaAbertura;
  }

  public double getMaxAbertura() {
    return maxAbertura;
  }

  public void setMaxAbertura(final double maxAbertura) {
    this.maxAbertura = maxAbertura;
  }

  public double getMinAbertura() {
    return minAbertura;
  }

  public void setMinAbertura(final double minAbertura) {
    this.minAbertura = minAbertura;
  }

  public double getStdAbertura() {
    return stdAbertura;
  }

  public void setStdAbertura(final double stdAbertura) {
    this.stdAbertura = stdAbertura;
  }

  public double getSomaAlta() {
    return somaAlta;
  }

  public void setSomaAlta(final double somaAlta) {
    this.somaAlta = somaAlta;
  }

  public double getMediaAlta() {
    return mediaAlta;
  }

  public void setMediaAlta(final double mediaAlta) {
    this.mediaAlta = mediaAlta;
  }

  public double getMaxAlta() {
    return maxAlta;
  }

  public void setMaxAlta(final double maxAlta) {
    this.maxAlta = maxAlta;
  }

  public double getMinAlta() {
    return minAlta;
  }

  public void setMinAlta(final double minAlta) {
    this.minAlta = minAlta;
  }

  public double getStdAlta() {
    return stdAlta;
  }

  public void setStdAlta(final double stdAlta) {
    this.stdAlta = stdAlta;
  }

  public double getSomaBaixa() {
    return somaBaixa;
  }

  public void setSomaBaixa(final double somaBaixa) {
    this.somaBaixa = somaBaixa;
  }

  public double getMediaBaixa() {
    return mediaBaixa;
  }

  public void setMediaBaixa(final double mediaBaixa) {
    this.mediaBaixa = mediaBaixa;
  }

  public double getMaxBaixa() {
    return maxBaixa;
  }

  public void setMaxBaixa(final double maxBaixa) {
    this.maxBaixa = maxBaixa;
  }

  public double getMinBaixa() {
    return minBaixa;
  }

  public void setMinBaixa(final double minBaixa) {
    this.minBaixa = minBaixa;
  }

  public double getStdBaixa() {
    return stdBaixa;
  }

  public void setStdBaixa(final double stdBaixa) {
    this.stdBaixa = stdBaixa;
  }

  public double getSomaFechamento() {
    return somaFechamento;
  }

  public void setSomaFechamento(final double somaFechamento) {
    this.somaFechamento = somaFechamento;
  }

  public double getMediaFechamento() {
    return mediaFechamento;
  }

  public void setMediaFechamento(final double mediaFechamento) {
    this.mediaFechamento = mediaFechamento;
  }

  public double getMaxFechamento() {
    return maxFechamento;
  }

  public void setMaxFechamento(final double maxFechamento) {
    this.maxFechamento = maxFechamento;
  }

  public double getMinFechamento() {
    return minFechamento;
  }

  public void setMinFechamento(final double minFechamento) {
    this.minFechamento = minFechamento;
  }

  public double getStdFechamento() {
    return stdFechamento;
  }

  public void setStdFechamento(final double stdFechamento) {
    this.stdFechamento = stdFechamento;
  }

  public double getSomaVolume() {
    return somaVolume;
  }

  public void setSomaVolume(final double somaVolume) {
    this.somaVolume = somaVolume;
  }

  public double getMediaVolume() {
    return mediaVolume;
  }

  public void setMediaVolume(final double mediaVolume) {
    this.mediaVolume = mediaVolume;
  }

  public double getMaxVolume() {
    return maxVolume;
  }

  public void setMaxVolume(final double maxVolume) {
    this.maxVolume = maxVolume;
  }

  public double getMinVolume() {
    return minVolume;
  }

  public void setMinVolume(final double minVolume) {
    this.minVolume = minVolume;
  }

  public double getStdVolume() {
    return stdVolume;
  }

  public void setStdVolume(final double stdVolume) {
    this.stdVolume = stdVolume;
  }

  public double getSomaAdjClose() {
    return somaAdjClose;
  }

  public void setSomaAdjClose(final double somaAdjClose) {
    this.somaAdjClose = somaAdjClose;
  }

  public double getMediaAdjClose() {
    return mediaAdjClose;
  }

  public void setMediaAdjClose(final double mediaAdjClose) {
    this.mediaAdjClose = mediaAdjClose;
  }

  public double getMaxAdjClose() {
    return maxAdjClose;
  }

  public void setMaxAdjClose(final double maxAdjClose) {
    this.maxAdjClose = maxAdjClose;
  }

  public double getMinAdjClose() {
    return minAdjClose;
  }

  public void setMinAdjClose(final double minAdjClose) {
    this.minAdjClose = minAdjClose;
  }

  public double getStdAdjClose() {
    return stdAdjClose;
  }

  public void setStdAdjClose(final double stdAdjClose) {
    this.stdAdjClose = stdAdjClose;
  }

  @Override
  public String toString() {
    return "AcaoEstatistica{" +
        "somaAbertura=" + somaAbertura +
        ", mediaAbertura=" + mediaAbertura +
        ", maxAbertura=" + maxAbertura +
        ", minAbertura=" + minAbertura +
        ", stdAbertura=" + stdAbertura +
        ", somaAlta=" + somaAlta +
        ", mediaAlta=" + mediaAlta +
        ", maxAlta=" + maxAlta +
        ", minAlta=" + minAlta +
        ", stdAlta=" + stdAlta +
        ", somaBaixa=" + somaBaixa +
        ", mediaBaixa=" + mediaBaixa +
        ", maxBaixa=" + maxBaixa +
        ", minBaixa=" + minBaixa +
        ", stdBaixa=" + stdBaixa +
        ", somaFechamento=" + somaFechamento +
        ", mediaFechamento=" + mediaFechamento +
        ", maxFechamento=" + maxFechamento +
        ", minFechamento=" + minFechamento +
        ", stdFechamento=" + stdFechamento +
        ", somaVolume=" + somaVolume +
        ", mediaVolume=" + mediaVolume +
        ", maxVolume=" + maxVolume +
        ", minVolume=" + minVolume +
        ", stdVolume=" + stdVolume +
        ", somaAdjClose=" + somaAdjClose +
        ", mediaAdjClose=" + mediaAdjClose +
        ", maxAdjClose=" + maxAdjClose +
        ", minAdjClose=" + minAdjClose +
        ", stdAdjClose=" + stdAdjClose +
        '}';
  }
}
