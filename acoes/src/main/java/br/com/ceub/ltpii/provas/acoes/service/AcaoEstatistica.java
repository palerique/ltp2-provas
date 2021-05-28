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

	public AcaoEstatistica calcular(List<Acao> dadosAcoes) {

		//Loop usando o metodo forEach:
		dadosAcoes.forEach(acao -> {
			this.setMaxAbertura(Math.max(acao.getAbertura(), this.getMaxAbertura()));
			this.setMinAbertura(Math.min(acao.getAbertura(), this.getMinAbertura()));
			this.setSomaAbertura(this.getSomaAbertura() + acao.getAbertura());
			this.setMaxAdjClose(Math.max(acao.getAdjClose(), this.getMaxAdjClose()));
			this.setMinAdjClose(Math.min(acao.getAdjClose(), this.getMinAdjClose()));
			this.setSomaAdjClose(this.getSomaAdjClose() + acao.getAdjClose());
			this.setMaxAlta(Math.max(acao.getAlta(), this.getMaxAlta()));
			this.setMinAlta(Math.min(acao.getAlta(), this.getMinAlta()));
			this.setSomaAlta(this.getSomaAlta() + acao.getAlta());
			this.setMaxBaixa(Math.max(acao.getBaixa(), this.getMaxBaixa()));
			this.setMinBaixa(Math.min(acao.getBaixa(), this.getMinBaixa()));
			this.setSomaBaixa(this.getSomaBaixa() + acao.getBaixa());
			this.setMaxFechamento(Math.max(acao.getFechamento(), this.getMaxFechamento()));
			this.setMinFechamento(Math.min(acao.getFechamento(), this.getMinFechamento()));
			this.setSomaFechamento(this.getSomaFechamento() + acao.getFechamento());
			this.setMaxVolume(Math.max(acao.getVolume(), this.getMaxVolume()));
			this.setMinVolume(Math.min(acao.getVolume(), this.getMinVolume()));
			this.setSomaVolume(this.getSomaVolume() + acao.getVolume());
		});

		//Agora que sabemos o total podemos calcular a media
		this.setMediaAbertura(this.getSomaAbertura() / dadosAcoes.size());
		this.setMediaAdjClose(this.getSomaAdjClose() / dadosAcoes.size());
		this.setMediaAlta(this.getSomaAlta() / dadosAcoes.size());
		this.setMediaBaixa(this.getSomaBaixa() / dadosAcoes.size());
		this.setMediaFechamento(this.getSomaFechamento() / dadosAcoes.size());
		this.setMediaVolume(this.getSomaVolume() / dadosAcoes.size());

		//E com as médias os desvios padrões:
		dadosAcoes.forEach(acao -> {
			this.setStdAbertura(this.getStdAbertura() + Math.pow(acao.getAbertura(), 2));
			this.setStdAdjClose(this.getStdAdjClose() + Math.pow(acao.getAdjClose(), 2));
			this.setStdAlta(this.getStdAlta() + Math.pow(acao.getAlta(), 2));
			this.setStdBaixa(this.getStdBaixa() + Math.pow(acao.getBaixa(), 2));
			this.setStdFechamento(this.getStdFechamento() + Math.pow(acao.getFechamento(), 2));
			this.setStdVolume(this.getStdVolume() + Math.pow(acao.getVolume(), 2));
		});

		this.setStdAbertura(Math.sqrt(this.getStdAbertura() / dadosAcoes.size()));
		this.setStdAdjClose(Math.sqrt(this.getStdAdjClose() / dadosAcoes.size()));
		this.setStdAlta(Math.sqrt(this.getStdAlta() / dadosAcoes.size()));
		this.setStdBaixa(Math.sqrt(this.getStdBaixa() / dadosAcoes.size()));
		this.setStdFechamento(Math.sqrt(this.getStdFechamento() / dadosAcoes.size()));
		this.setStdVolume(Math.sqrt(this.getStdVolume() / dadosAcoes.size()));

		return this;
	}

	public double getSomaAbertura() {
		return somaAbertura;
	}

	public void setSomaAbertura(double somaAbertura) {
		this.somaAbertura = somaAbertura;
	}

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

	public double getSomaAlta() {
		return somaAlta;
	}

	public void setSomaAlta(double somaAlta) {
		this.somaAlta = somaAlta;
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

	public double getSomaBaixa() {
		return somaBaixa;
	}

	public void setSomaBaixa(double somaBaixa) {
		this.somaBaixa = somaBaixa;
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

	public double getSomaFechamento() {
		return somaFechamento;
	}

	public void setSomaFechamento(double somaFechamento) {
		this.somaFechamento = somaFechamento;
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

	public double getSomaVolume() {
		return somaVolume;
	}

	public void setSomaVolume(double somaVolume) {
		this.somaVolume = somaVolume;
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

	public double getSomaAdjClose() {
		return somaAdjClose;
	}

	public void setSomaAdjClose(double somaAdjClose) {
		this.somaAdjClose = somaAdjClose;
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
