package algoritmos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Leitura {
    public int[] ler(String nomeFicheiro, int n) {
        int[] vetor = new int[n]; //inicializado array de argumentos

        try (BufferedReader in = new BufferedReader(new FileReader(nomeFicheiro))) {
            for (int i = 0; i < n; i++) {
                String linha = in.readLine();       // lê uma linha do ficheiro (String)
                vetor[i] = Integer.parseInt(linha); // converte para int e guarda
            }  
            System.out.println(Arrays.toString(vetor));
        } catch (IOException e) {
            System.out.println("Erro a ler o ficheiro");
        }
    return vetor;
    }
}
