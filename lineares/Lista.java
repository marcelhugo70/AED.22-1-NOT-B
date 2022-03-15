package lineares;

public interface Lista {
	void inserir(int valor);
	String exibir();
	int buscar(int valor);
	boolean estaVazia();
	void retirar(int valor);
	Lista copiar();
	void concatenar(Lista outraLista);
	int getTamanho();
	Lista dividir();
	int pegar(int posicao);
}