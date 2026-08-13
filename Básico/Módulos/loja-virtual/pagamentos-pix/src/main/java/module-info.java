module br.com.loja.pagamentos.pix {

    requires br.com.loja.pagamentos.api;

    provides pagamentos.api.service.PagamentoService
    with pagamentos.pix.PixService;

}