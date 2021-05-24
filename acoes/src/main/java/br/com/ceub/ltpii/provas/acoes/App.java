package br.com.ceub.ltpii.provas.acoes;

import br.com.ceub.ltpii.provas.acoes.dominio.Acao;
import br.com.ceub.ltpii.provas.acoes.service.AcaoService;
import java.util.List;

public class App {

    public static void main(String[] args) {
        AcaoService acaoService = new AcaoService();
        List<Acao> acoes = acaoService
                .obterAcoes("/Users/ricardojosemenezesmaia/eclipse-workspace/AcoesBolsaValores/csv/appl_stock.csv");
        for (Acao acao : acoes) {
            System.out.println("Abertura " + acao.getAbertura() + " Fechamento " + acao.getFechamento());
        }
    }
}
