public class Animal {
    String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    // Método final (não pode ser sobrescrito)
    public final void fazerSom() {
        System.out.println(nome + " faz um som.");
    }

    public void mover() {
        System.out.println(nome + " está se movendo.");
    }

    public String getNome() {
        return nome;
    }
}