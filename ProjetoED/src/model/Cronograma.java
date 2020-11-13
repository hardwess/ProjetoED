package model;
import java.util.Date;

public class Cronograma {
	private Long id;
	private Date dataInscricao;
	private Date dataCurriculo;
	private Date dataEntrevista;
	private Date dataResultadoPre;
	private Date dataResultado;
	private Date dataMatricula;
	private Date dataSegundaChamada;
	
	public Cronograma(Long id, Date dataInscricao, Date dataCurriculo, Date dataEntrevista, Date dataResultadoPre,
			Date dataResultado, Date dataMatricula, Date dataSegundaChamada) {
		super();
		this.id = id;
		this.dataInscricao = dataInscricao;
		this.dataCurriculo = dataCurriculo;
		this.dataEntrevista = dataEntrevista;
		this.dataResultadoPre = dataResultadoPre;
		this.dataResultado = dataResultado;
		this.dataMatricula = dataMatricula;
		this.dataSegundaChamada = dataSegundaChamada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		dataInscricao = dataInscricao;
	}

	public Date getDataCurriculo() {
		return dataCurriculo;
	}

	public void setDataCurriculo(Date dataCurriculo) {
		dataCurriculo = dataCurriculo;
	}

	public Date getDataEntrevista() {
		return dataEntrevista;
	}

	public void setDataEntrevista(Date dataEntrevista) {
		dataEntrevista = dataEntrevista;
	}

	public Date getDataResultadoPre() {
		return dataResultadoPre;
	}

	public void setDataResultadoPre(Date dataResultadoPre) {
		dataResultadoPre = dataResultadoPre;
	}

	public Date getDataResultado() {
		return dataResultado;
	}

	public void setDataResultado(Date dataResultado) {
		dataResultado = dataResultado;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		dataMatricula = dataMatricula;
	}

	public Date getDataSegundaChamada() {
		return dataSegundaChamada;
	}

	public void setDataSegundaChamada(Date dataSegundaChamada) {
		dataSegundaChamada = dataSegundaChamada;
	}

	@Override
	public String toString() {
		return id + ";" + dataInscricao + ";" + dataCurriculo
				+ ";" + dataEntrevista + ";" + dataResultadoPre + ";"
				+ dataResultado + ";" + dataMatricula + ";" + dataSegundaChamada
				+ "\n";
	}

	
}