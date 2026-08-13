package pedidos.core.validator;

import pedidos.api.model.Pedido;

public class PedidoValidator {

    public void validar(Pedido pedido) {
        if (pedido.getCliente() == null) {
            throw new IllegalArgumentException("Pedido sem cliente.");
        }
    }

}