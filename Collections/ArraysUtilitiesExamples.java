import java.util.*;
import java.util.stream.IntStream;

public class ArraysUtilitiesExamples {

    public static void main(String[] args) {
        demoSort();
        demoParallelSort();
        demoBinarySearch();
        demoEquals();
        demoFill();
        demoCopy();
        demoAsList();
        demoStream();
        demoToString();
        demoQuickComparison();
    }

    // =========================================================
    // 1) sort (ordenação)
    // =========================================================
    private static void demoSort() {
        section("1) Arrays.sort");

        Integer[] numbers = {5, 1, 4, 2, 3};
        print("Antes", Arrays.toString(numbers));

        Arrays.sort(numbers); // ordem natural
        print("Depois (natural)", Arrays.toString(numbers));

        Arrays.sort(numbers, Comparator.reverseOrder());
        print("Depois (reversa)", Arrays.toString(numbers));

        // Ordenação parcial (intervalo)
        Integer[] partial = {9, 8, 7, 6, 5, 4};
        Arrays.sort(partial, 1, 4); // ordena índices [1..3]
        print("Parcial [1..4)", Arrays.toString(partial));
    }

    // =========================================================
    // 2) parallelSort
    // =========================================================
    private static void demoParallelSort() {
        section("2) Arrays.parallelSort");

        int[] values = {9, 3, 7, 1, 6, 2, 8, 5, 4};
        print("Antes", Arrays.toString(values));

        Arrays.parallelSort(values);
        print("Depois (parallelSort)", Arrays.toString(values));

        System.out.println("Obs.: usa ForkJoinPool; pode ser melhor para arrays grandes.");
    }

    // =========================================================
    // 3) binarySearch
    // =========================================================
    private static void demoBinarySearch() {
        section("3) Arrays.binarySearch");

        int[] values = {1, 2, 3, 4, 5, 6};

        int idx1 = Arrays.binarySearch(values, 4);
        int idx2 = Arrays.binarySearch(values, 10);

        System.out.println("Índice do 4 -> " + idx1);
        System.out.println("Busca do 10 -> " + idx2 + " (-(pontoInserção)-1)");

        System.out.println("Obs.: array PRECISA estar ordenado.");
    }

    // =========================================================
    // 4) equals vs deepEquals
    // =========================================================
    private static void demoEquals() {
        section("4) equals vs deepEquals");

        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};

        System.out.println("equals (primitivo) -> " + Arrays.equals(a1, a2));

        int[][] m1 = {{1, 2}, {3, 4}};
        int[][] m2 = {{1, 2}, {3, 4}};

        System.out.println("equals (2D) -> " + Arrays.equals(m1, m2));
        System.out.println("deepEquals (2D) -> " + Arrays.deepEquals(m1, m2));
    }

    // =========================================================
    // 5) fill
    // =========================================================
    private static void demoFill() {
        section("5) Arrays.fill");

        int[] values = new int[5];
        Arrays.fill(values, 7);
        print("fill completo", Arrays.toString(values));

        Arrays.fill(values, 1, 4, 3);
        print("fill parcial [1..4)", Arrays.toString(values));
    }

    // =========================================================
    // 6) copyOf / copyOfRange
    // =========================================================
    private static void demoCopy() {
        section("6) copyOf / copyOfRange");

        int[] original = {1, 2, 3, 4, 5};

        int[] copy1 = Arrays.copyOf(original, original.length);
        int[] copy2 = Arrays.copyOf(original, 3);
        int[] copy3 = Arrays.copyOfRange(original, 1, 4);

        print("Original", Arrays.toString(original));
        print("copyOf (mesmo tamanho)", Arrays.toString(copy1));
        print("copyOf (3)", Arrays.toString(copy2));
        print("copyOfRange [1..4)", Arrays.toString(copy3));
    }

    // =========================================================
    // 7) asList (ARMADILHA)
    // =========================================================
    private static void demoAsList() {
        section("7) Arrays.asList (armadilha clássica)");

        String[] array = {"A", "B", "C"};
        List<String> list = Arrays.asList(array);

        print("List", list);

        // Modifica o array -> reflete na lista
        array[1] = "X";
        print("Após array[1]=X", list);

        try {
            list.add("D"); // NÃO funciona
        } catch (Exception e) {
            System.out.println("list.add -> ERRO: " + e.getClass().getSimpleName());
        }

        System.out.println("""
        Obs.:
        - Tamanho fixo
        - backed by array
        - Não é ArrayList!
        """);
    }

    // =========================================================
    // 8) stream
    // =========================================================
    private static void demoStream() {
        section("8) Arrays.stream");

        int[] values = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(values).sum();
        print("Soma", sum);

        IntStream.range(1, 6)
                 .filter(n -> n % 2 == 0)
                 .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    // =========================================================
    // 9) toString vs deepToString
    // =========================================================
    private static void demoToString() {
        section("9) toString vs deepToString");

        int[] a = {1, 2, 3};
        int[][] m = {{1, 2}, {3, 4}};

        System.out.println("toString (1D) -> " + Arrays.toString(a));
        System.out.println("toString (2D) -> " + Arrays.toString(m));
        System.out.println("deepToString (2D) -> " + Arrays.deepToString(m));
    }

    // =========================================================
    // 10) Resumo / regras práticas
    // =========================================================
    private static void demoQuickComparison() {
        section("10) Regras práticas");

        System.out.println("""
        Arrays é focado em ARRAYS, não Collections.
        
        Use quando:
        - Precisa de performance máxima
        - Trabalha com tipos primitivos
        - Manipula estruturas de baixo nível
        
        Regras de ouro:
        - binarySearch só em array ORDENADO
        - asList NÃO cria lista mutável
        - deepEquals / deepToString para arrays aninhados
        - parallelSort só vale para arrays grandes
        """);
    }

    // =========================================================
    // Helpers
    // =========================================================
    private static void section(String title) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println(title);
        System.out.println("==================================================");
    }

    private static void print(String label, Object value) {
        System.out.printf("%-30s -> %s%n", label, value);
    }
}