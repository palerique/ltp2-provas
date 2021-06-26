package br.com.ceub.ltpii.provas.xadrez.tabuleiro;

public class Posicao {

  private int linha;
  private int coluna;

  public Posicao(final int linha, final int coluna) {
    this.linha = linha;
    this.coluna = coluna;
  }

  public static Posicao dePosicao(final Posicao posicao) {
    return new Posicao((char) (8 - posicao.getColuna()), 8 - posicao.getLinha());
  }

  public int getLinha() {
    return linha;
  }

  public void setLinha(final int linha) {
    this.linha = linha;
  }

  public int getColuna() {
    return coluna;
  }

  public void setColuna(final int coluna) {
    this.coluna = coluna;
  }

  public void setValores(final int linha, final int coluna) {
    this.linha = linha;
    this.coluna = coluna;
  }

  @Override
  public String toString() {
    return linha + "," + coluna;
  }
}
