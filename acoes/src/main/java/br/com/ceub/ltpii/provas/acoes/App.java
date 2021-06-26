package br.com.ceub.ltpii.provas.acoes;

import br.com.ceub.ltpii.provas.acoes.service.AcaoEstatistica;
import br.com.ceub.ltpii.provas.acoes.service.AcaoService;

public class App {

  public static void main(final String[] args) {
    final AcaoService acaoService = new AcaoService();
    acaoService.obterAcoes("csv/appl_stock.csv");
    final AcaoEstatistica estatisticas = acaoService.obterEstatisticas();
    System.out.println(estatisticas);
  }
}
