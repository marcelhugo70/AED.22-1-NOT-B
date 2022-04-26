package arvores;

public class ArvoreBinaria<T> { // contribuição da Júlia
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public void setRaiz(NoArvoreBinaria<T> no) {
		this.raiz = no;
	}

	public boolean vazia() {
		return this.raiz == null;
	}

	public NoArvoreBinaria<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		} else {
			return this.raiz.pertence(info);
		}
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		} else {
			return this.raiz.imprimePre();
		}
	}
}
