package mapas;

import java.math.BigInteger;

/*
 * Esta implementa��o de MapaDispersao n�o realiza o tratamento de colis�o.
 * @author Marcel Hugo
 * 
 * Altera��o feita por: 
 * 
 */

public class MapaDispersao<K, T> {

	private ObjetoMapa<K, T>[] tabela;

	public MapaDispersao(int quantidade) {
		BigInteger bi = BigInteger.valueOf(quantidade * 2);
		this.tabela = new ObjetoMapa[bi.nextProbablePrime().intValue()];
	}

	private int calcularHash(K chave) {
		// calcula �ndice do vetor
		return (chave.hashCode() & 0x7fffffff) % tabela.length;
		// & 0x7fffffff : esta opera��o bin�ria garante que o valor ser� positivo
	}

	public boolean inserir(K chave, T valor) {
		int index = calcularHash(chave);

		if (tabela[index] == null) { // se posi��o estiver vazia, guarda o par<chave,valor>
			ObjetoMapa<K, T> om = new ObjetoMapa<K, T>();
			om.setChave(chave);
			om.setValor(valor);
			tabela[index] = om;
			return true;
		} else { // j� possui um objeto na posi��o (colis�o)
			return false;
		}

	}

	public T buscar(K chave) {
		int index = calcularHash(chave);
		if (tabela[index] == null) {
			return null;
		}
		return tabela[index].getValor();
	}

	public T remover(K chave) {
		int index = calcularHash(chave);
		if (tabela[index] == null) {
			return null;
		}
		T temp = tabela[index].getValor();
		tabela[index] = null;
		return temp;
	}
}
