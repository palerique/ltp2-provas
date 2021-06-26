package br.com.ceub.ltpii.provas.covid.infra;

import br.com.ceub.ltpii.provas.covid.dominio.Covid;
import br.com.ceub.ltpii.provas.covid.dominio.CovidEstatistica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CovidDAO {

  public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("MM/dd/yy");
  public static final String SEPARADOR = ",";
  public static final String REGEX_SEPARADOR = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

  private Covid getCovid(final String linhaArquivo) {
    final Covid covid = new Covid();
    final String[] vetor = linhaArquivo.split(REGEX_SEPARADOR, -1);
    for (int i = 0; i < vetor.length; i++) {
      final String celula = vetor[i];
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
            final Date parsed = SIMPLE_DATE_FORMAT.parse(CovidEstatistica.getCabecalho()[i]);
            covid.getMortes().put(
                parsed.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate(),
                Long.valueOf(celula)
            );
          } catch (final ParseException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return covid;
  }

  public Map<String, Covid> getListaCovid(final String caminhoArquivo) {
    final Map<String, Covid> mapaCovid = new HashMap<>();
    try (
        final InputStream inputStream = Thread.currentThread().getContextClassLoader()
            .getResourceAsStream(caminhoArquivo);
        final InputStreamReader inputStreamReader = new InputStreamReader(
            Objects.requireNonNull(inputStream));
        final BufferedReader br = new BufferedReader(inputStreamReader);
        final Stream<String> linhas = br.lines()
    ) {
      final AtomicInteger index = new AtomicInteger();
      linhas.forEach(linha -> {
        if (index.get() == 0) {
          CovidEstatistica.setCabecalho(linha.split(SEPARADOR));
        } else {
          final Covid covidDto = getCovid(linha);
          mapaCovid.put(covidDto.getPais(), covidDto);
        }
        index.getAndIncrement();
      });
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return mapaCovid;
  }
}
