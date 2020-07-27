//Programa para treinar o uso de vetores e strings em java
//Adaptado em 12/05 para uso mais avancado, usando Pessoa fisica e juridica
//Feita por: Leonardo Fonseca Pinheiro
public class Pessoa {
	private String nome;
	private String endereco;
	private String email;
	
	public Pessoa(String n, String end, String em) {
		nome = n;
		endereco = end;
		email = em;
	}
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getEmail() {
		return email;
	}
	//Utilizada para procurar uma pessoa
	boolean compara_nome(String n) {
		if(n.equalsIgnoreCase(nome)) {
			return true;
		}
		else {
			return false;
		}
	}
	void imprimir_pessoa(Pessoa aux) {
		System.out.printf("Nome: %s\n", nome);
		System.out.printf("Endereco: %s\n", endereco);
		System.out.printf("Email: %s\n", email);
	}
}
