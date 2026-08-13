module br.com.loja.pagamentos.cartao {

    requires br.com.loja.pagamentos.api;

    provides pagamentos.api.service.PagamentoService
    with pagamentos.cartao.CartaoService;

}