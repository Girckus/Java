import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListImplementations {

    public static void main(String[] args) {
        demoArrayList();
        demoLinkedList();
        demoCopyOnWriteArrayList();
        demoQuickComparison();
    }

    // =========================================================
    // 1) ArrayList
    // =========================================================
    private static void demoArrayList() {
        section("1) ArrayList");

        List<String> list = new ArrayList<>();

        // Ordem mantida, duplicatas e null permitidos
        list.add("B");
        list.add("A");
        list.add("A");   // duplicata
        list.add(null);  // permitido
        list.add("C");

        print("Conteúdo inicial", list);

        // Acesso rápido por índice (O(1))
        System.out.println("get(1) -> " + list.get(1));

        // Inserção no meio: precisa "empurrar" elementos (O(n))
        list.add(2, "X");
        print("Após add(2, X)", list);

        // Remoção no meio: precisa "puxar" elementos (O(n))
        list.remove(2);
        print("Após remove(2)", list);

        // Iteração + modificação estrutural normalmente dá erro
        try {
            for (String s : list) {
                if ("B".equals(s)) {
                    list.add("NEW"); // modifica durante foreach -> geralmente explode
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Modificar durante foreach -> ERRO: ConcurrentModificationException");
        }

        print("Final", list);
    }

    // =========================================================
    // 2) LinkedList
    // =========================================================
    private static void demoLinkedList() {
        section("2) LinkedList");

        LinkedList<String> list = new LinkedList<>();

        // Ordem mantida, duplicatas e null permitidos
        list.add("B");
        list.add("A");
        list.add("A");
        list.add(null);
        list.add("C");

        print("Conteúdo inicial", list);

        // get(index) é O(n) (tem que caminhar nós)
        System.out.println("get(1) -> " + list.get(1) + "  (em LinkedList é O(n))");

        // Inserções/remoções no começo/fim são O(1) (bem natural em LinkedList como Deque)
        list.addFirst("FIRST");
        list.addLast("LAST");
        print("Após addFirst/addLast", list);

        System.out.println("removeFirst() -> " + list.removeFirst());
        System.out.println("removeLast()  -> " + list.removeLast());
        print("Após removeFirst/removeLast", list);

        // Inserção no meio ainda é O(n) porque precisa navegar até o índice
        list.add(2, "X");
        print("Após add(2, X)", list);

        list.remove(2);
        print("Após remove(2)", list);

        // Como fila/pilha (Deque)
        list.offer("Q1"); // enfileira
        list.offer("Q2");
        print("Após offer(Q1,Q2) [fila]", list);
        System.out.println("poll() -> " + list.poll()); // desenfileira
        print("Após poll() [fila]", list);

        list.push("S1"); // empilha (topo no início)
        list.push("S2");
        print("Após push(S1,S2) [pilha]", list);
        System.out.println("pop() -> " + list.pop()); // desempilha
        print("Após pop() [pilha]", list);

        // Iteração + modificação estrutural também costuma dar erro
        try {
            for (String s : list) {
                if ("B".equals(s)) {
                    list.add("NEW"); // modifica durante foreach
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Modificar durante foreach -> ERRO: ConcurrentModificationException");
        }

        print("Final", list);
    }

    // =========================================================
    // 3) CopyOnWriteArrayList
    // =========================================================
    private static void demoCopyOnWriteArrayList() {
        section("3) CopyOnWriteArrayList");

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Ordem mantida, duplicatas e null permitidos
        list.add("B");
        list.add("A");
        list.add("A");
        list.add(null);
        list.add("C");

        print("Conteúdo inicial", list);

        // get(index) é O(1) (array)
        System.out.println("get(1) -> " + list.get(1));

        // A diferença principal: em qualquer modificação (add/remove),
        // ele COPIA o array internamente -> escrita é cara, leitura/iteração é excelente.
        list.add(2, "X");
        print("Após add(2, X) [copia array]", list);

        list.remove(2);
        print("Após remove(2) [copia array]", list);

        // Iteração segura: NÃO lança ConcurrentModificationException
        // e o foreach enxerga um "snapshot" (fotografia) da lista no início do loop.
        int before = list.size();
        for (String s : list) {
            if ("B".equals(s)) {
                list.add("NEW"); // permitido durante foreach
            }
            System.out.println("Iterando (snapshot): " + s);
        }
        int after = list.size();

        System.out.println("Tamanho antes do foreach: " + before);
        System.out.println("Tamanho após  do foreach: " + after);
        System.out.println("Obs.: o foreach não viu o NEW durante a mesma iteração (snapshot).");

        print("Final", list);
    }

    // =========================================================
    // 4) Comparativo rápido (mesmo conjunto de operações)
    // =========================================================
    private static void demoQuickComparison() {
        section("4) Comparativo rápido (mesmas operações)");

        List<String> a = new ArrayList<>();
        List<String> l = new LinkedList<>();
        List<String> c = new CopyOnWriteArrayList<>();

        for (List<String> list : List.of(a, l, c)) {
            list.addAll(Arrays.asList("A", "B", "C"));
        }

        // Operações iguais em todas
        a.add(1, "X");
        l.add(1, "X");
        c.add(1, "X");

        a.remove("B");
        l.remove("B");
        c.remove("B");

        print("ArrayList", a);
        print("LinkedList", l);
        print("CopyOnWriteArrayList", c);

        System.out.println("\nDiferenças chave:");
        System.out.println("- ArrayList: get(index) rápido; add/remove no meio desloca elementos.");
        System.out.println("- LinkedList: ótimo para add/remove no início/fim; get(index) é lento (caminha nós).");
        System.out.println("- CopyOnWriteArrayList: thread-safe e iteração por snapshot; escrita é cara (copia array).");
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

    private static void print(String label, List<?> list) {
        System.out.printf("%-35s -> %s%n", label, list);
    }
}