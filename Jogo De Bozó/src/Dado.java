//Classe que representa um dado
//Tem os métodos rolar, getLado e toString
//Por: Leonardo Fonseca Pinheiro
public class Dado {
	private int lados;
	private int atual;//Face do dado atual
	private Random r1 = new Random();
	//Montador com l lados
	public Dado(int l){
		lados = l;
	}
	//Montador padrão, 6 lados
	public Dado() {
		lados = 6;//Dado padrão
	}
	//Simula o lançamento de um dado, retornando um número entre 1 e o número total de faces
	public int rolar(){
		atual = r1.getintRand(lados) + 1; //Soma um para tirar o 0. Poderia ter usado um getintRand com min e max
		return atual;
	}
	//Retorna o lado atual do dado
	public int getLado() {
		return atual;
	}
	//Muda a representação do dado
	@Override
		public String toString() {
			switch(atual) {
			case 1:
				return("+-----+\n|     |\n|  *  |\n|     |\n+-----+\n");
			case 2:
				return("+-----+\n|*    |\n|     |\n|    *|\n+-----+\n");
			case 3:
				return("+-----+\n|*    |\n|  *  |\n|    *|\n+-----+\n");
			case 4:
				return("+-----+\n|*   *|\n|     |\n|*   *|\n");
			case 5:
				return("+-----+\n|*   *|\n|  *  |\n|*   *|\n");
			case 6:
				return("+-----+\n|*   *|\n|*   *|\n|*   *|\n");
			}
			return null;
	}
}
	

