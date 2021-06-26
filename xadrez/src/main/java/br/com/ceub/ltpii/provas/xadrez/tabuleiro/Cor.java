package br.com.ceub.ltpii.provas.xadrez.tabuleiro;

public enum Cor {
  NEUTRA('n'),
  BRANCO('b'),
  PRETO('p');

  private final char id;

  Cor(final char id) {
    this.id = id;
  }

  public char getId() {
    return id;
  }
}
