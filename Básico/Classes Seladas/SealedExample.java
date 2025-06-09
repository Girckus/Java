// Classe selada que define quais classes podem estendê-la
sealed class Forma permits Circulo, Retangulo, Poligono {
    abstract double calcularArea();
}

// Subclasse final: impede novas heranças
final class Circulo extends Forma {
    private final double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    double calcularArea() {
        return Math.PI * raio * raio;
    }
}

// Subclasse final: impede novas heranças
final class Retangulo extends Forma {
    private final double largura;
    private final double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    double calcularArea() {
        return largura * altura;
    }
}

// Subclasse que permite novas heranças
non-sealed class Poligono extends Forma {
    protected int numeroLados;

    public Poligono(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    @Override
    double calcularArea() {
        // Apenas um exemplo, pois polígonos podem ter fórmulas variadas
        return 0;
    }
}

// Classe que herda de Poligono sem restrição
class Triangulo extends Poligono {
    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        super(3); // Triângulo tem 3 lados
        this.base = base;
        this.altura = altura;
    }

    @Override
    double calcularArea() {
        return (base * altura) / 2;
    }
}

public class SealedExample {
    public static void main(String[] args) {
        Forma c = new Circulo(5);
        Forma r = new Retangulo(4, 6);
        Forma t = new Triangulo(3, 5);

        System.out.println("Área do Círculo: " + c.calcularArea());
        System.out.println("Área do Retângulo: " + r.calcularArea());
        System.out.println("Área do Triângulo: " + t.calcularArea());
    }
}
