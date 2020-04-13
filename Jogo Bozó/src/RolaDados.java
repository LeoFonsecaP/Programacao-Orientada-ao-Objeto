//Essa é uma classe auxiliar, que tem como objetivo rolar mais de um dado de uma vez
//Todos os métodos estão relacionados a isso
//Feito por: Leonardo Fonseca Pinheiro

public class RolaDados {
	private int qtd; //Quantidade de dados totais
	private Dado dados[];//Vetor dos dados
	//Montador do rola dados
	public RolaDados(int n) {
		qtd = n;
		dados = new Dado[n];
		for(int i = 0; i<qtd; i++) {
			dados[i] = new Dado();
			while(true) {
				try {
					Thread.sleep(100);//Para deixar os valores gerados aleatórios
					break;
				}
				catch(Exception e) {
					System.out.println("e");
				}
			}
		}
	}
	//Rola todos os dados
	public int[] rolar() {
		int valores[] = new int[qtd];
		for(int i = 0; i<qtd; i++) {
			valores[i] = dados[i].rolar();
		}
		return valores;
	}
	//Rola os dados selecionados através de true e false
	public int[] rolar(boolean[] quais) {
		int valores[] = new int[qtd];
		for(int i = 0; i<qtd; i++) {
			if(quais[i] == true) {
				valores[i] = dados[i].rolar();
			}
			else {
				valores[i] = dados[i].getLado();
			}
		}
		return valores;
	}
	//Rola os dados selecionados na string espaçada
	public int[] rolar(java.lang.String s) {
		int valores[] = new int[qtd];
		int aux = s.length();//Pega o tamanho da string para o for
		char c;
		int a;
		//Pula os espaços
		for(int i = 0; i < aux; i+=2) {
			c = s.charAt(i);//Pega o char na posição i
			a = Character.getNumericValue(c);//Pega o valor inteiro do char
			a--;//Para ajusta ao vetor
			dados[a].rolar();
		}
		//Depois de rodar os dados especificos no for anterior, esse for pega o valor atual de todos os dados
		for(int i = 0; i<qtd; i++) {
			valores[i] = dados[i].getLado();
		}
		return valores;
	}
	//Desenha os 5 dados
	@Override
		public String toString() {
			String impressao;
			impressao = " 1          2          3          4          5\n+-----+    +-----+    +-----+    +-----+    +-----+\n";
			//Imprime a parte de cima dos 5 dados
			for(int i = 0; i<qtd; i++) {
				switch(dados[i].getLado()) {
				case 1:
					impressao += "|     |    ";
					break;
				case 2:
					impressao += "|*    |    ";
					break;
				case 3:
					impressao += "|*    |    ";
					break;
				case 4:
					impressao += "|*   *|    ";
					break;
				case 5:
					impressao += "|*   *|    ";
					break;
				case 6:
					impressao += "|*   *|    ";
					break;
				}
			}
			impressao += "\n";
			//Imprime o meio de todos os dados
			for(int i = 0; i<qtd; i++) {
				switch(dados[i].getLado()) {
				case 1:
					impressao += "|  *  |    ";
					break;
				case 2:
					impressao += "|     |    ";
					break;
				case 3:
					impressao += "|  *  |    ";
					break;
				case 4:
					impressao += "|     |    ";
					break;
				case 5:
					impressao += "|  *  |    ";
					break;
				case 6:
					impressao += "|*   *|    ";
					break;
				}
			}
			impressao +="\n";
			//Imprime a parte de baixo de todos os dados
			for(int i = 0; i<qtd; i++) {
				switch(dados[i].getLado()) {
				case 1:
					impressao += "|     |    ";
					break;
				case 2:
					impressao += "|    *|    ";
					break;
				case 3:
					impressao += "|    *|    ";
					break;
				case 4:
					impressao += "|*   *|    ";
					break;
				case 5:
					impressao += "|*   *|    ";
					break;
				case 6:
					impressao += "|*   *|    ";
					break;
				}
			}
			impressao += "\n";
			impressao += "+-----+    +-----+    +-----+    +-----+    +-----+\n";
			return impressao;
	}
}
