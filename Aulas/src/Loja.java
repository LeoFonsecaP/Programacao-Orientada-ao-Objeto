import java.io.IOException;

//Tem como funcao administrar os produtos da loja
//Feito por: Leonardo Fonseca Pinheiro
public class Loja {
	Produtos p[] = new Produtos[100];
	private int cadastrados = 0;
	private int quantidade_cd = 0;
	private int quantidade_dvd = 0;
	private int quantidade_livros = 0;
	
	//Armazena um produto na loja
	private void ArmazenaProduto(Produtos P) {
		if(cadastrados == 100) {//verifica se a loja esta lotada
			System.out.printf("A loja esta lotada\n");
			return;
		}
		p[cadastrados++] = P;
		if(P instanceof CD) {
			quantidade_cd ++;
		}
		else if(P instanceof DVD) {
			quantidade_dvd ++;
		}
		else {
			quantidade_livros ++;
		}
	}
	//Recebe um nome ou um codigo de barras de um produto e o remove, se estiver na loja
		private boolean removeProduto(String t) {
			int i = buscaProduto(t);
			if(i != -1) {
				if(p[i] instanceof CD) {
					CD aux = (CD) p[i];
					if(aux.getQuantidade() == 1) {
						for(int j = i; j<cadastrados-1; j++) {
							p[j] = p[j+1];
						}
						cadastrados--;
						quantidade_cd --;
					}
					else {
						aux.remove_um();
					}
				}
				else if(p[i] instanceof DVD) {
					DVD aux1 = (DVD) p[i];
					if(aux1.getQuantidade() == 1) {
						for(int j = i; j<cadastrados-1; j++) {
							p[j] = p[j+1];
						}
						cadastrados--;
						quantidade_dvd --;
					}
					else {
						aux1.remove_um();
					}
				}
				else {
					Livro aux2 = (Livro) p[i];
					if(aux2.getQuantidade() == 1) {
						for(int j = i; j<cadastrados-1; j++) {
							p[j] = p[j+1];
						}
						cadastrados--;
						quantidade_livros --;
					}
					else {
						aux2.remove_um();
					}
				}
				return true;
			}
			return false;
		}
	//Recebe um nome ou um codigo de barras de um produto e faz a busca na loja. A posição é retornada, se encontrada, caso contrario, retorna -1
		private int buscaProduto(String texto) {
			int i;
			for(i = 0; i<cadastrados; i++) {
				p[i].compara_nome(texto); 
			}
			return -1;
		}
		public void contabiliza_estoque() {
			System.out.printf("Quantida de DVDs: %d\n", quantidade_dvd);
			System.out.printf("Quantida de CDs: %d\n", quantidade_cd);
			System.out.printf("Quantida de Livros: %d\n", quantidade_livros);
		}
		public int getQuantidade_cd() {
			return quantidade_cd;
		}
	
		public int getQuantidade_dvd() {
			return quantidade_dvd;
		}
	
		public int getQuantidade_livros() {
			return quantidade_livros;
		}	

	public static void main(String[] args) throws IOException {
		int sel = -1;
		Loja l = new Loja();
		do {
			System.out.printf("**************MENU**************\n");
			System.out.printf("Digite 1 para adicionar um CD\n");
			System.out.printf("Digite 2 para adicionar um DVD\n");
			System.out.printf("Digite 3 para adicionar um Livro\n");
			System.out.printf("Digite 4 para vender um produto\n");
			System.out.printf("Digite 5 para buscar um produto\n");
			System.out.printf("Digite 6 para verificar o estoque\n");
			System.out.printf("Digite 0 para sair\n");
			sel = EntradaTeclado.leInt();
			switch(sel) {
			case 1:
				String nome;
				System.out.printf("Digite o nome do CD:");
				nome = EntradaTeclado.leString();
				String cb;
				System.out.printf("\nDigite o codigo de barras do CD:");
				cb = EntradaTeclado.leString();
				int qtd;
				System.out.printf("\nQuantos desse CD deseja adicionar?");
				qtd = EntradaTeclado.leInt();
				System.out.printf("\n");
				CD c = new CD(nome, cb, qtd);
				l.ArmazenaProduto(c);
				break;
			case 2:
				System.out.printf("Digite o nome do DVD:");
				nome = EntradaTeclado.leString();
				System.out.printf("\nDigite o codigo de barras do DVD:");
				cb = EntradaTeclado.leString();
				System.out.printf("\nQuantos desse DVD deseja adicionar?");
				qtd = EntradaTeclado.leInt();
				System.out.printf("\n");
				DVD d = new DVD(nome, cb, qtd);
				l.ArmazenaProduto(d);
				break;
			case 3:
				System.out.printf("Digite o nome do Livro:");
				nome = EntradaTeclado.leString();
				System.out.printf("\nDigite o codigo de barras do Livro:");
				cb = EntradaTeclado.leString();
				System.out.printf("\nQuantos desse Livro deseja adicionar?");
				qtd = EntradaTeclado.leInt();
				System.out.printf("\n");
				Livro li = new Livro(nome, cb, qtd);
				l.ArmazenaProduto(li);
				break;
			case 4:
				System.out.printf("Qual o codigo de barras do produto que voce quer comprar?");
				nome = EntradaTeclado.leString();
				System.out.printf("\n");
				if (l.removeProduto(nome) == true) {
					System.out.printf("Compra realizada com sucesso!!\n");
				}
				else {
					System.out.printf("Ops! O produto nao esta em estoque no momento.\n");
				}
				break;
			case 5:
				System.out.printf("Qual o codigo de barras do produto que voce quer buscar?");
				nome = EntradaTeclado.leString();
				System.out.printf("\n");
				if (l.buscaProduto(nome) > -1) {
					System.out.printf("O produto esta em estoque\n");
				}
				else {
					System.out.printf("O produto nao esta em estoque no momento.\n");
				}
				break;
			case 6:
				l.contabiliza_estoque();
				break;
			case 0:
				break;
			default:
				System.out.printf("Entrada invalida\n");
				break;
			}
		}while(sel != 0);
	}
}

