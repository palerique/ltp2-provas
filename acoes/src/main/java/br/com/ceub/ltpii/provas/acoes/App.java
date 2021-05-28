package br.com.ceub.ltpii.provas.acoes;

import br.com.ceub.ltpii.provas.acoes.service.AcaoEstatistica;
import br.com.ceub.ltpii.provas.acoes.service.AcaoService;

public class App {

    public static void main(String[] args) {
        AcaoService acaoService = new AcaoService();
        acaoService.obterAcoes("csv/appl_stock.csv");
        AcaoEstatistica estatisticas = acaoService.obterEstatisticas();
        System.out.println(estatisticas);
    }
}
