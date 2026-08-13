package loja.admin.console;

import loja.admin.service.AdministracaoService;

public class MenuAdministrador {

    private final AdministracaoService service = new AdministracaoService();

    public void executar() {

        System.out.println();

        System.out.println("===== ADMINISTRAÇÃO =====");

        System.out.println();

        System.out.println("Usuários cadastrados:");

        service.listarUsuarios();

        System.out.println();

        service.resetarSenha(1L);

        service.bloquear(2L);

        service.desbloquear(2L);

    }

}