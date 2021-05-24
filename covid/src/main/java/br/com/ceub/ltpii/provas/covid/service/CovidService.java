package br.com.ceub.ltpii.provas.covid.service;

import br.com.ceub.ltpii.provas.covid.dominio.Covid;
import br.com.ceub.ltpii.provas.covid.dominio.CovidEstatistica;
import br.com.ceub.ltpii.provas.covid.infra.CovidDAO;
import java.util.Map;

public class CovidService {
	private CovidDAO covidDAO;
	private Map<String, Covid> dadosCovid;
	private String arquivoDadosCovid;

	public CovidService(String arquivoDadosCovid) {
		this.arquivoDadosCovid = arquivoDadosCovid;
		covidDAO = new CovidDAO();
	}

	public CovidDAO getCovidDAO() {
		return covidDAO;
	}

	public void setCovidDAO(CovidDAO covidDAO) {
		this.covidDAO = covidDAO;
	}

	public void getDadosCovid() {
		dadosCovid = getCovidDAO().getListaCovid(this.arquivoDadosCovid);
	}

	public CovidEstatistica getEstatistica(String pais) {
		CovidEstatistica covidEstatistica = new CovidEstatistica( dadosCovid.get(pais));
		return covidEstatistica;
	}
}
