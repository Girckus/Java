import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Wrapper implementations (Collections.*):
 * - checked*      : checagem de tipo em runtime (bom para interoperar com raw types)
 * - synchronized* : thread-safety via lock (precisa sincronizar na iteração!)
 * - unmodifiable* : view não-modificável (mas reflete mudanças da coleção base)
 *
 * Também inclui: diferenças importantes + armadilhas clássicas.
 */
public class WrapperImplementationsExamples {

    public static void main(String[] args) throws Exception {
        demoCheckedWrappers();
        demoSynchronizedWrappers();
        demoUnmodifiableWrappers();
        demoWrappersAreViews();
        demoQuickComparison();
    }

    // =========================================================
    // 1) CHECKED WRAPPERS
    // =========================================================
    private static void demoCheckedWrappers() {
        section("1) Checked wrappers (checkedList/Set/Map)");

        // Imagine que você recebe uma List "raw" (sem generics) de uma API antiga.
        List raw = new ArrayList();
        raw.add("A");
        raw.add("B");

        // Você quer garantir em runtime que só entra String:
        List<String> safe = Collections.checkedList(raw, String.class);

        print("safe (checked view)", safe);

        safe.add("C"); // OK

        // Inserindo "errado" via raw reference: o wrapper pega em runtime
        try {
            raw.add(123); // tentativa de colocar Integer
            System.out.println("raw.add(123) -> inseriu? (deveria falhar ao passar pelo wrapper)");
            // Para forçar a validação, faça uma operação via safe que percorra a lista:
            for (String s : safe) {
                // ao tentar ler/castar, pode estourar também
            }
        } catch (Exception e) {
            System.out.println("Erro após inserir tipo errado -> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        // Melhor demonstração: tentar inserir tipo errado PELO wrapper
        try {
            @SuppressWarnings("unchecked")
            List unsafeView = safe; // referência raw apontando para o wrapper
            unsafeView.add(999);    // passa pelo wrapper -> ClassCastException
        } catch (Exception e) {
            System.out.println("Inserção tipo errado via checkedList -> ERRO: " + e.getClass().getSimpleName());
        }

        print("Final (raw)", raw);
        print("Final (safe)", safe);

        System.out.println("Obs.: checked* é útil para proteger coleções quando há código legado com raw types.");
    }

    // =========================================================
    // 2) SYNCHRONIZED WRAPPERS
    // =========================================================
    private static void demoSynchronizedWrappers() throws Exception {
        section("2) Synchronized wrappers (synchronizedList/Set/Map)");

        List<String> base = new ArrayList<>();
        List<String> sync = Collections.synchronizedList(base);

        // Escritas concorrentes (simples demo com threads)
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) sync.add("T1-" + i);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) sync.add("T2-" + i);
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        print("Após threads (sync)", sync);

        // ARMADILHA: iterar sem sincronizar externamente pode dar problema
        // A documentação recomenda sincronizar no MESMO lock do wrapper durante iteração:
        System.out.println("Iteração CORRETA (sincronizando externamente):");
        synchronized (sync) {
            for (String s : sync) {
                System.out.println(" - " + s);
            }
        }

        // Para comparar: um exemplo de alternativa moderna para leituras intensas:
        List<String> cow = new CopyOnWriteArrayList<>(sync);
        print("CopyOnWriteArrayList (snapshot-friendly)", cow);
        System.out.println("Obs.: synchronized* protege operações individuais; iteração precisa synchronized(sync).");
    }

    // =========================================================
    // 3) UNMODIFIABLE WRAPPERS
    // =========================================================
    private static void demoUnmodifiableWrappers() {
        section("3) Unmodifiable wrappers (unmodifiableList/Set/Map)");

        List<String> baseList = new ArrayList<>(List.of("A", "B"));
        List<String> viewList = Collections.unmodifiableList(baseList);

        print("Base", baseList);
        print("View unmodifiable", viewList);

        // Tentativa de modificar pela view -> UnsupportedOperationException
        try {
            viewList.add("X");
        } catch (Exception e) {
            System.out.println("viewList.add -> ERRO: " + e.getClass().getSimpleName());
        }

        // Mas mudar a BASE muda o que a view enxerga (porque é VIEW)
        baseList.add("C");
        print("View após base.add(C)", viewList);

        // Map e Set idem
        Map<String, Integer> baseMap = new HashMap<>();
        baseMap.put("A", 1);
        Map<String, Integer> viewMap = Collections.unmodifiableMap(baseMap);

        try {
            viewMap.put("B", 2);
        } catch (Exception e) {
            System.out.println("viewMap.put -> ERRO: " + e.getClass().getSimpleName());
        }

        baseMap.put("B", 2);
        print("viewMap após baseMap.put(B,2)", viewMap);

        System.out.println("Obs.: unmodifiable* NÃO cria cópia; é uma view read-only.");
    }

    // =========================================================
    // 4) WRAPPERS SÃO VIEWS (NÃO CÓPIAS)
    // =========================================================
    private static void demoWrappersAreViews() {
        section("4) Wrappers são views (não cópias)");

        List<String> base = new ArrayList<>(List.of("A", "B"));
        List<String> unmod = Collections.unmodifiableList(base);
        List<String> sync = Collections.synchronizedList(base);
        List<String> checked = Collections.checkedList(base, String.class);

        print("Base", base);
        print("Unmodifiable view", unmod);
        print("Synchronized view", sync);
        print("Checked view", checked);

        System.out.println("-- Alterando a BASE: base.add(C) --");
        base.add("C");

        print("Base", base);
        print("Unmodifiable view", unmod);
        print("Synchronized view", sync);
        print("Checked view", checked);

        System.out.println("""
        Observação:
        - Todos os wrappers acima compartilham a MESMA coleção subjacente.
        - Se você precisa "congelar" o conteúdo, faça cópia + List.of(...) (ou List.copyOf).
        """);
    }

    // =========================================================
    // 5) RESUMO / COMPARAÇÃO
    // =========================================================
    private static void demoQuickComparison() {
        section("5) Resumo rápido");

        System.out.println("""
        checked*:
        - Garante tipo em runtime (ótimo com código legado / raw types)
        - Pode lançar ClassCastException ao inserir tipo inválido
        
        synchronized*:
        - Thread-safe via lock para operações individuais
        - Iteração exige synchronized(wrapper) para evitar race/ConcurrentModificationException
        
        unmodifiable*:
        - Bloqueia modificações via view (UnsupportedOperationException)
        - É VIEW: mudanças na coleção base aparecem na view
        
        Dica:
        - Precisa imutável REAL? use List.of/Set.of/Map.of ou List.copyOf/Set.copyOf/Map.copyOf
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