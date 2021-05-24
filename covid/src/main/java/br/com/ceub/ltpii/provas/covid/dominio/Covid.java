package br.com.ceub.ltpii.provas.covid.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Covid {
	private String estado;
	private String pais;
	private double latitude;
	private double longitude;
	private List<Double> mortes;

	public Covid() {
		mortes = new ArrayList<Double>();
	}

	public List<Double> getMortes() {
		return mortes;
	}
	public void setMortes(List<Double> mortes) {
		this.mortes = mortes;
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
}
