package br.com.ceub.ltpii.provas.covid;

import br.com.ceub.ltpii.provas.covid.dominio.CovidEstatistica;
import br.com.ceub.ltpii.provas.covid.service.CovidService;

public class App {

    public static void main(String[] args) {
        CovidService covidService = new CovidService(
                "/Users/ricardojosemenezesmaia/eclipse-workspace/covid/time_series_covid19_deaths_global.csv");
        covidService.getDadosCovid();

        CovidEstatistica covidEstatistica = covidService.getEstatistica("Brazil");
        System.out.println(Double.valueOf(covidEstatistica.getTotalMortes()).intValue());
    }
}
