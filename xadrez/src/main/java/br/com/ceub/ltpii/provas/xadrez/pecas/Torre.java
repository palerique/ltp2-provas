package br.com.ceub.ltpii.provas.xadrez.pecas;

import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas.Constants;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;

public class Torre extends Peca {

  public Torre(final Tabuleiro tabuleiro, final Cor cor) {
    super(tabuleiro, cor, EnumPecas.getEnum(cor, Constants.TORRE));
  }

  @Override
  public boolean[][] possivelMovimento() {
    final boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro()
        .getLinhas()][getTabuleiro().getColunas()];

    final Posicao p = new Posicao(0, 0);

    // norte - movimenta para cima - movimenta v�rias casas
    p.setValores(posicao.getLinha() - 1, posicao.getColuna());
    while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      p.setValores(p.getLinha() - 1, p.getColuna());
    }

    // norte - Torre est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // sul - movimenta para baixo
    p.setValores(posicao.getLinha() + 1, posicao.getColuna());
    while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      p.setValores(p.getLinha() + 1, p.getColuna());
    }

    // sul - Torre est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // leste - Torre movimenta para direita
    p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
    while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      p.setValores(p.getLinha(), p.getColuna() + 1);
    }

    // leste - Torre est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // oeste - Torre movimenta para esquerda
    p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
    while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      p.setValores(p.getLinha(), p.getColuna() - 1);
    }

    // oeste - Torre est� capturando uma pe�a advers�ria
    if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    System.out.println(imprimir(matrizMovimentosPossiveis));
    return matrizMovimentosPossiveis;
  }
}
