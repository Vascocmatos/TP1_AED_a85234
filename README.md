# Algoritmos e Estruturas de Dados, 2026/27

**1º Trabalho: Ordenação de conjunto de Inteiros**
Data de entrega: 25 de outubro de 2026
Grupos de 2 alunos no máximo, defesa individualizada

Autor: Vasco (a85234)

Repositório git: https://github.com/Vascocmatos/TP1_AED_a85234.git


---

## 1. Resumo

Programa em Java que lê um ficheiro com inteiros (em **texto** ou **binário**), ordena-os com o algoritmo escolhido e grava o resultado num novo ficheiro, no mesmo formato da entrada. Cada execução regista num ficheiro de log o algoritmo usado, o número de elementos, a data/hora e o tempo gasto, para permitir o estudo comparativo dos algoritmos.

Fluxo do programa:

```
ler (texto OU binário) -> int[] -> ordenar (algoritmo escolhido) -> escrever (texto OU binário)
```

O formato é detetado pela extensão do ficheiro de entrada: `.txt` é tratado como texto, qualquer outra extensão (por exemplo `.bin`) como binário.

## 2. Enunciado

### Objetivo
Desenvolver um programa que recebe da linha de comandos (através dos argumentos do método `main`) o nome de um ficheiro e o número de inteiros que o ficheiro contém, e que, em seguida, lê e ordena o conteúdo desse ficheiro (gravando a ordenação em ficheiro, no mesmo formato de entrada).

### Requisitos do programa
1. **Argumentos da linha de comandos**
   - Primeiro argumento: nome do ficheiro a ordenar.
   - Segundo argumento: número inteiro que representa a quantidade exata de inteiros contidos no ficheiro.
2. **Manipulação de ficheiros** (duas formas distintas, para efeitos de avaliação)
   - Leitura/escrita de ficheiros de texto (15% da avaliação do trabalho).
   - Leitura/escrita de ficheiros binários (30% da avaliação do trabalho).
   - O programa deve guardar o resultado da ordenação num novo ficheiro.
3. **Algoritmo de ordenação**
   - Aplicar pelo menos um dos algoritmos de ordenação estudados.
   - Para o estudo comparativo do desempenho, é obrigatório implementar e avaliar os algoritmos estudados e descrever o processo no relatório. O número de valores tem de ser representativo, com n ∈ {1.000, 5.000, 10.000, 100.000, 250.000, 500.000}.
4. **Estrutura e eficiência**
   - O código deve apresentar uma estrutura orientada a objetos clara, modular e eficiente.

## 3. Estrutura do projeto

```
TP1_AED_a85234/
├── algoritmos/
│   ├── Main.java                     ponto de entrada, orquestra o programa
│   ├── Log.java                      regista cada execução em log.txt
│   ├── Conversor.java                utilitário: converte um .txt num .bin de teste
│   ├── R_W/
│   │   ├── Leitura.java              ler_txt, ler_bin, n_txt, n_bin
│   │   └── Escrita.java              escrever_txt, escrever_bin
│   └── alg_ordenacao/
│       ├── ControladorAlgoritmos.java  escolhe o algoritmo pelo nome
│       ├── BubbleSort.java
│       ├── InsertionSort.java
│       └── QuickSort.java
├── inputs/                           ficheiros a ordenar
├── outputs/                          ficheiros ordenados
├── log.txt                           histórico de execuções
└── README.md
```

Cada responsabilidade está numa classe própria: o `Main` só coordena, `Leitura`/`Escrita` tratam dos ficheiros, e cada algoritmo é uma classe independente, escolhida pelo `ControladorAlgoritmos`.

## 4. Formatos dos ficheiros

| | Texto (`.txt`) | Binário (`.bin`) |
|---|---|---|
| Conteúdo | um inteiro por linha, escrito como caracteres | só os inteiros em bruto, 4 bytes cada (`writeInt`), sem separadores |
| Leitura | `BufferedReader.readLine()` + `Integer.parseInt` | `DataInputStream.readInt()` |
| Escrita | `BufferedWriter.write` + `newLine` | `DataOutputStream.writeInt` |
| Tamanho | varia com o número de dígitos | sempre `n x 4` bytes |

Um ficheiro binário não pode ser criado à mão nem num editor de texto: tem de ser gerado por um programa com `writeInt` (ver o `Conversor` na secção 6).

## 5. Guia de utilização

### Compilar
A partir da pasta `TP1_AED_a85234`:

```
javac algoritmos/Main.java
```

O `javac` compila automaticamente as classes de que o `Main` depende. Para compilar tudo explicitamente:

```
javac algoritmos/*.java algoritmos/R_W/*.java algoritmos/alg_ordenacao/*.java
```

### Executar

```
java algoritmos.Main <ficheiro> <algoritmo>
```

Exemplos:

```
java algoritmos.Main inputs\parte1_texto.txt bubblesort
java algoritmos.Main inputs\parte1_bin.bin quicksort
```

Algoritmos disponíveis (não distingue maiúsculas de minúsculas):

- `bubblesort`
- `insertionsort`
- `quicksort`

O caminho do ficheiro é relativo à pasta de onde se corre o comando. Se o ficheiro está em `inputs`, o caminho tem de incluir `inputs\`.

### Número de elementos
O programa descobre sozinho quantos inteiros o ficheiro tem: no binário divide o tamanho do ficheiro por 4, no texto conta as linhas.

### Resultados
- O ficheiro ordenado é gravado em `outputs/<nome>_ordenado<extensão>`, por exemplo `outputs/parte1_texto_ordenado.txt`. O formato é o mesmo da entrada.
- Cada execução acrescenta uma linha a `log.txt`:

```
Data: 2026-10-20T12:19:42 | algoritmo: Quicksort | número de elementos: 15 | duração: 7.134 ms
```

O tempo registado inclui leitura, ordenação e escrita.

## 6. Gerar ficheiros de teste

O `Conversor` lê um `.txt` e grava os mesmos números num `.bin` verdadeiro:

```
java algoritmos.Conversor <ficheiro.txt> <n> <ficheiro.bin>
```

Para verificar o conteúdo de um binário no PowerShell:

```
Format-Hex inputs\parte1_bin.bin
```

O número 46, por exemplo, deve aparecer como `00 00 00 2E`.

## 7. Notas

- O bubble sort e o insertion sort são O(n²) e podem demorar vários minutos com 500.000 elementos. O quicksort é, em média, O(n log n).
- Para comparar algoritmos com justiça, todos devem ordenar os mesmos dados de entrada.