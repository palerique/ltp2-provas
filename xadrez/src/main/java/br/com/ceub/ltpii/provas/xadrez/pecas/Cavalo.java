package br.com.ceub.ltpii.provas.xadrez.pecas;

import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas.Constants;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;

/**
 * Cont�m as regras para movimenta��o da pe�a Cavalo em um jogo de xadrez. Considerando as cores
 * brancas e pretas.
 *
 * @author ricar
 */
public class Cavalo extends Peca {

  /**
   * Construtor da pe�a Cavalo
   *
   * @param tabuleiro
   * @param cor
   */
  public Cavalo(final Tabuleiro tabuleiro, final Cor cor) {
    super(tabuleiro, cor, EnumPecas.getEnum(cor, Constants.CAVALO));
  }

  private boolean podeMover(final Posicao posicao) {
    final Peca p = getTabuleiro().peca(posicao);
    return p == null || p.getCor() != getCor();
  }

  /**
   * Ir� retornar a matriz de booleanos para informar os poss�veis movimentos do cavalo Este m�todo
   * dever� ser documentado
   */
  @Override
  public boolean[][] possivelMovimento() {
    final boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro()
        .getLinhas()][getTabuleiro()
        .getColunas()];

    final Posicao p = new Posicao(0, 0);
    // L indo para cima
    // Movimento 1 - faz um L <---> sobe uma linha e vai para esquerda duas casas
    p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 2);
    if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // Movimento 2 - faz um L <---> sobe uma linha e vai para direita duas casas
    p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 2);
    if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // Movimento 3 - faz um L <---> sobe duas linhas e vai para esquerda uma casa
    p.setValores(posicao.getLinha() - 2, posicao.getColuna() - 1);
    if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // Movimento 4 - faz um L <---> sobe duas linhas e vai para direita uma casa
    p.setValores(posicao.getLinha() - 2, posicao.getColuna() + 1);
    if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // L indo para baixo
    // Movimento 5 - faz um L <---> desce uma linha e vai para esquerda duas casas
    p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 2);
    if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // Movimento 6 - faz um L <---> desce uma linha e vai para direita duas casas
    p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 2);
    if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // Movimento 7 - faz um L <---> desce duas linhas e vai para esquerda uma casa
    p.setValores(posicao.getLinha() + 2, posicao.getColuna() - 1);
    if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    // Movimento 8 - faz um L <---> desce duas linhas e vai para direita uma casa
    p.setValores(posicao.getLinha() + 2, posicao.getColuna() + 1);
    if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
      matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
    }

    return matrizMovimentosPossiveis;
  }

}
