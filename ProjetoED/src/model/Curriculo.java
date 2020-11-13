package model;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Curriculo {
	private Long id;
	private Boolean genero;
	private Integer idade;
	private Long cPF;
	private BufferedImage[] documentos;
	
	public Curriculo(Long id, Boolean genero, Integer idade, Long cPF) {
		this.id = id;
		this.genero = genero;
		this.idade = idade;
		this.cPF = cPF;
	}

	public Long getcPF() {
		return cPF;
	}

	public void setcPF(Long cPF) {
		this.cPF = cPF;
	}

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
		return cPF;
	}
	
	public void setCPF(Long cPF) {
		cPF = cPF;
	}
	
	public BufferedImage[] getDocumentos() {
		return documentos;
	}
	
	public void setDocumentos(BufferedImage[] documentos) {
		this.documentos = documentos;
	}

	@Override
	public String toString() {
		return id + ";" + (genero? "1" : "0") + ";" + idade + ";" + cPF+"\n";
	}
	
	
}