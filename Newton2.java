package Calculo;


import java.lang.Math;

public class Newton2 {

    static double x0 = 0.5;
    static double prec = 0.001;
    static int maxIterations = 100; 

    public static double function(double x) {
        return -Math.cos(Math.pow(Math.PI, x));
    }

    public static double derivative(double x) {
        return Math.pow(Math.PI, x) * Math.log(Math.PI) * Math.sin(Math.pow(Math.PI, 2));
    }

    public static void main(String[] args) {
        double err = 0;
        double initial = x0;
        double next = 0;
        int iteration = 0;

        do {
            double y = function(initial);
            double y1 = derivative(initial);
            next = initial - (y / y1);
            err = Math.abs(next - initial);
            System.out.println("X: " + initial);
            System.out.println("Próximo X: " + next);
            System.out.println("Erro: " + err);
            initial = next;
            iteration++;

        } while (err > prec && iteration < maxIterations);

        double finalValue = function(next);
        if (Math.abs(finalValue) < prec) {
            System.out.println("Resultado final: " + next + " (Raiz encontrada)");
        } else {
            System.out.println("Resultado final: " + next + " (Sem raiz)");
        }

        if (iteration == maxIterations) {
            System.out.println("Limite de iterações alcançado. A solução pode não ter convergido.");
        }
    }
}

}
