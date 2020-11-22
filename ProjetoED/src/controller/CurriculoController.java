package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import controller.dataStructure.list.Lista;
import model.Curriculo;

public class CurriculoController {
	Lista<Curriculo> lista = new Lista<Curriculo>();
	final Path path = Paths.get("D:\\\\Desenvolvimento\\\\ProjetoED\\\\ProjetoED\\\\src\\\\data\\curriculo.txt");
	public Lista<Curriculo> getListaCurriculo() {		
		try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] curriculo = line.split(";");
		        lista.inserir(new Curriculo(
							        		Long.parseLong(curriculo[0]), //id
							        		curriculo[1],//genero
							        		Integer.parseInt(curriculo[2]), //idade
		        							Long.parseLong(curriculo[3]))); //cpf
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}
	
	public void saveListCurriculo(Lista<Curriculo> lista) {
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
	
	public Curriculo recuperar(int posicao) {
		return lista.recuperar(posicao);
	}
	
	public int retornaTamanho() {
		return lista.tamanho();
	}
	
	public boolean estaVazia() {
		return lista.estaVazia();
	}
	
	public static void main(String[] args) {
		CurriculoController cc = new CurriculoController();
//		System.out.println(cc.getListaCurriculo().montaTxt());
		cc.saveListCurriculo(cc.getListaCurriculo());
	}
}
