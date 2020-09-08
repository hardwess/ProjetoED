package model;
import java.awt.image.BufferedImage;

public class Curriculo {

	private Long id;
	private Boolean genero;
	private Integer idade;
	private Long CPF;
	private BufferedImage[] documentos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getGenero() {
		return genero;
	}
	
	public void setGenero(Boolean genero) {
		this.genero = genero;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Long getCPF() {
		return CPF;
	}
	
	public void setCPF(Long cPF) {
		CPF = cPF;
	}
	
	public BufferedImage[] getDocumentos() {
		return documentos;
	}
	
	public void setDocumentos(BufferedImage[] documentos) {
		this.documentos = documentos;
	}
	
}
