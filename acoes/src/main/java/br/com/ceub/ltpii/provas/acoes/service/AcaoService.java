package br.com.ceub.ltpii.provas.acoes.service;

import br.com.ceub.ltpii.provas.acoes.dominio.Acao;
import java.util.ArrayList;
import java.util.List;

import br.com.ceub.ltpii.provas.acoes.infra.AcaoDAO;

public class AcaoService {
	private List<Acao> dadosAcoes;
	private AcaoEstatistica estatisticas;
	private AcaoDAO acaoDAO;

	public AcaoService() {
		dadosAcoes = new ArrayList<>();
		estatisticas = new AcaoEstatistica();
		acaoDAO = new AcaoDAO();
	}

	public List<Acao> obterAcoes(String nomeArquivo) {
		dadosAcoes = acaoDAO.csv(nomeArquivo);
		return dadosAcoes;
	}

	public AcaoEstatistica obterEstatisticas() {
		this.estatisticas = estatisticas.calcular(dadosAcoes);
		return estatisticas;
	}
}
