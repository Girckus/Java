import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Demonstra diferenças entre implementações de Deque:
 * - ArrayDeque (não thread-safe; rápido; não aceita null)
 * - ConcurrentLinkedDeque (concorrente; não-bloqueante; não aceita null)
 * - LinkedBlockingDeque (concorrente e BLOQUEANTE; opcionalmente limitada; não aceita null)
 *
 * Deque = Double-Ended Queue: operações eficientes no início e no fim.
 */
public class DequeImplementations {

    public static void main(String[] args) throws Exception {
        demoArrayDeque();
        demoConcurrentLinkedDeque();
        demoLinkedBlockingDeque();
        demoQuickComparison();
    }

    // =========================================================
    // 1) ArrayDeque
    // =========================================================
    private static void demoArrayDeque() {
        section("1) ArrayDeque (não thread-safe; rápido; circular array)");

        Deque<String> d = new ArrayDeque<>();

        // Como fila (FIFO): offerLast/pollFirst
        d.offerLast("A");
        d.offerLast("B");
        d.offerLast("C");
        print("Como fila (após offerLast A,B,C)", d);
        System.out.println("pollFirst() -> " + d.pollFirst());
        print("Após pollFirst()", d);

        // Como pilha (LIFO): push/pop (push = addFirst)
        d.push("S1");
        d.push("S2");
        print("Como pilha (após push S1,S2)", d);
        System.out.println("pop() -> " + d.pop());
        print("Após pop()", d);

        // Não aceita null
        try {
            d.offerLast(null);
        } catch (Exception e) {
            System.out.println("ArrayDeque.offerLast(null) -> ERRO: " + e.getClass().getSimpleName());
        }

        // Iteração + modificação estrutural geralmente explode
        try {
            for (String s : d) {
                if ("B".equals(s)) d.addLast("NEW");
            }
        } catch (Exception e) {
            System.out.println("Modificar durante foreach -> ERRO: " + e.getClass().getSimpleName());
        }

        print("Final", d);
    }

    // =========================================================
    // 2) ConcurrentLinkedDeque
    // =========================================================
    private static void demoConcurrentLinkedDeque() {
        section("2) ConcurrentLinkedDeque (concorrente; não-bloqueante)");

        Deque<String> d = new ConcurrentLinkedDeque<>();

        d.addFirst("A");
        d.addLast("B");
        d.addLast("C");
        print("Após addFirst(A), addLast(B,C)", d);

        System.out.println("pollFirst() -> " + d.pollFirst());
        System.out.println("pollLast()  -> " + d.pollLast());
        print("Após pollFirst/pollLast", d);

        // Não aceita null
        try {
            d.addFirst(null);
        } catch (Exception e) {
            System.out.println("ConcurrentLinkedDeque.addFirst(null) -> ERRO: " + e.getClass().getSimpleName());
        }

        // Iteração "weakly consistent": pode modificar durante iteração sem ConcurrentModificationException
        d.addLast("X");
        d.addLast("Y");
        for (String s : d) {
            if ("X".equals(s)) d.addLast("NEW"); // permitido
            System.out.println("Iterando: " + s);
        }
        print("Após iterar e add(NEW)", d);
    }

    // =========================================================
    // 3) LinkedBlockingDeque
    // =========================================================
    private static void demoLinkedBlockingDeque() throws Exception {
        section("3) LinkedBlockingDeque (concorrente; BLOQUEANTE; opcionalmente limitada)");

        LinkedBlockingDeque<String> d = new LinkedBlockingDeque<>(2); // capacidade fixa p/ demo

        // put bloqueia se cheia; usamos offer com timeout para demonstrar
        d.putLast("A");
        d.putLast("B");
        print("Após putLast(A,B) [cheia]", d);

        System.out.println("offerLast(C, 100ms) quando cheia -> " + d.offerLast("C", 100, TimeUnit.MILLISECONDS));

        System.out.println("takeFirst() -> " + d.takeFirst());
        print("Após takeFirst()", d);

        System.out.println("putFirst(Z)...");
        d.putFirst("Z");
        print("Após putFirst(Z)", d);

        // Não aceita null
        try {
            d.putLast(null);
        } catch (Exception e) {
            System.out.println("LinkedBlockingDeque.putLast(null) -> ERRO: " + e.getClass().getSimpleName());
        }

        // takeLast com timeout: se vazio, retorna null
        d.clear();
        System.out.println("pollLast(100ms) quando vazio -> " + d.pollLast(100, TimeUnit.MILLISECONDS));
        print("Final", d);
    }

    // =========================================================
    // 4) Comparativo rápido
    // =========================================================
    private static void demoQuickComparison() {
        section("4) Comparativo rápido (resumo)");

        System.out.println("- ArrayDeque: melhor opção geral em thread única (rápido, baixo overhead).");
        System.out.println("- ConcurrentLinkedDeque: concorrente sem bloqueio; iteração weakly consistent.");
        System.out.println("- LinkedBlockingDeque: concorrente e BLOQUEANTE (put/take); suporta capacidade.");
        System.out.println("\nRegras rápidas:");
        System.out.println("- Precisa de pilha/fila simples? ArrayDeque.");
        System.out.println("- Precisa de deque concorrente sem bloquear? ConcurrentLinkedDeque.");
        System.out.println("- Produtor/consumidor com bloqueio e limite? LinkedBlockingDeque.");
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
        System.out.printf("%-55s -> %s%n", label, value);
    }
}