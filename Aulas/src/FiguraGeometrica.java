//Tem como funcao representar uma figura geometrica qualquer
//Pode estar preenchida ou nao por uma cor qualquer
//Feita por: Leonardo Fonseca Pinheiro

public class FiguraGeometrica {
	private String cor;
	private boolean filled;
	
	public FiguraGeometrica(String c, boolean f) {
		cor = c;
		filled = f;
	}
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	
}
