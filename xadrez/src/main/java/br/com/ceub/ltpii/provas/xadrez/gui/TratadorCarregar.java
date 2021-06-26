package br.com.ceub.ltpii.provas.xadrez.gui;

import br.com.ceub.ltpii.provas.xadrez.pecas.Bispo;
import br.com.ceub.ltpii.provas.xadrez.pecas.Cavalo;
import br.com.ceub.ltpii.provas.xadrez.pecas.Peao;
import br.com.ceub.ltpii.provas.xadrez.pecas.Peca;
import br.com.ceub.ltpii.provas.xadrez.pecas.Rainha;
import br.com.ceub.ltpii.provas.xadrez.pecas.Rei;
import br.com.ceub.ltpii.provas.xadrez.pecas.Torre;
import br.com.ceub.ltpii.provas.xadrez.pojo.PecaPojo;
import br.com.ceub.ltpii.provas.xadrez.pojo.TabuleiroPojo;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.EnumPecas;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Tabuleiro;
import br.com.ceub.ltpii.provas.xadrez.xadrez.PartidaXadrez;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map.Entry;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

class TratadorCarregar implements EventHandler<Event> {

  public static final Gson GSON = new Gson();

  @Override
  public void handle(final Event evt) {
    try {
      final Path source = Paths.get(getClass().getResource("/").getPath());
      final Path newFolder = Paths.get(source.toAbsolutePath() + "/salvos/");
      Files.createDirectories(newFolder);
      final Path newFile = Paths.get(newFolder.toAbsolutePath() + "/jogo.json");
      System.out.printf("Carregando de %s%n", newFile.toAbsolutePath());

      try (final var fileReader = new FileReader(newFile.toFile())) {
        final TabuleiroPojo tabuleiroPojo = GSON.fromJson(fileReader, TabuleiroPojo.class);
        System.out.println(tabuleiroPojo);
        final var tabuleiro = PartidaXadrez.getInstance().getTabuleiro();
        tabuleiro.limpar();

        final ImageView imagemVazia = new ImageView(Tela.getVazio());
        for (Entry<String, Button> buttonEntry : Tela.getMapButton().entrySet()) {
          buttonEntry.getValue().setGraphic(imagemVazia);
        }

        tabuleiroPojo.getListaPecas().forEach(
            pecaPojo -> colocarPeca(tabuleiro, pecaPojo, EnumPecas.getEnum(pecaPojo.getTipoPecao()))
        );
      }
    } catch (final IOException ioException) {
      ioException.printStackTrace();
    }
  }

  private void colocarPeca(
      final Tabuleiro tabuleiro,
      final PecaPojo pecaPojo,
      final EnumPecas enumPecas) {
    Peca peca = null;
    switch (enumPecas) {
      case RAINHA_BRANCO:
        peca = new Rainha(tabuleiro, Cor.BRANCO);
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case RAINHA_PRETO:
        peca = new Rainha(tabuleiro, Cor.PRETO);
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case REI_BRANCO:
        peca = new Rei(tabuleiro, Cor.BRANCO, PartidaXadrez.getInstance());
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case REI_PRETO:
        peca = new Rei(tabuleiro, Cor.PRETO, PartidaXadrez.getInstance());
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case BISPO_BRANCO:
        peca = new Bispo(tabuleiro, Cor.BRANCO);
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case BISPO_PRETO:
        peca = new Bispo(tabuleiro, Cor.PRETO);
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case TORRE_BRANCO:
        peca = new Torre(tabuleiro, Cor.BRANCO);
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case TORRE_PRETO:
        peca = new Torre(tabuleiro, Cor.PRETO);
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case PEAO_BRANCO:
        peca = new Peao(tabuleiro, Cor.BRANCO, PartidaXadrez.getInstance());
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case PEAO_PRETO:
        peca = new Peao(tabuleiro, Cor.PRETO, PartidaXadrez.getInstance());
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case CAVALO_BRANCO:
        peca = new Cavalo(tabuleiro, Cor.BRANCO);
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
      case CAVALO_PRETO:
        peca = new Cavalo(tabuleiro, Cor.PRETO);
        tabuleiro.colocarPeca(peca, new Posicao(pecaPojo.getLinha(), pecaPojo.getColuna()));
        break;
    }

    Tela.getMapButton().get(String.format("%d,%d", pecaPojo.getLinha(), pecaPojo.getColuna()))
        .setGraphic(Tela.getImageXadrez(peca));
  }
}
