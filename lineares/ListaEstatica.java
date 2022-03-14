package lineares;

public class ListaEstatica {
	private int[] info;
	private int tamanho;

	public ListaEstatica() {
		info = new int[10];
		tamanho = 0;
	}

	public void inserir(int valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	private void redimensionar() {
		int[] novo = new int[tamanho + 10];
		for (int i = 0; i < tamanho; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}

	public String exibir() {
		String resultado = "[";
		for (int i = 0; i < tamanho; i++) {
			resultado += info[i] + ", ";
		}
		return resultado + "]";
	}

	public int buscar(int valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}

	public boolean estaVazia() {
		return (tamanho == 0);
	}

	public void retirar(int valor) {
		int posicao = this.buscar(valor);

		if (posicao != -1) {
			for (int idx = posicao; idx < tamanho - 1; idx++) {
				info[idx] = info[idx + 1];
			}
			tamanho--;
		}
	}

	public ListaEstatica copiar() {
		ListaEstatica novaLista = new ListaEstatica();

		for (int idx = 0; idx < tamanho; idx++)
			novaLista.inserir(info[idx]);

		return novaLista;
	}

	public void concatenar(ListaEstatica outraLista) {
		for (int idx = 0; idx < outraLista.getTamanho(); idx++)
			this.inserir(outraLista.info[idx]); // a pensar
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public ListaEstatica dividir() {
		ListaEstatica novaLista = new ListaEstatica();

		int tamanhoOriginal = tamanho;
		int metadeLista = tamanho / 2;

		for (int idx = metadeLista; idx < tamanhoOriginal; idx++)
			novaLista.inserir(info[idx]);

		this.tamanho = metadeLista;

		return novaLista;
	}
}
