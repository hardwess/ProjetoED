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
		        lista.inserir(new Inscricao(Long.parseLong(inscricao[0]),//id
		        										null, //entrevista
		        										inscricao[2].equals("0")? false : true, //statusCurriculo
		        										Long.parseLong(inscricao[3]))); //idCronograma
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
	
	public static void main(String[] args) {
		InscricaoController cc = new InscricaoController();
		System.out.println(cc.getListaInscricao().toString());
	}
}	
