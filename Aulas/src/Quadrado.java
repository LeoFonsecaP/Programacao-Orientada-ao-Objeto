
public class Quadrado extends FiguraGeometrica {
	private float lado;
	
	
	public Quadrado(String c, boolean f, float l) {
		super(c, f);
		lado = l;
	}


	public float getLado() {
		return lado;
	}


	public void setLado(float lado) {
		this.lado = lado;
	}
	
	public float getArea() {
		return (float) lado * lado;
	}
	
	public float getPerimetro() {
		return (float) 4 * lado;
	}
}
