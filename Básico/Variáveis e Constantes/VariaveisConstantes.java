public class VariaveisConstantes {
	
	public static final double CM_PER_INCH = 2.54;
	
    public static void main(String[] args) {
        // Variáveis
        int idade = 25;
        double altura = 1.75;
        String nome = "João";
        boolean ativo = true;
		int i, j;
		
		i = 1;
		j = 2;
		
        // Exibindo valores das variáveis
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Ativo: " + ativo);
		System.out.println("i: " + i);
		System.out.println("j: " + j);
		System.out.println("CM_PER_INCH: " + CM_PER_INCH);

        // Constante (final faz com que o valor não possa ser alterado)
        final double PI = 3.14159;
        System.out.println("Valor de PI: " + PI);

        // Tentativa de alterar uma constante (Descomente para ver o erro)
        // PI = 3.14; // Isso geraria um erro de compilação
    }
	
}