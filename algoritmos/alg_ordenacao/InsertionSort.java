package algoritmos.alg_ordenacao;

public class InsertionSort {
    public void ordenar(int[] v) {
        int n = v.length;
        for (int i = 1; i < n; ++i) {
            int chave = v[i];
            int j = i - 1;

            // Move os elementos de v[0..i-1], que são maiores que a chave,
            // para uma posição à frente de sua posição atual
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = chave;
        }
    }
}