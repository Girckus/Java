import java.util.*;

/**
 * Demonstra ordenação com Comparable e Comparator:
 * - Comparable: ordem natural da classe
 * - Comparator: ordens alternativas / externas
 */
public class ComparableComparatorExamples {

    public static void main(String[] args) {
        demoComparable();
        demoComparatorBasic();
        demoComparatorLambda();
        demoComparatorComparing();
        demoComparatorChaining();
        demoReverseOrder();
        demoNullHandling();
        demoWithTreeStructures();
        demoQuickComparison();
    }

    // =========================================================
    // 1) Comparable (ordem natural)
    // =========================================================
    private static void demoComparable() {
        section("1) Comparable (ordem natural)");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Carlos", 30));
        people.add(new Person("Ana", 25));
        people.add(new Person("Bruno", 40));

        print("Antes", people);

        Collections.sort(people); // usa compareTo
        print("Depois (Comparable)", people);

        System.out.println("Obs.: Comparable define UMA ordem natural para a classe.");
    }

    // =========================================================
    // 2) Comparator básico (classe separada)
    // =========================================================
    private static void demoComparatorBasic() {
        section("2) Comparator básico (classe externa)");

        List<Person> people = samplePeople();

        people.sort(new PersonAgeComparator());
        print("Ordenado por idade", people);
    }

    // =========================================================
    // 3) Comparator com lambda
    // =========================================================
    private static void demoComparatorLambda() {
        section("3) Comparator com lambda");

        List<Person> people = samplePeople();

        people.sort((p1, p2) -> p1.name.compareTo(p2.name));
        print("Ordenado por nome", people);
    }

    // =========================================================
    // 4) Comparator.comparing
    // =========================================================
    private static void demoComparatorComparing() {
        section("4) Comparator.comparing");

        List<Person> people = samplePeople();

        people.sort(Comparator.comparing(p -> p.age));
        print("Ordenado por idade", people);

        people.sort(Comparator.comparing(p -> p.name));
        print("Ordenado por nome", people);
    }

    // =========================================================
    // 5) Encadeamento (thenComparing)
    // =========================================================
    private static void demoComparatorChaining() {
        section("5) thenComparing (ordenação composta)");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Ana", 30));
        people.add(new Person("Ana", 20));
        people.add(new Person("Bruno", 20));
        people.add(new Person("Bruno", 40));

        print("Antes", people);

        people.sort(
                Comparator
                        .comparing((Person p) -> p.name)
                        .thenComparing(p -> p.age)
        );

        print("Depois (nome, depois idade)", people);
    }

    // =========================================================
    // 6) Ordem reversa
    // =========================================================
    private static void demoReverseOrder() {
        section("6) Ordem reversa");

        List<Person> people = samplePeople();

        people.sort(Comparator.comparing((Person p) -> p.age).reversed());
        print("Idade decrescente", people);

        people.sort(Comparator.reverseOrder()); // usa Comparable invertido
        print("Ordem natural reversa (nome)", people);
    }

    // =========================================================
    // 7) Tratamento de null (nullsFirst / nullsLast)
    // =========================================================
    private static void demoNullHandling() {
        section("7) nullsFirst / nullsLast");

        List<Person> people = new ArrayList<>();
        people.add(new Person("Carlos", 30));
        people.add(null);
        people.add(new Person("Ana", 25));

        print("Antes", people);

        people.sort(
                Comparator.nullsLast(
                        Comparator.comparing((Person p) -> p.name)
                )
        );

        print("Depois (nullsLast)", people);
    }

    // =========================================================
    // 8) Uso com TreeSet e TreeMap
    // =========================================================
    private static void demoWithTreeStructures() {
        section("8) TreeSet / TreeMap com Comparator");

        // TreeSet com Comparator customizado
        Set<Person> set = new TreeSet<>(Comparator.comparing(p -> p.age));
        set.addAll(samplePeople());
        print("TreeSet (ordenado por idade)", set);

        // TreeMap com Comparator customizado
        Map<Person, String> map = new TreeMap<>(
                Comparator.comparing(p -> p.name)
        );
        map.put(new Person("Carlos", 30), "Dev");
        map.put(new Person("Ana", 25), "QA");
        map.put(new Person("Bruno", 40), "PO");

        print("TreeMap (ordenado por nome)", map);
    }

    // =========================================================
    // 9) Comparativo final
    // =========================================================
    private static void demoQuickComparison() {
        section("9) Quando usar Comparable vs Comparator");

        System.out.println("""
        Comparable:
        - Define a ORDEM NATURAL da classe
        - Implementado dentro da classe
        - Apenas UMA ordem
        - Ex.: String, Integer
        
        Comparator:
        - Define ordens ALTERNATIVAS
        - Fora da classe
        - Pode ter várias
        - Mais flexível (lambda, chaining, nulls)
        
        Regras práticas:
        - A classe TEM um conceito natural de ordem? -> Comparable
        - Precisa ordenar de formas diferentes?     -> Comparator
        - TreeSet/TreeMap exigem Comparable ou Comparator
        """);
    }

    // =========================================================
    // Helpers / modelos
    // =========================================================
    private static List<Person> samplePeople() {
        return new ArrayList<>(List.of(
                new Person("Carlos", 30),
                new Person("Ana", 25),
                new Person("Bruno", 40)
        ));
    }

    private static void section(String title) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println(title);
        System.out.println("==================================================");
    }

    private static void print(String label, Object value) {
        System.out.printf("%-35s -> %s%n", label, value);
    }

    // =========================================================
    // Classe de domínio com Comparable
    // =========================================================
    static class Person implements Comparable<Person> {
        final String name;
        final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Ordem natural: por nome
        @Override
        public int compareTo(Person other) {
            return this.name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }

    // =========================================================
    // Comparator externo clássico
    // =========================================================
    static class PersonAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return Integer.compare(p1.age, p2.age);
        }
    }
}