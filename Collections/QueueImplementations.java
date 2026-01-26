import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstra diferenças entre implementações de Queue/BlockingQueue:
 * - ArrayBlockingQueue
 * - ConcurrentLinkedQueue
 * - DelayQueue
 * - LinkedBlockingQueue
 * - LinkedTransferQueue
 * - PriorityBlockingQueue
 * - PriorityQueue
 * - SynchronousQueue
 *
 * Observações:
 * - Filas *Blocking* são para produtor/consumidor (put/take bloqueiam).
 * - Filas concorrentes geralmente NÃO aceitam null.
 * - PriorityQueue/PriorityBlockingQueue ordenam por prioridade, não por inserção.
 */
public class QueueImplementations {

    public static void main(String[] args) throws Exception {
        demoPriorityQueue();
        demoConcurrentLinkedQueue();
        demoArrayBlockingQueue();
        demoLinkedBlockingQueue();
        demoPriorityBlockingQueue();
        demoSynchronousQueue();
        demoLinkedTransferQueue();
        demoDelayQueue();
        demoQuickComparison();
    }

    // =========================================================
    // 1) PriorityQueue (não-bloqueante; ordenada por prioridade)
    // =========================================================
    private static void demoPriorityQueue() {
        section("1) PriorityQueue (não-bloqueante; ordenada por prioridade)");

        Queue<Integer> pq = new java.util.PriorityQueue<>();
        pq.add(5);
        pq.add(1);
        pq.add(3);
        pq.add(2);
        pq.add(4);

        print("Conteúdo interno (não reflete ordem real)", pq);
        System.out.println("poll() -> " + pq.poll()); // menor primeiro (ordem natural)
        System.out.println("poll() -> " + pq.poll());
        print("Após 2 polls", pq);

        // PriorityQueue não aceita null
        try {
            pq.add(null);
        } catch (Exception e) {
            System.out.println("PriorityQueue.add(null) -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 2) ConcurrentLinkedQueue (não-bloqueante; concorrente; FIFO)
    // =========================================================
    private static void demoConcurrentLinkedQueue() {
        section("2) ConcurrentLinkedQueue (não-bloqueante; concorrente; FIFO)");

        Queue<String> q = new ConcurrentLinkedQueue<>();
        q.offer("A");
        q.offer("B");
        q.offer("C");

        print("Conteúdo", q);
        System.out.println("poll() -> " + q.poll());
        print("Após poll()", q);

        // Não aceita null
        try {
            q.offer(null);
        } catch (Exception e) {
            System.out.println("ConcurrentLinkedQueue.offer(null) -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 3) ArrayBlockingQueue (bloqueante; capacidade fixa; FIFO)
    // =========================================================
    private static void demoArrayBlockingQueue() {
        section("3) ArrayBlockingQueue (bloqueante; capacidade fixa; FIFO)");

        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);
        System.out.println("offer(1) -> " + q.offer(1));
        System.out.println("offer(2) -> " + q.offer(2));
        System.out.println("offer(3) quando cheia -> " + q.offer(3)); // false

        print("Conteúdo", q);
        System.out.println("poll() -> " + q.poll());
        print("Após poll()", q);

        // put/take bloqueiam: vamos mostrar com timeout para não travar
        try {
            System.out.println("put(9) com fila não cheia (ok)...");
            q.put(9);
            print("Após put(9)", q);

            System.out.println("offer(10, 100ms) quando cheia -> " + q.offer(10, 100, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // =========================================================
    // 4) LinkedBlockingQueue (bloqueante; opcionalmente limitada; FIFO)
    // =========================================================
    private static void demoLinkedBlockingQueue() throws Exception {
        section("4) LinkedBlockingQueue (bloqueante; encadeada; FIFO)");

        LinkedBlockingQueue<String> q = new LinkedBlockingQueue<>(2); // limite opcional
        q.put("A");
        q.put("B");
        print("Conteúdo", q);

        // put bloqueia se cheia; usamos offer com timeout para demonstrar sem travar
        System.out.println("offer(C, 100ms) quando cheia -> " + q.offer("C", 100, TimeUnit.MILLISECONDS));
        System.out.println("take() -> " + q.take());
        print("Após take()", q);
    }

    // =========================================================
    // 5) PriorityBlockingQueue (bloqueante; ordenada por prioridade)
    // =========================================================
    private static void demoPriorityBlockingQueue() throws Exception {
        section("5) PriorityBlockingQueue (bloqueante; ordenada por prioridade)");

        // Exemplo com ordem reversa (maior primeiro)
        PriorityBlockingQueue<Integer> q =
                new PriorityBlockingQueue<>(11, Comparator.reverseOrder());

        q.put(5);
        q.put(1);
        q.put(3);
        q.put(2);
        q.put(4);

        print("Conteúdo interno (não reflete ordem real)", q);
        System.out.println("take() -> " + q.take()); // maior primeiro (reverseOrder)
        System.out.println("take() -> " + q.take());
        print("Após 2 takes", q);

        // Não aceita null
        try {
            q.put(null);
        } catch (Exception e) {
            System.out.println("PriorityBlockingQueue.put(null) -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 6) SynchronousQueue (zero-capacity; handoff direto)
    // =========================================================
    private static void demoSynchronousQueue() throws Exception {
        section("6) SynchronousQueue (capacidade 0; handoff direto)");

        SynchronousQueue<String> q = new SynchronousQueue<>();

        // offer sem consumidor esperando falha (false)
        System.out.println("offer(\"X\") sem consumidor -> " + q.offer("X"));

        // Agora com consumidor esperando: faremos uma troca com timeout
        ExecutorService ex = Executors.newFixedThreadPool(2);
        try {
            ex.submit(() -> {
                try {
                    String v = q.take(); // bloqueia esperando alguém colocar
                    System.out.println("[consumer] take() -> " + v);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread.sleep(100); // dá tempo do consumidor bloquear no take

            System.out.println("[producer] put(\"HELLO\") (vai liberar o consumer)...");
            q.put("HELLO");

        } finally {
            ex.shutdownNow();
            ex.awaitTermination(1, TimeUnit.SECONDS);
        }
    }

    // =========================================================
    // 7) LinkedTransferQueue (bloqueante; transferência direta opcional)
    // =========================================================
    private static void demoLinkedTransferQueue() throws Exception {
        section("7) LinkedTransferQueue (transfer / tryTransfer)");

        LinkedTransferQueue<String> q = new LinkedTransferQueue<>();

        // Sem consumidor esperando: tryTransfer retorna false
        System.out.println("tryTransfer(\"A\") sem consumidor -> " + q.tryTransfer("A"));
        print("Conteúdo após tryTransfer falhar", q);

        ExecutorService ex = Executors.newFixedThreadPool(2);
        try {
            ex.submit(() -> {
                try {
                    String v = q.take();
                    System.out.println("[consumer] take() -> " + v);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread.sleep(100);

            // transfer bloqueia até alguém consumir
            ex.submit(() -> {
                try {
                    System.out.println("[producer] transfer(\"B\") (bloqueia até consumir)...");
                    q.transfer("B");
                    System.out.println("[producer] transfer(\"B\") concluído!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

        } finally {
            Thread.sleep(200); // tempo para a demo concluir
            ex.shutdownNow();
            ex.awaitTermination(1, TimeUnit.SECONDS);
        }
    }

    // =========================================================
    // 8) DelayQueue (bloqueante; só libera elementos após delay expirar)
    // =========================================================
    private static void demoDelayQueue() throws Exception {
        section("8) DelayQueue (libera itens apenas após atraso)");

        DelayQueue<DelayedTask> q = new DelayQueue<>();

        q.put(new DelayedTask("T1 (200ms)", 200));
        q.put(new DelayedTask("T2 (50ms)", 50));
        q.put(new DelayedTask("T3 (120ms)", 120));

        print("Conteúdo interno (não é ordenação visível confiável)", q);

        long start = System.currentTimeMillis();
        System.out.println("take() -> " + q.take() + " (t+" + (System.currentTimeMillis() - start) + "ms)");
        System.out.println("take() -> " + q.take() + " (t+" + (System.currentTimeMillis() - start) + "ms)");
        System.out.println("take() -> " + q.take() + " (t+" + (System.currentTimeMillis() - start) + "ms)");

        // Não aceita null
        try {
            q.put(null);
        } catch (Exception e) {
            System.out.println("DelayQueue.put(null) -> ERRO: " + e.getClass().getSimpleName());
        }
    }

    // =========================================================
    // 9) Comparativo rápido
    // =========================================================
    private static void demoQuickComparison() {
        section("9) Comparativo rápido (resumo)");

        System.out.println("FIFO (geral): ArrayBlockingQueue, LinkedBlockingQueue, ConcurrentLinkedQueue, LinkedTransferQueue");
        System.out.println("Prioridade (ordena por Comparator/natural): PriorityQueue, PriorityBlockingQueue");
        System.out.println("Handoff direto (capacidade 0): SynchronousQueue");
        System.out.println("Tempo/atraso: DelayQueue (só sai quando delay expira)");
        System.out.println("\nRegras rápidas:");
        System.out.println("- Precisa BLOQUEAR produtor/consumidor? use *BlockingQueue* (put/take).");
        System.out.println("- Precisa de concorrência sem bloqueio? ConcurrentLinkedQueue.");
        System.out.println("- Precisa de capacidade fixa e previsível? ArrayBlockingQueue.");
        System.out.println("- Precisa de prioridade? PriorityQueue / PriorityBlockingQueue.");
        System.out.println("- Precisa trocar item diretamente entre threads? SynchronousQueue / transfer().");
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

    // =========================================================
    // Classe Delayed para DelayQueue
    // =========================================================
    static final class DelayedTask implements Delayed {
        private static final AtomicInteger SEQ = new AtomicInteger(0);

        private final int seq;
        private final String name;
        private final long startNanos; // instante em nanos quando fica disponível

        DelayedTask(String name, long delayMillis) {
            this.seq = SEQ.incrementAndGet();
            this.name = name;
            this.startNanos = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(delayMillis);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long remainingNanos = startNanos - System.nanoTime();
            return unit.convert(remainingNanos, TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            // ordena por tempo de liberação; se empatar, por sequência
            if (this == other) return 0;
            long diff = this.getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS);
            if (diff < 0) return -1;
            if (diff > 0) return 1;
            if (other instanceof DelayedTask o) return Integer.compare(this.seq, o.seq);
            return 0;
        }

        @Override
        public String toString() {
            return "DelayedTask{" + "seq=" + seq + ", name='" + name + '\'' + '}';
        }
    }
}
