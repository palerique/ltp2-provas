package br.com.ceub.ltpii.provas.covid;

import br.com.ceub.ltpii.provas.covid.service.CovidService;

public class App {

  public static void main(final String[] args) {
    final CovidService covidService = new CovidService();
    covidService.getDadosCovid("time_series_covid19_deaths_global.csv");
    System.out.println(covidService.getEstatistica("Brazil"));
    System.out.println(covidService.getEstatistica("Israel"));
    System.out.println(covidService.getEstatistica("US"));
  }
}
