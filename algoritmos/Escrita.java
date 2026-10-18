package algoritmos;
import java.io.*;

public class Escrita {
    public void escrever(String nomeFicheiro, int[] vetor){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(nomeFicheiro));
            for (int i = 0; i < vetor.length; i++) {
                out.write(Integer.toString(vetor[i]));
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Erro a escrever no ficheiro");
        }
    }
}
