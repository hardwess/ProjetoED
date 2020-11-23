package controller;

import java.util.Arrays;

import controller.dataStructure.list.Lista;
import model.Candidato;
import model.Curriculo;
import model.DadosGerais;
import model.Entrevista;
import model.Inscricao;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		DadosGerais[] lista = ms.getListaGeral();
		// teste
		for(DadosGerais dado : lista) {
			System.out.println(dado.toString()+"\n");
		}
	}

	public DadosGerais[] getListaGeral() {
		Candidato candidato;
		Inscricao dados;
		Curriculo curriculo;
		Entrevista entrevista;

		CandidatoController candidatoController = new CandidatoController();
		InscricaoController inscricaoController = new InscricaoController();
		CurriculoController curriculoController = new CurriculoController();
		EntrevistaController entrevistaController = new EntrevistaController();

		candidatoController.getListaCandidato();
		inscricaoController.getListaInscricao();
		curriculoController.getListaCurriculo();
		entrevistaController.getListaEntrevista();

		DadosGerais[] lista = new DadosGerais[entrevistaController.retornaTamanho()];

		for (int i = 0; i < entrevistaController.retornaTamanho(); i++) {
			entrevista = entrevistaController.recuperar(i);
			curriculo = curriculoController.recuperar(i);
			int pos = inscricaoController.contem(Long.parseLong(entrevista.getId().toString()),
					Integer.parseInt(entrevista.getId().toString()));
			if (pos > 0) {
				dados = inscricaoController.recuperar(pos - 1);
				candidato = candidatoController.recuperar(pos - 1);
				lista[i] = new DadosGerais(candidato.getNome(), // nome
						candidato.getCpf(), // cpf
						candidato.getRg(), // rg
						candidato.getDeficiencia(), // deficiencia
						candidato.getEmail(), // email
						curriculo.getGenero(), // genero
						curriculo.getIdade(), // idade
						entrevista.getDataEntrevista(), // dataEntrevista
						entrevista.getStatusEntrevista(), // statusEntrevista
						dados.getSemestreAno(), // semestreAno
						dados.getCurso(), // curso
						dados.getStatusCurriculo(), // statusCurriculo
						dados.getStatusInscricao(), // statusInscricao
						dados.getTurno() // turno
				);
			}
		}

//    	mergeSort(lista, 1, lista.length);
		return lista;
	}

	public static void mergeSort(DadosGerais[] a, int from, int to) {
		if (from == to) {
			return;
		}
		int mid = (from + to) / 2;

		mergeSort(a, from, mid);
		mergeSort(a, mid + 1, to);
		merge(a, from, mid, to);
	}

	public static void merge(DadosGerais[] a, int from, int mid, int to) {
		int n = to - from + 1;
		DadosGerais[] b = new DadosGerais[n];
		int i1 = from;
		int i2 = mid + 1;
		int j = 0;

		while (i1 <= mid && i2 <= to) {
			if (a[i1].getNome().compareTo(a[i2].getNome()) < 0) {
				b[j] = a[i1];
				i1++;
			} else {
				b[j] = a[i2];
				i2++;
			}
			j++;
		}
		while (i1 <= mid) {
			b[j] = a[i1];
			i1++;
			j++;
		}
		while (i2 <= to) {
			b[j] = a[i2];
			i2++;
			j++;
		}
		for (j = 0; j < n; j++) {
			a[from + j] = b[j];
		}
	}
}