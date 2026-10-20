package algoritmos.alg_ordenacao;

public class ControladorAlgoritmos {
    public void executarAlgoritmo(String algoritmo, int[] vetor) {
        switch (algoritmo.toLowerCase()) {
            case "bubblesort":
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.ordenar(vetor);
                break;
            // Adicione outros algoritmos aqui conforme necessário
            default:
                System.out.println("Algoritmo não reconhecido: " + algoritmo);
                break;
        }
    }
}