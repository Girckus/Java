import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapImplementations {

    public static void main(String[] args) {
        demoHashMap();
        demoLinkedHashMap();
        demoTreeMap();
        demoConcurrentHashMap();
        demoConcurrentSkipListMap();
        demoIdentityHashMap();
        demoWeakHashMap();
        demoEnumMap();
        demoQuickComparison();
    }

    // =========================================================
    // 1) HashMap
    // =========================================================
    private static void demoHashMap() {
        section("1) HashMap (sem ordem garantida)");

        Map<String, Integer> map = new HashMap<>();
        addStringMapSamples(map);

        print("Conteúdo", map);
        System.out.println("get(\"A\") -> " + map.get("A") + " (sobrescreve em duplicata)");
        System.out.println("get(null) -> " + map.get(null) + " (1 chave null permitida)");
        System.out.println("containsKey(\"C\") -> " + map.containsKey("C"));
        System.out.println("containsValue(null) -> " + map.containsValue(null));
    }

    // =========================================================
    // 2) LinkedHashMap
    // =========================================================
    private static void demoLinkedHashMap() {
        section("2) LinkedHashMap (ordem de inserção; pode ser LRU)");

        Map<String, Integer> insertionOrder = new LinkedHashMap<>();
        addStringMapSamples(insertionOrder);
        print("Ordem de inserção", insertionOrder);

        // LinkedHashMap pode ser configurado para ordem de acesso (base de LRU cache)
        int maxEntries = 3;
        Map<String, Integer> lru = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > maxEntries; // remove o mais antigo por acesso (LRU)
            }
        };
        lru.put("A", 1);
        lru.put("B", 2);
        lru.put("C", 3);

        // acessa A para virar "mais recente"
        lru.get("A");
        // adiciona D -> deve remover o menos recente (B)
        lru.put("D", 4);

        print("LinkedHashMap (accessOrder=true) tipo LRU (max=3)", lru);
        System.out.println("Obs.: aqui, B tende a ser removido por ser o menos recentemente acessado.");
    }

    // =========================================================
    // 3) TreeMap
    // =========================================================
    private static void demoTreeMap() {
        section("3) TreeMap (ordenado por chave; NavigableMap)");

        NavigableMap<String, Integer> map = new TreeMap<>();
        map.put("B", 2);
        map.put("A", 1);
        map.put("C", 3);

        print("Conteúdo (ordenado por chave)", map);

        // TreeMap não aceita chave null (na ordenação natural)
        try {
            map.put(null, 0);
        } catch (Exception e) {
            System.out.println("TreeMap.put(null, ...) -> ERRO: " + e.getClass().getSimpleName());
        }

        // Operações de navegação
        System.out.println("lowerKey(\"B\")   -> " + map.lowerKey("B"));
        System.out.println("floorKey(\"B\")   -> " + map.floorKey("B"));
        System.out.println("ceilingKey(\"B\") -> " + map.ceilingKey("B"));
        System.out.println("higherKey(\"B\")  -> " + map.higherKey("B"));
    }

    // =========================================================
    // 4) ConcurrentHashMap
    // =========================================================
    private static void demoConcurrentHashMap() {
        section("4) ConcurrentHashMap (concorrente; sem null)");

        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        print("Conteúdo", map);

        // Não permite null (nem chave, nem valor)
        try {
            map.put("C", null);
        } catch (Exception e) {
            System.out.println("ConcurrentHashMap.put(\"C\", null) -> ERRO: " + e.getClass().getSimpleName());
        }
        try {
            map.put(null, 99);
        } catch (Exception e) {
            System.out.println("ConcurrentHashMap.put(null, 99) -> ERRO: " + e.getClass().getSimpleName());
        }

        // Operações atômicas úteis em concorrência
        map.compute("A", (k, v) -> v == null ? 1 : v + 10);
        map.putIfAbsent("C", 3);
        print("Após compute/putIfAbsent", map);
    }

    // =========================================================
    // 5) ConcurrentSkipListMap
    // =========================================================
    private static void demoConcurrentSkipListMap() {
        section("5) ConcurrentSkipListMap (concorrente + ordenado; NavigableMap)");

        NavigableMap<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("B", 2);
        map.put("A", 1);
        map.put("C", 3);

        print("Conteúdo (ordenado por chave)", map);

        // Não permite chave/valor null
        try {
            map.put(null, 0);
        } catch (Exception e) {
            System.out.println("ConcurrentSkipListMap.put(null, ...) -> ERRO: " + e.getClass().getSimpleName());
        }
        try {
            map.put("D", null);
        } catch (Exception e) {
            System.out.println("ConcurrentSkipListMap.put(\"D\", null) -> ERRO: " + e.getClass().getSimpleName());
        }

        // Iteração "weakly consistent": pode ser modificada durante iteração sem explodir
        for (String k : map.keySet()) {
            if ("B".equals(k)) {
                map.put("D", 4);
            }
            System.out.println("Iterando chave: " + k);
        }
        print("Após iterar e adicionar D", map);
    }

    // =========================================================
    // 6) IdentityHashMap
    // =========================================================
    private static void demoIdentityHashMap() {
        section("6) IdentityHashMap (compara chaves com ==)");

        Map<String, Integer> map = new IdentityHashMap<>();

        String k1 = new String("key");
        String k2 = new String("key"); // equals = true, mas referências diferentes

        System.out.println("k1.equals(k2)? " + k1.equals(k2));
        System.out.println("k1 == k2?      " + (k1 == k2));

        map.put(k1, 1);
        map.put(k2, 2);

        print("Conteúdo (duas entradas!)", map);
        System.out.println("get(new String(\"key\")) -> " + map.get(new String("key")) + " (geralmente null)");
        System.out.println("Obs.: útil em casos bem específicos (ex.: graphs por identidade, proxies, etc.)");

        // IdentityHashMap permite null
        map.put(null, 999);
        map.put("N", null);
        print("Após inserir null key/value", map);
    }

    // =========================================================
    // 7) WeakHashMap
    // =========================================================
    private static void demoWeakHashMap() {
        section("7) WeakHashMap (chaves fracas; bom para caches)");

        Map<Object, String> map = new WeakHashMap<>();

        Object strongKey = new Object();   // referência forte fora do mapa
        Object weakKey = new Object();     // vamos perder a referência depois

        map.put(strongKey, "STRONG");
        map.put(weakKey, "WEAK");

        print("Antes de perder referência", map);

        // Perdendo a referência forte para weakKey:
        weakKey = null;

        // Tentando encorajar GC (não é garantido, mas costuma funcionar em demo)
        forceGc();

        print("Depois de GC (a entrada WEAK pode sumir)", map);
        System.out.println("Obs.: WeakHashMap remove entradas cujas chaves não têm mais referências fortes.");
    }

    // =========================================================
    // 8) EnumMap
    // =========================================================
    private static void demoEnumMap() {
        section("8) EnumMap (muito eficiente; chaves são enums)");

        EnumMap<Day, String> map = new EnumMap<>(Day.class);
        map.put(Day.MONDAY, "Segunda");
        map.put(Day.WEDNESDAY, "Quarta");
        map.put(Day.FRIDAY, "Sexta");

        print("Conteúdo (ordem natural do enum)", map);

        // EnumMap não aceita chave null
        try {
            map.put(null, "X");
        } catch (Exception e) {
            System.out.println("EnumMap.put(null, ...) -> ERRO: " + e.getClass().getSimpleName());
        }

        // Valores null são permitidos
        map.put(Day.SUNDAY, null);
        print("Após put(SUNDAY, null)", map);
    }

    // =========================================================
    // 9) Comparativo rápido (mesmas inserções)
    // =========================================================
    private static void demoQuickComparison() {
        section("9) Comparativo rápido (mesmas inserções)");

        Map<String, Integer> hash = new HashMap<>();
        Map<String, Integer> linked = new LinkedHashMap<>();
        Map<String, Integer> tree = new TreeMap<>();
        Map<String, Integer> identity = new IdentityHashMap<>();
        Map<String, Integer> weak = new WeakHashMap<>();
        Map<String, Integer> chm = new ConcurrentHashMap<>();
        Map<String, Integer> skip = new ConcurrentSkipListMap<>();

        // Inserções base
        List<String> keys = Arrays.asList("B", "A", "A", "C", null);

        // HashMap/LinkedHashMap/IdentityHashMap/WeakHashMap aceitam null key/value (com regras)
        for (String k : keys) {
            hash.put(k, k == null ? 0 : k.length());
            linked.put(k, k == null ? 0 : k.length());
            identity.put(k, k == null ? 0 : k.length());
            weak.put(k, k == null ? 0 : k.length());
        }

        // TreeMap / SkipListMap: não aceitam key null
        for (String k : keys) {
            if (k != null) {
                tree.put(k, k.length());
                skip.put(k, k.length());
            }
        }

        // ConcurrentHashMap: não aceita null key/value
        for (String k : keys) {
            if (k != null) {
                chm.put(k, k.length());
            }
        }

        print("HashMap", hash);
        print("LinkedHashMap (inserção)", linked);
        print("TreeMap (ordenado)", tree);
        print("IdentityHashMap (==)", identity);
        print("WeakHashMap (chaves fracas)", weak);
        print("ConcurrentHashMap (sem null)", chm);
        print("ConcurrentSkipListMap (ordenado + concorrente)", skip);

        System.out.println("\nDiferenças chave:");
        System.out.println("- HashMap: padrão; rápido; aceita 1 chave null e valores null; sem ordem.");
        System.out.println("- LinkedHashMap: mantém ordem de inserção (ou de acesso p/ LRU).");
        System.out.println("- TreeMap: ordenado por chave; NavigableMap; não aceita chave null (orden. natural).");
        System.out.println("- ConcurrentHashMap: concorrente; sem null; operações atômicas (compute/merge/etc.).");
        System.out.println("- ConcurrentSkipListMap: concorrente e ordenado; NavigableMap; sem null.");
        System.out.println("- IdentityHashMap: compara chaves por identidade (==), não por equals.");
        System.out.println("- WeakHashMap: entradas podem sumir após GC se a chave ficar sem referência forte.");
        System.out.println("- EnumMap: melhor opção quando a chave é enum; muito eficiente; ordem natural do enum.");
    }

    // =========================================================
    // Helpers
    // =========================================================
    private static void addStringMapSamples(Map<String, Integer> map) {
        map.put("B", 2);
        map.put("A", 1);
        map.put("A", 999);  // sobrescreve
        map.put(null, 0);   // permitido em HashMap/LinkedHashMap/IdentityHashMap/WeakHashMap
        map.put("C", null); // valores null permitidos em HashMap/LinkedHashMap/IdentityHashMap/WeakHashMap
    }

    private static void forceGc() {
        // Nenhum método garante GC, mas isso costuma ajudar em demo local.
        for (int i = 0; i < 3; i++) {
            System.gc();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void section(String title) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println(title);
        System.out.println("==================================================");
    }

    private static void print(String label, Object value) {
        System.out.printf("%-45s -> %s%n", label, value);
    }

    // Enum de exemplo para EnumMap
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
