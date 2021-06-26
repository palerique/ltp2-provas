package br.com.ceub.ltpii.provas.xadrez.pecas;

import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas.Constants;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;

/**
 * Cont�m as regras de movimenta��o da pe�a Bispo em um jogo de Xadrez tanto para as pe�as brancas e
 * pretas
 *
 * @author ricar
 */
public class Bispo extends Peca {

  /**
   * M�todo Construtor do Bispo
   *
   * @param tabuleiro
   * @param cor
   */
  public Bispo(final Tabuleiro tabuleiro, final Cor cor) {
    super(tabuleiro, cor, EnumPecas.getEnum(cor, Constants.BISPO));
  }

  /**
   * Cont�m a implementa��o dos poss�veis movimentos da pe�a Bispo
   */
  @Override
  public boolean[][] possivelMovimento() {
    boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro().getLinhas()][getTabuleiro()
        .getColunas()];

    Posicao p = new Posicao(0, 0);

    // noroeste - diagonal superior esquerda - movimenta v�rias casas
    // Bispo apenas movimenta para noroeste e nesta movimenta��o n�o pode ter uma pe�a advers�ria no meio
    // do caminho. Caso o bispo encontre ele sai do la�o
    p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
    while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      p.setValores(p.getLinha() - 1, p.getColuna() - 1);
    }

    // noroeste - Bispo est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // nordeste - diagonal superior direita
    p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
    while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      p.setValores(p.getLinha() - 1, p.getColuna() + 1);
    }

    // nordeste - Bispo est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // sudeste - diagonal inferior direita
    p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
    while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      p.setValores(p.getLinha() + 1, p.getColuna() + 1);
    }

    // sudeste - Bispo est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // sudoeste - diagonal inferior esquerda
    p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
    while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      p.setValores(p.getLinha() + 1, p.getColuna() - 1);
    }

    // sudoeste - Bispo est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    System.out.println(imprimir(matrizMovimentosPossiveis));
    return matrizMovimentosPossiveis;
  }
}
