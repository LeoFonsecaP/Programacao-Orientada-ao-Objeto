//Tem como funcao controlar um CD
//Feito por: Leonardo Fonseca Pinheiro
public class CD extends Produtos {
	private int quantidade;
	public CD(String n, String cb, int q) {
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
