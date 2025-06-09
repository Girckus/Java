public class RecordPatternExample {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(4, 6);

        printShapeInfo(shape1);
        printShapeInfo(shape2);
    }

    static void printShapeInfo(Shape shape) {
        if (shape instanceof Circle(double radius)) {
            System.out.println("É um círculo com raio: " + radius);
        } else if (shape instanceof Rectangle(var width, var height)) {
            System.out.println("É um retângulo com largura: " + width + " e altura: " + height);
        } else {
            System.out.println("Forma desconhecida");
        }
    }

    sealed interface Shape permits Circle, Rectangle {}

    record Circle(double radius) implements Shape {}

    record Rectangle(double width, double height) implements Shape {}
}