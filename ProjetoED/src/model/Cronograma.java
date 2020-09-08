package model;
import java.util.Date;

public class Cronograma {

	private Long id;
	private Date DataInscricao;
	private Date DataCurriculo;
	private Date DataEntrevista;
	private Date DataResultadoPre;
	private Date DataResultado;
	private Date DataMatricula;
	private Date DataSegundaChamada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInscricao() {
		return DataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		DataInscricao = dataInscricao;
	}

	public Date getDataCurriculo() {
		return DataCurriculo;
	}

	public void setDataCurriculo(Date dataCurriculo) {
		DataCurriculo = dataCurriculo;
	}

	public Date getDataEntrevista() {
		return DataEntrevista;
	}

	public void setDataEntrevista(Date dataEntrevista) {
		DataEntrevista = dataEntrevista;
	}

	public Date getDataResultadoPre() {
		return DataResultadoPre;
	}

	public void setDataResultadoPre(Date dataResultadoPre) {
		DataResultadoPre = dataResultadoPre;
	}

	public Date getDataResultado() {
		return DataResultado;
	}

	public void setDataResultado(Date dataResultado) {
		DataResultado = dataResultado;
	}

	public Date getDataMatricula() {
		return DataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		DataMatricula = dataMatricula;
	}

	public Date getDataSegundaChamada() {
		return DataSegundaChamada;
	}

	public void setDataSegundaChamada(Date dataSegundaChamada) {
		DataSegundaChamada = dataSegundaChamada;
	}

}
