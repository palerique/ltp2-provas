package br.com.ceub.ltpii.provas.xadrez.pecas;

import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.IPeca;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;

public abstract class Peca implements IPeca {

  private final EnumPecas peca;
  protected Posicao posicao;
  private Cor cor;
  private Tabuleiro tabuleiro;
  private int contagemMovimento;

  public Peca(final Tabuleiro tabuleiro, final Cor cor, final EnumPecas peca) {
    this.tabuleiro = tabuleiro;
    this.cor = cor;
    this.peca = peca;
  }

  public abstract boolean[][] possivelMovimento();

  public boolean possivelMovimento(final Posicao posicao) {
    return possivelMovimento()[posicao.getLinha()][posicao.getColuna()];
  }

  public boolean haAlgumMovimentoPossivel() {
    final boolean[][] mat = possivelMovimento();
    for (final boolean[] booleans : mat) {
      for (int j = 0; j < mat.length; j++) {
        if (booleans[j]) {
          return true;
        }
      }
    }
    return false;
  }

  public int getContagemMovimento() {
    return contagemMovimento;
  }

  public void setContagemMovimento(final int contagemMovimento) {
    this.contagemMovimento = contagemMovimento;
  }

  public void aumentaContagemMovimento() {
    contagemMovimento++;
  }

  public void diminuiContagemMovimento() {
    contagemMovimento--;
  }

  public Posicao getPosicaoXadrez() {
    return Posicao.dePosicao(posicao);
  }

  protected boolean ehPecaOponente(final Posicao posicao) {
    final Peca p = getTabuleiro().peca(posicao);
    return p != null && p.getCor() != cor;
  }

  @Override
  public boolean eliminarPeca(final Peca pecaAlvo) {
    return !equals(pecaAlvo);
  }

  public Posicao getPosicao() {
    return posicao;
  }

  public void setPosicao(final Posicao posicao) {
    this.posicao = posicao;
  }

  public Cor getCor() {
    return cor;
  }

  public void setCor(final Cor cor) {
    this.cor = cor;
  }

  public Tabuleiro getTabuleiro() {
    return tabuleiro;
  }

  public void setTabuleiro(final Tabuleiro tabuleiro) {
    this.tabuleiro = tabuleiro;
  }

  String imprimir(final boolean[][] matrizMovimentosPossiveis) {

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < matrizMovimentosPossiveis.length; i++) {
      sb.append(" \t").append(i);
    }
    sb.append("\n");
    for (int i = 0, matrizMovimentosPossiveisLength = matrizMovimentosPossiveis.length;
        i < matrizMovimentosPossiveisLength; i++) {
      sb.append(i);
      boolean[] possiveis = matrizMovimentosPossiveis[i];
      for (final boolean possivel : possiveis) {
        sb.append("\t").append(possivel ? 'T' : 'F');
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return "Peca{" +
        "posicao=" + posicao +
        ", cor=" + cor +
        ", tabuleiro=" + tabuleiro +
        ", contagemMovimento=" + contagemMovimento +
        ", peca=" + peca +
        '}';
  }

  public EnumPecas getPeca() {
    return peca;
  }
}
