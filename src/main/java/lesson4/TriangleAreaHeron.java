package lesson4;

public class TriangleAreaHeron {
    private static ArithmeticException arithmeticException = new ArithmeticException("Некорректная длина стороны треугольника");

    public static double calcTriangleArea(int a, int b, int c) throws ArithmeticException, NullPointerException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw arithmeticException;
        }
        double halfPerimeter = (double) (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}
