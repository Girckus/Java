package pedidos.api.service;

import java.util.List;

import pedidos.api.model.Pedido;
import usuarios.api.model.Usuario;

public interface PedidoService {

    Pedido criarPedido(Usuario cliente);

    void adicionarItem(Pedido pedido, String produto, int quantidade, double valorUnitario);

    Pedido buscar(Long numero);

    List<Pedido> listar();
    
    void pagar(Pedido pedido, String formaPagamento);

}