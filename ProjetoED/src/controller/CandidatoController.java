package controller;

import java.io.BufferedReader;
import java.io.FileReader;

import controller.dataStructure.list.Lista;
import model.Candidato;
import model.Inscricao;

public class CandidatoController {
	Lista<Candidato> lista = new Lista<Candidato>();
	
	public Lista<Candidato> getListaCandidato() {
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\Desenvolvimento\\ProjetoED\\ProjetoED\\src\\data\\candidato.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] candidato = line.split(";");
		        Candidato data = new Candidato(Long.parseLong(candidato[0]), Long.parseLong(candidato[1]), Long.parseLong(candidato[2]),
		        		candidato[3], candidato[4], candidato[5], candidato[6], candidato[7]);
		        lista.inserir(data);
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}
	
	public Candidato recuperar(int posicao) {
		return lista.recuperar(posicao);
	}
	
	public static void main(String[] args) {
		CandidatoController cc = new CandidatoController();
		System.out.println(cc.getListaCandidato().toString());
	}
}