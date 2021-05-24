package br.com.ceub.ltpii.provas.acoes.service;

import br.com.ceub.ltpii.provas.acoes.dominio.Acao;
import java.util.List;

/*
 * https://www.todamateria.com.br/desvio-padrao/
 */
public class AcaoEstatistica {
	private double mediaAbertura;
	private double maxAbertura;
	private double minAbertura;
	private double stdAbertura; // desvio padrão

	private double mediaAlta;
	private double maxAlta;
	private double minAlta;
	private double stdAlta; // desvio padrão

	private double mediaBaixa;
	private double maxBaixa;
	private double minBaixa;
	private double stdBaixa; // desvio padrão

	private double mediaFechamento;
	private double maxFechamento;
	private double minFechamento;
	private double stdFechamento; // desvio padrão

	private double mediaVolume;
	private double maxVolume;
	private double minVolume;
	private double stdVolume; // desvio padrão

	private double mediaAdjClose;
	private double maxAdjClose;
	private double minAdjClose;
	private double stdAdjClose; // desvio padrão

	public double getMediaAbertura() {
		return mediaAbertura;
	}
	public void setMediaAbertura(double mediaAbertura) {
		this.mediaAbertura = mediaAbertura;
	}
	public double getMaxAbertura() {
		return maxAbertura;
	}
	public void setMaxAbertura(double maxAbertura) {
		this.maxAbertura = maxAbertura;
	}
	public double getMinAbertura() {
		return minAbertura;
	}
	public void setMinAbertura(double minAbertura) {
		this.minAbertura = minAbertura;
	}
	public double getStdAbertura() {
		return stdAbertura;
	}
	public void setStdAbertura(double stdAbertura) {
		this.stdAbertura = stdAbertura;
	}
	public double getMediaAlta() {
		return mediaAlta;
	}
	public void setMediaAlta(double mediaAlta) {
		this.mediaAlta = mediaAlta;
	}
	public double getMaxAlta() {
		return maxAlta;
	}
	public void setMaxAlta(double maxAlta) {
		this.maxAlta = maxAlta;
	}
	public double getMinAlta() {
		return minAlta;
	}
	public void setMinAlta(double minAlta) {
		this.minAlta = minAlta;
	}
	public double getStdAlta() {
		return stdAlta;
	}
	public void setStdAlta(double stdAlta) {
		this.stdAlta = stdAlta;
	}
	public double getMediaBaixa() {
		return mediaBaixa;
	}
	public void setMediaBaixa(double mediaBaixa) {
		this.mediaBaixa = mediaBaixa;
	}
	public double getMaxBaixa() {
		return maxBaixa;
	}
	public void setMaxBaixa(double maxBaixa) {
		this.maxBaixa = maxBaixa;
	}
	public double getMinBaixa() {
		return minBaixa;
	}
	public void setMinBaixa(double minBaixa) {
		this.minBaixa = minBaixa;
	}
	public double getStdBaixa() {
		return stdBaixa;
	}
	public void setStdBaixa(double stdBaixa) {
		this.stdBaixa = stdBaixa;
	}
	public double getMediaFechamento() {
		return mediaFechamento;
	}
	public void setMediaFechamento(double mediaFechamento) {
		this.mediaFechamento = mediaFechamento;
	}
	public double getMaxFechamento() {
		return maxFechamento;
	}
	public void setMaxFechamento(double maxFechamento) {
		this.maxFechamento = maxFechamento;
	}
	public double getMinFechamento() {
		return minFechamento;
	}
	public void setMinFechamento(double minFechamento) {
		this.minFechamento = minFechamento;
	}
	public double getStdFechamento() {
		return stdFechamento;
	}
	public void setStdFechamento(double stdFechamento) {
		this.stdFechamento = stdFechamento;
	}
	public double getMediaVolume() {
		return mediaVolume;
	}
	public void setMediaVolume(double mediaVolume) {
		this.mediaVolume = mediaVolume;
	}
	public double getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(double maxVolume) {
		this.maxVolume = maxVolume;
	}
	public double getMinVolume() {
		return minVolume;
	}
	public void setMinVolume(double minVolume) {
		this.minVolume = minVolume;
	}
	public double getStdVolume() {
		return stdVolume;
	}
	public void setStdVolume(double stdVolume) {
		this.stdVolume = stdVolume;
	}
	public double getMediaAdjClose() {
		return mediaAdjClose;
	}
	public void setMediaAdjClose(double mediaAdjClose) {
		this.mediaAdjClose = mediaAdjClose;
	}
	public double getMaxAdjClose() {
		return maxAdjClose;
	}
	public void setMaxAdjClose(double maxAdjClose) {
		this.maxAdjClose = maxAdjClose;
	}
	public double getMinAdjClose() {
		return minAdjClose;
	}
	public void setMinAdjClose(double minAdjClose) {
		this.minAdjClose = minAdjClose;
	}
	public double getStdAdjClose() {
		return stdAdjClose;
	}
	public void setStdAdjClose(double stdAdjClose) {
		this.stdAdjClose = stdAdjClose;
	}

	public AcaoEstatistica calcular(List<Acao> dadosAcoes) {
		return null;
	}
}
