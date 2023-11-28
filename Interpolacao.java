package Calculo;

import java.text.DecimalFormat;

public class Interpolacao {

	  public static String interpolacaoLagrange(double x, double[] valoresX, double[] valoresY) {
	        int n = valoresX.length;
	        StringBuilder polinomio = new StringBuilder();

	        for (int i = 0; i < n; i++) {
	            String termo = formatarTermo(valoresY[i]);

	            for (int j = 0; j < n; j++) {
	                if (j != i) {
	                    termo += " * (x - " + formatarTermo(valoresX[j]) + ") / (" +
	                             formatarTermo(valoresX[i] - valoresX[j]) + ")";
	                }
	            }

	            polinomio.append(termo);
	            if (i < n - 1) {
	                polinomio.append(" + ");
	            }
	        }

	        return polinomio.toString();
	    }

	    private static String formatarTermo(double valor) {
	        DecimalFormat df = new DecimalFormat("+#,##0.###;-#");
	        return df.format(valor);
	    }
	    public static void main(String[] args) {
	 
	        double[] valoresX = {-2, 0, 2, 3, 5};
	        double[] valoresY = {5, -2, 3, 6, 4};

	  
	        int grau = valoresX.length - 1;

	  
	        String polinomio = interpolacaoLagrange(grau, valoresX, valoresY);

	        System.out.println("O polinomio interpolador e: P(x) = " + polinomio);
	    }
}