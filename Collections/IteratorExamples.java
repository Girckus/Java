import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorExamples {

    public static void main(String[] args) {
        demoIterator();
        demoIteratorRemove();
        demoFailFast();
        demoListIterator();
        demoForEach();
        demoConcurrentIterator();
        demoCopyOnWriteIterator();
        demoReverseIteration();
        demoQuickComparison();
    }

    // =========================================================
    // 1) Iterator básico
    // =========================================================
    private static void demoIterator() {
        section("1) Iterator básico");

        List<String> list = new ArrayList<>(List.of("A", "B", "C"));

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("Valor: " + value);
        }
    }

    // =========================================================
    // 2) Iterator.remove() (forma correta de remover durante iteração)
    // =========================================================
    private static void demoIteratorRemove() {
        section("2) Iterator.remove() (remoção segura)");

        List<String> list = new ArrayList<>(List.of("A", "B", "C", "B"));

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if ("B".equals(it.next())) {
                it.remove(); // seguro
            }
        }

        print("Após remover todos os B", list);
    }

    // =========================================================
    // 3) Fail-fast (ConcurrentModificationException)
    // =========================================================
    private static void demoFailFast() {
        section("3) Fail-fast (erro clássico)");

        List<String> list = new ArrayList<>(List.of("A", "B", "C"));

        try {
            for (String s : list) {
                if ("B".equals(s)) {
                    list.add("X"); // modificação estrutural
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ERRO -> ConcurrentModificationException");
        }

        print("Estado final", list);
    }

    // =========================================================
    // 4) ListIterator (avança, retrocede, altera, adiciona)
    // =========================================================
    private static void demoListIterator() {
        section("4) ListIterator (bidirecional)");

        List<String> list = new ArrayList<>(List.of("A", "B", "C"));

        ListIterator<String> it = list.listIterator();

        System.out.println(">> Avançando");
        while (it.hasNext()) {
            String v = it.next();
            System.out.println("next(): " + v);

            if ("B".equals(v)) {
                it.set("B*");      // altera elemento atual
                it.add("X");       // adiciona APÓS o atual
            }
        }

        print("Após forward", list);

        System.out.println(">> Retrocedendo");
        while (it.hasPrevious()) {
            System.out.println("previous(): " + it.previous());
        }
    }

    // =========================================================
    // 5) for-each (Iterator implícito)
    // =========================================================
    private static void demoForEach() {
        section("5) for-each (Iterator implícito)");

        Set<String> set = new HashSet<>(Set.of("A", "B", "C"));

        for (String s : set) {
            System.out.println("Elemento: " + s);
        }

        System.out.println("Obs.: não é possível chamar remove() diretamente aqui.");
    }

    // =========================================================
    // 6) Iteradores concorrentes (weakly consistent)
    // =========================================================
    private static void demoConcurrentIterator() {
        section("6) Iterador concorrente (weakly consistent)");

        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        for (String k : map.keySet()) {
            System.out.println("Iterando: " + k);
            if ("B".equals(k)) {
                map.put("D", 4); // permitido
            }
        }

        print("Mapa final", map);
        System.out.println("Obs.: pode ou não ver D durante o loop.");
    }

    // =========================================================
    // 7) CopyOnWriteIterator (snapshot)
    // =========================================================
    private static void demoCopyOnWriteIterator() {
        section("7) CopyOnWriteIterator (snapshot)");

        CopyOnWriteArrayList<String> list =
                new CopyOnWriteArrayList<>(List.of("A", "B", "C"));

        for (String s : list) {
            System.out.println("Iterando: " + s);
            if ("B".equals(s)) {
                list.add("X"); // permitido
            }
        }

        print("Lista final", list);
        System.out.println("Obs.: o foreach NÃO viu o X durante a iteração.");
    }

    // =========================================================
    // 8) Iteração reversa
    // =========================================================
    private static void demoReverseIteration() {
        section("8) Iteração reversa");

        List<String> list = new ArrayList<>(List.of("A", "B", "C"));

        ListIterator<String> it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            System.out.println("previous(): " + it.previous());
        }
    }

    // =========================================================
    // 9) Comparativo rápido
    // =========================================================
    private static void demoQuickComparison() {
        section("9) Resumo comparativo");

        System.out.println("""
        Iterator:
        - Unidirecional
        - remove() seguro
        - fail-fast na maioria das collections
        
        ListIterator:
        - Bidirecional
        - add(), set(), remove()
        - Apenas para List
        
        for-each:
        - Mais legível
        - Iterator implícito
        - Não permite controle fino
        
        Iteradores concorrentes:
        - weakly consistent
        - Não lançam ConcurrentModificationException
        - Podem refletir mudanças
        
        CopyOnWrite:
        - Snapshot
        - Nunca lança ConcurrentModificationException
        - Escrita cara
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