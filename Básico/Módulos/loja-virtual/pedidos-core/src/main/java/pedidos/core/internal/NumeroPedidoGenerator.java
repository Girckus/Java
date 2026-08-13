package pedidos.core.internal;

public final class NumeroPedidoGenerator {

    private static long numero = 1000;

    private NumeroPedidoGenerator() {
    }

    public static synchronized Long gerar() {
        return ++numero;
    }

}