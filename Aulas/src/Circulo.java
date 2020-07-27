
public class Circulo extends FiguraGeometrica {
	private float raio;
	
	public Circulo(String c, boolean f, float r) {
		super(c, f);
		raio = r;
	}

	public float getRaio() {
		return raio;
	}

	public void setRaio(float raio) {
		this.raio = raio;
	}
	
	public float getArea() {
		return (float) 3.14 * raio * raio;
	}
	
	public float getPerimetro() {
		return (float) (2.0 * 3.14 * raio);
	}
}
