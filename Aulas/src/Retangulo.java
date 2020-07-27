
public class Retangulo extends FiguraGeometrica {
	private float lado1;
	private float lado2;
	
	public Retangulo(String c, boolean f, float l1, float l2) {
		super(c, f);
		setLado1(l1);
		setLado2(l2);
	}

	public float getLado1() {
		return lado1;
	}

	public void setLado1(float lado1) {
		this.lado1 = lado1;
	}

	public float getLado2() {
		return lado2;
	}

	public void setLado2(float lado2) {
		this.lado2 = lado2;
	}
	
	public float getArea() {
		return (float) lado1 * lado2;
	}
	
	public float getPerimetro() {
		return (float) (2 * lado1) + (2 * lado2);
	}
	
}
