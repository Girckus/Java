module br.com.loja.usuarios.core {

    requires br.com.loja.usuarios.api;

    provides usuarios.api.service.UsuarioService
    with usuarios.core.service.UsuarioServiceImpl;

}