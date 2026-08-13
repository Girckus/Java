package pagamentos.cartao;

import pagamentos.api.service.PagamentoService;

public class CartaoService implements PagamentoService {

    @Override
    public boolean pagar(double valor) {
        System.out.println("Pagamento Castão: " + valor);
        return true;
    }

	@Override
	public String getCodigo() {
		return "CARTAO";
	}

	@Override
	public String getDescricao() {
		return "Pagamento via cartão";
	}

}