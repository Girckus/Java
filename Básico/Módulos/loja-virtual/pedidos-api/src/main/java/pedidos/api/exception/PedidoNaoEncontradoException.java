package pedidos.api.exception;

public class PedidoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException(Long numero) {
        super("Pedido " + numero + " não encontrado.");
    }

}