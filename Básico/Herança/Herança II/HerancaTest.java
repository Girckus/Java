public class HerancaTest {
    public static void main(String[] args) {
        // Criando objetos
        Animal cachorro1 = new Cachorro("Rex");
        Animal cachorro2 = new Cachorro("Max");
        Animal gato1 = new Gato("Felix");

        // Upcasting (Cachorro -> Animal)
        Animal animal = cachorro;
        animal.fazerSom();  // Chama método final da classe Animal
        animal.mover();  // Chama método da classe Animal

        // ========= Exemplo tradicional de instanceof (Java 15 ou inferior) =========
        if (cachorro1 instanceof Cachorro) {
            Cachorro cachorroConvertido = (Cachorro) cachorro1;
            cachorroConvertido.latir();
        }

        // ========= Pattern Matching com instanceof (Java 16+) =========
        if (cachorro1 instanceof Cachorro cachorroNovo) {
            cachorroNovo.latir();
        }

        // ========= instanceof com condição extra =========
        if (cachorro1 instanceof Cachorro c && c.getNome().startsWith("R")) {
            System.out.println(c.getNome() + " tem um nome que começa com R!");
        }

        if (gato1 instanceof Gato g && g.getNome().equals("Felix")) {
            System.out.println(g.getNome() + " é um gato famoso!");
        }

        // Outro exemplo: um cachorro que não atende ao critério
        if (cachorro2 instanceof Cachorro c && c.getNome().startsWith("R")) {
            System.out.println(c.getNome() + " tem um nome que começa com R!");
        } else {
            System.out.println(cachorro2.getNome() + " NÃO tem um nome que começa com R!");
        }

        // Tentativa de instanciar e usar a classe final
        AnimalSelvagem leao = new AnimalSelvagem();
        leao.rugir();
    }
}