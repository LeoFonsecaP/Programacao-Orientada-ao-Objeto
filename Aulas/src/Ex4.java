import java.io.IOException;

public class Ex4 {

	public static void main(String[] args) throws IOException {
		int n;
		System.out.printf("Digite o valor de n: ");
		n = EntradaTeclado.leInt();
		int aux = (int) Math.sqrt(n);
		int a = 0;
		for(int i = 2; i<= aux; i++) {
			if(n % i == 0) {
				System.out.printf("O número %d e divisivel por %d\n", n, i);
				a = 1;
				break;
			}
		}
		if(a == 0) {
			System.out.printf("O número %d e primo\n", n);
		}
	}

}
