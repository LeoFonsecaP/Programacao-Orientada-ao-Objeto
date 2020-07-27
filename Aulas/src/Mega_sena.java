import java.io.IOException;

public class Mega_sena {
	public static void main(String[] args) throws IOException {
		System.out.printf("Entre o valor da semente:\n");
		int seed = EntradaTeclado.leInt();
		Random r = new Random(seed);
		int k;
		for(int i = 0; i<6; i++) {
			k = r.getintRand(60) + 1;
			System.out.printf("%d ", k);
		}
		System.out.printf("\n");

	}

}
