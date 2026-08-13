package usuarios.api.service;

import java.util.List;

import usuarios.api.model.Usuario;

public interface UsuarioService {

    Usuario cadastrar(String nome, String email);

    Usuario buscarPorId(Long id);

    List<Usuario> listar();

}