package br.com.ceub.ltpii.provas.xadrez.pojo;

public class PecaPojo {

  private int linha;
  private int coluna;
  private char tipoPecao;
  private char cor;

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

  public char getTipoPecao() {
    return tipoPecao;
  }

  public void setTipoPecao(final char tipoPecao) {
    this.tipoPecao = tipoPecao;
  }

  public char getCor() {
    return cor;
  }

  public void setCor(final char cor) {
    this.cor = cor;
  }

  @Override
  public String toString() {
    return "PecaPojo{" +
        "linha=" + linha +
        ", coluna=" + coluna +
        ", tipoPecao=" + tipoPecao +
        ", cor=" + cor +
        '}';
  }
}
