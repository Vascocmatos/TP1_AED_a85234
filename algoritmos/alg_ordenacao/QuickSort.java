package algoritmos.alg_ordenacao;

public class QuickSort {
    public void ordenar(int[] v, int inicio, int fim) {
        //v --> array a ser ordenado
        //inicio --> índice inicial do array
        //fim --> índice final do array

        if (inicio < fim) {
            int pivo = particionar(v, inicio, fim);
            ordenar(v, inicio, pivo - 1);
            ordenar(v, pivo + 1, fim);
        }
    }

    private int particionar(int[] v, int inicio, int fim) {
        int pivo = v[fim];
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            // Se o elemento atual é menor ou igual ao pivô
            if (v[j] <= pivo) {
                i++;
                int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
            }
        }
        int temp = v[i + 1];
        v[i + 1] = v[fim];
        v[fim] = temp;
        return i + 1;
    }
}