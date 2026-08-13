package pedidos.core.repository;

import java.util.ArrayList;
import java.util.List;

import pedidos.api.model.Pedido;

public class PedidoRepositoryMemoria implements PedidoRepository {

    private final List<Pedido> pedidos = new ArrayList<>();

    @Override
    public Pedido salvar(Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }

    @Override
    public Pedido buscar(Long numero) {
        return pedidos.stream()
                .filter(p -> p.getNumero().equals(numero))
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Pedido> listar() {
        return List.copyOf(pedidos);
    }

}