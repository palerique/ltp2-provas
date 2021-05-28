package br.com.ceub.ltpii.provas.covid.infra;

import br.com.ceub.ltpii.provas.covid.dominio.Covid;
import br.com.ceub.ltpii.provas.covid.dominio.CovidEstatistica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CovidDAO {

  public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("MM/dd/yy");
  public static final String SEPARADOR = ",";

  private Covid getCovid(String linhaArquivo) {
    //TODO: resolver o problema da "Korea, South" e o split nas virgulas!
    Covid covid = new Covid();
    String[] vetor = linhaArquivo.split(SEPARADOR);
    System.out.println(linhaArquivo);
    for (int i = 0; i < vetor.length; i++) {
      String celula = vetor[i];
      if (celula != null && !celula.isEmpty()) {
        if (i == 0) {
          covid.setEstado(celula);
        } else if (i == 1) {
          covid.setPais(celula);
        } else if (i == 2) {
          covid.setLatitude(Double.parseDouble(celula));
        } else if (i == 3) {
          covid.setLongitude(Double.parseDouble(celula));
        } else {
          try {
            covid.getMortes().put(
                SIMPLE_DATE_FORMAT.parse(CovidEstatistica.getCabecalho()[i]),
                Double.valueOf(celula)
            );
          } catch (ParseException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return covid;
  }

  public Map<String, Covid> getListaCovid(String caminhoArquivo) {
    Map<String, Covid> mapaCovid = new HashMap<>();
    try (
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
            .getResourceAsStream(caminhoArquivo);
        InputStreamReader inputStreamReader = new InputStreamReader(
            Objects.requireNonNull(inputStream));
        BufferedReader br = new BufferedReader(inputStreamReader);
        Stream<String> linhas = br.lines()
    ) {
      AtomicInteger index = new AtomicInteger();
      linhas.forEach(linha -> {
        System.out.println(linha);
        if (index.get() == 0) {
          CovidEstatistica.setCabecalho(linha.split(SEPARADOR));
        } else {
          Covid covidDto = getCovid(linha);
          mapaCovid.put(covidDto.getPais(), covidDto);
        }
        index.getAndIncrement();
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mapaCovid;
  }
}
