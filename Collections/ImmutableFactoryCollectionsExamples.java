import java.util.*;

public class ImmutableFactoryCollectionsExamples {

    public static void main(String[] args) {
        demoListOf();
        demoSetOf();
        demoMapOf();
        demoMapOfEntries();
        demoEmptyFactories();
        demoSingletonFactories();
        demoUnmodifiableViews();
        demoImmutableVsUnmodifiable();
        demoQuickComparison();
    }

    // =========================================================
    // 1) List.of(...)
    // =========================================================
    private static void demoListOf() {
        section("1) List.of(...)");

        List<String> list = List.of("A", "B", "C");
        print("Conteúdo", list);

        try {
            list.add("X");
        } catch (Exception e) {
            System.out.println("list.add -> ERRO: " + e.getClass().getSimpleName());
        }

        try {
            List.of("A", null);
        } catch (Exception e) {
            System.out.println("List.of com null -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 2) Set.of(...)
    // =========================================================
    private static void demoSetOf() {
        section("2) Set.of(...)");

        Set<String> set = Set.of("A", "B", "C");
        print("Conteúdo", set);

        try {
            set.remove("A");
        } catch (Exception e) {
            System.out.println("set.remove -> ERRO: " + e.getClass().getSimpleName());
        }

        try {
            Set.of("A", "A");
        } catch (Exception e) {
            System.out.println("Set.of com duplicata -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 3) Map.of(...)
    // =========================================================
    private static void demoMapOf() {
        section("3) Map.of(...)");

        Map<String, Integer> map = Map.of(
                "A", 1,
                "B", 2,
                "C", 3
        );
        print("Conteúdo", map);

        try {
            map.put("D", 4);
        } catch (Exception e) {
            System.out.println("map.put -> ERRO: " + e.getClass().getSimpleName());
        }

        try {
            Map.of("A", 1, "A", 2);
        } catch (Exception e) {
            System.out.println("Map.of com chave duplicada -> ERRO: " + e.getClass().getSimpleName());
        }

        try {
            Map.of("A", null);
        } catch (Exception e) {
            System.out.println("Map.of com null -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 4) Map.ofEntries(...)
    // =========================================================
    private static void demoMapOfEntries() {
        section("4) Map.ofEntries(...)");

        Map<String, String> map = Map.ofEntries(
                Map.entry("A", "Alpha"),
                Map.entry("B", "Beta"),
                Map.entry("C", "Gamma")
        );

        print("Conteúdo", map);

        try {
            Map.ofEntries(
                    Map.entry("A", "1"),
                    Map.entry("A", "2")
            );
        } catch (Exception e) {
            System.out.println("Map.ofEntries duplicado -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 5) Collections.empty*
    // =========================================================
    private static void demoEmptyFactories() {
        section("5) Collections.empty*");

        List<String> list = Collections.emptyList();
        Set<Integer> set = Collections.emptySet();
        Map<String, String> map = Collections.emptyMap();

        print("emptyList", list);
        print("emptySet", set);
        print("emptyMap", map);

        try {
            list.add("X");
        } catch (Exception e) {
            System.out.println("emptyList.add -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 6) Collections.singleton*
    // =========================================================
    private static void demoSingletonFactories() {
        section("6) Collections.singleton*");

        List<String> list = Collections.singletonList("ONLY");
        Set<String> set = Collections.singleton("ONE");
        Map<String, Integer> map = Collections.singletonMap("A", 1);

        print("singletonList", list);
        print("singletonSet", set);
        print("singletonMap", map);

        try {
            set.add("X");
        } catch (Exception e) {
            System.out.println("singletonSet.add -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 7) Collections.unmodifiable*
    // =========================================================
    private static void demoUnmodifiableViews() {
        section("7) Collections.unmodifiable* (VIEW)");

        List<String> base = new ArrayList<>(List.of("A", "B"));
        List<String> view = Collections.unmodifiableList(base);

        print("Base", base);
        print("View imutável", view);

        base.add("C");
        print("View após base.add(C)", view);

        try {
            view.add("X");
        } catch (Exception e) {
            System.out.println("view.add -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 8) Imutável real vs View imutável
    // =========================================================
    private static void demoImmutableVsUnmodifiable() {
        section("8) Imutável real vs Unmodifiable View");

        List<String> immutable = List.of("A", "B");
        List<String> base = new ArrayList<>(List.of("A", "B"));
        List<String> view = Collections.unmodifiableList(base);

        base.add("C");

        print("List.of (imutável real)", immutable);
        print("Unmodifiable view (reflete base)", view);

        System.out.println("""
        Diferença:
        - List.of: estrutura interna nunca muda
        - unmodifiableList: bloqueia escrita, mas reflete mudanças da coleção base
        """);
    }

    // =========================================================
    // 9) Comparativo final
    // =========================================================
    private static void demoQuickComparison() {
        section("9) Comparativo final");

        System.out.println("""
        Factory methods imutáveis (Java 9+):
        - List.of / Set.of / Map.of
        - Map.ofEntries
        - empty* / singleton*
        
        Características:
        - Imutáveis de verdade
        - Não aceitam null
        - Estruturas compactas e eficientes
        - thread-safe por definição
        
        Collections.unmodifiable*:
        - Apenas VIEW
        - Base pode mudar
        - NÃO é thread-safe automaticamente
        
        Exceções comuns:
        - UnsupportedOperationException (tentou modificar)
        - NullPointerException (null em of())
        - IllegalArgumentException (duplicatas)
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
        System.out.printf("%-35s -> %s%n", label, value);
    }
}