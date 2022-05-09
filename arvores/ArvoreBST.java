package arvores;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public NoArvoreBST<T> buscar(T valor){
		if (this.vazia()) {
			return null;
		}
		return ((NoArvoreBST<T>)this.getRaiz()).buscar(valor);
	}
	
	public void inserir(T info) {
		if (this.vazia()){
			this.setRaiz(new NoArvoreBST<>(info));
		}
		else {
			((NoArvoreBST<T>)this.getRaiz()).inserir(info);
		}
	}
}
