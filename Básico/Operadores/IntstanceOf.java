public class IntstanceOf {

    public static void main(String[] args) {
		Object obj = new String("Teste");
		
        if (obj instanceof String) {
			String s = (String) obj; // necessidade de cast
			System.out.println("String com length: " + s.length());
		}
		
		if (obj instanceof String s) { // faz o cast e a verificação ao mesmo tempo
			System.out.println("String com length: " + s.length());
		}
		
		if (obj instanceof String s && s.length > 2) { // faz o cast e a verificação ao mesmo tempo e condicional se a string tem tamanho maior que 2
			System.out.println("String com length: " + s.length());
		}
		
    }

}