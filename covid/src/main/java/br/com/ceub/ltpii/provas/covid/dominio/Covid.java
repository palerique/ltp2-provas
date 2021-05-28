package br.com.ceub.ltpii.provas.covid.dominio;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Covid {

  private final Map<Date, Double> mortes;
  private String estado;
  private String pais;
  private double latitude;
  private double longitude;

  public Covid() {
    mortes = new HashMap<>();
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public Map<Date, Double> getMortes() {
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
