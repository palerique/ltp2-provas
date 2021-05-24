package br.com.ceub.ltpii.provas.covid.infra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.ceub.ltpii.provas.covid.dominio.Covid;
import br.com.ceub.ltpii.provas.covid.dominio.CovidEstatistica;

/*
 *
 */
public class CovidDAO {

	private Covid getCovid(String linhaArquivo) {
		Covid covid = new Covid();

		String[] vetor = linhaArquivo.split(",");

		String estado    = vetor[0];
		String pais      = vetor[1];
		String latitude  = vetor[2];
		String longitude = vetor[3];

		covid.setEstado(estado);
		covid.setPais(pais);

		try {
			covid.setLatitude(Double.valueOf(latitude));
		} catch(NumberFormatException nfe) {

		}

		try {
			covid.setLongitude(Double.valueOf(longitude));
		} catch(NumberFormatException nfe) {

		}

		for(int i=4; i<vetor.length; i++) {
			String morteDia=vetor[i];
			covid.getMortes().add(Double.valueOf(morteDia));
		}

		return covid;
	}

	public Map<String, Covid> getListaCovid(String caminhoArquivo) {
		BufferedReader br = null;
		FileReader fr = null;

		Map<String, Covid> mapaCovid = new HashMap<String, Covid>();

		try {
			fr = new FileReader(caminhoArquivo);
			br = new BufferedReader(fr);

			String cabecalho = br.readLine(); // lendo o cabecalho do arquivo
			CovidEstatistica.setCabecalho(cabecalho.split(","));

			String linha = br.readLine(); // estou lendo a primeira linha do arquivo

			while(linha != null) {
				Covid covidDto = getCovid(linha);

				mapaCovid.put(covidDto.getPais(), covidDto);

				linha = br.readLine();
			}

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return mapaCovid;
	}
}
