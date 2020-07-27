import java.io.IOException;

//Programa para treinar o uso de vetores e strings em java
//Utiliza a classe "Pessoa"
//Adaptado em 12/05 para uso mais avancado, usando Pessoa fisica e juridica
//Feita por: Leonardo Fonseca Pinheiro

public class Agenda {

		private Pessoa ag[] = new Pessoa[100];
		private int cadastrados = 0;
		
		private int tipo(Pessoa P) {
			if(P instanceof PessoaFisica) {
				return 1;
			}
			return 0;
		}
		//Armazena uma pessoa na agenda
		private void ArmazenaPessoa(Pessoa P) {
			if(cadastrados == 100) {//verifica se a agenda esta lotada
				System.out.printf("A agenda esta cheia\n");
				return;
			}
			ag[cadastrados++] = P;
		}
		//Recebe on nome, CPF ou CNPJ de uma pessoa e a remove, se estiver na agenda
		private boolean removePessoa(String t) {
			int i = buscaPessoa(t);
			if(i != -1) {
				for(int j = i; j<cadastrados-1; j++) {
					ag[j] = ag[j+1];
				}
				cadastrados--;
				return true;
			}
			return false;
		}
		//Recebe o nome, CPF ou CNPJ de uma pessoa e faz a busca na agenda. A posição é retornada, se encontrada, caso contrario, retorna -1
		private int buscaPessoa(String texto) {
			int i;
			for(i = 0; i<cadastrados; i++) {
				if(ag[i] instanceof PessoaFisica) {
					PessoaFisica PF = (PessoaFisica)ag[i];
					if(PF.compara_c(texto) == true || PF.compara_nome(texto)) {
						return i;
					}
				}
				else {
					PessoaJuridica PJ = (PessoaJuridica)ag[i];
					if(PJ.compara_c(texto) == true || PJ.compara_nome(texto)) {
						return i;
					}
				}			
			}
			return -1;
		}
		//Imprime a agenda completa
		private void imprimeAgenda() {
			for(int i = 0; i<cadastrados; i++) {
					ag[i].imprimir_pessoa(ag[i]);
					System.out.printf("\n");
			}
		}
		//Ordena a agente
		private void ordenar_agenda() {
			Pessoa P;
			for(int i = 0; i<cadastrados; i++) {
				for(int j = i+1; j<cadastrados; j++) {
					if(tipo(ag[j]) > tipo(ag[i])) {//Coloca as pessoas fisicas na frente
						P = ag[i];
						ag[i] = ag[j];
						ag[j] = P;
					}
					else {
						if((tipo(ag[j]) < tipo(ag[i]))){
						}
						else if(tipo(ag[i]) == 1) {//Ordena as pessoas de mesmo tipo
							PessoaFisica pfi = (PessoaFisica) ag[i];
							PessoaFisica pfj = (PessoaFisica) ag[j];
							if(pfj.getCPF().compareTo(pfi.getCPF()) < 0) {
								P = ag[i];
								ag[i] = ag[j];
								ag[j] = P;
							}
						}
						else {
							PessoaJuridica pji = (PessoaJuridica) ag[i];
							PessoaJuridica pjj = (PessoaJuridica) ag[j];
							if(pjj.getCNPJ().compareTo(pji.getCNPJ()) < 0) {
								P = ag[i];
								ag[i] = ag[j];
								ag[j] = P;
							}
						}
					}
				}
			}
		}
		public static void main(String[] args) throws IOException {
			int sel = -1;
			Agenda a = new Agenda();
			do {
				System.out.printf("**************MENU**************\n");
				System.out.printf("Digite 1 para adicionar uma pessoa física\n");
				System.out.printf("Digite 2 para adicionar uma pessoa juridica\n");
				System.out.printf("Digite 3 para remover uma pessoa\n");
				System.out.printf("Digite 4 para buscar uma pessoa\n");
				System.out.printf("Digite 5 para imprimir a agenda\n");
				System.out.printf("Digite 6 para ordenar a agenda\n");
				System.out.printf("Digite 0 para sair\n");
				sel = EntradaTeclado.leInt();
				switch(sel) {
				case 1:
					String nome;
					System.out.printf("Digite o nome da pessoa:");
					nome = EntradaTeclado.leString();
					String end;
					System.out.printf("\nDigite o endereco da pessoa:");
					end = EntradaTeclado.leString();
					String email;
					System.out.printf("\nDigite o email da pessoa:");
					email = EntradaTeclado.leString();
					String CPF;
					System.out.printf("\nDigite o CPF da pessoa:");
					CPF = EntradaTeclado.leString();
					String data;
					System.out.printf("\nDigite a data de nascimento da pessoa:");
					data = EntradaTeclado.leString();
					String ec;
					System.out.printf("\nDigite o estado civil da pessoa:");
					ec = EntradaTeclado.leString();
					System.out.printf("\n");
					PessoaFisica PF = new PessoaFisica(nome, end, email, CPF, data,ec);
					a.ArmazenaPessoa(PF);
					break;
				case 2:
					System.out.printf("Digite o nome da pessoa:");
					nome = EntradaTeclado.leString();
					System.out.printf("\nDigite o endereco da pessoa:");
					end = EntradaTeclado.leString();
					System.out.printf("\nDigite o email da pessoa:");
					email = EntradaTeclado.leString();
					String CNPJ;
					System.out.printf("\nDigite o CNPJ da pessoa:");
					CNPJ = EntradaTeclado.leString();
					String ie;
					System.out.printf("\nDigite a inscricao estadual da pessoa:");
					ie = EntradaTeclado.leString();
					String rs;
					System.out.printf("\nDigite a razao social da pessoa:");
					rs = EntradaTeclado.leString();
					System.out.printf("\n");
					PessoaJuridica PJ = new PessoaJuridica(nome, end, email, CNPJ, ie,rs);
					a.ArmazenaPessoa(PJ);
					break;
				case 3:
					String remove;
					System.out.printf("Digite o nome, CPF ou CNPJ que deseja remover\n");
					remove = EntradaTeclado.leString();
					if(a.removePessoa(remove) == true) {
						System.out.printf("Pessoa Removida com sucesso\n");
					}
					else {
						System.out.printf("Houve um erro na remocao\n");
					}
					break;
				case 4:
					String busca;
					System.out.printf("Digite o nome, CPF ou CNPJ que deseja buscar\n");
					busca = EntradaTeclado.leString();
					if(a.buscaPessoa(busca) > -1) {
						System.out.printf("A pessoa esta na agenda\n");
					}
					else {
						System.out.printf("A pessoa nao esta na agenda\n");
					}
					break;
				case 5:
					a.imprimeAgenda();
					break;
				case 6:
					a.ordenar_agenda();
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
