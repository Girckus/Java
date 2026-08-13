package loja.admin.service;

import java.util.ServiceLoader;

import usuarios.api.admin.AdministradorUsuario;
import usuarios.api.service.UsuarioService;

public class AdministracaoService {

    private final UsuarioService usuarioService;

    private final AdministradorUsuario administrador = new AdministradorUsuario();

    public AdministracaoService() {
        usuarioService = ServiceLoader.load(UsuarioService.class)
                             		  .findFirst()
                             		  .orElseThrow();
    }

    public void listarUsuarios() {

        usuarioService
                .listar()
                .forEach(System.out::println);

    }

    public void resetarSenha(Long id) {

        administrador.resetarSenha(id);

    }

    public void bloquear(Long id) {

        administrador.bloquear(id);

    }

    public void desbloquear(Long id) {

        administrador.desbloquear(id);

    }

}