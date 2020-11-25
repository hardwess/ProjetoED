package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.text.SimpleDateFormat;

import controller.dataStructure.list.Lista;
import model.Cronograma;

public class CronogramaController {
	public Lista<Cronograma> getListaCronograma() {
		Lista<Cronograma> lista = new Lista<Cronograma>();
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\Desenvolvimento\\ProjetoED\\ProjetoED\\src\\data\\cronograma.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] cronograma = line.split(";");
		        lista.inserir(new Cronograma(
		        					Long.parseLong(cronograma[0]), //id
		        					new SimpleDateFormat("dd-MM-yyyy").parse(cronograma[1]), //dataInscricao
		        					new SimpleDateFormat("dd-MM-yyyy").parse(cronograma[2]), //dataCurriculo
		        					new SimpleDateFormat("dd-MM-yyyy").parse(cronograma[3]), //dataEntrevista
		        					new SimpleDateFormat("dd-MM-yyyy").parse(cronograma[4]), //dataResultadoPre
		        					new SimpleDateFormat("dd-MM-yyyy").parse(cronograma[5]), //dataResultado
		        					new SimpleDateFormat("dd-MM-yyyy").parse(cronograma[6]), //dataMatricula
		        					new SimpleDateFormat("dd-MM-yyyy").parse(cronograma[7]))); //dataSegundaChamada
		    }
		    br.close();
		} catch (Exception e) {
			System.out.println("Erro");
		} 
		return lista;
	}
	
	public static void main(String[] args) {
		CronogramaController cc = new CronogramaController();
		System.out.println(cc.getListaCronograma().toString());
	}
}
