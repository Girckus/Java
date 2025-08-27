import java.util.Random;
import java.util.concurrent.*;

public class FutureDemo2 {

    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        ExecutorService threadpool = Executors.newFixedThreadPool(3);

        GerarNumeroAleatorio tarefa1 = new GerarNumeroAleatorio();
        GerarNumeroAleatorio tarefa2 = new GerarNumeroAleatorio();
        GerarNumeroAleatorio tarefa3 = new GerarNumeroAleatorio();

        System.out.println("Processando a tarefa ...");
        Future<Integer> futureT1 = threadpool.submit(tarefa1);
        Future<Integer> futureT2 = threadpool.submit(tarefa2);
        Future<Integer> futureT3 = threadpool.submit(tarefa3);

        while (!futureT1.isDone() && !futureT2.isDone() && !futureT3.isDone()) {
            System.out.println("As tarefas ainda não foram processadas!");
            Thread.sleep(1); // 1 ms

            if (rand.nextBoolean()) futureT1.cancel(true);
            if (rand.nextBoolean()) futureT2.cancel(true);
            if (rand.nextBoolean()) futureT3.cancel(true);
        }

        System.out.println("Tarefa completa!");

        // Análise com métodos modernos (Java 21+)
        analyzeFuture("Tarefa 1", futureT1);
        analyzeFuture("Tarefa 2", futureT2);
        analyzeFuture("Tarefa 3", futureT3);

        threadpool.shutdown();
    }

    private static void analyzeFuture(String label, Future<Integer> future) {
        System.out.println("\n " + label);
        System.out.println("Estado: " + future.state());

        if (future.isCancelled()) {
            System.out.println("Cancelada");
        } else {
            try {
                // resultNow e exceptionNow só devem ser chamados se isDone() for true e isCancelled() for false
                Integer result = future.resultNow(); // Não bloqueia
                System.out.println("Resultado imediato: " + result);
            } catch (IllegalStateException e) {
                System.out.println("Resultado não disponível: tarefa ainda em execução ou falhou");
            }

            try {
                Throwable ex = future.exceptionNow(); // Exceção lançada, se houver
                if (ex != null) {
                    System.out.println("Exceção lançada: " + ex.getMessage());
                } else {
                    System.out.println("Sem exceção");
                }
            } catch (IllegalStateException e) {
                System.out.println("Exceção não disponível: tarefa ainda em execução");
            }
        }
    }
}

class GerarNumeroAleatorio implements Callable<Integer> {

    @Override
    public Integer call() throws InterruptedException {
        Random rand = new Random();
        int number = rand.nextInt(100);

        Thread.sleep(1000); // Simula tempo de execução

        return number;
    }
}
