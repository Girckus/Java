package aplicacao;

import java.util.List;
import java.util.ServiceLoader;

import pagamentos.api.service.PagamentoSelector;
import pagamentos.api.service.PagamentoService;
import pedidos.api.model.Pedido;
import pedidos.api.service.PedidoService;
import usuarios.api.model.Usuario;
import usuarios.api.service.UsuarioService;
import validation.runtime.ValidationService;

public class Main {

    public static void main(String[] args) {
    	
    	UsuarioService usuarioService = carregarServico(UsuarioService.class);

        PedidoService pedidoService = carregarServico(PedidoService.class);
        
        ValidationService validation = new ValidationService();
        Usuario usuarioInvalido = new Usuario(10L, "", "email-invalido");
        List<String> erros =  validation.validar(usuarioInvalido);
        erros.forEach(erro -> System.out.println("ERRO: " + erro));
        
        Usuario joao = usuarioService.cadastrar("João Silva", "joaosilva@email.com");

        Usuario maria = usuarioService.cadastrar("Maria Oliveira", "mariazinha@supermail.com");

        System.out.println("=== Usuários ===");

        usuarioService.listar().forEach(System.out::println);

        System.out.println();

        Pedido pedido = pedidoService.criarPedido(joao);

        pedidoService.adicionarItem(pedido, "Notebook", 1, 4500.00);

        pedidoService.adicionarItem(pedido, "Mouse Gamer", 2, 180.00);

        pedidoService.adicionarItem(pedido, "Teclado Mecânico", 1, 520.00);

        System.out.println("=== Pedido 1001 ===");

        System.out.println("Número: " + pedido.getNumero());

        System.out.println("Cliente: " + pedido.getCliente().getNome());

        System.out.println();

        System.out.println("Itens:");

        pedido.getItens().forEach(item ->
                System.out.printf(
                        "%dx %-20s R$ %.2f%n",
                        item.getQuantidade(),
                        item.getProduto(),
                        item.getSubtotal())

        );

        System.out.println();

        System.out.printf("TOTAL: R$ %.2f%n", pedido.getTotal());
        
        System.out.println();
        
        Pedido pedido2 = pedidoService.criarPedido(maria);

        pedidoService.adicionarItem(pedido2, "Bijuteria", 5, 4.00);

        pedidoService.adicionarItem(pedido2, "Creme para as mãos", 3, 12.00);

        pedidoService.adicionarItem(pedido2, "Bolsa", 1, 120.00);

        System.out.println("=== Pedido 1002 ===");

        System.out.println("Número: " + pedido2.getNumero());

        System.out.println("Cliente: " + pedido2.getCliente().getNome());

        System.out.println();

        System.out.println("Itens:");

        pedido2.getItens().forEach(item ->
                System.out.printf(
                        "%dx %-20s R$ %.2f%n",
                        item.getQuantidade(),
                        item.getProduto(),
                        item.getSubtotal())

        );

        System.out.println();

        System.out.printf("TOTAL: R$ %.2f%n", pedido2.getTotal());
        
        System.out.println("Meios de pagamento encontrados:");
        PagamentoSelector selector = new PagamentoSelector();
        List<PagamentoService> pagamentos = selector.listarFormasPagamento();
        
        System.out.println("Formas de pagamento disponíveis:");

        System.out.println();

        for (PagamentoService pagamento : pagamentos) {
            System.out.println( pagamento.getCodigo() + " - "  + pagamento.getDescricao());
        }
        
        pedidoService.pagar(pedido, "PIX");
        pedidoService.pagar(pedido2, "CARTAO");
    }
    
    private static <T> T carregarServico(Class<T> tipo) {

        ServiceLoader<T> loader = ServiceLoader.load(tipo);

        return loader.findFirst()
                .orElseThrow(() -> new IllegalStateException("Nenhum serviço encontrado para " + tipo.getSimpleName()));

    }
    
}