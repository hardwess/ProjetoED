package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import controller.dataStructure.list.Lista;
import model.Candidato;
import model.Inscricao;

public class InscricaoController {
	final Path path = Paths.get("D:\\Desenvolvimento\\ProjetoED\\ProjetoED\\src\\data\\inscricao.txt");
	Lista<Inscricao> lista = new Lista<Inscricao>();
	
	public Lista<Inscricao> getListaInscricao() {
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] inscricao = line.split(";");
		        Inscricao data = new Inscricao(Long.parseLong(inscricao[0]), inscricao[2], inscricao[1], null, Integer.parseInt(inscricao[4]),
		        		Integer.parseInt(inscricao[5]), inscricao[6]);
		        lista.inserir(data);
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}
	
	public void saveListInscricao(String lista) {
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
	
	public int retornaTamanho() {
		return lista.tamanho();
	}
	
	public boolean estaVazia() {
		return lista.estaVazia();
	}
	
	public Inscricao recuperar(int posicao) {
		return lista.recuperar(posicao);
	}
	
	public int contem(Long id, int row) {
		return lista.buscaSequencial(id, 0, row+1, false);
	}
	
	public void substituir(int pos, Inscricao e) {
		this.lista.substituir(pos, e);
	}
	
	public String montaTxt() {
		return this.lista.montaTxt();
	}
	
	public static void main(String[] args) {
		InscricaoController cc = new InscricaoController();
		System.out.println(cc.getListaInscricao().toString());
	}
}	
