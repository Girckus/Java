package pedidos.core.service;

import java.util.List;

import pagamentos.api.service.PagamentoSelector;
import pagamentos.api.service.PagamentoService;
import pedidos.api.exception.PedidoNaoEncontradoException;
import pedidos.api.model.ItemPedido;
import pedidos.api.model.Pedido;
import pedidos.api.service.PedidoService;
import pedidos.core.internal.NumeroPedidoGenerator;
import pedidos.core.repository.PedidoRepository;
import pedidos.core.repository.PedidoRepositoryMemoria;
import pedidos.core.validator.PedidoValidator;
import usuarios.api.model.Usuario;

public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository = new PedidoRepositoryMemoria();

    private final PedidoValidator validator = new PedidoValidator();
    
    private final PagamentoSelector pagamentoSelector = new PagamentoSelector();

    @Override
    public Pedido criarPedido(Usuario cliente) {
        Pedido pedido = new Pedido(NumeroPedidoGenerator.gerar(), cliente);

        validator.validar(pedido);

        repository.salvar(pedido);

        return pedido;
    }

    @Override
    public void adicionarItem(Pedido pedido, String produto, int quantidade, double valorUnitario) {
        pedido.adicionarItem(new ItemPedido(produto, quantidade, valorUnitario));
    }

    @Override
    public Pedido buscar(Long numero) {
        Pedido pedido = repository.buscar(numero);

        if (pedido == null) {
            throw new PedidoNaoEncontradoException(numero);
        }

        return pedido;
    }

    @Override
    public List<Pedido> listar() {
        return repository.listar();
    }
    
    @Override
    public void pagar(Pedido pedido, String formaPagamento) {

        PagamentoService pagamento = pagamentoSelector.selecionar(formaPagamento);

        System.out.println("Processando pagamento do pedido " + pedido.getNumero());

        pagamento.pagar(pedido.getTotal());

    }

}