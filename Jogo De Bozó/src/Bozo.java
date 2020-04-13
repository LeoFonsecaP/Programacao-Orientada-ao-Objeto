//Classe que contém o jogo do Bozó na main
//Utiliza as classes placar, rola dados, random e dado feitas por Leonardo Fonseca Pinheiro
//Utiliza a classe Entrada Teclado feita por Marcio Delamaro
//Feito por: Leonardo Fonseca Pinheiro
public class Bozo {

	public static void main(String[] args)  throws java.io.IOException {
		RolaDados dados = new RolaDados(5);
		Placar placar = new Placar();
		int resultados[] = new int[5];
		int rodadas = 10;
		int posicao;
		String lednv;//Usada para registrar os dados que devem ser lançados novamente
		int aux; //Usada pra controlar o loop do lançamento dos dados
		System.out.println("********JOGO DE BOZO********\n");
		System.out.println(placar);
		for(int i = 1; i<=rodadas; i++) {
			System.out.println("****RODADA " + i + "****\n");
			System.out.println("Pressione qualquer tecla pra lançar os dados");
			EntradaTeclado.leString();
			resultados = dados.rolar();
			aux = 1;
			while(aux <3) {
				System.out.println(dados);
				System.out.println("Digite os dados que deseja lançar novamente, separados por espaço. Se não quiser trocar nenhum, digite enter");
				lednv = EntradaTeclado.leString();
				if(lednv.equals("") == false) {
					resultados = dados.rolar(lednv);
					aux++;
				}
				else {
					break;
				}
			}
			if(aux == 3) {//Quando o usuário troca os dados todas as vezez, o looping não imprime os dados do 
				System.out.println(dados);
			}
			System.out.println(placar);
			System.out.println("Escolha a posicao que quer ocupar com essa jogada:\n");
			while(true) {
				try {
					posicao = EntradaTeclado.leInt();
					placar.add(posicao, resultados);
					break;
				}
				catch(Exception e) {
					System.out.println("A posicao selecionada ja esta ocupada ou e invalida.");
					System.out.println("Digite outra posicao\n");
				}
			}
			System.out.println(placar);
		}
		System.out.println("***PLACAR FINAL: " + placar.getScore() + "***\n");
	}

}
