import java.io.IOException;

public class Ex5 {

	public static void main(String[] args) throws IOException {
		int n;
		System.out.printf("Digite o valor de n: ");
		n = EntradaTeclado.leInt();
		int a = 0;
		do {
		a = 0;
		int aux = (int) Math.sqrt(n - 1);
		for(int i = 2; i<= aux; i++) {
			if(n % i == 0) {
				a = 1;
				break;
			}
		}
		if(a == 0) {
			System.out.printf("O número %d e o primeiro primo\n", n);
			}
		}while(a == 1);
	}
}

