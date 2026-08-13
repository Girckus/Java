package usuarios.core.internal;

public final class IdGenerator {

    private static long proximoId = 1;

    private IdGenerator() {
    }

    public static synchronized Long gerar() {
        return proximoId++;
    }

}