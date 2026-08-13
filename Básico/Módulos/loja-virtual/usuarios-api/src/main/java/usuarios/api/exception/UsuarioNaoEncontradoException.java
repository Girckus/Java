package usuarios.api.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException(Long id) {
        super("Usuário " + id + " não encontrado.");
    }

}