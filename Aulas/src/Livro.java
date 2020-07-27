//Tem como funcao controlar um Livro
//Feito por: Leonardo Fonseca Pinheiro
public class Livro extends Produtos {
	private int quantidade;
	public Livro(String n, String cb, int q) {
		super(n, cb);
		quantidade = q;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void remove_um() {
		quantidade--;
	}
}
