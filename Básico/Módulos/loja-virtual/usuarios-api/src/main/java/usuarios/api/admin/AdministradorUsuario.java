package usuarios.api.admin;

public class AdministradorUsuario {

    public void resetarSenha(Long id) {
        System.out.println("Senha do usuário " + id + " redefinida.");
    }

    public void bloquear(Long id) {
        System.out.println("Usuário " + id + " bloqueado.");
    }

    public void desbloquear(Long id) {
        System.out.println("Usuário " + id + " desbloqueado.");
    }

}