package Calculo;

public class MinimosQuadrados2 {
	public static void main(String[] args) {
        double[] x = {-2, 0, 2, 3, 5};
        double[] y = {6, 3, 2, 1, -6};
        int N = x.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < N; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double m = (N * sumXY - sumX * sumY) / (N * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / N;

        System.out.println("Coeficiente a (m): " + m);
        System.out.println("Coeficiente b: " + b);

        double resultado = calcularAproximacao(1, m, b);
        System.out.println("Aproximacao de f(1): " + resultado);
    }

    private static double calcularAproximacao(double x, double m, double b) {
        return m * x + b;
    }
}
