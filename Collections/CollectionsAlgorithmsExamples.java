import java.util.*;

/**
 * Exemplos dos algoritmos utilitários de java.util.Collections:
 * addAll, binarySearch, copy, disjoint, fill, frequency,
 * indexOfSubList, lastIndexOfSubList, max, min, replaceAll,
 * reverse, reverseOrder, rotate, shuffle, sort, swap.
 *
 * Observações:
 * - binarySearch exige lista ordenada no mesmo critério do Comparator usado.
 * - copy(dest, src): dest precisa ter tamanho >= src (não só capacidade).
 */
public class CollectionsAlgorithmsExamples {

    public static void main(String[] args) {
        demoAddAll();
        demoSortAndReverseOrder();
        demoBinarySearch();
        demoMaxMin();
        demoReverse();
        demoRotate();
        demoShuffle();
        demoSwap();
        demoFill();
        demoReplaceAll();
        demoFrequency();
        demoDisjoint();
        demoCopy();
        demoIndexOfSubList();
        demoLastIndexOfSubList();
        demoQuickSummary();
    }

    // =========================================================
    // 1) addAll
    // =========================================================
    private static void demoAddAll() {
        section("1) Collections.addAll");

        List<String> list = new ArrayList<>();
        boolean changed = Collections.addAll(list, "A", "B", "C", "C");
        print("List", list);
        System.out.println("changed -> " + changed);
    }

    // =========================================================
    // 2) sort + reverseOrder
    // =========================================================
    private static void demoSortAndReverseOrder() {
        section("2) Collections.sort + reverseOrder");

        List<Integer> list = new ArrayList<>(List.of(5, 1, 4, 2, 3));

        Collections.sort(list);
        print("sort (natural)", list);

        Collections.sort(list, Collections.reverseOrder());
        print("sort (reverseOrder)", list);
    }

    // =========================================================
    // 3) binarySearch
    // =========================================================
    private static void demoBinarySearch() {
        section("3) Collections.binarySearch");

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        int idx4 = Collections.binarySearch(list, 4);
        int idx10 = Collections.binarySearch(list, 10);

        System.out.println("idx(4)  -> " + idx4);
        System.out.println("idx(10) -> " + idx10 + " (-(pontoInserção)-1)");

        // Com Comparator: a lista PRECISA estar ordenada com o MESMO Comparator
        List<String> names = new ArrayList<>(List.of("ana", "Bruno", "CARLOS"));
        Comparator<String> caseInsensitive = String.CASE_INSENSITIVE_ORDER;

        names.sort(caseInsensitive);
        print("Ordenada (case-insensitive)", names);

        int idx = Collections.binarySearch(names, "carlos", caseInsensitive);
        System.out.println("binarySearch(\"carlos\", caseInsensitive) -> " + idx + " (encontrou: " + names.get(idx) + ")");
    }

    // =========================================================
    // 4) max / min
    // =========================================================
    private static void demoMaxMin() {
        section("4) Collections.max / min");

        List<Integer> list = List.of(5, 1, 4, 2, 3);

        System.out.println("max -> " + Collections.max(list));
        System.out.println("min -> " + Collections.min(list));

        List<String> names = List.of("ana", "Bruno", "CARLOS");
        System.out.println("max (case-insensitive) -> " + Collections.max(names, String.CASE_INSENSITIVE_ORDER));
        System.out.println("min (case-insensitive) -> " + Collections.min(names, String.CASE_INSENSITIVE_ORDER));
    }

    // =========================================================
    // 5) reverse
    // =========================================================
    private static void demoReverse() {
        section("5) Collections.reverse");

        List<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));
        print("Antes", list);

        Collections.reverse(list);
        print("Depois", list);
    }

    // =========================================================
    // 6) rotate
    // =========================================================
    private static void demoRotate() {
        section("6) Collections.rotate");

        List<String> list = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        print("Antes", list);

        Collections.rotate(list, 2); // gira para a direita
        print("rotate +2", list);

        Collections.rotate(list, -3); // gira para a esquerda
        print("rotate -3", list);
    }

    // =========================================================
    // 7) shuffle
    // =========================================================
    private static void demoShuffle() {
        section("7) Collections.shuffle");

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        print("Antes", list);

        Collections.shuffle(list);
        print("Depois (shuffle)", list);

        // shuffle com Random fixo (reprodutível)
        Collections.shuffle(list, new Random(42));
        print("shuffle (seed=42)", list);
    }

    // =========================================================
    // 8) swap
    // =========================================================
    private static void demoSwap() {
        section("8) Collections.swap");

        List<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));
        print("Antes", list);

        Collections.swap(list, 1, 3);
        print("swap(1,3)", list);
    }

    // =========================================================
    // 9) fill
    // =========================================================
    private static void demoFill() {
        section("9) Collections.fill");

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        print("Antes", list);

        Collections.fill(list, "X");
        print("Depois", list);

        System.out.println("Obs.: fill exige lista MUTÁVEL (e com tamanho definido).");
    }

    // =========================================================
    // 10) replaceAll
    // =========================================================
    private static void demoReplaceAll() {
        section("10) Collections.replaceAll");

        List<String> list = new ArrayList<>(List.of("A", "B", "A", "C", "A"));
        print("Antes", list);

        boolean changed = Collections.replaceAll(list, "A", "X");
        print("Depois", list);
        System.out.println("changed -> " + changed);
    }

    // =========================================================
    // 11) frequency
    // =========================================================
    private static void demoFrequency() {
        section("11) Collections.frequency");

        List<String> list = List.of("A", "B", "A", "C", "A");
        System.out.println("frequency(\"A\") -> " + Collections.frequency(list, "A"));
        System.out.println("frequency(\"Z\") -> " + Collections.frequency(list, "Z"));
    }

    // =========================================================
    // 12) disjoint
    // =========================================================
    private static void demoDisjoint() {
        section("12) Collections.disjoint");

        List<String> a = List.of("A", "B", "C");
        List<String> b = List.of("X", "Y");
        List<String> c = List.of("Y", "B");

        System.out.println("disjoint(a,b) -> " + Collections.disjoint(a, b)); // true
        System.out.println("disjoint(a,c) -> " + Collections.disjoint(a, c)); // false
    }

    // =========================================================
    // 13) copy
    // =========================================================
    private static void demoCopy() {
        section("13) Collections.copy");

        List<String> src = List.of("A", "B", "C");

        // Atenção: dest precisa ter TAMANHO >= src (não apenas capacidade)
        List<String> dest = new ArrayList<>(Arrays.asList("?", "?", "?", "?"));
        print("dest antes", dest);
        print("src", src);

        Collections.copy(dest, src); // copia a partir do índice 0
        print("dest depois", dest);

        // Exemplo do erro clássico:
        try {
            List<String> badDest = new ArrayList<>(3); // capacidade 3, TAMANHO 0
            Collections.copy(badDest, src);
        } catch (Exception e) {
            System.out.println("copy em dest tamanho 0 -> ERRO: " + e.getClass().getSimpleName()
                    + " (dica: preencha com placeholders antes)");
        }
    }

    // =========================================================
    // 14) indexOfSubList
    // =========================================================
    private static void demoIndexOfSubList() {
        section("14) Collections.indexOfSubList");

        List<String> list = List.of("A", "B", "C", "B", "C", "D");
        List<String> sub = List.of("B", "C");

        int idx = Collections.indexOfSubList(list, sub);
        System.out.println("indexOfSubList -> " + idx);
    }

    // =========================================================
    // 15) lastIndexOfSubList
    // =========================================================
    private static void demoLastIndexOfSubList() {
        section("15) Collections.lastIndexOfSubList");

        List<String> list = List.of("A", "B", "C", "B", "C", "D");
        List<String> sub = List.of("B", "C");

        int idx = Collections.lastIndexOfSubList(list, sub);
        System.out.println("lastIndexOfSubList -> " + idx);
    }

    // =========================================================
    // 16) Resumo rápido
    // =========================================================
    private static void demoQuickSummary() {
        section("16) Resumo rápido");

        System.out.println("""
        Algoritmos principais:
        - addAll: adiciona vários elementos
        - sort / reverseOrder: ordenação
        - binarySearch: busca binária (lista ordenada!)
        - max / min: extremos
        - reverse: inverte
        - rotate: gira
        - shuffle: embaralha
        - swap: troca posições
        - fill: sobrescreve todos os elementos
        - replaceAll: substitui ocorrências
        - frequency: conta ocorrências
        - disjoint: verifica se NÃO há interseção
        - copy: copia src -> dest (dest precisa ter tamanho)
        - indexOfSubList / lastIndexOfSubList: encontra sublista
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
        System.out.printf("%-22s -> %s%n", label, value);
    }
}