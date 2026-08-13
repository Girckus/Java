package pedidos.api.model;

import java.util.ArrayList;
import java.util.List;

import usuarios.api.model.Usuario;

public class Pedido {

    private Long numero;

    private Usuario cliente;

    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Long numero, Usuario cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public Long getNumero() {
        return numero;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double getTotal() {

        return itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();

    }

}