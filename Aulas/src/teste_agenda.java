import java.io.IOException;
//Programa para testar o funcionamento da agenda
//Leonardo Fonseca P
public class teste_agenda {

	public static void main(String[] args) throws IOException {
		Agenda a = new Agenda();
		int sel = -1;
		String n;
		int c;
		double b;
		do {
			System.out.printf("**************MENU**************\n");
			System.out.printf("Digite 1 para adicionar uma pessoa\n");
			System.out.printf("Digite 2 para remover uma pessoa\n");
			System.out.printf("Digite 3 para buscar uma pessoa\n");
			System.out.printf("Digite 4 para imprimir a agenda\n");
			System.out.printf("Digite 5 para imprimir uma pessoa\n");
			System.out.printf("Digite 0 para sair\n");
			sel = EntradaTeclado.leInt();
			switch(sel) {
			case 1:
				System.out.printf("Digite o nome: ");
				n = EntradaTeclado.leString();
				System.out.printf("Digite a idade: ");
				c = EntradaTeclado.leInt();
				System.out.printf("Digite a altura: ");
				b = EntradaTeclado.leDouble();
				a.ArmazenaPessoa(n, c, b);
				break;
			case 2:
				System.out.printf("Digite o nome da pessoa que deseja remover: ");
				n = EntradaTeclado.leString();
				a.removePessoa(n);
				break;
			case 3:
				System.out.printf("Digite o nome que deseja buscar: ");
				n = EntradaTeclado.leString();
				c = a.buscaPessoa(n);
				if(c == -1) {
					System.out.printf("%s nao esta na agenda\n", n);
				}
				else {
					System.out.printf("%s esta na posicao %d da agenda\n", n, c);
				}
				break;
			case 4:
				a.imprimeAgenda();
				break;
			case 5:
				System.out.printf("Digite a posicao que deseja imprimir: ");
				c = EntradaTeclado.leInt();
				a.imprimePessoa(c);
				break;
			}
			System.out.printf("\n");
		}while(sel != 0);
		return;
	}

}
