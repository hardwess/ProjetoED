package model;
import java.util.Date;

public class Entrevista {
	private Long id;
	private String dataEntrevista;
	private int statusEntrevista;
	
	public Entrevista() {}
	
	public Entrevista(Long id, String dataEntrevista, int statusEntrevista) {
		super();
		this.id = id;
		this.dataEntrevista = dataEntrevista;
		this.statusEntrevista = statusEntrevista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataEntrevista() {
		return dataEntrevista;
	}

	public void setDataEntrevista(String dataEntrevista) {
		this.dataEntrevista = dataEntrevista;
	}

	public String getStatusEntrevista() {
		String status = "";
		if (this.statusEntrevista == 0) {
			status = "Reprovado";
		} else if (this.statusEntrevista == 1) {
			status = "Aprovado";
		} else if (this.statusEntrevista == 2) {
			status = "Pendente";
		}
		
		return status;
	}

	public void setStatusEntrevista(int statusEntrevista) {
		this.statusEntrevista = statusEntrevista;
	}

	@Override
	public String toString() {
		return id + ";" + dataEntrevista + ";" + statusEntrevista
				+ "\n";
	}
}