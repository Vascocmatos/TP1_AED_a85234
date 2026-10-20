package algoritmos;

import java.io.*;
import java.time.LocalDateTime;

public class Log {
    public void escrever_log(String algoritmo, long duracao, int n_args) {
        LocalDateTime data = LocalDateTime.now();
        try (BufferedWriter out = new BufferedWriter(new FileWriter("log.txt", true))) {
            out.write("Data: " +data + " | algoritmo: " + algoritmo + " | número de elementos: " + n_args + " | duração: " + (duracao / 1_000_000.0) + " ms");
            out.newLine();
        } catch (IOException e) {
            System.out.println("Erro a escrever no ficheiro de log: " + e);
        }
    }
}
