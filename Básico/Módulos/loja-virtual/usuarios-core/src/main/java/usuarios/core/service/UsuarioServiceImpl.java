package usuarios.core.service;

import java.util.List;

import usuarios.api.exception.UsuarioNaoEncontradoException;
import usuarios.api.model.Usuario;
import usuarios.api.service.UsuarioService;
import usuarios.core.internal.IdGenerator;
import usuarios.core.repository.UsuarioRepository;
import usuarios.core.repository.UsuarioRepositoryMemoria;
import usuarios.core.validator.UsuarioValidator;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository =  new UsuarioRepositoryMemoria();

    private final UsuarioValidator validator = new UsuarioValidator();

    @Override
    public Usuario cadastrar(String nome, String email) {
        validator.validarNome(nome);

        Usuario usuario = new Usuario(IdGenerator.gerar(), nome, email);

        repository.salvar(usuario);

        return usuario;

    }

    @Override
    public Usuario buscarPorId(Long id) {
        Usuario usuario = repository.buscarPorId(id);

        if (usuario == null) {
            throw new UsuarioNaoEncontradoException(id);
        }

        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }

}