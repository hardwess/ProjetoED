package controller;

import java.io.BufferedReader;
import java.io.FileReader;

import controller.dataStructure.list.Lista;
import model.Candidato;

public class CandidatoController {
	public Lista<Candidato> getListaCandidato() {
		Lista<Candidato> lista = new Lista<Candidato>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\macie\\Documents\\FATEC 2020-2Semestre\\Estrutura de dados\\ProjetoED\\ProjetoED\\src\\data\\candidato.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] candidato = line.split(";");
		        lista.inserir(new Candidato(Long.parseLong(candidato[0]), Long.parseLong(candidato[1]), candidato[2]));
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}
	
	public static void main(String[] args) {
		CandidatoController cc = new CandidatoController();
		System.out.println(cc.getListaCandidato().toString());
	}
}