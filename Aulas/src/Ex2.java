import java.io.IOException;

public class Ex2 {

	public static void main(String[] args) throws IOException {
		int n;
		System.out.printf("Digite o valor de n: ");
		 n = EntradaTeclado.leInt();
		for(int j = n; j>0; j--) {
			for(int h = 0; h < j; h++) {
				System.out.printf("* ");
			}
			System.out.printf("\n");
		}
	}
}
