package algoritmos.alg_ordenacao;

public class BubbleSort {
    public void ordenar(int[] v) 
        {
        int n = v.length;
      
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (v[j] > v[j + 1]) {
                  
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
    }
}
