module br.com.loja.admin {

    requires br.com.loja.usuarios.api;
    requires br.com.loja.usuarios.core;

    uses usuarios.api.service.UsuarioService;

}