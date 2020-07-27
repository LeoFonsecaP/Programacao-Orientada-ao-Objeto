//Tem como funcao administrar produto
//Tem nome e codigo de barras
//Feita por: Leonardo Fonseca Pinheiro
public class Produtos {
	private String nome;
	private String codigo_de_barras;
	
	public Produtos(String n, String cb) {
		nome = n;
		codigo_de_barras = cb;
	}
	public String getNome() {
		return nome;
	}
	public String getCodigoDeBarras() {
		return codigo_de_barras;
	}
	//Utilizada para procurar um produto
	boolean compara_nome(String n) {
		if(n.equalsIgnoreCase(nome)) {
			return true;
		}
		else {
			return false;
		}
	}
	void imprimir_pessoa(Produtos aux) {
		System.out.printf("Nome: %s\n", nome);
		System.out.printf("Codigo de barras: %s\n", codigo_de_barras);
	}
}
