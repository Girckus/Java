public class LocalVariableTypeInference {
    public static void main(String[] args) {
        var mensagem = "Olá, mundo!"; // tipo inferido como String
        var numeros = new ArrayList<Integer>(); // tipo inferido como ArrayList<Integer>
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        var soma = numeros.stream().mapToInt(Integer::intValue).sum(); // tipo inferido como int
        System.out.println(mensagem);
        System.out.println("A soma dos números é " + soma);
    }
}