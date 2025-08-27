import java.time.Duration;

public class ThreadDemo2 {

    private static final int NUM_THREADS = 30;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Comparando Platform Threads e Virtual Threads com " + NUM_THREADS*2 + " tarefas...");

        System.out.println("\n Executando com Platform Threads...");
        long platformTime = runWithPlatformThreads();
        System.out.println("Tempo com Platform Threads: " + platformTime + " ms");

        System.out.println("\n Executando com Virtual Threads...");
        long virtualTime = runWithVirtualThreads();
        System.out.println("Tempo com Virtual Threads: " + virtualTime + " ms");

        System.out.println("\n Diferença: " + (platformTime - virtualTime) + " ms");
    }

    private static long runWithPlatformThreads() throws InterruptedException {
        Runnable task = () -> {
            try {
                System.out.println("Platform Thread ID: " + Thread.currentThread().threadId() + ", isVirtual: " + Thread.currentThread().isVirtual());
                Thread.sleep(Duration.ofMillis(1000)); // usa Duration
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread[] threads = new Thread[NUM_THREADS*2];

        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = Thread.ofPlatform().unstarted(task); // Usando builder de Platform Thread
            threads[i].start();
        }
        
        for (int i = NUM_THREADS; i < NUM_THREADS*2; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join(Duration.ofSeconds(2)); // join com timeout
        }

        return System.currentTimeMillis() - start;
    }

    private static long runWithVirtualThreads() throws InterruptedException {
        Runnable task = () -> {
            try {
                System.out.println("Virtual Thread ID: " + Thread.currentThread().threadId() + ", isVirtual: " + Thread.currentThread().isVirtual());
                Thread.sleep(Duration.ofMillis(1000)); // usa Duration
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread[] threads = new Thread[NUM_THREADS*2];

        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = Thread.ofVirtual().unstarted(task); // Usando builder de Virtual Thread
            threads[i].start();
        }
        
        for (int i = NUM_THREADS; i < NUM_THREADS*2; i++) {
            threads[i] = Thread.startVirtualThread(task);
        }

        for (Thread t : threads) {
            t.join(Duration.ofSeconds(2)); // join com timeout
        }

        return System.currentTimeMillis() - start;
    }
}