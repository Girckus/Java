package pagamentos.pix;

import pagamentos.api.service.PagamentoService;

public class PixService implements PagamentoService {

    @Override
    public boolean pagar(double valor) {
        System.out.println("Pagamento PIX: " + valor);
        return true;
    }

	@Override
	public String getCodigo() {
		return "PIX";
	}

	@Override
	public String getDescricao() {
		return "Pagamento via PIX";
	}

}