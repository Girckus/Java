package pagamentos.api.service;

import java.util.List;
import java.util.ServiceLoader;

public class PagamentoSelector {

    public List<PagamentoService> listarFormasPagamento() {

        return ServiceLoader
                .load(PagamentoService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .toList();
    }

    public PagamentoService selecionar(String codigo) {

        return listarFormasPagamento()
                .stream()
                .filter(service ->
                        service.getCodigo()
                               .equalsIgnoreCase(codigo))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Forma de pagamento não encontrada: "
                                + codigo));
    }

}