package br.com.ceub.ltpii.provas.xadrez.gui;

import br.com.ceub.ltpii.provas.xadrez.pecas.Peca;
import br.com.ceub.ltpii.provas.xadrez.pojo.PecaPojo;
import br.com.ceub.ltpii.provas.xadrez.pojo.TabuleiroPojo;
import br.com.ceub.ltpii.provas.xadrez.xadrez.PartidaXadrez;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javafx.event.Event;
import javafx.event.EventHandler;

class TratadorSalvar implements EventHandler<Event> {

  public static final Gson GSON = new Gson();

  @Override
  public void handle(final Event evt) {
    final Peca[][] pecasTabuleiro = PartidaXadrez.getInstance().getTabuleiro().getPecas();
    System.out.println(Arrays.deepToString(pecasTabuleiro));

    final TabuleiroPojo tabuleiroPojo = new TabuleiroPojo();

    for (int i = 0; i < pecasTabuleiro[0].length; i++) {
      for (int j = 0; j < pecasTabuleiro.length; j++) {
        final PecaPojo pecaPojo = new PecaPojo();
        pecaPojo.setLinha(i);
        pecaPojo.setColuna(j);
        final var peca = pecasTabuleiro[i][j];
        if (peca != null) {
          System.out.println(peca);
          pecaPojo.setTipoPecao(peca.getPeca().getPeca());
          pecaPojo.setCor(peca.getPeca().getCor().getId());
          tabuleiroPojo.add(pecaPojo);
        }
      }
    }

    System.out.println(tabuleiroPojo);

    try {
      final Path source = Paths.get(getClass().getResource("/").getPath());
      final Path newFolder = Paths.get(source.toAbsolutePath() + "/salvos/");
      Files.createDirectories(newFolder);
      final Path newFile = Paths.get(newFolder.toAbsolutePath() + "/jogo.json");
      Files.deleteIfExists(newFile);
      Files.createFile(newFile);
      System.out.printf("Salvando em %s%n", newFile.toAbsolutePath());
      try (final var fileWriter = new FileWriter(newFile.toFile())) {
        GSON.toJson(tabuleiroPojo, fileWriter);
      }
    } catch (final IOException ioException) {
      ioException.printStackTrace();
    }
  }
}
