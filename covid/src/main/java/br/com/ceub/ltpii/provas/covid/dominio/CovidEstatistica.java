package br.com.ceub.ltpii.provas.covid.dominio;

import java.time.LocalDate;

public class CovidEstatistica {

  private static String[] cabecalho;
  private long totalMortes;
  private double mediaMortes;
  private double stdMortes;
  private long mortesNoPiorDia;
  private long mortesNoMelhorDia;
  private LocalDate dataMaisMortes;
  private LocalDate dataMenosMortes;
  private Covid covid;

  public CovidEstatistica(final Covid covid) {
    this.covid = covid;
    calcularIndicadoresEstatisticos();
  }

  public static String[] getCabecalho() {
    return cabecalho;
  }

  public static void setCabecalho(final String[] cabecalho) {
    CovidEstatistica.cabecalho = cabecalho;
  }

  private void calcularIndicadoresEstatisticos() {
    if (covid != null) {
      totalMortes = covid.getMortes().get(covid.getMortes().lastKey());
      dataMenosMortes = covid.getMortes().firstKey();

      //2,0 pontos a.3) Média de mortes
      mediaMortes = totalMortes / (double) covid.getMortes().size();

      covid.getMortes().forEach((data, totalDeMortesAteEsseDia) -> {
        final Long totalDeMortesAteOProximoDia = covid.getMortes().get(data.plusDays(1));
        final long morteApenasNesseDia;
        if (totalDeMortesAteOProximoDia == null) {
          final Long totalDeMortesAteODiaAnterior = covid.getMortes().get(data.minusDays(1));
          morteApenasNesseDia = totalDeMortesAteEsseDia - totalDeMortesAteODiaAnterior;
        } else {
          morteApenasNesseDia = totalDeMortesAteOProximoDia - totalDeMortesAteEsseDia;
        }

        //1,0 pontos a.2) quantidade máxima de mortes
        //2,0 pontos a.2) Data com mais mortes
        if (getMortesNoPiorDia() < morteApenasNesseDia) {
          setMortesNoPiorDia(morteApenasNesseDia);
          setDataMaisMortes(data);
        }

        //1,0 pontos a.1) quantidade mínima de mortes
        //2,0 pontos a.1) Data com menos mortes
        if (getMortesNoMelhorDia() > morteApenasNesseDia) {
          setMortesNoMelhorDia(morteApenasNesseDia);
          setDataMenosMortes(data);
        }

        setStdMortes(getStdMortes() + Math.pow(morteApenasNesseDia, 2));
      });

      //2,0 pontos a.4) Desvio padrão de mortes
      setStdMortes(Math.sqrt(getStdMortes() / covid.getMortes().size()));
    }
  }

  public long getTotalMortes() {
    return totalMortes;
  }

  public void setTotalMortes(final long totalMortes) {
    this.totalMortes = totalMortes;
  }

  public double getMediaMortes() {
    return mediaMortes;
  }

  public void setMediaMortes(final double mediaMortes) {
    this.mediaMortes = mediaMortes;
  }

  public double getStdMortes() {
    return stdMortes;
  }

  public void setStdMortes(final double stdMortes) {
    this.stdMortes = stdMortes;
  }

  public long getMortesNoPiorDia() {
    return mortesNoPiorDia;
  }

  public void setMortesNoPiorDia(final long mortesNoPiorDia) {
    this.mortesNoPiorDia = mortesNoPiorDia;
  }

  public long getMortesNoMelhorDia() {
    return mortesNoMelhorDia;
  }

  public void setMortesNoMelhorDia(final long mortesNoMelhorDia) {
    this.mortesNoMelhorDia = mortesNoMelhorDia;
  }

  public LocalDate getDataMaisMortes() {
    return dataMaisMortes;
  }

  public void setDataMaisMortes(final LocalDate dataMaisMortes) {
    this.dataMaisMortes = dataMaisMortes;
  }

  public LocalDate getDataMenosMortes() {
    return dataMenosMortes;
  }

  public void setDataMenosMortes(final LocalDate dataMenosMortes) {
    this.dataMenosMortes = dataMenosMortes;
  }

  public Covid getCovid() {
    return covid;
  }

  public void setCovid(final Covid covid) {
    this.covid = covid;
  }

  @Override
  public String toString() {
    return "CovidEstatistica{" +
        "totalMortes=" + totalMortes +
        ", mediaMortes=" + mediaMortes +
        ", stdMortes=" + stdMortes +
        ", mortesNoPiorDia=" + mortesNoPiorDia +
        ", mortesNoMelhorDia=" + mortesNoMelhorDia +
        ", dataMaisMortes=" + dataMaisMortes +
        ", dataMenosMortes=" + dataMenosMortes +
        ", covid=" + covid +
        '}';
  }
}
