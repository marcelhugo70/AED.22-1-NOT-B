package ordenacao;

public class ClasseDeBusca<T> {
    public static <T extends Comparable<T>> int pesquisaBinaria(T[] info, T valorBuscar) {
        int inicio = 0;
        int fim = info.length - 1;
        while(inicio <= fim) {
            int meio = (inicio + fim)/2;
            if(valorBuscar.compareTo(info[meio]) < 0) {
                fim = meio - 1;
            }else if (valorBuscar.compareTo(info[meio]) > 0) {
                inicio = meio + 1;
            }else {
                 return meio;
            }
        }
        return -1;
    }
}
