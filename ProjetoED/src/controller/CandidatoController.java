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
import model.Curriculo;
import model.Inscricao;

public class CandidatoController {
	final Path path = Paths.get("D:\\Desenvolvimento\\ProjetoED\\ProjetoED\\src\\data\\candidato.txt");
	Lista<Candidato> lista = new Lista<Candidato>();
	
	public Lista<Candidato> getListaCandidato() {
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
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
	
	public void saveListCandidato(Lista<Candidato> lista) {
		try {
			BufferedWriter bw = null;
			File file = new File("C:\\Users\\macie\\Documents\\FATEC 2020-2Semestre\\Estrutura de dados\\ProjetoED\\ProjetoED\\src\\data\\candidatoTeste.txt");
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(lista.montaTxt());
			bw.close();
			
		} catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		CandidatoController cc = new CandidatoController();
		System.out.println(cc.getListaCandidato().toString());
		cc.saveListCandidato(cc.getListaCandidato());
	}
}