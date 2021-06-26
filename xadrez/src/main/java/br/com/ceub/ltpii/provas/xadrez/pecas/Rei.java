package br.com.ceub.ltpii.provas.xadrez.pecas;

import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas.Constants;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;
import br.com.ceub.ltpii.provas.xadrez.xadrez.PartidaXadrez;

public class Rei extends Peca {

  PartidaXadrez partidaXadrez;

  public Rei(final Tabuleiro tabuleiro, final Cor cor, final PartidaXadrez partidaXadrez) {
    super(tabuleiro, cor, EnumPecas.getEnum(cor, Constants.REI));
    this.partidaXadrez = partidaXadrez;
  }

  private boolean podeMover(final Posicao posicao) {
    final Peca p = getTabuleiro().peca(posicao);
    return p == null || p.getCor() != getCor();
  }

  private boolean testRookCastling(final Posicao posicao) {
    final Peca p = getTabuleiro().peca(posicao);
    return p instanceof Torre && p.getCor() == getCor()
        && p.getContagemMovimento() == 0;
  }

  @Override
  public boolean[][] possivelMovimento() {
    // Questão 1
    final boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro()
        .getLinhas()][getTabuleiro()
        .getColunas()];

    final Posicao posicao = new Posicao(0, 0);

    // noroeste - diagonal superior esquerda - movimenta v�rias casas
    posicao.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() - 1);
    if (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // noroeste - Rei est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // nordeste - diagonal superior direita
    posicao.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() + 1);
    if (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // nordeste - Rei est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sudeste - diagonal inferior direita
    posicao.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() + 1);
    if (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sudeste - Rei est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sudoeste - diagonal inferior esquerda
    posicao.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() - 1);
    if (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sudoeste - Rei est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }
    // norte - movimenta para cima - movimenta v�rias casas
    posicao.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna());
    if (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // norte - Rei est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sul - movimenta para baixo
    posicao.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna());
    if (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sul - Rei est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // leste - Rei movimenta para direita
    posicao.setValores(this.posicao.getLinha(), this.posicao.getColuna() + 1);
    if (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // leste - Rei est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // oeste - Rei movimenta para esquerda
    posicao.setValores(this.posicao.getLinha(), this.posicao.getColuna() - 1);
    if (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // oeste - Rei est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    System.out.println(imprimir(matrizMovimentosPossiveis));
    return matrizMovimentosPossiveis;
  }
}
