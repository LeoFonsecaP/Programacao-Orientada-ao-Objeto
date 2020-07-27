import java.io.IOException;

public class Ex1 {

	public static void main(String[] args) throws IOException {
		double x;
		double xi;
		double erro = 0.00000001;
		double aux;
		System.out.printf("Digite o valor de x: ");
		x = EntradaTeclado.leDouble();
		System.out.printf("\nChute o valor da raiz de x: ");
		xi = EntradaTeclado.leDouble();
		do {
			aux = xi;
			xi = (aux + (x/aux))/2;
		} while(xi - aux >= erro);
		System.out.printf("\nA raiz de x: %f", xi);
	}
}
