package algoritmos.R_W;

import java.io.*;
import java.util.Arrays;

public class Leitura {
    public int[] ler_txt(String nomeFicheiro, int n) {
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
    public int[] ler_bin(String nomeFicheiro, int n) {

        int[] vetor = new int[n]; //inicializado array de argumentos

        try (DataInputStream in = new DataInputStream(new FileInputStream(nomeFicheiro))) {
            for (int i = 0; i < n; i++) {
                vetor[i] = in.readInt(); // lê 4 bytes, um inteiro do ficheiro binário
            }
            System.out.println(Arrays.toString(vetor));
        } catch (IOException e) {
            System.out.println("Erro a ler o ficheiro binário");
        }
        return vetor;
    }

    public int n_txt(String nomeFicheiro) {
        int n = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(nomeFicheiro))) {
            while (in.readLine() != null) {
                n++;
            }
        } catch (IOException e) {
            System.out.println("Erro a ler o ficheiro: " + e);
            System.exit(1);
        }
        return n;
    }
    public int n_bin(String nomeFicheiro) {
        return (int) (new File(nomeFicheiro).length() / 4);
    }
}
