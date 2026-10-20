package algoritmos.R_W;
import java.io.*;

public class Escrita {
    public void escrever_txt(String nomeFicheiro, int[] vetor){
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
    public void escrever_bin(String nomeFicheiro, int[] vetor){
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(nomeFicheiro));
            for (int i = 0; i < vetor.length; i++) {
                out.writeInt(vetor[i]);
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Erro a escrever no ficheiro binário");
        }
    }

}
