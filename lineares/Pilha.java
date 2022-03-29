package lineares;

public interface Pilha<T> {
	void push(T info);
	T pop();
	T peek();
	boolean estaVazia();
	void liberar();
}
