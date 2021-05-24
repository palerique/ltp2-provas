package br.com.ceub.ltpii.provas.acoes.infra;

import br.com.ceub.ltpii.provas.acoes.dominio.Acao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcaoDAO {

	private void inserirAcaoLista(List<Acao> acoes, String linhaArquivo) {
		String[] vetor = linhaArquivo.split(",");
		Acao acao = new Acao();
		//acao.setData(new Date(vetor[0]));
		acao.setAbertura(Double.parseDouble(vetor[1]));
		acao.setAlta(Double.parseDouble(vetor[2]));
		acao.setBaixa(Double.parseDouble(vetor[3]));
		acao.setFechamento(Double.parseDouble(vetor[4]));
		acao.setAdjClose(Double.parseDouble(vetor[5]));
		acao.setVolume(Double.parseDouble(vetor[6]));

		acoes.add(acao);
	}

	public List<Acao> csv(String nomeArquivo) {
		List<Acao> acoes = new ArrayList<Acao>();
		File arquivoAcoes = new File(nomeArquivo);
		try {
			Scanner sc = new Scanner(arquivoAcoes);
			String linhaArquivo = sc.nextLine(); // lendo o cabecao

			while(sc.hasNextLine()) {
				linhaArquivo = sc.nextLine();

				inserirAcaoLista(acoes, linhaArquivo);
			}

			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return acoes;
	}

 }
