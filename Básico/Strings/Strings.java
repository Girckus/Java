public class Strings {

	public static void main(String[] args) {
		
		// Criando Strings
		String e = ""; // string vazia
        String nome = "João";
        String sobrenome = "Silva";
		int idade = 49;
        String nomeCompleto = nome + " " + sobrenome;
		String perfil = nomeCompleto + " " + idade;
        
		System.out.println("string vazia: " + e);
        System.out.println("Nome completo: " + nomeCompleto);
		System.out.println("Perfil: " + perfil);
        
        // Métodos comuns
        System.out.println("Tamanho: " + nomeCompleto.length());
        System.out.println("Maiúsculas: " + nomeCompleto.toUpperCase());
        System.out.println("Minúsculas: " + nomeCompleto.toLowerCase());
        System.out.println("Começa com 'Jo': " + nomeCompleto.startsWith("Jo"));
        System.out.println("Termina com 'va': " + nomeCompleto.endsWith("va"));
        
        // Substituição de caracteres
        String novaString = nomeCompleto.replace("Silva", "Souza");
        System.out.println("Substituição: " + novaString);
        
        // Divisão da string
        String[] partes = nomeCompleto.split(" ");
        System.out.println("Primeiro nome: " + partes[0]);
        System.out.println("Último nome: " + partes[1]);
        
        // Uso do StringBuilder para eficiência em concatenações
        StringBuilder sb = new StringBuilder("Olá");
        sb.append(", ").append(nomeCompleto).append("!");
        System.out.println("Com StringBuilder: " + sb.toString());
		
		String hello = "Hello"; // incializa a string
		if (hello == "Hello") { // provavelmente true
			System.out.println("Hello Iguais");
		}
		
		if (hello.substring(0, 3) == "Hel") { // provavelmente false
			System.out.println("Hel Não Iguais");
		}
		
		String a = new String("NovaString");
		String b = new String("NovaString");
		
		if (a == b) { // false
			System.out.println("string a e string b apontam para o mesmo local na memória");
		} else {
			System.out.println("string a e string b não apontam para o mesmo local na memória");
		}
		
		if (a.equals(b)) { // true
			System.out.println("string a e string b tem o mesmo conteúdo");
		} else {
			System.out.println("string a e string b não tem o mesmo conteúdo");
		}
	}

}