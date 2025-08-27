import java.time.Duration;
import java.util.concurrent.ThreadFactory;

public class ThreadBuilderFullExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Platform Threads ===");
        runPlatformThreads();

        System.out.println("\n=== Virtual Threads ===");
        runVirtualThreads();
    }

    // Exemplo usando Thread.Builder.OfPlatform
    private static void runPlatformThreads() throws InterruptedException {
        // Cria um builder específico para threads de plataforma
        Thread.Builder.OfPlatform platformBuilder = Thread.ofPlatform()
                .name("platform-worker-", 100) // prefixo com contador
                .inheritInheritableThreadLocals(false)
                .uncaughtExceptionHandler((t, e) -> {
                    System.out.println("[Platform] Erro na thread " + t.getName() + ": " + e.getMessage());
                });

        Runnable task = () -> {
            System.out.println("Thread: " + Thread.currentThread().getName() +
                    ", ID: " + Thread.currentThread().threadId() +
                    ", Virtual: " + Thread.currentThread().isVirtual());
            try {
                Thread.sleep(Duration.ofMillis(300));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // start(task): cria e inicia a thread
        platformBuilder.start(task);

        // unstarted(task): cria, mas não inicia
        Thread t = platformBuilder.unstarted(task);
        System.out.println("Criada (ainda não iniciada): " + t.getName());
        t.start();
        t.join();

        // Criando via factory()
        ThreadFactory factory = platformBuilder.factory();
        for (int i = 0; i < 3; i++) {
            Thread thread = factory.newThread(task);
            thread.start();
        }
    }

    // Exemplo usando Thread.Builder.OfVirtual
    private static void runVirtualThreads() throws InterruptedException {
        // Cria um builder específico para threads virtuais
        Thread.Builder.OfVirtual virtualBuilder = Thread.ofVirtual()
                .name("virtual-task-")
                .inheritInheritableThreadLocals(true)
                .uncaughtExceptionHandler((t, e) -> {
                    System.out.println("[Virtual] Erro na thread " + t.getName() + ": " + e.getMessage());
                });

        Runnable task = () -> {
            System.out.println("Thread: " + Thread.currentThread().getName() +
                    ", ID: " + Thread.currentThread().threadId() +
                    ", Virtual: " + Thread.currentThread().isVirtual());
            try {
                Thread.sleep(Duration.ofMillis(300));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // start(task): cria e inicia a thread virtual
        virtualBuilder.start(task);

        // unstarted(task): cria mas não inicia
        Thread t = virtualBuilder.unstarted(task);
        System.out.println("Criada (ainda não iniciada): " + t.getName());
        t.start();
        t.join();

        // Criando várias via factory()
        ThreadFactory factory = virtualBuilder.factory();
        for (int i = 0; i < 3; i++) {
            Thread thread = factory.newThread(task);
            thread.start();
        }
    }
}
