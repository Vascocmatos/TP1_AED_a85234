package algoritmos;
import java.io.*;

import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        int n_args = Integer.parseInt(args[1]); //numero de argumentos
        int[] vetor = new int[n_args]; //inicializado array de argumentos

        try {
            BufferedReader in = new BufferedReader(new FileReader(args[0]));

            for (int i = 0; i < n_args; i++) {
                String linha = in.readLine();       // lê uma linha do ficheiro (String)
                vetor[i] = Integer.parseInt(linha); // converte para int e guarda
            }  
            System.out.println(Arrays.toString(vetor));
            in.close();
        } catch (IOException e) {
            System.out.println("Erro a ler o ficheiro");
        }
    }

}
