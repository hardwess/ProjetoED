package controller;

import java.io.BufferedReader;
import java.io.FileReader;

import controller.dataStructure.list.Lista;
import model.Inscricao;

public class InscricaoController {
	Lista<Inscricao> lista = new Lista<Inscricao>();
	public Lista<Inscricao> getListaInscricao() {
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\Desenvolvimento\\ProjetoED\\ProjetoED\\src\\data\\inscricao.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] inscricao = line.split(";");
		        Inscricao data = new Inscricao(Long.parseLong(inscricao[0]), inscricao[2], inscricao[1], null, inscricao[4].equals("0")? false : true,
		        		inscricao[5].equals("0")? false : true);
		        lista.inserir(data);
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
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
