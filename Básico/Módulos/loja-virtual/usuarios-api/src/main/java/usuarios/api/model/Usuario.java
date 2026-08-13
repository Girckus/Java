package usuarios.api.model;

import validation.api.constraint.Email;
import validation.api.constraint.MaxLength;
import validation.api.constraint.NotBlank;

public class Usuario {

	private Long id;
	
    @NotBlank
    @MaxLength(100)
    private String nome;

    @Email
    @MaxLength(150)
    private String email;
    
    public Usuario() {
    }

    public Usuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
    public String toString() {
        return id + " - " + nome;
    }

}