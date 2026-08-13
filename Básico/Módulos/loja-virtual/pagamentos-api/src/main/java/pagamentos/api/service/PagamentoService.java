package pagamentos.api.service;

public interface PagamentoService {

    String getCodigo();

    String getDescricao();

    boolean pagar(double valor);

}