package br.com.ceub.ltpii.provas.acoes.infra;

import br.com.ceub.ltpii.provas.acoes.dominio.Acao;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AcaoDAO {

  public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
  public static final String CSV_SEPARADOR = ",";

  private Acao criarAcao(final String linhaArquivo) throws ParseException {
    final String[] vetor = linhaArquivo.split(CSV_SEPARADOR);
    final Acao acao = new Acao();
    acao.setData(SIMPLE_DATE_FORMAT.parse(vetor[0]));
    acao.setAbertura(Double.parseDouble(vetor[1]));
    acao.setAlta(Double.parseDouble(vetor[2]));
    acao.setBaixa(Double.parseDouble(vetor[3]));
    acao.setFechamento(Double.parseDouble(vetor[4]));
    acao.setAdjClose(Double.parseDouble(vetor[5]));
    acao.setVolume(Double.parseDouble(vetor[6]));
    return acao;
  }

  public List<Acao> csv(final String nomeArquivo) {
    final List<Acao> acoes = new ArrayList<>();
    final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    try (final InputStream is = classloader.getResourceAsStream(nomeArquivo)) {
      try (final Scanner sc = new Scanner(Objects.requireNonNull(is))) {
        sc.nextLine(); //Para pular o cabeçalho.
        while (sc.hasNextLine()) {
          final String linhaArquivo = sc.nextLine();
          try {
            acoes.add(criarAcao(linhaArquivo));
          } catch (final ParseException e) {
            System.err.println("Nao foi possível criar a linha: " + linhaArquivo + "Data invalida");
            e.printStackTrace();
          }
        }
      }
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return acoes;
  }
}
