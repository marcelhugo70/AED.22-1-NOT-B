package lineares;

public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElementos;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProx(novo);
		}
		ultimo = novo;
		qtdElementos++;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		NoLista<T> p = primeiro;
		while (p != null) {
			resultado += p.getInfo() + ", ";
			p = p.getProx();
		}
		return resultado + "]";
	}

	@Override
	public int buscar(T valor) {
		int indice = 0;
		NoLista p = primeiro;
		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return indice;
			}
			p = p.getProx();
			indice++;
		}
		return -1;
	}

	@Override
	public boolean estaVazia() {
		return primeiro == null;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;

		while (p != null && !p.getInfo().equals(valor)) {
			anterior = p;
			p = p.getProx();
		}
		if (p != null) { // significa que encontrou o elemento a ser retirado
			if (anterior == null) {
				primeiro = p.getProx();
			} else {
				anterior.setProx(p.getProx());
			}
			if (ultimo == p) {
				ultimo = anterior;
			}
			qtdElementos--;
		}

	}

	@Override
	public Lista<T> copiar() {
		Lista<T> listaCopia = new ListaEncadeada<>();
		NoLista<T> p = primeiro;
		while (p != null) {
			T valor = p.getInfo();
			listaCopia.inserir(valor);
			p = p.getProx();
		}
		return listaCopia;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return this.qtdElementos;
	}

	
	public Lista dividir2() { // Kaue e Pedro: manda a primeira metade para a outra lista
		Lista<T> nova = new ListaEncadeada<>();
		NoLista<T> iterador = primeiro;
		int metade = qtdElementos / 2;

		for (int idx = 0; idx < metade; ++idx) {
			nova.inserir(iterador.getInfo());
			iterador = iterador.getProx();
		}

		primeiro = iterador;
		qtdElementos = qtdElementos - metade;
		return nova;
	}

	public Lista<T> dividir() {  // Hiago: mant�m a primeira metade e manda a segunda metada para a nova lista
		int qtd = getTamanho() / 2;
		ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		NoLista<T> p = primeiro;
		int contador = 0;

		while (p != null) {
			++contador;
			if (contador > qtd)
				novaLista.inserir(p.getInfo());

			if (contador == qtd) {
				ultimo = p;
			}

			p = p.getProx();
		}
		ultimo.setProx(null);
		qtdElementos = qtd;
		return novaLista;
	}

	@Override
	public T pegar(int posicao) {
		if (posicao < 0 || posicao >= qtdElementos) {
			throw new IndexOutOfBoundsException("Index:" + posicao + " Size:" + qtdElementos);
		}
		int contador = 0;
		NoLista<T> p = primeiro;
		while (p != null) {
			if (contador == posicao) {
				return p.getInfo();
			}
			contador++;
			p = p.getProx();
		}
		return null; // nunca deveria chegar aqui
	}

}
