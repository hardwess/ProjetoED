package model;
import java.util.Date;

public class Entrevista {
	private Long id;
	private Date dataEntrevista;
	private Boolean statusEntrevista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEntrevista() {
		return dataEntrevista;
	}

	public void setDataEntrevista(Date dataEntrevista) {
		this.dataEntrevista = dataEntrevista;
	}

	public Boolean getStatusEntrevista() {
		return statusEntrevista;
	}

	public void setStatusEntrevista(Boolean statusEntrevista) {
		this.statusEntrevista = statusEntrevista;
	}
}