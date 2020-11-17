package model;

import java.util.Arrays;

public class Inscricao {
	private Long idCandidato;
	private String semestreAno;
	private String curso;
	private Entrevista entrevista;
	private int statusCurriculo;
	private int statusInscricao;
	private String turno;
	
	public Inscricao() {}

	public Inscricao(Long idCandidato, String curso, String semestreAno, Entrevista entrevista, int statusCurriculo,
			int statusInscricao, String turno) {
		this.idCandidato = idCandidato;
		this.semestreAno = semestreAno;
		this.entrevista = entrevista;
		this.statusCurriculo = statusCurriculo;
		this.statusInscricao = statusInscricao;
		this.curso = curso;
		this.turno = turno;
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

	public String getStatusCurriculo() {
		String status = "";
		if (this.statusCurriculo == 0) {
			status = "Reprovado";
		} else if (this.statusCurriculo == 1) {
			status = "Aprovado";
		} else if (this.statusCurriculo == 2) {
			status = "Pendente";
		}
		
		return status;
	}

	public void setStatusCurriculo(int statusCurriculo) {
		this.statusCurriculo = statusCurriculo;
	}

	public String getStatusInscricao() {
		String status = "";
		if (this.statusInscricao == 0) {
			status = "Reprovado";
		} else if (this.statusInscricao == 1) {
			status = "Aprovado";
		} else if (this.statusInscricao == 2) {
			status = "Pendente";
		}
		
		return status;
	}

	public void setStatusInscricao(int statusInscricao) {
		this.statusInscricao = statusInscricao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return idCandidato + ";" + semestreAno + ";" + curso
				+ ";" + entrevista + ";" + statusCurriculo + ";"
				+ statusInscricao + ";" + turno + "\n";
	}
}