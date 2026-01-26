import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetImplementations {

    public static void main(String[] args) {
        demoHashSet();
        demoLinkedHashSet();
        demoTreeSet();
        demoConcurrentSkipListSet();
        demoCopyOnWriteArraySet();
        demoEnumSet();
        demoQuickComparison();
    }

    // =========================================================
    // 1) HashSet
    // =========================================================
    private static void demoHashSet() {
        section("1) HashSet (sem ordem garantida)");

        Set<String> set = new HashSet<>();
        addStringSamples(set);

        print("Conteúdo", set);
        System.out.println("Contém 'A'? " + set.contains("A"));
        System.out.println("Tamanho (duplicatas ignoradas): " + set.size());

        // HashSet permite 1 null
        System.out.println("Contém null? " + set.contains(null));
    }

    // =========================================================
    // 2) LinkedHashSet
    // =========================================================
    private static void demoLinkedHashSet() {
        section("2) LinkedHashSet (mantém ordem de inserção)");

        Set<String> set = new LinkedHashSet<>();
        addStringSamples(set);

        print("Conteúdo (ordem de inserção)", set);
    }

    // =========================================================
    // 3) TreeSet
    // =========================================================
    private static void demoTreeSet() {
        section("3) TreeSet (ordenado; NavigableSet)");

        NavigableSet<String> set = new TreeSet<>();
        set.add("B");
        set.add("A");
        set.add("C");
        set.add("A"); // duplicata ignorada

        print("Conteúdo (ordenado)", set);

        // TreeSet não permite null (natural ordering)
        try {
            set.add(null);
        } catch (Exception e) {
            System.out.println("TreeSet.add(null) -> ERRO: " + e.getClass().getSimpleName());
        }

        // Operações de navegação
        System.out.println("lower(\"B\")  -> " + set.lower("B"));   // < B
        System.out.println("floor(\"B\")  -> " + set.floor("B"));   // <= B
        System.out.println("ceiling(\"B\")-> " + set.ceiling("B")); // >= B
        System.out.println("higher(\"B\") -> " + set.higher("B"));  // > B
    }

    // =========================================================
    // 4) ConcurrentSkipListSet
    // =========================================================
    private static void demoConcurrentSkipListSet() {
        section("4) ConcurrentSkipListSet (concorrente + ordenado)");

        NavigableSet<String> set = new ConcurrentSkipListSet<>();
        set.add("B");
        set.add("A");
        set.add("C");
        set.add("A"); // duplicata ignorada

        print("Conteúdo (ordenado)", set);

        // Não permite null
        try {
            set.add(null);
        } catch (Exception e) {
            System.out.println("ConcurrentSkipListSet.add(null) -> ERRO: " + e.getClass().getSimpleName());
        }

        // Iteração "weakly consistent": não explode com ConcurrentModificationException
        for (String s : set) {
            if ("B".equals(s)) {
                set.add("D"); // permitido enquanto itera
            }
            System.out.println("Iterando: " + s);
        }
        print("Após iterar e add(D)", set);
    }

    // =========================================================
    // 5) CopyOnWriteArraySet
    // =========================================================
    private static void demoCopyOnWriteArraySet() {
        section("5) CopyOnWriteArraySet (concorrente + snapshot; sem ordenação)");

        Set<String> set = new CopyOnWriteArraySet<>();
        addStringSamples(set);

        print("Conteúdo", set);

        // Iteração segura por snapshot (não lança ConcurrentModificationException)
        int before = set.size();
        for (String s : set) {
            if ("B".equals(s)) {
                set.add("NEW"); // permitido durante foreach
            }
            System.out.println("Iterando (snapshot): " + s);
        }
        int after = set.size();

        System.out.println("Tamanho antes do foreach: " + before);
        System.out.println("Tamanho após  do foreach: " + after);
        System.out.println("Obs.: o foreach não vê o 'NEW' no mesmo loop (snapshot).");

        print("Final", set);
    }

    // =========================================================
    // 6) EnumSet
    // =========================================================
    private static void demoEnumSet() {
        section("6) EnumSet (extremamente eficiente p/ enums)");

        EnumSet<Day> set = EnumSet.noneOf(Day.class);
        set.add(Day.MONDAY);
        set.add(Day.WEDNESDAY);
        set.add(Day.FRIDAY);
        set.add(Day.FRIDAY); // duplicata ignorada

        print("Conteúdo (ordem natural do enum)", set);

        // Operações úteis
        EnumSet<Day> all = EnumSet.allOf(Day.class);
        print("EnumSet.allOf", all);

        EnumSet<Day> range = EnumSet.range(Day.TUESDAY, Day.THURSDAY);
        print("EnumSet.range(TUE..THU)", range);

        EnumSet<Day> complement = EnumSet.complementOf(set);
        print("complementOf(set)", complement);

        // EnumSet não aceita null
        try {
            set.add(null);
        } catch (Exception e) {
            System.out.println("EnumSet.add(null) -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 7) Comparativo rápido (mesmas inserções)
    // =========================================================
    private static void demoQuickComparison() {
        section("7) Comparativo rápido (mesmas inserções)");

        Set<String> hash = new HashSet<>();
        Set<String> linked = new LinkedHashSet<>();
        Set<String> tree = new TreeSet<>();
        Set<String> cow = new CopyOnWriteArraySet<>();
        Set<String> skip = new ConcurrentSkipListSet<>();

        // Mesma sequência de inserção
        List<String> items = Arrays.asList("B", "A", "A", "C", null);

        // HashSet / LinkedHashSet / CopyOnWriteArraySet aceitam null
        for (String s : items) {
            hash.add(s);
            linked.add(s);
            cow.add(s);
        }

        // TreeSet / ConcurrentSkipListSet NÃO aceitam null
        for (String s : items) {
            if (s != null) {
                tree.add(s);
                skip.add(s);
            }
        }

        print("HashSet", hash);
        print("LinkedHashSet", linked);
        print("TreeSet (ordenado)", tree);
        print("CopyOnWriteArraySet", cow);
        print("ConcurrentSkipListSet (ordenado)", skip);

        System.out.println("\nDiferenças chave:");
        System.out.println("- HashSet: mais comum; sem ordem garantida; 1 null; rápido para contains/add.");
        System.out.println("- LinkedHashSet: mantém ordem de inserção; custo um pouco maior que HashSet.");
        System.out.println("- TreeSet: mantém ordenação; NavigableSet; não aceita null; log(n).");
        System.out.println("- ConcurrentSkipListSet: versão concorrente e ordenada (skip list); não aceita null.");
        System.out.println("- CopyOnWriteArraySet: concorrente por snapshot; ótimo p/ muitas leituras e poucas escritas.");
        System.out.println("- EnumSet: só para enums; muito eficiente (bitset); ordenação natural do enum; não aceita null.");
    }

    // =========================================================
    // Helpers
    // =========================================================
    private static void addStringSamples(Set<String> set) {
        set.add("B");
        set.add("A");
        set.add("A");   // duplicata ignorada
        set.add(null);  // permitido (exceto TreeSet/SkipListSet/EnumSet)
        set.add("C");
    }

    private static void section(String title) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println(title);
        System.out.println("==================================================");
    }

    private static void print(String label, Object value) {
        System.out.printf("%-35s -> %s%n", label, value);
    }

    // Enum de exemplo para EnumSet
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}