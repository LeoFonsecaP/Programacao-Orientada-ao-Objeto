import java.io.IOException;

public class Jogo_da_senha {

	public static void main(String[] args) throws IOException {
		Random r = new Random(100);
		int max;
		System.out.printf("Digite o valor maximo: ");
		max = EntradaTeclado.leInt();
		int k;
		k = r.getintRand(max);
		int tentativas = 1;
		int chute;
		System.out.printf("Digite o seu palpite: ");
		chute = EntradaTeclado.leInt();
		while(chute != k) {
			System.out.printf("Incorreto!\n");
			System.out.printf("Digite o seu palpite: ");
			chute = EntradaTeclado.leInt();
			tentativas++;
		}
		System.out.printf("Acertou!\n");
		System.out.printf("Foram necessarias %d tentativas.", tentativas);
	}

}
