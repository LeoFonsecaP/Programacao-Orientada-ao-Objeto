//Classe que tem como responsabilidade cuidar do placar do jogo
//Seus métodos adicionam valores ao placar e contam o total atual
//Feito por: Leonardo Fonseca Pinheiro

public class Placar {
	int pontuacao[] = new int[10];
	int aux;
	public Placar() {
		for(int i = 0; i<10; i++){
			pontuacao[i] = -1;//Definir os espaços válidos
		}
	}
	
	public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException{
		if(pontuacao[posicao-1] != -1 || posicao < 1 || posicao > 10) { //Verifica se a posição ja esta ocupada ou é invalida
			throw new IllegalArgumentException("A posicao selecionada ja esta ocupada o e invalida.");
		}
		//Se for em uma das posições numericas
		if(posicao <= 6) {
			pontuacao[posicao-1] = 0;
			for(int i = 0; i<5; i++) {
				if(dados[i] == posicao) {
					pontuacao[posicao-1] += posicao;
				}
			}
		}
		//Se for um caso especial
		switch(posicao) {
		case 7://Full Hand
			aux = 0;
			//Verifica quantos dados sao iguais ao primeiro dado
			for(int i = 1; i<5; i++) {
				if(dados[i] == dados[0]) {
					aux++;
				}
			}
			//Se o primeiro dado participa de uma trinca ou dupla é possivel ter um full hand
			if(aux == 2 || aux == 1) {
				for(int i = 1; i<5; i++) {
					if(dados[i] != dados[0]) {//Acha o primeiro dado diferente do primeiro
						for(int j = i; i<5; i++) {
							if(dados[j] == dados[i]) {
								aux++;//Soma quantos dados são iguais a ele. Somará 1 em caso de dupla e 2 em caso de trinca
							}
						}
						if(aux == 3) {//Se, depois de verificarmos que o primeiro dado faz uma dupla ou trinca, o segundo dado tambem fizer, temos um full hand
							pontuacao[6] = 15;
						}
						break;
					}
				}
			}
			if(aux != 3) {
				pontuacao[6] = 15;
			}
			break;
		case 8://Sequencia
			int um = 0;//Para ser uma sequencia, não pode ter, ao mesmo tempo, o 1 e o 6
			int seis = 0;
			int ig = 0;//Para ser uma sequencia, deve ter 5 números diferentes
			for(int i = 0; i < 5; i++) {
				if(dados[i] == 1) {
					um = 1;
				}
				if(dados[i] == 6){
					seis = 1;
				}
				if(um == 1 && seis == 1) {
					break;
				}
				for(int j = i+1; j < 5; j++) {
					if(dados[i] == dados[j]) {
						ig = 1;
						break;
					}
				}
			}
			if(ig != 1) {
				if(um != 1 || seis != 1) {
					pontuacao[7] = 20;
				}
				else {
					pontuacao[7] = 0;
				}
			}
			else {
				pontuacao[7] = 0;
			}
			break;
		case 9://Quadra
			int contigual = 0; //So pode ter um número diferente para ser uma quadra
			for(int i = 1; i<5; i++) {//Compara todos os dados com o primeiro dado
				if(dados[0] == dados[1]) {
						contigual++;
					}
				}
				if(contigual >= 3) {//Se o primeiro dado for parte de uma quadra ou quina, a quadra é computada
					pontuacao[8] = 30;
					break;
				}
				else if(contigual == 0) {//Se o primeiro dado não forma uma quadra, ele tem que ser diferente de todos
					for(int i = 2; i<5; i++) {//E, nesse caso, os proximos quatro devem formar a quadra
						if(dados[1] == dados[1]) {
								contigual++;
						}
					}
					if(contigual >= 3) {
						pontuacao[8] = 30;
						break;
					}
					else {
						pontuacao[8] = 0;
					}
				}
				else {
					pontuacao[8] = 0;
				}
				break;
		case 10://Quina
			int dif = 0;//Na quina, todos os dados devem ser iguais
			for(int i = 1; i<5; i++) {
				if(dados[i] != dados[0]) {
					dif = 1;
					break;
				}
			}
			if(dif == 0) {
				pontuacao[9] = 40;
			}
			else {
				pontuacao[9] = 0;
			}
			break;
		}
	}
	//Calcula a pontuação total
	public int getScore() {
		int pontos = 0;
		for(int i = 0; i<10; i++) {
			if(pontuacao[i] != -1) {
				pontos += pontuacao[i];
			}
		}
		return pontos;
	}
	//Desenha o placar
	@Override
		public String toString() {
		//Verifica se a pontuação ja foi computada, se sim, coloca a pontuação, se não, deixa-a livre
			String p = "";
			if(pontuacao[0] == -1) {
				p += "(1)";
			}
			else {
				p += pontuacao[0];
				p += "  ";//Para ajustar o alinhamento quando o número só tem um digito
			}
			
			p += "    |   ";
			
			if(pontuacao[6] == -1) {
				p += "(7)";
			}
			else {
				p += pontuacao[6];
			}
			
			p += "    |   ";
			
			if(pontuacao[3] == -1) {
				p += "(4)";
			}
			else {
				p += pontuacao[3];
				if(pontuacao[3] < 10) {
					p += "  ";
				}
			}
			
			p += "\n--------------------------\n";
			
			if(pontuacao[1] == -1) {
				p += "(2)";
			}
			else {
				p += pontuacao[1];
				if(pontuacao[1] < 10) {
					p += "  ";
				}
			}
			
			p += "    |   ";
			
			if(pontuacao[7] == -1) {
				p += "(8)";
			}
			else {
				p += pontuacao[7];
			}
			
			p += "    |   ";
			
			if(pontuacao[4] == -1) {
				p += "(5)";
			}
			else {
				p += pontuacao[4];
				if(pontuacao[4] < 10) {
					p += "  ";
				}
			}
			
			p += "\n--------------------------\n";
			
			if(pontuacao[2] == -1) {
				p += "(3)";
			}
			else {
				p += pontuacao[2];
				if(pontuacao[2] < 10) {
					p += "  ";
				}
			}
			
			p += "    |   ";
			
			if(pontuacao[8] == -1) {
				p += "(9)";
			}
			else {
				p += pontuacao[8];
			}
			
			p += "    |   ";
			
			if(pontuacao[5] == -1) {
				p += "(6)";
			}
			else {
				p += pontuacao[5];
				if(pontuacao[5] < 10) {
					p += "  ";
				}
			}
			
			p += "\n--------------------------\n       |   ";
			
			if(pontuacao[9] == -1) {
				p += "(10)";
			}
			else {
				p += pontuacao[9];
			}
			
			p+="   |\n       +----------+ \n";
			return p;
	}
}
