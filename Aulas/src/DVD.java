//Tem como funcao controlar um DVD
//Feito por: Leonardo Fonseca Pinheiro
public class DVD extends Produtos {
	private int quantidade;
	public DVD(String n, String cb, int q) {
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
