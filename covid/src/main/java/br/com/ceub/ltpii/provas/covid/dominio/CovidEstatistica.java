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

  public CovidEstatistica(Covid covid) {
    this.covid = covid;
    calcularIndicadoresEstatisticos();
  }

  public static String[] getCabecalho() {
    return cabecalho;
  }

  public static void setCabecalho(String[] cabecalho) {
    CovidEstatistica.cabecalho = cabecalho;
  }

  private void calcularIndicadoresEstatisticos() {
    if (this.covid != null) {
      this.totalMortes = this.covid.getMortes().get(this.covid.getMortes().lastKey());
      this.dataMenosMortes = this.covid.getMortes().firstKey();

      //2,0 pontos a.3) Média de mortes
      this.mediaMortes = totalMortes / (double) this.covid.getMortes().size();

      this.covid.getMortes().forEach((data, totalDeMortesAteEsseDia) -> {
        Long totalDeMortesAteOProximoDia = this.covid.getMortes().get(data.plusDays(1));
        long morteApenasNesseDia;
        if (totalDeMortesAteOProximoDia == null) {
          Long totalDeMortesAteODiaAnterior = this.covid.getMortes().get(data.minusDays(1));
          morteApenasNesseDia = totalDeMortesAteEsseDia - totalDeMortesAteODiaAnterior;
        } else {
          morteApenasNesseDia = totalDeMortesAteOProximoDia - totalDeMortesAteEsseDia;
        }

        //1,0 pontos a.2) quantidade máxima de mortes
        //2,0 pontos a.2) Data com mais mortes
        if (this.getMortesNoPiorDia() < morteApenasNesseDia) {
          this.setMortesNoPiorDia(morteApenasNesseDia);
          this.setDataMaisMortes(data);
        }

        //1,0 pontos a.1) quantidade mínima de mortes
        //2,0 pontos a.1) Data com menos mortes
        if (this.getMortesNoMelhorDia() > morteApenasNesseDia) {
          this.setMortesNoMelhorDia(morteApenasNesseDia);
          this.setDataMenosMortes(data);
        }

        this.setStdMortes(this.getStdMortes() + Math.pow(morteApenasNesseDia, 2));
      });

      //2,0 pontos a.4) Desvio padrão de mortes
      this.setStdMortes(Math.sqrt(this.getStdMortes() / this.covid.getMortes().size()));
    }
  }

  public long getTotalMortes() {
    return totalMortes;
  }

  public void setTotalMortes(long totalMortes) {
    this.totalMortes = totalMortes;
  }

  public double getMediaMortes() {
    return mediaMortes;
  }

  public void setMediaMortes(double mediaMortes) {
    this.mediaMortes = mediaMortes;
  }

  public double getStdMortes() {
    return stdMortes;
  }

  public void setStdMortes(double stdMortes) {
    this.stdMortes = stdMortes;
  }

  public long getMortesNoPiorDia() {
    return mortesNoPiorDia;
  }

  public void setMortesNoPiorDia(long mortesNoPiorDia) {
    this.mortesNoPiorDia = mortesNoPiorDia;
  }

  public long getMortesNoMelhorDia() {
    return mortesNoMelhorDia;
  }

  public void setMortesNoMelhorDia(long mortesNoMelhorDia) {
    this.mortesNoMelhorDia = mortesNoMelhorDia;
  }

  public LocalDate getDataMaisMortes() {
    return dataMaisMortes;
  }

  public void setDataMaisMortes(LocalDate dataMaisMortes) {
    this.dataMaisMortes = dataMaisMortes;
  }

  public LocalDate getDataMenosMortes() {
    return dataMenosMortes;
  }

  public void setDataMenosMortes(LocalDate dataMenosMortes) {
    this.dataMenosMortes = dataMenosMortes;
  }

  public Covid getCovid() {
    return covid;
  }

  public void setCovid(Covid covid) {
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
