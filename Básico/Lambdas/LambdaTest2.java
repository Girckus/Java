import java.util.*;
import java.util.function.*;

public class LambdaTest2 {
    public static void main(String[] args) {
        // Lista de nomes
        List<String> nomes = Arrays.asList("Ana", "Bruno", "Carlos", "Beatriz", "Amanda");

        // 1. Lambda sem parâmetro
        Runnable saudacao = () -> System.out.println("Bem-vindo ao exemplo de lambdas!");
        saudacao.run();

        // 2. Lambda com um parâmetro (sem tipo explícito)
        nomes.forEach(nome -> System.out.println("Nome: " + nome));

        // 3. Lambda com um parâmetro (com tipo explícito)
        nomes.forEach((String nome) -> System.out.println("-> " + nome));

        // 4. Lambda com vários parâmetros (sem tipo explícito)
        Comparator<String> comparador1 = (s1, s2) -> s1.compareToIgnoreCase(s2);
        Collections.sort(nomes, comparador1);
        System.out.println("Ordenado (ignora maiúsculas/minúsculas): " + nomes);

        // 5. Lambda com vários parâmetros (com tipo explícito)
        Comparator<String> comparador2 = (String s1, String s2) -> s1.length() - s2.length();
        nomes.sort(comparador2);
        System.out.println("Ordenado por tamanho: " + nomes);

        // 6. Lambda com expressão simples (sem chaves)
        Function<Integer, Integer> quadrado = x -> x * x;
        System.out.println("Quadrado de 4: " + quadrado.apply(4));

        // 7. Lambda com múltiplas instruções (com chaves e return)
        Function<Integer, Integer> cubo = x -> {
            int resultado = x * x * x;
            return resultado;
        };
        System.out.println("Cubo de 3: " + cubo.apply(3));

        // 8. Lambda com tipo de retorno complexo
        BiFunction<Integer, Integer, String> somador = (a, b) -> {
            int soma = a + b;
            return "Resultado: " + soma;
        };
        System.out.println(somador.apply(5, 7));

        // 9. Lambda como argumento direto
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        numeros.stream()
               .filter(n -> n % 2 == 0)
               .forEach(n -> System.out.println("Número par: " + n));

        // 10. Lambda usando 'var' nos parâmetros (Java 11+)
        nomes.forEach((var nome) -> System.out.println("Usando var: " + nome));

        // 11. Lambda com 'var' e anotação
        Comparator<String> comparadorComVar = (@NonNull var a, @NonNull var b) -> {
            return a.length() - b.length();
        };
        nomes.sort(comparadorComVar);
        System.out.println("Ordenado por tamanho (com var): " + nomes);
    }
}
