package arvores;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

	public NoArvoreBST(T info) {
		super(info);
	}

	public NoArvoreBST<T> buscar(T valor) {
		if (this.getInfo().equals(valor)) {
			return this;
		} else {
			if (valor.compareTo(this.getInfo()) < 0) {
				if (this.getEsq() == null) {
					return null;
				} else {
					return ((NoArvoreBST<T>) this.getEsq()).buscar(valor);
				}
			} else {
				if (this.getDir() == null) {
					return null;
				} else {
					return ((NoArvoreBST<T>) this.getDir()).buscar(valor);
				}
			}
		}
	}

	public void inserir(T info) {
		if (info.compareTo(this.getInfo()) < 0) {
			if (this.getEsq() == null) {
				this.setEsq(new NoArvoreBST<>(info));
			} else {
				((NoArvoreBST<T>) this.getEsq()).inserir(info);
			}
		} else {
			if (this.getDir() == null) {
				this.setDir(new NoArvoreBST<>(info));
			} else {
				((NoArvoreBST<T>) this.getDir()).inserir(info);
			}
		}
	}
}
