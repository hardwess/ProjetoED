package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import controller.dataStructure.list.Lista;
import model.Candidato;
import model.Entrevista;

public class EntrevistaController {
	final Path path = Paths.get("C:\\Users\\macie\\Documents\\FATEC 2020-2Semestre\\Estrutura de dados\\ProjetoED\\ProjetoED\\src\\data\\candidato.txt");
	public Lista<Entrevista> getListaEntrevista() {
		Lista<Entrevista> lista = new Lista<Entrevista>();
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] entrevista = line.split(";");
		        lista.inserir(new Entrevista(
		        							Long.parseLong(entrevista[0]),//id
		        							new SimpleDateFormat("dd-MM-yyyy").parse(entrevista[1]), //dataEntrevista
		        							entrevista[2].contentEquals("0") ? false : true)); //statusEntrevista
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}
	
	public void saveListCandidato(Lista<Entrevista> lista) {
		try {
			BufferedWriter bw = null;
			File file = new File(path.toString());
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(lista.montaTxt());
			bw.close();
			
		} catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		EntrevistaController cc = new EntrevistaController();
		System.out.println(cc.getListaEntrevista().toString());
	}
}
