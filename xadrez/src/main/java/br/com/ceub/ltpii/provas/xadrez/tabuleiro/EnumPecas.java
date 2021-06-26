package br.com.ceub.ltpii.provas.xadrez.tabuleiro;

import java.util.Arrays;

public enum EnumPecas {
  PEAO_BRANCO('p', Constants.PEAO, Cor.BRANCO),
  PEAO_PRETO('P', Constants.PEAO, Cor.PRETO),
  BISPO_BRANCO('b', Constants.BISPO, Cor.BRANCO),
  BISPO_PRETO('B', Constants.BISPO, Cor.PRETO),
  CAVALO_BRANCO('c', Constants.CAVALO, Cor.BRANCO),
  CAVALO_PRETO('C', Constants.CAVALO, Cor.PRETO),
  TORRE_BRANCO('t', Constants.TORRE, Cor.BRANCO),
  TORRE_PRETO('T', Constants.TORRE, Cor.PRETO),
  REI_BRANCO('k', Constants.REI, Cor.BRANCO),
  REI_PRETO('K', Constants.REI, Cor.PRETO),
  RAINHA_BRANCO('q', Constants.RAINHA, Cor.BRANCO),
  RAINHA_PRETO('Q', Constants.RAINHA, Cor.PRETO),
  ESPACO_VAZIO(' ', "", Cor.NEUTRA);

  private final char peca;
  private final String nome;
  private final Cor cor;

  EnumPecas(final char peca, final String nome, final Cor cor) {
    this.peca = peca;
    this.nome = nome;
    this.cor = cor;
  }

  public static EnumPecas getEnum(final Cor cor, final String nome) {
    return Arrays.stream(values())
        .filter(enumPecas -> enumPecas.getNome().equals(nome) && enumPecas.getCor().equals(cor))
        .findFirst().orElseThrow();
  }

  public static EnumPecas getEnum(final char peca) {
    return Arrays.stream(values())
        .filter(enumPecas -> enumPecas.getPeca() == peca)
        .findFirst().orElseThrow();
  }

  private String getNome() {
    return nome;
  }

  public char getPeca() {
    return peca;
  }

  public Cor getCor() {
    return cor;
  }

  @Override
  public String toString() {
    return "EnumPecas{" +
        "peca=" + peca +
        ", nome='" + nome + '\'' +
        ", cor=" + cor +
        '}';
  }

  public static class Constants {

    public static final String PEAO = "peao";
    public static final String BISPO = "bispo";
    public static final String CAVALO = "cavalo";
    public static final String TORRE = "torre";
    public static final String REI = "rei";
    public static final String RAINHA = "rainha";
  }
}
