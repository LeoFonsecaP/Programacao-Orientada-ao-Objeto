
public class ContaPoupança extends ContaBancaria{
	private int dia;
	public ContaPoupança(String nome, long num, double s, int d) {
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
