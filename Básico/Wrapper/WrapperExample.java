public class WrapperExample {
    public static void main(String[] args) {
        // Autoboxing: conversão automática de primitivo para Wrapper
        Integer numWrapper = 10; // Equivalente a: Integer numWrapper = Integer.valueOf(10);
        
        // Unboxing: conversão automática de Wrapper para primitivo
        int numPrimitivo = numWrapper; // Equivalente a: int numPrimitivo = numWrapper.intValue();
        
        // Usando métodos da classe Wrapper
        Double valor = 5.75; // Autoboxing
        System.out.println("Valor arredondado: " + Math.round(valor)); // Unboxing implícito
        
        // Comparação entre primitivos e Wrappers
        Integer x = 100;
        Integer y = 100;
        System.out.println("x == y? " + (x == y)); // Pode ser true devido ao cache de valores pequenos

        Integer a = 200;
        Integer b = 200;
        System.out.println("a == b? " + (a == b)); // Pode ser false, pois valores maiores não são cacheados
        
        // Comparação correta entre Wrappers
        System.out.println("a.equals(b)? " + a.equals(b)); // Compara valores corretamente
    }
}