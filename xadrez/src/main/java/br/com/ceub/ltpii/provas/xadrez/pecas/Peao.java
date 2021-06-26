package br.com.ceub.ltpii.provas.xadrez.pecas;

import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas.Constants;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;
import br.com.ceub.ltpii.provas.xadrez.xadrez.PartidaXadrez;

public class Peao extends Peca {

  PartidaXadrez partidaXadrez;

  public Peao(final Tabuleiro tabuleiro, final Cor cor, final PartidaXadrez partidaXadrez) {
    super(tabuleiro, cor, EnumPecas.getEnum(cor, Constants.PEAO));
    this.partidaXadrez = partidaXadrez;
  }

  // Foco do nosso trabalho quanto a movimenta��o � aqui
  @Override
  public boolean[][] possivelMovimento() {
    final boolean[][] matrizMovimentosPossiveis = new boolean[getTabuleiro()
        .getLinhas()][getTabuleiro()
        .getColunas()];

    final Posicao p = new Posicao(0, 0);

    if (getCor() == Cor.PRETO) {
      p.setValores(posicao.getLinha() - 1, posicao.getColuna());

      // movimento 1 - peão preto
      // verifica se pode movimentar 1 casa para frente
      if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
        matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      }

      // movimento 2 - peão preto
      // verifica se pode movimentar duas casas para frente na primeira jogada
      final Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
      p.setValores(posicao.getLinha() - 2, posicao.getColuna());
      if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p) &&
          getTabuleiro().posicaoExiste(p2) && !getTabuleiro().existePeca(p2)
          && getContagemMovimento() == 0) {
        matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      }

      // movimento 3 - peão preto
      // Jogada para capturar pecas que estão na diagonal superior esquerda
      // verifico se a coluna > 0, pois desejo movimentar para a diagonal superior esquerda
      if (posicao.getColuna() > 0) {
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
          matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
        }
      }

      // movimento 4 - peão preto
      // Jogada para capturar pecas que estão na diagonal superior direito
      // Jogada para capturar pecas
      // verifico se a coluna > 0, pois desejo movimentar para a diagonal superior direita
      if (posicao.getColuna() < 7) {
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
          matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
        }
      }

    } else {
      p.setValores(posicao.getLinha() + 1, posicao.getColuna());

      // movimento 1 do peão branco
      // ir para frente que significa incrementar as linhas
      if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p)) {
        matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      }

      // movimento 2 do peão branco
      // a possibilidade de movimentar até duas casas na primeira jogada do peão
      final Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
      p.setValores(posicao.getLinha() + 2, posicao.getColuna());
      if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().existePeca(p) &&
          getTabuleiro().posicaoExiste(p2) && !getTabuleiro().existePeca(p2)
          && getContagemMovimento() == 0) {
        matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
      }

      // movimento 3 do peão branco
      // Jogada para capturar pecas
      // verifico se a coluna > 0, pois desejo movimentar para a diagonal inferior esquerda
      if (posicao.getColuna() > 0) {
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
          matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
        }
      }

      // movimento 4 do peão branco
      // Jogada para capturar pecas
      // verifico se a coluna > 0, pois desejo movimentar para a diagonal inferior direita
      if (posicao.getColuna() < 7) {
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p) && ehPecaOponente(p)) {
          matrizMovimentosPossiveis[p.getLinha()][p.getColuna()] = true;
        }
      }

    }

    return matrizMovimentosPossiveis;

  }
}
