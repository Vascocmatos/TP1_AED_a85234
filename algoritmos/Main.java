package algoritmos;
import java.io.*;

import java.util.Arrays;
public class Main {
    public static void main(String[] args){

        long inicio = System.nanoTime(); //tempo de inicio


        int n_args = Integer.parseInt(args[1]); //numero de argumentos
        int[] vetor = new int[n_args]; //inicializado array de argumentos
        String nomeFicheiro = args[0]; //nome do ficheiro a ler

        //ler o ficheiro e guardar os valores no array
        Leitura leitura = new Leitura();
        if (args[0].endsWith(".txt")) {
            vetor = leitura.ler_txt(nomeFicheiro, n_args);
        } else {
            vetor = leitura.ler_bin(nomeFicheiro, n_args);
        }


        //ordenar o array com o algoritmo bubble sort
        BubbleSort alg = new BubbleSort();
        alg.ordenar(vetor);
        System.out.println(Arrays.toString(vetor));

        //escrever o array ordenado no ficheiro de saida
        String soNome = new File(args[0]).getName();   // parte1_texto.txt
        int pos = soNome.lastIndexOf('.');
        String base = soNome.substring(0, pos);       // até pos
        String extensao = soNome.substring(pos);   // de pos em diante
        String nomeSaida = "outputs/" + base + "_ordenado" + extensao;

        
        Escrita escrita = new Escrita();

        if (args[0].endsWith(".txt")) {
            escrita.escrever_txt(nomeSaida, vetor);
        } else {
            escrita.escrever_bin(nomeSaida, vetor);
        }


        long fim = System.nanoTime(); //tempo de fim
        long duracao = fim - inicio; //tempo de execução
        System.out.println("Tempo de execução: " + duracao + " ns");

    }
}


