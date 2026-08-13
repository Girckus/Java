module br.com.loja.pedidos.core {

    requires br.com.loja.pedidos.api;
    requires br.com.loja.pagamentos.api;

    provides pedidos.api.service.PedidoService
    with pedidos.core.service.PedidoServiceImpl;
	
}