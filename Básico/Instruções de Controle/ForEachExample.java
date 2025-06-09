import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        // Exemplo com um array de números
        int[] numeros = {1, 2, 3, 4, 5};
        System.out.println("Números no array:");
        for (int numero : numeros) {
            System.out.println(numero);
        }
        
        // Exemplo com uma lista de Strings
        List<String> nomes = Arrays.asList("Ana", "Bruno", "Carlos", "Diana");
        System.out.println("\nNomes na lista:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}