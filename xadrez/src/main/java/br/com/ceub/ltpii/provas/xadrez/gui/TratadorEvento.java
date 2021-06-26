package br.com.ceub.ltpii.provas.xadrez.gui;

import br.com.ceub.ltpii.provas.xadrez.pecas.Peca;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.xadrez.PartidaXadrez;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;

public class TratadorEvento implements EventHandler<Event> {

  @Override
  public void handle(final Event evt) {
    final String identificadorDestino = ((Control) evt.getSource()).getId();
    final String[] ids = identificadorDestino.split(",");
    final int linhaDestino = Integer.parseInt(ids[0]);
    final int colunaDestino = Integer.parseInt(ids[1]);

    if (Tela.getPosicaoOrigem() == null) {
      System.out.printf("definindo posição de origem = %s%n", identificadorDestino);
      Tela.setPosicaoOrigem(identificadorDestino);
    }

    if (!Tela.getPosicaoOrigem().equals(identificadorDestino)) {
      System.out.printf("Posição origem [%s] != destino [%s]%n", Tela.getPosicaoOrigem(),
          identificadorDestino);
      final String[] idOrigem = Tela.getPosicaoOrigem().split(",");
      final int linhaOrigem = Integer.parseInt(idOrigem[0]);
      final int colunaOrigem = Integer.parseInt(idOrigem[1]);
      final Posicao posicaoDestino = new Posicao(linhaDestino, colunaDestino);
      final Peca pecaOrigem = PartidaXadrez.getInstance().getTabuleiro()
          .getPecas()[linhaOrigem][colunaOrigem];
      if (pecaOrigem != null) {
        System.out.println(pecaOrigem);
        // Obt�m a lista de movimentos v�lidos para pe�a
        final boolean[][] possiveisMovimentosOrigem = pecaOrigem.possivelMovimento();
        System.out.printf("%s %s%n", Tela.getPosicaoOrigem(), identificadorDestino);

        // Verifica se para onde deseja movimentar � true
        try {
          if (PartidaXadrez.getInstance().getTabuleiro()
              .movimentoInvalido(possiveisMovimentosOrigem[linhaDestino][colunaDestino])) {
            PartidaXadrez.getInstance().getTabuleiro().removePeca(pecaOrigem.getPosicao());
            PartidaXadrez.getInstance().getTabuleiro().colocarPeca(pecaOrigem, posicaoDestino);
            final ImageView imagemVazia = new ImageView(Tela.getVazio());
            Tela.getMapButton().get(Tela.getPosicaoOrigem()).setGraphic(imagemVazia);
            Tela.getMapButton().get(identificadorDestino)
                .setGraphic(Tela.getImageXadrez(pecaOrigem));
            Tela.setPosicaoOrigem(null);
          }
        } catch (final XadrezException xe) {
          xe.printStackTrace();
        }

        Tela.setPosicaoOrigem(null);
      }
    }
    System.out.println(Tela.getPosicaoOrigem() + ",			" + identificadorDestino);
  }
}
