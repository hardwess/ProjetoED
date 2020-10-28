package model;

public class Candidato {
	private Long idCandidato;
	private Long idCurriculo;
	private Long idInscricao;
	private String nome;
	private String cpf;
	private String rg;
	private String deficiencia;
	private String email;
	
	public Candidato(Long idCandidato, Long idCurriculo, Long idInscricao, String nome, String cpf, String rg, String deficiencia,
			String email) {
		this.idCandidato = idCandidato;
		this.idCurriculo = idCurriculo;
		this.idInscricao = idInscricao;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.deficiencia = deficiencia;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}

	@Override
	public String toString() {
		return "Candidato [idCurriculo=" + idCurriculo + ", idInscricao=" + idInscricao + ", nome=" + nome + ", cpf="
				+ cpf + ", rg=" + rg + ", deficiencia=" + deficiencia + ", email=" + email + "]";
	}
}