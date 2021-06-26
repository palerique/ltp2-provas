package br.com.ceub.ltpii.provas.xadrez.xadrez;

import br.com.ceub.ltpii.provas.xadrez.pecas.Bispo;
import br.com.ceub.ltpii.provas.xadrez.pecas.Cavalo;
import br.com.ceub.ltpii.provas.xadrez.pecas.Peao;
import br.com.ceub.ltpii.provas.xadrez.pecas.Peca;
import br.com.ceub.ltpii.provas.xadrez.pecas.Rainha;
import br.com.ceub.ltpii.provas.xadrez.pecas.Rei;
import br.com.ceub.ltpii.provas.xadrez.pecas.Torre;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;
import java.util.ArrayList;
import java.util.List;

public class PartidaXadrez {

  private static PartidaXadrez instance;
  private boolean checkMate;
  private boolean check;
  private Cor jogadorCorrente;
  private Tabuleiro tabuleiro;
  private List<Peca> pecasNoTabuleiro = new ArrayList<>();
  private List<Peca> pecasCapturadas = new ArrayList<>();

  public PartidaXadrez() {
    tabuleiro = new Tabuleiro(8, 8);
    jogadorCorrente = Cor.BRANCO;
    inicializacao();
  }

  // Singleton
  public static PartidaXadrez getInstance() {
    if (instance == null) {
      instance = new PartidaXadrez();
    }
    return instance;
  }

  public Peca[][] getPecas() {
    final Peca[][] mat = new Peca[tabuleiro.getLinhas()][tabuleiro.getColunas()];
    for (int i = 0; i < tabuleiro.getLinhas(); i++) {
      for (int j = 0; j < tabuleiro.getColunas(); j++) {
        mat[i][j] = tabuleiro.peca(i, j);
      }
    }
    return mat;
  }

  private void colocarNovaPeca(final int linha, final int coluna, final Peca peca) {
    tabuleiro.colocarPeca(peca, new Posicao(linha, coluna));
    pecasNoTabuleiro.add(peca);
  }

  private void inicializacao() {
    colocarNovaPeca(0, 0, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca(0, 1, new Cavalo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca(0, 2, new Bispo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca(0, 3, new Rainha(tabuleiro, Cor.BRANCO));
    colocarNovaPeca(0, 4, new Rei(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca(0, 5, new Bispo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca(0, 6, new Cavalo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca(0, 7, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca(1, 0, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca(1, 1, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca(1, 2, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca(1, 3, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca(1, 4, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca(1, 5, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca(1, 6, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca(1, 7, new Peao(tabuleiro, Cor.BRANCO, this));

    colocarNovaPeca(7, 0, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca(7, 1, new Cavalo(tabuleiro, Cor.PRETO));
    colocarNovaPeca(7, 2, new Bispo(tabuleiro, Cor.PRETO));
    colocarNovaPeca(7, 3, new Rainha(tabuleiro, Cor.PRETO));
    colocarNovaPeca(7, 4, new Rei(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca(7, 5, new Bispo(tabuleiro, Cor.PRETO));
    colocarNovaPeca(7, 6, new Cavalo(tabuleiro, Cor.PRETO));
    colocarNovaPeca(7, 7, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca(6, 0, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca(6, 1, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca(6, 2, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca(6, 3, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca(6, 4, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca(6, 5, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca(6, 6, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca(6, 7, new Peao(tabuleiro, Cor.PRETO, this));
  }

  public Cor getJogadorCorrente() {
    return jogadorCorrente;
  }

  public void setJogadorCorrente(final Cor jogadorCorrente) {
    this.jogadorCorrente = jogadorCorrente;
  }

  public Tabuleiro getTabuleiro() {
    return tabuleiro;
  }

  public void setTabuleiro(final Tabuleiro tabuleiro) {
    this.tabuleiro = tabuleiro;
  }

  public List<Peca> getPecasNoTabuleiro() {
    return pecasNoTabuleiro;
  }

  public void setPecasNoTabuleiro(final List<Peca> pecasNoTabuleiro) {
    this.pecasNoTabuleiro = pecasNoTabuleiro;
  }

  public List<Peca> getPecasCapturadas() {
    return pecasCapturadas;
  }

  public void setPecasCapturadas(final List<Peca> pecasCapturadas) {
    this.pecasCapturadas = pecasCapturadas;
  }

  public boolean getCheck() {
    return check;
  }

  public boolean getCheckMate() {
    return checkMate;
  }


}
