package arvores;

public abstract class ArvoreBinariaAbstract<T> { // contribui��o da J�lia
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinariaAbstract() {
		this.raiz = null;
	}

	protected void setRaiz(NoArvoreBinaria<T> no) {
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
	
	public NoArvoreBinaria<T> getRaiz(){
		return this.raiz;
	}
}
