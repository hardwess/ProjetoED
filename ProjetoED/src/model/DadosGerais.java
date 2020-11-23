package model;

public class DadosGerais {
	private String nome;
	private String cpf;
	private String rg;
	private String deficiencia;
	private String email;
	private String genero;
	private int idade;
	private String dataEntrevista;
	private String statusEntrevista;
	private String semestreAno;
	private String curso;
	private String statusCurriculo;
	private String statusInscricao;
	private String turno;
	
	public DadosGerais(String nome, String cpf, String rg, String deficiencia, String email, String genero,
			int idade, String dataEntrevista, String statusEntrevista, String semestreAno, String curso,
			String statusCurriculo, String statusInscricao, String turno) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.deficiencia = deficiencia;
		this.email = email;
		this.genero = genero;
		this.idade = idade;
		this.dataEntrevista = dataEntrevista;
		this.statusEntrevista = statusEntrevista;
		this.semestreAno = semestreAno;
		this.curso = curso;
		this.statusCurriculo = statusCurriculo;
		this.statusInscricao = statusInscricao;
		this.turno = turno;
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getDataEntrevista() {
		return dataEntrevista;
	}
	public void setDataEntrevista(String dataEntrevista) {
		this.dataEntrevista = dataEntrevista;
	}
	public String getStatusEntrevista() {
		return statusEntrevista;
	}
	public void setStatusEntrevista(String statusEntrevista) {
		this.statusEntrevista = statusEntrevista;
	}
	public String getSemestreAno() {
		return semestreAno;
	}
	public void setSemestreAno(String semestreAno) {
		this.semestreAno = semestreAno;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getStatusCurriculo() {
		return statusCurriculo;
	}
	public void setStatusCurriculo(String statusCurriculo) {
		this.statusCurriculo = statusCurriculo;
	}
	public String getStatusInscricao() {
		return statusInscricao;
	}
	public void setStatusInscricao(String statusInscricao) {
		this.statusInscricao = statusInscricao;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	@Override
	public String toString() {
		return "DadosGerais [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", deficiencia=" + deficiencia + ", email="
				+ email + ", genero=" + genero + ", idade=" + idade + ", dataEntrevista=" + dataEntrevista
				+ ", statusEntrevista=" + statusEntrevista + ", semestreAno=" + semestreAno + ", curso=" + curso
				+ ", statusCurriculo=" + statusCurriculo + ", statusInscricao=" + statusInscricao + ", turno=" + turno
				+ "]";
	}
}
