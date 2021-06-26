package br.com.ceub.ltpii.provas.xadrez.gui;

import br.com.ceub.ltpii.provas.xadrez.pecas.Bispo;
import br.com.ceub.ltpii.provas.xadrez.pecas.Cavalo;
import br.com.ceub.ltpii.provas.xadrez.pecas.Peao;
import br.com.ceub.ltpii.provas.xadrez.pecas.Peca;
import br.com.ceub.ltpii.provas.xadrez.pecas.Rainha;
import br.com.ceub.ltpii.provas.xadrez.pecas.Rei;
import br.com.ceub.ltpii.provas.xadrez.pecas.Torre;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Cor;
import br.com.ceub.ltpii.provas.xadrez.tabuleiro.Posicao;
import br.com.ceub.ltpii.provas.xadrez.xadrez.PartidaXadrez;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * https://docs.oracle.com/javase/8/javase-clienttechnologies.htm
 */
public class Tela extends Application {

  public static final String CARREGAR = "Carregar";
  public static final String SALVAR = "Salvar";
  private static Image peaoBranco = null;
  private static Image cavaloBranco = null;
  private static Image bispoBranco = null;
  private static Image torreBranco = null;
  private static Image reiBranco = null;
  private static Image rainhaBranco = null;
  private static Image peaoPreto = null;
  private static Image cavaloPreto = null;
  private static Image bispoPreto = null;
  private static Image torrePreto = null;
  private static Image reiPreto = null;
  private static Image rainhaPreto = null;
  private static Image botaoSalvar = null;
  private static Image botaoCarregar = null;
  private static Image vazio = null;
  private static String posicaoOrigem;
  private static Map<String, Button> mapButton = null;
  private static PartidaXadrez partidaXadrez;
  private TextArea textArea = null;

  public Tela() {
    inicializar();
  }

  /**
   * Método para inicializar um aplicativo java
   */
  public static void main(final String[] args) {
    launch(args);
  }

  public static ImageView getImageXadrez(final Peca peca) {
    Image image = null;
    if (peca instanceof Peao && peca.getCor() == Cor.BRANCO) {
      image = getPeaoBranco();
    }
    if (peca instanceof Peao && peca.getCor() == Cor.PRETO) {
      image = getPeaoPreto();
    }
    if (peca instanceof Torre && peca.getCor() == Cor.PRETO) {
      image = getTorrePreto();
    }
    if (peca instanceof Torre && peca.getCor() == Cor.BRANCO) {
      image = getTorreBranco();
    }
    if (peca instanceof Bispo && peca.getCor() == Cor.PRETO) {
      image = getBispoPreto();
    }
    if (peca instanceof Bispo && peca.getCor() == Cor.BRANCO) {
      image = getBispoBranco();
    }
    if (peca instanceof Cavalo && peca.getCor() == Cor.PRETO) {
      image = getCavaloPreto();
    }
    if (peca instanceof Cavalo && peca.getCor() == Cor.BRANCO) {
      image = getCavaloBranco();
    }
    if (peca instanceof Rei && peca.getCor() == Cor.BRANCO) {
      image = getReiBranco();
    }
    if (peca instanceof Rei && peca.getCor() == Cor.PRETO) {
      image = getReiPreto();
    }
    if (peca instanceof Rainha && peca.getCor() == Cor.BRANCO) {
      image = getRainhaBranco();
    }
    if (peca instanceof Rainha && peca.getCor() == Cor.PRETO) {
      image = getRainhaPreto();
    }

    if (peca == null) {
      image = getVazio();
    }

    return new ImageView(image);
  }

  public static Image getPeaoBranco() {
    return peaoBranco;
  }

  public static void setPeaoBranco(Image peaoBranco) {
    Tela.peaoBranco = peaoBranco;
  }

  public static Image getCavaloBranco() {
    return cavaloBranco;
  }

  public static void setCavaloBranco(Image cavaloBranco) {
    Tela.cavaloBranco = cavaloBranco;
  }

  public static Image getBispoBranco() {
    return bispoBranco;
  }

  public static void setBispoBranco(Image bispoBranco) {
    Tela.bispoBranco = bispoBranco;
  }

  public static Image getTorreBranco() {
    return torreBranco;
  }

  public static void setTorreBranco(Image torreBranco) {
    Tela.torreBranco = torreBranco;
  }

  public static Image getReiBranco() {
    return reiBranco;
  }

  public static void setReiBranco(Image reiBranco) {
    Tela.reiBranco = reiBranco;
  }

  public static Image getRainhaBranco() {
    return rainhaBranco;
  }

  public static void setRainhaBranco(Image rainhaBranco) {
    Tela.rainhaBranco = rainhaBranco;
  }

  public static Image getPeaoPreto() {
    return peaoPreto;
  }

  public static void setPeaoPreto(Image peaoPreto) {
    Tela.peaoPreto = peaoPreto;
  }

  public static Image getCavaloPreto() {
    return cavaloPreto;
  }

  public static void setCavaloPreto(Image cavaloPreto) {
    Tela.cavaloPreto = cavaloPreto;
  }

  public static Image getBispoPreto() {
    return bispoPreto;
  }

  public static void setBispoPreto(Image bispoPreto) {
    Tela.bispoPreto = bispoPreto;
  }

  public static Image getTorrePreto() {
    return torrePreto;
  }

  public static void setTorrePreto(Image torrePreto) {
    Tela.torrePreto = torrePreto;
  }

  public static Image getReiPreto() {
    return reiPreto;
  }

  public static void setReiPreto(Image reiPreto) {
    Tela.reiPreto = reiPreto;
  }

  public static Image getRainhaPreto() {
    return rainhaPreto;
  }

  public static void setRainhaPreto(Image rainhaPreto) {
    Tela.rainhaPreto = rainhaPreto;
  }

  public static Image getBotaoSalvar() {
    return botaoSalvar;
  }

  public static void setBotaoSalvar(Image botaoSalvar) {
    Tela.botaoSalvar = botaoSalvar;
  }

  public static Image getBotaoCarregar() {
    return botaoCarregar;
  }

  public static void setBotaoCarregar(Image botaoCarregar) {
    Tela.botaoCarregar = botaoCarregar;
  }

  public static Image getVazio() {
    return vazio;
  }

  public static void setVazio(Image vazio) {
    Tela.vazio = vazio;
  }

  public static String getPosicaoOrigem() {
    return posicaoOrigem;
  }

  public static void setPosicaoOrigem(String posicaoOrigem) {
    Tela.posicaoOrigem = posicaoOrigem;
  }

  public static Map<String, Button> getMapButton() {
    return mapButton;
  }

  public static void setMapButton(Map<String, Button> mapButton) {
    Tela.mapButton = mapButton;
  }

  public static PartidaXadrez getPartidaXadrez() {
    return partidaXadrez;
  }

  public static void setPartidaXadrez(PartidaXadrez partidaXadrez) {
    Tela.partidaXadrez = partidaXadrez;
  }

  @Override
  public void start(final Stage stage) {
    stage.setTitle("Jogo de Xadrez LTPII");

    final VBox root = new VBox();
    final int alturaTela = 700;
    final int larguraTela = 575;
    final Scene scene = new Scene(root, larguraTela, alturaTela);
    stage.setScene(scene);
    stage.setWidth(larguraTela);
    stage.setHeight(alturaTela);
    exibirTabuleiro(root);
    exibirTelasInformacoesJogadores(root);
    exibirBotoesSalvarECarregar(root);
    stage.show();
  }

  private void exibirTelasInformacoesJogadores(final VBox root) {
    final VBox vBox = new VBox();
    setTextArea(new TextArea());
    getTextArea().setText("Jogador 1 - Proprietário das Peças Brancas \n"
        + "Jogador 2 - Proprietário das Peças Pretas"
        + ""
        + "\n"
        + "Jogador atual eh ");
    vBox.getChildren().add(getTextArea());
    root.getChildren().add(vBox);
  }

  private void exibirBotoesSalvarECarregar(final VBox root) {
    final VBox vBox = new VBox();
    final Button salvar = new Button();
    salvar.setId(SALVAR);
    salvar.setText(SALVAR);
    salvar.addEventHandler(MouseEvent.MOUSE_CLICKED, new TratadorSalvar());
    vBox.getChildren().add(salvar);
    final Button carregar = new Button();
    carregar.setId(CARREGAR);
    carregar.setText(CARREGAR);
    carregar.addEventHandler(MouseEvent.MOUSE_CLICKED, new TratadorCarregar());
    vBox.getChildren().add(carregar);
    root.getChildren().add(vBox);
  }

  private void exibirTabuleiro(final VBox root) {
    for (int linha = 0; linha < getPartidaXadrez().getTabuleiro().getLinhas(); linha++) {
      final HBox hroot = new HBox();
      for (int coluna = 0; coluna < getPartidaXadrez().getTabuleiro().getColunas(); coluna++) {
        final Peca peca = getPartidaXadrez().getTabuleiro().getPecas()[linha][coluna];
        final Posicao posicao = new Posicao(linha, coluna);
        adicionarButton(peca, posicao, hroot);
      }
      root.getChildren().add(hroot);
    }
  }

  void adicionarButton(final Peca peca, final Posicao posicao, final HBox root) {
    final Button button = new Button();
    final String chaveIdentificarButton = posicao.getLinha() + "," + posicao.getColuna();
    getMapButton().put(chaveIdentificarButton, button);
    button.setId(chaveIdentificarButton);
    button.setGraphic(getImageXadrez(peca));
    button.addEventHandler(MouseEvent.MOUSE_CLICKED, new TratadorEvento());
    root.getChildren().add(button);
  }

  void inicializar() {
    setMapButton(new HashMap<>());
    setPartidaXadrez(PartidaXadrez.getInstance());
    setPeaoBranco(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/peao_branco.png")), 50, 50, false,
        false));
    setCavaloBranco(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/cavalo_branco.png")), 50, 50, false,
        false));
    setBispoBranco(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/bispo_branco.png")), 50, 50, false,
        false));
    setTorreBranco(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/torre_branco.png")), 50, 50, false,
        false));
    setReiBranco(
        new Image(Objects.requireNonNull(getClass().getResourceAsStream("/rei_branco.png")),
            50, 50, false, false));
    setRainhaBranco(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/rainha_branco.png")), 50, 50, false,
        false));

    setPeaoPreto(
        new Image(Objects.requireNonNull(getClass().getResourceAsStream("/peao_preto.png")),
            50, 50, false, false));
    setCavaloPreto(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/cavalo_preto.png")), 50, 50, false,
        false));
    setBispoPreto(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/bispo_preto.png")), 50, 50, false,
        false));
    setTorrePreto(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/torre_preto.png")), 50, 50, false,
        false));
    setReiPreto(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/rei_preto.png")),
        50, 50, false, false));
    setRainhaPreto(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/rainha_preto.png")), 50, 50, false,
        false));

    setVazio(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/vazio.png")), 50, 50,
        false, false));

    setBotaoSalvar(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/salvar.png")),
        50, 50, false, false));
    setBotaoCarregar(new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/carregar.png")), 50, 50, false,
        false));
  }

  public TextArea getTextArea() {
    return textArea;
  }

  public void setTextArea(TextArea textArea) {
    this.textArea = textArea;
  }
}



