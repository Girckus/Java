package usuarios.core.repository;

import java.util.ArrayList;
import java.util.List;

import usuarios.api.model.Usuario;

public class UsuarioRepositoryMemoria implements UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario salvar(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Usuario> listar() {
        return List.copyOf(usuarios);
    }

}