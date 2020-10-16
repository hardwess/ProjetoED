package controller;

import java.io.BufferedReader;
import java.io.FileReader;

import controller.dataStructure.list.Lista;
import model.Curriculo;

public class CurriculoController {
	public Lista<Curriculo> getListaCurriculo() {
		Lista<Curriculo> lista = new Lista<Curriculo>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\macie\\Documents\\FATEC 2020-2Semestre\\Estrutura de dados\\ProjetoED\\ProjetoED\\src\\data\\curriculo.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] curriculo = line.split(";");
		        lista.inserir(new Curriculo(
							        		Long.parseLong(curriculo[0]), //id
							        		curriculo[1].equals("0")? false : true,//genero
							        		Integer.parseInt(curriculo[2]), //idade
		        							Long.parseLong(curriculo[3]))); //cpf
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		return lista;
	}
	
	public static void main(String[] args) {
		CurriculoController cc = new CurriculoController();
		System.out.println(cc.getListaCurriculo().toString());
	}
}
