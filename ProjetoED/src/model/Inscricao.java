package model;
public class Inscricao {

	private Long id;
	private Entrevista entrevista;
	private Boolean statusCurriculo;
	private Long idCronograma;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Entrevista getEntrevista() {
		return entrevista;
	}
	
	public void setEntrevista(Entrevista entrevista) {
		this.entrevista = entrevista;
	}
	
	public Boolean getStatusCurriculo() {
		return statusCurriculo;
	}
	
	public void setStatusCurriculo(Boolean statusCurriculo) {
		this.statusCurriculo = statusCurriculo;
	}
	
	public Long getIdCronograma() {
		return idCronograma;
	}
	
	public void setIdCronograma(Long idCronograma) {
		this.idCronograma = idCronograma;
	}
	
}
