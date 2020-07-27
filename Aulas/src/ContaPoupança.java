
public class ContaPoupan�a extends ContaBancaria{
	private int dia;
	public ContaPoupan�a(String nome, long num, double s, int d) {
		super(nome, num, s);
		setDia(d);
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	void atualiza(double taxa) {
		double saldo = getSaldo();
		saldo *= (1 + taxa);
		setSaldo(saldo);
	}
	
}
