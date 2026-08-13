package pedidos.api.model;

import validation.api.constraint.NotBlank;

public class ItemPedido {

	@NotBlank
    private String produto;

	@NotBlank
    private int quantidade;

	@NotBlank
    private double valorUnitario;

    public ItemPedido() {
    }

    public ItemPedido(String produto, int quantidade, double valorUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;

    }

    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getSubtotal() {
        return quantidade * valorUnitario;
    }

}