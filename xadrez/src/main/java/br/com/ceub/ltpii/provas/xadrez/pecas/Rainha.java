package br.com.ceub.ltpii.provas.xadrez.pecas;

import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas.Constants;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;

public class Rainha extends Peca {

  public Rainha(final Tabuleiro tabuleiro, final Cor cor) {
    super(tabuleiro, cor, EnumPecas.getEnum(cor, Constants.RAINHA));
  }

  @Override
  public boolean[][] possivelMovimento() {
    // Questão 2
    final boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro()
        .getLinhas()][getTabuleiro()
        .getColunas()];

    final Posicao posicao = new Posicao(0, 0);

    // noroeste - diagonal superior esquerda - movimenta v�rias casas
    posicao.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() - 1);
    while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
      posicao.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
    }

    // noroeste - Rainha est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // nordeste - diagonal superior direita
    posicao.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna() + 1);
    while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
      posicao.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
    }

    // nordeste - Rainha est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sudeste - diagonal inferior direita
    posicao.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() + 1);
    while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
      posicao.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
    }

    // sudeste - Rainha est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sudoeste - diagonal inferior esquerda
    posicao.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna() - 1);
    while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
      posicao.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
    }

    // sudoeste - Rainha est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }
    // norte - movimenta para cima - movimenta v�rias casas
    posicao.setValores(this.posicao.getLinha() - 1, this.posicao.getColuna());
    while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
      posicao.setValores(posicao.getLinha() - 1, posicao.getColuna());
    }

    // norte - Rainha est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // sul - movimenta para baixo
    posicao.setValores(this.posicao.getLinha() + 1, this.posicao.getColuna());
    while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
      posicao.setValores(posicao.getLinha() + 1, posicao.getColuna());
    }

    // sul - Rainha est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // leste - Rainha movimenta para direita
    posicao.setValores(this.posicao.getLinha(), this.posicao.getColuna() + 1);
    while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
      posicao.setValores(posicao.getLinha(), posicao.getColuna() + 1);
    }

    // leste - Rainha est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    // oeste - Rainha movimenta para esquerda
    posicao.setValores(this.posicao.getLinha(), this.posicao.getColuna() - 1);
    while (getTabuleiro().posicaoExiste(posicao) && !getTabuleiro().existePeca(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
      posicao.setValores(posicao.getLinha(), posicao.getColuna() - 1);
    }

    // oeste - Rainha est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(posicao) && ehPecaOponente(posicao)) {
      matrizMovimentosPossiveis[posicao.getLinha()][posicao.getColuna()] = true;
    }

    System.out.println(imprimir(matrizMovimentosPossiveis));
    return matrizMovimentosPossiveis;
  }
}
