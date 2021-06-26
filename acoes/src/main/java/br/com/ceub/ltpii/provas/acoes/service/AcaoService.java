package br.com.ceub.ltpii.provas.acoes.service;

import br.com.ceub.ltpii.provas.acoes.dominio.Acao;
import br.com.ceub.ltpii.provas.acoes.infra.AcaoDAO;
import java.util.ArrayList;
import java.util.List;

public class AcaoService {

  private final AcaoDAO acaoDAO;
  private List<Acao> dadosAcoes;
  private AcaoEstatistica estatisticas;

  public AcaoService() {
    dadosAcoes = new ArrayList<>();
    estatisticas = new AcaoEstatistica();
    acaoDAO = new AcaoDAO();
  }

  public List<Acao> obterAcoes(final String nomeArquivo) {
    dadosAcoes = acaoDAO.csv(nomeArquivo);
    return dadosAcoes;
  }

  public AcaoEstatistica obterEstatisticas() {
    estatisticas = estatisticas.calcular(dadosAcoes);
    return estatisticas;
  }
}
