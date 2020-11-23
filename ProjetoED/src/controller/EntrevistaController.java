package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.dataStructure.list.Lista;
import model.Candidato;
import model.Curriculo;
import model.Entrevista;
import model.Inscricao;

public class EntrevistaController {
	Lista<Entrevista> lista = new Lista<Entrevista>();
	final Path path = Paths.get("C:\\Users\\macie\\Documents\\FATEC 2020-2Semestre\\Estrutura de dados\\ProjetoED\\ProjetoED\\src\\data\\entrevista.txt");
	
	public Lista<Entrevista> getListaEntrevista() {
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] entrevista = line.split(";");
		        lista.inserir(new Entrevista(
		        							Long.parseLong(entrevista[0]),//id
		        							entrevista[1], //dataEntrevista
		        							Integer.parseInt(entrevista[2]))); //statusEntrevista
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}
	
	public void saveListCandidato(String lista) {
		try {
			BufferedWriter bw = null;
			File file = new File(path.toString());
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(lista);
			bw.close();
			
		} catch(Exception e) {
			
		}
	}
	
	public void inserirEntrevista(Entrevista entrevista) {
		getListaEntrevista();
		if (estaVazia()) {
			lista.inserir(entrevista);
		} else {
			lista.inserirUltimo(entrevista);
		}
	}
	
	public int contem(Long id, int row) {
		return lista.buscaSequencialEntrevista(id, 0, row+1, false);
	}
	
	public String montaTxt() {
		return this.lista.montaTxt();
	}
	
	public Entrevista recuperar(int posicao) {
		return lista.recuperar(posicao);
	}
	
	public boolean estaVazia() {
		return lista.estaVazia();
	}
	
	public int retornaTamanho() {
		return lista.tamanho();
	}
	
	public void substituir(int pos, Entrevista e) {
		this.lista.substituir(pos, e);
	}
	
	public static void main(String[] args) {
		EntrevistaController cc = new EntrevistaController();
		System.out.println(cc.getListaEntrevista().toString());
	}
}
