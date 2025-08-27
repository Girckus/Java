import java.util.concurrent.*;

public class FutureStateExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarefa = () -> {
            Thread.sleep(1000); // Simula execução
            return "Resultado da tarefa";
        };

        Future<String> future = executor.submit(tarefa);

        System.out.println(" Estado inicial: " + future.state()); // Deve ser RUNNING

        // Verifica enquanto ainda está rodando
        while (!future.isDone()) {
            System.out.println(" Estado intermediário: " + future.state());
            Thread.sleep(300);
        }

        System.out.println(" Estado final: " + future.state());

        if (future.state() == Future.State.SUCCESS) {
            System.out.println("Resultado: " + future.resultNow());
        }
		
		Callable<String> erro = () -> {
			throw new RuntimeException("Erro simulado");
		};

		Future<String> futureErro = executor.submit(erro);

		while (!futureErro.isDone()) { Thread.sleep(100); }

		System.out.println("Estado com falha: " + futureErro.state());
		System.out.println("Exceção: " + futureErro.exceptionNow());
		
		Callable<String> longa = () -> {
			Thread.sleep(2000);
			return "demorado";
		};

		Future<String> futureCancelado = executor.submit(longa);
		Thread.sleep(100); // espera um pouco
		futureCancelado.cancel(true);

		System.out.println("Estado cancelado: " + futureCancelado.state());

        executor.shutdown();
    }
}
