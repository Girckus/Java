module br.com.loja.pedidos.api {

    requires transitive br.com.loja.usuarios.api;

    requires static br.com.loja.validation.api;
    
    exports pedidos.api.model;
    exports pedidos.api.service;
    exports pedidos.api.exception;
    
}