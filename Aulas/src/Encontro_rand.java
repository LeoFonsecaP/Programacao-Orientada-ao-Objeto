import java.io.IOException;

public class Encontro_rand {

	public static void main(String[] args) throws IOException {
		System.out.printf("Entre o valor da semente:\n");
		int seed = EntradaTeclado.leInt();
		Random r1 = new Random(seed);
		System.out.printf("Entre um valor diferente para outra semente:\n");
		seed = EntradaTeclado.leInt();
		Random r2 = new Random(seed);
		int k1;
		int k2;
		int n = 0;
		do {
			k1 = r1.getintRand(500);
			k2 = r2.getintRand(500);
			n++;
		}while(k1 != k2);
		System.out.printf("Os dois chegaram ao número %d apos %d repeticoes\n", k1, n);
	}

}
