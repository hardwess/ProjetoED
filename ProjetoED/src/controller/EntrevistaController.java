package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;

import controller.dataStructure.list.Lista;
import model.Entrevista;

public class EntrevistaController {
	public Lista<Entrevista> getListaEntrevista() {
		Lista<Entrevista> lista = new Lista<Entrevista>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\macie\\Documents\\FATEC 2020-2Semestre\\Estrutura de dados\\ProjetoED\\ProjetoED\\src\\data\\entrevista.txt"))) {
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
	
	public static void main(String[] args) {
		EntrevistaController cc = new EntrevistaController();
		System.out.println(cc.getListaEntrevista().toString());
	}
}
