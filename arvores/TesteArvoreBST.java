package arvores;

public class TesteArvoreBST {

	public static void main(String[] args) {
		ArvoreBST<String> arvBusca = new ArvoreBST<>();
		arvBusca.inserir("Joana");
		arvBusca.inserir("Joao");
		arvBusca.inserir("Carlos");
		arvBusca.inserir("Zeca");
		arvBusca.inserir("Ana");
		arvBusca.inserir("Danilo");
		arvBusca.inserir("Yuri");
		arvBusca.inserir("José");
		arvBusca.inserir("Patricia");
		arvBusca.inserir("Maria");

		
		System.out.println("Null->"+arvBusca.buscar("Pedro"));
		System.out.println("Danilo ->"+arvBusca.buscar("Danilo").getInfo());
		System.out.println("Maria ->"+arvBusca.buscar("Maria").getInfo());
		System.out.println(arvBusca);
	}

}
