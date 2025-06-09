public class PatternMatchingSwitch {

    public static void main(String[] args) {
        printInfo(42);         // Saída: É um número inteiro positivo: 42
        printInfo(-7);         // Saída: É um número inteiro negativo: -7
        printInfo("java");     // Saída: É uma string curta: JAVA
        printInfo("programação"); // Saída: É uma string longa: PROGRAMAÇÃO
        printInfo(3.14);       // Saída: É um número decimal: 3.14
        printInfo(null);       // Saída: Valor nulo recebido!
        printInfo(true);       // Saída: É um valor booleano.
    }

    static void printInfo(Object obj) {
        switch (obj) {
            case Integer i when i > 0 -> System.out.println("É um número inteiro positivo: " + i);
            case Integer i when i < 0 -> System.out.println("É um número inteiro negativo: " + i);
            case String s when s.length() <= 5 -> System.out.println("É uma string curta: " + s.toUpperCase());
            case String s -> System.out.println("É uma string longa: " + s.toUpperCase());
            case Double d  -> System.out.println("É um número decimal: " + d);
            case null      -> System.out.println("Valor nulo recebido!");
            case Boolean _ -> System.out.println("É um valor booleano.");
            default        -> System.out.println("Outro tipo desconhecido: " + obj);
        }
    }

}