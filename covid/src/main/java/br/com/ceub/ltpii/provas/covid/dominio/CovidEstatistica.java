package br.com.ceub.ltpii.provas.covid.dominio;

import java.util.Arrays;

public class CovidEstatistica {

  private static String[] cabecalho;
  private double totalMortes;
  private double mediaMortes;
  private double stdMortes;
  private double diaMaisMortes;
  private double diaMenosMortes;
  private String dataMaisMortes;
  private String dataMenosMortes;
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
    int quantidadeDias = this.covid.getMortes().size();
    double morteDia = 0, morteProximoDia = 0, morteDiaHoje = 0;

    for (int i = 0; i < quantidadeDias - 1; i++) {

      morteDiaHoje = this.covid.getMortes().get(i);
      morteProximoDia = this.covid.getMortes().get(i + 1);
      morteDia = morteProximoDia - morteDiaHoje;
      this.totalMortes += morteDia;
    }
  }

  public double getTotalMortes() {
    return totalMortes;
  }

  public void setTotalMortes(double totalMortes) {
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

  public double getDiaMaisMortes() {
    return diaMaisMortes;
  }

  public void setDiaMaisMortes(double diaMaisMortes) {
    this.diaMaisMortes = diaMaisMortes;
  }

  public double getDiaMenosMortes() {
    return diaMenosMortes;
  }

  public void setDiaMenosMortes(double diaMenosMortes) {
    this.diaMenosMortes = diaMenosMortes;
  }

  public String getDataMaisMortes() {
    return dataMaisMortes;
  }

  public void setDataMaisMortes(String dataMaisMortes) {
    this.dataMaisMortes = dataMaisMortes;
  }

  public String getDataMenosMortes() {
    return dataMenosMortes;
  }

  public void setDataMenosMortes(String dataMenosMortes) {
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
        "cabecalho=" + Arrays.toString(cabecalho) +
        ", totalMortes=" + totalMortes +
        ", mediaMortes=" + mediaMortes +
        ", stdMortes=" + stdMortes +
        ", diaMaisMortes=" + diaMaisMortes +
        ", diaMenosMortes=" + diaMenosMortes +
        ", dataMaisMortes='" + dataMaisMortes + '\'' +
        ", dataMenosMortes='" + dataMenosMortes + '\'' +
        ", covid=" + covid +
        '}';
  }
}
