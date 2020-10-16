package model;

public class Candidato {
	private Long idCurriculo;
	private Long idInscricao;
	private String email;
	
	public Candidato(Long idCurriculo, Long idInscricao, String email) {
		super();
		this.idCurriculo = idCurriculo;
		this.idInscricao = idInscricao;
		this.email = email;
	}

	public Long getIdCurriculo() {
		return idCurriculo;
	}
	
	public void setIdCurriculo(Long idCurriculo) {
		this.idCurriculo = idCurriculo;
	}
	
	public Long getIdInscricao() {
		return idInscricao;
	}
	
	public void setIdInscricao(Long idInscricao) {
		this.idInscricao = idInscricao;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		email = email;
	}
	
	private void AlterarIncrição() {
		
	}
	
	private void SolicitarRecurso() {
		
	}

	@Override
	public String toString() {
		return "Candidato [idCurriculo=" + idCurriculo + ", idInscricao=" + idInscricao + ", email=" + email + "]";
	}
}