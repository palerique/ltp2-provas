package br.com.ceub.ltpii.provas.xadrez.tabuleiro;

import br.com.ceub.ltpii.provas.xadrez.gui.XadrezException;
import br.com.ceub.ltpii.provas.xadrez.pecas.Peca;
import java.util.Arrays;

public class Tabuleiro {

  private static Tabuleiro tabuleiro;
  private int linhas;
  private int colunas;
  private Peca[][] pecas;

  public Tabuleiro(final int linhas, final int colunas) {
    if (linhas < 1 || colunas < 1) {
//			throw new Exception("Erro ao criar tabuleiro: deve haver pelo menos 1 linha e 1 coluna");
    }
    this.linhas = linhas;
    this.colunas = colunas;
    pecas = new Peca[linhas][colunas];
  }

  public static Tabuleiro getTabuleiro() {
    return tabuleiro;
  }

  public static void setTabuleiro(final Tabuleiro tabuleiro) {
    Tabuleiro.tabuleiro = tabuleiro;
  }

  public boolean movimentoInvalido(final boolean posicao) throws XadrezException {
    if (!posicao) {
      throw new XadrezException("Movimento invalido");
    }
    return posicao;
  }

  public Peca peca(final int linha, final int coluna) {
    if (!posicaoExiste(linha, coluna)) {
//			throw new Exception("Posi��o fora do tabuleiro");
    }
    return pecas[linha][coluna];
  }

  public Peca peca(final Posicao posicao) {
    if (!posicaoExiste(posicao)) {
//			throw new Exception("Posi��o fora do tabuleiro");
    }
    return pecas[posicao.getLinha()][posicao.getColuna()];
  }

  private boolean posicaoExiste(final int linha, final int coluna) {
    return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
  }

  public boolean posicaoExiste(final Posicao posicao) {
    return posicaoExiste(posicao.getLinha(), posicao.getColuna());
  }

  public void colocarPeca(final Peca peca, final Posicao posicao) {

    System.out.printf("Colocando peca = [%s] na posicao = [%s]%n", peca, posicao);

    if (existePeca(posicao)) {
//			throw new TabuleiroException("J� existe uma pe�a na posi��o " + position);
    }
    peca.setPosicao(posicao);
    pecas[posicao.getLinha()][posicao.getColuna()] = peca;
//		peca.position = position;
    System.out.println(Arrays.deepToString(pecas));
  }

  public Peca removePeca(final Posicao posicao) {
    if (!existePeca(posicao)) {
//			throw new TabuleiroException("Posi��o fora do tabuleiro ");
    }
    if (peca(posicao) == null) {
      return null;
    }
    final Peca aux = peca(posicao);
//		aux.position = null;
    pecas[posicao.getLinha()][posicao.getColuna()] = null;
    return aux;
  }

  public boolean existePeca(final Posicao posicao) {
    if (!posicaoExiste(posicao)) {
//			throw new TabuleiroException("Posi��o fora do tabuleiro");
    }
    return peca(posicao) != null;
  }

  public int getLinhas() {
    return linhas;
  }

  public void setLinhas(final int linhas) {
    this.linhas = linhas;
  }

  public int getColunas() {
    return colunas;
  }

  public void setColunas(final int colunas) {
    this.colunas = colunas;
  }

  public Peca[][] getPecas() {
    return pecas;
  }

  public void setPecas(final Peca[][] pecas) {
    this.pecas = pecas;
  }


  public void limpar() {
    for (int linha = 0, pecasLength = pecas.length; linha < pecasLength; linha++) {
      for (int coluna = 0, linhaLength = pecas[linha].length; coluna < linhaLength; coluna++) {
        pecas[linha][coluna] = null;
      }
    }
  }
}
