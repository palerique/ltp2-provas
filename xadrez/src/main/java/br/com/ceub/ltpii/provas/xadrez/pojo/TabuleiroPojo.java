package br.com.ceub.ltpii.provas.xadrez.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabuleiroPojo {

  private final List<PecaPojo> listaPecas;

  public TabuleiroPojo() {
    listaPecas = new ArrayList<>();
  }

  public List<PecaPojo> getListaPecas() {
    return Collections.unmodifiableList(listaPecas);
  }

  @Override
  public String toString() {
    return "TabuleiroPojo{" +
        "listaPecas=" + listaPecas +
        '}';
  }

  public void add(final PecaPojo peca) {
    listaPecas.add(peca);
  }
}
