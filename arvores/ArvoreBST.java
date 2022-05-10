package arvores;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public NoArvoreBST<T> buscar(T valor) {
		if (this.vazia()) {
			return null;
		}
		return ((NoArvoreBST<T>) this.getRaiz()).buscar(valor);
	}

	public void inserir(T info) {
		if (this.vazia()) {
			this.setRaiz(new NoArvoreBST<>(info));
		} else {
			((NoArvoreBST<T>) this.getRaiz()).inserir(info);
		}
	}

	public void retirar(T valor) {
		NoArvoreBST<T> noARetirar = this.buscar(valor);
		if (noARetirar == null) {
			return;
		}

		NoArvoreBST<T> pai = this.descobrirPai(noARetirar);
		
		if (noARetirar.ehFolha()) { // caso 1
			if (pai == null) {  // nó a retirar é raiz
				
			}
			else {
				
			}
		} else {
			if (noARetirar.temUmFilho()) { // caso 2
				if (pai == null) {  // nó a retirar é raiz
					
				}
				else {
					
				}
			}
			else { //caso 3
				if (pai == null) {  // nó a retirar é raiz
					
				}
				else {
					
				}
			}
		}

	}

	private NoArvoreBST<T> descobrirPai(NoArvoreBST<T> noARetirar) {
		if (noARetirar == this.getRaiz()) {
			return null;
		}
		NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();

		while (noPai.getDir() != noARetirar && noPai.getEsq() != noARetirar) {
			if (noARetirar.getInfo().compareTo(noPai.getInfo()) < 0) {
				noPai = (NoArvoreBST<T>) noPai.getEsq();
			} else {
				noPai = (NoArvoreBST<T>) noPai.getDir();
			}
		}

		return noPai;
	}


	public NoArvoreBST<T> buscarPai(T valor) {  // uma alternativa recursiva ao descobrirPai
		if (this.vazia()) {
			return null;
		}
		return ((NoArvoreBST<T>) this.getRaiz()).buscarPai(valor, null);
	}
}
