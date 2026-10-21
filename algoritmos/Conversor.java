package algoritmos;

import algoritmos.R_W.Escrita;
import algoritmos.R_W.Leitura;

public class Conversor {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[1]);
        int[] vetor = new Leitura().ler_txt(args[0], n);
        new Escrita().escrever_bin(args[2], vetor);
    }
}
