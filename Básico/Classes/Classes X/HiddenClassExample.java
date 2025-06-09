import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandle;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HiddenClassExample {
    public static void main(String[] args) throws Throwable {
        // Criando o lookup (necessário para definir Hidden Classes)
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        
        // Suponha que temos o bytecode de uma classe compilada (exemplo fictício)
        byte[] classBytes = Files.readAllBytes(Paths.get("MyDynamicClass.class"));
        
        // Criando a Hidden Class na JVM
        MethodHandles.Lookup hiddenLookup = lookup.defineHiddenClass(classBytes, true, MethodHandles.Lookup.ClassOption.NESTMATE);

        // Obtendo a classe criada
        Class<?> hiddenClass = hiddenLookup.lookupClass();
        System.out.println("Classe oculta criada: " + hiddenClass.getName());

        // Criando uma instância da classe oculta e chamando um método dela
        Object instance = hiddenClass.getDeclaredConstructor().newInstance();
        MethodHandle methodHandle = lookup.findVirtual(hiddenClass, "sayHello", MethodType.methodType(void.class));
        methodHandle.invoke(instance);
    }
}
