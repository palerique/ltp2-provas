package br.com.ceub.ltpii.provas.covid;

import br.com.ceub.ltpii.provas.covid.dominio.CovidEstatistica;
import br.com.ceub.ltpii.provas.covid.service.CovidService;

public class App {

    public static void main(String[] args) {
        CovidService covidService = new CovidService();
        covidService.getDadosCovid("time_series_covid19_deaths_global.csv");
        covidService.calcularEstatisticas();
        covidService.getEstatistica("Brazil");
        covidService.getEstatistica("USA");
    }
}
