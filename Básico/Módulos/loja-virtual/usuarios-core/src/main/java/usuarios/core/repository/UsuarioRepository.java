package usuarios.core.repository;

import java.util.List;

import usuarios.api.model.Usuario;

public interface UsuarioRepository {

    Usuario salvar(Usuario usuario);

    Usuario buscarPorId(Long id);

    List<Usuario> listar();

}