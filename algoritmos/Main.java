package algoritmos;
import java.io.*;

import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        int n_args = Integer.parseInt(args[1]); //numero de argumentos
        int[] vetor = new int[n_args]; //inicializado array de argumentos
        String nomeFicheiro = args[0]; //nome do ficheiro a ler

        //ler o ficheiro e guardar os valores no array
        Leitura leitura = new Leitura();
        vetor = leitura.ler(nomeFicheiro, n_args);

        //ordenar o array com o algoritmo bubble sort
        BubbleSort alg = new BubbleSort();
        alg.ordenar(vetor);
        System.out.println(Arrays.toString(vetor));

        //escrever o array ordenado no ficheiro de saida
    }
}


