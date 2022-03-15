package lineares;

public class ListaEncadeada implements Lista {
	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdElementos;
	
	@Override
	public void inserir(int valor) {
		NoLista novo = new NoLista();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		}
		else {
			ultimo.setProx(novo);
		}
		ultimo = novo;
		qtdElementos++;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		NoLista p = primeiro;
		while (p != null) {
			resultado += p.getInfo()+", ";
			p = p.getProx();
		}
		return resultado+"]";
	}

	@Override
	public int buscar(int valor) {
		int indice = 0;
		NoLista p = primeiro;
		while (p != null) {
			if (p.getInfo() == valor) {
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
	public void retirar(int valor) {
		NoLista anterior = null;
		NoLista p = primeiro;
		
		while (p!=null && p.getInfo()!=valor) {
			anterior = p;
			p = p.getProx();
		}
		if (p!=null) { // significa que encontrou o elemento a ser retirado
			if (anterior == null) {
				primeiro = p.getProx();
			}
			else {
				anterior.setProx(p.getProx());
			}
			if (ultimo == p) {
				ultimo = anterior;
			}
		}

	}

	@Override
	public Lista copiar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void concatenar(Lista outraLista) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Lista dividir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pegar(int posicao) {
		// TODO Auto-generated method stub
		return 0;
	}

}
