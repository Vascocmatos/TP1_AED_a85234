package algoritmos.alg_ordenacao;

public class ControladorAlgoritmos {
    public void executarAlgoritmo(String algoritmo, int[] vetor) {
        switch (algoritmo.toLowerCase()) {
            case "bubblesort":
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.ordenar(vetor);
                break;
            // Adicione outros algoritmos aqui conforme necessário
            case "quicksort":
                QuickSort quickSort = new QuickSort();
                quickSort.ordenar(vetor, 0, vetor.length - 1);
                break;
            case "insertionsort":
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.ordenar(vetor);
                break;
            default:
                System.out.println("Algoritmo não reconhecido: " + algoritmo);
                break;
        }
    }
}