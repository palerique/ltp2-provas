package br.com.ceub.ltpii.provas.xadrez.tabuleiro;

import br.com.ceub.ltpii.provas.xadrez.pecas.Peca;

public interface IPeca {

  boolean eliminarPeca(Peca alvo);

  boolean possivelMovimento(Posicao posicao);

  boolean haAlgumMovimentoPossivel();
}
