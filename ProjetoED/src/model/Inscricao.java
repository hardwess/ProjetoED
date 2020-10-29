package model;

import java.util.Arrays;

public class Inscricao {
	private Long idCandidato;
	private String semestreAno;
	private String curso;
	private Entrevista entrevista;
	private Boolean statusCurriculo;
	private Boolean statusInscricao;
	
	public Inscricao() {}

	public Inscricao(Long idCandidato, String curso, String semestreAno, Entrevista entrevista, Boolean statusCurriculo,
			Boolean statusInscricao) {
		this.idCandidato = idCandidato;
		this.semestreAno = semestreAno;
		this.entrevista = entrevista;
		this.statusCurriculo = statusCurriculo;
		this.statusInscricao = statusInscricao;
		this.curso = curso;
	}

	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}

	public String getSemestreAno() {
		return semestreAno;
	}

	public void setSemestreAno(String semestreAno) {
		this.semestreAno = semestreAno;
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

	public Boolean getStatusInscricao() {
		return statusInscricao;
	}

	public void setStatusInscricao(Boolean statusInscricao) {
		this.statusInscricao = statusInscricao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return idCandidato + ";" + semestreAno + ";" + entrevista
				+ ";" + statusCurriculo + ";" + statusInscricao + ";"
				+ curso + "\n";
	}
}