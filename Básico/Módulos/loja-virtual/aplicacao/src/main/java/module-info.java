module br.com.loja.aplicacao {
    requires br.com.loja.usuarios.api;
    requires br.com.loja.pedidos.api;
    requires br.com.loja.validation.runtime;
    requires br.com.loja.pagamentos.api;
    
    uses usuarios.api.service.UsuarioService;
    uses pedidos.api.service.PedidoService;
}