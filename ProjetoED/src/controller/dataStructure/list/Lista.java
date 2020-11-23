package controller.dataStructure.list;

import javax.swing.JOptionPane;

import model.Candidato;
import model.Entrevista;
import model.Inscricao;

public class Lista<T> {
	private No<T> primeiroNo;
	private No<T> ultimoNo;
	private int tamanho;
	private Inscricao[] data;
	private Entrevista[] entrevista;
	private String resultSearch;
	private int posicaoEncontrada;
	
	public Lista(){
		this.primeiroNo = null;
		this.ultimoNo = null;
		this.tamanho = 0;
	}
	
	public void inserir(T valor) {
		No<T> novoNo = new No<T>(valor);
		if(estaVazia()) {
			this.primeiroNo = novoNo;
			this.ultimoNo = novoNo;
		} else {
			this.ultimoNo.setProximo(novoNo);
			this.ultimoNo = novoNo; 
		}
		this.tamanho++;
	}
	
	public void inserirEm(int posicao, T valor) {
		if(posicao >= tamanho()) {
			throw new IllegalArgumentException(String.format("Posica��o inv�lida [%d]", posicao));
		}
		if(posicao == 0) {
			No<T> novoNo = new No<T>(valor);
			novoNo.setProximo(this.primeiroNo);
			this.primeiroNo = novoNo;
		} else if(posicao == this.tamanho()-1){
			No<T> novoNo = new No<T>(valor);
			this.ultimoNo.setProximo(novoNo);
			this.ultimoNo = novoNo;
		} else {
			No<T> noAnterior = buscarNo(posicao -1);
			No<T> noAtual = buscarNo(posicao);
			No<T> novoNo = new No<>(valor);
			noAnterior.setProximo(novoNo);
			novoNo.setProximo(noAtual);
		}
		this.tamanho++;
	}
	
	public void inserirPrimeiro(T valor) {
		inserirEm(0, valor);
	}
	
	public void inserirUltimo(T valor) {
		inserirEm(tamanho-1, valor);
	}
	
	public T recuperar(int posicao) {
		No<T> no = buscarNo(posicao);
		if(no!= null) {
			return no.getValor();
		} else {
			return null;
		}
	}
	
	private No<T> buscarNo(int posicao) {
		if(posicao >= tamanho()) {
			throw new IllegalArgumentException(String.format("Posica��o inv�lida [%d]", posicao));
		}
		No<T> resultado = null;
		for(int i=0;i<=posicao;i++) {
			if(i==0) {
				resultado = this.primeiroNo;
			} else {
				resultado = resultado.getProximo();
			}
		}
		return resultado;
	}
	
	public boolean estaVazia() {
		return this.tamanho == 0;
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
	public boolean contem(T valor) {
		for(int i=0;i<tamanho();i++) {
			No<T> noAtual = buscarNo(i);
			if(noAtual.getValor() != null && noAtual.getValor().equals(valor)) {
				return true;
			}
		}
		return false;
	}
	
	public int indice(T valor) {
		for(int i=0;i<tamanho();i++) {
			No<T> noAtual = buscarNo(i);
			if(noAtual.getValor() != null && noAtual.getValor().equals(valor)) {
				return i;
			}
		}
		return -1;
	}
	
	public void remover(int posicao) {
		if(posicao >= tamanho()) {
			throw new IllegalArgumentException(String.format("Posica��o inv�lida [%d]", posicao));
		}
		if(posicao==0) {
			No<T> proximoNo = this.primeiroNo.getProximo();
			this.primeiroNo.setProximo(null);
			this.primeiroNo = proximoNo;			
		} else if(posicao==tamanho()-1){
			No<T> penultimoNo = buscarNo(tamanho()-2);
			penultimoNo.setProximo(null);
			this.ultimoNo = penultimoNo;
		} else {
			No<T> noAnterior = buscarNo(posicao -1);
			No<T> proximoNo = buscarNo(posicao + 1);
			No<T> noAtual = buscarNo(posicao);
			noAnterior.setProximo(proximoNo);
			noAtual.setProximo(null);
		}
		this.tamanho--;
	}
	
	public void remover(T valor) {
		int indice = indice(valor);
		if(indice==-1) {
			throw new IllegalArgumentException(String.format("valor inv�lido - " + valor.toString()));
		}
		remover(indice);
	}
	
	public int buscaSequencial(Long id, int count, int n, boolean found) {
		data = convertToVectorInscricao();

		if (data != null && found == false) {
			if (!id.equals(data[count].getIdCandidato()) && count < n-1 && found == false) {
				count += 1;
				buscaSequencial(id, count, n, false);
			} else if (id.equals(data[count].getIdCandidato())) {
				found = true;
				posicaoEncontrada = count + 1;
				resultSearch = "A inscri��o foi encontrada na posi��o: " + posicaoEncontrada + "\n";
				return posicaoEncontrada;
			} else if (found == false) {
				resultSearch = "Inscri��o n�o encontrada. Tente novamente.";
				JOptionPane.showMessageDialog(null, resultSearch);
			}
		}
		
		return posicaoEncontrada;
	}
	
	public Inscricao[] convertToVectorInscricao() {
		No auxl = primeiroNo;
		int count = 0;
		int size = tamanho();
		Inscricao[] data = new Inscricao[size];
		while (auxl != null) {
			data[count] = (Inscricao) auxl.getValor();
			auxl = auxl.getProximo();
			count++;
		}

		return data;
	}
	
	public Entrevista[] convertToVectorEntrevista() {
		No auxl = primeiroNo;
		int count = 0;
		int size = tamanho();
		Entrevista[] data = new Entrevista[size];
		while (auxl != null) {
			data[count] = (Entrevista) auxl.getValor();
			auxl = auxl.getProximo();
			count++;
		}

		return data;
	}
	
	public int buscaSequencialEntrevista(Long id, int count, int n, boolean found) {
		entrevista = convertToVectorEntrevista();

		if (entrevista != null && found == false) {
			if (!id.equals(entrevista[count].getId()) && count < n-1 && found == false) {
				count += 1;
				buscaSequencialEntrevista(id, count, n, false);
			} else if (id.equals(entrevista[count].getId())) {
				found = true;
				posicaoEncontrada = count + 1;
				resultSearch = "A entrevista foi encontrada na posi��o: " + posicaoEncontrada + "\n";
				return posicaoEncontrada;
			} else if (found == false) {
				resultSearch = "Entrevista n�o encontrada. Tente novamente.";
				JOptionPane.showMessageDialog(null, resultSearch);
			}
		}
		
		return posicaoEncontrada;
	}
	
	public void substituir(int pos, T valor) {
		int count = 1;
		
		if (pos == 0) {
			this.primeiroNo.setValor(valor);
			System.out.println("VALOR 0 " + this.primeiroNo.getValor());
		} else {
			No<T> aux = primeiroNo.getProximo();
			if (aux != null) {
				while (count != pos) {
					count++;
					aux = aux.getProximo();
					/**System.out.println("VALOR " + aux.getValor());**/
				}
				
				if (count == pos) {
					aux.setValor(valor);
					/**System.out.println("VALOR 1 " + aux.getValor());**/
				}
			}
		}
	}
	
	public String montaTxt() {
		if(estaVazia()) {
			return "Sem informa��es";
		} else {
			No aux = primeiroNo;
			String r = "";
			while(aux!=null){
				r=r+aux.getValor();
				aux=aux.getProximo();
			}
			return r.toString();
		}
	}
	
	@Override
	public String toString() {
		if(estaVazia()) {
			return "Lista []";
		} else {
			No<T> noAtual = this.primeiroNo;
			StringBuffer sb = new StringBuffer();
			sb.append("Lista [");
			sb.append(noAtual.getValor() != null ? noAtual.getValor().toString() : "<NULO>");
			sb.append(",");
			while(noAtual.getProximo() != null) {
				sb.append(noAtual.getProximo().getValor() != null ? noAtual.getProximo().getValor().toString() : "<NULO>");
				sb.append(",");
				noAtual = noAtual.getProximo(); //trocando refer�ncia
				}
			sb.append("]");
			return sb.toString();
		}
	}
}