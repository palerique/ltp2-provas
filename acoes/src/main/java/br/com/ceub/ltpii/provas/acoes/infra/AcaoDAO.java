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

  private Acao criarAcao(String linhaArquivo) throws ParseException {
    String[] vetor = linhaArquivo.split(CSV_SEPARADOR);
    Acao acao = new Acao();
    acao.setData(SIMPLE_DATE_FORMAT.parse(vetor[0]));
    acao.setAbertura(Double.parseDouble(vetor[1]));
    acao.setAlta(Double.parseDouble(vetor[2]));
    acao.setBaixa(Double.parseDouble(vetor[3]));
    acao.setFechamento(Double.parseDouble(vetor[4]));
    acao.setAdjClose(Double.parseDouble(vetor[5]));
    acao.setVolume(Double.parseDouble(vetor[6]));
    return acao;
  }

  public List<Acao> csv(String nomeArquivo) {
    List<Acao> acoes = new ArrayList<>();
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    try (InputStream is = classloader.getResourceAsStream(nomeArquivo)) {
      try (Scanner sc = new Scanner(Objects.requireNonNull(is))) {
        sc.nextLine(); //Para pular o cabeçalho.
        while (sc.hasNextLine()) {
          String linhaArquivo = sc.nextLine();
          try {
            acoes.add(criarAcao(linhaArquivo));
          } catch (ParseException e) {
            System.err.println("Nao foi possível criar a linha: " + linhaArquivo + "Data invalida");
            e.printStackTrace();
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return acoes;
  }
}
