package usuarios.core.validator;

public class UsuarioValidator {

    public void validarNome(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório.");
        }

    }

}