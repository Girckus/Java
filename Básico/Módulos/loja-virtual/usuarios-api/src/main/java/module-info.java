module br.com.loja.usuarios.api {

    exports usuarios.api.model;
    exports usuarios.api.service;
    exports usuarios.api.exception;
    
    requires static br.com.loja.validation.api;
    
    exports usuarios.api.admin
    to br.com.loja.admin;
    
    opens usuarios.api.model
    to br.com.loja.validation.runtime;
	
}