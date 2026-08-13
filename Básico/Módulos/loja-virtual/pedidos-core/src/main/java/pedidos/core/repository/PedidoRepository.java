package pedidos.core.repository;

import java.util.List;

import pedidos.api.model.Pedido;

public interface PedidoRepository {

    Pedido salvar(Pedido pedido);

    Pedido buscar(Long numero);

    List<Pedido> listar();

}