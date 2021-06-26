package br.com.ceub.ltpii.provas.covid.dominio;

import java.time.LocalDate;
import java.util.SortedMap;
import java.util.TreeMap;

public class Covid {

  private final SortedMap<LocalDate, Long> mortes;
  private String estado;
  private String pais;
  private double latitude;
  private double longitude;

  public Covid() {
    mortes = new TreeMap<>(LocalDate::compareTo);
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(final String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(final String pais) {
    this.pais = pais;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(final double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(final double longitude) {
    this.longitude = longitude;
  }

  public SortedMap<LocalDate, Long> getMortes() {
    return mortes;
  }

  @Override
  public String toString() {
    return "Covid{" +
        "estado='" + estado + '\'' +
        ", pais='" + pais + '\'' +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        ", mortes=" + mortes +
        '}';
  }
}
